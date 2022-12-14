package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    ImageButton ibtnplay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000,100) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if(skOne.getProgress() >= skOne.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "XE 1 THANG", Toast.LENGTH_SHORT).show();
                    if(cbOne.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();

                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Ban doan sai", Toast.LENGTH_SHORT).show();

                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if(skTwo.getProgress() >= skTwo.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "XE 2 THANG", Toast.LENGTH_SHORT).show();
                    if(cbTwo.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Ban doan sai", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if(skThree.getProgress() >= skThree.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "XE 3 THANG", Toast.LENGTH_SHORT).show();
                    if(cbThree.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Ban doan chinh xac", Toast.LENGTH_SHORT).show();

                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Ban doan sai", Toast.LENGTH_SHORT).show();

                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }

                skOne.setProgress(skOne.getProgress() +one);
                skTwo.setProgress(skTwo.getProgress() +two);
                skThree.setProgress(skThree.getProgress() +three);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    ibtnplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this,"Vui long dat cuoc truoc khi choi!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });

        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);

    }

    private void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void AnhXa(){
        txtDiem     = (TextView) findViewById(R.id.diem);
        ibtnplay    = (ImageButton) findViewById(R.id.btnplay);
        cbOne       = (CheckBox) findViewById((R.id.checkBox1));
        cbTwo       = (CheckBox) findViewById((R.id.checkBox2));
        cbThree     = (CheckBox) findViewById((R.id.checkBox3));
        skOne       = (SeekBar) findViewById(R.id.seekBar1);
        skTwo       = (SeekBar) findViewById(R.id.seekBar2);
        skThree     = (SeekBar) findViewById(R.id.seekBar3);

    }
}