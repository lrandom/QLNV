/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dals;

import employeemanagement.models.Employee;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Lrandom
 */
public class EmployeeDAL {
    ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public void add(Employee employee){
       this.employees.add(employee);
    }
    
    public boolean edit(String id, String fullname, String address, float salary, String position){
        EmployeeWrapper employeeWrapper = findById(id);
        if(employeeWrapper!=null){
            employeeWrapper.employee.setFullname(fullname);
            employeeWrapper.employee.setAddress(address);
            employeeWrapper.employee.setSalary(salary);
            employeeWrapper.employee.setPosition(position);
            this.employees.set(employeeWrapper.index, employeeWrapper.employee);
            return true;
        }
        return false;
    }
    
    public EmployeeWrapper findById(String id){
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getId().equalsIgnoreCase(id)){
               return new EmployeeWrapper(i,employees.get(i));
            }
        }
        return null;
    }
    
    public ArrayList<Employee> findByName(String fullname){
        ArrayList<Employee> tmpEmployee = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getFullname().equalsIgnoreCase(fullname)){
               tmpEmployee.add(employees.get(i));
            }
        }
        return tmpEmployee;
    }
    
    public float getSalaryAvg(){
        float sum =0;
        for (int i = 0; i < employees.size(); i++) {
            sum+=employees.get(i).getSalary();
        }
        return sum/(employees.size());
    }
    
    public ArrayList<Employee> findBySalary(float salary, boolean isLager){
        ArrayList<Employee> tmpEmployee = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
           if(isLager){
             if(employees.get(i).getSalary()>salary){
                tmpEmployee.add(employees.get(i));
             }; 
           }else{
              if(employees.get(i).getSalary()<salary){
                tmpEmployee.add(employees.get(i));
             }; 
           }
        }
        return tmpEmployee;
    }
    
    class EmployeeWrapper{
       public int index;
       public Employee employee;

        public EmployeeWrapper(int index, Employee employee) {
            this.index = index;
            this.employee = employee;
        }
    }
}
