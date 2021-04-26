package d.g.c.a;
/* loaded from: classes6.dex */
public final class n {
    public static void A(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }

    public static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    public static String b(int i2, int i3, String str) {
        if (i2 < 0) {
            return q.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException("negative size: " + i3);
    }

    public static String c(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return b(i2, i4, "start index");
        }
        return (i3 < 0 || i3 > i4) ? b(i3, i4, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i2)));
        }
    }

    public static void g(boolean z, String str, int i2, int i3) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void h(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j)));
        }
    }

    public static void i(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void j(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j), obj));
        }
    }

    public static void k(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static void l(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, obj, obj2));
        }
    }

    public static void m(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(q.b(str, obj, obj2, obj3, obj4));
        }
    }

    public static int n(int i2, int i3) {
        o(i2, i3, "index");
        return i2;
    }

    public static int o(int i2, int i3, String str) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException(a(i2, i3, str));
        }
        return i2;
    }

    public static <T> T p(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T q(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T> T r(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(q.b(str, obj));
    }

    public static <T> T s(T t, String str, Object obj, Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(q.b(str, obj, obj2));
    }

    public static int t(int i2, int i3) {
        u(i2, i3, "index");
        return i2;
    }

    public static int u(int i2, int i3, String str) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(b(i2, i3, str));
        }
        return i2;
    }

    public static void v(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(c(i2, i3, i4));
        }
    }

    public static void w(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void x(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void y(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalStateException(q.b(str, Integer.valueOf(i2)));
        }
    }

    public static void z(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(q.b(str, Long.valueOf(j)));
        }
    }
}
