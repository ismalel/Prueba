package com.telynet.prueba.view.ui.main;

import android.content.Context;

import com.telynet.prueba.data.entity.Customer;

import java.util.List;

public interface MainContract {

    interface View{
        void showMessage(String message);
        void showCustomerList(List<Customer> customers);
        void showCustomerName(List<Customer> customers);
        Context getAppContext();
    }

    interface Presenter{
        void getCustomers();
        void getCustomerSortedByCode();
        void getCustomerSortedByName();
        void getCustomerVisited();
        void getCustomerNotVisited();
        void onSetCustomers(List<Customer> customers);
        void onSetCustomersCode(List<Customer> customers);
        void onSetCustomersName(List<Customer> customers);
        void onSetCustomersVisited(List<Customer> customers);
        void onSetCustomersNotVisited(List<Customer> customers);
        Context getAppContext();
    }

    interface Interactor{
        void fetchCustomers();
        void fetchCustomersCode();
        void fetchCustomersName();
        void fetchCustomersVisited();
        void fetchCustomersNotVisited();
    }
}
