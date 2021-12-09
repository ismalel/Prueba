package com.telynet.prueba.view.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.telynet.prueba.R;
import com.telynet.prueba.data.entity.Customer;
import com.telynet.prueba.databinding.ActivityMainBinding;
import com.telynet.prueba.view.adapter.MainViewAdapter;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, MainViewAdapter.ItemClickListener {

    ActivityMainBinding binding;
    MainContract.Presenter presenter;
    MainViewAdapter adapter;
    LinearLayoutManager llmVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        llmVertical = new LinearLayoutManager(this);


        presenter = new MainPresenter(this);
        presenter.getCustomers();

        binding.btnSortByCode.setOnClickListener(v -> {
            presenter.getCustomerSortedByCode();
        });
        binding.btnSortByName.setOnClickListener(v ->{
            presenter.getCustomerSortedByName();
        });
        binding.btnFilterVisited.setOnClickListener(v ->{
            presenter.getCustomerVisited();
        });
        binding.btnFilterNotVisited.setOnClickListener(v ->{
            presenter.getCustomerNotVisited();
        });

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCustomerList(List<Customer> customers) {
        binding.rvCustomers.setLayoutManager(llmVertical);
        adapter = new MainViewAdapter(this,customers);
        adapter.setClickListener(this);
        binding.rvCustomers.setAdapter(adapter);
    }

    @Override
    public void showCustomerName(List<Customer> customers) {
        adapter = new MainViewAdapter(this,customers);
        adapter.setClickListener(this);
        binding.rvCustomers.setAdapter(adapter);
    }

    @Override
    public Context getAppContext() {
        return this.getApplicationContext();
    }

    @Override
    public void onItemClick(View view, int position) {
        TextView v = view.findViewById(R.id.tvPhone);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+v.getText().toString()));
        startActivity(intent);
    }
}