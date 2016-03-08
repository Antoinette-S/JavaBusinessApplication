
package presentationui;

import BusinessClass.UserAccount;
import BusinessClass.UserAccountList;
import BusinessClass.Employee;
import BusinessClass.EmployeeList;
import BusinessClass.Customer;
import BusinessClass.Person;
import java.io.IOException;
import java.util.Scanner;

public class PresentationUI {
public static UserAccountList objUserAccount = new UserAccountList();
public static EmployeeList objEmployee = new EmployeeList();

public static boolean Authenticate(String username, String password) throws Exception{
     
    return objUserAccount.Authenticate(username, password);
}


public static int mainMenuScreen() {
    Scanner keyboardInput = new Scanner(System.in);
    int option;
        System.out.println("Welcome to the small business application!" );
         System.out.println( );
         System.out.println("1. Back-end Management Screen");
         System.out.println("2. Retail Point-Of-Sales Screen");
         System.out.println("0. Exit (return to login screen)");
         System.out.println( );
         System.out.println("Please select a menu option (1, 2, or 0)");
         System.out.println( );
         
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
         
}
    public static int BackEndManagementScreen() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        
         System.out.println("Welcome to the Back-end & Maintenance Management Portal!" );
         System.out.println();
         System.out.println("1. User Account Management");
         System.out.println("2. Employee Management");
         System.out.println("0. Exit (return to main screen)");
         System.out.println( );
         System.out.println("Please select a menu option (1 or 0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
    }
    
    public static void startBackEndManagement() throws Exception {
        int option;
        objUserAccount.load();
        option = BackEndManagementScreen();
        while (option != 0){
            switch (option)
            {
                case 1:
                    startUserAccountScreen();
                    break;
                case 2:
                    startEmployeeScreen();
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
                    System.out.println();
                    break;
            }
            option = BackEndManagementScreen();
        }
      System.out.println("Exiting Back-end Management.....");
      System.out.println();
    }

    public static int userAccountManagement() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the User Account Management Portal" );
         System.out.println( );
         System.out.println("1. Search for a User Account Record");
         System.out.println("2. Add a User Account Record");
         System.out.println("3. Edit a User Account Record");
         System.out.println("4. Remove a User Account Record");
         System.out.println("5. Change a Username");
         System.out.println("6. Change a Password");
         System.out.println("7. Change a Email");
         System.out.println("0. Exit (return to Back-End Management)");
         System.out.println( );
         System.out.println("Please select a menu option (1, 2, 3, 4, 5, 6, 7 or 0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
}
    public static void startUserAccountScreen() throws Exception{
        int option;
        objUserAccount.load();
        option = userAccountManagement();
        while (option !=0) {
            switch (option)
            {
                case 1:
                    searchUserAccountRecord();
                    break;
                case 2:
                    addUserAccountRecord();
                    break;
                case 3:
                    editUserAccountRecord();
                    break;
                case 4:
                    removeUserAccountRecord();
                    break;
                case 5:
                    changeUsername();
                    break;
                case 6:
                    changePassword();
                    break;
                case 7:
                    changeEmail();
                    break;
                    
                default:
                    System.out.println("Incorrect entry, please try again");
                    break;
            }
        option = userAccountManagement();
        }
        System.out.print("Exiting User Account Management...");
        objUserAccount.save();
        objUserAccount.clear();
    }
    public static int employeeManagement() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Employee Management Portal" );
         System.out.println( );
         System.out.println("1. Search for an Employee Record");
         System.out.println("2. Add an Employee Record");
         System.out.println("3. Edit an Employee Record");
         System.out.println("4. Remove an Employee Record");
         System.out.println("5. Print an Employee Record");
         System.out.println("6. Print all Employee Records");
         System.out.println("0. Exit (return to Back-End Management)");
         System.out.println( );
         System.out.println("Please select a menu option (1, 2, 3, 4, 5, 6 or 0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
}
    
