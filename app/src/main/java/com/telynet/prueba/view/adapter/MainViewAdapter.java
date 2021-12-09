package com.telynet.prueba.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.telynet.prueba.R;
import com.telynet.prueba.data.entity.Customer;

import java.util.List;

public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.ViewHolder> {

    private List<Customer> customers;
    private LayoutInflater inflater;
    private ItemClickListener listener;

    public MainViewAdapter(Context context, List<Customer> customers){
        this.inflater = LayoutInflater.from(context);
        this.customers = customers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customer_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_code.setText(String.valueOf(customers.get(position).getCode()));
        holder.tv_name.setText(customers.get(position).getName());
        holder.tv_phone.setText(customers.get(position).getPhone());
        holder.tv_email.setText(customers.get(position).getEmail());
        if(customers.get(position).isVisited()){
            holder.tv_visited.setText(R.string.filter_visited);
            holder.rl_visited.setBackgroundColor(holder.itemView.getResources().getColor(R.color.green));
        }else{
            holder.tv_visited.setText(R.string.filter_not_visited);
            holder.rl_visited.setBackgroundColor(holder.itemView.getResources().getColor(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_code;
        TextView tv_name;
        TextView tv_phone;
        TextView tv_email;
        TextView tv_visited;
        RelativeLayout rl_visited;

        ViewHolder(View view){
            super(view);
            tv_code = view.findViewById(R.id.tvCode);
            tv_name = view.findViewById(R.id.tvName);
            tv_phone = view.findViewById(R.id.tvPhone);
            tv_email = view.findViewById(R.id.tvEmail);
            tv_visited = view.findViewById(R.id.tvVisited);
            rl_visited = view.findViewById(R.id.rlVisited);
            tv_phone.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            if(listener != null){
                listener.onItemClick(v, getAbsoluteAdapterPosition());
            }
        }
    }
    public List<Customer> getCustomers(){
        return this.customers;
    }

    public void setClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
