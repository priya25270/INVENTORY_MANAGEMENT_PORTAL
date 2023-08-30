package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
@Autowired
public CustomerRepository crepo;
public String saveCust(CustomerModel c) {
	crepo.save(c);
	return"Customer data is saved to database";
}
public List<CustomerModel> getCustomer(){
	return crepo.findAll();
}
public CustomerModel updateCustomer(CustomerModel cm) {
	return crepo.saveAndFlush(cm);
}
public boolean updateCustomerif(int custId,CustomerModel cm) {
	if(crepo.existsById(custId)) {
		crepo.save(cm);
		return true;
	}
	return false;
}
public boolean deleteCustomer(int custId) {
	if(crepo.existsById(custId)) {
		crepo.deleteById(custId);
		return true;
	}
	return false;
}
public void deletecustomer(int cust_id) {
	System.out.println("Customer id deleted");
	crepo.deleteById(cust_id);
}
public int deleteRowByid(int id) {
	return crepo.deleteId(id);
}
public Optional<CustomerModel> getCustId(int custId){
	Optional<CustomerModel> customer=crepo.findById(custId);
	if(customer.isPresent()) {
		return customer;
	}
	return null;
}
//sort
public List<CustomerModel>sortByAsc(String custName)
{
	return crepo.findAll(Sort.by(custName).ascending()); 
}
public List<CustomerModel>sortByDsc(String custName){
	return crepo.findAll(Sort.by(custName).descending());
}

//pagination
public List<CustomerModel>pagination(int pageNum,int pageSize)
{
	Page<CustomerModel>cont=crepo.findAll(PageRequest.of(pageNum,pageSize));
	return cont.getContent();
}

//pagination and sorting
public List<CustomerModel>paginationAndSorting(int pageNum,int pageSize,String name)
{
	Page<CustomerModel>cont1=crepo.findAll(PageRequest.of(pageNum,pageSize,Sort.by(name)));
	return cont1.getContent();
}
public List<CustomerModel> getAllrows()
{
	return crepo.getAllrows();
}

}