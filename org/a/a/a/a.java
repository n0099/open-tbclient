package org.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/* loaded from: classes4.dex */
public class a {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
