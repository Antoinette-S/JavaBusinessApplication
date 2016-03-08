

package BusinessClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.file.*;
import java.io.*;

public class Employee extends Person{

    private String jobTitle;
    
    
    public Employee(){
        
        jobTitle ="";  
        
        
    }
        
    public Employee(String s, String f, String l, String d, String a, String p, String e, String t) {
        setSSNumber (s);
        setfirstName (f);
        setlastName (l);
        setDateOfBirth (d);
        setaddress (a);
        setphone  (p);
        setemail (e);
        setjobTitle (t);
        
        
    
        
    }
@Override
    public String getDateOfBirth(){
        return super.getDateOfBirth();
    }  
@Override    
    public void setDateOfBirth(String d){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate objDOB = LocalDate.parse(d,formatter);
        int age = LocalDate.now().getYear() - objDOB.getYear();
        if(age >= 16){
         super.setDateOfBirth(d);
        }
        else{
            throw new UnsupportedOperationException("Policy violation- employee is underage");            
       
}
    }
    
    public String getjobTitle(){
        return jobTitle;
    }
    public void setjobTitle(String t){
        jobTitle = t;
    }
    
    
    
public void print (){
        try {   
            
         PrintWriter objOutStream= new PrintWriter( 
                                   new BufferedWriter(
                                   new FileWriter("NetworkPrinter.txt", true)));
         
        
        objOutStream.println("Employee information: ");
        objOutStream.println("Social Security= " + this.getSSNumber());
        objOutStream.println("First Name= " + this.getfirstName());
        objOutStream.println("Last Name= " + this.getlastName());
        
        objOutStream.println("Date Of Birth= " + this.getDateOfBirth());
        objOutStream.println("Age= "+ this.getage());
        objOutStream.println("Address= "+ this.getaddress());
        objOutStream.println("Phone= " + this.getphone());
        objOutStream.println("Email= " + this.getemail());
        objOutStream.println("Title= " + this.getjobTitle());
        objOutStream.println();
        objOutStream.println();
        objOutStream.close();
        
        }
        catch (Exception objException) {
            System.out.println("Error in load() method" + objException.toString() );    
                
               }
       

       }
public void load(){
database_Load();
}
public void insert(){
database_Insert();
}
public void update(){
database_Update();
}
public void delete(){
database_Delete();
}
protected void database_Load() throws UnsupportedOperationException{
try{
    System.out.println("This feature is under construction");
}
catch (UnsupportedOperationException loadException) {
    throw new UnsupportedOperationException("Error details" +"\n" + loadException.getMessage());            
       
}
}
protected void database_Insert() throws UnsupportedOperationException{
try{
    System.out.println("This feature is under construction");
}
catch (UnsupportedOperationException insertException) {
    throw new UnsupportedOperationException("Error details" +"\n" + insertException.getMessage());            
       
}
}
protected void database_Update() throws UnsupportedOperationException{
try{
    System.out.println("This feature is under construction");
}
catch (UnsupportedOperationException updateException) {
    throw new UnsupportedOperationException("Error details" +"\n" + updateException.getMessage());            
       
}
}
protected void database_Delete() throws UnsupportedOperationException{
try{
    System.out.println("This feature is under construction");
}
catch (UnsupportedOperationException deleteException) {
    throw new UnsupportedOperationException("Error details" +"\n" + deleteException.getMessage());            
       
}
}

    
}
