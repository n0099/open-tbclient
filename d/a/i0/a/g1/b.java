package d.a.i0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.xiaomi.mipush.sdk.Constants;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.n;
import d.a.i0.a.v2.f0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.x0;
/* loaded from: classes3.dex */
public abstract class b implements d {
    public static final boolean j = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.p.e.a f41715a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.a2.n.b f41716b = new d.a.i0.a.a2.n.b();

    /* renamed from: c  reason: collision with root package name */
    public String f41717c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f41718d;

    /* renamed from: e  reason: collision with root package name */
    public e f41719e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f41720f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f41721g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41722h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41723i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f41724e;

        public a(boolean z) {
            this.f41724e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity = b.this.f41718d;
            if (swanAppActivity != null) {
                int taskId = swanAppActivity.getTaskId();
                b.this.f41718d.finish();
                if (this.f41724e) {
                    b.this.f41718d.overridePendingTransition(0, d.a.i0.a.a.aiapps_slide_out_to_right_zadjustment_top);
                }
                d.a.i0.a.v2.c.m().l(taskId);
            }
        }
    }

    /* renamed from: d.a.i0.a.g1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0628b implements FullScreenFloatView.c {
        public C0628b() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            b.this.q().W();
        }
    }

    public b() {
        d.a.i0.a.h0.u.g.N();
        e eVar = new e();
        this.f41719e = eVar;
        eVar.h(this);
    }

    @Override // d.a.i0.a.g1.d
    public String A() {
        return TextUtils.isEmpty(this.f41717c) ? "" : this.f41717c;
    }

    @Override // d.a.i0.a.g1.d
    public d.a.i0.a.p.e.d B(String str) {
        return d.a.i0.a.h0.u.g.N().W(str);
    }

    @Override // d.a.i0.a.g1.d
    public AbsoluteLayout C(String str) {
        d.a.i0.a.p.e.c u;
        d.a.i0.a.p.e.d B = B(str);
        if (B == null || (u = B.u()) == null) {
            return null;
        }
        return u.getCurrentWebView();
    }

    @Override // d.a.i0.a.g1.d
    public String D() {
        d.a.i0.a.h0.g.f J = J();
        return J != null ? J.g3() : "";
    }

    @Override // d.a.i0.a.g1.d
    public void E(Context context) {
        if (this.f41719e == null) {
            return;
        }
        R();
        this.f41719e.c(context);
    }

    @Override // d.a.i0.a.g1.d
    @Nullable
    public d.a.i0.a.a2.e F() {
        return d.a.i0.a.a2.e.i();
    }

    @Override // d.a.i0.a.g1.d
    @CallSuper
    public void G(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        R();
    }

    @Override // d.a.i0.a.g1.d
    public d.a.i0.a.p.b.a.k H() {
        return null;
    }

    @Override // d.a.i0.a.g1.d
    @NonNull
    public final d.a.i0.a.k2.f.d I() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return new d.a.i0.a.k2.f.b();
        }
        return Q.W();
    }

    @Override // d.a.i0.a.g1.d
    public d.a.i0.a.h0.g.f J() {
        d.a.i0.a.h0.g.g U = U();
        if (U == null) {
            return null;
        }
        return U.o();
    }

    @Override // d.a.i0.a.g1.d
    public void K() {
        e eVar;
        if (!j() || (eVar = this.f41719e) == null) {
            return;
        }
        eVar.i();
    }

    @Override // d.a.i0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        R();
        if (activity == null) {
            return null;
        }
        if (this.f41721g == null && (viewGroup = (ViewGroup) activity.findViewById(d.a.i0.a.f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f41721g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f41721g);
        }
        return this.f41721g;
    }

    @Override // d.a.i0.a.g1.d
    public n M() {
        return null;
    }

    @Override // d.a.i0.a.g1.d
    public SwanCoreVersion N() {
        return null;
    }

    @Override // d.a.i0.a.g1.d
    public boolean O() {
        R();
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        b.a N = i2 != null ? i2.N() : null;
        return N != null && ((j && N.m0()) || d.a.i0.a.v.a.g(N) || d.a.i0.a.v.a.d(N));
    }

    @Override // d.a.i0.a.g1.d
    @CallSuper
    public void P() {
        this.f41723i = true;
        e eVar = this.f41719e;
        if (eVar != null) {
            eVar.j();
            this.f41719e = null;
        }
        d.a.i0.a.v1.a.b.b.a.b().d();
        V();
        if (!d.a.i0.a.r1.l.e.g()) {
            d.a.i0.a.f1.c.b.c().a();
            d.a.i0.a.r1.r.a.f().b();
        }
        if (d.a.i0.a.r1.l.e.j()) {
            d.a.i0.a.r1.l.f.a.e().g(d.a.i0.a.a2.d.g().getAppId());
        } else {
            d.a.i0.a.r1.l.f.a.e().f();
            d.a.i0.a.n1.q.c.a.o();
        }
        d.a.i0.a.l2.b.u(true);
        this.f41718d = null;
    }

    @Override // d.a.i0.a.g1.d
    public n Q() {
        return null;
    }

    public void R() {
        if (getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void S(boolean z) {
        if (this.f41718d != null) {
            q0.b0(new a(z));
        }
    }

    @NonNull
    public Pair<Integer, Integer> T() {
        d.a.i0.a.h0.g.f J = J();
        if (J == null) {
            return new Pair<>(0, 0);
        }
        return J.a3();
    }

    public d.a.i0.a.h0.g.g U() {
        SwanAppActivity swanAppActivity = this.f41718d;
        if (swanAppActivity == null) {
            return null;
        }
        return swanAppActivity.getSwanAppFragmentManager();
    }

    public final void V() {
        FullScreenFloatView fullScreenFloatView = this.f41720f;
        if (fullScreenFloatView != null) {
            ViewParent parent = fullScreenFloatView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f41720f);
            }
        }
        d.a.i0.a.p.e.a aVar = this.f41715a;
        if (aVar != null) {
            aVar.E();
        }
        d.a.i0.a.e0.c.e();
    }

    @Override // d.a.i0.a.g1.d
    public String a() {
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null || Q.N() == null) {
            return null;
        }
        return d.a.i0.a.f1.e.b.k1(Q.N(), f.V().s());
    }

    @Override // d.a.i0.a.g1.d
    public void b() {
        this.f41722h = true;
    }

    @Override // d.a.i0.a.g1.d
    @CallSuper
    public void c(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        R();
    }

    @Override // d.a.i0.a.g1.d
    @NonNull
    public d.a.i0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
            return this.f41716b.b(str2, str, swanAppConfigData.f11348e);
        }
        return e(str);
    }

    @Override // d.a.i0.a.g1.d
    @NonNull
    public d.a.i0.a.a2.n.g e(String str) {
        SwanAppConfigData s = s();
        if (s == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.a.i0.a.a2.n.g.d();
        }
        return this.f41716b.b(A(), str, s.f11348e);
    }

    @Override // d.a.i0.a.g1.d
    public void exit() {
        S(true);
    }

    @Override // d.a.i0.a.g1.d
    public String f() {
        SwanAppConfigData s = s();
        return s == null ? "" : s.e();
    }

    @Override // d.a.i0.a.g1.e.b
    public void g(int i2) {
        R();
        d.a.i0.a.v2.c.m().x(this.f41718d);
        S(false);
    }

    @Override // d.a.i0.a.g1.d
    public SwanAppActivity getActivity() {
        return d.a.i0.a.a2.d.g().x();
    }

    @Override // d.a.i0.a.g1.d
    public d.a.i0.a.p.e.c h() {
        d.a.i0.a.p.e.d B = B(D());
        if (B == null) {
            return null;
        }
        return B.u();
    }

    @Override // d.a.i0.a.g1.d
    public d.a.i0.a.a2.n.g i(String str) {
        SwanAppConfigData s = s();
        if (s == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.a.i0.a.a2.n.g.d();
        }
        return this.f41716b.a(A(), str, s.f11348e);
    }

    @Override // d.a.i0.a.g1.d
    public void k(Context context) {
        e eVar = this.f41719e;
        if (eVar == null) {
            return;
        }
        eVar.f(context);
    }

    @Override // d.a.i0.a.g1.d
    public void l(SwanAppActivity swanAppActivity) {
        this.f41718d = swanAppActivity;
    }

    @Override // d.a.i0.a.g1.d
    public void m(String str, d.a.i0.a.o0.d.a aVar) {
        d.a.i0.a.h0.u.g.N().I0(str, aVar);
    }

    @Override // d.a.i0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        R();
        if (activity == null) {
            return null;
        }
        if (this.f41720f == null) {
            FullScreenFloatView a2 = d.a.i0.a.z1.a.a.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.f41720f = a2;
            a2.setFloatButtonText(activity.getString(d.a.i0.a.h.aiapps_sconsole));
            this.f41720f.setFloatImageBackground(d.a.i0.a.e.aiapps_float_view_button_shape);
            this.f41720f.setVisibility(8);
            this.f41720f.setDragImageListener(new C0628b());
        }
        return this.f41720f;
    }

    @Override // d.a.i0.a.g1.d
    public void o() {
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (x == null || x.isFinishing()) {
            return;
        }
        x.removeLoadingView();
    }

    @Override // d.a.i0.a.g1.d
    public void p() {
        this.f41722h = false;
    }

    @Override // d.a.i0.a.g1.d
    @DebugTrace
    public d.a.i0.a.p.e.a q() {
        d.a.i0.a.p.e.a b2 = d.a.i0.a.e0.c.b();
        SwanAppActivity swanAppActivity = this.f41718d;
        if (swanAppActivity != null) {
            b2.H((ViewGroup) swanAppActivity.findViewById(d.a.i0.a.f.ai_apps_activity_root));
        }
        return b2;
    }

    @Override // d.a.i0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        Pair<Integer, Integer> T = T();
        int intValue = ((Integer) T.first).intValue();
        int intValue2 = ((Integer) T.second).intValue();
        if (intValue == 0) {
            intValue = n0.o(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = n0.v(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @Override // d.a.i0.a.g1.d
    public SwanAppConfigData s() {
        d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
        if (g2.C()) {
            return g2.r().F();
        }
        return null;
    }

    @Override // d.a.i0.a.g1.d
    public void t(Intent intent) {
        d.a.i0.a.h0.u.g.N().p0(intent);
    }

    @Override // d.a.i0.a.g1.d
    public void u() {
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (x == null || x.isFinishing()) {
            return;
        }
        x.showLoadingView();
    }

    @Override // d.a.i0.a.g1.d
    public void v(d.a.i0.a.o0.d.a aVar) {
        d.a.i0.a.h0.u.g.N().H0(aVar);
    }

    @Override // d.a.i0.a.g1.d
    @CallSuper
    public void w() {
        R();
        String V = d.a.i0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        this.f41722h = true;
        this.f41719e.j();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, V);
        bundle.putInt("task_id", getActivity().getTaskId());
        d.a.i0.a.v1.c.a.e().h(new d.a.i0.a.v1.c.c(9, bundle));
        d.a.i0.a.c1.a.D().c(d.a.i0.a.a2.e.Q() == null ? "" : d.a.i0.a.a2.e.Q().D());
    }

    @Override // d.a.i0.a.g1.d
    @CallSuper
    public void x() {
        String V = d.a.i0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            return;
        }
        K();
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q != null) {
            Q.B().e(Q.getAppId());
        }
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, V);
        bundle.putInt("task_id", x0.b().a());
        d.a.i0.a.v1.c.a.e().h(new d.a.i0.a.v1.c.c(10, bundle));
        d.a.i0.a.c1.a.D().a(d.a.i0.a.a2.e.Q() == null ? "" : d.a.i0.a.a2.e.Q().D());
        d.a.i0.a.c1.a.c().b(AppRuntime.getAppContext(), null, DownloadParams.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
    }

    @Override // d.a.i0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int n = n0.n(appContext);
        int measuredHeight = (d.a.i0.a.a2.d.g().x() == null || (window = d.a.i0.a.a2.d.g().x().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
        if (measuredHeight >= n) {
            return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(measuredHeight));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            n += f0.e(appContext);
        }
        return new Pair<>(Integer.valueOf(n0.o(appContext)), Integer.valueOf(n));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.String] */
    @Override // d.a.i0.a.g1.d
    public void z(d.a.i0.a.o0.d.d dVar, boolean z) {
        d.a.i0.a.r1.g.a("postMessage", "handleNativeMessage start.");
        if (dVar == null) {
            return;
        }
        d.a.i0.a.o0.d.g gVar = new d.a.i0.a.o0.d.g();
        gVar.f43750c = dVar.f43742b;
        gVar.f43751d = z;
        if (j) {
            Log.d("AiBaseController", "handleNativeMessage data: " + dVar.f43742b + " ; needEncode = " + z);
        }
        m(dVar.f43741a, gVar);
        d.a.i0.a.r1.g.a("postMessage", "handleNativeMessage end.");
    }
}
