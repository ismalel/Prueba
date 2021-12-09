package com.telynet.prueba.view.ui.main;

import com.telynet.prueba.data.repository.MainRepository;

public class MainInteractor implements MainContract.Interactor{

    private MainContract.Presenter presenter;
    MainRepository repository;

    public MainInteractor(MainContract.Presenter presenter){
        this.presenter = presenter;
        repository = new MainRepository();
    }

    @Override
    public void fetchCustomers() {
        presenter.onSetCustomers(repository.getCustomers());
    }

    @Override
    public void fetchCustomersCode() {
        presenter.onSetCustomersCode(repository.getCustomers());
    }

    @Override
    public void fetchCustomersName() {
        presenter.onSetCustomersName(repository.getCustomers());
    }

    @Override
    public void fetchCustomersVisited() {
        presenter.onSetCustomersVisited(repository.getCustomers());
    }

    @Override
    public void fetchCustomersNotVisited() {
        presenter.onSetCustomersNotVisited(repository.getCustomers());
    }
}
