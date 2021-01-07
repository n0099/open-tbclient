package com.kwad.sdk.plugin;

import androidx.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class, e> f10784a = new ConcurrentHashMap();

    @Nullable
    public static <T extends e> T a(Class<T> cls) {
        T t = (T) f10784a.get(cls);
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
                f10784a.put(cls, t2);
                return t2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(Class cls, e eVar) {
        f10784a.put(cls, eVar);
    }
}
