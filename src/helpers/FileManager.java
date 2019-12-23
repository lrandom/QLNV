/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import employeemanagement.models.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lrandom
 */
public class FileManager {
   private ObjectInputStream obInputStream;
   private ObjectOutputStream obOutputStream;
   private FileInputStream fis; 
   private FileOutputStream fos;
   public static final String DB_PATH = "data.dat";

    public FileManager() {
        File file = new File(DB_PATH);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
   
   
   public ArrayList<Employee> getEmployeesFromDB(){
       try {
           fis = new FileInputStream(DB_PATH);
           obInputStream =new ObjectInputStream(fis);
           ArrayList<Employee> employees =(ArrayList<Employee>)obInputStream.readObject();
           obInputStream.close();
           fis.close();
           return employees;
       } catch (Exception e) {
           //e.printStackTrace();
           return new ArrayList<Employee>();
       }
   }
   
   public boolean saveDB(ArrayList<Employee> employees){
       try {
           fos = new FileOutputStream(DB_PATH);
           obOutputStream = new ObjectOutputStream(fos);
           obOutputStream.writeObject(employees);
           obOutputStream.flush();
           fos.flush();
           obOutputStream.close();
           fos.close();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
}
