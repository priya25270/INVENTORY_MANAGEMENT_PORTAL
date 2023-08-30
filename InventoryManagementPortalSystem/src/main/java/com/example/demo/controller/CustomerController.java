package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController{
@Autowired
public CustomerService cserv;
@PostMapping("/postCustomer")
public String postCustomer(@RequestBody CustomerModel cm) {
	cserv.saveCust(cm);
	return"Customer data saved";
}
@GetMapping("/getCustomer")
public List<CustomerModel> getCustomerInfo(){
	return cserv.getCustomer();
}

@GetMapping("/custs/{custId}")
public ResponseEntity<?>getCustbyId(@PathVariable int custId){
	Optional<CustomerModel>customer=cserv.getCustId(custId);
	if(customer!=null) {
		return ResponseEntity.ok(customer);
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not available with custid "+custId);
}
@GetMapping("/getAllrows")
public List<CustomerModel> getAllrows()
{
	 return cserv.getAllrows();
}
@PutMapping("/updateCustomer")
public CustomerModel updatecustomer(@RequestBody CustomerModel ca) {
	return cserv.updateCustomer(ca);
}
@PutMapping("/updateCustomers/{id}")
public ResponseEntity<String>putCustomer(@PathVariable int id,@RequestBody CustomerModel ca){
	boolean updated=cserv.updateCustomerif(id,ca);
	if(updated) {
		return ResponseEntity.ok("Customer details with custid "+ id +" is updated successfully");
	}
	else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not exists with custid: "+id);
	}
}
@DeleteMapping("/deleteCustomer/{id}")
public String removeCustomer(@PathVariable("id") int cid) {
	cserv.deletecustomer(cid);
	return "Customer with custId "+cid+" is deleted successfully";
}
@DeleteMapping("/byReqPam")
public String removeByRequestParameter(@RequestParam("id") int id) {
	cserv.deletecustomer(id);
	return "Customer with custid "+id+" is deleted successfully";
}
@DeleteMapping("/deleteCustomers/{id}")
public ResponseEntity<String>deleteCustomer(@PathVariable int id){
	boolean delete=cserv.deleteCustomer(id);
	if(delete) {
		return ResponseEntity.ok("Customer with cust_id "+id+" id deleted");
	}
	else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with custid "+id+" does not exists");
	}
}
@DeleteMapping("/deleteCustomerss/{id}")
public String deleteRow(@PathVariable("id") int id) {
	 return cserv.deleteRowByid(id)+" id deleted";
}
@GetMapping("/sortAsc/{name}")
public List<CustomerModel>sortasc(@PathVariable("name") String custName)
{
	   return cserv.sortByAsc(custName);
}
@GetMapping("/sortDsc/{name}")
public List<CustomerModel>sortdsc(@PathVariable("name") String custName)
{
	   return cserv.sortByDsc(custName);
}
//Pagination

@GetMapping("/pagination/{num}/{size}")
public List<CustomerModel>paginationEx(@PathVariable("num")int num,@PathVariable("size")int size)
{
	   return cserv.pagination(num, size);
}
//Pagination and Sorting
@GetMapping("/pagination/{num}/{size}/{name}")
public List<CustomerModel> paginationAndSorting(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String shopName){
	return cserv.paginationAndSorting(num, size,shopName);
}
}