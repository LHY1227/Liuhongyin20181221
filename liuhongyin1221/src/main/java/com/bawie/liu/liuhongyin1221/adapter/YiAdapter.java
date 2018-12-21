package com.bawie.liu.liuhongyin1221.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.activity.MainActivity;
import com.bawie.liu.liuhongyin1221.activity.TwoActivity;
import com.bawie.liu.liuhongyin1221.http.Bean1;

import java.util.ArrayList;

/**
 * 作者：liu on 2018/12/21 14:32
 * 邮箱：1915760456@qq.com
 */
public class YiAdapter extends PagerAdapter {

    private ArrayList<View> views;
    public YiAdapter(ArrayList<View> views) {
        this.views = views;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(views.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        View view=views.get(position);
        container.addView(view);
        if(position==2){
            Button button=(Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"点击成功", Toast.LENGTH_SHORT).show();

                }
            });
        }
        return view;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
}
