package d.b.g0.a.j1;

import android.text.TextUtils;
import android.util.Log;
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
    public static final boolean f44883a = d.b.g0.a.k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44884b;

    /* renamed from: c  reason: collision with root package name */
    public static Timer f44885c;

    /* renamed from: d  reason: collision with root package name */
    public static String f44886d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static volatile d.b.g0.a.j1.b f44887e;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f44888e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44889f;

        public a(d.b.g0.a.y0.e.b bVar, boolean z) {
            this.f44888e = bVar;
            this.f44889f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.h(this.f44888e, this.f44889f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f44890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44891f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44892g;

        public b(d.b.g0.a.y0.e.b bVar, String str, boolean z) {
            this.f44890e = bVar;
            this.f44891f = str;
            this.f44892g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow o = i.o("startup");
            String S = TextUtils.isEmpty(this.f44890e.S()) ? "NA" : this.f44890e.S();
            if (this.f44890e.F() == 1) {
                o.D(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            }
            o.z("from", "swan");
            o.z("source", S);
            o.y("appid", this.f44890e.G());
            o.y("swan", d.b.g0.a.b2.b.g(this.f44890e.f0(), this.f44890e.F()));
            o.y("mobile", l.a());
            long k = this.f44890e.k("box_cold_launch", -1L);
            if (k < 0) {
                k = d.b.g0.a.j1.c.a();
            }
            if (k > 0) {
                o.y("box_cold_launch", String.valueOf(k));
            }
            o.y("net", SwanAppNetworkUtils.f().type);
            o.y("appversion", this.f44890e.n1());
            o.y("thirdversion", this.f44890e.o1());
            o.z("from", this.f44890e.F() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
            o.y("scheme", this.f44890e.V());
            HashSet hashSet = new HashSet();
            hashSet.add("callback");
            hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
            String h2 = i0.h(this.f44891f, hashSet);
            if (!TextUtils.isEmpty(h2) && h2.startsWith(File.separator)) {
                h2 = h2.substring(1);
            }
            o.y("path", TextUtils.isEmpty(h2) ? "" : h2);
            if (i.f44883a) {
                StringBuilder sb = new StringBuilder();
                sb.append("PerformanceUbc path: ");
                if (TextUtils.isEmpty(h2)) {
                    h2 = "";
                }
                sb.append(h2);
                Log.v("SwanAppPerformanceUBC", sb.toString());
            }
            if (this.f44892g) {
                o.z("value", "arrive_success");
            }
            o.y("launchid", this.f44890e.U());
            if (this.f44890e.F() == 0) {
                o.w();
            }
            d.b.g0.a.c0.c.h("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f44890e);
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
            this.f47253c = TextUtils.isEmpty(this.f47253c) ? "NA" : this.f47253c;
            if (this.f47257g == null) {
                this.f47257g = new JSONObject();
            }
            try {
                if (this.k != null) {
                    if (this.l) {
                        String v = k0.v(m);
                        if (!TextUtils.isEmpty(v)) {
                            this.k.put("stacktrace", v);
                        }
                    }
                    this.f47257g.put("info", this.k);
                }
            } catch (JSONException e2) {
                if (d.b.g0.a.z1.k.e.i) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }

        public d g(String str) {
            this.f47251a = str;
            return this;
        }

        public d h(String str) {
            this.f47253c = str;
            return this;
        }

        public d i(String str) {
            this.f47252b = str;
            return this;
        }
    }

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_performance_aligned_search_switch", false);
        f44884b = false;
    }

    public static String c(d.b.g0.a.y0.e.b bVar) {
        String b0 = bVar.b0();
        if (TextUtils.isEmpty(b0)) {
            if (TextUtils.isEmpty(f44886d)) {
                f44886d = d.b.g0.a.t1.k.p0.c.c();
                if (f44883a) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + f44886d);
                }
            } else if (f44883a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + f44886d);
            }
        } else {
            f44886d = b0;
            if (f44883a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f44886d);
            }
        }
        return f44886d;
    }

    public static synchronized HybridUbcFlow d(String str) {
        HybridUbcFlow b2;
        synchronized (i.class) {
            b2 = e().b(str);
        }
        return b2;
    }

    public static d.b.g0.a.j1.b e() {
        if (f44887e == null) {
            synchronized (d.b.g0.a.j1.b.class) {
                if (f44887e == null) {
                    f44887e = new d.b.g0.a.j1.b();
                    f(f44887e);
                }
            }
        }
        return f44887e;
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
        f44885c = timer;
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
        if (f44883a) {
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
        Timer timer = f44885c;
        if (timer != null) {
            timer.cancel();
            f44885c = null;
        }
    }
}
