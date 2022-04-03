package com.android.kiemtra_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 123;
    private EditText Sotiengui;
    private EditText Laisuat;
    private EditText Kyhan;

    private Button Xemketqua;

    public static final String TIENLAI = "TIENLAI";
    public static final String TONGTIEN = "TONGTIEN";
    public static final String BUNDLE = "BUNDLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sotiengui = findViewById(R.id.sotien);
        Laisuat = findViewById(R.id.laisuat);
        Kyhan = findViewById(R.id.kyhan);
        Xemketqua = (Button) findViewById(R.id.xemketqua);

        Xemketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a;
                double b;
                double c;
                try {
                    a = getOperand(Sotiengui);
                    b = getOperand(Laisuat);
                    c = getOperand(Kyhan);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result;
                result = String.valueOf(
                        tinhlaisuat(a,b,c));

                String result2;
                result2 = String.valueOf(
                        a + tinhlaisuat(a,b,c));

                byBundle(result,result2);
            }
        });
    }
    public double tinhlaisuat(double sotiengui, double laisuat, double kyhan){
        double a = laisuat/100;
        double b = kyhan*30;
        return (sotiengui*a*b)/360;
    }


    public void byBundle(String result, String result2){
        Intent intent = new Intent(MainActivity.this,second.class);
        Bundle bundle = new Bundle();
        bundle.putString(TIENLAI,result);
        bundle.putString(TONGTIEN,result2);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }

    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){

        }
    }
}