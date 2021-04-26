package d.a.h0.a.c0.d.e;

import android.os.Bundle;
import d.a.h0.a.i2.u;
import d.a.h0.a.r1.e;
/* loaded from: classes2.dex */
public class d implements d.a.h0.a.c0.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f41657a;

    public static void d() {
        e h2 = e.h();
        if (h2 == null) {
            return;
        }
        d.a.h0.a.i2.e.i(h2.A());
        System.exit(0);
    }

    public static String e() {
        return f41657a;
    }

    @Override // d.a.h0.a.c0.d.a
    public void a(Bundle bundle) {
        f41657a = u.i(bundle, "extraWSUrl");
        d.a.h0.a.c0.d.b.i(u.i(bundle, "masterPreload"));
        d.a.h0.a.c0.d.b.j(u.i(bundle, "slavePreload"));
    }

    @Override // d.a.h0.a.c0.d.a
    public void b(Bundle bundle) {
        bundle.putString("extraWSUrl", f41657a);
        bundle.putString("slavePreload", d.a.h0.a.c0.d.b.c());
        bundle.putString("masterPreload", d.a.h0.a.c0.d.b.a());
    }

    @Override // d.a.h0.a.c0.d.a
    public String c() {
        return b.d().getPath();
    }
}
