package d.b.g0.e.a.q;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class f {
    public static String a() {
        return d.b.g0.g.i0.c.A().y();
    }

    public static String b() {
        return d.b.g0.g.i0.c.A().v();
    }

    public static String c() {
        return d.b.g0.g.i0.c.A().z();
    }

    public static String d() {
        return d.b.g0.g.i0.c.A().x();
    }

    public static boolean e() {
        return (TextUtils.isEmpty(a()) || TextUtils.isEmpty(b()) || System.currentTimeMillis() - d.b.g0.g.i0.c.A().w().longValue() >= 604800000) ? false : true;
    }

    public static boolean f() {
        return (TextUtils.isEmpty(c()) || TextUtils.isEmpty(d()) || System.currentTimeMillis() - d.b.g0.g.i0.c.A().w().longValue() >= 604800000) ? false : true;
    }

    public static boolean g() {
        return d.b.g0.g.i0.c.A().u() && f();
    }

    public static boolean h() {
        return f() && d.b.g0.g.i0.c.A().B();
    }

    public static boolean i() {
        return d.b.g0.g.i0.c.A().C();
    }
}
