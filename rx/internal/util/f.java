package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes12.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int pUp = eGc();

    static {
        IS_ANDROID = pUp != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eGb() {
        return pUp;
    }

    private static int eGc() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eGd()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eGd() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eGe */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
