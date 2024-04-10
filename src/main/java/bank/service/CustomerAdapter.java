package bank.service;

import bank.domain.Customer;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        return customer;
    }
    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        CustomerDTO customerDto = new CustomerDTO();
        customerDto.setName(customer.getName());
        return customerDto;
    }
}
