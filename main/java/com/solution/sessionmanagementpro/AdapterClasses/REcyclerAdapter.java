package com.solution.sessionmanagementpro.AdapterClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solution.sessionmanagementpro.R;

import java.util.ArrayList;
import java.util.List;

public class REcyclerAdapter extends RecyclerView.Adapter<REcyclerAdapter.Myadapter>{

    Context context;
    List<String> emailadd=new ArrayList<>();
    List<String> pass =new ArrayList<>();
    REcyclerAdapter.Select select;

    public REcyclerAdapter(Context context, List<String> emailadd, List<String> pass, Select select) {
        this.context = context;
        this.emailadd = emailadd;
        this.pass = pass;
        this.select = select;
    }

    @NonNull
    @Override
    public Myadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.details,parent,false);
        return new REcyclerAdapter.Myadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter holder, int position) {
holder.tvemail.setText(emailadd.get(position));
holder.tvname.setText(pass.get(position));
    }

    @Override
    public int getItemCount() {
        return emailadd.size();
    }

    public class Myadapter extends RecyclerView.ViewHolder {
        TextView tvname,tvemail;
        public Myadapter(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.name);
            tvemail=itemView.findViewById(R.id.email);
        }
    }
    public interface Select{
        void click(int position,String email,String password);
    }
}
