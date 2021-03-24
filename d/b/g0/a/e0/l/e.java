package d.b.g0.a.e0.l;

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
import d.b.g0.a.e0.v.b;
import d.b.g0.a.i2.b0;
import d.b.g0.a.i2.c0;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.c.a;
import d.b.g0.i.n;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class e extends d.b.g0.a.e0.l.c implements a.InterfaceC0764a {
    public static final boolean Q0 = k.f45050a;
    public static final int R0 = h0.f(149.0f);
    public static String S0 = "-1";
    public static String T0 = "-1";
    public static String U0;
    public FrameLayout B0;
    public d.b.g0.a.p.d.b C0;
    public d.b.g0.a.d2.b.a D0;
    public d.b.g0.a.q1.b.c.a E0;
    public View K0;
    public d.b.g0.a.r1.n.c L0;
    public d.b.g0.a.e0.n.c N0;
    public d.b.g0.a.p.c.h0 O0;
    public d.b.g0.a.z1.a y0;
    public d.b.g0.a.e1.b z0 = new d.b.g0.a.e1.b();
    public Map<String, d.b.g0.a.p.d.b> A0 = new TreeMap();
    public int M0 = 0;
    public boolean P0 = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.O0 = d.b.g0.a.w0.a.C();
            d.b.g0.a.p.c.h0 h0Var = e.this.O0;
            e eVar = e.this;
            h0Var.a(eVar.g0, eVar.l());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanAppActionBar.c {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            String c2 = e.this.C0.c();
            d.b.g0.a.k0.b.g gVar = new d.b.g0.a.k0.b.g();
            gVar.f45068b = d.b.g0.a.j2.f.c.a.a(c2, "scrollViewBackToTop");
            d.b.g0.a.z0.f.V().z(c2, gVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.O2();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements b.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.c f44000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44002c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44003d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44004e;

        public d(b.c cVar, String str, String str2, String str3, String str4) {
            this.f44000a = cVar;
            this.f44001b = str;
            this.f44002c = str2;
            this.f44003d = str3;
            this.f44004e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [d.b.g0.a.p.d.c] */
        @Override // d.b.g0.a.e0.v.b.d
        public void onReady() {
            String str;
            d.b.g0.a.e0.w.b bVar = new d.b.g0.a.e0.w.b();
            bVar.i = this.f44000a.f44303a.w();
            if (!TextUtils.isEmpty(this.f44001b)) {
                d.b.g0.a.j1.j.e(this.f44000a, this.f44001b);
            }
            String b2 = d.b.g0.a.t1.k.p0.j.b(this.f44002c);
            bVar.f44316a = this.f44003d;
            if (TextUtils.isEmpty(this.f44004e)) {
                str = this.f44002c;
            } else {
                str = this.f44002c + "?" + this.f44004e;
            }
            bVar.f44317b = str;
            if (d.b.g0.a.r1.e.O() != null) {
                bVar.f44318c = d.b.g0.a.r1.e.O().Q(b2);
                bVar.f44321f = d.b.g0.a.r1.e.O().K(b2);
            }
            bVar.k = d.b.g0.a.e0.w.a.b(d.b.g0.a.r1.e.y(), bVar.f44317b);
            bVar.f44319d = d.b.g0.a.z0.f.V().k(b2).f45776g;
            bVar.f44320e = String.valueOf(d.b.g0.a.c0.a.a());
            bVar.f44322g = e.Q0 || d.b.g0.a.z0.f.V().O();
            if (d.b.g0.a.m1.a.a.C()) {
                bVar.j = d.b.g0.a.c0.d.b.d();
            }
            if (!TextUtils.isEmpty(this.f44001b)) {
                String str2 = this.f44001b;
                bVar.f44323h = str2;
                d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).A(new UbcFlowEvent("slave_dispatch_start"));
            }
            b0.d();
            this.f44000a.f44303a.getWebView().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f44002c);
            this.f44000a.f44303a.s(bVar.f44317b);
            d.b.g0.a.z0.f.V().z(this.f44000a.f44303a.c(), d.b.g0.a.e0.w.b.a(bVar));
            d.b.g0.a.z1.e.B(this.f44000a.f44303a.c(), bVar.f44317b);
            if (e.Q0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + bVar.toString());
            }
        }
    }

    /* renamed from: d.b.g0.a.e0.l.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0661e implements d.b.g0.a.e0.n.c {
        public C0661e() {
        }

        @Override // d.b.g0.a.e0.n.c
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            e.this.z3(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.e0.n.e {
        public f() {
        }

        @Override // d.b.g0.a.e0.n.e
        public void a(d.b.g0.a.p.d.e eVar) {
            if (eVar != null) {
                eVar.F(e.this.N0);
                eVar.P(e.this.c3());
                d.b.g0.a.f1.f.e().a(eVar);
            }
        }

        @Override // d.b.g0.a.e0.n.e
        public void b(d.b.g0.a.p.d.e eVar) {
            if (eVar != null) {
                eVar.H(e.this.N0);
                d.b.g0.a.f1.f.e().b(eVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.b.g0.a.e0.n.a {
        public g() {
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public void a(String str) {
            e.this.i2(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public static int f44009a = -1;

        public static int a() {
            if (f44009a < 0) {
                d.b.g0.a.w0.a.N().getSwitch("swan_app_fragment_destroy_switch", 1);
                f44009a = 1;
            }
            if (e.Q0) {
                Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + f44009a);
            }
            return f44009a;
        }

        public static boolean b() {
            return a() > 0;
        }
    }

    private void U0() {
        if (V()) {
            p3();
        }
        if (Q0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.C0.c())));
        }
    }

    private void X0() {
        if (V()) {
            s3();
        }
        n nVar = this.j0;
        if (nVar != null && nVar.h()) {
            this.j0.x(d.b.g0.a.w0.a.z().a());
        }
        if (Q0) {
            Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.C0.c())));
        }
    }

    public static e o3(d.b.g0.a.e1.c cVar) {
        e eVar = new e();
        if (cVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_param", cVar.i());
            eVar.d1(bundle);
        }
        return eVar;
    }

    public static void v3(String str) {
        U0 = str;
    }

    public void A3() {
        d.b.g0.a.e1.c cVar = this.g0;
        if (cVar == null) {
            return;
        }
        cVar.j();
    }

    public final void B3(boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            d.b.g0.a.j2.c.b bVar = this.n0;
            if (bVar != null && bVar.i()) {
                i = h0.s();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
                layoutParams.topMargin = i2;
                this.B0.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
                layoutParams2.topMargin = i;
                this.h0.setLayoutParams(layoutParams2);
            }
        } else {
            i2 = C1().getDimensionPixelSize(d.b.g0.a.d.aiapps_normal_base_action_bar_height);
        }
        i = 0;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.B0.getLayoutParams();
        layoutParams3.topMargin = i2;
        this.B0.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.h0.getLayoutParams();
        layoutParams22.topMargin = i;
        this.h0.setLayoutParams(layoutParams22);
    }

    public final void J2(d.b.g0.a.p.d.b bVar) {
        if (bVar == null) {
            return;
        }
        d.b.g0.a.e0.n.c cVar = this.N0;
        if (cVar != null) {
            bVar.F(cVar);
        }
        bVar.Q(d3());
    }

    public final void K2() {
        this.y0 = d.b.g0.a.z1.h.e("805");
    }

    public final d.b.g0.a.p.d.b L2(String str, String str2, String str3, String str4) {
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad start.");
        }
        b.c d2 = d.b.g0.a.e0.v.b.d(f());
        if (!TextUtils.isEmpty(str4)) {
            HybridUbcFlow p = d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
            p.A(new UbcFlowEvent("na_pre_load_slave_check"));
            p.y("preload", d2.f44304b ? "1" : "0");
        }
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + d2);
        }
        d.b.g0.a.e0.v.b.j(d2, new d(d2, str4, str2, str, str3));
        if (Q0) {
            Log.d("SwanAppFragment", "createSlaveAndLoad end.");
        }
        return d2.f44303a;
    }

    @Override // d.b.g0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        k2(R1());
        if (k3()) {
            W1();
        }
        q3();
        this.i0.setOnDoubleClickListener(new b());
    }

    public final void M2(View view) {
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
        String f2 = this.g0.f();
        String h2 = this.g0.h();
        String g2 = this.g0.g();
        String c2 = k0.c(f2, g2, h2);
        this.C0 = d.b.g0.a.e0.v.b.f(c2);
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
            this.C0 = L2(f2, g2, h2, "");
        }
        d.b.g0.a.r1.n.c k = d.b.g0.a.z0.f.V().k(g2);
        d.b.g0.a.c0.c.g("SwanAppFragment", "create slave webview: " + g2);
        this.C0.b0(this.B0, k);
        this.C0.E(this.B0, k);
        e3(g2);
        J2(this.C0);
        if (V1()) {
            this.A0.put(g2, this.C0);
            this.D0.f(view, l(), g2);
        }
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
        K2();
    }

    public final void N2(d.b.g0.a.e1.b bVar, String str) {
        if (this.A0.get(bVar.f44364d) == null) {
            String c2 = k0.c(bVar.f44363c, bVar.f44361a, bVar.f44362b);
            d.b.g0.a.p.d.b f2 = d.b.g0.a.e0.v.b.f(c2);
            if (f2 != null) {
                if (Q0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + c2);
                }
                this.A0.put(bVar.f44361a, f2);
            } else {
                if (Q0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                f2 = L2(bVar.f44363c, bVar.f44361a, bVar.f44362b, str);
                this.A0.put(bVar.f44361a, f2);
            }
            e3(bVar.f44361a);
            J2(f2);
        }
    }

    public final void O2() {
        Map<String, d.b.g0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.b.g0.a.p.d.b bVar : this.A0.values()) {
                if (bVar != null) {
                    y3(bVar);
                    bVar.destroy();
                }
            }
            this.A0.clear();
        } else {
            d.b.g0.a.p.d.b bVar2 = this.C0;
            if (bVar2 != null) {
                y3(bVar2);
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
        d.b.g0.a.e0.v.b.h(d.b.g0.a.z0.f.V().getActivity());
    }

    public void P2() {
        this.L0.j = "default";
        o1();
        q3();
    }

    public void Q2(d.b.g0.a.e1.b bVar, String str) {
        String str2 = bVar.f44361a;
        String str3 = bVar.f44364d;
        d.b.g0.a.r1.n.c k = d.b.g0.a.z0.f.V().k(TextUtils.isEmpty(str3) ? "" : str3);
        d.b.g0.a.e1.b bVar2 = this.z0;
        bVar2.f44361a = str2;
        bVar2.f44362b = bVar != null ? bVar.e() : "";
        this.z0.f44364d = str3;
        this.L0 = k;
        boolean z = false;
        if (m3(str3)) {
            x3(str3);
        } else {
            z = true;
            N2(bVar, str);
            x3(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                d.b.g0.a.j1.j.c(7, str);
            } else {
                d.b.g0.a.j1.j.c(6, str);
            }
            d.b.g0.a.j1.i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).A(new UbcFlowEvent("na_push_page_end"));
            d.b.g0.a.j1.j.a(str);
        }
        i2(k.f45771b);
        o2(SwanAppConfigData.s(k.f45772c));
        g2(k.f45770a);
        q3();
        A3();
        d.b.g0.a.c0.c.g("SwanAppFragment", "switch tab title: " + k.f45771b + " page:" + str2);
    }

    public d.b.g0.a.e1.b R2() {
        return this.z0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [d.b.g0.a.p.d.c] */
    @NonNull
    public Pair<Integer, Integer> S2() {
        d.b.g0.a.p.d.b bVar = this.C0;
        if (bVar == null) {
            return new Pair<>(0, 0);
        }
        AbsoluteLayout currentWebView = bVar.getWebView().getCurrentWebView();
        return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    public d.b.g0.a.p.d.b T2() {
        return this.C0;
    }

    public final int U2() {
        return U1() ? l3() ? 18 : 17 : l3() ? 12 : 15;
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean V1() {
        SwanAppConfigData I;
        d.b.g0.a.e1.c cVar;
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        if (V == null || (I = V.I()) == null || !I.m() || (cVar = this.g0) == null) {
            return false;
        }
        return I.q(cVar.g());
    }

    public final void V2(boolean z) {
        if (d.b.g0.a.d1.a.g(z)) {
            d.b.g0.a.d1.a.j(l(), this.j0, d.b.g0.a.r1.e.O().J().c0().paNumber);
        }
    }

    public final void W2(boolean z) {
        if (d.b.g0.a.d1.a.g(z)) {
            d.b.g0.a.d1.a.i(l(), this.i0, d.b.g0.a.r1.e.O().J().c0().paNumber);
        } else if (d.b.g0.a.r1.e.O() == null) {
        } else {
            d.b.g0.a.d1.a.l(this.i0, d.b.g0.a.r1.e.O().H().d("key_unread_counts_message", 0).intValue());
        }
    }

    public String X2() {
        d.b.g0.a.p.d.b bVar = this.C0;
        return bVar != null ? bVar.c() : "";
    }

    public PullToRefreshBaseWebView Y() {
        d.b.g0.a.p.d.b bVar = this.C0;
        if (bVar != null) {
            return bVar.Y();
        }
        return null;
    }

    public List<String> Y2() {
        ArrayList arrayList = new ArrayList();
        Map<String, d.b.g0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, d.b.g0.a.p.d.b> entry : this.A0.entrySet()) {
                if (entry != null) {
                    arrayList.add(entry.getValue().c());
                }
            }
        }
        d.b.g0.a.p.d.b bVar = this.C0;
        if (bVar != null) {
            String c2 = bVar.c();
            if (!arrayList.contains(c2)) {
                arrayList.add(c2);
            }
        }
        return arrayList;
    }

    @Override // d.b.g0.a.e0.l.c
    public void Z1() {
        H1();
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47253d = "gohome";
        fVar.f47252c = "bar";
        e A = d.b.g0.a.z0.f.V().A();
        d.b.g0.a.e1.c G1 = A == null ? null : A.G1();
        if (G1 != null && !TextUtils.isEmpty(G1.g())) {
            fVar.a("page", G1.g());
        }
        t1(fVar);
    }

    @Nullable
    public d.b.g0.a.d2.b.a Z2() {
        return this.D0;
    }

    @Override // d.b.g0.a.e0.l.c
    public void a2() {
        this.C0.I();
        f3();
        V2(true);
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.k0;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setAttentionBtnStates(d.b.g0.a.g0.c.a.n(d.b.g0.a.r1.d.e().getAppId()));
        }
        this.j0.r(d.b.g0.a.w0.a.z().a(), z1(), this.k0, false);
    }

    public String a3(String str) {
        if (this.A0.containsKey(str)) {
            return this.A0.get(str).c();
        }
        return null;
    }

    public FrameLayout b3() {
        return this.B0;
    }

    public final d.b.g0.a.e0.n.a c3() {
        return new g();
    }

    @Override // d.b.g0.a.e0.l.c
    public void d2() {
        super.d2();
        q3();
    }

    public final d.b.g0.a.e0.n.e d3() {
        return new f();
    }

    public final void e3(String str) {
        if (i3()) {
            return;
        }
        d.b.g0.a.z0.f V = d.b.g0.a.z0.f.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.k(str).f45777h && this.N0 == null) {
            this.N0 = new C0661e();
        }
    }

    @DebugTrace
    public void f3() {
        FragmentActivity f2 = f();
        if (this.k0 == null) {
            this.k0 = new SwanAppMenuHeaderView(l());
        }
        if (f2 == null || this.j0 != null) {
            return;
        }
        this.j0 = new n(f2, this.i0, U2(), d.b.g0.a.w0.a.y(), new d.b.g0.a.j2.g.b());
        new d.b.g0.a.c1.a(this.j0, this, this.k0).z();
        if (d.b.g0.a.c1.c.b.d()) {
            this.j0.k(50);
        }
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        if (i0()) {
            super.g1(z);
            if (Q0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                s3();
                W2(false);
                return;
            }
            p3();
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean g2(int i) {
        boolean g2 = super.g2(i);
        q3();
        return g2;
    }

    public boolean g3() {
        d.b.g0.a.d2.b.a aVar = this.D0;
        if (aVar == null) {
            return false;
        }
        return aVar.p();
    }

    @Override // d.b.g0.a.q1.b.c.a.InterfaceC0764a
    public d.b.g0.a.q1.b.c.a getFloatLayer() {
        if (this.E0 == null) {
            if (this.K0 == null) {
                return null;
            }
            this.E0 = new d.b.g0.a.q1.b.c.a(this, (LinearLayout) this.K0.findViewById(d.b.g0.a.f.ai_apps_fragment_base_view), C1().getDimensionPixelOffset(d.b.g0.a.d.aiapps_normal_base_action_bar_height));
        }
        return this.E0;
    }

    public final boolean h3() {
        d.b.g0.a.r1.n.c cVar = this.L0;
        return cVar != null && cVar.f45777h;
    }

    public final boolean i3() {
        d.b.g0.a.r1.n.c cVar = this.L0;
        if (cVar != null) {
            return TextUtils.equals(cVar.j, "custom");
        }
        return false;
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        return R1() && this.C0.isSlidable(motionEvent);
    }

    public final boolean j3(d.b.g0.a.e0.l.f fVar, SwanAppConfigData swanAppConfigData) {
        d.b.g0.a.e0.l.c j = fVar.j(0);
        if (j == null || !(j instanceof e)) {
            return false;
        }
        String d2 = ((e) j).R2().d();
        return swanAppConfigData.q(d2) || TextUtils.equals(swanAppConfigData.e(), d2);
    }

    public final boolean k3() {
        SwanAppConfigData I;
        d.b.g0.a.e0.l.f F1 = F1();
        if (F1 == null) {
            return false;
        }
        d.b.g0.a.r1.n.c cVar = this.L0;
        if ((cVar != null && cVar.k) || (I = d.b.g0.a.z0.f.V().I()) == null) {
            return false;
        }
        return !j3(F1, I);
    }

    public final boolean l3() {
        SwanAppConfigData I = d.b.g0.a.z0.f.V().I();
        return (I == null || TextUtils.equals(I.e(), this.z0.d())) ? false : true;
    }

    public final boolean m3(String str) {
        return (this.A0.isEmpty() || this.A0.get(str) == null) ? false : true;
    }

    public void n3(d.b.g0.a.z1.k.g gVar) {
        d.b.g0.a.z1.a aVar = this.y0;
        if (aVar != null) {
            d.b.g0.a.z1.h.k(aVar, gVar);
            this.y0 = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r3();
        if (Q0) {
            Log.d("SwanAppFragment", "onCreate() obj: " + this);
        }
        p.j(new a(), "SwanAppPageHistory");
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (h.b()) {
            k0.q().postAtFrontOfQueue(new c());
        } else {
            O2();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        U0();
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        X0();
        W2(false);
    }

    @Override // d.b.g0.a.e0.l.c
    public void p1(int i) {
        if (!d.b.g0.a.r1.n.c.f(this.L0)) {
            super.p1(i);
            return;
        }
        q1(i, i3() ? true : true ^ c0.e(this.f0));
        q3();
    }

    public void p3() {
        PullToRefreshBaseWebView Y;
        boolean z = this.C0 == null;
        String c2 = z ? "" : this.C0.c();
        if (Q0) {
            Log.d("SwanAppFragment", "pause() wvID: " + c2);
        }
        if (!z) {
            this.C0.onPause();
            t3("onHide");
        }
        if (getFloatLayer() != null && !getFloatLayer().d()) {
            getFloatLayer().g();
        }
        d.b.g0.a.c0.c.g("SwanApp", "onHide");
        d.b.g0.a.b1.b.i(false);
        if (z || (Y = this.C0.Y()) == null) {
            return;
        }
        Y.w(false);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void q0(Activity activity) {
        super.q0(activity);
        if (Q0) {
            Log.d("SwanAppFragment", "onAttach() obj: " + this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q3() {
        int i;
        d.b.g0.a.r1.n.c cVar;
        d.b.g0.a.p.d.c cVar2;
        TextView centerTitleView;
        if (this.i0 == null) {
            return;
        }
        int i2 = 1;
        boolean z = false;
        if (i3()) {
            n2(true);
            i = 0;
        } else if (h3()) {
            n2(false);
            d.b.g0.a.p.d.b bVar = this.C0;
            if (bVar != null) {
                if (bVar.n() != null) {
                    cVar2 = this.C0.n().getWebView();
                } else {
                    cVar2 = this.C0.getWebView();
                }
                if (cVar2 != null) {
                    i = cVar2.getWebViewScrollY();
                    cVar = this.L0;
                    if (cVar != null && cVar.i) {
                        i2 = 0;
                    }
                }
            }
            i = 0;
            cVar = this.L0;
            if (cVar != null) {
                i2 = 0;
            }
        } else {
            n2(false);
            i = R0 + this.M0;
            centerTitleView = this.i0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i2);
            }
            z3(i);
            B3(z);
        }
        z = true;
        centerTitleView = this.i0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        z3(i);
        B3(z);
    }

    public final void r3() {
        Bundle j = j();
        if (j == null) {
            return;
        }
        d.b.g0.a.e1.c e2 = d.b.g0.a.e1.c.e(j.getString("ai_apps_param"));
        this.g0 = e2;
        this.z0.f44361a = e2 != null ? e2.g() : "";
        d.b.g0.a.e1.b bVar = this.z0;
        d.b.g0.a.e1.c cVar = this.g0;
        bVar.f44362b = cVar != null ? cVar.h() : "";
        d.b.g0.a.e1.b bVar2 = this.z0;
        bVar2.f44364d = d.b.g0.a.t1.k.p0.j.b(bVar2.d());
        d.b.g0.a.r1.n.c k = d.b.g0.a.z0.f.V().k(this.z0.f());
        this.L0 = k;
        if (k.m) {
            this.L0 = d.b.g0.a.z0.f.V().r(this.z0.d());
        }
        this.M0 = C1().getDimensionPixelSize(d.b.g0.a.d.aiapps_normal_base_action_bar_height);
    }

    public void s3() {
        boolean z = this.C0 == null;
        String c2 = z ? "" : this.C0.c();
        if (Q0) {
            Log.d("SwanAppFragment", "resume() wvID: " + c2);
        }
        if (!z) {
            k2(R1());
            this.C0.onResume();
            u3();
            t3("onShow");
        }
        d.b.g0.a.c0.c.g("SwanApp", "onShow");
        d.b.g0.a.b1.b.i(true);
        if (d.b.g0.a.c0.c.d()) {
            d.b.g0.a.e0.j.b.b();
        }
    }

    public final void t3(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("lcType", str);
        hashMap.put("wvID", this.C0.c());
        d.b.g0.a.k0.b.c cVar = new d.b.g0.a.k0.b.c(hashMap);
        if (Q0) {
            Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.C0.c());
        }
        d.b.g0.a.z0.f.V().N(cVar);
    }

    public final void u3() {
        if (!TextUtils.equals(T0, this.C0.c()) || TextUtils.equals(U0, "switchTab")) {
            int o = this.D0.o(R2().f());
            d.b.g0.a.k0.b.e eVar = new d.b.g0.a.k0.b.e();
            eVar.f45061b = T0;
            eVar.f45062c = this.C0.c();
            eVar.f45063d = U0;
            eVar.f45064e = this.z0.f44361a;
            eVar.f45065f = String.valueOf(o);
            U0 = "";
            if (Q0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + eVar.f45061b + " ,toId: " + eVar.f45062c + " ,RouteType: " + eVar.f45063d + " page:" + eVar.f45064e + ",TabIndex: " + eVar.f45065f);
            }
            d.b.g0.a.z0.f.V().N(eVar);
            T0 = this.C0.c();
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public boolean v() {
        if ((getFloatLayer() == null || !getFloatLayer().d()) && !d.b.b0.a.j()) {
            d.b.g0.a.p.d.b bVar = this.C0;
            if (bVar != null) {
                if (d.b.g0.a.b1.b.g(bVar.c())) {
                    return true;
                }
                return this.C0.v();
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.b.g0.a.j1.h.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
        View inflate = layoutInflater.inflate(d.b.g0.a.g.aiapps_fragment, viewGroup, false);
        this.B0 = (FrameLayout) inflate.findViewById(d.b.g0.a.f.ai_apps_fragment_content);
        M1(inflate);
        this.D0 = new d.b.g0.a.d2.b.a(this);
        M2(inflate);
        if (!d.b.g0.a.c1.c.b.d() && !d.b.g0.a.c1.c.b.e()) {
            d.b.g0.a.c1.c.a.b(this.C0.c(), String.valueOf(d.b.g0.a.c1.c.b.c()));
        }
        if (L1()) {
            inflate = O1(inflate);
        }
        this.K0 = v1(inflate, this);
        this.p0.setRegionFactor(this.C0.c0());
        d.b.g0.a.f1.f.e().j();
        return this.K0;
    }

    public void w3(d.b.g0.a.e1.b bVar) {
        if (Q0) {
            Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
        }
        if (this.D0.o(R2().f()) == this.D0.o(bVar.f())) {
            return;
        }
        this.D0.E(bVar.f());
        onPause();
        Q2(bVar, "");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void x0() {
        super.x0();
        Map<String, d.b.g0.a.p.d.b> map = this.A0;
        if (map != null && !map.isEmpty()) {
            for (d.b.g0.a.p.d.b bVar : this.A0.values()) {
                if (bVar != null) {
                    bVar.W();
                }
            }
            return;
        }
        d.b.g0.a.p.d.b bVar2 = this.C0;
        if (bVar2 != null) {
            bVar2.W();
        }
    }

    @Override // d.b.g0.a.e0.l.c
    public void x2() {
        if (this.C0 == null) {
            if (Q0) {
                Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", this.C0.c());
        d.b.g0.a.p.d.e n = this.C0.n();
        if (n != null) {
            hashMap.put("webViewUrl", n.getCurrentPageUrl());
        }
        d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.b("sharebtn", hashMap));
    }

    public final void x3(String str) {
        d.b.g0.a.p.d.b bVar = this.A0.get(str);
        if (this.C0 == bVar || bVar == null) {
            return;
        }
        d.b.g0.a.r1.n.c k = d.b.g0.a.z0.f.V().k(str);
        bVar.b0(this.B0, k);
        if (!bVar.a()) {
            bVar.E(this.B0, k);
        }
        bVar.f0(0);
        d.b.g0.a.p.d.b bVar2 = this.C0;
        if (bVar2 != null) {
            bVar2.f0(8);
        }
        this.C0 = bVar;
    }

    @Override // d.b.g0.a.e0.l.c, com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        super.y0();
    }

    @Override // d.b.g0.a.e0.l.c
    public d.b.g0.a.r1.n.c y1() {
        return this.L0;
    }

    public final void y3(d.b.g0.a.p.d.b bVar) {
        d.b.g0.a.e0.n.c cVar = this.N0;
        if (cVar == null || bVar == null) {
            return;
        }
        bVar.H(cVar);
        if (bVar.n() != null) {
            bVar.H(this.N0);
        }
    }

    public final void z3(int i) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        float f2 = 1.0f;
        float f3 = (i - R0) * 1.0f;
        int i2 = this.M0;
        if (i2 == 0) {
            i2 = 1;
        }
        float f4 = f3 / i2;
        if (f4 <= 0.0f) {
            f2 = 0.0f;
        } else if (f4 < 1.0f) {
            f2 = f4;
        }
        int i3 = (int) (255.0f * f2);
        if (Q0 && i3 != 0 && i3 != 255) {
            Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i3);
        }
        d.b.g0.a.j2.c.b bVar = this.n0;
        if (bVar != null && bVar.i() && (e2 = this.n0.e()) != null && (background = e2.getBackground()) != null) {
            background.setAlpha(i3);
        }
        Drawable background2 = this.i0.getBackground();
        if (background2 != null) {
            background2.setAlpha(i3);
        }
        d.b.g0.a.r1.n.c cVar = this.L0;
        if (cVar != null && cVar.i && (centerTitleView = this.i0.getCenterTitleView()) != null) {
            centerTitleView.setAlpha(f2);
        }
        Drawable background3 = this.l0.getBackground();
        if (background3 != null) {
            background3.setAlpha(i3);
        }
    }
}
