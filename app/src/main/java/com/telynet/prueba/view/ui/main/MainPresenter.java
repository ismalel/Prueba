package com.telynet.prueba.view.ui.main;

import android.content.Context;

import com.telynet.prueba.data.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    MainContract.Interactor interactor;

    public MainPresenter(MainContract.View view){
        this.view = view;
        interactor = new MainInteractor(this);
    }
    @Override
    public void getCustomers() {
        interactor.fetchCustomers();
    }

    @Override
    public void getCustomerSortedByCode() {
        interactor.fetchCustomersCode();
    }

    @Override
    public void getCustomerSortedByName() {
        interactor.fetchCustomersName();
    }

    @Override
    public void getCustomerVisited() {
        interactor.fetchCustomersVisited();
    }

    @Override
    public void getCustomerNotVisited() {
        interactor.fetchCustomersNotVisited();
    }

    @Override
    public void onSetCustomers(List<Customer> customers) {
        view.showCustomerList(customers);
    }

    @Override
    public void onSetCustomersCode(List<Customer> customers) {
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return Integer.valueOf(o1.getCode()).compareTo(o2.getCode());
            }
        });
        view.showCustomerList(customers);
    }

    @Override
    public void onSetCustomersName(List<Customer> customers) {
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        view.showCustomerList(customers);
    }

    @Override
    public void onSetCustomersVisited(List<Customer> customers) {
        List<Customer> visited = new ArrayList<>();

        for(Customer customer : customers){
            if(customer.isVisited()){
                visited.add(customer);
            }
        }
        view.showCustomerList(visited);
    }

    @Override
    public void onSetCustomersNotVisited(List<Customer> customers) {
        List<Customer> not_visited = new ArrayList<>();

        for(Customer customer : customers){
            if(!customer.isVisited()){
                not_visited.add(customer);
            }
        }
        view.showCustomerList(not_visited);
    }

    @Override
    public Context getAppContext() {
        return view.getAppContext();
    }
}
