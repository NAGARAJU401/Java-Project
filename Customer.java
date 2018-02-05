package homeAPP;
//package : Package is name that organizes a set of related classes and interfaces similar to 
//different folders on my computer


	import java.util.*;
	//import : we use import keyword to access the packages.
	//java.util.scanner : util is ready made package under the main package Java,so we import a pacakge 
	//when we need to use some classes belonging to that package in current program

	public class Customer
	//declares a class called Customer
	{

	    /*Customer should know about his
	    customerID ,customerName, contactNumber */

	    int customerID;
		String customerName;
	    String contactNumber;
	    
	    public int getCustomerID() { //applying getters and setters
			return customerID;
		}


		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}


		public String getCustomerName() {
			return customerName;
		}


		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}


		public String getContactNumber() {
			return contactNumber;
		}


		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}


	    List <Product>bookedProductList;
	    
	    
	    public Customer (int custID,String name,String contactNo) 
	    /*The Constructor creates Customer object  with the given id, name &  contact no*/
	    {
	       customerID  = custID;
	       customerName = name;
	       contactNumber = contactNo;
	       bookedProductList = new ArrayList<Product>();
	    }
	    
	    
	    public Customer() {
		
		}


		
	    public void addBookedProduct(Product product)
	    /* Public void addBookedProduct(Product product) :The method adds the product which is booked by the customer to
	     his bookedProductList. */
	    {
	        bookedProductList.add(product);
	    }
	    


}