    public static void startEmployeeScreen() throws Exception{
        int option;
        objEmployee.load();
        option = employeeManagement();
        while (option !=0) {
            switch (option)
            {
                case 1:
                    searchEmployeeRecord();
                    break;
                case 2:
                    addEmployeeRecord();
                    break;
                case 3:
                    editEmployeeRecord();
                    break;
                case 4:
                    removeEmployeeRecord();
                    break;
                case 5:
                    printEmployee();
                    break;
                case 6:
                    printAll();
                    break;
                    
                default:
                    System.out.println("Incorrect entry, please try again");
                    break;
            }
        
        option = employeeManagement();
        }
        System.out.print("Exiting Employee Management...");
        objEmployee.save();
        objEmployee.clear();

    }
    
    
    public static void searchUserAccountRecord() throws Exception {
    objUserAccount.load();
    Scanner keyboardInput = new Scanner(System.in);
    String username;
    System.out.println("Searching User Account List...");
    System.out.println("Please enter username:");
    UserAccount tempUser;
    username = keyboardInput.nextLine();
    tempUser = objUserAccount.search(username);
    if (tempUser != null){

    System.out.println();
    System.out.println("Search Results:");
    System.out.println();
    System.out.println("Customer ID Number " + tempUser.getuserAccountID());
    System.out.println("Customer username " + tempUser.getusername());
    System.out.println("Customer password " + tempUser.getpassword());
    System.out.println("Customer email " + tempUser.getemail());
    
    }
    
    else {
        System.out.println();
        System.out.println("User not found!");
    }
    }
    
    public static void searchEmployeeRecord() throws Exception {
    objEmployee.load();
    Scanner keyboardInput = new Scanner(System.in);
    String SSNumber;
    System.out.println("Searching Employee List...");
    System.out.println("Please enter Social Security Number:");
    Employee tempEmployee;
    SSNumber = keyboardInput.nextLine();
    tempEmployee = objEmployee.search(SSNumber);
    if (tempEmployee != null){

    System.out.println();
    System.out.println("Search Results:");
    System.out.println();
    System.out.println("Employee Social Security Number " + tempEmployee.getSSNumber());
    System.out.println("Employee first name " + tempEmployee.getfirstName());
    System.out.println("Employee last name " + tempEmployee.getlastName());
    System.out.println("Employee date of birth " + tempEmployee.getDateOfBirth());
    System.out.println("Employee address " + tempEmployee.getaddress());
    System.out.println("Employee phone " + tempEmployee.getphone());
    System.out.println("Employee email " + tempEmployee.getemail());
    System.out.println("Employee job title " + tempEmployee.getjobTitle());
    
    }
    
    else {
        System.out.println();
        System.out.println("Employee not found!");
    }
    }
    public static void addEmployeeRecord() throws IOException, Exception {
     Scanner keyboardInput = new Scanner(System.in);
     String SSNumber, firstname, lastname, DOB, address, phone, email, jobtitle;
     boolean success;
     
     System.out.println("Add NEW Employee!");
     System.out.println();
     System.out.println("Please enter Social Security Number:");
     SSNumber = keyboardInput.nextLine();
     System.out.println("Please enter first name:");
     firstname = keyboardInput.nextLine();
     System.out.println("Please enter last name:");
     lastname = keyboardInput.nextLine();
     System.out.println("Please enter date of birth:");
     DOB = keyboardInput.nextLine();
     System.out.println("Please enter address:");
     address = keyboardInput.nextLine();
     System.out.println("Please enter phone number:");
     phone = keyboardInput.nextLine();
     System.out.println("Please enter email:");
     email = keyboardInput.nextLine();
     System.out.println("Please enter job title:");
     jobtitle = keyboardInput.nextLine();
     
     
     
     success = objEmployee.add(SSNumber, firstname, lastname, DOB, address, phone, email, jobtitle);
     if (success){
         System.out.println();
         System.out.println("Employee added");
         
     }
     else {
         System.out.println();
         System.out.println("No space available!");
     }
     
    }
    public static void addUserAccountRecord() throws Exception {
     Scanner keyboardInput = new Scanner(System.in);
     String username, newpassword, newemail;
     boolean success;
     
     System.out.println("Add NEW User Account!");
     System.out.println();
     System.out.println("Please enter NEW username:");
     username = keyboardInput.nextLine();
     System.out.println("Please enter NEW password:");
     newpassword = keyboardInput.nextLine();
     System.out.println("Please enter NEW email:");
     newemail = keyboardInput.nextLine();
     
     success = objUserAccount.add(username, newpassword, newemail);
     if (success){
         System.out.println();
         System.out.println("User Account added");
         
     }
     else {
         System.out.println();
         System.out.println("No space available!");
     }
     
    }
    
