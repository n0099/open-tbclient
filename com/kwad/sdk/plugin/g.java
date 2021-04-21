package com.kwad.sdk.plugin;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Class, e> f36465a = new ConcurrentHashMap();

    @Nullable
    public static <T extends e> T a(Class<T> cls) {
        T t = (T) f36465a.get(cls);
        if (t != null) {
            return t;
        }
        try {
            if (DevelopMangerPlugin.class.isAssignableFrom(cls)) {
                T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.kwad.sdk.plugin.g.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        return null;
                    }
                });
                f36465a.put(cls, t2);
                return t2;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Class cls, e eVar) {
        f36465a.put(cls, eVar);
    }
}
