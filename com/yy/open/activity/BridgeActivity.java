package com.yy.open.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public final class BridgeActivity extends Activity {
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.d("BridgeActivity", "onActivityResult");
        setResult(i2, intent);
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
        Exception e;
        requestWindowFeature(1);
        int i = 0;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        super.onCreate(bundle);
        if (getIntent() == null) {
            setResult(444222000);
            finish();
            return;
        }
        Log.d("BridgeActivity", "onCreate");
        if (bundle == null || !bundle.getBoolean("isRestart")) {
            try {
                intent = (Intent) getIntent().getParcelableExtra("intent");
                if (intent != null) {
                    try {
                        i = intent.getIntExtra("request_code", 0);
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("YYOpenSdk", "resultCode getIntExtra exception " + e);
                        if (intent == null) {
                        }
                    }
                }
            } catch (Exception e3) {
                intent = null;
                e = e3;
            }
            if (intent == null) {
                startActivityForResult(intent, i);
                return;
            }
            setResult(444222000);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("isRestart", true);
        super.onSaveInstanceState(bundle);
        Log.d("BridgeActivity", "onSaveInstanceState");
    }
}
