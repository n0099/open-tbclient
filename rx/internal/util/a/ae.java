package rx.internal.util.a;

import java.lang.reflect.Field;
/* loaded from: classes14.dex */
public final class ae {
    public static final a qtv;
    private static final boolean qtw;

    static {
        a aVar;
        qtw = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = a.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            aVar = (a) declaredField.get(null);
        } catch (Throwable th) {
            aVar = null;
        }
        qtv = aVar;
    }

    public static boolean eLk() {
        return false;
    }

    public static long m(Class<?> cls, String str) {
        try {
            return qtv.c(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    /* loaded from: classes14.dex */
    public static class a {
        public long c(Field field) {
            return 0L;
        }

        public int K(Class cls) {
            return 0;
        }

        public int L(Class cls) {
            return 0;
        }

        public void a(Object obj, long j, Object obj2) {
        }

        public void b(Object obj, long j, Object obj2) {
        }

        public Object c(Object obj, long j) {
            return null;
        }

        public Object d(Object obj, long j) {
            return null;
        }

        public void a(Object obj, long j, long j2) {
        }

        public long e(Object obj, long j) {
            return 0L;
        }

        public boolean a(Object obj, long j, long j2, long j3) {
            return false;
        }
    }
}
