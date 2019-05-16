package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class j {
    private static volatile j a;
    private Context b;
    private Handler c = new Handler(Looper.getMainLooper());
    private Map<String, Map<String, String>> d = new HashMap();

    private j(Context context) {
        this.b = context;
    }

    public static j a(Context context) {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        String str3;
        if (this.d != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.d.get(str);
                    str3 = map != null ? map.get(str2) : "";
                } catch (Throwable th) {
                    str3 = "";
                }
            }
        }
        str3 = "";
        return str3;
    }

    private synchronized void c(String str, String str2, String str3) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        Map<String, String> map = this.d.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.d.put(str, map);
    }

    public synchronized void a(String str, String str2, String str3) {
        c(str, str2, str3);
        this.c.post(new k(this, str, str2, str3));
    }

    public synchronized String b(String str, String str2, String str3) {
        String a2;
        a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            a2 = this.b.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }
}
