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
    private static volatile p f14490a;

    /* renamed from: a  reason: collision with other field name */
    private Context f866a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f867a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f868a = new HashMap();

    private p(Context context) {
        this.f866a = context;
    }

    public static p a(Context context) {
        if (f14490a == null) {
            synchronized (p.class) {
                if (f14490a == null) {
                    f14490a = new p(context);
                }
            }
        }
        return f14490a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.f868a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f868a.get(str);
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
        if (this.f868a == null) {
            this.f868a = new HashMap();
        }
        Map<String, String> map = this.f868a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f868a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f866a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m522a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f867a.post(new q(this, str, str2, str3));
    }
}
