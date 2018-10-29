package com.example.hritik.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastlocation;
    private Location mlastlocation;
    private Marker currentlocation;
    private Marker user2loc;
    public SharedPreferences sharedpref;
    public SharedPreferences join;
    public String code;
    public DatabaseReference dbreference;
    private DatabaseReference dbreferenceofother;
    private String name;
    private String email;
    private String password;
    private String roottag;
    private String sec_user_lat = "18";
    private String sec_user_lon = "72";
    private LatLng sec_user_latlng;
    private String issharing;
    private String usercode = null;
    public boolean isuserpresent = false;
    public boolean issharingenabled = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        join = getSharedPreferences("codeshare", Context.MODE_PRIVATE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkpermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        dbreference = FirebaseDatabase.getInstance().getReference("Users");
        dbreferenceofother = FirebaseDatabase.getInstance().getReference();


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            setgoogleapiclient();
            mMap.setMyLocationEnabled(true);
            Log.i("onmapready", "onLocationChanged: location getting updated ");
        }
    }

    protected synchronized void setgoogleapiclient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        googleApiClient.connect();
        Log.i("setgooogleapiclient", "onLocationChanged: location getting updated ");
    }


    @Override
    public void onLocationChanged(Location location) {
        lastlocation = location;
        if (currentlocation != null) {
            currentlocation.remove();
        }

        LatLng latLng = new LatLng(lastlocation.getLatitude(), lastlocation.getLongitude());
        Log.i("locationupdated", "onLocationChanged: location getting updated ");

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        currentlocation = mMap.addMarker(markerOptions);
        accessdata();
        savedata(name, email, password, code, Double.toString(lastlocation.getLongitude()), Double.toString(lastlocation.getLatitude()));


        if (usercode != null && issharingenabled == true ) {
            userposition(usercode);

        }


       // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       // mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }




    }


    public boolean checkpermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 10);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 10);
            }
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (googleApiClient == null) {
                            setgoogleapiclient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(2000);
        locationRequest.setPriority(locationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        Log.i("onconnected", "onLocationChanged: location getting updated ");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }


    }

    @Override
    protected void onStart() {
        if(googleApiClient!=null)
            googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        if(googleApiClient!=null)
            googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void accessdata() {
        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        code = sharedpref.getString("code", "");
        name = sharedpref.getString("name", "");
        email = sharedpref.getString("email", "");
        password = sharedpref.getString("password", "");
        roottag = email.substring(0, email.indexOf("@"));
        issharing = sharedpref.getString("issharing", "");
        usercode = join.getString("code", "");
        issharingenabled = join.getBoolean("issharing",false);

        Log.i("issharing", "accessdata:" + usercode + "");


    }

    private void savedata(String name, String email, String password, String code, String lat, String lon) {

            CreateUser createUser = new CreateUser(name, email, password, code, "false", Double.toString(lastlocation.getLatitude()), Double.toString(lastlocation.getLongitude()));
            dbreference.child(code).setValue(createUser);
            Toast.makeText(this, "stored in database", Toast.LENGTH_SHORT).show();
        }



    public void userposition(String usercode) {
        DatabaseReference db = dbreferenceofother.child("Users");
        db.child(usercode).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sec_user_lat = dataSnapshot.child("lat").getValue(String.class);

                Log.i("locationmrbeast", "onDataChange:" + sec_user_lat + "is latitude");
                sec_user_lon = dataSnapshot.child("lng").getValue(String.class);

                Log.i("locationmrbeast", "onDataChange:" + sec_user_lon + "is longitude");
                //sec_user_latlng = new LatLng(Double.parseDouble(sec_user_lat),Double.parseDouble(sec_user_lon));
                if (sec_user_lat!=null && sec_user_lon!=null) {
                    LatLng user2 = new LatLng(Double.parseDouble(sec_user_lon), Double.parseDouble(sec_user_lat));
                    MarkerOptions user2marker = new MarkerOptions();
                    user2marker.position(user2);
                    user2marker.title("second user location");
                    user2marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                    user2loc = mMap.addMarker(user2marker);
                    Toast.makeText(getApplicationContext(), "running", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sorry no one found", Toast.LENGTH_LONG).show();
                }
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
