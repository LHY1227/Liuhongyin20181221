package com.bawie.liu.liuhongyin1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liu on 2018/12/21 16:16
 * 邮箱：1915760456@qq.com
 */
public class TAdapter extends RecyclerView.Adapter<TAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Goods1> list;

    public TAdapter(Context context, ArrayList<Goods1> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.titem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TAdapter.MyViewHolder myViewHolder, int i) {
        List<Goods1.DataBean> data = list.get(i).getData();
        myViewHolder.tv1.setText(data.get(i).getName());
        Glide.with(context).load(data.get(i).getIcon()).into(myViewHolder.iv1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv1;
        private final TextView tv1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}
