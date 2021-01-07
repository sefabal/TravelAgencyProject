package com.travel.travel.controller;

import com.travel.travel.entity.Customer;
import com.travel.travel.repository.CustomerRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class CustomerControllerTest {

    @Test
    public void testHome() throws Exception {
        ArrayList<Customer> customers = createCustomerList(10);
        CustomerRepository mockRepo = mock(CustomerRepository.class);
        when(mockRepo.findAll()).thenReturn(customers);
        //CustomerController customerController = new CustomerController();
        //MockMvc mockMvc = standaloneSetup(customerController).build();
    }

    private ArrayList<Customer> createCustomerList(int i) {
        ArrayList<Customer> customerList = new ArrayList<>();

        for (int j = 0; j < i ; j++) {
            customerList.add(new Customer()) ;
        }

        return customerList;
    }
}
