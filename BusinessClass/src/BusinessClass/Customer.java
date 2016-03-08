package BusinessClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Customer extends Person {
    
    private String idNumber;
    
    public Customer()
    {
        super();
        
        idNumber = "";
    }
    public Customer(String idNumber, String f, String l, String d, String a, String p, String e){
        super(idNumber, f, l, d, a, p, e);
    }
    
    public String getidNumber(){
        return idNumber;
    }
    
    public void setidNumber(String i){
        idNumber = i;
    }
    
    public void print() {
    try {   
            
         PrintWriter objOutStream= new PrintWriter( 
                                   new BufferedWriter(
                                   new FileWriter("Network_Printer.txt", true)));
         
        
        objOutStream.println("Employee information: ");
        objOutStream.println("Social Security= " + this.getidNumber());
        objOutStream.println("First Name= " + this.getfirstName());
        objOutStream.println("Last Name= " + this.getlastName());
        
        objOutStream.println("Date Of Birth= " + this.getDateOfBirth());
        objOutStream.println("Age= "+ this.getage());
        objOutStream.println("Address= "+ this.getaddress());
        objOutStream.println("Phone= " + this.getphone());
        objOutStream.println("Email= " + this.getemail());
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

    idNumber = this.getidNumber();
    throw new UnsupportedOperationException("This feature is under construction, cannot find Customer ID" +this.toString() );            
}
protected void database_Insert() throws UnsupportedOperationException{
  
        
    idNumber = this.getidNumber();
    throw new UnsupportedOperationException("This feature is under construction, cannot insert the following values " +this.toString() +this.getfirstName() +this.getlastName()  +this.getDateOfBirth() +this.getaddress() +this.getphone() +this.getemail());            
       
}

protected void database_Update() throws UnsupportedOperationException{
    idNumber = this.getidNumber();
    throw new UnsupportedOperationException("This feature is under construction, cannot update the following values " +this.toString() +this.getfirstName() +this.getlastName()  +this.getDateOfBirth() +this.getaddress() +this.getphone() +this.getemail());            
                   
       

}
protected void database_Delete() throws UnsupportedOperationException{
idNumber = this.getidNumber();
    throw new UnsupportedOperationException("This feature is under construction, cannot delete the following customer " + this.toString());            
                   
       

}

    
}

