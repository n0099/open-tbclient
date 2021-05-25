package d.a.l0.a.a2;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a2.i;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends m {
    public static final boolean y = d.a.l0.a.k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public final String f40749f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f40750g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f40751h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.l0.a.a2.n.a f40752i;
    public d.a.l0.a.k2.c j;
    public d.a.l0.a.k2.f.d k;
    public d.a.l0.a.e2.a l;
    public d.a.l0.a.m.b m;
    public d.a.l0.a.n1.j n;
    public HttpManager o;
    public d.a.l0.a.b2.a.a p;
    public d.a.l0.a.i1.c.c q;
    public d.a.l0.a.n1.k r;
    public g s;
    public Map<String, String> t;
    public final k u;
    public final b.a v;
    public boolean w;
    public String x;

    public e(h hVar, String str) {
        super(hVar);
        this.u = new k(this);
        this.v = new b.a();
        boolean z = false;
        this.w = false;
        str = str == null ? "" : str;
        this.f40749f = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f40749f, "swan_id_unknown")) ? true : true;
        this.f40750g = z;
        if (z) {
            d.a.l0.a.b2.a.a aVar = new d.a.l0.a.b2.a.a();
            this.p = aVar;
            aVar.f(this.f40749f);
        }
        d.a.l0.a.e0.d.h("SwanApp", "new SwanApp id = " + this.f40749f + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    public static e Q() {
        d g2 = d.g();
        if (g2.C()) {
            return g2.r();
        }
        return null;
    }

    @Deprecated
    public static String V() {
        return d.g().getAppId();
    }

    @Deprecated
    public static e i() {
        return Q();
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public void A(i.a aVar) {
        super.A((i.a) aVar.D(H()));
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public boolean C() {
        return this.f40750g;
    }

    public String D() {
        return L().I();
    }

    public d.a.l0.a.i1.c.c E() {
        if (this.q == null) {
            this.q = new d.a.l0.a.i1.c.c(this);
        }
        return this.q;
    }

    public SwanAppConfigData F() {
        return this.f40751h;
    }

    public String G(String str) {
        SwanAppConfigData.k kVar;
        Map<String, String> map;
        SwanAppConfigData swanAppConfigData = this.f40751h;
        if (swanAppConfigData == null || (kVar = swanAppConfigData.f11248d) == null || (map = kVar.f11286a) == null) {
            return null;
        }
        return map.get(str);
    }

    public final Bundle H() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.f40749f);
        return bundle;
    }

    public d.a.l0.a.a2.n.a I() {
        return this.f40752i;
    }

    @NonNull
    public g J() {
        if (this.s == null) {
            this.s = new g(this);
        }
        return this.s;
    }

    public String K() {
        b.a L = L();
        return L != null ? h(L.t1()) : "0";
    }

    @NonNull
    public b.a L() {
        return this.v;
    }

    @Nullable
    public String M(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.t) == null) {
            return null;
        }
        return map.get(str);
    }

    @NonNull
    @Deprecated
    public b.a N() {
        return L();
    }

    public String O() {
        return L().K();
    }

    public synchronized d.a.l0.a.n1.j P() {
        if (this.n == null) {
            this.n = new d.a.l0.a.n1.j(this);
        }
        return this.n;
    }

    public String R(String str) {
        SwanAppConfigData.j jVar;
        SwanAppConfigData swanAppConfigData = this.f40751h;
        if (swanAppConfigData == null || (jVar = swanAppConfigData.f11247c) == null || jVar.f11282c == null) {
            return null;
        }
        return this.f40751h.f11247c.f11282c.get(d.a.l0.a.c2.f.p0.j.b(str));
    }

    public String S(String str) {
        SwanAppConfigData swanAppConfigData = this.f40751h;
        return swanAppConfigData != null ? swanAppConfigData.g(str) : "";
    }

    @NonNull
    public d.a.l0.a.e2.a T() {
        if (this.l == null) {
            this.l = new d.a.l0.a.e2.a(this);
        }
        return this.l;
    }

    public d.a.l0.a.k2.c U() {
        if (this.j == null) {
            this.j = new d.a.l0.a.k2.c(this);
        }
        return this.j;
    }

    public d.a.l0.a.k2.f.d W() {
        if (this.k == null) {
            if (m0()) {
                this.k = new d.a.l0.a.r0.l();
            } else {
                this.k = new d.a.l0.a.k2.f.f();
            }
        }
        return this.k;
    }

    public synchronized HttpManager X() {
        if (this.o == null) {
            this.o = d.a.l0.a.c1.b.l().b();
        }
        return this.o;
    }

    public String Y() {
        return this.x;
    }

    public String Z() {
        return L().u1();
    }

    public d.a.l0.a.b2.a.a a0() {
        if (this.p == null) {
            this.p = new d.a.l0.a.b2.a.a();
        }
        return this.p;
    }

    public d.a.l0.a.n1.k b0() {
        if (this.r == null) {
            this.r = new d.a.l0.a.n1.k();
        }
        return this.r;
    }

    public boolean c0() {
        d.a.l0.a.e0.d.h("SwanApp", "SwanAppActivity isAppHasLaunch:" + this.x);
        return h.I0.contains(this.x);
    }

    public boolean d0() {
        d.a.l0.a.t0.c frame;
        if (d.a.l0.a.h0.o.e.a.f()) {
            SwanAppActivity x = x();
            if (x == null || x.isFinishing() || x.isDestroyed() || (frame = x.getFrame()) == null) {
                return true;
            }
            return !frame.P().hasStarted();
        }
        return false;
    }

    public boolean e() {
        return this.f40750g && this.u.b0() && l() > -1;
    }

    public boolean e0() {
        return g0(d.a.l0.a.g1.f.V().U());
    }

    public e f(boolean z) {
        this.w = z;
        q("event_first_action_launched");
        return this;
    }

    public boolean f0() {
        d.a.l0.a.t0.c frame;
        SwanAppActivity x = x();
        if (x == null || (frame = x.getFrame()) == null) {
            return false;
        }
        return frame.P().hasCreated();
    }

    public boolean g() {
        return this.w;
    }

    public boolean g0(String str) {
        SwanAppConfigData swanAppConfigData;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f40751h) == null) {
            return false;
        }
        return swanAppConfigData.n(str);
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public String getAppId() {
        return this.f40749f;
    }

    public final String h(int i2) {
        if (i2 == 0) {
            b.a aVar = this.v;
            String v1 = aVar != null ? aVar.v1() : "";
            if (TextUtils.isEmpty(v1)) {
                v1 = Z();
            }
            String f2 = q0.f(v1);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(f2) ? " version is empty " : f2;
            d.a.l0.a.e0.d.a("SwanApp", objArr);
            return f2;
        }
        return "0";
    }

    public boolean h0(String str) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.d dVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f40751h) == null || (dVar = swanAppConfigData.f11246b) == null) {
            return false;
        }
        return dVar.c(str);
    }

    public boolean i0() {
        return this.u.a0();
    }

    public d.a.l0.a.m.b j() {
        if (this.m == null) {
            this.m = new d.a.l0.a.m.b(this);
        }
        return this.m;
    }

    public boolean j0(String str) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        Map<String, Boolean> map;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f40751h) == null || (jVar = swanAppConfigData.f11247c) == null || (map = jVar.f11281b) == null || !map.containsKey(str)) {
            return false;
        }
        if (y) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.f40751h.f11247c.f11281b.get(str).booleanValue();
    }

    @Deprecated
    public Activity k() {
        return x();
    }

    public boolean k0(String str) {
        return new File(d.a.l0.a.g1.f.V().A(), str).exists();
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public int l() {
        if (this.f40750g) {
            return L().G();
        }
        return -1;
    }

    public boolean l0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d.a.l0.n.g.a.h().m(this.f40749f, Z(), str);
    }

    public boolean m0() {
        return L().G() == 1;
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public SwanAppCores n() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.d(L().i0());
        swanAppCores.c(L().O());
        return swanAppCores;
    }

    public boolean n0() {
        return TextUtils.equals("update_tag_by_app_launch", this.x);
    }

    public void o0(Activity activity) {
        T().w(activity);
    }

    public String p0(String... strArr) {
        if (y) {
            Log.d("SwanApp", "——> release client Id " + this.f40749f);
        }
        SwanAppActivity x = x();
        if (x != null && !x.isDestroyed() && !x.isFinishing() && x.hasActivedFrame()) {
            x.reset(strArr);
        }
        d.a.l0.a.g1.f.c0();
        g gVar = this.s;
        if (gVar != null) {
            gVar.g();
        }
        d.a.l0.t.d.j(d.a.l0.a.k2.b.x(this.f40749f));
        d.a.l0.a.i1.c.c cVar = this.q;
        if (cVar != null) {
            cVar.E();
        }
        d.a.l0.a.b2.a.a aVar = this.p;
        if (aVar != null) {
            aVar.g();
        }
        d.a.l0.a.n1.k kVar = this.r;
        if (kVar != null) {
            kVar.d();
        }
        this.j = null;
        this.l = null;
        this.o = null;
        this.w = false;
        return this.f40749f;
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public void q(String str) {
        w(str, H());
    }

    public boolean q0(Bundle bundle, String str, boolean z) {
        boolean contains = h.I0.contains(str);
        b.a L = L();
        HybridUbcFlow p = d.a.l0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.u.b0() && f0()) {
            if (L.c("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (L.c("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
        L.D(bundle);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
        if (z) {
            q("event_on_app_occupied");
        }
        if (this.f40750g && !this.u.b0() && !this.u.a0()) {
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
            ubcFlowEvent3.a(true);
            p.C(ubcFlowEvent3);
            this.u.f0();
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
            ubcFlowEvent4.a(true);
            p.C(ubcFlowEvent4);
            return true;
        }
        if (this.u.b0() && contains) {
            k.d0(L, L.f0(), false, false);
        }
        return this.u.a0();
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public e r() {
        return this;
    }

    public int r0() {
        return this.u.i0();
    }

    public boolean s0() {
        return this.u.n0();
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public void t() {
        T().l();
        U().d(true);
    }

    public void t0(SwanAppConfigData swanAppConfigData) {
        this.f40751h = swanAppConfigData;
    }

    public void u0(d.a.l0.a.a2.n.a aVar) {
        this.f40752i = aVar;
    }

    public void v0(String str) {
        this.x = str;
        d.a.l0.a.e0.d.h("SwanApp", "SwanAppActivity setUpdateTag:" + this.x);
    }

    @Override // d.a.l0.a.a2.m, d.a.l0.a.a2.h
    public void w(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = H();
        } else {
            bundle.putAll(H());
        }
        super.w(str, bundle);
    }

    public d.a.l0.a.f1.e.b w0(Bundle bundle) {
        b.a L = L();
        L.D(bundle);
        return L;
    }

    public void x0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (y) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.t.put(str2, str);
    }

    public void y0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.j jVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f40751h) == null || (jVar = swanAppConfigData.f11247c) == null || jVar.f11281b == null) {
            return;
        }
        if (y) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f40751h.f11247c.f11281b.put(str, Boolean.valueOf(z));
    }
}
