/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.dto;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author CKarki
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails{ 
    
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int userid;
    
    private String username; 

 
   // @Embedded
   // private Address address;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="street",column=@Column(name="HOME_STREET")),
        @AttributeOverride(name="city",column=@Column(name="HOME_CITY")),
        @AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
        @AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE"))
    })
    private Address homeAddress;
    @Embedded
    private Address officeAddress;
    
    @Temporal(TemporalType.DATE)
    
    private Date joinedDate;
    @Transient
    private int age;
   
    @Lob
    private String description;
    
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
    
  
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
    
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDetails{" + "userid=" + userid + ", username=" + username + ", homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + ", joinedDate=" + joinedDate + ", age=" + age + ", description=" + description + '}';
    }
    
 
    
    
   
}
