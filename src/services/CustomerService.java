package services;

import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Management<Customer> {

    public static List<Customer> customerList = new ArrayList<>();

    static {
        initCustomer();
    }

    public static Customer initCustomer() {
        Customer customer = new Customer();
        customer.setIdCustomer(customerList.size() + 1);
        customer.setCitizenIdentificationCard("000000001");
        customerList.add(customer);
        return customer;
    }

    @Override
    public Customer findById(long id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer() == id) {
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void printList() {
        System.out.printf("%-20s%-30s%-30s%-18s%n", "Customer Id:", "CitizenIdentificationCard:", "Age:", "Phone Number:");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(customerList.get(i));
        }
    }

    @Override
    public void updateById(long id, Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer() == id) {
                customerList.get(i).setCitizenIdentificationCard(customer.getCitizenIdentificationCard());
                break;
            }
        }
    }

    @Override
    public void add(Customer customer) {
        customer.setIdCustomer(customerList.size() + 1);
        customerList.add(customer);
    }

    @Override
    public void delete(long id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getIdCustomer() == id) {
                customerList.remove(i);
                return;
            }
        }
    }
}
