package com.bawie.liu.liuhongyin1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawie.liu.liuhongyin1221.R;
import com.bawie.liu.liuhongyin1221.http.Good;
import com.bawie.liu.liuhongyin1221.http.Goods;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bawie.liu.liuhongyin1221.http.Goodss;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：liu on 2018/12/21 16:58
 * 邮箱：1915760456@qq.com
 */
public class GAdapter extends RecyclerView.Adapter<GAdapter.MyViewHolder> {
    /*private Context context;
    private ArrayList<Goodss> lists;

    public GAdapter(Context context, ArrayList<Goodss> lists) {
        this.context = context;
        this.lists = lists;
    }*/

    private Context context;
    private ArrayList<Goods1> list2;

    public GAdapter(Context context, ArrayList<Goods1> list2) {
        this.context = context;
        this.list2 = list2;
    }
    /*private ArrayList<Good> gglist;

    public GAdapter(Context context, ArrayList<Good> gglist) {
        this.context = context;
        this.gglist = gglist;
    }*/

    @NonNull
    @Override
    public GAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.gitem,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GAdapter.MyViewHolder myViewHolder, int i) {
        /*myViewHolder.tv2.setText(lists.get(i).getTitle());
        myViewHolder.tv3.setText(lists.get(i).getPrice());
        Glide.with(context).load(lists.get(i).getDetailUrl()).into(myViewHolder.iv2);*/
        List<Goods1.DataBean> data = list2.get(i).getData();
        myViewHolder.tv2.setText(data.get(i).getCreatetime());
        Glide.with(context).load(data.get(i).getIcon()).into(myViewHolder.iv2);
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv2;
        private final TextView tv2;
        private final TextView tv3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv2 = itemView.findViewById(R.id.iv2);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
