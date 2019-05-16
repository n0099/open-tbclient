package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.vivo.push.util.m;
import com.vivo.push.util.w;
/* loaded from: classes3.dex */
public class LinkProxyActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            m.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
            return;
        }
        try {
            Window window = getWindow();
            window.setGravity(8388659);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (Throwable th) {
            m.b("LinkProxyActivity", "enter onCreate error ", th);
        }
        String packageName = getPackageName();
        m.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
        if ("com.vivo.abe".equals(packageName)) {
            try {
                if (intent == null) {
                    m.d("LinkProxyActivity", "adapterToService intent is null");
                } else if (intent.getExtras() == null) {
                    m.d("LinkProxyActivity", "adapterToService getExtras() is null");
                } else {
                    Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        m.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                    } else {
                        w.a(this, intent2);
                    }
                }
            } catch (Exception e) {
                m.a("LinkProxyActivity", e.toString(), e);
            }
        } else {
            try {
                if (intent.getExtras() != null) {
                    startService((Intent) intent.getExtras().get("previous_intent"));
                }
            } catch (Exception e2) {
                m.a("LinkProxyActivity", e2.toString(), e2);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
