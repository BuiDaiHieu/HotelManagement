package services;

import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Management<Customer> {

    public static List<Customer> customerList = new ArrayList<>();

    // Method to find customer information given ID
    @Override
    public Customer findById(long id) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    // Method to print the current list of customers
    @Override
    public void printList() {
        System.out.println("----------------------------------------------");
        System.out.printf("%-20s%-30s%-30s%-18s%n", "Customer Id:", "CitizenIdentificationCard:", "Age:", "Phone Number:");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("----------------------------------------------");
    }

    // Method for updating an existing ID with the ID of another customer
    @Override
    public void updateById(long id, Customer customer) {
        for (Customer value : customerList) {
            if (value.getCustomerId() == id) {
                value.setCitizenIdentificationCard(customer.getCitizenIdentificationCard());
                break;
            }
        }
    }

    //Method for adding customer to list
    @Override
    public void add(Customer customer) {
        customer.setCustomerId(customerList.size() + 1);
        customerList.add(customer);
    }

    // Method to delete customer from list
    @Override
    public void delete(long id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == id) {
                customerList.remove(i);
                return;
            }
        }
    }
}
