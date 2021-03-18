package com.solution.sessionmanagementpro.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.solution.sessionmanagementpro.AdapterClasses.REcyclerAdapter;
import com.solution.sessionmanagementpro.MainActivity;
import com.solution.sessionmanagementpro.R;
import com.solution.sessionmanagementpro.utils.App;
import com.solution.sessionmanagementpro.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Button Logoutbutton;


    List<String> emailadd=new ArrayList<>();
    List<String> pass =new ArrayList<>();
    REcyclerAdapter rEcyclerAdapter;
    RecyclerView recycler;
    private String name, email;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
recycler=findViewById(R.id.recycler);
        Logoutbutton=findViewById(R.id.Logoutbutton);

//        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//
//        String name=sharedPreferences.getString(KEY_NAME,null);
//        String email=sharedPreferences.getString(KEY_EMAIL,null);
//        if(name !=null || email !=null)
//        {
//            tvname.setText("Full Name:"+name);
//            tvemail.setText("Email is:"+email);
//        }
         sharedpreferences = getSharedPreferences("surbhi", Context.MODE_PRIVATE);

        String size=sharedpreferences.getString(Constants.SIZE,null);
//        String size = App.getSharedpref().getString("size");
        int size2 = Integer.valueOf(size);
        Toast.makeText(this, "Number of list" + size, Toast.LENGTH_SHORT).show();
        for (int i = 0; i <= size2; i++) {
            emailadd.add(sharedpreferences.getString(Constants.USER_EMAIL + i,"null"));
            pass.add(sharedpreferences.getString(Constants.USER_PASSWORD + i,"null"));
        }

        rEcyclerAdapter = new REcyclerAdapter(this, emailadd, pass, new REcyclerAdapter.Select() {
            @Override
            public void click(int position, String email, String password) {
//
//                name = App.getSharedpref().getString(Constants.USER_EMAIL );
//                email = App.getSharedpref().getString(Constants.USER_PASSWORD);
//
//                emailadd.add(name);
//                pass.add(email);

            }
        });
        recycler.setAdapter(rEcyclerAdapter);


        Logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Constants.LOGIN,"0");
                editor.commit();
                Toast.makeText(HomeActivity.this, "Logout Succeessfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        });}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "please logout", Toast.LENGTH_SHORT).show();
    }
}