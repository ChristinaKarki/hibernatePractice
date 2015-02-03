/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.dto;

import java.util.Date;
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

 
    @Embedded
    private Address address;
    
    @Temporal(TemporalType.DATE)
    
    private Date joinedDate;
    @Transient
    private int age;
   
    @Lob
    private String description;
    
       public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "UserDetails{" + "userid=" + userid + ", username=" + username + ", address=" + address + ", joinedDate=" + joinedDate + ", age=" + age + ", description=" + description + '}';
    }

 
    
    
   
}
