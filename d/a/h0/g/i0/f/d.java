package d.a.h0.g.i0.f;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import d.a.h0.a.k;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46419a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static long f46420b = -1;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final long f46421a = d.f46420b;

        static {
            if (d.f46419a) {
                Log.i("SwanSoLoader", "CURRENT_V8_SO_VERSION: " + f46421a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c() {
        Iterator<d.a.h0.a.n1.c.f.c> it = d.a.h0.a.n1.c.f.e.j().p().iterator();
        while (it.hasNext()) {
            d.a.h0.a.n1.c.f.c next = it.next();
            if (next.D() || next.C()) {
                return;
            }
            while (it.hasNext()) {
            }
        }
        d.a.h0.a.w0.a.L().a();
    }

    public static void d() {
        d.a.h0.a.w0.a.L().g();
    }

    public static String e() {
        return d.a.h0.a.w0.a.L().f(a.f46421a);
    }

    public static long f() {
        return a.f46421a;
    }

    public static boolean g() {
        boolean z = a.f46421a > -1;
        if (f46419a) {
            Log.d("SwanSoLoader", "isNeedToLoadNewV8So: " + z);
        }
        return z;
    }

    public static boolean h() {
        return SoLoader.load(AppRuntime.getAppContext(), "audioengine");
    }

    public static f i() {
        if (!d.a.h0.a.w0.a.b0().c()) {
            return d.a.h0.a.e0.u.a.c(false);
        }
        if (g()) {
            d.a.h0.a.w0.a.L().b(a.f46421a);
            return f.e();
        }
        return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
    }

    public static void j(Bundle bundle) {
        bundle.putLong("bundle_key_new_v8_so_switch", d.a.h0.a.w0.a.L().d());
    }

    public static void k(Intent intent) {
        if (intent != null && intent.hasExtra("bundle_key_new_v8_so_switch")) {
            f46420b = intent.getLongExtra("bundle_key_new_v8_so_switch", f46420b);
        }
        if (f46419a) {
            Log.i("SwanSoLoader", "updateNewV8SoEnabled: " + f46420b);
        }
    }
}
