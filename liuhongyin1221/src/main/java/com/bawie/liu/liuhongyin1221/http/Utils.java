package com.bawie.liu.liuhongyin1221.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：liu on 2018/12/21 14:08
 * 邮箱：1915760456@qq.com
 */
public class Utils {
    public static String get(String url){

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request build = new Request.Builder().url(url).get().build();
        Call call = okHttpClient.newCall(build);
        try {
            Response execute = call.execute();
            return execute.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }
}
