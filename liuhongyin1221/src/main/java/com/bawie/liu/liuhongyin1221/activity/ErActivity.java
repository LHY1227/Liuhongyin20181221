package com.bawie.liu.liuhongyin1221.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawie.liu.liuhongyin1221.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ErActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView zxing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_er);

        zxing = findViewById(R.id.zxingview);
        zxing.setDelegate(this);

    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
