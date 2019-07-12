package com.samgu.practicemyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Main2Activity extends AppCompatActivity {

    RadioGroup sexGroup;
    RadioButton Man, Woman;
    CheckBox box1, box2, box3, box4;
    Spinner edu;
    Switch isPush;
    Button send;
    StringBuilder sb = new StringBuilder();
    String sexcontent = "男", educontent = "", pushcontent = "關閉", skillcotent = "";
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViews();
    }


    private void findViews() {
        sexGroup = findViewById(R.id.sexGroup);
        Man = findViewById(R.id.Man);
        Woman = findViewById(R.id.Woman);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);
        edu = findViewById(R.id.edu);
        isPush = findViewById(R.id.isPush);
        send = findViewById(R.id.send);
        txtResult = findViewById(R.id.txtResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource//adapter 配置器
                (this, R.array.edudata, android.R.layout.simple_spinner_item);//(context ,陣列來源,spinner排版)
        edu.setAdapter(adapter);//edu spinner 放入配置器
        edu.setSelection(3);//設定預設選項 Selection

        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                if (checkId == Man.getId()) //id=男生
                    sexcontent = "男";
                else
                    sexcontent = "女";
            }
        });//選項被改變


        edu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //edu spinner選項
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {//被選項Item時
                educontent = adapterView.getItemAtPosition(position).toString();
                //educontent 用 adpterView 去getItemAtPositon(position) 轉字串toString
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        isPush.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)

                    pushcontent = "啟動";
                else
                    pushcontent = "關閉";
            }
        });


        send.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.setLength(0);//刪除 StringBuilder 的內容



                sb.append(sexcontent + "\n");
                sb.append(educontent + "\n");
                sb.append(pushcontent + "\n"); //點即時的時候把sexcontent educontent pushcontent都加入
                if (box1.isChecked()) //如果box1 被Checked的話
                    sb.append("水電" + "\n"); //StringBuilder   append附加(String)
                if (box2.isChecked())
                    sb.append("程式" + "\n");
                if (box3.isChecked())
                    sb.append("翻譯" + "\n");
                if (box4.isChecked())
                    sb.append("畫畫" + "\n");

                //  Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                txtResult.setText(sb.toString());
            }
        });
    }
}