package com.example.muqorrobinaimar.onclick;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //kenalin (Variable global)
    Button toast, alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hubungin
        toast = findViewById(R.id.btnToast); //cara baru
        alert = (Button) findViewById(R.id.btnAlert); //cara lama

        //ngapain / memberi aksi pada button
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ngenalin dan hubungin EditText
                EditText edit = findViewById(R.id.editInput);
                String hasil = edit.getText().toString(); //mendapatkan teks

                //memanggil toast
                Toast.makeText(MainActivity.this, "INI Hasilnya : " + hasil , Toast.LENGTH_SHORT).show();

                alert.setText(hasil); //ngeset text di button alert
                edit.setText("");//mengosongkan edit
            }
        });

        //set on LongClick
        toast.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "INI TOAST " , Toast.LENGTH_SHORT).show();

                return true;
            }
        });



        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AlertDialog
                final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("Peringatan");
                dialog.setMessage("Apakah anda akan keluar?");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();//mengakhiri kelas
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "TIDAK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); // untuk menutup dialog
                    }
                });
                dialog.show(); //menampilkan
            }
        });
    }
    //salah satu cara memberi onClick pda object
    public void pindah(View view) {
        //loading
        final ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Harap Bersabar Ini Ujian !");
        progress.show();

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();
                //pindah activity
                Intent intentPindah = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intentPindah);
            }
        }, 3000);

    }


}