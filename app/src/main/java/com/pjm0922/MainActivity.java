package com.pjm0922;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1,rb2;
    Button bt1,bt2,bt3;
    EditText ed1,ed2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Report02");


        rg = findViewById(R.id.RG1);
        rb1 = findViewById(R.id.RB1);
        rb2 = findViewById(R.id.RB2);
        ed1 = findViewById(R.id.EDT1);
        ed2 = findViewById(R.id.EDT2);
        bt1 = findViewById(R.id.BT1);
        bt2 = findViewById(R.id.BT2);
        bt3 = findViewById(R.id.BT3);
        LinearLayout lay1 = findViewById(R.id.LAY1);
        LinearLayout lay2 = findViewById(R.id.LAY2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.RB1:
                        bt1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                lay1.setVisibility(View.VISIBLE);
                                lay2.setVisibility(View.GONE);
                            }
                        });
                        break;

                    case R.id.RB2:
                        bt1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                lay1.setVisibility(View.GONE);
                                lay2.setVisibility(View.VISIBLE);
                            }
                        });
                        break;
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = ed1.getText().toString();
                int Year = Calendar.getInstance().get(Calendar.YEAR);
                int age = Integer.parseInt(temp);
                int regult = Year - age + 1;

                if (age >= 2022 || 1900 > age)
                {Toast.makeText(getApplicationContext(), "출생년도를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {Toast.makeText(getApplicationContext(),"당신의 나이는 " + regult + "세 입니다.",Toast.LENGTH_SHORT).show();}
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = ed2.getText().toString();
                int Year = Calendar.getInstance().get(Calendar.YEAR);
                int age = Integer.parseInt(temp);
                int result = Year - age + 1;

                if (age >= 130 || 0 >= age)
                {Toast.makeText(getApplicationContext(), "나이를 정확하게 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {Toast.makeText(getApplicationContext(),"당신의 태어난 해는 " + result + "년 입니다.",Toast.LENGTH_SHORT).show();}
            }
        });
    }
}