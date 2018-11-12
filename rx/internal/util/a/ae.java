package rx.internal.util.a;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public final class ae {
    public static final Unsafe iFC;
    private static final boolean iFD;

    static {
        Unsafe unsafe;
        iFD = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        iFC = unsafe;
    }

    public static boolean ccD() {
        return (iFC == null || iFD) ? false : true;
    }

    public static long j(Class<?> cls, String str) {
        try {
            return iFC.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
