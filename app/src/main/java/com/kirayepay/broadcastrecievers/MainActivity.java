package com.kirayepay.broadcastrecievers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    Toolbar toolbar;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        editText = (EditText) findViewById(R.id.textview);
        button = (Button) findViewById(R.id.bttn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValueToFragment(editText.getText().toString());
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.container,new DemoFragment()).commit();
    }
    protected void sendValueToFragment(String text) {
        Intent intent = new Intent("DEMO_PLEASE");
        intent.putExtra("TEXT", text);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}
