package com.demo.sdkforbaidudemo.view;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.chushou.view.homepage.HomePageRecommendFragment;
import com.kascend.cstvsdk.CSTVSdk;
import com.kascend.cstvsdk.receiver.CSTVWifiReceiver;
import tv.chushou.a;
/* loaded from: classes6.dex */
public class CSTVSdkMainActivityNew extends BaseActivity {
    private Button enterLiveBtn;
    private EditText liveTypeEdit;
    private EditText roomIdEdit;
    private HomePageRecommendFragment fragment = null;
    private BroadcastReceiver networkReceiver = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
        if (this.networkReceiver == null) {
            this.networkReceiver = new CSTVWifiReceiver();
            registerReceiver(this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void init() {
        setContentView(a.c.cssdk_activity_main);
        View findViewById = findViewById(a.b.root);
        if (Build.VERSION.SDK_INT >= 23) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            getWindow().clearFlags(1024);
            getWindow().clearFlags(512);
            getWindow().addFlags(256);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, a.C0943a.transparent));
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(8448);
            findViewById.setFitsSystemWindows(false);
        } else {
            getWindow().clearFlags(1024);
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
        this.fragment = new ListFragment();
        getSupportFragmentManager().beginTransaction().add(a.b.fragmentContainer, this.fragment).commitAllowingStateLoss();
        this.roomIdEdit = (EditText) findViewById(a.b.roomId);
        this.liveTypeEdit = (EditText) findViewById(a.b.liveType);
        this.enterLiveBtn = (Button) findViewById(a.b.enter);
        this.enterLiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.demo.sdkforbaidudemo.view.CSTVSdkMainActivityNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj = CSTVSdkMainActivityNew.this.roomIdEdit.getText().toString();
                String obj2 = CSTVSdkMainActivityNew.this.liveTypeEdit.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    Toast.makeText(CSTVSdkMainActivityNew.this, "房间号为空", 0).show();
                } else {
                    CSTVSdk.INSTANCE.startLiveRoom(CSTVSdkMainActivityNew.this, obj, obj2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.networkReceiver != null) {
            unregisterReceiver(this.networkReceiver);
            this.networkReceiver = null;
        }
    }
}
