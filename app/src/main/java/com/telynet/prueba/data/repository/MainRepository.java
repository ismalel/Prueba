package com.telynet.prueba.data.repository;

import com.telynet.prueba.data.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {

    private List<Customer> customers = new ArrayList<>();

    public MainRepository(){
        customers.add(new Customer(11194,"Ismael Ochoa Miranda","5554672994","ochoa.ismael@gmail.com",true));
        customers.add(new Customer(11145,"Antonio Jesus Mesa","2026867162","ajm@gmail.com",true));
        customers.add(new Customer(11123,"Vanesa Dueñas","8135138874","vduenas@gmail.com",false));
        customers.add(new Customer(11176,"German Rodriguez","8017601387","grodriguez@gmail.com",true));
        customers.add(new Customer(11167,"Joaquin Perez","3037656567","jperez@gmail.com",false));
        customers.add(new Customer(11110,"Ramira Castro","2542277188","rcastro@gmail.com",true));
        customers.add(new Customer(11143,"Valentina Camacho","7158933732","vcamacho@gmail.com",true));
        customers.add(new Customer(11191,"Daniel Lopez","4804368687","dlopez@gmail.com",true));
        customers.add(new Customer(11187,"Javiera Casas","8568259157","jcasas@gmail.com",true));
        customers.add(new Customer(11154,"Vincente Barajas","3074691961","vbarajas@gmail.com",true));
        customers.add(new Customer(11175,"Juan Guiza","5182299215","jguiza@gmail.com",false));
        customers.add(new Customer(11161,"Lourdes Maya","6012929356","lmaya@gmail.com",true));
        customers.add(new Customer(11185,"Pedro Piedra","4175618545","ppiedra@gmail.com",false));
        customers.add(new Customer(11128,"Enrique Guzman","55713579581","eguzman@gmail.com",true));

    }
    public List<Customer> getCustomers(){
        return this.customers;
    }
}
