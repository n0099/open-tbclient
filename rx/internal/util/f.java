package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kAg = cPQ();
    private static final boolean kAh;

    static {
        kAh = kAg != 0;
    }

    public static boolean cPO() {
        return kAh;
    }

    public static int cPP() {
        return kAg;
    }

    private static int cPQ() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, cPR()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader cPR() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cPS */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
