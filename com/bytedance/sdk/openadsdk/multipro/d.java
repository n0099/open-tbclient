package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class d {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        String packageName = context.getPackageName();
        com.bytedance.sdk.openadsdk.multipro.d.a.a(context.getApplicationContext());
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            int myPid = Process.myPid();
            packageName = context.getPackageName() + myPid;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    packageName = runningAppProcessInfo.processName;
                }
            }
            WebView.setDataDirectorySuffix(packageName);
        } catch (Throwable th) {
            try {
                WebView.setDataDirectorySuffix(packageName);
            } catch (Throwable unused) {
            }
            u.b(th.toString());
        }
    }
}
