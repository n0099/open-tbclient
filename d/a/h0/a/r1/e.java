package d.a.h0.a.r1;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.i;
import d.a.h0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends m {
    public static final boolean x = d.a.h0.a.k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public final String f43823f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f43824g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f43825h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.h0.g.z.a.a f43826i;
    public d.a.h0.a.a2.c j;
    public d.a.h0.a.a2.f.c k;
    public d.a.h0.a.v1.a l;
    public d.a.h0.a.m.b m;
    public d.a.h0.a.g1.j n;
    public d.a.h0.g.w.b o;
    public d.a.h0.a.s1.a.a p;
    public d.a.h0.a.b1.c.c q;
    public d.a.h0.a.g1.k r;
    public g s;
    public Map<String, String> t;
    public final k u;
    public final b.a v;
    public boolean w;

    public e(h hVar, String str) {
        super(hVar);
        this.u = new k(this);
        this.v = new b.a();
        boolean z = false;
        this.w = false;
        str = str == null ? "" : str;
        this.f43823f = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f43823f, "swan_id_unknown")) ? true : true;
        this.f43824g = z;
        if (z) {
            d.a.h0.a.s1.a.a aVar = new d.a.h0.a.s1.a.a();
            this.p = aVar;
            aVar.e(this.f43823f);
        }
    }

    public static e O() {
        d e2 = d.e();
        if (e2.z()) {
            return e2.p();
        }
        return null;
    }

    @Deprecated
    public static String T() {
        return d.e().getAppId();
    }

    @Deprecated
    public static e h() {
        return O();
    }

    @Deprecated
    public Activity A() {
        return v();
    }

    public String B() {
        return J().H();
    }

    public d.a.h0.a.b1.c.c C() {
        if (this.q == null) {
            this.q = new d.a.h0.a.b1.c.c(this);
        }
        return this.q;
    }

    public SwanAppConfigData D() {
        return this.f43825h;
    }

    public String E(String str) {
        SwanAppConfigData.i iVar;
        HashMap<String, String> hashMap;
        SwanAppConfigData swanAppConfigData = this.f43825h;
        if (swanAppConfigData == null || (iVar = swanAppConfigData.f12154c) == null || (hashMap = iVar.f12177a) == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public final Bundle F() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.f43823f);
        return bundle;
    }

    public d.a.h0.g.z.a.a G() {
        return this.f43826i;
    }

    @NonNull
    public g H() {
        if (this.s == null) {
            this.s = new g(this);
        }
        return this.s;
    }

    public String I() {
        b.a J = J();
        return J != null ? g(J.m1()) : "0";
    }

    @NonNull
    public b.a J() {
        return this.v;
    }

    @Nullable
    public String K(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.t) == null) {
            return null;
        }
        return map.get(str);
    }

    @NonNull
    @Deprecated
    public b.a L() {
        return J();
    }

    public String M() {
        return J().J();
    }

    public synchronized d.a.h0.a.g1.j N() {
        if (this.n == null) {
            this.n = new d.a.h0.a.g1.j(this);
        }
        return this.n;
    }

    public String P(String str) {
        SwanAppConfigData.h hVar;
        SwanAppConfigData swanAppConfigData = this.f43825h;
        if (swanAppConfigData == null || (hVar = swanAppConfigData.f12153b) == null || hVar.f12175c == null) {
            return null;
        }
        return this.f43825h.f12153b.f12175c.get(d.a.h0.a.t1.k.p0.j.b(str));
    }

    public String Q(String str) {
        SwanAppConfigData swanAppConfigData = this.f43825h;
        return swanAppConfigData != null ? swanAppConfigData.g(str) : "";
    }

    @NonNull
    public d.a.h0.a.v1.a R() {
        if (this.l == null) {
            this.l = new d.a.h0.a.v1.a(this);
        }
        return this.l;
    }

    public d.a.h0.a.a2.c S() {
        if (this.j == null) {
            this.j = new d.a.h0.a.a2.c(this);
        }
        return this.j;
    }

    public d.a.h0.a.a2.f.c U() {
        if (this.k == null) {
            if (i0()) {
                this.k = new d.a.h0.g.l.l();
            } else {
                this.k = new d.a.h0.a.a2.f.e();
            }
        }
        return this.k;
    }

    public synchronized d.a.h0.g.w.b V() {
        if (this.o == null) {
            this.o = d.a.h0.g.w.b.d();
        }
        return this.o;
    }

    public String W() {
        return J().n1();
    }

    public d.a.h0.a.s1.a.a X() {
        if (this.p == null) {
            this.p = new d.a.h0.a.s1.a.a();
        }
        return this.p;
    }

    public d.a.h0.a.g1.k Y() {
        if (this.r == null) {
            this.r = new d.a.h0.a.g1.k();
        }
        return this.r;
    }

    public boolean Z() {
        d.a.h0.a.o0.c frame;
        if (d.a.h0.a.e0.q.e.a.c()) {
            SwanAppActivity v = v();
            if (v == null || (frame = v.getFrame()) == null) {
                return true;
            }
            return !frame.N().hasStarted();
        }
        return false;
    }

    public boolean a0() {
        return c0(d.a.h0.a.z0.f.V().U());
    }

    public boolean b0() {
        d.a.h0.a.o0.c frame;
        SwanAppActivity v = v();
        if (v == null || (frame = v.getFrame()) == null) {
            return false;
        }
        return frame.N().hasCreated();
    }

    public boolean c0(String str) {
        SwanAppConfigData swanAppConfigData;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43825h) == null) {
            return false;
        }
        return swanAppConfigData.n(str);
    }

    public boolean d() {
        return this.f43824g && this.u.U() && j() > -1;
    }

    public boolean d0(String str) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.a aVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43825h) == null || (aVar = swanAppConfigData.f12152a) == null) {
            return false;
        }
        return aVar.c(str);
    }

    public e e(boolean z) {
        this.w = z;
        o("event_first_action_launched");
        return this;
    }

    public boolean e0() {
        return this.u.T();
    }

    public boolean f() {
        return this.w;
    }

    public boolean f0(String str) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.h hVar;
        HashMap<String, Boolean> hashMap;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43825h) == null || (hVar = swanAppConfigData.f12153b) == null || (hashMap = hVar.f12174b) == null || !hashMap.containsKey(str)) {
            return false;
        }
        if (x) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.f43825h.f12153b.f12174b.get(str).booleanValue();
    }

    public final String g(int i2) {
        if (i2 == 0) {
            b.a aVar = this.v;
            String o1 = aVar != null ? aVar.o1() : "";
            if (TextUtils.isEmpty(o1)) {
                o1 = W();
            }
            String g2 = k0.g(o1);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(g2) ? " version is empty " : g2;
            d.a.h0.a.c0.c.a("SwanApp", objArr);
            return g2;
        }
        return "0";
    }

    public boolean g0(String str) {
        return new File(d.a.h0.a.z0.f.V().A(), str).exists();
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public String getAppId() {
        return this.f43823f;
    }

    public boolean h0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d.a.h0.l.i.a.h().m(this.f43823f, W(), str);
    }

    public d.a.h0.a.m.b i() {
        if (this.m == null) {
            this.m = new d.a.h0.a.m.b(this);
        }
        return this.m;
    }

    public boolean i0() {
        return J().F() == 1;
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public int j() {
        if (this.f43824g) {
            return J().F();
        }
        return -1;
    }

    public void j0(Activity activity) {
        R().v(activity);
    }

    public String k0(String... strArr) {
        if (x) {
            Log.d("SwanApp", "——> release client Id " + this.f43823f);
        }
        SwanAppActivity v = v();
        if (v != null && !v.isDestroyed() && !v.isFinishing() && v.hasActivedFrame()) {
            v.reset(strArr);
        }
        d.a.h0.a.z0.f.d0();
        g gVar = this.s;
        if (gVar != null) {
            gVar.g();
        }
        d.a.h0.p.d.g(d.a.h0.a.a2.b.h(this.f43823f));
        d.a.h0.a.b1.c.c cVar = this.q;
        if (cVar != null) {
            cVar.D();
        }
        d.a.h0.a.s1.a.a aVar = this.p;
        if (aVar != null) {
            aVar.f();
        }
        d.a.h0.a.g1.k kVar = this.r;
        if (kVar != null) {
            kVar.d();
        }
        this.j = null;
        this.l = null;
        this.o = null;
        this.w = false;
        return this.f43823f;
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public SwanAppCores l() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.d(J().f0());
        swanAppCores.c(J().N());
        return swanAppCores;
    }

    public boolean l0(Bundle bundle, String str, boolean z) {
        boolean contains = h.I0.contains(str);
        b.a J = J();
        HybridUbcFlow o = d.a.h0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.u.U() && b0()) {
            if (J.c("swanCoreVersion")) {
                bundle.remove("swanCoreVersion");
                bundle.remove("extensionCore");
            }
            if (J.c("pms_db_info_onload")) {
                bundle.remove("pms_db_info_onload");
            }
        }
        J.C(bundle);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
        if (z) {
            o("event_on_app_occupied");
        }
        if (this.f43824g && !this.u.U() && !this.u.T()) {
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
            ubcFlowEvent3.a(true);
            o.A(ubcFlowEvent3);
            this.u.Y();
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
            ubcFlowEvent4.a(true);
            o.A(ubcFlowEvent4);
            return true;
        }
        if (this.u.U() && contains) {
            k.W(J, J.c0(), false, false, false);
        }
        return this.u.T();
    }

    public int m0() {
        return this.u.b0();
    }

    public boolean n0() {
        return this.u.f0();
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public void o(String str) {
        u(str, F());
    }

    public void o0(SwanAppConfigData swanAppConfigData) {
        this.f43825h = swanAppConfigData;
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public e p() {
        return this;
    }

    public void p0(d.a.h0.g.z.a.a aVar) {
        this.f43826i = aVar;
    }

    public d.a.h0.a.y0.e.b q0(Bundle bundle) {
        b.a J = J();
        J.C(bundle);
        return J;
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public void r() {
        R().l();
        S().d(true);
    }

    public void r0(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.t == null) {
            this.t = new HashMap();
        }
        if (x) {
            Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
        }
        this.t.put(str2, str);
    }

    public void s0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.h hVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f43825h) == null || (hVar = swanAppConfigData.f12153b) == null || hVar.f12174b == null) {
            return;
        }
        if (x) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f43825h.f12153b.f12174b.put(str, Boolean.valueOf(z));
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public void u(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = F();
        } else {
            bundle.putAll(F());
        }
        super.u(str, bundle);
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public void y(i.a aVar) {
        super.y((i.a) aVar.C(F()));
    }

    @Override // d.a.h0.a.r1.m, d.a.h0.a.r1.h
    public boolean z() {
        return this.f43824g;
    }
}
