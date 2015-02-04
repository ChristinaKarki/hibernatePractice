/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.christina.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
//    private Address homeAddress;
//    @Embedded
//    private Address officeAddress;
//    @ElementCollection
    @ElementCollection(fetch=FetchType.EAGER)
    @JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
//  private Set<Address> listOfAddresses = new HashSet();
//    @GenericGenerator(name = "hilo-gen",strategy = "hilo")
//    @CollectionId(columns =@Column(name="ADDRESS_ID") ,generator ="hilo-gen" ,type =@Type(type="long"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();
    
    @Temporal(TemporalType.DATE)
    
    @Transient
    private Date joinedDate;
    @Transient
    private int age;
   
//    @Lob
//    private String description;

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
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

   
   
    
 
    
    
}
