package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f4617a = null;
    private volatile WeakReference<SharedPreferences> b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f4617a == null) {
                f4617a = new g();
            }
            gVar = f4617a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.b.get().getString(host, null);
            if (string == null || host.equals(string)) {
                com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
                return str;
            }
            String replace = str.replace(host, string);
            com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", "return environment url : " + replace);
            return replace;
        } catch (Exception e) {
            com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
