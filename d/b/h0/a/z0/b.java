package d.b.h0.a.z0;

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
import d.b.h0.a.e0.l.j;
import d.b.h0.a.i2.c0;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p0;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.b;
/* loaded from: classes2.dex */
public abstract class b implements d {
    public static final boolean j = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.p.d.a f47858a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.r1.n.a f47859b = new d.b.h0.a.r1.n.a();

    /* renamed from: c  reason: collision with root package name */
    public String f47860c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public SwanAppActivity f47861d;

    /* renamed from: e  reason: collision with root package name */
    public e f47862e;

    /* renamed from: f  reason: collision with root package name */
    public FullScreenFloatView f47863f;

    /* renamed from: g  reason: collision with root package name */
    public SwanAppPropertyWindow f47864g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47865h;
    public boolean i;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47866e;

        public a(boolean z) {
            this.f47866e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity = b.this.f47861d;
            if (swanAppActivity != null) {
                int taskId = swanAppActivity.getTaskId();
                b.this.f47861d.finish();
                if (this.f47866e) {
                    b.this.f47861d.overridePendingTransition(0, d.b.h0.a.a.aiapps_slide_out_to_right_zadjustment_top);
                }
                d.b.h0.a.i2.b.m().l(taskId);
            }
        }
    }

    /* renamed from: d.b.h0.a.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0922b implements FullScreenFloatView.c {

        /* renamed from: a  reason: collision with root package name */
        public d.b.h0.a.p.d.a f47868a;

        public C0922b(b bVar) {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            if (this.f47868a == null) {
                this.f47868a = f.V().F();
            }
            this.f47868a.K();
        }
    }

    public b() {
        d.b.h0.a.e0.w.d.L();
        e eVar = new e();
        this.f47862e = eVar;
        eVar.h(this);
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.a.e0.l.e A() {
        d.b.h0.a.e0.l.f U = U();
        if (U == null) {
            return null;
        }
        return U.o();
    }

    @Override // d.b.h0.a.z0.d
    public FullScreenFloatView B(Activity activity) {
        R();
        if (activity == null) {
            return null;
        }
        if (this.f47863f == null) {
            FullScreenFloatView a2 = d.b.h0.a.q1.a.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.f47863f = a2;
            a2.setFloatButtonText(activity.getString(d.b.h0.a.h.aiapps_sconsole));
            this.f47863f.setFloatImageBackground(d.b.h0.a.e.aiapps_float_view_button_shape);
            this.f47863f.setVisibility(8);
            this.f47863f.setDragImageListener(new C0922b(this));
        }
        return this.f47863f;
    }

    @Override // d.b.h0.a.z0.d
    public void C() {
        SwanAppActivity n = d.b.h0.a.r1.d.e().n();
        if (n == null || n.isFinishing()) {
            return;
        }
        n.removeLoadingView();
    }

    @Override // d.b.h0.a.z0.d
    public void D() {
        this.f47865h = false;
    }

    @Override // d.b.h0.a.z0.d
    public void E() {
        if (s()) {
            this.f47862e.i();
        }
    }

    @Override // d.b.h0.a.z0.d
    @DebugTrace
    public d.b.h0.a.p.d.a F() {
        R();
        if (this.f47858a == null) {
            this.f47858a = d.b.h0.a.e0.w.d.L().V().c(AppRuntime.getAppContext());
            d.b.h0.a.c0.c.k(true);
        }
        SwanAppActivity swanAppActivity = this.f47861d;
        if (swanAppActivity != null) {
            this.f47858a.o((ViewGroup) swanAppActivity.findViewById(d.b.h0.a.f.ai_apps_activity_root));
        }
        return this.f47858a;
    }

    @Override // d.b.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> G() {
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

    @Override // d.b.h0.a.z0.d
    public SwanAppPropertyWindow H(Activity activity) {
        ViewGroup viewGroup;
        R();
        if (activity == null) {
            return null;
        }
        if (this.f47864g == null && (viewGroup = (ViewGroup) activity.findViewById(d.b.h0.a.f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f47864g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f47864g);
        }
        return this.f47864g;
    }

    @Override // d.b.h0.a.z0.d
    public SwanAppConfigData I() {
        d.b.h0.a.r1.d e2 = d.b.h0.a.r1.d.e();
        if (e2.x()) {
            return e2.s().D();
        }
        return null;
    }

    @Override // d.b.h0.a.z0.d
    public void J(Intent intent) {
        d.b.h0.a.e0.w.d.L().i0(intent);
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.g.k0.d K() {
        j jVar;
        d.b.h0.a.e0.l.f U = U();
        if (U == null || (jVar = (j) U.n(j.class)) == null) {
            return null;
        }
        return jVar.Y2();
    }

    @Override // d.b.h0.a.z0.d
    public SwanCoreVersion L() {
        return null;
    }

    @Override // d.b.h0.a.z0.d
    public void M() {
        SwanAppActivity n = d.b.h0.a.r1.d.e().n();
        if (n == null || n.isFinishing()) {
            return;
        }
        n.showLoadingView();
    }

    @Override // d.b.h0.a.z0.d
    public void N(d.b.h0.a.k0.b.a aVar) {
        d.b.h0.a.e0.w.d.L().A0(aVar);
    }

    @Override // d.b.h0.a.z0.d
    public boolean O() {
        R();
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        b.a L = y != null ? y.L() : null;
        return L != null && ((j && L.j0()) || d.b.h0.a.u.a.g(L) || d.b.h0.a.u.a.d(L));
    }

    @Override // d.b.h0.a.z0.d
    @CallSuper
    public void P() {
        this.i = true;
        e eVar = this.f47862e;
        if (eVar != null) {
            eVar.j();
            this.f47862e = null;
        }
        g.a().e();
        d.b.h0.a.n1.a.b.b.a.b().d();
        V();
        d.b.h0.a.y0.c.b.c().a();
        d.b.h0.a.g1.o.c.a.l();
        this.f47861d = null;
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.g.k0.d Q() {
        j jVar;
        d.b.h0.a.e0.l.f U = U();
        if (U == null || (jVar = (j) U.n(j.class)) == null) {
            return null;
        }
        return jVar.W2();
    }

    public void R() {
        if (getActivity() == null && j) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    public final void S(boolean z) {
        if (this.f47861d != null) {
            k0.X(new a(z));
        }
    }

    @NonNull
    public Pair<Integer, Integer> T() {
        d.b.h0.a.e0.l.e A = A();
        if (A == null) {
            return new Pair<>(0, 0);
        }
        return A.S2();
    }

    public d.b.h0.a.e0.l.f U() {
        SwanAppActivity swanAppActivity = this.f47861d;
        if (swanAppActivity == null) {
            return null;
        }
        return swanAppActivity.getSwanAppFragmentManager();
    }

    public final void V() {
        FullScreenFloatView fullScreenFloatView = this.f47863f;
        if (fullScreenFloatView != null) {
            ViewParent parent = fullScreenFloatView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f47863f);
            }
        }
        d.b.h0.a.p.d.a aVar = this.f47858a;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // d.b.h0.a.z0.d
    @CallSuper
    public void a() {
        R();
        String T = d.b.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        this.f47865h = true;
        this.f47862e.j();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, T);
        bundle.putInt("task_id", getActivity().getTaskId());
        d.b.h0.a.n1.c.a.e().h(new d.b.h0.a.n1.c.c(9, bundle));
        d.b.h0.a.w0.a.v().a();
    }

    @Override // d.b.h0.a.z0.d
    @CallSuper
    public void b() {
        String T = d.b.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            return;
        }
        E();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.APP_ID, T);
        bundle.putInt("task_id", p0.b().a());
        d.b.h0.a.n1.c.a.e().h(new d.b.h0.a.n1.c.c(10, bundle));
        d.b.h0.a.w0.a.v().b();
        d.b.h0.a.w0.a.d().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
    }

    @Override // d.b.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> c() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int l = h0.l(appContext);
        int measuredHeight = (d.b.h0.a.r1.d.e().n() == null || (window = d.b.h0.a.r1.d.e().n().getWindow()) == null || (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) == null || !viewGroup.isLaidOut()) ? 0 : viewGroup.getMeasuredHeight();
        if (measuredHeight >= l) {
            return new Pair<>(Integer.valueOf(h0.m(appContext)), Integer.valueOf(measuredHeight));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            l += c0.b(appContext);
        }
        return new Pair<>(Integer.valueOf(h0.m(appContext)), Integer.valueOf(l));
    }

    @Override // d.b.h0.a.z0.d
    public String d() {
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null || O.L() == null) {
            return null;
        }
        return d.b.h0.a.y0.e.b.e1(O.L(), f.V().I());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.String] */
    @Override // d.b.h0.a.z0.d
    public void e(d.b.h0.a.k0.b.d dVar, boolean z) {
        d.b.h0.a.j1.h.a("postMessage", "handleNativeMessage start.");
        if (dVar == null) {
            return;
        }
        d.b.h0.a.k0.b.g gVar = new d.b.h0.a.k0.b.g();
        gVar.f45790b = dVar.f45782b;
        gVar.f45791c = z;
        if (j) {
            Log.d("AiBaseController", "handleNativeMessage data: " + dVar.f45782b + " ; needEncode = " + z);
        }
        z(dVar.f45781a, gVar);
        d.b.h0.a.j1.h.a("postMessage", "handleNativeMessage end.");
    }

    @Override // d.b.h0.a.z0.d
    public void exit() {
        S(true);
    }

    @Override // d.b.h0.a.z0.d
    public void f() {
        this.f47865h = true;
    }

    @Override // d.b.h0.a.z0.d
    @CallSuper
    public void g(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        R();
    }

    @Override // d.b.h0.a.z0.d
    public SwanAppActivity getActivity() {
        return d.b.h0.a.r1.d.e().n();
    }

    @Override // d.b.h0.a.z0.d
    public String h() {
        return TextUtils.isEmpty(this.f47860c) ? "" : this.f47860c;
    }

    @Override // d.b.h0.a.z0.d
    @NonNull
    public d.b.h0.a.r1.n.c i(String str, SwanAppConfigData swanAppConfigData, String str2) {
        if (swanAppConfigData != null && !TextUtils.isEmpty(str2)) {
            return this.f47859b.b(str2, str, swanAppConfigData.f12285d);
        }
        return k(str);
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.a.p.d.d j(String str) {
        return d.b.h0.a.e0.w.d.L().U(str);
    }

    @Override // d.b.h0.a.z0.d
    @NonNull
    public d.b.h0.a.r1.n.c k(String str) {
        SwanAppConfigData I = I();
        if (I == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.b.h0.a.r1.n.c.d();
        }
        return this.f47859b.b(h(), str, I.f12285d);
    }

    @Override // d.b.h0.a.z0.d
    public String l() {
        SwanAppConfigData I = I();
        return I == null ? "" : I.e();
    }

    @Override // d.b.h0.a.z0.d
    public AbsoluteLayout m(String str) {
        d.b.h0.a.p.d.c F;
        d.b.h0.a.p.d.d j2 = j(str);
        if (j2 == null || (F = j2.F()) == null) {
            return null;
        }
        return F.getCurrentWebView();
    }

    @Override // d.b.h0.a.z0.e.b
    public void n(int i) {
        R();
        d.b.h0.a.i2.b.m().x(this.f47861d);
        S(false);
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.a.p.d.c o() {
        d.b.h0.a.p.d.d j2 = j(p());
        if (j2 == null) {
            return null;
        }
        return j2.F();
    }

    @Override // d.b.h0.a.z0.d
    public String p() {
        d.b.h0.a.e0.l.e A = A();
        return A != null ? A.X2() : "";
    }

    @Override // d.b.h0.a.z0.d
    public void q(Context context) {
        R();
        this.f47862e.c(context);
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.a.r1.n.c r(String str) {
        SwanAppConfigData I = I();
        if (I == null) {
            if (j) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return d.b.h0.a.r1.n.c.d();
        }
        return this.f47859b.a(h(), str, I.f12285d);
    }

    @Override // d.b.h0.a.z0.d
    @Nullable
    public d.b.h0.a.r1.e t() {
        return d.b.h0.a.r1.e.y();
    }

    @Override // d.b.h0.a.z0.d
    @CallSuper
    public void u(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        R();
    }

    @Override // d.b.h0.a.z0.d
    public d.b.h0.g.v.a v() {
        return null;
    }

    @Override // d.b.h0.a.z0.d
    public void w(Context context) {
        this.f47862e.f(context);
    }

    @Override // d.b.h0.a.z0.d
    public void x(SwanAppActivity swanAppActivity) {
        this.f47861d = swanAppActivity;
    }

    @Override // d.b.h0.a.z0.d
    @NonNull
    public final d.b.h0.a.a2.f.c y() {
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null) {
            return new d.b.h0.a.a2.f.b();
        }
        return O.U();
    }

    @Override // d.b.h0.a.z0.d
    public void z(String str, d.b.h0.a.k0.b.a aVar) {
        d.b.h0.a.e0.w.d.L().B0(str, aVar);
    }
}
