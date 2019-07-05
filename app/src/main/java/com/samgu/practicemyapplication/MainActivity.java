package com.samgu.practicemyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtAccount, edtPassword;
    Button btnOk, btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);


        btnCancel.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtAccount.setText("");
                edtPassword.setText("");
            }
        });
    }

    public void Ok(View view) {

        String user = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();
        //宣告 String user  String password  數值與字串 (String) 型態互相轉換

        //( 輸入 int 傳回 String ) :   String.valueOf( int )
        //( 輸入 String 傳回 int ) :   Integer.parseInt( String )

        if (user.equals("123") & password.equals("123")) { //如果 user=123 & password=123
            Toast.makeText(getApplicationContext(), "登入成功", Toast.LENGTH_SHORT).show();
        } else {//否則
            Toast.makeText(getApplicationContext(), "登入失敗", Toast.LENGTH_SHORT).show();
        }
    }
}
