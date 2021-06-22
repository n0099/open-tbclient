package d.a.m0.a.e0.f.f;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.a2.e;
import d.a.m0.a.v2.f;
import d.a.m0.a.v2.v;
/* loaded from: classes3.dex */
public class d implements d.a.m0.a.e0.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f45261a;

    public static void d() {
        e i2 = e.i();
        if (i2 == null) {
            return;
        }
        f.j(i2.k());
        System.exit(0);
    }

    public static String e() {
        return f45261a;
    }

    @Override // d.a.m0.a.e0.f.a
    public void a(Bundle bundle) {
        f45261a = v.i(bundle, "extraWSUrl");
        d.a.m0.a.e0.f.b.i(v.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
        d.a.m0.a.e0.f.b.j(v.i(bundle, "slavePreload"));
    }

    @Override // d.a.m0.a.e0.f.a
    public void b(Bundle bundle) {
        bundle.putString("extraWSUrl", f45261a);
        bundle.putString("slavePreload", d.a.m0.a.e0.f.b.c());
        bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, d.a.m0.a.e0.f.b.a());
    }

    @Override // d.a.m0.a.e0.f.a
    public String c() {
        return b.e().getPath();
    }
}
