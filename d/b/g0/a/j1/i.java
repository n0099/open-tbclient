package d.b.g0.a.j1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.l;
import d.b.g0.a.i2.p;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45275a = d.b.g0.a.k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45276b;

    /* renamed from: c  reason: collision with root package name */
    public static Timer f45277c;

    /* renamed from: d  reason: collision with root package name */
    public static String f45278d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static volatile d.b.g0.a.j1.b f45279e;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f45280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45281f;

        public a(d.b.g0.a.y0.e.b bVar, boolean z) {
            this.f45280e = bVar;
            this.f45281f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.h(this.f45280e, this.f45281f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f45282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f45284g;

        public b(d.b.g0.a.y0.e.b bVar, String str, boolean z) {
            this.f45282e = bVar;
            this.f45283f = str;
            this.f45284g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow o = i.o("startup");
            String S = TextUtils.isEmpty(this.f45282e.S()) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f45282e.S();
            if (this.f45282e.F() == 1) {
                o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            }
            o.z("from", "swan");
            o.z("source", S);
            o.y("appid", this.f45282e.G());
            o.y("swan", d.b.g0.a.b2.b.g(this.f45282e.f0(), this.f45282e.F()));
            o.y("mobile", l.a());
            long k = this.f45282e.k("box_cold_launch", -1L);
            if (k < 0) {
                k = d.b.g0.a.j1.c.a();
            }
            if (k > 0) {
                o.y("box_cold_launch", String.valueOf(k));
            }
            o.y("net", SwanAppNetworkUtils.f().type);
            o.y("appversion", this.f45282e.n1());
            o.y("thirdversion", this.f45282e.o1());
            o.z("from", this.f45282e.F() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
            o.y("scheme", this.f45282e.V());
            HashSet hashSet = new HashSet();
            hashSet.add("callback");
            hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
            String h2 = i0.h(this.f45283f, hashSet);
            if (!TextUtils.isEmpty(h2) && h2.startsWith(File.separator)) {
                h2 = h2.substring(1);
            }
            o.y("path", TextUtils.isEmpty(h2) ? "" : h2);
            if (i.f45275a) {
                StringBuilder sb = new StringBuilder();
                sb.append("PerformanceUbc path: ");
                if (TextUtils.isEmpty(h2)) {
                    h2 = "";
                }
                sb.append(h2);
                Log.v("SwanAppPerformanceUBC", sb.toString());
            }
            if (this.f45284g) {
                o.z("value", "arrive_success");
            }
            o.y("launchid", this.f45282e.U());
            if (this.f45282e.F() == 0) {
                o.w();
            }
            d.b.g0.a.c0.c.h("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f45282e);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            i.l();
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends d.b.g0.a.z1.k.e {
        public static int m = 35;
        public final String j;
        public JSONObject k;
        public boolean l = true;

        public d(String str) {
            this.j = str;
        }

        @Override // d.b.g0.a.z1.k.e
        public JSONObject f() {
            this.f47645c = TextUtils.isEmpty(this.f47645c) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f47645c;
            if (this.f47649g == null) {
                this.f47649g = new JSONObject();
            }
            try {
                if (this.k != null) {
                    if (this.l) {
                        String v = k0.v(m);
                        if (!TextUtils.isEmpty(v)) {
                            this.k.put("stacktrace", v);
                        }
                    }
                    this.f47649g.put("info", this.k);
                }
            } catch (JSONException e2) {
                if (d.b.g0.a.z1.k.e.i) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }

        public d g(String str) {
            this.f47643a = str;
            return this;
        }

        public d h(String str) {
            this.f47645c = str;
            return this;
        }

        public d i(String str) {
            this.f47644b = str;
            return this;
        }
    }

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_performance_aligned_search_switch", false);
        f45276b = false;
    }

    public static String c(d.b.g0.a.y0.e.b bVar) {
        String b0 = bVar.b0();
        if (TextUtils.isEmpty(b0)) {
            if (TextUtils.isEmpty(f45278d)) {
                f45278d = d.b.g0.a.t1.k.p0.c.c();
                if (f45275a) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + f45278d);
                }
            } else if (f45275a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + f45278d);
            }
        } else {
            f45278d = b0;
            if (f45275a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f45278d);
            }
        }
        return f45278d;
    }

    public static synchronized HybridUbcFlow d(String str) {
        HybridUbcFlow b2;
        synchronized (i.class) {
            b2 = e().b(str);
        }
        return b2;
    }

    public static d.b.g0.a.j1.b e() {
        if (f45279e == null) {
            synchronized (d.b.g0.a.j1.b.class) {
                if (f45279e == null) {
                    f45279e = new d.b.g0.a.j1.b();
                    f(f45279e);
                }
            }
        }
        return f45279e;
    }

    public static void f(d.b.g0.a.j1.b bVar) {
        bVar.d("preload", new d.b.g0.a.j1.n.a());
        bVar.d("startup", new d.b.g0.a.j1.n.c());
        bVar.d(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, new d.b.g0.a.j1.n.b());
        bVar.d("video", new d.b.g0.a.j1.n.d());
    }

    public static synchronized void g(String str, String str2) {
        synchronized (i.class) {
            HybridUbcFlow b2 = e().b(str);
            if (b2 != null) {
                e().e(str2).v(b2);
                q(str);
            }
        }
    }

    public static void h(d.b.g0.a.y0.e.b bVar, boolean z) {
        d.b.g0.a.c0.c.h("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar == null || bVar.O() == null) {
            return;
        }
        p.j(new b(bVar, c(bVar), z), "recordFromLaunchInfo");
    }

    public static void i(d.b.g0.a.y0.e.b bVar, boolean z) {
        d.b.g0.a.r1.d.g().post(new a(bVar, z));
    }

    public static synchronized void j(d.b.g0.a.f2.a aVar) {
        synchronized (i.class) {
            HybridUbcFlow l = l();
            if (l != null) {
                l.z("value", SmsLoginView.f.l);
                if (aVar != null) {
                    l.y("statusCode", String.valueOf(aVar.a()));
                    l.y("launchid", d.b.g0.a.r1.d.e().s().J().U());
                }
                l.k();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void k(String str) {
        char c2;
        switch (str.hashCode()) {
            case -952207494:
                if (str.equals("independent")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -533350585:
                if (str.equals("subNormal")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -285446714:
                if (str.equals("dynamicLib")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3343801:
                if (str.equals(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        o("startup").y("package_type", c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "-1" : "3" : "1" : "2" : "0");
    }

    public static synchronized HybridUbcFlow l() {
        synchronized (i.class) {
            s();
            d.b.g0.a.s0.k.f.b.a();
            HybridUbcFlow d2 = d("startup");
            if (d2 == null) {
                return null;
            }
            d2.A(new UbcFlowEvent("performanceEnd"));
            d2.w();
            d2.x();
            d2.O();
            d2.N();
            return d2;
        }
    }

    public static void m() {
        Timer timer = new Timer();
        f45277c = timer;
        timer.schedule(new c(), 15000L);
    }

    @Deprecated
    public static synchronized HybridUbcFlow n() {
        HybridUbcFlow o;
        synchronized (i.class) {
            o = o("startup");
        }
        return o;
    }

    public static synchronized HybridUbcFlow o(String str) {
        HybridUbcFlow e2;
        synchronized (i.class) {
            e2 = e().e(str);
        }
        return e2;
    }

    public static void onEvent(d dVar) {
        if (f45275a) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + dVar);
        }
        d.b.g0.a.z1.b.j(dVar.j, dVar.f());
    }

    public static synchronized HybridUbcFlow p(String str, String str2) {
        HybridUbcFlow f2;
        synchronized (i.class) {
            f2 = e().f(str, str2);
        }
        return f2;
    }

    public static synchronized void q(String str) {
        synchronized (i.class) {
            e().g(str);
        }
    }

    public static synchronized void r(String str, String str2) {
        synchronized (i.class) {
            e().h(str, str2);
        }
    }

    public static void s() {
        Timer timer = f45277c;
        if (timer != null) {
            timer.cancel();
            f45277c = null;
        }
    }
}
