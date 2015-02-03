/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;



/**
 *
 * @author CKarki
 */

@Embeddable
public class Address {
    @Column(name="STREET_NAME")
    private String street;
    @Column(name="CITY_NAME")
    private String city;
    @Column(name="STATE_NAME")
    private String state;
    @Column(name="PINCODE_NAME")
    private String pincode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
    
}
