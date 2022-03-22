package Assignment2;

import javax.persistence.EntityManager;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Address;
import com.Customer;

public class Library {
    public boolean someLibraryMethod() {
        return true;
    }
    public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerPU");
		EntityManager entitymanager = emf.createEntityManager();
		Address add = new Address();
		add.setCustomerAddress("175 pancaker street");
		
		
		Customer custo = new Customer();
	    custo.setCustomerName("Siddartha Gurugubelli");
	    custo.setCustomerEmail("18131A04i6@gvpce.ac.in");
	    custo.setCustomerAddress(add);
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(custo);
		entitymanager.flush();
		entitymanager.getTransaction().commit();
		
		Customer mycustomer = entitymanager.find(Customer.class, "Siddartha Gurugubelli");
		System.out.println(mycustomer.getCustomerName());
		System.out.println(mycustomer.getCustomerEmail());
		System.out.println(mycustomer.getCustomerAddress());
		
		
	}
}
