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
    private static final Map<Class, e> f10783a = new ConcurrentHashMap();

    @Nullable
    public static <T extends e> T a(Class<T> cls) {
        T t = (T) f10783a.get(cls);
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
                f10783a.put(cls, t2);
                return t2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(Class cls, e eVar) {
        f10783a.put(cls, eVar);
    }
}
