package com.tomorrow_p;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tomorrow_p.activity.BluetoothActivity;
import com.tomorrow_p.activity.CameraActivity;
import com.tomorrow_p.activity.DateFormatActivity;
import com.tomorrow_p.activity.DialogActivity;
import com.tomorrow_p.activity.EncryptTestActivity;
import com.tomorrow_p.activity.NotificationActivity;
import com.tomorrow_p.activity.VibratorActivity;
import com.tomorrow_p.activity.WarrantyActivity;
import com.tomorrow_p.view.FlowButton;
import com.tomorrow_p.view.FlowLayout;
import com.tomorrow_p.view.drawoutline.DrawOutlineActivity;

public class MainActivity extends AppCompatActivity {

    private FlowLayout mFlowLayout;
    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);
        mFlowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        mFlowLayout.addView(new FlowButton(this, "Encrypt", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, EncryptTestActivity.class));
            }
        }));
//        mFlowLayout.addView(new FlowButton(this, "Boot the wizard", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(mContext, DefaultActivity.class));
//            }
//        }));
//        mFlowLayout.addView(new FlowButton(this, "gesture", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(mContext, com.tomorrow_p.gesture.MainActivity.class));
//            }
//        }));
        mFlowLayout.addView(new FlowButton(this, "Draw Face", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DrawOutlineActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Date Format", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DateFormatActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Dialog", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, DialogActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Camera", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, CameraActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Warranty", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, WarrantyActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Vibrator", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, VibratorActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Bluetooth", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, BluetoothActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "Notification", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, NotificationActivity.class));
            }
        }));
        mFlowLayout.addView(new FlowButton(this, "test", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(mContext, BluetoothClientActivity.class));
                /*if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_CALL_LOG)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.WRITE_CALL_LOG, Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_CONTACTS}, 1);
//                    ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.READ_CALL_LOG}, 1);
//                    ActivityCompat.requestPermissions(mContext, new String[]{Manifest.permission.WRITE_CALL_LOG}, 1);
//                    return;
                }
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                //url:统一资源定位符
                //uri:统一资源标示符（更广）
                intent.setData(Uri.parse("tel:" + "18520816072"));
                //开启系统拨号器
                startActivity(intent);*/

            }
        }));


        ImmersiveMode();
    }

    private void ImmersiveMode() {
//        transparentStatusBar();
        transparentNavigationBar();
//        hideStatusAndNavigationBar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    private void hideStatusAndNavigationBar() {
        View decorView = getWindow().getDecorView();    //获取当前界面的DecorView
        int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;  // 设置全屏(隐藏导航栏)
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;  // 设置全屏(隐藏状态栏)
        decorView.setSystemUiVisibility(option);
    }

    private void transparentStatusBar() {   // 设置全屏(透明状态栏)
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void transparentNavigationBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {    // 沉浸式模式
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }
}
