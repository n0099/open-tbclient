package com.win.opensdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public class E1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40046a;

    public E1(F1 f1, Context context) {
        this.f40046a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String userAgentString;
        Context context = this.f40046a;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    Process.myPid();
                    if (context != null) {
                        try {
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                                if (runningAppProcessInfo.pid == Process.myPid()) {
                                    str = runningAppProcessInfo.processName;
                                    break;
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    str = null;
                    if (!TextUtils.equals(context.getPackageName(), str)) {
                        WebView.setDataDirectorySuffix(str);
                    }
                } catch (Exception unused2) {
                }
            }
            a2.f40250a = System.getProperty("http.agent");
            if (Build.VERSION.SDK_INT >= 17) {
                userAgentString = WebSettings.getDefaultUserAgent(context);
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                Y1.f40224a.post(new Z1(context));
                return;
            } else {
                userAgentString = new WebView(context).getSettings().getUserAgentString();
            }
            a2.f40250a = userAgentString;
        } catch (Exception unused3) {
        }
    }
}
