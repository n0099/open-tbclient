package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class g {
    private static final int iPf = cfh();
    private static final boolean iPg;

    static {
        iPg = iPf != 0;
    }

    public static boolean cff() {
        return iPg;
    }

    public static int cfg() {
        return iPf;
    }

    private static int cfh() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cfi */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
