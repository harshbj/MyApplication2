/**
 * Customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.service;

public class Customer  implements java.io.Serializable {
    private java.lang.Integer customer_id;

    private java.lang.String customer_name;

    private java.lang.String dateOfBirth;

    private java.lang.String gender;

    private java.lang.Integer occupationCode;

    private java.lang.String panNumber;

    private long phoneNumber;

    private java.lang.String prefix;

    public Customer() {
    }

    public Customer(
           java.lang.Integer customer_id,
           java.lang.String customer_name,
           java.lang.String dateOfBirth,
           java.lang.String gender,
           java.lang.Integer occupationCode,
           java.lang.String panNumber,
           long phoneNumber,
           java.lang.String prefix) {
           this.customer_id = customer_id;
           this.customer_name = customer_name;
           this.dateOfBirth = dateOfBirth;
           this.gender = gender;
           this.occupationCode = occupationCode;
           this.panNumber = panNumber;
           this.phoneNumber = phoneNumber;
           this.prefix = prefix;
    }


    /**
     * Gets the customer_id value for this Customer.
     * 
     * @return customer_id
     */
    public java.lang.Integer getCustomer_id() {
        return customer_id;
    }


    /**
     * Sets the customer_id value for this Customer.
     * 
     * @param customer_id
     */
    public void setCustomer_id(java.lang.Integer customer_id) {
        this.customer_id = customer_id;
    }


    /**
     * Gets the customer_name value for this Customer.
     * 
     * @return customer_name
     */
    public java.lang.String getCustomer_name() {
        return customer_name;
    }


    /**
     * Sets the customer_name value for this Customer.
     * 
     * @param customer_name
     */
    public void setCustomer_name(java.lang.String customer_name) {
        this.customer_name = customer_name;
    }


    /**
     * Gets the dateOfBirth value for this Customer.
     * 
     * @return dateOfBirth
     */
    public java.lang.String getDateOfBirth() {
        return dateOfBirth;
    }


    /**
     * Sets the dateOfBirth value for this Customer.
     * 
     * @param dateOfBirth
     */
    public void setDateOfBirth(java.lang.String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets the gender value for this Customer.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this Customer.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the occupationCode value for this Customer.
     * 
     * @return occupationCode
     */
    public java.lang.Integer getOccupationCode() {
        return occupationCode;
    }


    /**
     * Sets the occupationCode value for this Customer.
     * 
     * @param occupationCode
     */
    public void setOccupationCode(java.lang.Integer occupationCode) {
        this.occupationCode = occupationCode;
    }


    /**
     * Gets the panNumber value for this Customer.
     * 
     * @return panNumber
     */
    public java.lang.String getPanNumber() {
        return panNumber;
    }


    /**
     * Sets the panNumber value for this Customer.
     * 
     * @param panNumber
     */
    public void setPanNumber(java.lang.String panNumber) {
        this.panNumber = panNumber;
    }


    /**
     * Gets the phoneNumber value for this Customer.
     * 
     * @return phoneNumber
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the phoneNumber value for this Customer.
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Gets the prefix value for this Customer.
     * 
     * @return prefix
     */
    public java.lang.String getPrefix() {
        return prefix;
    }


    /**
     * Sets the prefix value for this Customer.
     * 
     * @param prefix
     */
    public void setPrefix(java.lang.String prefix) {
        this.prefix = prefix;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.customer_id==null && other.getCustomer_id()==null) || 
             (this.customer_id!=null &&
              this.customer_id.equals(other.getCustomer_id()))) &&
            ((this.customer_name==null && other.getCustomer_name()==null) || 
             (this.customer_name!=null &&
              this.customer_name.equals(other.getCustomer_name()))) &&
            ((this.dateOfBirth==null && other.getDateOfBirth()==null) || 
             (this.dateOfBirth!=null &&
              this.dateOfBirth.equals(other.getDateOfBirth()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.occupationCode==null && other.getOccupationCode()==null) || 
             (this.occupationCode!=null &&
              this.occupationCode.equals(other.getOccupationCode()))) &&
            ((this.panNumber==null && other.getPanNumber()==null) || 
             (this.panNumber!=null &&
              this.panNumber.equals(other.getPanNumber()))) &&
            this.phoneNumber == other.getPhoneNumber() &&
            ((this.prefix==null && other.getPrefix()==null) || 
             (this.prefix!=null &&
              this.prefix.equals(other.getPrefix())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCustomer_id() != null) {
            _hashCode += getCustomer_id().hashCode();
        }
        if (getCustomer_name() != null) {
            _hashCode += getCustomer_name().hashCode();
        }
        if (getDateOfBirth() != null) {
            _hashCode += getDateOfBirth().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getOccupationCode() != null) {
            _hashCode += getOccupationCode().hashCode();
        }
        if (getPanNumber() != null) {
            _hashCode += getPanNumber().hashCode();
        }
        _hashCode += new Long(getPhoneNumber()).hashCode();
        if (getPrefix() != null) {
            _hashCode += getPrefix().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.soap.com/", "customer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customer_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "customer_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfBirth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateOfBirth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("occupationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "occupationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("panNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "panNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
