
package BusinessClass;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
public class UserAccountList {
public static final int size = 10;
private UserAccount[] arrUserAccountList;

public UserAccountList() {
    arrUserAccountList = new UserAccount[size];
    
}

public UserAccount search(String username) throws Exception{
    
    try {
    for (int index= 0; index < size; index ++){
        if (arrUserAccountList[index] != null){
            if(username.equals(arrUserAccountList[index].getusername())){
                return arrUserAccountList[index];
            }
            }
        }
    }
    catch (Exception objException) {
                
                throw new Exception("Error details" +"\n" + objException.getMessage());
                    }
            
    return null;
}

public boolean add(UserAccount objNewUserAccount) throws Exception{
    try {
for (int index=0; index < size; index++) {
    if(arrUserAccountList[index] == null){
        arrUserAccountList[index] = objNewUserAccount;
        return true;
    }
}
    }
catch (Exception addObjException){
        
        throw new Exception("Error details" +"\n" + addObjException.getMessage());
                    }

 return false;
}

public boolean add(String username, String newpassword, String newemail) throws Exception{
    UserAccount objNewUserAccount = new UserAccount(username, newpassword, newemail);
    try {
    for (int index=0; index<size; index++){
        if (arrUserAccountList[index] == null){
            arrUserAccountList[index] = objNewUserAccount;
            return true;
        }
    }
    }
    catch (Exception addUserException){
            throw new Exception("Error details" +"\n" + addUserException.getMessage());       
            }
    
     return false;
}

public boolean edit(String username, UserAccount objEditUserAccount) throws Exception{
    try {
    for(int index=0; index< size; index++){
        if(arrUserAccountList[index] != null){
            if (username.equals(arrUserAccountList[index].getpassword()))
        arrUserAccountList[index].setpassword(objEditUserAccount.getpassword());
        arrUserAccountList[index].setemail(objEditUserAccount.getemail());
        return true;
        }
    }
    }
    catch (Exception editObjException){
                throw new Exception("Error details" +"\n" + editObjException.getMessage());            
            }
    
     return false;
}
public boolean edit(String username, String password, String email) throws Exception{
    try {
    for (int index=0; index<size; index++){
        if(arrUserAccountList[index] != null){
            if(username.equals(arrUserAccountList[index].getusername())){
                arrUserAccountList[index].setpassword(password);
                arrUserAccountList[index].setemail(email);
                return true;
            }
        }
    }
    }
    catch (Exception editUserException){
        throw new Exception("Error details" +"\n" + editUserException.getMessage());            
    }
    
    return false;
}

public boolean remove(String username)throws Exception{
    try {
    for(int index=0; index<size; index++){
        if(arrUserAccountList[index] != null){
            if (username.equals(arrUserAccountList[index].getusername())){
                arrUserAccountList= null;
                return true;
            }
        }
    } 
    }
    catch (Exception removeUserException){
        throw new Exception("Error details" +"\n" + removeUserException.getMessage());            
            
    }
    
    return false;
}

public boolean changeUsername(String username, String newUsername) throws Exception{
    try {
    for(int index=0; index<size; index++){
        if(arrUserAccountList[index] != null){
        if(username.equals(arrUserAccountList[index].getusername())){
            arrUserAccountList[index].setusername(newUsername);
            return true;
        }
        }
        }
    }
    catch (Exception changeUsernameException){
        throw new Exception("Error details" +"\n" + changeUsernameException.getMessage());            
   }
    
    return false;
}
public boolean changePassword(String username, String newPassword) throws Exception{
    try{
    for(int index=0; index<size; index++){
        if(arrUserAccountList[index] != null){
        if(username.equals(arrUserAccountList[index].getusername())){
            arrUserAccountList[index].setpassword(newPassword);
            return true;
        }
        }
        } 
    }
    catch (Exception changePasswordException){
        throw new Exception("Error details" +"\n" + changePasswordException.getMessage());            
       }
    
    return false;
}
public boolean changeEmail(String username, String newEmail) throws Exception{
    try {
    for(int index=0; index<size; index++){
        if(arrUserAccountList[index] != null){
        if(username.equals(arrUserAccountList[index].getusername())){
            arrUserAccountList[index].setemail(newEmail);
            return true;
        }
        }
        } 
    }
    catch (Exception changeEmailException){
    throw new Exception("Error details" +"\n" + changeEmailException.getMessage());            
       }
    
    return false;
}

public void clear() throws Exception{ 
    try{
    Arrays.fill(arrUserAccountList, null);
    }
    catch (Exception clearException){
        throw new Exception("Error details" +"\n" + clearException.getMessage());            
       
    }
    
}


public boolean Authenticate(String username, String password) throws Exception{
    load();
    
try {
    
    for (int index= 0; index < size; index ++){
        
            if (arrUserAccountList[index] != null){
                if (username.equals(arrUserAccountList[index].getusername()) & password.equals(arrUserAccountList[index].getpassword())){ 
                    
                   clear();
                   return true;
                
            }
            }
            else {
         UserAccount defaultUser;
         defaultUser= UserAccount.getInstance("admin", "999", null);
         return defaultUser.authenticate(username, password);
            }
            
}
     
}
catch (Exception authenticateException) {
    throw new Exception("Error details" +"\n" + authenticateException.getMessage());            
       
}

    clear();
    return false;
        } 

public void load() throws Exception{
database_Load(); 
    }
 public void save() throws IOException{
     database_Save();
 }
 protected void database_Load() throws Exception{
     try {
         Path objDirPath = Paths.get("UserAccountData.txt");
         if (Files.notExists(objDirPath)) {
             Files.createFile(objDirPath);
         }
         BufferedReader objInStream= new BufferedReader(
                                     new FileReader("UserAccountData.txt"));
         
         String line;
         line = objInStream.readLine();
         
         while(line != null){
             String [] arrLine= line.split(",");
             UserAccount objUserAccount = new UserAccount();
             objUserAccount.setuserAccountID(arrLine[0]);
             objUserAccount.setusername(arrLine[1]);
             objUserAccount.setpassword(arrLine[2]);
             objUserAccount.setemail(arrLine[3]);
             this.add(objUserAccount);
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
                                     new FileWriter("UserAccountData.txt")));
      for(int index=0; index < size; index++) {
          if(arrUserAccountList[index] != null) {
              objOutStream.println(
              arrUserAccountList[index].getuserAccountID() + "," +
              arrUserAccountList[index].getusername() + "," +
              arrUserAccountList[index].getpassword() + "," +
              arrUserAccountList[index].getemail());
          }
      }
      objOutStream.close();
      
      }
      catch (IOException objSaveException){
          throw new IOException("I/O Error in Save method" + objSaveException.toString());
      }
}
 
}

          




           
                    

        
    
    


    

