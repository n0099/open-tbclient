package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kDv = cPa();
    private static final boolean kDw;

    static {
        kDw = kDv != 0;
    }

    public static boolean cOY() {
        return kDw;
    }

    public static int cOZ() {
        return kDv;
    }

    private static int cPa() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, cPb()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader cPb() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cPc */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
