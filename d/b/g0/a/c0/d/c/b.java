package d.b.g0.a.c0.d.c;

import android.os.Bundle;
import d.b.g0.a.i2.u;
/* loaded from: classes2.dex */
public class b implements d.b.g0.a.c0.d.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f43993a = "";

    public static String d() {
        return f43993a;
    }

    @Override // d.b.g0.a.c0.d.a
    public String a() {
        return a.b().getPath();
    }

    @Override // d.b.g0.a.c0.d.a
    public void b(Bundle bundle) {
        f43993a = u.i(bundle, "adb_debug_path");
        d.b.g0.a.c0.d.b.i(u.i(bundle, "masterPreload"));
        d.b.g0.a.c0.d.b.j(u.i(bundle, "slavePreload"));
    }

    @Override // d.b.g0.a.c0.d.a
    public void c(Bundle bundle) {
        bundle.putString("adb_debug_path", f43993a);
        bundle.putString("slavePreload", d.b.g0.a.c0.d.b.c());
        bundle.putString("masterPreload", d.b.g0.a.c0.d.b.a());
    }
}
