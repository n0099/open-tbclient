package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class f {
    private static final int kaV = cEF();
    private static final boolean kaW;

    static {
        kaW = kaV != 0;
    }

    public static boolean cED() {
        return kaW;
    }

    public static int cEE() {
        return kaV;
    }

    private static int cEF() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: cEG */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
