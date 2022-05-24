package com.example.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,password;
    Button btnLogin;
    SQLite_test DB;
    TextView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText) findViewById(R.id.editTextTextPersonName2);
        password=(EditText) findViewById(R.id.editTextTextPersonName3);
        btnLogin=(Button) findViewById(R.id.button6);
        reg=(TextView) findViewById(R.id.textView5);
        DB=new SQLite_test(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1=user.getText().toString();
                String password1=password.getText().toString();
                if(user1.equals("")||password1.equals("")){
                    Toast.makeText(MainActivity.this, "Không được để trống", Toast.LENGTH_LONG).show();
                }
                else
                {

                    Boolean checkpassword=DB.checkpassword(user1,password1);
                    Boolean checkuser=DB.checkuser(user1);
                    if(checkpassword==true)
                    {
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công/n"+"chào mừng"+user1, Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),ListView1.class);
                        startActivity(intent);
                    }
                    else if(checkuser==true&&checkpassword==false)
                    {
                        Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Tài khoản không tồn tại, vui lòng tạo tài khoản", Toast.LENGTH_LONG).show();
                    }


                }


            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent1);
            }
        });

    }
}