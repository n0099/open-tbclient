package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class o {
    public static volatile o a;

    /* renamed from: a  reason: collision with other field name */
    public Context f819a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f820a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f821a = new HashMap();

    public o(Context context) {
        this.f819a = context;
    }

    public static o a(Context context) {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f821a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f821a.get(str);
                    if (map != null) {
                        return map.get(str2);
                    }
                    return "";
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void b(String str, String str2, String str3) {
        if (this.f821a == null) {
            this.f821a = new HashMap();
        }
        Map<String, String> map = this.f821a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f821a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            return this.f819a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m731a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f820a.post(new p(this, str, str2, str3));
    }
}
