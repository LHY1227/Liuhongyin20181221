package com.bawie.liu.liuhongyin1221.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.adapter.GAdapter;
import com.bawie.liu.liuhongyin1221.adapter.TAdapter;
import com.bawie.liu.liuhongyin1221.core.DataCall;
import com.bawie.liu.liuhongyin1221.core.GoodBack;
import com.bawie.liu.liuhongyin1221.core.GoodCall;
import com.bawie.liu.liuhongyin1221.http.Good;
import com.bawie.liu.liuhongyin1221.http.Goods;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bawie.liu.liuhongyin1221.http.Goodss;
import com.bawie.liu.liuhongyin1221.presenter.GPresenter;
import com.bawie.liu.liuhongyin1221.presenter.TPresenter;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity implements DataCall,GoodCall {
    private TextView er;
    private TextView qie;
    private RecyclerView re1;
    private RecyclerView rec2;
    ArrayList<Goods1> list = new ArrayList<>();
    ArrayList<Goods1> list2 = new ArrayList<>();
    private TPresenter tPresenter;
    private TAdapter tAdapter;
    private GridLayoutManager gridLayoutManager;
    ArrayList<Goods> glist=new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private GAdapter gAdapter;
    ArrayList<Good> gglist = new ArrayList<>();
    private GPresenter gPresenter;


    ArrayList<Goodss> lists = new ArrayList<>();
    private TextView err;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        //查找控件
        err = findViewById(R.id.er);
        qie = findViewById(R.id.qie);
        re1 = findViewById(R.id.re1);
        rec2 = findViewById(R.id.rec2);
        //调用p层
        tPresenter = new TPresenter(this);
        tPresenter.get("http://www.zhaoapi.cn/product/getCatagory");
        tAdapter = new TAdapter(this, list);
        gridLayoutManager = new GridLayoutManager(this,5);
        re1.setLayoutManager(gridLayoutManager);
        re1.setAdapter(tAdapter);


        gPresenter = new GPresenter(this);
        gPresenter.get("http://www.zhaoapi.cn/product/getCarts?uid=71");
        gAdapter = new GAdapter(this, list);
        linearLayoutManager = new LinearLayoutManager(this);
        rec2.setLayoutManager(linearLayoutManager);
        rec2.setAdapter(gAdapter);

        err.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TwoActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TwoActivity.this,ErActivity.class);
                startActivity(intent);
            }
        });

        qie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this,QieActivity.class);
                startActivity(intent);
            }
        });


    }

   /* @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.er:
                Toast.makeText(this, "哈哈", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,ErActivity.class);
                startActivity(intent);
                break;
            case R.id.qie:
                break;
        }
    }*/



    @Override
    public void callback(Goods1 goods1) {
        for (int i = 0; i < goods1.getData().size(); i++) {
            list.add(goods1);
            list2.add(goods1);
            tAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void callgood(Good good) {
        for (int i = 0; i < good.getData().size(); i++) {
            gglist.add(good);
            gAdapter.notifyDataSetChanged();
        }
    }
}
