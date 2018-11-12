package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes2.dex */
public final class g {
    private static final int iEO = cco();
    private static final boolean iEP;

    static {
        iEP = iEO != 0;
    }

    public static boolean ccm() {
        return iEP;
    }

    public static int ccn() {
        return iEO;
    }

    private static int cco() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            /* renamed from: ccp */
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