    public static void editEmployeeRecord() throws Exception{
       Scanner keyboardInput = new Scanner(System.in);
       String SSNumber, firstname, lastname, DOB, address, phone, email, jobtitle;
       boolean success;
       System.out.println("Edit Employee Record");
       System.out.println();
       System.out.println("Please enter the Social Security Number of the Employee you wish to edit:");
       SSNumber = keyboardInput.nextLine();
       System.out.println("Please enter NEW first name");
       firstname = keyboardInput.nextLine();
       System.out.println("Please enter NEW last name:");
       lastname = keyboardInput.nextLine();
       System.out.println("Please enter NEW date of birth:");
       DOB = keyboardInput.nextLine();
       System.out.println("Please enter NEW address:");
       address = keyboardInput.nextLine();
       System.out.println("Please enter NEW phone number:");
       phone = keyboardInput.nextLine();
       System.out.println("Please enter NEW email:");
       email = keyboardInput.nextLine();
       System.out.println("Please enter NEW job title:");
       jobtitle = keyboardInput.nextLine();

       success = objEmployee.edit(SSNumber, firstname, lastname, DOB, address, phone, email, jobtitle);
       if (success){
         System.out.println();
         System.out.println("Employee modified");  
     }
     else {
         System.out.println();
         System.out.println("Employee not found!");
     }
    }
    
    public static void editUserAccountRecord() throws Exception{
       Scanner keyboardInput = new Scanner(System.in);
       String username, password, email;
       boolean success;
       System.out.println("Edit User Account Record");
       System.out.println();
       System.out.println("Please enter the user you wish to edit:");
       username = keyboardInput.nextLine();
       System.out.println("Please enter NEW password");
       password = keyboardInput.nextLine();
       System.out.println("Please enter NEW email:");
       email = keyboardInput.nextLine();

       success = objUserAccount.edit(username, password, email);
       if (success){
         System.out.println();
         System.out.println("User Account modified");  
     }
     else {
         System.out.println();
         System.out.println("User not found!");
     }
    }
    
    public static void removeUserAccountRecord() throws Exception{
        Scanner keyboardInput = new Scanner(System.in);
        String username, password, email;
        boolean success;
        
        System.out.println("Delete User Account");
        System.out.println();
        System.out.println("Please enter the username you wish to delete");
        username = keyboardInput.nextLine();
        
        success = objUserAccount.remove(username);
        if (success){
         System.out.println();
         System.out.println("User Account removed");  
     }
     else {
         System.out.println();
         System.out.println("User not found!");
     }
}
    
    public static void removeEmployeeRecord() throws Exception{
        Scanner keyboardInput = new Scanner(System.in);
        String SSNumber;
        boolean success;
        
        System.out.println("Delete Employee Record");
        System.out.println();
        System.out.println("Please enter the social security number of the Employee you wish to delete");
        SSNumber = keyboardInput.nextLine();
        
        success = objEmployee.remove(SSNumber);
        if (success){
         System.out.println();
         
         System.out.println("Employee removed");  
     }
     else {
         System.out.println();
         System.out.println("Employee not found!");
     }
}
    
