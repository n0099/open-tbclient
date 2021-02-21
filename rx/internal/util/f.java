package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes5.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int qDz = eNw();

    static {
        IS_ANDROID = qDz != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eNv() {
        return qDz;
    }

    private static int eNw() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eNx()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eNx() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eNy */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
