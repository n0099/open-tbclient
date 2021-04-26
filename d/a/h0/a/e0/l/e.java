package d.a.h0.a.e0.l;

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
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.h0.a.e0.v.b;
import d.a.h0.a.i2.b0;
import d.a.h0.a.i2.c0;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.c.a;
import d.a.h0.i.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class e extends d.a.h0.a.e0.l.c implements a.InterfaceC0736a {
    public static final boolean Q0 = k.f43101a;
    public static final int R0 = h0.f(149.0f);
    public static String S0 = "-1";
    public static String T0 = "-1";
    public static String U0;
    public FrameLayout B0;
    public d.a.h0.a.p.d.b C0;
    public d.a.h0.a.d2.b.a D0;
    public d.a.h0.a.q1.b.c.a E0;
    public View K0;
    public d.a.h0.a.r1.n.c L0;
    public d.a.h0.a.e0.n.c N0;
    public d.a.h0.a.p.c.h0 O0;
    public d.a.h0.a.z1.a y0;
    public d.a.h0.a.e1.b z0 = new d.a.h0.a.e1.b();
    public Map<String, d.a.h0.a.p.d.b> A0 = new TreeMap();
    public int M0 = 0;
    public boolean P0 = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.O0 = d.a.h0.a.w0.a.C();
            d.a.h0.a.p.c.h0 h0Var = e.this.O0;
            e eVar = e.this;
            h0Var.a(eVar.g0, eVar.m());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements SwanAppActionBar.c {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            String c2 = e.this.C0.c();
            d.a.h0.a.k0.b.g gVar = new d.a.h0.a.k0.b.g();
            gVar.f43119b = d.a.h0.a.j2.f.c.a.a(c2, "scrollViewBackToTop");
            d.a.h0.a.z0.f.V().o(c2, gVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.N2();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f42019a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42020b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f42021c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f42022d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42023e;

        public d(b.c cVar, String str, String str2, String str3, String str4) {
            this.f42019a = cVar;
            this.f42020b = str;
            this.f42021c = str2;
            this.f42022d = str3;
            this.f42023e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [d.a.h0.a.p.d.c] */
        @Override // d.a.h0.a.e0.v.b.d
        public void onReady() {
            String str;
            d.a.h0.a.e0.w.b bVar = new d.a.h0.a.e0.w.b();
            bVar.f42353i = this.f42019a.f42331a.J();
            if (!TextUtils.isEmpty(this.f42020b)) {
                d.a.h0.a.j1.j.e(this.f42019a, this.f42020b);
            }
            String b2 = d.a.h0.a.t1.k.p0.j.b(this.f42021c);
            bVar.f42345a = this.f42022d;
            if (TextUtils.isEmpty(this.f42023e)) {
                str = this.f42021c;
            } else {
                str = this.f42021c + "?" + this.f42023e;
            }
            bVar.f42346b = str;
            if (d.a.h0.a.r1.e.O() != null) {
                bVar.f42347c = d.a.h0.a.r1.e.O().Q(b2);
                bVar.f42350f = d.a.h0.a.r1.e.O().K(b2);
            }
            bVar.k = d.a.h0.a.e0.w.a.b(d.a.h0.a.r1.e.h(), bVar.f42346b);
            bVar.f42348d = d.a.h0.a.z0.f.V().g(b2).f43862g;
            bVar.f42349e = String.valueOf(d.a.h0.a.c0.a.a());
            bVar.f42351g = e.Q0 || d.a.h0.a.z0.f.V().O();
            if (d.a.h0.a.m1.a.a.C()) {
                bVar.j = d.a.h0.a.c0.d.b.d();
            }
            if (!TextUtils.isEmpty(this.f42020b)) {
                String str2 = this.f42020b;
                bVar.f42352h = str2;
                d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).A(new UbcFlowEvent("slave_dispatch_start"));
            }
            b0.d();
            this.f42019a.f42331a.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f42021c);
            this.f42019a.f42331a.n(bVar.f42346b);
            d.a.h0.a.z0.f.V().o(this.f42019a.f42331a.c(), d.a.h0.a.e0.w.b.a(bVar));
            d.a.h0.a.z1.e.B(this.f42019a.f42331a.c(), bVar.f42346b);
            if (e.Q0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
            }
        }
    }

    /* renamed from: d.a.h0.a.e0.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0633e implements d.a.h0.a.e0.n.c {
        public C0633e() {
        }

        @Override // d.a.h0.a.e0.n.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            e.this.y3(i3);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.h0.a.e0.n.e {
        public f() {
        }

        @Override // d.a.h0.a.e0.n.e
        public void a(d.a.h0.a.p.d.e eVar) {
            if (eVar != null) {
                eVar.t(e.this.N0);
                eVar.X(e.this.b3());
                d.a.h0.a.f1.f.e().a(eVar);
            }
        }

        @Override // d.a.h0.a.e0.n.e
        public void b(d.a.h0.a.p.d.e eVar) {
            if (eVar != null) {
                eVar.S(e.this.N0);
                d.a.h0.a.f1.f.e().b(eVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends d.a.h0.a.e0.n.a {
        public g() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public void a(String str) {
            e.this.h2(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public static int f42028a = -1;

        public static int a() {
            if (f42028a < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_app_fragment_destroy_switch", 1);
                f42028a = 1;
            }
            if (e.Q0) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + f42028a);
            }
            return f42028a;
        }

        public static boolean b() {
            return a() > 0;
        }
    }

    private void T0() {
        if (N()) {
            o3();
        }
        if (Q0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.C0.c())));
        }
    }

    private void W0() {
        if (N()) {
            r3();
        }
        n nVar = this.j0;
        if (nVar != null && nVar.h()) {
            this.j0.x(d.a.h0.a.w0.a.z().a());
        }
        if (Q0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.C0.c())));
        }
    }

    public static e n3(d.a.h0.a.e1.c cVar) {
        e eVar = new e();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.i());
            eVar.c1(bundle);
        }
        return eVar;
    }

    public static void u3(String str) {
        U0 = str;
    }

    public final void A3(boolean z) {
        int i2;
        int i3 = 0;
        if (z) {
            d.a.h0.a.j2.c.b bVar = this.n0;
            if (bVar != null && bVar.i()) {
                i2 = h0.s();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
                layoutParams.topMargin = i3;
                this.B0.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
                layoutParams2.topMargin = i2;
                this.h0.setLayoutParams(layoutParams2);
            }
        } else {
            i3 = B1().getDimensionPixelSize(d.a.h0.a.d.aiapps_normal_base_action_bar_height);
        }
        i2 = 0;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
        layoutParams3.topMargin = i3;
        this.B0.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
        layoutParams22.topMargin = i2;
        this.h0.setLayoutParams(layoutParams22);
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean I() {
        if ((getFloatLayer() == null || !getFloatLayer().d()) && !d.a.z.a.j()) {
            d.a.h0.a.p.d.b bVar = this.C0;
            if (bVar != null) {
                if (d.a.h0.a.b1.b.g(bVar.c())) {
                    return true;
                }
                return this.C0.I();
            }
            return false;
        }
        return true;
    }

    public final void I2(d.a.h0.a.p.d.b bVar) {
        if (bVar == null) {
            return;
        }
        d.a.h0.a.e0.n.c cVar = this.N0;
        if (cVar != null) {
            bVar.t(cVar);
        }
        bVar.Y(c3());
    }

    public final void J2() {
        this.y0 = d.a.h0.a.z1.h.e("805");
    }

    public final d.a.h0.a.p.d.b K2(String str, String str2, String str3, String str4) {
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        b.c d2 = d.a.h0.a.e0.v.b.d(f());
        if (!TextUtils.isEmpty(str4)) {
            HybridUbcFlow p = d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
            p.A(new UbcFlowEvent("na_pre_load_slave_check"));
            p.y("preload", d2.f42332b ? "1" : "0");
        }
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + d2);
        }
        d.a.h0.a.e0.v.b.j(d2, new d(d2, str4, str2, str, str3));
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return d2.f42331a;
    }

    @Override // d.a.h0.a.e0.l.c
    public void L1(View view) {
        super.L1(view);
        j2(Q1());
        if (j3()) {
            V1();
        }
        p3();
        this.i0.setOnDoubleClickListener(new b());
    }

    public final void L2(View view) {
        d.a.h0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
        String f2 = this.g0.f();
        String h2 = this.g0.h();
        String g2 = this.g0.g();
        String c2 = k0.c(f2, g2, h2);
        this.C0 = d.a.h0.a.e0.v.b.f(c2);
        if (Q0) {
            StringBuilder sb = new StringBuilder();
            sb.append("pageUrl: ");
            sb.append(c2);
            sb.append(" is load: ");
            sb.append(this.C0 != null);
            Log.d("SwanAppFragment", sb.toString());
        }
        if (this.C0 == null) {
            if (Q0) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
            }
            this.C0 = K2(f2, g2, h2, "");
        }
        d.a.h0.a.r1.n.c g3 = d.a.h0.a.z0.f.V().g(g2);
        d.a.h0.a.c0.c.g("SwanAppFragment", "create slave webview: " + g2);
        this.C0.z(this.B0, g3);
        this.C0.O(this.B0, g3);
        d3(g2);
        I2(this.C0);
        if (U1()) {
            this.A0.put(g2, this.C0);
            this.D0.f(view, m(), g2);
        }
        d.a.h0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
        J2();
    }

    public final void M2(d.a.h0.a.e1.b bVar, String str) {
        if (this.A0.get(bVar.f42395d) == null) {
            String c2 = k0.c(bVar.f42394c, bVar.f42392a, bVar.f42393b);
            d.a.h0.a.p.d.b f2 = d.a.h0.a.e0.v.b.f(c2);
            if (f2 != null) {
                if (Q0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + c2);
                }
                this.A0.put(bVar.f42392a, f2);
            } else {
                if (Q0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                f2 = K2(bVar.f42394c, bVar.f42392a, bVar.f42393b, str);
                this.A0.put(bVar.f42392a, f2);
            }
            d3(bVar.f42392a);
            I2(f2);
        }
    }

    public final void N2() {
        Map<String, d.a.h0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.a.h0.a.p.d.b bVar : this.A0.values()) {
                if (bVar != null) {
                    x3(bVar);
                    bVar.destroy();
                }
            }
            this.A0.clear();
        } else {
            d.a.h0.a.p.d.b bVar2 = this.C0;
            if (bVar2 != null) {
                x3(bVar2);
                this.C0.destroy();
            }
        }
        this.C0 = null;
        if (Q0) {
            Log.d("SwanAppFragment", "onDestroy() obj: " + this);
        }
        if (this.P0) {
            return;
        }
        d.a.h0.a.e0.v.b.h(d.a.h0.a.z0.f.V().getActivity());
    }

    public void O2() {
        this.L0.j = "default";
        n1();
        p3();
    }

    public void P2(d.a.h0.a.e1.b bVar, String str) {
        String str2 = bVar.f42392a;
        String str3 = bVar.f42395d;
        d.a.h0.a.r1.n.c g2 = d.a.h0.a.z0.f.V().g(TextUtils.isEmpty(str3) ? "" : str3);
        d.a.h0.a.e1.b bVar2 = this.z0;
        bVar2.f42392a = str2;
        bVar2.f42393b = bVar != null ? bVar.e() : "";
        this.z0.f42395d = str3;
        this.L0 = g2;
        boolean z = false;
        if (l3(str3)) {
            w3(str3);
        } else {
            z = true;
            M2(bVar, str);
            w3(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                d.a.h0.a.j1.j.c(7, str);
            } else {
                d.a.h0.a.j1.j.c(6, str);
            }
            d.a.h0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.a.h0.a.j1.j.a(str);
        }
        h2(g2.f43857b);
        n2(SwanAppConfigData.s(g2.f43858c));
        f2(g2.f43856a);
        p3();
        z3();
        d.a.h0.a.c0.c.g("SwanAppFragment", "switch tab title: " + g2.f43857b + " page:" + str2);
    }

    public d.a.h0.a.e1.b Q2() {
        return this.z0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [d.a.h0.a.p.d.c] */
    @NonNull
    public Pair<Integer, Integer> R2() {
        d.a.h0.a.p.d.b bVar = this.C0;
        if (bVar == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = bVar.s().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean S1() {
        return true;
    }

    public d.a.h0.a.p.d.b S2() {
        return this.C0;
    }

    public final int T2() {
        return T1() ? k3() ? 18 : 17 : k3() ? 12 : 15;
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean U1() {
        SwanAppConfigData u;
        d.a.h0.a.e1.c cVar;
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        if (V == null || (u = V.u()) == null || !u.m() || (cVar = this.g0) == null) {
            return false;
        }
        return u.q(cVar.g());
    }

    public final void U2(boolean z) {
        if (d.a.h0.a.d1.a.g(z)) {
            d.a.h0.a.d1.a.j(m(), this.j0, d.a.h0.a.r1.e.O().J().c0().paNumber);
        }
    }

    public final void V2(boolean z) {
        if (d.a.h0.a.d1.a.g(z)) {
            d.a.h0.a.d1.a.i(m(), this.i0, d.a.h0.a.r1.e.O().J().c0().paNumber);
        } else if (d.a.h0.a.r1.e.O() == null) {
        } else {
            d.a.h0.a.d1.a.l(this.i0, d.a.h0.a.r1.e.O().H().d("key_unread_counts_message", 0).intValue());
        }
    }

    public String W2() {
        d.a.h0.a.p.d.b bVar = this.C0;
        return bVar != null ? bVar.c() : "";
    }

    public List<String> X2() {
        ArrayList arrayList = new ArrayList();
        Map<String, d.a.h0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, d.a.h0.a.p.d.b> entry : this.A0.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().c());
                }
            }
        }
        d.a.h0.a.p.d.b bVar = this.C0;
        if (bVar != null) {
            String c2 = bVar.c();
            if (!arrayList.contains(c2)) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Y1() {
        G1();
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45414d = "gohome";
        fVar.f45413c = "bar";
        e J = d.a.h0.a.z0.f.V().J();
        d.a.h0.a.e1.c F1 = J == null ? null : J.F1();
        if (F1 != null && !TextUtils.isEmpty(F1.g())) {
            fVar.a("page", F1.g());
        }
        s1(fVar);
    }

    @Nullable
    public d.a.h0.a.d2.b.a Y2() {
        return this.D0;
    }

    @Override // d.a.h0.a.e0.l.c
    public void Z1() {
        this.C0.R();
        e3();
        U2(true);
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.k0;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setAttentionBtnStates(d.a.h0.a.g0.c.a.n(d.a.h0.a.r1.d.e().getAppId()));
        }
        this.j0.r(d.a.h0.a.w0.a.z().a(), y1(), this.k0, false);
    }

    public String Z2(String str) {
        if (this.A0.containsKey(str)) {
            return this.A0.get(str).c();
        }
        return null;
    }

    public FrameLayout a3() {
        return this.B0;
    }

    public final d.a.h0.a.e0.n.a b3() {
        return new g();
    }

    @Override // d.a.h0.a.e0.l.c
    public void c2() {
        super.c2();
        p3();
    }

    public final d.a.h0.a.e0.n.e c3() {
        return new f();
    }

    public final void d3(String str) {
        if (h3()) {
            return;
        }
        d.a.h0.a.z0.f V = d.a.h0.a.z0.f.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.g(str).f43863h && this.N0 == null) {
            this.N0 = new C0633e();
        }
    }

    @DebugTrace
    public void e3() {
        FragmentActivity f2 = f();
        if (this.k0 == null) {
            this.k0 = new SwanAppMenuHeaderView(m());
        }
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(f2, this.i0, T2(), d.a.h0.a.w0.a.y(), new d.a.h0.a.j2.g.b());
        new d.a.h0.a.c1.a(this.j0, this, this.k0).z();
        if (d.a.h0.a.c1.c.b.d()) {
            this.j0.k(50);
        }
    }

    public PullToRefreshBaseWebView f0() {
        d.a.h0.a.p.d.b bVar = this.C0;
        if (bVar != null) {
            return bVar.f0();
        }
        return null;
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void f1(boolean z) {
        if (d0()) {
            super.f1(z);
            if (Q0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                r3();
                V2(false);
                return;
            }
            o3();
        }
    }

    @Override // d.a.h0.a.e0.l.c
    public boolean f2(int i2) {
        boolean f2 = super.f2(i2);
        p3();
        return f2;
    }

    public boolean f3() {
        d.a.h0.a.d2.b.a aVar = this.D0;
        if (aVar == null) {
            return false;
        }
        return aVar.p();
    }

    public final boolean g3() {
        d.a.h0.a.r1.n.c cVar = this.L0;
        return cVar != null && cVar.f43863h;
    }

    @Override // d.a.h0.a.q1.b.c.a.InterfaceC0736a
    public d.a.h0.a.q1.b.c.a getFloatLayer() {
        if (this.E0 == null) {
            if (this.K0 == null) {
                return null;
            }
            this.E0 = new d.a.h0.a.q1.b.c.a(this, (LinearLayout) this.K0.findViewById(d.a.h0.a.f.ai_apps_fragment_base_view), B1().getDimensionPixelOffset(d.a.h0.a.d.aiapps_normal_base_action_bar_height));
        }
        return this.E0;
    }

    public final boolean h3() {
        d.a.h0.a.r1.n.c cVar = this.L0;
        if (cVar != null) {
            return TextUtils.equals(cVar.j, SchedulerSupport.CUSTOM);
        }
        return false;
    }

    public final boolean i3(d.a.h0.a.e0.l.f fVar, SwanAppConfigData swanAppConfigData) {
        d.a.h0.a.e0.l.c j = fVar.j(0);
        if (j == null || !(j instanceof e)) {
            return false;
        }
        String d2 = ((e) j).Q2().d();
        return swanAppConfigData.q(d2) || TextUtils.equals(swanAppConfigData.e(), d2);
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return Q1() && this.C0.isSlidable(motionEvent);
    }

    public final boolean j3() {
        SwanAppConfigData u;
        d.a.h0.a.e0.l.f E1 = E1();
        if (E1 == null) {
            return false;
        }
        d.a.h0.a.r1.n.c cVar = this.L0;
        if ((cVar != null && cVar.k) || (u = d.a.h0.a.z0.f.V().u()) == null) {
            return false;
        }
        return !i3(E1, u);
    }

    public final boolean k3() {
        SwanAppConfigData u = d.a.h0.a.z0.f.V().u();
        return (u == null || TextUtils.equals(u.e(), this.z0.d())) ? false : true;
    }

    public final boolean l3(String str) {
        return (this.A0.isEmpty() || this.A0.get(str) == null) ? false : true;
    }

    public void m3(d.a.h0.a.z1.k.g gVar) {
        d.a.h0.a.z1.a aVar = this.y0;
        if (aVar != null) {
            d.a.h0.a.z1.h.k(aVar, gVar);
            this.y0 = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void n0(Activity activity) {
        super.n0(activity);
        if (Q0) {
            Log.d("SwanAppFragment", "onAttach() obj: " + this);
        }
    }

    @Override // d.a.h0.a.e0.l.c
    public void o1(int i2) {
        if (!d.a.h0.a.r1.n.c.f(this.L0)) {
            super.o1(i2);
            return;
        }
        p1(i2, h3() ? true : true ^ c0.e(this.f0));
        p3();
    }

    public void o3() {
        PullToRefreshBaseWebView f0;
        boolean z = this.C0 == null;
        String c2 = z ? "" : this.C0.c();
        if (Q0) {
            Log.d("SwanAppFragment", "pause() wvID: " + c2);
        }
        if (!z) {
            this.C0.onPause();
            s3("onHide");
        }
        if (getFloatLayer() != null && !getFloatLayer().d()) {
            getFloatLayer().g();
        }
        d.a.h0.a.c0.c.g("SwanApp", "onHide");
        d.a.h0.a.b1.b.i(false);
        if (z || (f0 = this.C0.f0()) == null) {
            return;
        }
        f0.w(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q3();
        if (Q0) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.j(new a(), "SwanAppPageHistory");
        d.a.h0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (h.b()) {
            k0.q().postAtFrontOfQueue(new c());
        } else {
            N2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        T0();
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        W0();
        V2(false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p3() {
        int i2;
        d.a.h0.a.r1.n.c cVar;
        d.a.h0.a.p.d.c cVar2;
        TextView centerTitleView;
        if (this.i0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (h3()) {
            m2(true);
            i2 = 0;
        } else if (g3()) {
            m2(false);
            d.a.h0.a.p.d.b bVar = this.C0;
            if (bVar != null) {
                if (bVar.l() != null) {
                    cVar2 = this.C0.l().s();
                } else {
                    cVar2 = this.C0.s();
                }
                if (cVar2 != null) {
                    i2 = cVar2.getWebViewScrollY();
                    cVar = this.L0;
                    if (cVar != null && cVar.f43864i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            cVar = this.L0;
            if (cVar != null) {
                i3 = 0;
            }
        } else {
            m2(false);
            i2 = R0 + this.M0;
            centerTitleView = this.i0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            y3(i2);
            A3(z);
        }
        z = true;
        centerTitleView = this.i0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        y3(i2);
        A3(z);
    }

    public final void q3() {
        Bundle i2 = i();
        if (i2 == null) {
            return;
        }
        d.a.h0.a.e1.c e2 = d.a.h0.a.e1.c.e(i2.getString("ai_apps_param"));
        this.g0 = e2;
        this.z0.f42392a = e2 != null ? e2.g() : "";
        d.a.h0.a.e1.b bVar = this.z0;
        d.a.h0.a.e1.c cVar = this.g0;
        bVar.f42393b = cVar != null ? cVar.h() : "";
        d.a.h0.a.e1.b bVar2 = this.z0;
        bVar2.f42395d = d.a.h0.a.t1.k.p0.j.b(bVar2.d());
        d.a.h0.a.r1.n.c g2 = d.a.h0.a.z0.f.V().g(this.z0.f());
        this.L0 = g2;
        if (g2.m) {
            this.L0 = d.a.h0.a.z0.f.V().k(this.z0.d());
        }
        this.M0 = B1().getDimensionPixelSize(d.a.h0.a.d.aiapps_normal_base_action_bar_height);
    }

    public void r3() {
        boolean z = this.C0 == null;
        String c2 = z ? "" : this.C0.c();
        if (Q0) {
            Log.d("SwanAppFragment", "resume() wvID: " + c2);
        }
        if (!z) {
            j2(Q1());
            this.C0.onResume();
            t3();
            s3("onShow");
        }
        d.a.h0.a.c0.c.g("SwanApp", "onShow");
        d.a.h0.a.b1.b.i(true);
        if (d.a.h0.a.c0.c.d()) {
            d.a.h0.a.e0.j.b.b();
        }
    }

    public final void s3(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.C0.c());
        d.a.h0.a.k0.b.c cVar = new d.a.h0.a.k0.b.c(hashMap);
        if (Q0) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.C0.c());
        }
        d.a.h0.a.z0.f.V().x(cVar);
    }

    public final void t3() {
        if (!TextUtils.equals(T0, this.C0.c()) || TextUtils.equals(U0, "switchTab")) {
            int o = this.D0.o(Q2().f());
            d.a.h0.a.k0.b.e eVar = new d.a.h0.a.k0.b.e();
            eVar.f43112b = T0;
            eVar.f43113c = this.C0.c();
            eVar.f43114d = U0;
            eVar.f43115e = this.z0.f42392a;
            eVar.f43116f = String.valueOf(o);
            U0 = "";
            if (Q0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.f43112b + " ,toId: " + eVar.f43113c + " ,RouteType: " + eVar.f43114d + " page:" + eVar.f43115e + ",TabIndex: " + eVar.f43116f);
            }
            d.a.h0.a.z0.f.V().x(eVar);
            T0 = this.C0.c();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.h0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
        View inflate = layoutInflater.inflate(d.a.h0.a.g.aiapps_fragment, viewGroup, false);
        this.B0 = (FrameLayout) inflate.findViewById(d.a.h0.a.f.ai_apps_fragment_content);
        L1(inflate);
        this.D0 = new d.a.h0.a.d2.b.a(this);
        L2(inflate);
        if (!d.a.h0.a.c1.c.b.d() && !d.a.h0.a.c1.c.b.e()) {
            d.a.h0.a.c1.c.a.b(this.C0.c(), String.valueOf(d.a.h0.a.c1.c.b.c()));
        }
        if (K1()) {
            inflate = N1(inflate);
        }
        this.K0 = u1(inflate, this);
        this.p0.setRegionFactor(this.C0.A());
        d.a.h0.a.f1.f.e().j();
        return this.K0;
    }

    public void v3(d.a.h0.a.e1.b bVar) {
        if (Q0) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.D0.o(Q2().f()) == this.D0.o(bVar.f())) {
            return;
        }
        this.D0.E(bVar.f());
        onPause();
        P2(bVar, "");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0() {
        super.w0();
        Map<String, d.a.h0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.a.h0.a.p.d.b bVar : this.A0.values()) {
                if (bVar != null) {
                    bVar.d0();
                }
            }
            return;
        }
        d.a.h0.a.p.d.b bVar2 = this.C0;
        if (bVar2 != null) {
            bVar2.d0();
        }
    }

    @Override // d.a.h0.a.e0.l.c
    public void w2() {
        if (this.C0 == null) {
            if (Q0) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.C0.c());
        d.a.h0.a.p.d.e l = this.C0.l();
        if (l != null) {
            hashMap.put("webViewUrl", l.getCurrentPageUrl());
        }
        d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.b("sharebtn", hashMap));
    }

    public final void w3(String str) {
        d.a.h0.a.p.d.b bVar = this.A0.get(str);
        if (this.C0 == bVar || bVar == null) {
            return;
        }
        d.a.h0.a.r1.n.c g2 = d.a.h0.a.z0.f.V().g(str);
        bVar.z(this.B0, g2);
        if (!bVar.a()) {
            bVar.O(this.B0, g2);
        }
        bVar.F(0);
        d.a.h0.a.p.d.b bVar2 = this.C0;
        if (bVar2 != null) {
            bVar2.F(8);
        }
        this.C0 = bVar;
    }

    @Override // d.a.h0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void x0() {
        super.x0();
    }

    @Override // d.a.h0.a.e0.l.c
    public d.a.h0.a.r1.n.c x1() {
        return this.L0;
    }

    public final void x3(d.a.h0.a.p.d.b bVar) {
        d.a.h0.a.e0.n.c cVar = this.N0;
        if (cVar == null || bVar == null) {
            return;
        }
        bVar.S(cVar);
        if (bVar.l() != null) {
            bVar.S(this.N0);
        }
    }

    public final void y3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        float f2 = 1.0f;
        float f3 = (i2 - R0) * 1.0f;
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
        if (Q0 && i4 != 0 && i4 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
        }
        d.a.h0.a.j2.c.b bVar = this.n0;
        if (bVar != null && bVar.i() && (e2 = this.n0.e()) != null && (background = e2.getBackground()) != null) {
            background.setAlpha(i4);
        }
        Drawable background2 = this.i0.getBackground();
        if (background2 != null) {
            background2.setAlpha(i4);
        }
        d.a.h0.a.r1.n.c cVar = this.L0;
        if (cVar != null && cVar.f43864i && (centerTitleView = this.i0.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f2);
        }
        Drawable background3 = this.l0.getBackground();
        if (background3 != null) {
            background3.setAlpha(i4);
        }
    }

    public void z3() {
        d.a.h0.a.e1.c cVar = this.g0;
        if (cVar == null) {
            return;
        }
        cVar.j();
    }
}
