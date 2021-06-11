package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f40295a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f40296b;

    /* renamed from: c  reason: collision with root package name */
    public e f40297c;

    public static b a() {
        if (f40296b == null) {
            synchronized (f40295a) {
                if (f40296b == null) {
                    f40296b = new b();
                }
            }
        }
        return f40296b;
    }

    public final e a(Context context) {
        e eVar = this.f40297c;
        if (eVar != null) {
            return eVar;
        }
        try {
            String str = z.a(context) ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
            Method method = Class.forName(str).getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is " + str);
            e eVar2 = (e) method.invoke(null, context);
            this.f40297c = eVar2;
            return eVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
