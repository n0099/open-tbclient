package d.a.l0.a.n0.h;

import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43601a;

    static {
        boolean z = k.f43199a;
        f43601a = b("swan_clean_pkg_opt", 0);
    }

    public static boolean a() {
        return f43601a;
    }

    public static boolean b(String str, int i2) {
        d.a.l0.a.c1.a.Z().getSwitch(str, i2);
        d.a.l0.a.e0.d.h("CleanPkgSwitcher", str + " value from AB : " + i2);
        return i2 == 1;
    }
}
