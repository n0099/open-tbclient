package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes15.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int qvP = eOk();

    static {
        IS_ANDROID = qvP != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eOj() {
        return qvP;
    }

    private static int eOk() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eOl()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eOl() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eOm */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
