package d.b.h0.a.r1;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.r1.i;
import d.b.h0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class e extends m {
    public static final boolean x = d.b.h0.a.k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public final String f46461f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f46462g;

    /* renamed from: h  reason: collision with root package name */
    public SwanAppConfigData f46463h;
    public d.b.h0.g.z.a.a i;
    public d.b.h0.a.a2.c j;
    public d.b.h0.a.a2.f.c k;
    public d.b.h0.a.v1.a l;
    public d.b.h0.a.m.b m;
    public d.b.h0.a.g1.j n;
    public d.b.h0.g.w.b o;
    public d.b.h0.a.s1.a.a p;
    public d.b.h0.a.b1.c.c q;
    public d.b.h0.a.g1.k r;
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
        this.f46461f = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.f46461f, "swan_id_unknown")) ? true : true;
        this.f46462g = z;
        if (z) {
            d.b.h0.a.s1.a.a aVar = new d.b.h0.a.s1.a.a();
            this.p = aVar;
            aVar.e(this.f46461f);
        }
    }

    public static e O() {
        d e2 = d.e();
        if (e2.x()) {
            return e2.s();
        }
        return null;
    }

    @Deprecated
    public static String T() {
        return d.e().getAppId();
    }

    @Deprecated
    public static e y() {
        return O();
    }

    @Deprecated
    public Activity A() {
        return n();
    }

    public String B() {
        return J().H();
    }

    public d.b.h0.a.b1.c.c C() {
        if (this.q == null) {
            this.q = new d.b.h0.a.b1.c.c(this);
        }
        return this.q;
    }

    public SwanAppConfigData D() {
        return this.f46463h;
    }

    public String E(String str) {
        SwanAppConfigData.i iVar;
        HashMap<String, String> hashMap;
        SwanAppConfigData swanAppConfigData = this.f46463h;
        if (swanAppConfigData == null || (iVar = swanAppConfigData.f12284c) == null || (hashMap = iVar.f12306a) == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public final Bundle F() {
        Bundle bundle = new Bundle();
        bundle.putString("mAppId", this.f46461f);
        return bundle;
    }

    public d.b.h0.g.z.a.a G() {
        return this.i;
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

    public synchronized d.b.h0.a.g1.j N() {
        if (this.n == null) {
            this.n = new d.b.h0.a.g1.j(this);
        }
        return this.n;
    }

    public String P(String str) {
        SwanAppConfigData.h hVar;
        SwanAppConfigData swanAppConfigData = this.f46463h;
        if (swanAppConfigData == null || (hVar = swanAppConfigData.f12283b) == null || hVar.f12304c == null) {
            return null;
        }
        return this.f46463h.f12283b.f12304c.get(d.b.h0.a.t1.k.p0.j.b(str));
    }

    public String Q(String str) {
        SwanAppConfigData swanAppConfigData = this.f46463h;
        return swanAppConfigData != null ? swanAppConfigData.g(str) : "";
    }

    @NonNull
    public d.b.h0.a.v1.a R() {
        if (this.l == null) {
            this.l = new d.b.h0.a.v1.a(this);
        }
        return this.l;
    }

    public d.b.h0.a.a2.c S() {
        if (this.j == null) {
            this.j = new d.b.h0.a.a2.c(this);
        }
        return this.j;
    }

    public d.b.h0.a.a2.f.c U() {
        if (this.k == null) {
            if (i0()) {
                this.k = new d.b.h0.g.l.l();
            } else {
                this.k = new d.b.h0.a.a2.f.e();
            }
        }
        return this.k;
    }

    public synchronized d.b.h0.g.w.b V() {
        if (this.o == null) {
            this.o = d.b.h0.g.w.b.d();
        }
        return this.o;
    }

    public String W() {
        return J().n1();
    }

    public d.b.h0.a.s1.a.a X() {
        if (this.p == null) {
            this.p = new d.b.h0.a.s1.a.a();
        }
        return this.p;
    }

    public d.b.h0.a.g1.k Y() {
        if (this.r == null) {
            this.r = new d.b.h0.a.g1.k();
        }
        return this.r;
    }

    public boolean Z() {
        d.b.h0.a.o0.c frame;
        if (d.b.h0.a.e0.q.e.a.c()) {
            SwanAppActivity n = n();
            if (n == null || (frame = n.getFrame()) == null) {
                return true;
            }
            return !frame.N().hasStarted();
        }
        return false;
    }

    public boolean a0() {
        return c0(d.b.h0.a.z0.f.V().U());
    }

    public boolean b0() {
        d.b.h0.a.o0.c frame;
        SwanAppActivity n = n();
        if (n == null || (frame = n.getFrame()) == null) {
            return false;
        }
        return frame.N().hasCreated();
    }

    public boolean c0(String str) {
        SwanAppConfigData swanAppConfigData;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f46463h) == null) {
            return false;
        }
        return swanAppConfigData.n(str);
    }

    public boolean d() {
        return this.f46462g && this.u.U() && h() > -1;
    }

    public boolean d0(String str) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.a aVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f46463h) == null || (aVar = swanAppConfigData.f12282a) == null) {
            return false;
        }
        return aVar.c(str);
    }

    public e e(boolean z) {
        this.w = z;
        r("event_first_action_launched");
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
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f46463h) == null || (hVar = swanAppConfigData.f12283b) == null || (hashMap = hVar.f12303b) == null || !hashMap.containsKey(str)) {
            return false;
        }
        if (x) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.f46463h.f12283b.f12303b.get(str).booleanValue();
    }

    public final String g(int i) {
        if (i == 0) {
            b.a aVar = this.v;
            String o1 = aVar != null ? aVar.o1() : "";
            if (TextUtils.isEmpty(o1)) {
                o1 = W();
            }
            String g2 = k0.g(o1);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(g2) ? " version is empty " : g2;
            d.b.h0.a.c0.c.a("SwanApp", objArr);
            return g2;
        }
        return "0";
    }

    public boolean g0(String str) {
        return new File(d.b.h0.a.z0.f.V().h(), str).exists();
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public String getAppId() {
        return this.f46461f;
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public int h() {
        if (this.f46462g) {
            return J().F();
        }
        return -1;
    }

    public boolean h0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d.b.h0.l.i.a.h().m(this.f46461f, W(), str);
    }

    public boolean i0() {
        return J().F() == 1;
    }

    public void j0(Activity activity) {
        R().v(activity);
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public SwanAppCores k() {
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.d(J().f0());
        swanAppCores.c(J().N());
        return swanAppCores;
    }

    public String k0(String... strArr) {
        if (x) {
            Log.d("SwanApp", "——> release client Id " + this.f46461f);
        }
        SwanAppActivity n = n();
        if (n != null && !n.isDestroyed() && !n.isFinishing() && n.hasActivedFrame()) {
            n.reset(strArr);
        }
        d.b.h0.a.z0.f.d0();
        g gVar = this.s;
        if (gVar != null) {
            gVar.g();
        }
        d.b.h0.p.d.g(d.b.h0.a.a2.b.h(this.f46461f));
        d.b.h0.a.b1.c.c cVar = this.q;
        if (cVar != null) {
            cVar.D();
        }
        d.b.h0.a.s1.a.a aVar = this.p;
        if (aVar != null) {
            aVar.f();
        }
        d.b.h0.a.g1.k kVar = this.r;
        if (kVar != null) {
            kVar.d();
        }
        this.j = null;
        this.l = null;
        this.o = null;
        this.w = false;
        return this.f46461f;
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public void l(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = F();
        } else {
            bundle.putAll(F());
        }
        super.l(str, bundle);
    }

    public boolean l0(Bundle bundle, String str, boolean z) {
        boolean contains = h.I0.contains(str);
        b.a J = J();
        HybridUbcFlow o = d.b.h0.a.j1.i.o("startup");
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
            r("event_on_app_occupied");
        }
        if (this.f46462g && !this.u.U() && !this.u.T()) {
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

    public void o0(SwanAppConfigData swanAppConfigData) {
        this.f46463h = swanAppConfigData;
    }

    public void p0(d.b.h0.g.z.a.a aVar) {
        this.i = aVar;
    }

    public d.b.h0.a.y0.e.b q0(Bundle bundle) {
        b.a J = J();
        J.C(bundle);
        return J;
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public void r(String str) {
        l(str, F());
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

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public e s() {
        return this;
    }

    public void s0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.h hVar;
        if (TextUtils.isEmpty(str) || (swanAppConfigData = this.f46463h) == null || (hVar = swanAppConfigData.f12283b) == null || hVar.f12303b == null) {
            return;
        }
        if (x) {
            Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f46463h.f12283b.f12303b.put(str, Boolean.valueOf(z));
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public void t(i.a aVar) {
        super.t((i.a) aVar.C(F()));
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public void v() {
        R().l();
        S().d(true);
    }

    @Override // d.b.h0.a.r1.m, d.b.h0.a.r1.h
    public boolean x() {
        return this.f46462g;
    }

    public d.b.h0.a.m.b z() {
        if (this.m == null) {
            this.m = new d.b.h0.a.m.b(this);
        }
        return this.m;
    }
}
