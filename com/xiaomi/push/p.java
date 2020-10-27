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
    private static volatile p f5013a;

    /* renamed from: a  reason: collision with other field name */
    private Context f785a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f786a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Map<String, String>> f787a = new HashMap();

    private p(Context context) {
        this.f785a = context;
    }

    public static p a(Context context) {
        if (f5013a == null) {
            synchronized (p.class) {
                if (f5013a == null) {
                    f5013a = new p(context);
                }
            }
        }
        return f5013a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.f787a != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f787a.get(str);
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
        if (this.f787a == null) {
            this.f787a = new HashMap();
        }
        Map<String, String> map = this.f787a.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f787a.put(str, map);
    }

    public synchronized String a(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.f785a.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m503a(String str, String str2, String str3) {
        b(str, str2, str3);
        this.f786a.post(new q(this, str, str2, str3));
    }
}
