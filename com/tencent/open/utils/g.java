package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f13735a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f13736b = null;

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f13735a == null) {
                f13735a = new g();
            }
            gVar = f13735a;
        }
        return gVar;
    }

    public String a(Context context, String str) {
        if (this.f13736b == null || this.f13736b.get() == null) {
            this.f13736b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f13736b.get().getString(host, null);
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
