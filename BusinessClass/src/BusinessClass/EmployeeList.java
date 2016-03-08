
package BusinessClass;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
public class EmployeeList {
private final int size = 10;
private Employee[] arrEmployeeList;

public EmployeeList() {
    arrEmployeeList = new Employee[size];
}

public Employee search(String username) throws Exception{
    
    try {
    for (int index= 0; index < size; index ++){
        if (arrEmployeeList[index] != null){
            if(username.equals(arrEmployeeList[index].getSSNumber())){
                return arrEmployeeList[index];
            }
            }
        }
    }
    catch (Exception objException) {
                throw new Exception("Error details" +"\n" + objException.getMessage());
                    }
            
    return null;
}

public boolean add(Employee objNewEmployee) throws Exception{
    try {
for (int index=0; index < size; index++) {
    if(arrEmployeeList[index] == null){
        if(arrEmployeeList[index].getage() >= 16){
        arrEmployeeList[index] = objNewEmployee;
        return true;
    }
    }
} 
    }

catch (Exception addObjException){
        
                throw new Exception("Error details" +"\n" + addObjException.getMessage());
                    }
    return false;
}
 


public boolean add(String SSNumber, String firstname, String lastname, String DOB, String address, String phone, String email, String jobtitle) throws Exception{
    Employee objNewEmployee = new Employee( SSNumber, firstname, lastname, DOB, address, phone, email, jobtitle);
    try {
    for (int index=0; index<size; index++){
        if (arrEmployeeList[index] == null){
            if(arrEmployeeList[index].getage() >= 16){
            arrEmployeeList[index] = objNewEmployee;
            return true;
        }
    }
    }
    }
    catch (Exception addEmpException){
            
            throw new Exception("Error details" +"\n" + addEmpException.getMessage());       
            }
    return false;
}
     


public boolean edit(String ssNumber, Employee objEditEmployee) throws Exception{
    try {
    for(int index=0; index< size; index++){
        if(arrEmployeeList[index] != null){
            if (ssNumber.equals(arrEmployeeList[index].getSSNumber()))
        arrEmployeeList[index].setfirstName(objEditEmployee.getfirstName());
        arrEmployeeList[index].setlastName(objEditEmployee.getlastName());
        arrEmployeeList[index].setDateOfBirth(objEditEmployee.getDateOfBirth());
        arrEmployeeList[index].setaddress(objEditEmployee.getaddress());
        arrEmployeeList[index].setphone(objEditEmployee.getphone());
        arrEmployeeList[index].setemail(objEditEmployee.getemail());
        arrEmployeeList[index].setjobTitle(objEditEmployee.getjobTitle());
        return true;
        }
    }
    }
    catch (Exception editObjException){
                throw new Exception("Error details" +"\n" + editObjException.getMessage());            
            }
     return false;
}
public boolean edit(String SSNumber, String firstname, String lastname, String DOB, String address, String phone, String email, String jobtitle) throws Exception{
    try {
    for (int index=0; index<size; index++){
        if(arrEmployeeList[index] != null){
            if(SSNumber.equals(arrEmployeeList[index].getSSNumber())){
                arrEmployeeList[index].setfirstName(firstname);
                arrEmployeeList[index].setlastName(lastname);
                arrEmployeeList[index].setDateOfBirth(DOB);
                arrEmployeeList[index].setaddress(address);
                arrEmployeeList[index].setphone(phone);
                arrEmployeeList[index].setemail(email);
                arrEmployeeList[index].setjobTitle(jobtitle);
                return true;
            }
        }
    }
    }
    catch (Exception editEmployeeException){
        throw new Exception("Error details" +"\n" + editEmployeeException.getMessage());            
    }

    return false;
}

public boolean remove(String SSNumber) throws Exception{
    try {
    for(int index=0; index<size; index++){
        if(arrEmployeeList[index] != null){
            if (SSNumber.equals(arrEmployeeList[index].getSSNumber())){
                arrEmployeeList= null;
                return true;
            }
        }
    } 
    }
    catch (Exception removeEmployeeException){
        throw new Exception("Error details" +"\n" + removeEmployeeException.getMessage());            
            
    }
    return false;
}

public boolean print(String SSNumber) throws Exception{
    try {
    for(int index=0; index<size; index++){
        if(arrEmployeeList[index] != null){
        if(SSNumber.equals(arrEmployeeList[index].getSSNumber())){
            arrEmployeeList[index].print();
            return true;
        }
        }
        }
    }
    catch (Exception printException){
        throw new Exception("Error details" +"\n" + printException.getMessage());            
   }
    return false;
}
public void printAll(){
    try{
    for (int index=0; index<size; index++){
        if(arrEmployeeList[index] != null){
            arrEmployeeList[index].print();}
        } 
    }
    catch (Exception printAllException){
        System.out.println("An exception was thrown");
        System.out.println("Error details" +"\n" + printAllException.getMessage());            
       }
}


public void clear() throws Exception{ 
    try{
    Arrays.fill(arrEmployeeList, null);
    }
    catch (Exception clearException){
        throw new Exception("Error details" +"\n" + clearException.getMessage());            
       
    }
}


public void load() throws Exception {
database_Load(); 
    }
 public void save() throws IOException{
     database_Save();
 }
 protected void database_Load() throws Exception {
     try {
         Path objDirPath = Paths.get("EmployeeData.txt");
         if (Files.notExists(objDirPath)) {
             Files.createFile(objDirPath);
         }
         BufferedReader objInStream= new BufferedReader(
                                     new FileReader("EmployeeData.txt"));
         
         String line;
         line = objInStream.readLine();
         
         while(line != null){
             String [] arrLine= line.split(",");
             Employee objEmployee = new Employee();             
             objEmployee.setSSNumber(arrLine[0]);
             objEmployee.setfirstName(arrLine[1]);
             objEmployee.setlastName(arrLine[2]);
             objEmployee.setDateOfBirth(arrLine[3]);
             objEmployee.setaddress(arrLine[4]);
             objEmployee.setphone(arrLine[5]);
             objEmployee.setemail(arrLine[6]);
             objEmployee.setjobTitle(arrLine[7]);
             this.add(objEmployee);
             line = objInStream.readLine();
               
         } 
         objInStream.close();
     }
    
     catch (Exception objException){
        throw new Exception("Error in load() method" + objException.toString() ); 
        
     }
 }
 
 protected void database_Save() throws IOException{
      try {
          PrintWriter objOutStream= new PrintWriter(
                                     new BufferedWriter(
                                     new FileWriter("EmployeeData.txt")));
      for(int index=0; index < size; index++) {
          if(arrEmployeeList[index] != null) {
              objOutStream.println(
              arrEmployeeList[index].getSSNumber() + "," +
              arrEmployeeList[index].getfirstName() + "," +
              arrEmployeeList[index].getlastName() + "," +
              arrEmployeeList[index].getDateOfBirth() + "," + 
              arrEmployeeList[index].getaddress() + "," +  
              arrEmployeeList[index].getphone() + "," +
              arrEmployeeList[index].getemail() + "," +
              arrEmployeeList[index].getjobTitle());
          }
      }
      objOutStream.close();
      
      }
      catch (IOException objSaveException){
          throw new IOException("I/O Error in Save method" + objSaveException.toString());
      }
}
 
}

          




           
                    

        
    
    


    

