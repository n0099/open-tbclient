package d.a.m0.a.r1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.m0.a.k;
import d.a.m0.a.v2.m;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.File;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48220a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48221b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48222c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f48223d;

    /* renamed from: e  reason: collision with root package name */
    public static String f48224e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static volatile d.a.m0.a.r1.b f48225f;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f48226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48227f;

        public a(d.a.m0.a.f1.e.b bVar, boolean z) {
            this.f48226e = bVar;
            this.f48227f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.i(this.f48226e, this.f48227f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f48228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48230g;

        public b(d.a.m0.a.f1.e.b bVar, String str, boolean z) {
            this.f48228e = bVar;
            this.f48229f = str;
            this.f48230g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow p = h.p("startup");
            String T = TextUtils.isEmpty(this.f48228e.T()) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f48228e.T();
            if (this.f48228e.G() == 1) {
                p.F(HybridUbcFlow.SubmitStrategy.NA_ONLY);
            }
            p.B("from", "swan");
            p.B("source", T);
            p.A("appid", this.f48228e.H());
            p.A("swan", d.a.m0.a.m2.b.i(this.f48228e.i0(), this.f48228e.G()));
            p.A("mobile", m.c());
            long l = this.f48228e.l("box_cold_launch", -1L);
            if (l < 0) {
                l = d.a.m0.a.r1.c.a();
            }
            if (l > 0) {
                p.A("box_cold_launch", String.valueOf(l));
            }
            p.A("net", SwanAppNetworkUtils.f().type);
            p.A("appversion", this.f48228e.u1());
            p.A("thirdversion", this.f48228e.v1());
            p.B("from", this.f48228e.G() == 1 ? SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : "swan");
            p.A("scheme", this.f48228e.W());
            HashSet hashSet = new HashSet();
            hashSet.add("callback");
            hashSet.add(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE);
            String i2 = o0.i(this.f48229f, hashSet);
            if (!TextUtils.isEmpty(i2) && i2.startsWith(File.separator)) {
                i2 = i2.substring(1);
            }
            p.A("path", TextUtils.isEmpty(i2) ? "" : i2);
            if (h.f48220a) {
                StringBuilder sb = new StringBuilder();
                sb.append("PerformanceUbc path: ");
                if (TextUtils.isEmpty(i2)) {
                    i2 = "";
                }
                sb.append(i2);
                Log.v("SwanAppPerformanceUBC", sb.toString());
            }
            if (this.f48230g) {
                p.B("value", "arrive_success");
            }
            p.A("launchid", this.f48228e.V());
            p.A("isPreDownloading", this.f48228e.r0().getString("aiapp_extra_pkg_downloading", "0"));
            p.A("isReloadApp", this.f48228e.d("launch_by_reload") ? "1" : "0");
            p.A("preAppReadyState", String.valueOf(d.a.m0.a.h0.u.b.a(this.f48228e)));
            if (this.f48228e.G() == 0) {
                p.A("is_opti", d.a.m0.a.l1.d.d.f().g(this.f48228e.f0()) ? "1" : "0");
                p.x();
            }
            d.a.m0.a.e0.d.h("SwanAppPerformanceUBC", "recordFromLaunchInfoForStartup" + this.f48228e);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            h.m();
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends d.a.m0.a.j2.p.e {
        public static int n = 35;
        public final String k;
        public JSONObject l;
        public boolean m = true;

        public d(String str) {
            this.k = str;
        }

        @Override // d.a.m0.a.j2.p.e
        public JSONObject f() {
            this.f46971c = TextUtils.isEmpty(this.f46971c) ? AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA : this.f46971c;
            if (this.f46976h == null) {
                this.f46976h = new JSONObject();
            }
            try {
                if (this.l != null) {
                    if (this.m) {
                        String z = q0.z(n);
                        if (!TextUtils.isEmpty(z)) {
                            this.l.put("stacktrace", z);
                        }
                    }
                    this.f46976h.put("info", this.l);
                }
            } catch (JSONException e2) {
                if (d.a.m0.a.j2.p.e.j) {
                    e2.printStackTrace();
                }
            }
            return super.f();
        }

        public d g(String str) {
            this.f46969a = str;
            return this;
        }

        public d h(String str) {
            this.f46971c = str;
            return this;
        }

        public d i(String str) {
            this.f46970b = str;
            return this;
        }
    }

    static {
        d.a.m0.a.c1.a.Z().getSwitch("swan_performance_aligned_search_switch", false);
        f48221b = false;
        d.a.m0.a.c1.a.Z().getSwitch("swan_app_use_performance_end_v2", false);
        f48222c = false;
    }

    public static String c(d.a.m0.a.f1.e.b bVar) {
        String e0 = bVar.e0();
        if (TextUtils.isEmpty(e0)) {
            if (TextUtils.isEmpty(f48224e)) {
                f48224e = d.a.m0.a.c2.f.p0.c.b();
                if (f48220a) {
                    Log.v("SwanAppPerformanceUBC", "chechPath- 冷启场景 path 为空，取首页 path: " + f48224e);
                }
            } else if (f48220a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 热启场景 path 为空，使用上次调起 path: " + f48224e);
            }
        } else {
            f48224e = e0;
            if (f48220a) {
                Log.v("SwanAppPerformanceUBC", "chechPath- 冷/热启场景 path 不为空，直接使用调起 path: " + f48224e);
            }
        }
        return f48224e;
    }

    public static synchronized HybridUbcFlow d(String str) {
        HybridUbcFlow b2;
        synchronized (h.class) {
            b2 = f().b(str);
        }
        return b2;
    }

    public static synchronized HybridUbcFlow e(String str, String str2) {
        HybridUbcFlow c2;
        synchronized (h.class) {
            c2 = f().c(str, str2);
        }
        return c2;
    }

    public static d.a.m0.a.r1.b f() {
        if (f48225f == null) {
            synchronized (d.a.m0.a.r1.b.class) {
                if (f48225f == null) {
                    f48225f = new d.a.m0.a.r1.b();
                    g(f48225f);
                }
            }
        }
        return f48225f;
    }

    public static void g(d.a.m0.a.r1.b bVar) {
        bVar.d("preload", new d.a.m0.a.r1.m.a());
        bVar.d("startup", new d.a.m0.a.r1.m.c());
        bVar.d(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, new d.a.m0.a.r1.m.b());
        bVar.d("video", new d.a.m0.a.r1.m.d());
    }

    public static synchronized void h(String str, String str2) {
        synchronized (h.class) {
            HybridUbcFlow b2 = f().b(str);
            if (b2 != null) {
                f().e(str2).w(b2);
                r(str);
            }
        }
    }

    public static void i(d.a.m0.a.f1.e.b bVar, boolean z) {
        d.a.m0.a.e0.d.h("SwanAppPerformanceUBC", "recordForStartup");
        if (bVar == null || bVar.P() == null) {
            return;
        }
        q.i(new b(bVar, c(bVar), z), "recordFromLaunchInfo");
    }

    public static void j(d.a.m0.a.f1.e.b bVar, boolean z) {
        d.a.m0.a.a2.d.i().post(new a(bVar, z));
    }

    public static synchronized void k(d.a.m0.a.q2.a aVar) {
        synchronized (h.class) {
            HybridUbcFlow m = m();
            if (m != null) {
                m.B("value", SmsLoginView.f.l);
                if (aVar != null) {
                    m.A("statusCode", String.valueOf(aVar.a()));
                    m.A("launchid", d.a.m0.a.a2.d.g().r().L().V());
                }
                m.l();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void l(String str) {
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
        p("startup").A("package_type", c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? "-1" : "3" : "1" : "2" : "0");
    }

    public static synchronized HybridUbcFlow m() {
        d.a.m0.a.h0.g.f o;
        synchronized (h.class) {
            t();
            d.a.m0.a.y0.k.f.b.a();
            HybridUbcFlow d2 = d("startup");
            d.a.m0.a.p.e.b bVar = null;
            if (d2 == null) {
                return null;
            }
            d2.C(new UbcFlowEvent("performanceEnd"));
            if (!d2.q()) {
                d2.x();
            }
            d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
            if (W != null && (o = W.o()) != null) {
                bVar = o.b3();
            }
            d2.z(bVar);
            if (!d2.u()) {
                d2.Q();
            }
            if (!d2.t()) {
                d2.P();
            }
            return d2;
        }
    }

    public static void n() {
        Timer timer = new Timer();
        f48223d = timer;
        timer.schedule(new c(), 15000L);
    }

    @Deprecated
    public static synchronized HybridUbcFlow o() {
        HybridUbcFlow p;
        synchronized (h.class) {
            p = p("startup");
        }
        return p;
    }

    public static void onEvent(d dVar) {
        if (f48220a) {
            Log.i("SwanAppPerformanceUBC", "onEvent " + dVar);
        }
        d.a.m0.a.j2.b.k(dVar.k, dVar.f());
    }

    public static synchronized HybridUbcFlow p(String str) {
        HybridUbcFlow e2;
        synchronized (h.class) {
            e2 = f().e(str);
        }
        return e2;
    }

    public static synchronized HybridUbcFlow q(String str, String str2) {
        HybridUbcFlow f2;
        synchronized (h.class) {
            f2 = f().f(str, str2);
        }
        return f2;
    }

    public static synchronized void r(String str) {
        synchronized (h.class) {
            f().g(str);
        }
    }

    public static synchronized void s(String str, String str2) {
        synchronized (h.class) {
            f().h(str, str2);
        }
    }

    public static void t() {
        Timer timer = f48223d;
        if (timer != null) {
            timer.cancel();
            f48223d = null;
        }
    }
}
