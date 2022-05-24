package com.example.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SQLite_test DB;
    Button btnreg;
    EditText user,password,repassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user=(EditText) findViewById(R.id.editTextTextPersonName5);
        password =(EditText)  findViewById(R.id.editTextTextPersonName6);
        repassword=(EditText) findViewById(R.id.editTextTextPersonName7);
        btnreg=(Button) findViewById(R.id.button);
        DB=new SQLite_test(this);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1=user.getText().toString();
                String password1=password.getText().toString();
                String repassword1=repassword.getText().toString();

                if(user1.equals("")||password1.equals("")||repassword1.equals(""))
                {
                    Toast.makeText(RegisterActivity.this,"Vui lòng không bỏ trống",Toast.LENGTH_LONG).show();
                }
                else {
                    Boolean checkinsert=DB.insertData(user1,password1);
                    if(password1.equals(repassword1)){
                        Boolean checkuser=DB.checkuser(user1);
                        if(checkuser==false){
                            Boolean insert=DB.insertData(user1,password1);
                            if(insert==true){
                                Toast.makeText(RegisterActivity.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();
                            }

                        }

                    }
                    else if(checkinsert==false){
                        Toast.makeText(RegisterActivity.this,"Tài khoản đã tồn tại",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}