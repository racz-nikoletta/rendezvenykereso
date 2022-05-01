package com.example.vizsgaremek;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class RegisterUser {
    protected void putDataToDB(User user, ProgressBar progressBar) {
        if (!user.getLastname().equals("") && !user.getFirstname().equals("") && !user.getEmail().equals("") && !user.getPassword().equals("")) {
            progressBar.setVisibility(View.VISIBLE);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String[] field = new String[4];
                    field[0] = "lastname";
                    field[1] = "firstname";
                    field[2] = "email";
                    field[3] = "password";
                    //Creating array for data
                    String[] data = new String[4];
                    data[0] = user.getLastname();
                    data[1] = user.getFirstname();
                    data[2] = user.getEmail();
                    data[3] = user.getPassword();
                    PutData putData = new PutData("http://10.0.11.200/vizsg/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            progressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            if(result.equals("Sign Up Success")){
                                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        /*Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                        finish();*/
                            }else{
                                //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                            Log.i("PutData", result);
                        }
                    }
                }
            });
        }
        else{
            //Toast.makeText(getApplicationContext(), "All fields required!", Toast.LENGTH_SHORT).show();
        }
    }
}