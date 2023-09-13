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
    public Context f823a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f824a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f825a = new HashMap();

    public o(Context context) {
        this.f823a = context;
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
        if (this.f825a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f825a.get(str);
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
        if (this.f825a == null) {
            this.f825a = new HashMap();
        }
        Map<String, String> map = this.f825a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f825a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            return this.f823a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m722a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f824a.post(new p(this, str, str2, str3));
    }
}