    public static void printEmployee() throws Exception{ 
        try { 
        Scanner keyboardInput = new Scanner(System.in); 
        String SSNumber; 
        boolean success; 
        System.out.println("Print Employee Screen ");
        System.out.println("Please enter the Social Security Number of the Employee you wish to Print"); 
        SSNumber = keyboardInput.nextLine(); 

        success = objEmployee.print(SSNumber); 
        if (!success) { 
            System.out.println(); 
        System.out.println("Employee not found!"); 
        
        }
        else {
            System.out.println(); 
            System.out.println("Please check Homework5/PresentationUI/NetworkPrinter.txt for your employee results");
            System.out.println(); 
        }
        } 
     
        catch (Exception objE) { 
                System.out.println(objE.toString()); 
        }
    }

    public static void printAll() throws Exception{ 
        try { 

            System.out.println("Print all Employees"); 
            System.out.println();  
            objEmployee.printAll();
            System.out.println(); 
            System.out.println("Please check Homework5/PresentationUI/NetworkPrinter.txt for your employee results"); 
            System.out.println(); 
        } 
        catch (Exception objE) { 

            System.out.println(objE.toString()); 
        } 
    }

    
    public static void changeUsername() throws Exception{
        Scanner keyboardInput = new Scanner(System.in);
        String username;
        boolean success;
        System.out.println("Change username");
        System.out.println();
        System.out.println("Please enter the username you wish to change");
        username = keyboardInput.nextLine();
        
        success = objUserAccount.changeUsername(username, username);
        if (success){
         System.out.println();
         System.out.println("Your username has been changed!");  
     }
     else {
         System.out.println();
         System.out.println("User not found!");
    }
    }
    
    public static void changePassword() throws Exception{
        Scanner keyboardInput = new Scanner(System.in);
        String username, password;
        boolean success;
        System.out.println("Change password");
        System.out.println();
        System.out.println("Please enter your username");
        username = keyboardInput.nextLine();
        System.out.println("Please enter your NEW password");
        password = keyboardInput.nextLine();
        
        
        success = objUserAccount.changePassword(username, password);
        if (success){
         System.out.println();
         System.out.println("Your password has been changed!");  
     }
     else {
         System.out.println();
         System.out.println("User not found!");
    }
    }
    
    public static void changeEmail() throws Exception{
        Scanner keyboardInput = new Scanner(System.in);
        String username, email;
        boolean success;
        System.out.println("Change email");
        System.out.println();
        System.out.println("Please enter your username");
        username = keyboardInput.nextLine();
        System.out.println("Please enter your NEW password");
        email = keyboardInput.nextLine();
        
        
        success = objUserAccount.changeEmail(username, email);
        if (success){
         System.out.println();
         System.out.println("Your email has been changed!");  
     }
     else {
         System.out.println();
         System.out.println("User not found!");
    }
    }
     
    public static int RetailPointOfSalesScreen() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Retail Point-Of-Sales Portal!" );
         System.out.println( );
         System.out.println("1. Car Rental");
         System.out.println("2. Car Return");
         System.out.println("3. Customer Management");
         System.out.println("0. Exit (return to main screen)");
         System.out.println( );
         System.out.println("Please select a menu option (1, 2, 3 or 0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
    }
    public static void startRetailPointOfSales() throws Exception {
        int option;
        
        option = RetailPointOfSalesScreen();
        while (option != 0){
            switch (option)
            {
                case 1:
                    CarRental();
                    break;
                case 2:
                    CarReturn();
                    break;
                case 3:
                    startCustomerScreen();
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
                    System.out.println();
                    break;
            }
            option = RetailPointOfSalesScreen();
        }
      System.out.println("Exiting Retail Point-Of-Sales.....");
      System.out.println();
    }
    
    public static void startCarRental() throws Exception {
        int option;
        
        option = CarRental();
        while (option != 0){
            switch (option)
            {
                case 1:
                    System.out.println("This page is under construction");
                    System.out.println();
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
                    System.out.println();
                    break;
            }
            option = CarReturn();
        }
        
        }
    
    public static int CarRental() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Car Rental Portal!" );
         System.out.println( );
         System.out.println("this page is under construction.");
         System.out.println("0. Exit (return to Retail Point-Of-Sales)");
         System.out.println( );
         System.out.println("Please select a menu option (0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
    }
    
