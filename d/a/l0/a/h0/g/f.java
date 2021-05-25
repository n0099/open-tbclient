package d.a.l0.a.h0.g;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.l0.a.h0.t.a;
import d.a.l0.a.p.d.q0;
import d.a.l0.a.v2.d0;
import d.a.l0.a.v2.f0;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import d.a.l0.a.z1.b.c.a;
import d.a.l0.k.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class f extends d.a.l0.a.h0.g.d implements a.InterfaceC0935a {
    public static d.a.l0.a.l1.b U0;
    public static String W0;
    public FrameLayout B0;
    public d.a.l0.a.p.e.b C0;
    public d.a.l0.a.o2.b.a D0;
    public d.a.l0.a.z1.b.c.a E0;
    public View K0;
    public d.a.l0.a.a2.n.g L0;
    public d.a.l0.a.h0.j.c N0;
    public q0 O0;
    public d.a.l0.a.j2.a x0;
    public d.a.l0.a.l1.b z0;
    public static final boolean R0 = d.a.l0.a.k.f43199a;
    public static final int S0 = n0.g(149.0f);
    public static String T0 = "-1";
    public static String V0 = "-1";
    public d.a.l0.a.l1.b y0 = new d.a.l0.a.l1.b();
    public Map<String, d.a.l0.a.p.e.b> A0 = new TreeMap();
    public int M0 = 0;
    public boolean P0 = false;
    public boolean Q0 = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.O0 = d.a.l0.a.c1.a.L();
            q0 q0Var = f.this.O0;
            f fVar = f.this;
            q0Var.a(fVar.g0, fVar.q());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SwanAppActionBar.c {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            String b2 = f.this.C0.b();
            d.a.l0.a.o0.d.g gVar = new d.a.l0.a.o0.d.g();
            gVar.f43924c = d.a.l0.a.w2.g.c.a.a(b2, "scrollViewBackToTop");
            d.a.l0.a.g1.f.V().m(b2, gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.W2();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f42062a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42063b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42064c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f42065d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42066e;

        public d(a.d dVar, String str, String str2, String str3, String str4) {
            this.f42062a = dVar;
            this.f42063b = str;
            this.f42064c = str2;
            this.f42065d = str3;
            this.f42066e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [d.a.l0.a.p.e.c] */
        @Override // d.a.l0.a.h0.t.a.e
        public void onReady() {
            String str;
            d.a.l0.a.h0.u.d dVar = new d.a.l0.a.h0.u.d();
            dVar.f42620i = this.f42062a.f42580a.L();
            if (!TextUtils.isEmpty(this.f42063b)) {
                d.a.l0.a.r1.i.e(this.f42062a, this.f42063b);
            }
            String b2 = d.a.l0.a.c2.f.p0.j.b(this.f42064c);
            dVar.f42612a = this.f42065d;
            if (TextUtils.isEmpty(this.f42066e)) {
                str = this.f42064c;
            } else {
                str = this.f42064c + "?" + this.f42066e;
            }
            dVar.f42613b = str;
            if (d.a.l0.a.a2.e.Q() != null) {
                dVar.f42614c = d.a.l0.a.a2.e.Q().S(b2);
                dVar.f42617f = d.a.l0.a.a2.e.Q().M(b2);
            }
            dVar.k = d.a.l0.a.h0.u.a.c(d.a.l0.a.a2.e.i(), dVar.f42613b);
            dVar.f42615d = d.a.l0.a.g1.f.V().e(b2).f40798g;
            dVar.f42616e = String.valueOf(d.a.l0.a.e0.a.a());
            dVar.f42618g = f.R0 || d.a.l0.a.g1.f.V().O();
            if (d.a.l0.a.u1.a.a.G()) {
                dVar.j = d.a.l0.a.e0.f.b.d();
            }
            if (!TextUtils.isEmpty(this.f42063b)) {
                String str2 = this.f42063b;
                dVar.f42619h = str2;
                d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).C(new UbcFlowEvent("slave_dispatch_start"));
            }
            d0.d();
            this.f42062a.f42580a.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f42064c);
            this.f42062a.f42580a.S(dVar.f42613b);
            d.a.l0.a.g1.f.V().m(this.f42062a.f42580a.b(), d.a.l0.a.h0.u.d.a(dVar));
            if (d.a.l0.a.h0.u.e.b()) {
                d.a.l0.a.h0.u.e eVar = new d.a.l0.a.h0.u.e();
                eVar.f42623a = this.f42062a.f42580a.b();
                d.a.l0.a.g1.f.V().v(d.a.l0.a.h0.u.e.a(eVar));
            }
            d.a.l0.a.j2.e.F(this.f42062a.f42580a.b(), dVar.f42613b);
            if (f.R0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + dVar.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.f> {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.Q0 = false;
                f.this.s2(true, false);
            }
        }

        public e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.f fVar) {
            if (fVar == null || fVar.f41697d || fVar.j != 1) {
                return;
            }
            d.a.l0.a.v2.q0.b0(new a());
        }
    }

    /* renamed from: d.a.l0.a.h0.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0661f implements d.a.l0.a.h0.j.c {
        public C0661f() {
        }

        @Override // d.a.l0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            f.this.L3(i3);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.l0.a.h0.j.e {
        public g() {
        }

        @Override // d.a.l0.a.h0.j.e
        public void a(d.a.l0.a.p.e.e eVar) {
            if (eVar != null) {
                eVar.v(f.this.N0);
                eVar.Z(f.this.l3());
                d.a.l0.a.m1.g.f().a(eVar);
            }
        }

        @Override // d.a.l0.a.h0.j.e
        public void b(d.a.l0.a.p.e.e eVar) {
            if (eVar != null) {
                eVar.U(f.this.N0);
                d.a.l0.a.m1.g.f().b(eVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.a.l0.a.h0.j.a {
        public h() {
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void a(String str) {
            f.this.n2(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public static int f42073a = -1;

        public static int a() {
            if (f42073a < 0) {
                d.a.l0.a.c1.a.Z().getSwitch("swan_app_fragment_destroy_switch", 1);
                f42073a = 1;
            }
            if (f.R0) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + f42073a);
            }
            return f42073a;
        }

        public static boolean b() {
            return a() > 0;
        }
    }

    public static void G3(d.a.l0.a.l1.b bVar) {
        try {
            if (R0) {
                Log.d("SwanAppFragment", "setLastPageParams =" + bVar);
            }
            if (bVar == null) {
                U0 = null;
            } else {
                U0 = (d.a.l0.a.l1.b) bVar.clone();
            }
        } catch (Exception e2) {
            if (R0) {
                e2.printStackTrace();
            }
        }
    }

    public static void H3(String str) {
        W0 = str;
    }

    private void a1() {
        if (W()) {
            A3();
        }
        if (R0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.C0.b())));
        }
    }

    private void d1() {
        if (W()) {
            D3();
        }
        n nVar = this.j0;
        if (nVar != null && nVar.g()) {
            this.j0.x(d.a.l0.a.c1.a.H().a());
        }
        if (R0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.C0.b())));
        }
    }

    public static f z3(d.a.l0.a.l1.c cVar) {
        f fVar = new f();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.i());
            fVar.j1(bundle);
        }
        return fVar;
    }

    public void A3() {
        PullToRefreshBaseWebView h0;
        boolean z = this.C0 == null;
        String b2 = z ? "" : this.C0.b();
        if (R0) {
            Log.d("SwanAppFragment", "pause() wvID: " + b2);
        }
        if (!z) {
            this.C0.onPause();
            E3("onHide");
            d.a.l0.a.m1.g.f().k(false);
        }
        if (getFloatLayer() != null && !getFloatLayer().d()) {
            getFloatLayer().g();
        }
        d.a.l0.a.e0.d.g("SwanApp", "onHide");
        d.a.l0.a.i1.b.i(false);
        if (!z && (h0 = this.C0.h0()) != null) {
            h0.w(false);
        }
        d.a.l0.a.c1.a.D().f(d.a.l0.a.a2.e.Q() != null ? d.a.l0.a.a2.e.Q().D() : "");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
        View b2 = d.a.l0.a.r1.n.a.a().b(d.a.l0.a.g.aiapps_fragment, viewGroup, false);
        this.B0 = (FrameLayout) b2.findViewById(d.a.l0.a.f.ai_apps_fragment_content);
        Q1(b2);
        this.D0 = new d.a.l0.a.o2.b.a(this);
        U2(b2);
        if (!d.a.l0.a.j1.e.b.d() && !d.a.l0.a.j1.e.b.e()) {
            d.a.l0.a.j1.e.a.b(this.C0.b(), String.valueOf(d.a.l0.a.j1.e.b.c()), String.valueOf(d.a.l0.a.j1.e.b.a(d.a.l0.a.j1.e.b.b())));
        }
        if (P1()) {
            b2 = S1(b2);
        }
        this.K0 = A1(b2, this);
        this.p0.setRegionFactor(this.C0.F());
        d.a.l0.a.m1.g.f().o();
        return this.K0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B3() {
        int i2;
        d.a.l0.a.a2.n.g gVar;
        d.a.l0.a.p.e.c cVar;
        TextView centerTitleView;
        if (this.i0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (t3()) {
            s2(true, this.Q0);
            i2 = 0;
        } else if (s3()) {
            s2(false, false);
            d.a.l0.a.p.e.b bVar = this.C0;
            if (bVar != null) {
                if (bVar.m() != null) {
                    cVar = this.C0.m().u();
                } else {
                    cVar = this.C0.u();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.L0;
                    if (gVar != null && gVar.f40800i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.L0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            s2(false, false);
            i2 = S0 + this.M0;
            centerTitleView = this.i0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            L3(i2);
            N3(z);
        }
        z = true;
        centerTitleView = this.i0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        L3(i2);
        N3(z);
    }

    @Override // d.a.l0.a.h0.g.d
    public void C2() {
        if (this.C0 == null) {
            if (R0) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.C0.b());
        d.a.l0.a.p.e.e m = this.C0.m();
        if (m != null) {
            hashMap.put("webViewUrl", m.getCurrentPageUrl());
        }
        d.a.l0.a.g1.f.V().v(new d.a.l0.a.o0.d.b("sharebtn", hashMap));
    }

    public final void C3() {
        Bundle n = n();
        if (n == null) {
            return;
        }
        this.z0 = U0;
        if (R0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.z0);
        }
        d.a.l0.a.l1.c e2 = d.a.l0.a.l1.c.e(n.getString("ai_apps_param"));
        this.g0 = e2;
        this.y0.f43357e = e2 != null ? e2.g() : "";
        d.a.l0.a.l1.b bVar = this.y0;
        d.a.l0.a.l1.c cVar = this.g0;
        bVar.f43358f = cVar != null ? cVar.h() : "";
        d.a.l0.a.l1.b bVar2 = this.y0;
        bVar2.f43360h = d.a.l0.a.c2.f.p0.j.b(bVar2.f());
        d.a.l0.a.a2.n.g e3 = d.a.l0.a.g1.f.V().e(this.y0.h());
        this.L0 = e3;
        if (e3.p) {
            this.L0 = d.a.l0.a.g1.f.V().i(this.y0.f());
        }
        this.M0 = G1().getDimensionPixelSize(d.a.l0.a.d.aiapps_normal_base_action_bar_height);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        super.D0();
        Map<String, d.a.l0.a.p.e.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.a.l0.a.p.e.b bVar : this.A0.values()) {
                if (bVar != null) {
                    bVar.f0();
                }
            }
        } else {
            d.a.l0.a.p.e.b bVar2 = this.C0;
            if (bVar2 != null) {
                bVar2.f0();
            }
        }
        n3();
    }

    @Override // d.a.l0.a.h0.g.d
    public d.a.l0.a.a2.n.g D1() {
        return this.L0;
    }

    public void D3() {
        boolean z = false;
        boolean z2 = this.C0 == null;
        String b2 = z2 ? "" : this.C0.b();
        if (R0) {
            Log.d("SwanAppFragment", "resume() wvID: " + b2);
        }
        if (!z2) {
            p2((V1() || r3()) ? true : true);
            this.C0.onResume();
            F3();
            E3("onShow");
            d.a.l0.a.m1.g.f().k(true);
        }
        d.a.l0.a.e0.d.g("SwanApp", "onShow");
        d.a.l0.a.i1.b.i(true);
        if (d.a.l0.a.e0.d.d()) {
            d.a.l0.a.h0.e.b.b();
        }
        d.a.l0.a.c1.a.D().e(d.a.l0.a.a2.e.Q() != null ? d.a.l0.a.a2.e.Q().D() : "");
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        super.E0();
    }

    public final void E3(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.C0.b());
        d.a.l0.a.o0.d.c cVar = new d.a.l0.a.o0.d.c(hashMap);
        if (R0) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.C0.b());
        }
        d.a.l0.a.g1.f.V().v(cVar);
    }

    public final void F3() {
        if (!TextUtils.equals(V0, this.C0.b()) || TextUtils.equals(W0, "switchTab")) {
            int o = this.D0.o(Z2().h());
            d.a.l0.a.o0.d.e eVar = new d.a.l0.a.o0.d.e();
            eVar.f43917c = V0;
            eVar.f43918d = this.C0.b();
            eVar.f43919e = W0;
            eVar.f43920f = this.y0.f43357e;
            eVar.f43921g = String.valueOf(o);
            W0 = "";
            if (R0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.f43917c + " ,toId: " + eVar.f43918d + " ,RouteType: " + eVar.f43919e + " page:" + eVar.f43920f + ",TabIndex: " + eVar.f43921g);
            }
            d.a.l0.a.g1.f.V().v(eVar);
            V0 = this.C0.b();
        }
    }

    public void I3(d.a.l0.a.l1.b bVar) {
        if (R0) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.D0.o(Z2().h()) == this.D0.o(bVar.h())) {
            return;
        }
        this.D0.E(bVar.h());
        onPause();
        Y2(bVar, "");
    }

    public final void J3(String str) {
        d.a.l0.a.p.e.b bVar = this.A0.get(str);
        if (this.C0 == bVar || bVar == null) {
            return;
        }
        d.a.l0.a.a2.n.g e2 = d.a.l0.a.g1.f.V().e(str);
        bVar.B(this.B0, e2);
        if (!bVar.d()) {
            bVar.Q(this.B0, e2);
        }
        bVar.G(0);
        d.a.l0.a.p.e.b bVar2 = this.C0;
        if (bVar2 != null) {
            bVar2.G(8);
        }
        this.C0 = bVar;
        bVar.i(this.y0);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean K() {
        if ((getFloatLayer() == null || !getFloatLayer().d()) && !d.a.b0.a.j()) {
            d.a.l0.a.p.e.b bVar = this.C0;
            if (bVar != null) {
                if (d.a.l0.a.i1.b.g(bVar.b())) {
                    return true;
                }
                return this.C0.K();
            }
            return false;
        }
        return true;
    }

    public final void K3(d.a.l0.a.p.e.b bVar) {
        d.a.l0.a.h0.j.c cVar = this.N0;
        if (cVar == null || bVar == null) {
            return;
        }
        bVar.U(cVar);
        if (bVar.m() != null) {
            bVar.U(this.N0);
        }
    }

    public final void L3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        float f2 = 1.0f;
        float f3 = (i2 - S0) * 1.0f;
        int i3 = this.M0;
        if (i3 == 0) {
            i3 = 1;
        }
        float f4 = f3 / i3;
        if (f4 <= 0.0f) {
            f2 = 0.0f;
        } else if (f4 < 1.0f) {
            f2 = f4;
        }
        int i4 = (int) (255.0f * f2);
        if (R0 && i4 != 0 && i4 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
        }
        d.a.l0.a.w2.d.b bVar = this.n0;
        if (bVar != null && bVar.i() && (e2 = this.n0.e()) != null && (background = e2.getBackground()) != null) {
            background.setAlpha(i4);
        }
        Drawable background2 = this.i0.getBackground();
        if (background2 != null) {
            background2.setAlpha(i4);
        }
        d.a.l0.a.a2.n.g gVar = this.L0;
        if (gVar != null && gVar.f40800i && (centerTitleView = this.i0.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f2);
        }
        Drawable background3 = this.l0.getBackground();
        if (background3 != null) {
            background3.setAlpha(i4);
        }
    }

    public void M3() {
        d.a.l0.a.l1.c cVar = this.g0;
        if (cVar == null) {
            return;
        }
        cVar.j();
    }

    public final void N3(boolean z) {
        int i2;
        int i3 = 0;
        if (z) {
            d.a.l0.a.w2.d.b bVar = this.n0;
            if (bVar != null && bVar.i()) {
                i2 = n0.u();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
                layoutParams.topMargin = i3;
                this.B0.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
                layoutParams2.topMargin = i2;
                this.h0.setLayoutParams(layoutParams2);
            }
        } else {
            i3 = G1().getDimensionPixelSize(d.a.l0.a.d.aiapps_normal_base_action_bar_height);
        }
        i2 = 0;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
        layoutParams3.topMargin = i3;
        this.B0.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
        layoutParams22.topMargin = i2;
        this.h0.setLayoutParams(layoutParams22);
    }

    @Override // d.a.l0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        boolean z = false;
        p2(V1() || r3());
        if (v3()) {
            a2();
        }
        B3();
        this.i0.setOnDoubleClickListener(new b());
        if (!d.a.l0.a.j2.e.i()) {
            d.a.l0.a.j2.e.d(d.a.l0.a.a2.d.g().r().L());
        }
        if (t3() && r3()) {
            z = true;
        }
        this.Q0 = z;
        if (z) {
            S2();
        }
    }

    public final void Q2(d.a.l0.a.p.e.b bVar) {
        if (bVar == null) {
            return;
        }
        d.a.l0.a.h0.j.c cVar = this.N0;
        if (cVar != null) {
            bVar.v(cVar);
        }
        bVar.a0(m3());
    }

    public final void R2() {
        this.x0 = d.a.l0.a.j2.k.c("805");
    }

    public final void S2() {
        d.a.l0.a.a2.d.g().r().T().e("mapp_i_custom_navigation_bar", new e());
    }

    public final d.a.l0.a.p.e.b T2(String str, String str2, String str3, String str4) {
        if (R0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        a.d f2 = d.a.l0.a.h0.t.a.f(h());
        if (!TextUtils.isEmpty(str4)) {
            HybridUbcFlow q = d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
            q.C(new UbcFlowEvent("na_pre_load_slave_check"));
            q.A("preload", f2.f42581b ? "1" : "0");
        }
        if (R0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
        }
        d.a.l0.a.h0.t.a.n(f2, new d(f2, str4, str2, str, str3));
        if (R0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return f2.f42580a;
    }

    public final void U2(View view) {
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
        String f2 = this.g0.f();
        String h2 = this.g0.h();
        String g2 = this.g0.g();
        String a2 = d.a.l0.a.v2.q0.a(f2, g2, h2);
        this.C0 = d.a.l0.a.h0.t.a.h(a2);
        if (R0) {
            StringBuilder sb = new StringBuilder();
            sb.append("pageUrl: ");
            sb.append(a2);
            sb.append(" is load: ");
            sb.append(this.C0 != null);
            Log.d("SwanAppFragment", sb.toString());
        }
        if (this.C0 == null) {
            if (R0) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.C0 = T2(f2, g2, h2, "");
        }
        this.C0.i(this.y0);
        d.a.l0.a.a2.n.g e2 = d.a.l0.a.g1.f.V().e(g2);
        d.a.l0.a.e0.d.g("SwanAppFragment", "create slave webview: " + g2);
        this.C0.B(this.B0, e2);
        this.C0.Q(this.B0, e2);
        o3(g2);
        Q2(this.C0);
        if (Z1()) {
            this.A0.put(g2, this.C0);
            this.D0.f(view, q(), g2);
        }
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
        R2();
    }

    public final void V2(d.a.l0.a.l1.b bVar, String str) {
        if (this.A0.get(bVar.f43360h) == null) {
            String a2 = d.a.l0.a.v2.q0.a(bVar.f43359g, bVar.f43357e, bVar.f43358f);
            d.a.l0.a.p.e.b h2 = d.a.l0.a.h0.t.a.h(a2);
            if (h2 != null) {
                if (R0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.A0.put(bVar.f43357e, h2);
            } else {
                if (R0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = T2(bVar.f43359g, bVar.f43357e, bVar.f43358f, str);
                this.A0.put(bVar.f43357e, h2);
            }
            o3(bVar.f43357e);
            Q2(h2);
        }
    }

    public final void W2() {
        Map<String, d.a.l0.a.p.e.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.a.l0.a.p.e.b bVar : this.A0.values()) {
                if (bVar != null) {
                    K3(bVar);
                    bVar.destroy();
                }
            }
            this.A0.clear();
        } else {
            d.a.l0.a.p.e.b bVar2 = this.C0;
            if (bVar2 != null) {
                K3(bVar2);
                this.C0.destroy();
            }
        }
        this.C0 = null;
        if (R0) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (this.P0) {
            return;
        }
        d.a.l0.a.h0.t.a.l(d.a.l0.a.g1.f.V().getActivity());
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    public void X2() {
        this.L0.j = "default";
        t1();
        B3();
    }

    public void Y2(d.a.l0.a.l1.b bVar, String str) {
        G3(this.y0);
        this.z0 = U0;
        if (R0) {
            Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.z0);
        }
        String str2 = bVar.f43357e;
        String str3 = bVar.f43360h;
        d.a.l0.a.a2.n.g e2 = d.a.l0.a.g1.f.V().e(TextUtils.isEmpty(str3) ? "" : str3);
        d.a.l0.a.l1.b bVar2 = this.y0;
        bVar2.f43357e = str2;
        bVar2.f43358f = bVar != null ? bVar.g() : "";
        this.y0.f43360h = str3;
        this.L0 = e2;
        boolean z = !x3(str3);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                d.a.l0.a.r1.i.c(7, str);
            } else {
                d.a.l0.a.r1.i.c(6, str);
            }
        }
        if (!z) {
            J3(str3);
        } else {
            V2(bVar, str);
            J3(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            d.a.l0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
            d.a.l0.a.r1.i.a(str, bVar);
        }
        n2(e2.f40793b);
        t2(SwanAppConfigData.s(e2.f40794c));
        l2(e2.f40792a);
        B3();
        M3();
        d.a.l0.a.e0.d.g("SwanAppFragment", "switch tab title: " + e2.f40793b + " page:" + str2);
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean Z1() {
        SwanAppConfigData s;
        d.a.l0.a.l1.c cVar;
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        if (V == null || (s = V.s()) == null || !s.m() || (cVar = this.g0) == null) {
            return false;
        }
        return s.q(cVar.g());
    }

    @NonNull
    public d.a.l0.a.l1.b Z2() {
        return this.y0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [d.a.l0.a.p.e.c] */
    @NonNull
    public Pair<Integer, Integer> a3() {
        d.a.l0.a.p.e.b bVar = this.C0;
        if (bVar == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = bVar.u().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    public d.a.l0.a.p.e.b b3() {
        return this.C0;
    }

    public final int c3() {
        return Y1() ? w3() ? 18 : 17 : w3() ? 12 : 15;
    }

    @Override // d.a.l0.a.h0.g.d
    public void d2() {
        L1();
        d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
        fVar.f43189e = "gohome";
        fVar.f43187c = "bar";
        f J = d.a.l0.a.g1.f.V().J();
        d.a.l0.a.l1.c K1 = J == null ? null : J.K1();
        if (K1 != null && !TextUtils.isEmpty(K1.g())) {
            fVar.a("page", K1.g());
        }
        y1(fVar);
    }

    public final void d3(boolean z) {
        if (d.a.l0.a.c1.a.G().i(z, 2)) {
            d.a.l0.a.k1.a.l(q(), this.j0, d.a.l0.a.a2.e.Q().L().f0().paNumber);
        }
    }

    @Override // d.a.l0.a.h0.g.d
    public void e2() {
        this.C0.V();
        p3();
        d3(true);
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.k0;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setAttentionBtnStates(d.a.l0.a.j0.b.a.n(d.a.l0.a.a2.d.g().getAppId()));
        }
        this.j0.r(d.a.l0.a.c1.a.H().a(), E1(), this.k0, false);
    }

    @Nullable
    public d.a.l0.a.l1.b e3() {
        return this.z0;
    }

    public final void f3(boolean z) {
        if (d.a.l0.a.c1.a.G().i(z, 1)) {
            d.a.l0.a.k1.a.k(q(), this.i0, d.a.l0.a.a2.e.Q().L().f0().paNumber);
        } else if (d.a.l0.a.a2.e.Q() == null) {
        } else {
            d.a.l0.a.k1.a.o(this.i0, d.a.l0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue());
        }
    }

    public String g3() {
        d.a.l0.a.p.e.b bVar = this.C0;
        return bVar != null ? bVar.b() : "";
    }

    @Override // d.a.l0.a.z1.b.c.a.InterfaceC0935a
    public d.a.l0.a.z1.b.c.a getFloatLayer() {
        if (this.E0 == null) {
            if (this.K0 == null) {
                return null;
            }
            this.E0 = new d.a.l0.a.z1.b.c.a(this, (LinearLayout) this.K0.findViewById(d.a.l0.a.f.ai_apps_fragment_base_view), G1().getDimensionPixelOffset(d.a.l0.a.d.aiapps_normal_base_action_bar_height));
        }
        return this.E0;
    }

    public PullToRefreshBaseWebView h0() {
        d.a.l0.a.p.e.b bVar = this.C0;
        if (bVar != null) {
            return bVar.h0();
        }
        return null;
    }

    public List<String> h3() {
        ArrayList arrayList = new ArrayList();
        Map<String, d.a.l0.a.p.e.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, d.a.l0.a.p.e.b> entry : this.A0.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().b());
                }
            }
        }
        d.a.l0.a.p.e.b bVar = this.C0;
        if (bVar != null) {
            String b2 = bVar.b();
            if (!arrayList.contains(b2)) {
                arrayList.add(b2);
            }
        }
        return arrayList;
    }

    @Override // d.a.l0.a.h0.g.d
    public void i2() {
        super.i2();
        B3();
    }

    @Nullable
    public d.a.l0.a.o2.b.a i3() {
        return this.D0;
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return V1() && this.C0.isSlidable(motionEvent);
    }

    public String j3(String str) {
        if (this.A0.containsKey(str)) {
            return this.A0.get(str).b();
        }
        return null;
    }

    public FrameLayout k3() {
        return this.B0;
    }

    @Override // d.a.l0.a.h0.g.d
    public boolean l2(int i2) {
        boolean l2 = super.l2(i2);
        B3();
        return l2;
    }

    public final d.a.l0.a.h0.j.a l3() {
        return new h();
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        if (n0()) {
            super.m1(z);
            if (R0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                D3();
                f3(false);
                return;
            }
            A3();
        }
    }

    public final d.a.l0.a.h0.j.e m3() {
        return new g();
    }

    public final void n3() {
        d.a.l0.a.y0.j.b F0;
        d.a.l0.a.p.e.b b3 = b3();
        if (!(b3 instanceof SwanAppWebViewManager) || (F0 = ((SwanAppWebViewManager) b3).F0()) == null) {
            return;
        }
        F0.d();
    }

    public final void o3(String str) {
        if (t3()) {
            return;
        }
        d.a.l0.a.g1.f V = d.a.l0.a.g1.f.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.e(str).f40799h && this.N0 == null) {
            this.N0 = new C0661f();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3();
        if (R0) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        q.i(new a(), "SwanAppPageHistory");
        d.a.l0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (i.b()) {
            d.a.l0.a.v2.q0.q().postAtFrontOfQueue(new c());
        } else {
            W2();
        }
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        a1();
    }

    @Override // d.a.l0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        d1();
        f3(false);
    }

    @DebugTrace
    public void p3() {
        FragmentActivity h2 = h();
        if (this.k0 == null) {
            this.k0 = new SwanAppMenuHeaderView(q());
        }
        if (h2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(h2, this.i0, c3(), d.a.l0.a.c1.a.G(), new d.a.l0.a.w2.h.b());
        new d.a.l0.a.j1.a(this.j0, this, this.k0).z();
        if (d.a.l0.a.j1.e.b.d()) {
            this.j0.j(50);
        }
    }

    public boolean q3() {
        d.a.l0.a.o2.b.a aVar = this.D0;
        if (aVar == null) {
            return false;
        }
        return aVar.p();
    }

    public final boolean r3() {
        SwanAppConfigData s = d.a.l0.a.g1.f.V().s();
        boolean z = false;
        if (s == null) {
            return false;
        }
        return !((TextUtils.equals(s.e(), this.y0.f43357e) || s.q(this.y0.f43357e)) ? true : true);
    }

    public final boolean s3() {
        d.a.l0.a.a2.n.g gVar = this.L0;
        return gVar != null && gVar.f40799h;
    }

    public boolean t3() {
        d.a.l0.a.a2.n.g gVar = this.L0;
        if (gVar != null) {
            return TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
        }
        return false;
    }

    @Override // d.a.l0.a.h0.g.d
    public void u1(int i2) {
        if (!d.a.l0.a.a2.n.g.f(this.L0)) {
            super.u1(i2);
            return;
        }
        v1(i2, t3() ? true : true ^ f0.h(this.f0));
        B3();
    }

    public final boolean u3(d.a.l0.a.h0.g.g gVar, SwanAppConfigData swanAppConfigData) {
        d.a.l0.a.h0.g.d j = gVar.j(0);
        if (j == null || !(j instanceof f)) {
            return false;
        }
        String f2 = ((f) j).Z2().f();
        return swanAppConfigData.q(f2) || TextUtils.equals(swanAppConfigData.e(), f2);
    }

    public final boolean v3() {
        SwanAppConfigData s;
        d.a.l0.a.h0.g.g J1 = J1();
        if (J1 == null) {
            return false;
        }
        d.a.l0.a.a2.n.g gVar = this.L0;
        if ((gVar != null && gVar.k) || (s = d.a.l0.a.g1.f.V().s()) == null) {
            return false;
        }
        return !u3(J1, s);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        super.w0(activity);
        if (R0) {
            Log.d("SwanAppFragment", "onAttach() obj: " + this);
        }
    }

    public final boolean w3() {
        SwanAppConfigData s = d.a.l0.a.g1.f.V().s();
        return (s == null || TextUtils.equals(s.e(), this.y0.f())) ? false : true;
    }

    public final boolean x3(String str) {
        return (this.A0.isEmpty() || this.A0.get(str) == null) ? false : true;
    }

    public void y3(d.a.l0.a.j2.p.g gVar) {
        d.a.l0.a.j2.a aVar = this.x0;
        if (aVar != null) {
            d.a.l0.a.j2.k.i(aVar, gVar);
            this.x0 = null;
        }
    }
}
