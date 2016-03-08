
package BusinessClass;
import java.util.UUID;


public class UserAccount {


private String userAccountID;
private String username;
private String password;
private String email;


    public UserAccount(){
    userAccountID = UUID.randomUUID().toString();
    username = "";
    password = "";
    email = "";
    }
    
    UserAccount(String u, String p, String e){
        userAccountID= UUID.randomUUID().toString();
        setusername(u);
        setpassword(p);
        setemail(e);
    
    }

    
    
    
    
    
    
    public String getuserAccountID() {
        return userAccountID;
        
    }
    public void setuserAccountID(String i){
    userAccountID = i;
}
   public String getusername() {
   return username;
}
    public void setusername(String u){
    username = u;
}
    public String getpassword(){
    return password;
}
    public void setpassword(String p){
    password = p;
}
    public String getemail(){
    return email;
}
    public void setemail(String e){
    email = e;
}

    

    
public static UserAccount getInstance() {
            
        UserAccount objAccount1 = new UserAccount ();
        return objAccount1;
}

public static UserAccount getInstance(String u, String p, String e) {
            
        UserAccount ObjAccount2 = new UserAccount ( u, p, e);
        return ObjAccount2;
}

    public boolean authenticate (String u, String p){
        
             
        if ( username.equals(u) & password.equals(p)) {
            return true;
        }
        else{
        
    return false;
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
protected void database_Load(){

}
protected void database_Insert(){

}
protected void database_Update(){

}
protected void database_Delete(){

}        
        
}