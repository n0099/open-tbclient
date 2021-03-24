package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static g f39317a;

    /* renamed from: b  reason: collision with root package name */
    public volatile WeakReference<SharedPreferences> f39318b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f39317a == null) {
                f39317a = new g();
            }
            gVar = f39317a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        if (this.f39318b == null || this.f39318b.get() == null) {
            this.f39318b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f39318b.get().getString(host, null);
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
