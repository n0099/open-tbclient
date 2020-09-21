package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.List;
/* loaded from: classes12.dex */
public class LinkProxyActivity extends Activity {
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3 A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e7, blocks: (B:25:0x00b7, B:27:0x00bd, B:29:0x00cc, B:31:0x00d2, B:33:0x00da, B:42:0x00f5, B:44:0x00fd, B:46:0x0101, B:37:0x00e3, B:50:0x010b), top: B:57:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e7, blocks: (B:25:0x00b7, B:27:0x00bd, B:29:0x00cc, B:31:0x00d2, B:33:0x00da, B:42:0x00f5, B:44:0x00fd, B:46:0x0101, B:37:0x00e3, B:50:0x010b), top: B:57:0x00b7 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle bundle) {
        boolean z;
        PackageManager packageManager;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            p.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
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
            p.b("LinkProxyActivity", "enter onCreate error ", th);
        }
        String packageName = getPackageName();
        p.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
        if ("com.vivo.abe".equals(packageName)) {
            try {
                if (intent == null) {
                    p.d("LinkProxyActivity", "adapterToService intent is null");
                } else if (intent.getExtras() == null) {
                    p.d("LinkProxyActivity", "adapterToService getExtras() is null");
                } else {
                    Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        p.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                    } else {
                        z.a(this, intent2);
                    }
                }
            } catch (Exception e) {
                p.a("LinkProxyActivity", e.toString(), e);
            }
        } else {
            try {
                if (intent.getExtras() != null) {
                    Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent3 != null && (packageManager = getPackageManager()) != null) {
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent3, 576);
                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                            z = false;
                        } else {
                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                            if (resolveInfo != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.exported) {
                                z = true;
                            }
                        }
                        if (!z) {
                            startService(intent3);
                        } else {
                            p.b("LinkProxyActivity", "service's exported is " + z);
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            } catch (Exception e2) {
                p.a("LinkProxyActivity", e2.toString(), e2);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
