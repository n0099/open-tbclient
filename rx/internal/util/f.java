package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kDE = cQX();
    private static final boolean kDF;

    static {
        kDF = kDE != 0;
    }

    public static boolean cQV() {
        return kDF;
    }

    public static int cQW() {
        return kDE;
    }

    private static int cQX() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, cQY()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader cQY() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cQZ */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
