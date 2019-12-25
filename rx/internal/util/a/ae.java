package rx.internal.util.a;

import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class ae {
    public static final a njb;
    private static final boolean njc;

    static {
        a aVar;
        njc = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = a.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            aVar = (a) declaredField.get(null);
        } catch (Throwable th) {
            aVar = null;
        }
        njb = aVar;
    }

    public static boolean dGX() {
        return false;
    }

    public static long l(Class<?> cls, String str) {
        try {
            return njb.b(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        public long b(Field field) {
            return 0L;
        }

        public int Q(Class cls) {
            return 0;
        }

        public int R(Class cls) {
            return 0;
        }

        public void a(Object obj, long j, Object obj2) {
        }

        public void b(Object obj, long j, Object obj2) {
        }

        public Object b(Object obj, long j) {
            return null;
        }

        public Object c(Object obj, long j) {
            return null;
        }

        public void a(Object obj, long j, long j2) {
        }

        public long d(Object obj, long j) {
            return 0L;
        }

        public boolean a(Object obj, long j, long j2, long j3) {
            return false;
        }
    }
}
