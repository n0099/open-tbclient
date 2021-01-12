package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes14.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int qsV = eKY();

    static {
        IS_ANDROID = qsV != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eKX() {
        return qsV;
    }

    private static int eKY() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eKZ()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eKZ() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eLa */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
