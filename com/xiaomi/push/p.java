package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile p f14491a;

    /* renamed from: a  reason: collision with other field name */
    private Context f867a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f868a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f869a = new HashMap();

    private p(Context context) {
        this.f867a = context;
    }

    public static p a(Context context) {
        if (f14491a == null) {
            synchronized (p.class) {
                if (f14491a == null) {
                    f14491a = new p(context);
                }
            }
        }
        return f14491a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.f869a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f869a.get(str);
                    str3 = map != null ? map.get(str2) : "";
                } catch (Throwable th) {
                    str3 = "";
                }
            }
        }
        str3 = "";
        return str3;
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f869a == null) {
            this.f869a = new HashMap();
        }
        Map<String, String> map = this.f869a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f869a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f867a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m533a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f868a.post(new q(this, str, str2, str3));
    }
}
