package com.bawie.liu.liuhongyin1221.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.adapter.TAdapter;
import com.bawie.liu.liuhongyin1221.core.DataCall;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bawie.liu.liuhongyin1221.presenter.TPresenter;

import java.util.ArrayList;

public class QieActivity extends AppCompatActivity implements DataCall {

    private RecyclerView re3;
    private TPresenter tPresenter;
    private TAdapter tAdapter;
    ArrayList<Goods1> list = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qie);

        re3 = findViewById(R.id.re3);

        tPresenter = new TPresenter(this);
        tPresenter.get("http://www.zhaoapi.cn/product/getCatagory");
        tAdapter = new TAdapter(this, list);
        gridLayoutManager = new GridLayoutManager(this,2);
        re3.setLayoutManager(gridLayoutManager);
        re3.setAdapter(tAdapter);

    }

    @Override
    public void callback(Goods1 goods1) {
        for (int i = 0; i < goods1.getData().size(); i++) {
            list.add(goods1);
            list.add(goods1);
            tAdapter.notifyDataSetChanged();
        }
    }
}
