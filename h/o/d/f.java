package h.o.d;

import java.security.AccessController;
import java.security.PrivilegedAction;
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f69090a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f69091b;

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
        f69090a = d2;
        f69091b = d2 != 0;
    }

    public static int a() {
        return f69090a;
    }

    public static ClassLoader b() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new a());
    }

    public static boolean c() {
        return f69091b;
    }

    public static int d() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, b()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
