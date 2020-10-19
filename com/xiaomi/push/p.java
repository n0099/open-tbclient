package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile p f5015a;

    /* renamed from: a  reason: collision with other field name */
    private Context f788a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f789a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f790a = new HashMap();

    private p(Context context) {
        this.f788a = context;
    }

    public static p a(Context context) {
        if (f5015a == null) {
            synchronized (p.class) {
                if (f5015a == null) {
                    f5015a = new p(context);
                }
            }
        }
        return f5015a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.f790a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f790a.get(str);
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
        if (this.f790a == null) {
            this.f790a = new HashMap();
        }
        Map<String, String> map = this.f790a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f790a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f788a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m504a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f789a.post(new q(this, str, str2, str3));
    }
}
