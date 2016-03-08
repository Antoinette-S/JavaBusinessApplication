

package BusinessClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class Person {
    private String SSNumber;
    private String firstName;
    private String lastName;
    private String DateOfBirth;
    private int age;
    private String address;
    private String phone;
    private String email;

    private static int count = 0;

             
  
    public Person(){
        SSNumber = "";
        firstName= "";
        lastName= "";
        DateOfBirth="";
        address = "";
        phone = "";
        email= "";
  
        
        count++;
    }
        
    public Person(String s, String f, String l, String d, String a, String p, String e) {
        setSSNumber (s);
        setfirstName (f);
        setlastName (l);
        setDateOfBirth (d);
        setaddress (a);
        setphone  (p);
        setemail (e);
        
        
        count++;
    
        
    }

    public String getSSNumber(){
        return SSNumber;
    } 
    public void setSSNumber(String s){
        SSNumber = s;
        
    }
    public String getfirstName(){
            return firstName;
                
            }   
    public void setfirstName(String f){
        firstName = f;
    }
    public String getlastName(){            
                return lastName;
                
    }
    public void setlastName(String l){
        lastName = l;
    }
    public String getDateOfBirth(){
        return DateOfBirth;
    }  
    public void setDateOfBirth(String d){
        DateOfBirth = d;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate objDOB = LocalDate.parse(d,formatter);
        LocalDate today = LocalDate.now();
        
        age = today.getYear() - objDOB.getYear();    
    }
    public int getage(){
        return age;
    }  
    public String getaddress(){
       return address;
}   
   public void setaddress (String a){
       address = a;
       
   }
    public String getphone(){
        return phone;
    }
    public void setphone(String p){
        phone = p;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String e){
        email = e;
    }
    public static int getcount(){
        return count;
    }
    public static void setcount(int c){
        
        count = c;
    }
    public abstract void print();
    
    
}
