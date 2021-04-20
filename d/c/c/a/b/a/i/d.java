package d.c.c.a.b.a.i;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f66259a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66260b;

    /* renamed from: c  reason: collision with root package name */
    public final Class[] f66261c;

    public d(Class<?> cls, String str, Class... clsArr) {
        this.f66259a = cls;
        this.f66260b = str;
        this.f66261c = clsArr;
    }

    public static Method c(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object a(T t, Object... objArr) throws InvocationTargetException {
        Method b2 = b(t.getClass());
        if (b2 == null) {
            return null;
        }
        try {
            return b2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public final Method b(Class<?> cls) {
        Class<?> cls2;
        String str = this.f66260b;
        if (str != null) {
            Method c2 = c(cls, str, this.f66261c);
            if (c2 == null || (cls2 = this.f66259a) == null || cls2.isAssignableFrom(c2.getReturnType())) {
                return c2;
            }
            return null;
        }
        return null;
    }

    public boolean d(T t) {
        return b(t.getClass()) != null;
    }

    public Object e(T t, Object... objArr) {
        try {
            return a(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object f(T t, Object... objArr) throws InvocationTargetException {
        Method b2 = b(t.getClass());
        if (b2 != null) {
            try {
                return b2.invoke(t, objArr);
            } catch (IllegalAccessException e2) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + b2);
                assertionError.initCause(e2);
                throw assertionError;
            }
        }
        throw new AssertionError("Method " + this.f66260b + " not supported for object " + t);
    }

    public Object g(T t, Object... objArr) {
        try {
            return f(t, objArr);
        } catch (InvocationTargetException e2) {
            Throwable targetException = e2.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
