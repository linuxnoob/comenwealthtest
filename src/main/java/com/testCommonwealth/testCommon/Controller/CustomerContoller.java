package com.testCommonwealth.testCommon.Controller;

import com.testCommonwealth.testCommon.Entity.Customer;
import com.testCommonwealth.testCommon.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerContoller {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAllProducts() {
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteProduct(id);
    }


    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer product) {
        return customerService.saveProduct(product);
    }


    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer product) {
        return customerService.updateProduct(product);
    }

    @RequestMapping(path = "/getCustByName", method = RequestMethod.GET)
    public List<Customer>  getCustByName(@RequestParam("name") String name){return customerService.getCustomerByName(name);}



}
