package d.a.m0.a.h0.o.e;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a2.e;
import d.a.m0.a.h0.l.g.h;
import d.a.m0.a.k;
import d.a.m0.a.v1.b.d;
import d.a.m0.a.v1.b.f;
import d.a.m0.a.v2.l0;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46226a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46227b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46228c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46229d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46230e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46231f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f46232g;

    /* renamed from: d.a.m0.a.h0.o.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0746a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", a.f());
            return bundle2;
        }
    }

    static {
        f46227b = ProcessUtils.isMainProcess() ? h("swan_prefetch_app_data") : e();
        f46228c = h("swan_prefetch_slave_data");
        f46229d = h("swan_prefetch_click");
        f46230e = h("swan_prefetch_event_on");
        f46231f = h("swan_prefetch_sub_pkg");
        f46232g = d("swan_prefetch_app_data_multi", 0);
        if (f46226a) {
            Log.i("PrefetchABSwitcher", "prefetch switch - " + f46227b);
            Log.i("PrefetchABSwitcher", "master prefetch switch -  " + f46230e);
            Log.i("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f46231f);
            Log.i("PrefetchABSwitcher", "master multi preload switch -  " + f46232g);
        }
    }

    public static boolean a() {
        return f46229d;
    }

    public static int b(String str) {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt(str, -1);
    }

    public static int c() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("swan_prefetch_event", -1);
    }

    public static int d(String str, int i2) {
        int b2;
        if (!f46226a || (b2 = b(str)) == -1) {
            d.a.m0.a.c1.a.Z().getSwitch(str, i2);
            Log.d("PrefetchABSwitcher", str + " value from AB : " + i2);
            return i2;
        }
        return b2;
    }

    public static boolean e() {
        long currentTimeMillis = f46226a ? System.currentTimeMillis() : 0L;
        f b2 = d.b(C0746a.class, null);
        boolean z = false;
        if (b2.a() && b2.f49079a.getBoolean("result", false)) {
            z = true;
        }
        if (f46226a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("PrefetchABSwitcher", "get prefetch switch cross precess cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
        return z;
    }

    public static boolean f() {
        return f46227b;
    }

    public static boolean g() {
        boolean z = !l0.f("3.290.0");
        if (!f46226a || b("swan_prefetch_app_data_multi") <= 0) {
            return z;
        }
        return true;
    }

    public static boolean h(String str) {
        int b2;
        if (f46226a) {
            if (d.a.m0.a.u1.a.a.W() || (b2 = b(str)) == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
        }
        return d(str, 0) == 1;
    }

    public static void i() {
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "preload master is on = " + f46227b);
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "preload slave is on = " + f46228c);
        e Q = e.Q();
        boolean z = Q != null && k(Q.L().f0());
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "prefetch master show is on = " + z);
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "prefetch master click is on = " + f46229d);
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "sub pkg prefetch switch -  " + f46231f);
        d.a.m0.a.h0.l.g.a a2 = h.b().a();
        if (a2 != null) {
            d.a.m0.a.e0.d.h("PrefetchABSwitcher", "current running master id = " + a2.i().b());
        }
        d.a.m0.a.e0.d.h("PrefetchABSwitcher", "master multi preload switch -  " + f46232g);
    }

    public static int j() {
        return f46232g;
    }

    public static boolean k(PMSAppInfo pMSAppInfo) {
        if (f()) {
            if (k.f46983a) {
                int c2 = c();
                if (c2 == 1) {
                    return true;
                }
                if (c2 == 0) {
                    return false;
                }
            }
            return f46230e && d.a.m0.a.l1.d.d.f().h(pMSAppInfo);
        }
        return false;
    }

    public static boolean l() {
        return f46228c;
    }

    public static boolean m() {
        return f46231f;
    }
}
