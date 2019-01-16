package rx.internal.util.a;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public final class ae {
    public static final Unsafe iRa;
    private static final boolean iRb;

    static {
        Unsafe unsafe;
        iRb = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        iRa = unsafe;
    }

    public static boolean cge() {
        return (iRa == null || iRb) ? false : true;
    }

    public static long j(Class<?> cls, String str) {
        try {
            return iRa.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
