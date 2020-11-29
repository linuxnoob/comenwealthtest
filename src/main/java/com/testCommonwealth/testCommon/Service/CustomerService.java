package com.testCommonwealth.testCommon.Service;

import com.testCommonwealth.testCommon.Entity.Customer;
import com.testCommonwealth.testCommon.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);

    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public List<Customer>  getCustomerByName(String name){
        return customerRepository.findByNameIgnoreContaining(name);
    }

    public String deleteProduct(Integer id) {
        customerRepository.deleteById(id);
        return "product berhasil dihapus !! " + id;
    }

    public Customer updateProduct(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setPhone(customer.getPhone());
        return customerRepository.save(existingCustomer);
    }


    public Customer saveProduct(Customer product) {
        return customerRepository.save(product);
    }



}
