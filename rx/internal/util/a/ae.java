package rx.internal.util.a;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public final class ae {
    public static final Unsafe iMJ;
    private static final boolean iMK;

    static {
        Unsafe unsafe;
        iMK = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        iMJ = unsafe;
    }

    public static boolean ceG() {
        return (iMJ == null || iMK) ? false : true;
    }

    public static long j(Class<?> cls, String str) {
        try {
            return iMJ.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
