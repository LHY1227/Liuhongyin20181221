package com.bawie.liu.liuhongyin1221.presenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.bawie.liu.liuhongyin1221.core.GoodCall;
import com.bawie.liu.liuhongyin1221.http.Good;
import com.bawie.liu.liuhongyin1221.http.Goods1;
import com.bawie.liu.liuhongyin1221.modle.Modle;
import com.google.gson.Gson;

/**
 * 作者：liu on 2018/12/21 17:22
 * 邮箱：1915760456@qq.com
 */
public class GPresenter {
    private GoodCall goodCall;

    public GPresenter(GoodCall goodCall) {
        this.goodCall = goodCall;
    }

    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String s = (String) msg.obj;
            Gson gson = new Gson();
            Good good = gson.fromJson(s, Good.class);
            goodCall.callgood(good);

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
