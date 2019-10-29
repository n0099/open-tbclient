package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kEm = cPc();
    private static final boolean kEn;

    static {
        kEn = kEm != 0;
    }

    public static boolean cPa() {
        return kEn;
    }

    public static int cPb() {
        return kEm;
    }

    private static int cPc() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, cPd()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader cPd() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cPe */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
