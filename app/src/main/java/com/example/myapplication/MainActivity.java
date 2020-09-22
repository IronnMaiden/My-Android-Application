package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    //private static final String TAG = MainActivity.class.getSimpleName();

    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.i(TAG,"MAinactivity created");
        nameEditText = findViewById(R.id.editTextTextPersonName);
    }

    public void clickListener(View view) {

        /*String name = nameEditText.getText().toString();
        Toast.makeText(this, "Welcome "+ name+ "to Android!", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra(name: "studentname", name);
        startActivity(hIntent);*/
        Log.e(TAG,"Button is clicked");
        switch (view.getId()){
            case R.id.loginbutton:
                startHomeActivity();
                break;
            case R.id.cancelbutton:
                dialPhone();
                break;
        }

    }

    private void dialPhone() {
        Log.v(TAG,"dialing phone no");
        Intent dIntent = new Intent();
        dIntent.setAction(Intent.ACTION_DIAL);
        dIntent.setData(Uri.parse("tel:8208491054"));
        startActivity(dIntent);
    }

    private void startHomeActivity() {
        Log.w(TAG,"starting home activity");
        String name = nameEditText.getText().toString();
        Toast.makeText(this, "welcome "+name +" to android", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class); //explicit intent
        hIntent.putExtra("studentname",name);
        startActivity(hIntent);
    }
}