/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import dals.EmployeeDAL;
import employeemanagement.models.Employee;
import helpers.FileManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lrandom
 */
public class EmployeeManagement {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FileManager fileManager;
        EmployeeDAL employeeDAL;
        ArrayList<Employee> employees;
        
        fileManager = new FileManager();
        employees=fileManager.getEmployeesFromDB();
        employeeDAL = new EmployeeDAL();
        employeeDAL.setEmployees(employees);
        
        do {            
            System.out.println("Moi chon");
            System.out.println("1. Xem danh sach NV");
            System.out.println("2. Them NV");
            System.out.println("3. Sua NV");
            System.out.println("4. Xoa NV theo Id");
            System.out.println("5. Tim ds NV theo Id");
            System.out.println("6. Tim NV theo ten");
            System.out.println("7. Tinh luong trung binh cua NV");
            System.out.println("8. Tim ds NV theo luong nho hon hoac lon hon");
            System.out.println("9. Thoat");
            
            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();
            switch(key){
              case 1:
                  //DS NV
                  System.out.println("Danh sach nv la");
                  employees = employeeDAL.getEmployees();
                  for (int i = 0; i < employees.size(); i++) {
                      System.out.println("NV thu "+(i+1));
                      System.out.println("Id: "+employees.get(i).getId());
                      System.out.println("FullName: "+employees.get(i).getFullname());
                      System.out.println("Address: "+employees.get(i).getAddress());
                      System.out.println("Salary: "+employees.get(i).getSalary());
                      System.out.println("------------------------------------------");
                  }
                  break;
                  
              case 2:
                  //Add NV
                  Scanner scanner1 = new Scanner(System.in);
                  System.out.println("Vui long nhap thong tin NV");
                  System.out.println("Id");
                  String id = scanner1.nextLine();
                  
                  System.out.println("FullName");
                  scanner1 =new Scanner(System.in);
                  String fullName = scanner1.nextLine();
                          
                  System.out.println("Address");
                  scanner1.reset();
                  String address = scanner1.nextLine();
                  
                  System.out.println("Salary");
                  scanner1.reset();
                  float salary = scanner1.nextFloat();
                  
                  System.out.println("Position");
                  scanner1.reset();
                  String position = scanner1.nextLine();
                  
                  Employee employee = new Employee(id, fullName, salary, address, position);
                  employeeDAL.add(employee);
                  
                  //luu lai vao file
                  fileManager.saveDB(employeeDAL.getEmployees());
                  break;
                  
              case 3:
                  Scanner scanner2 = new Scanner(System.in);
                  System.out.println("Vui long nhap vao id cua nhan vien");
                  id = scanner2.nextLine();
                  scanner2= new Scanner(System.in);
                  fullName = scanner2.nextLine();
                  scanner2 = new Scanner(System.in);
                  address = scanner2.nextLine();
                  scanner2 = new Scanner(System.in);
                  salary = scanner2.nextFloat();
                  scanner2 = new Scanner(System.in);
                  position = scanner2.nextLine();
                  employeeDAL.edit(id, fullName, address, salary, position);
                  
                  fileManager.saveDB(employeeDAL.getEmployees());
                  break;
                  
              case 4:
                  break;
                  
              case 5:
                  break;
                  
              case 6:
                  break;
                  
              case 7:
                  break;
                  
              case 8:
                  break;
                  
              case 9:
                 
                  System.exit(0);
                  break;
            }
        } while (true);
    }
}
