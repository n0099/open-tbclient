package d.a.h0.a.c0.d.c;

import android.os.Bundle;
import d.a.h0.a.i2.u;
/* loaded from: classes2.dex */
public class b implements d.a.h0.a.c0.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f41606a = "";

    public static String d() {
        return f41606a;
    }

    @Override // d.a.h0.a.c0.d.a
    public void a(Bundle bundle) {
        f41606a = u.i(bundle, "adb_debug_path");
        d.a.h0.a.c0.d.b.i(u.i(bundle, "masterPreload"));
        d.a.h0.a.c0.d.b.j(u.i(bundle, "slavePreload"));
    }

    @Override // d.a.h0.a.c0.d.a
    public void b(Bundle bundle) {
        bundle.putString("adb_debug_path", f41606a);
        bundle.putString("slavePreload", d.a.h0.a.c0.d.b.c());
        bundle.putString("masterPreload", d.a.h0.a.c0.d.b.a());
    }

    @Override // d.a.h0.a.c0.d.a
    public String c() {
        return a.b().getPath();
    }
}
