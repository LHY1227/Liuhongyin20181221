package com.bawie.liu.liuhongyin1221.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.bawie.liu.liuhongyin1221.core.DataCall;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bawie.liu.liuhongyin1221.modle.Modle;
import com.google.gson.Gson;

/**
 * 作者：liu on 2018/12/21 16:02
 * 邮箱：1915760456@qq.com
 */
public class TPresenter {
    static private DataCall dataCall;

     public TPresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

     Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String s = (String) msg.obj;
            Gson gson = new Gson();
            Goods1 goods1 = gson.fromJson(s, Goods1.class);
            dataCall.callback(goods1);

        }
    };

    public  void  get(final String url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String ss = Modle.get(url);
                Message message = handler.obtainMessage();
                message.obj=ss;
                handler.sendMessage(message);
            }
        }).start();
    }
}
