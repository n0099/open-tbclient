package com.yy.open.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public final class BridgeActivity extends Activity {
    public static final String FLAG_RESTART = "isRestart";

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.d("BridgeActivity", "onActivityResult");
        setResult(i3, intent);
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        Intent intent;
        Exception e2;
        requestWindowFeature(1);
        int i2 = 0;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        super.onCreate(bundle);
        if (getIntent() == null) {
            setResult(444222000);
            finish();
            return;
        }
        Log.d("BridgeActivity", MissionEvent.MESSAGE_CREATE);
        if (bundle == null || !bundle.getBoolean(FLAG_RESTART)) {
            try {
                intent = (Intent) getIntent().getParcelableExtra("intent");
                if (intent != null) {
                    try {
                        i2 = intent.getIntExtra("request_code", 0);
                    } catch (Exception e3) {
                        e2 = e3;
                        Log.e("YYOpenSdk", "resultCode getIntExtra exception " + e2);
                        if (intent == null) {
                        }
                    }
                }
            } catch (Exception e4) {
                intent = null;
                e2 = e4;
            }
            if (intent == null) {
                startActivityForResult(intent, i2);
                return;
            }
            setResult(444222000);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(FLAG_RESTART, true);
        super.onSaveInstanceState(bundle);
        Log.d("BridgeActivity", "onSaveInstanceState");
    }
}
