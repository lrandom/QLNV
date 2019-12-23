/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement.models;

import java.io.Serializable;

/**
 *
 * @author Lrandom
 */
public class Employee implements Serializable{
    private String id;
    private String fullname;
    private float salary;
    private String address;
    private String position;

    public Employee(){
    
    }
    public Employee(
            String id, 
            String fullname, 
            float salary, 
            String address, 
            String position) {
        this.id = id;
        this.fullname = fullname;
        this.salary = salary;
        this.address = address;
        this.position = position;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
