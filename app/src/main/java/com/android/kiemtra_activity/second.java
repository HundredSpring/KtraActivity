package com.android.kiemtra_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class second extends AppCompatActivity {


    private TextView Tienlai;
    private TextView Tongtien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);


        Tienlai = findViewById(R.id.tienlai);
        Tongtien = findViewById(R.id.tongtiennhanduoc);

        setDatabyBundle();

    }
//    public void setDatabyExtras(){
//        Intent intent = getIntent();
//        String tienlai = intent.getStringExtra(MainActivity.TIENLAI);
//        String tongtien = intent.getStringExtra(MainActivity.TONGTIEN);
//
//        Tienlai.setText(tienlai);
//        Tongtien.setText(tongtien);
//    }
    public void setDatabyBundle(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        String tienlai = bundle.getString(MainActivity.TIENLAI);
        String tongtien = bundle.getString(MainActivity.TONGTIEN);

        Tienlai.setText(tienlai);
        Tongtien.setText(tongtien);
    }

    public void back(View view){
        Intent intent = new Intent(second.this,MainActivity.class);
        startActivity(intent);
    }

}
