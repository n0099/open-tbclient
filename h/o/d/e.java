package h.o.d;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f72031a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f72032b;

    /* loaded from: classes8.dex */
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
        f72031a = d2;
        f72032b = d2 != 0;
    }

    public static int a() {
        return f72031a;
    }

    public static ClassLoader b() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean c() {
        return f72032b;
    }

    public static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, b()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
