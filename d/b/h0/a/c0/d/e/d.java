package d.b.h0.a.c0.d.e;

import android.os.Bundle;
import d.b.h0.a.i2.u;
import d.b.h0.a.r1.e;
/* loaded from: classes2.dex */
public class d implements d.b.h0.a.c0.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f44370a;

    public static void d() {
        e y = e.y();
        if (y == null) {
            return;
        }
        d.b.h0.a.i2.e.i(y.A());
        System.exit(0);
    }

    public static String e() {
        return f44370a;
    }

    @Override // d.b.h0.a.c0.d.a
    public String a() {
        return b.d().getPath();
    }

    @Override // d.b.h0.a.c0.d.a
    public void b(Bundle bundle) {
        f44370a = u.i(bundle, "extraWSUrl");
        d.b.h0.a.c0.d.b.i(u.i(bundle, "masterPreload"));
        d.b.h0.a.c0.d.b.j(u.i(bundle, "slavePreload"));
    }

    @Override // d.b.h0.a.c0.d.a
    public void c(Bundle bundle) {
        bundle.putString("extraWSUrl", f44370a);
        bundle.putString("slavePreload", d.b.h0.a.c0.d.b.c());
        bundle.putString("masterPreload", d.b.h0.a.c0.d.b.a());
    }
}
