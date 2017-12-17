package com.example.muqorrobinaimar.onclick;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Hitungan Mundur
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //pindah activity
                Intent intentPindah = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intentPindah);
                finish();
            }
        }, 3000);
    }
}
