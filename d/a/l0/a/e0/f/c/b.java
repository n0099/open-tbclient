package d.a.l0.a.e0.f.c;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.v2.v;
/* loaded from: classes2.dex */
public class b implements d.a.l0.a.e0.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static String f41358a = "";

    public static String d() {
        return f41358a;
    }

    @Override // d.a.l0.a.e0.f.a
    public void a(Bundle bundle) {
        f41358a = v.i(bundle, "adb_debug_path");
        d.a.l0.a.e0.f.b.i(v.i(bundle, PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD));
        d.a.l0.a.e0.f.b.j(v.i(bundle, "slavePreload"));
    }

    @Override // d.a.l0.a.e0.f.a
    public void b(Bundle bundle) {
        bundle.putString("adb_debug_path", f41358a);
        bundle.putString("slavePreload", d.a.l0.a.e0.f.b.c());
        bundle.putString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, d.a.l0.a.e0.f.b.a());
    }

    @Override // d.a.l0.a.e0.f.a
    public String c() {
        return a.b().getPath();
    }
}
