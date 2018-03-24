package com.learning.jpa.app

import javax.validation.Valid

import com.learning.jpa.model.{Customer, CustomerRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RequestMethod, ResponseStatus, RestController}

import scala.collection.JavaConverters._


@RestController
@RequestMapping(Array("/api"))
class CustomerController @Autowired()(repository: CustomerRepository) {

  @RequestMapping(value = Array("/customers"), method = Array(RequestMethod.GET))
  def getAllCustomers(): java.util.List[Customer] = {
    repository.findAll()
  }

  @RequestMapping(value = Array("/customers"), method = Array(RequestMethod.POST))
  @ResponseStatus(HttpStatus.CREATED)
  def createCustomer(@RequestBody customer: Customer) = {
    println(s"Got customer: $customer")
    repository.save(customer)
  }

  @RequestMapping(value = Array("/customers/{id}"), method = Array(RequestMethod.GET))
  def getCustomerById(@PathVariable(value = "id") id: Long): Customer = {
    repository.findById(id).get()
  }

}
