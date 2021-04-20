package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static volatile p f41185a;

    /* renamed from: a  reason: collision with other field name */
    public Context f818a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f819a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public Map<String, Map<String, String>> f820a = new HashMap();

    public p(Context context) {
        this.f818a = context;
    }

    public static p a(Context context) {
        if (f41185a == null) {
            synchronized (p.class) {
                if (f41185a == null) {
                    f41185a = new p(context);
                }
            }
        }
        return f41185a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f820a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f820a.get(str);
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
        if (this.f820a == null) {
            this.f820a = new HashMap();
        }
        Map<String, String> map = this.f820a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f820a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            return this.f818a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m525a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f819a.post(new q(this, str, str2, str3));
    }
}
