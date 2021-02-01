package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes5.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int qCZ = eNo();

    static {
        IS_ANDROID = qCZ != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eNn() {
        return qCZ;
    }

    private static int eNo() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eNp()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eNp() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eNq */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
