package com.bawie.liu.liuhongyin1221.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.adapter.YiAdapter;
import com.bawie.liu.liuhongyin1221.http.Bean1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ViewPager vp;
    ArrayList<View> views;
    /*String pi1 = "http://www.zhaoapi.cn/images/quarter/ad1.png";
    String pi2=  "http://www.zhaoapi.cn/images/quarter/ad2.png";
    String pi3=  "http://www.zhaoapi.cn/images/quarter/ad3.png";
    String pi4=  "http://www.zhaoapi.cn/images/quarter/ad4.png";*/
    private YiAdapter yiAdapter;
    private Button button;
    private Button bt;

    //    private YiAdapter yiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

        vp = findViewById(R.id.vp);
        views = new ArrayList<>();
        View view1 = getLayoutInflater().inflate(R.layout.viewpager_item1, null);
        View view2 = getLayoutInflater().inflate(R.layout.viewpager_item2, null);
        View view3 = getLayoutInflater().inflate(R.layout.viewpager_item3, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        YiAdapter yiAdapter = new YiAdapter(views);
        vp.setAdapter(yiAdapter);






    }
}
