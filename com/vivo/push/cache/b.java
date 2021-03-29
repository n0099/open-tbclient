package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f39455a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f39456b;

    /* renamed from: c  reason: collision with root package name */
    public e f39457c;

    public static b a() {
        if (f39456b == null) {
            synchronized (f39455a) {
                if (f39456b == null) {
                    f39456b = new b();
                }
            }
        }
        return f39456b;
    }

    public final e a(Context context) {
        e eVar = this.f39457c;
        if (eVar != null) {
            return eVar;
        }
        try {
            String str = z.a(context) ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
            Method method = Class.forName(str).getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is " + str);
            e eVar2 = (e) method.invoke(null, context);
            this.f39457c = eVar2;
            return eVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
