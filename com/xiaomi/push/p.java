package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class p {
    private static volatile p a;

    /* renamed from: a  reason: collision with other field name */
    private Context f802a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f803a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f804a = new HashMap();

    private p(Context context) {
        this.f802a = context;
    }

    public static p a(Context context) {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.f804a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f804a.get(str);
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
        if (this.f804a == null) {
            this.f804a = new HashMap();
        }
        Map<String, String> map = this.f804a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f804a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f802a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m481a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f803a.post(new q(this, str, str2, str3));
    }
}
