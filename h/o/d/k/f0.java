package h.o.d.k;

import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67972a;

    /* loaded from: classes7.dex */
    public static class a {
        public int a(Class cls) {
            return 0;
        }

        public int b(Class cls) {
            return 0;
        }

        public boolean c(Object obj, long j, long j2, long j3) {
            return false;
        }

        public long d(Object obj, long j) {
            return 0L;
        }

        public Object e(Object obj, long j) {
            return null;
        }

        public Object f(Object obj, long j) {
            return null;
        }

        public long g(Field field) {
            return 0L;
        }

        public void h(Object obj, long j, Object obj2) {
        }

        public void i(Object obj, long j, long j2) {
        }

        public void j(Object obj, long j, Object obj2) {
        }
    }

    static {
        System.getProperty("rx.unsafe-disable");
        a aVar = null;
        try {
            Field declaredField = a.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            aVar = (a) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f67972a = aVar;
    }

    public static long a(Class<?> cls, String str) {
        try {
            return f67972a.g(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            InternalError internalError = new InternalError();
            internalError.initCause(e2);
            throw internalError;
        }
    }

    public static boolean b() {
        return false;
    }
}
