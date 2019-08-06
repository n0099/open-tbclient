package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kBm = cQl();
    private static final boolean kBn;

    static {
        kBn = kBm != 0;
    }

    public static boolean cQj() {
        return kBn;
    }

    public static int cQk() {
        return kBm;
    }

    private static int cQl() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, cQm()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader cQm() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cQn */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
