package com.testCommonwealth.testCommon.Service;

import com.testCommonwealth.testCommon.Entity.Customer;
import com.testCommonwealth.testCommon.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLException;
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

    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Customer berhasil dihapus !! " + id;
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setActive(customer.getActive());
        return customerRepository.save(existingCustomer);
    }

    public List<Customer> updateProductList(List<Customer> customerList) throws SQLException {
        try {
            for (Customer customer1 :customerList){
                Customer customer = customerRepository.findById(customer1.getId()).orElse(null);
                customer.setActive(customer1.getActive());
                customer.setPhone(customer1.getPhone());
                customer.setName(customer1.getName());
                customerRepository.save(customer);
            }

        }catch (Exception e){
            System.out.println("Exeption updateProductList = " + e);
        }

        return customerList;
    }


    public Customer saveProduct(Customer product) {
        return customerRepository.save(product);
    }

    public Customer deleteCustByUpdate(Boolean isActive, Integer id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer!=null){
            customer.setActive(isActive);
            customerRepository.save(customer);
        }
        return customer;
    }

}
