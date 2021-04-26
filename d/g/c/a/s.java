package d.g.c.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f65517a;

    static {
        Object b2 = b();
        f65517a = b2;
        if (b2 != null) {
            a();
        }
        if (f65517a == null) {
            return;
        }
        d();
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d() {
        try {
            Method c2 = c("getStackTraceDepth", Throwable.class);
            if (c2 == null) {
                return null;
            }
            c2.invoke(b(), new Throwable());
            return c2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static void e(Throwable th) {
        n.p(th);
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw ((RuntimeException) th);
    }
}
