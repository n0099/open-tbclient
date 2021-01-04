package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f13932a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f13933b;
    private e c;

    private b() {
    }

    public static b a() {
        if (f13933b == null) {
            synchronized (f13932a) {
                if (f13933b == null) {
                    f13933b = new b();
                }
            }
        }
        return f13933b;
    }

    public final e a(Context context) {
        String str;
        if (this.c != null) {
            return this.c;
        }
        try {
            if (z.a(context)) {
                str = "com.vivo.push.cache.ServerConfigManagerImpl";
            } else {
                str = "com.vivo.push.cache.ClientConfigManagerImpl";
            }
            Method method = Class.forName(str).getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is " + str);
            this.c = (e) method.invoke(null, context);
            return this.c;
        } catch (Exception e) {
            e.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e);
            return null;
        }
    }
}
