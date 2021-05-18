package d.a.i0.a.e0.f.f;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.a2.e;
import d.a.i0.a.v2.f;
import d.a.i0.a.v2.v;
/* loaded from: classes2.dex */
public class d implements d.a.i0.a.e0.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f41303a;

    public static void d() {
        e i2 = e.i();
        if (i2 == null) {
            return;
        }
        f.j(i2.k());
        System.exit(0);
    }

    public static String e() {
        return f41303a;
    }

    @Override // d.a.i0.a.e0.f.a
    public void a(Bundle bundle) {
        f41303a = v.i(bundle, "extraWSUrl");
        d.a.i0.a.e0.f.b.i(v.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
        d.a.i0.a.e0.f.b.j(v.i(bundle, "slavePreload"));
    }

    @Override // d.a.i0.a.e0.f.a
    public void b(Bundle bundle) {
        bundle.putString("extraWSUrl", f41303a);
        bundle.putString("slavePreload", d.a.i0.a.e0.f.b.c());
        bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, d.a.i0.a.e0.f.b.a());
    }

    @Override // d.a.i0.a.e0.f.a
    public String c() {
        return b.e().getPath();
    }
}
