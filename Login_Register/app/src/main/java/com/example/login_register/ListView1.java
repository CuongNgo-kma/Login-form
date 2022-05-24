package com.example.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListView1 extends AppCompatActivity {
    private String Author="Ngô Ngọc Biên Cương";
    private ListView listView;
    private ArrayList <String> listData;
    private ArrayAdapter <String> adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);
        context=this;
        //gan id cho element
        listView=(ListView) findViewById(R.id.lv);

        // listData = context.getResources().getStringArray(R.array.listProduct);
        listData=new ArrayList<>();
        listData.add("Ngô Ngọc Biên Cương: 0987654321");
        listData.add("Nguyễn Văn Ba: 012382323");
        listData.add("Nguyễn Văn Xê: 012382844");
        listData.add("Trần Đức Bê: 093747343");
        listData.add("Lê Văn Chân: 032938283");
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
    }
}