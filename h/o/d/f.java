package h.o.d;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f67928a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f67929b;

    /* loaded from: classes7.dex */
    public static class a implements PrivilegedAction<ClassLoader> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.security.PrivilegedAction
        /* renamed from: a */
        public ClassLoader run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    static {
        int d2 = d();
        f67928a = d2;
        f67929b = d2 != 0;
    }

    public static int a() {
        return f67928a;
    }

    public static ClassLoader b() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean c() {
        return f67929b;
    }

    public static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, b()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