    public static void startCarReturn() throws Exception {
        int option;
        
        option = CarReturn();
        while (option != 0){
            switch (option)
            {
                case 1:
                    System.out.println("This page is under construction");
                    System.out.println();
                    break;
                default:
                    System.out.println("Incorrect entry, please try again");
                    System.out.println();
                    break;
            }
            option = CarReturn();
        }
        
        }
    
    public static int CarReturn() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Car Return Portal!" );
         System.out.println( );
         System.out.println("This page is under construction.");
         System.out.println("0. Exit (return to Retail Point-Of-Sales)");
         System.out.println( );
         System.out.println("Please select a menu option (0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
    }
    
    public static int customerManagement() {
        Scanner keyboardInput = new Scanner(System.in);
        int option;
        System.out.println("Welcome to the Customer Management Portal" );
         System.out.println( );
         System.out.println("1. Search Customer Information");
         System.out.println("2. Register Customer");
         System.out.println("3. Edit Customer");
         System.out.println("4. Remove Customer");
         System.out.println("5. Print Customer");
         System.out.println("0. Exit (return to Retail Point-Of-Sales)");
         System.out.println( );
         System.out.println("Please select a menu option (1, 2, 3, 4, 5 or 0)");
         System.out.println( );
         option = keyboardInput.nextInt();
         System.out.println();
         return option;
}
    
    public static void startCustomerScreen() throws Exception{
        int option;

        option = customerManagement();
        while (option !=0) {
            switch (option)
            {
                case 1:
                    searchCustomer();
                    break;
                case 2:
                    registerCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:
                    removeCustomer();
                    break;
                case 5:
                    printCustomer();
                    break;
                    
                default:
                    System.out.println("Incorrect entry, please try again");
                    break;
            }
        
        option = customerManagement();
        }
        System.out.print("Exiting Customer Management...");
        

    }
    
    public static void searchCustomer() throws UnsupportedOperationException{
        
    String idNumber;
    Scanner keyboardInput = new Scanner(System.in);
    
         
         

        System.out.println("Search Customer Screen"); 

        System.out.println("Please enter Customer ID number"); 
        idNumber = keyboardInput.nextLine(); 
        Customer objCustomer;
        objCustomer = new Customer();
        objCustomer.load();
         
        if(objCustomer!= null) { 
        System.out.println();
        System.out.println("The customer's information: "); 
        System.out.println("Customer ID Number = " + objCustomer.getidNumber());
         
        System.out.println("Customer Name = " + objCustomer.getfirstName());
        System.out.println("Customer Birthdate = " + objCustomer.getDateOfBirth()); 
        System.out.println("Customer Address = " + objCustomer.getaddress()); 
        System.out.println("Customer Phone = " + objCustomer.getphone()); 
    }
    
    else {  
            System.out.println(); 
            System.out.println("Customer not found!"); 
        } 
     
    
    
        
    }
    
    
    public static void registerCustomer() throws UnsupportedOperationException {
        
     Scanner keyboardInput = new Scanner(System.in);
     String IDNumber, firstname, lastname, DateOfBirth, address, phone, email;
     boolean success;
     
     System.out.println("Register new Customer!");
     System.out.println();
     System.out.println("Please enter ID Number:");
     IDNumber = keyboardInput.nextLine();
     System.out.println("Please enter first name:");
     firstname = keyboardInput.nextLine();
     System.out.println("Please enter last name:");
     lastname = keyboardInput.nextLine();
     System.out.println("Please enter date of birth:");
     DateOfBirth = keyboardInput.nextLine();
     System.out.println("Please enter address:");
     address = keyboardInput.nextLine();
     System.out.println("Please enter phone number:");
     phone = keyboardInput.nextLine();
     System.out.println("Please enter email:");
     email = keyboardInput.nextLine();
    
     
     Customer tempCustomer;
     tempCustomer = new Customer();
     tempCustomer.insert();
     
    
     
     
    }
     
    
    public static void editCustomer() throws UnsupportedOperationException{
        
       Scanner keyboardInput = new Scanner(System.in);
       String idNumber, firstname, lastname, DOB, address, phone, email;
       boolean success;
       System.out.println("Edit Customer Record");
       System.out.println();
       System.out.println("Please enter the ID Number of the Employee you wish to edit:");
       idNumber = keyboardInput.nextLine();
       System.out.println("Please enter NEW first name");
       firstname = keyboardInput.nextLine();
       System.out.println("Please enter NEW last name:");
       lastname = keyboardInput.nextLine();
       System.out.println("Please enter NEW date of birth:");
       DOB = keyboardInput.nextLine();
       System.out.println("Please enter NEW address:");
       address = keyboardInput.nextLine();
       System.out.println("Please enter NEW phone number:");
       phone = keyboardInput.nextLine();
       System.out.println("Please enter NEW email:");
       email = keyboardInput.nextLine();
       Customer tempCustomer;
       tempCustomer = new Customer();
       tempCustomer.setfirstName(firstname);
       tempCustomer.setlastName(lastname);
       tempCustomer.setDateOfBirth(DOB);
       tempCustomer.setaddress(address);
       tempCustomer.setphone(phone);
       tempCustomer.setemail(email);
       tempCustomer.update();
        
    }
    
