package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.u;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes6.dex */
public class d {
    public static void a(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            com.bytedance.sdk.openadsdk.multipro.d.a.a(context.getApplicationContext());
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    int myPid = Process.myPid();
                    packageName = context.getPackageName() + myPid;
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                        packageName = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : packageName;
                    }
                    SSWebView.setDataDirectorySuffix(packageName);
                } catch (Exception e) {
                    try {
                        SSWebView.setDataDirectorySuffix(packageName);
                    } catch (Exception e2) {
                    }
                    u.b(e.toString());
                }
            }
        }
    }
}
