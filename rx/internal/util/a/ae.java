package rx.internal.util.a;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public final class ae {
    public static final Unsafe kbJ;
    private static final boolean kbK;

    static {
        Unsafe unsafe;
        kbK = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        kbJ = unsafe;
    }

    public static boolean cEU() {
        return (kbJ == null || kbK) ? false : true;
    }

    public static long j(Class<?> cls, String str) {
        try {
            return kbJ.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
