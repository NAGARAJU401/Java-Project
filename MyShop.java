package homeAPP;
//package : Package is name that organizes a set of related classes and interfaces similar to 
//different folders on my computer

import java.util.*;
//import : we use import keyword to access the packages.
//java.util.scanner : util is ready made package under the main package Java,so we import a pacakge 
//when we need to use some classes belonging to that package in current program

public class MyShop{
	//public : members which can access as public,public members are visible to all other classes.
	//class : is a context of java that are used to create objects and to define object data types and methods.
	//declares a class called my shop
    public static RetailStore store;
    
     public static void main(String []args){
    	//Public is a keyword that is used as an access modifier for methods and variables.
    		//static used to prepare a field,method or inner classes as a class field.
    		//void: it is void if the method does not return a value.
    		//main:it is a function name When a program starts running, it has to start execution from somewhere.
    		//String[] args: it is  defining a String array to pass arguments at command line. args is the variable name of the String array.
    		
 
        System.out.println("Welcome to Spencer Home Appliances SHOP");
        
      //system : system is a class in java language.lang package
      		//out : out is the static member of system class.It's type PrintStream
      		//println: which is used to print the output.
      		//Inside the brackets is value which to be printed
      	
       
        
        
        store = new RetailStore("Spencer Home Appliances SHOP");
        
        /* stock the products in the store*/
        store.addProduct("SAMSUNG Television T222","",25000,12);
        store.addProduct("SAMSUNG Refrigerator R661","",35000,7);
        store.addProduct("SAMSUNG Micro Oven ","",3999,11);
        store.addProduct("OPPO A37","",90000,13);
        store.addProduct("MIXER GRINDER","",7000,25); 

        openShop(); /* open the shop*/
        
     }
     
    
    public static void openShop()
 
    {
        String custName = "";//creating the customer name with an empty value
        String prodName = "";//creating the customer id with an empty value
        int prodQuantityNeeded=0;
     //when we don't give any value then this will be equal to 0
        int prodQuantityAvailable=0;
        String custContact;
        int confirmBooking=0;
        Scanner reader = new Scanner(System.in); 
        // Reading from System.in
       
        List<String> menuList  = new ArrayList<String>();
        //Adding the products and these are the list of elements we have
        //and we created using array list
        menuList.add("SAMSUNG Television T222");
        menuList.add("SAMSUNG Refrigerator R661");
        menuList.add("SAMSUNG Micro Oven ");
        menuList.add("OPPO A37");
        menuList.add("MIXER GRINDER");
      
        
        int n=-1;
        // if we give the value -1
        //or 0 then it will show again the display options;
        while (n != 6)
       //if the value is not equal to 6 then it will clear screen
        {
            clearScreen();
        
            /* display menu options */
            
            System.out.println("\n\nPLEASE ENTER THE PRODUCT YOU WANT TO BOOK");
            System.out.println("\n\n");
            
            System.out.println("1. " + menuList.get(0) + " (" + store.checkProductAvailability(menuList.get(0)) + " )");
            System.out.println("2. " + menuList.get(1)+ " (" + store.checkProductAvailability(menuList.get(1)) + " )");
            System.out.println("3. " + menuList.get(2)+ " (" + store.checkProductAvailability(menuList.get(2)) + " )");
            System.out.println("4. " + menuList.get(3)+ " (" + store.checkProductAvailability(menuList.get(3)) + " )");
            System.out.println("5. " + menuList.get(4)+ " (" + store.checkProductAvailability(menuList.get(4)) + " )");
            System.out.println("6. CLOSE SHOP");
            System.out.println("\n\nPlease select product : ");
            n = reader.nextInt();
            
            if (n==6){
            	
                System.out.println("\n\n THANK YOU. GOOD BYE.");
                return;
            }
            
            if (n >=1 && n<=5)
         
            {
                prodName = menuList.get(n-1);
                System.out.println("\n\nProduct: " + prodName);
                System.out.println("\n\nProvide Customer Name: ");
                
                custName = readString();//it will read the string value
                
                System.out.println("\n\nProvide Customer Contact: ");
                
                custContact = readString();//reads the integer value
                
                System.out.println("\n\nProvide Quantity: ");
                prodQuantityNeeded = readInteger();
                
                int customerID = store.addCustomer(custName,String.valueOf(custContact));
                //when the id is given then we need add and show the name and contact of the customer
                
                /*print order*/
                clearScreen();
                System.out.println("\n\n\n\n\n\nDear customer " + custName );
                System.out.println("Your phone number is " + custContact);
                System.out.println("Your ordered " + prodQuantityNeeded + " of " + prodName );
                //checks the availability of the customer
                prodQuantityAvailable =
                                store.checkProductAvailability(menuList.get(n-1));
                
                System.out.println("\n\nAvailable Quantity: " + prodQuantityAvailable);
                
 /*once the product availability is checked then we see the product quantity which starts from 0 and products 
   customer asked. We need to verify whether the no.of products availability is greater then needed.
   if it is we have the customer id and add then  in booked list              
  */
                Product p;
                for (int i=0,TotalProdAddedToCustList=0;i<store.productList.size();i++)
                {
                    p= store.productList.get(i);
                    if (p.productName == prodName)
                    {
                        TotalProdAddedToCustList++;
                        if (TotalProdAddedToCustList <= prodQuantityAvailable && TotalProdAddedToCustList<=prodQuantityNeeded )
                            (store.getCustomer(customerID)).bookedProductList.add(p);
                    }
                }
                //here we will calculate the net amount of the product
                double netAmnt = store.calculateNetAmount(customerID,10);
                
                /*System.out.println("\n\nNet Amount:" + netAmnt);*/
                System.out.println("\n\nConfirm Booking: 1=Yes,0=No:");
             //confirmation will be don with reading integer   
                confirmBooking = readInteger();
                if (confirmBooking == 1)
                	//if booking is equal to 1 then need is equal to availability then id,product name and availability 
                	//should be checked else only values will be printed
                {
                    if (prodQuantityNeeded >= prodQuantityAvailable)
                        store.bookProduct(customerID,prodName,prodQuantityAvailable);
                    else
                        store.bookProduct(customerID,prodName,prodQuantityNeeded);
//once the booking is completed it will print print statements
                    System.out.print("\n\nThank you for booking");
                    System.out.print("\n\nContinue");
                    
                    String s = reader.nextLine();
                    //reads the next line
                }
                if (confirmBooking == 0)
                	//if we are not booking also we will have same statements
                {
                    System.out.print("\n\nThank you. Visit Again");
                    System.out.print("\n\nContinue");
                    String s = reader.nextLine();
                }
                
             
                
            } 
        }
    }
    
    
    /* clears the console*/
    public static void clearScreen() {    
          //  System.out.print("\f");  
          //  System.out.flush();  
    }//end clearScreen

    /* read the string*/
    public static String readString() {  
                String str="";
                Scanner reader = new Scanner(System.in);  
                // Reading from System.in
             
                
                       str = reader.nextLine();
                       if (str.length() >0);
                    	   return str;
                       
                    	 
               
        }
    
 
    public static int readInteger() {  
                int number=-1;
               //initializing the values with -1 
                Scanner reader = new Scanner(System.in); 
             
                // Reading from System.in
               
  
                       number  = reader.nextInt();

                       if (number>0);
  //if number is greater than equal to 0 then the line is true
                      
                
                return number;
                //returns the value
        }

}
