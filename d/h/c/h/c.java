package d.h.c.h;

import d.h.c.a.n;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/* loaded from: classes6.dex */
public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        n.p(invocationHandler);
        n.k(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
