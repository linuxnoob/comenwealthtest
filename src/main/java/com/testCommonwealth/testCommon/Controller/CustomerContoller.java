package com.testCommonwealth.testCommon.Controller;

import com.testCommonwealth.testCommon.Entity.Customer;
import com.testCommonwealth.testCommon.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
        return customerService.deleteCustomer(id);
    }


    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }


    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer product) {
        return customerService.updateCustomer(product);
    }

    @RequestMapping(path = "/getCustByName", method = RequestMethod.GET)
    public List<Customer>  getCustByName(@RequestParam("name") String name){return customerService.getCustomerByName(name);}

    @RequestMapping(path = "/deleteCustByUpdate", method = RequestMethod.POST)
    public Customer deleteCustByUpdate(@RequestParam ("isActive") Boolean isActive, @RequestParam("id") Integer id){
        return customerService.deleteCustByUpdate(isActive, id);
    }

    @RequestMapping(path = "/updateListCust", method = RequestMethod.POST)
    public List<Customer> updateCustList(@RequestBody List<Customer> customerList) throws SQLException {
        return customerService.updateProductList(customerList);
    }


}
