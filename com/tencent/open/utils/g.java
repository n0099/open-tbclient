package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f39607a;

    /* renamed from: b  reason: collision with root package name */
    public volatile WeakReference<SharedPreferences> f39608b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f39607a == null) {
                f39607a = new g();
            }
            gVar = f39607a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        if (this.f39608b == null || this.f39608b.get() == null) {
            this.f39608b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f39608b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e2) {
            com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
            return str;
        }
    }
}
