package rx.internal.util.a;

import java.lang.reflect.Field;
import sun.misc.Unsafe;
/* loaded from: classes2.dex */
public final class ae {
    public static final Unsafe kEZ;
    private static final boolean kFa;

    static {
        Unsafe unsafe;
        kFa = System.getProperty("rx.unsafe-disable") != null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        kEZ = unsafe;
    }

    public static boolean cPs() {
        return (kEZ == null || kFa) ? false : true;
    }

    public static long i(Class<?> cls, String str) {
        try {
            return kEZ.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
