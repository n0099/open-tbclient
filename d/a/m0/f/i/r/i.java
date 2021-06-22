package d.a.m0.f.i.r;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class i {
    public static String a() {
        return d.a.m0.f.i.m.a.a().m();
    }

    public static String b() {
        return d.a.m0.f.i.m.a.a().e();
    }

    public static String c() {
        return d.a.m0.f.i.m.a.a().g();
    }

    public static String d() {
        return d.a.m0.f.i.m.a.a().l();
    }

    public static boolean e() {
        return (TextUtils.isEmpty(a()) || TextUtils.isEmpty(b()) || System.currentTimeMillis() - d.a.m0.f.i.m.a.a().i().longValue() >= 604800000) ? false : true;
    }

    public static boolean f() {
        return (TextUtils.isEmpty(c()) || TextUtils.isEmpty(d()) || System.currentTimeMillis() - d.a.m0.f.i.m.a.a().i().longValue() >= 604800000) ? false : true;
    }

    public static boolean g() {
        return d.a.m0.f.i.m.a.a().k() && f();
    }

    public static boolean h() {
        return f() && d.a.m0.f.i.m.a.a().d();
    }

    public static boolean i() {
        return d.a.m0.f.i.m.a.a().c();
    }
}
