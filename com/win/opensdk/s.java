package com.win.opensdk;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes14.dex */
public class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8172a;

    public s(u uVar, Context context) {
        this.f8172a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String userAgentString;
        Context context = this.f8172a;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    Process.myPid();
                    if (context != null) {
                        try {
                            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                                if (runningAppProcessInfo.pid == Process.myPid()) {
                                    str = runningAppProcessInfo.processName;
                                    break;
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                    str = null;
                    if (!TextUtils.equals(context.getPackageName(), str)) {
                        WebView.setDataDirectorySuffix(str);
                    }
                } catch (Exception e2) {
                }
            }
            cb.f8139a = System.getProperty("http.agent");
            if (Build.VERSION.SDK_INT >= 17) {
                userAgentString = WebSettings.getDefaultUserAgent(context);
            } else if (Looper.myLooper() != Looper.getMainLooper()) {
                bv.f8133a.post(new by(context));
                return;
            } else {
                userAgentString = new WebView(context).getSettings().getUserAgentString();
            }
            cb.f8139a = userAgentString;
        } catch (Exception e3) {
        }
    }
}
