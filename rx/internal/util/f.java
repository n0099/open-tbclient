package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes12.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int pUn = eGb();

    static {
        IS_ANDROID = pUn != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eGa() {
        return pUn;
    }

    private static int eGb() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eGc()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eGc() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eGd */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
