package d.a.i0.a.n0.h;

import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43427a;

    static {
        boolean z = k.f43025a;
        f43427a = b("swan_clean_pkg_opt", 0);
    }

    public static boolean a() {
        return f43427a;
    }

    public static boolean b(String str, int i2) {
        d.a.i0.a.c1.a.Z().getSwitch(str, i2);
        d.a.i0.a.e0.d.h("CleanPkgSwitcher", str + " value from AB : " + i2);
        return i2 == 1;
    }
}
