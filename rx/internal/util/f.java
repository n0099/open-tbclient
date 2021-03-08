package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes4.dex */
public final class f {
    private static final boolean IS_ANDROID;
    private static final int qEb = eNe();

    static {
        IS_ANDROID = qEb != 0;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    public static int eNd() {
        return qEb;
    }

    private static int eNe() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, eNf()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader eNf() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: eNg */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
