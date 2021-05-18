package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f36687a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f36688b;

    /* renamed from: c  reason: collision with root package name */
    public e f36689c;

    public static b a() {
        if (f36688b == null) {
            synchronized (f36687a) {
                if (f36688b == null) {
                    f36688b = new b();
                }
            }
        }
        return f36688b;
    }

    public final e a(Context context) {
        e eVar = this.f36689c;
        if (eVar != null) {
            return eVar;
        }
        try {
            String str = z.a(context) ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
            Method method = Class.forName(str).getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is " + str);
            e eVar2 = (e) method.invoke(null, context);
            this.f36689c = eVar2;
            return eVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