    public static void removeCustomer() throws UnsupportedOperationException{
        
        Scanner keyboardInput = new Scanner(System.in);
        String idNumber;
        System.out.println("Remove Customer");
        System.out.println();
        System.out.println("Please enter the ID number of the Customer you wish to delete");
        idNumber = keyboardInput.nextLine();
        Customer tempCustomer;
        tempCustomer = new Customer();
        tempCustomer.getidNumber();
        tempCustomer.delete();
        
    }
    
    public static void printCustomer() throws Exception{ 
        
        Scanner keyboardInput = new Scanner(System.in); 
        String idNumber; 
        boolean success; 
        System.out.println("Print Customer Screen ");
        System.out.println("Please enter the ID Number of the Employee you wish to Print"); 
        idNumber = keyboardInput.nextLine(); 
        Customer tempCustomer;
        tempCustomer = new Customer();
        tempCustomer.load();
        success = tempCustomer.getidNumber().equals(idNumber);
        tempCustomer.print(); 
        if (success) { 
            System.out.println(); 
        System.out.println("customer records orinted successfully"); 
        
        }
       
    }

    public static void startApplication() throws Exception {
        int option;
        option = mainMenuScreen();
                    while (option !=0) {
            switch (option)
            {
                case 1: 
                    startBackEndManagement();
                    break;
                case 2:
                    startRetailPointOfSales();
                    break;
                    
                    default:
                        System.out.println("Incorrect input, please try again");
                        break;
            }
            option = mainMenuScreen(); }
                    System.out.println( );
    }
    public static void main(String[] args) throws Exception {
//         String username;
//         String password;
//         
//         
//         
//         System.out.println("Welcome to the authentication portal!" );
//         System.out.println( );
//		Scanner keyboardInput = new Scanner(System.in);
//       		System.out.println("Please enter username:" );
//        	username = keyboardInput.nextLine();
//                System.out.println( );
//        	System.out.println("Please enter password:" );
//        	password = keyboardInput.nextLine();
//                System.out.println( );
//          while ( !username.equals("-1") || !password.equals("-1") ){ 
//
//                    if (Authenticate(username, password)){ 
//                    System.out.println( );
//                    
                    startApplication();
//                    
//                    
//                    }
//                    
//                    else {
//                    System.out.println( );
//                    System.out.println("Access denied");
//                    System.out.println( );}
//                    
//                System.out.println("Please enter username:" );
//        	username = keyboardInput.nextLine();
//                System.out.println( );
//        	System.out.println("Please enter password:" );
//        	password = keyboardInput.nextLine(); 
//                System.out.println( );
//                   
//          }
//        System.out.println("Exiting program..") ;
    }
    }
   