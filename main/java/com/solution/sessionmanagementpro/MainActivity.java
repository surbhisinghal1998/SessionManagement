package com.solution.sessionmanagementpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.solution.sessionmanagementpro.activities.HomeActivity;
import com.solution.sessionmanagementpro.utils.App;
import com.solution.sessionmanagementpro.utils.Constants;

public class MainActivity extends AppCompatActivity {
    EditText emailedit, nameedit;
    Button submitbutton;


    SharedPreferences sharedpreferences;
    // SharedPreferences sharedPreferences;

    //    private static final String SHARED_PREF_NAME="surbhi";
//    private static final String KEY_NAME="name";
//    private static final String KEY_EMAIL="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailedit = findViewById(R.id.emailedit);
        nameedit = findViewById(R.id.nameedit);
        submitbutton = findViewById(R.id.submitbutton);


         sharedpreferences = getSharedPreferences("surbhi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        if(sharedpreferences.getString(Constants.LOGIN,null)==null || sharedpreferences.getString(Constants.LOGIN,null).equalsIgnoreCase("0") ){

        }else{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        // sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.putString(KEY_NAME,nameedit.getText().toString());
//                editor.putString(KEY_EMAIL,emailedit.getText().toString());
//                editor.apply();

                // Toast.makeText(Profile.this, str, Toast.LENGTH_SHORT).show();
                // App.getSharedpref().saveString("size",String.valueOf(size));

//                emailedit.setText(name);
//                nameedit.setText(pass);




                if (emailedit.getText().toString() != null && nameedit.getText().toString() != null) {
                    if(sharedpreferences.getString(Constants.SIZE,null)==null){
                       editor.putString(Constants.USER_EMAIL+0,emailedit.getText().toString());
                         editor.putString(Constants.USER_PASSWORD+0,nameedit.getText().toString());
                        editor.putString(Constants.SIZE,"0");
                        editor.putString(Constants.LOGIN,"1");
                        editor.commit();
                    }else{
                        String size=sharedpreferences.getString(Constants.SIZE,null);
                        int size1=Integer.parseInt(size);
                        size1++;
                        editor.putString(Constants.USER_EMAIL+size1,emailedit.getText().toString());
                        editor.putString(Constants.USER_PASSWORD+size1,nameedit.getText().toString());
                        editor.putString(Constants.SIZE,String.valueOf(size1));
                        editor.putString(Constants.LOGIN,"1");
                        editor.commit();
                    }

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Enter both fields.", Toast.LENGTH_SHORT).show();
                }


               // int i = 0;
               // if (!App.getSharedpref().getString("size").equalsIgnoreCase("")) {
                   // String b = App.getSharedpref().getString("size");
                   // int size = Integer.valueOf(b);
                   // size++;
//                    Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                   // App.getSharedpref().saveString("size", String.valueOf(size));
//                    App.getSharedpref().saveString(Constants.USER_EMAIL, name);
//                    App.getSharedpref().saveString(Constants.USER_PASSWORD, pass);
               // } else {
                   // App.getSharedpref().saveString("size", String.valueOf(i));
                   // App.getSharedpref().saveString(Constants.USER_EMAIL + i, name);
                    //App.getSharedpref().saveString(Constants.USER_PASSWORD + i, pass);
                //}

//                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(intent);
//
//                Toast.makeText(MainActivity.this, "Login Succeessfull" + name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}