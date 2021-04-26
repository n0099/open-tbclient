package d.a.h0.a.z0;

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
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.xiaomi.mipush.sdk.Constants;
import d.a.h0.a.e0.l.j;
import d.a.h0.a.i2.c0;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p0;
import d.a.h0.a.k;
import d.a.h0.a.y0.e.b;
/* loaded from: classes2.dex */
public abstract class b implements d {
    public static final boolean j = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.p.d.a f45293a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.r1.n.a f45294b = new d.a.h0.a.r1.n.a();

    /* renamed from: c  reason: collision with root package name */
    public String f45295c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f45296d;

    /* renamed from: e  reason: collision with root package name */
    public e f45297e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f45298f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f45299g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45300h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45301i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45302e;

        public a(boolean z) {
            this.f45302e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity = b.this.f45296d;
            if (swanAppActivity != null) {
                int taskId = swanAppActivity.getTaskId();
                b.this.f45296d.finish();
                if (this.f45302e) {
                    b.this.f45296d.overridePendingTransition(0, d.a.h0.a.a.aiapps_slide_out_to_right_zadjustment_top);
                }
                d.a.h0.a.i2.b.m().l(taskId);
            }
        }
    }

    /* renamed from: d.a.h0.a.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0861b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.h0.a.p.d.a f45304a;

        public C0861b(b bVar) {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            if (this.f45304a == null) {
                this.f45304a = f.V().s();
            }
            this.f45304a.T();
        }
    }

    public b() {
        d.a.h0.a.e0.w.d.L();
        e eVar = new e();
        this.f45297e = eVar;
        eVar.h(this);
    }

    @Override // d.a.h0.a.z0.d
    public String A() {
        return TextUtils.isEmpty(this.f45295c) ? "" : this.f45295c;
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.a.p.d.d B(String str) {
        return d.a.h0.a.e0.w.d.L().U(str);
    }

    @Override // d.a.h0.a.z0.d
    public AbsoluteLayout C(String str) {
        d.a.h0.a.p.d.c s;
        d.a.h0.a.p.d.d B = B(str);
        if (B == null || (s = B.s()) == null) {
            return null;
        }
        return s.getCurrentWebView();
    }

    @Override // d.a.h0.a.z0.d
    public String D() {
        d.a.h0.a.e0.l.e J = J();
        return J != null ? J.W2() : "";
    }

    @Override // d.a.h0.a.z0.d
    public void E(Context context) {
        R();
        this.f45297e.c(context);
    }

    @Override // d.a.h0.a.z0.d
    @Nullable
    public d.a.h0.a.r1.e F() {
        return d.a.h0.a.r1.e.h();
    }

    @Override // d.a.h0.a.z0.d
    @CallSuper
    public void G(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        R();
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.g.v.a H() {
        return null;
    }

    @Override // d.a.h0.a.z0.d
    @NonNull
    public final d.a.h0.a.a2.f.c I() {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null) {
            return new d.a.h0.a.a2.f.b();
        }
        return O.U();
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.a.e0.l.e J() {
        d.a.h0.a.e0.l.f U = U();
        if (U == null) {
            return null;
        }
        return U.o();
    }

    @Override // d.a.h0.a.z0.d
    public void K() {
        if (l()) {
            this.f45297e.i();
        }
    }

    @Override // d.a.h0.a.z0.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        R();
        if (activity == null) {
            return null;
        }
        if (this.f45299g == null && (viewGroup = (ViewGroup) activity.findViewById(d.a.h0.a.f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f45299g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f45299g);
        }
        return this.f45299g;
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.g.k0.d M() {
        j jVar;
        d.a.h0.a.e0.l.f U = U();
        if (U == null || (jVar = (j) U.n(j.class)) == null) {
            return null;
        }
        return jVar.X2();
    }

    @Override // d.a.h0.a.z0.d
    public SwanCoreVersion N() {
        return null;
    }

    @Override // d.a.h0.a.z0.d
    public boolean O() {
        R();
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        b.a L = h2 != null ? h2.L() : null;
        return L != null && ((j && L.j0()) || d.a.h0.a.u.a.g(L) || d.a.h0.a.u.a.d(L));
    }

    @Override // d.a.h0.a.z0.d
    @CallSuper
    public void P() {
        this.f45301i = true;
        e eVar = this.f45297e;
        if (eVar != null) {
            eVar.j();
            this.f45297e = null;
        }
        g.a().e();
        d.a.h0.a.n1.a.b.b.a.b().d();
        V();
        d.a.h0.a.y0.c.b.c().a();
        d.a.h0.a.g1.o.c.a.l();
        this.f45296d = null;
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.g.k0.d Q() {
        j jVar;
        d.a.h0.a.e0.l.f U = U();
        if (U == null || (jVar = (j) U.n(j.class)) == null) {
            return null;
        }
        return jVar.V2();
    }

    public void R() {
        if (getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void S(boolean z) {
        if (this.f45296d != null) {
            k0.X(new a(z));
        }
    }

    @NonNull
    public Pair<Integer, Integer> T() {
        d.a.h0.a.e0.l.e J = J();
        if (J == null) {
            return new Pair<>(0, 0);
        }
        return J.R2();
    }

    public d.a.h0.a.e0.l.f U() {
        SwanAppActivity swanAppActivity = this.f45296d;
        if (swanAppActivity == null) {
            return null;
        }
        return swanAppActivity.getSwanAppFragmentManager();
    }

    public final void V() {
        FullScreenFloatView fullScreenFloatView = this.f45298f;
        if (fullScreenFloatView != null) {
            ViewParent parent = fullScreenFloatView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f45298f);
            }
        }
        d.a.h0.a.p.d.a aVar = this.f45293a;
        if (aVar != null) {
            aVar.D();
        }
    }

    @Override // d.a.h0.a.z0.d
    @CallSuper
    public void a() {
        R();
        String T = d.a.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        this.f45300h = true;
        this.f45297e.j();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, T);
        bundle.putInt("task_id", getActivity().getTaskId());
        d.a.h0.a.n1.c.a.e().h(new d.a.h0.a.n1.c.c(9, bundle));
        d.a.h0.a.w0.a.v().a();
    }

    @Override // d.a.h0.a.z0.d
    @CallSuper
    public void b() {
        String T = d.a.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        K();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, T);
        bundle.putInt("task_id", p0.b().a());
        d.a.h0.a.n1.c.a.e().h(new d.a.h0.a.n1.c.c(10, bundle));
        d.a.h0.a.w0.a.v().b();
        d.a.h0.a.w0.a.d().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
    }

    @Override // d.a.h0.a.z0.d
    public String c() {
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null || O.L() == null) {
            return null;
        }
        return d.a.h0.a.y0.e.b.e1(O.L(), f.V().u());
    }

    @Override // d.a.h0.a.z0.d
    public void d() {
        this.f45300h = true;
    }

    @Override // d.a.h0.a.z0.d
    @CallSuper
    public void e(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        R();
    }

    @Override // d.a.h0.a.z0.d
    public void exit() {
        S(true);
    }

    @Override // d.a.h0.a.z0.d
    @NonNull
    public d.a.h0.a.r1.n.c f(String str, SwanAppConfigData swanAppConfigData, String str2) {
        if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
            return this.f45294b.b(str2, str, swanAppConfigData.f12155d);
        }
        return g(str);
    }

    @Override // d.a.h0.a.z0.d
    @NonNull
    public d.a.h0.a.r1.n.c g(String str) {
        SwanAppConfigData u = u();
        if (u == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.a.h0.a.r1.n.c.d();
        }
        return this.f45294b.b(A(), str, u.f12155d);
    }

    @Override // d.a.h0.a.z0.d
    public SwanAppActivity getActivity() {
        return d.a.h0.a.r1.d.e().v();
    }

    @Override // d.a.h0.a.z0.d
    public String h() {
        SwanAppConfigData u = u();
        return u == null ? "" : u.e();
    }

    @Override // d.a.h0.a.z0.e.b
    public void i(int i2) {
        R();
        d.a.h0.a.i2.b.m().x(this.f45296d);
        S(false);
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.a.p.d.c j() {
        d.a.h0.a.p.d.d B = B(D());
        if (B == null) {
            return null;
        }
        return B.s();
    }

    @Override // d.a.h0.a.z0.d
    public d.a.h0.a.r1.n.c k(String str) {
        SwanAppConfigData u = u();
        if (u == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.a.h0.a.r1.n.c.d();
        }
        return this.f45294b.a(A(), str, u.f12155d);
    }

    @Override // d.a.h0.a.z0.d
    public void m(Context context) {
        this.f45297e.f(context);
    }

    @Override // d.a.h0.a.z0.d
    public void n(SwanAppActivity swanAppActivity) {
        this.f45296d = swanAppActivity;
    }

    @Override // d.a.h0.a.z0.d
    public void o(String str, d.a.h0.a.k0.b.a aVar) {
        d.a.h0.a.e0.w.d.L().B0(str, aVar);
    }

    @Override // d.a.h0.a.z0.d
    public FullScreenFloatView p(Activity activity) {
        R();
        if (activity == null) {
            return null;
        }
        if (this.f45298f == null) {
            FullScreenFloatView a2 = d.a.h0.a.q1.a.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.f45298f = a2;
            a2.setFloatButtonText(activity.getString(d.a.h0.a.h.aiapps_sconsole));
            this.f45298f.setFloatImageBackground(d.a.h0.a.e.aiapps_float_view_button_shape);
            this.f45298f.setVisibility(8);
            this.f45298f.setDragImageListener(new C0861b(this));
        }
        return this.f45298f;
    }

    @Override // d.a.h0.a.z0.d
    public void q() {
        SwanAppActivity v = d.a.h0.a.r1.d.e().v();
        if (v == null || v.isFinishing()) {
            return;
        }
        v.removeLoadingView();
    }

    @Override // d.a.h0.a.z0.d
    public void r() {
        this.f45300h = false;
    }

    @Override // d.a.h0.a.z0.d
    @DebugTrace
    public d.a.h0.a.p.d.a s() {
        R();
        if (this.f45293a == null) {
            this.f45293a = d.a.h0.a.e0.w.d.L().V().b(AppRuntime.getAppContext());
            d.a.h0.a.c0.c.k(true);
        }
        SwanAppActivity swanAppActivity = this.f45296d;
        if (swanAppActivity != null) {
            this.f45293a.E((ViewGroup) swanAppActivity.findViewById(d.a.h0.a.f.ai_apps_activity_root));
        }
        return this.f45293a;
    }

    @Override // d.a.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> t() {
        Pair<Integer, Integer> T = T();
        int intValue = ((Integer) T.first).intValue();
        int intValue2 = ((Integer) T.second).intValue();
        if (intValue == 0) {
            intValue = h0.m(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = h0.t(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @Override // d.a.h0.a.z0.d
    public SwanAppConfigData u() {
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        if (e2.z()) {
            return e2.p().D();
        }
        return null;
    }

    @Override // d.a.h0.a.z0.d
    public void v(Intent intent) {
        d.a.h0.a.e0.w.d.L().i0(intent);
    }

    @Override // d.a.h0.a.z0.d
    public void w() {
        SwanAppActivity v = d.a.h0.a.r1.d.e().v();
        if (v == null || v.isFinishing()) {
            return;
        }
        v.showLoadingView();
    }

    @Override // d.a.h0.a.z0.d
    public void x(d.a.h0.a.k0.b.a aVar) {
        d.a.h0.a.e0.w.d.L().A0(aVar);
    }

    @Override // d.a.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> y() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int l = h0.l(appContext);
        int measuredHeight = (d.a.h0.a.r1.d.e().v() == null || (window = d.a.h0.a.r1.d.e().v().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
        if (measuredHeight >= l) {
            return new Pair<>(Integer.valueOf(h0.m(appContext)), Integer.valueOf(measuredHeight));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            l += c0.b(appContext);
        }
        return new Pair<>(Integer.valueOf(h0.m(appContext)), Integer.valueOf(l));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.String] */
    @Override // d.a.h0.a.z0.d
    public void z(d.a.h0.a.k0.b.d dVar, boolean z) {
        d.a.h0.a.j1.h.a("postMessage", "handleNativeMessage start.");
        if (dVar == null) {
            return;
        }
        d.a.h0.a.k0.b.g gVar = new d.a.h0.a.k0.b.g();
        gVar.f43119b = dVar.f43111b;
        gVar.f43120c = z;
        if (j) {
            Log.d("AiBaseController", "handleNativeMessage data: " + dVar.f43111b + " ; needEncode = " + z);
        }
        o(dVar.f43110a, gVar);
        d.a.h0.a.j1.h.a("postMessage", "handleNativeMessage end.");
    }
}
