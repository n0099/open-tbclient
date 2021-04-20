package d.b.g0.g.i0.f;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import d.b.g0.a.k;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48615a = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static long f48616b = -1;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final long f48617a = d.f48616b;

        static {
            if (d.f48615a) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + f48617a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        Iterator<d.b.g0.a.n1.c.f.c> it = d.b.g0.a.n1.c.f.e.j().p().iterator();
        while (it.hasNext()) {
            d.b.g0.a.n1.c.f.c next = it.next();
            if (next.D() || next.C()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        d.b.g0.a.w0.a.L().a();
    }

    public static void d() {
        d.b.g0.a.w0.a.L().b();
    }

    public static String e() {
        return d.b.g0.a.w0.a.L().g(a.f48617a);
    }

    public static long f() {
        return a.f48617a;
    }

    public static boolean g() {
        boolean z = a.f48617a > -1;
        if (f48615a) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static boolean h() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static f i() {
        if (!d.b.g0.a.w0.a.b0().b()) {
            return d.b.g0.a.e0.u.a.c(false);
        }
        if (g()) {
            d.b.g0.a.w0.a.L().c(a.f48617a);
            return f.e();
        }
        return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
    }

    public static void j(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", d.b.g0.a.w0.a.L().e());
    }

    public static void k(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            f48616b = intent.getLongExtra("bundle_key_new_v8_so_switch", f48616b);
        }
        if (f48615a) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + f48616b);
        }
    }
}
