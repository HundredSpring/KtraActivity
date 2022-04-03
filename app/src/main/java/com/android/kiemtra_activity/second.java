package com.android.kiemtra_activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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

    public void setDatabyBundle(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        String tienlai = bundle.getString(MainActivity.TIENLAI);
        String tongtien = bundle.getString(MainActivity.TONGTIEN);

        Tienlai.setText(tienlai + " đ");
        Tongtien.setText(tongtien +" đ");
    }

    public void back(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();

    }

}
