package d.b.h0.g.u;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.f;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
import d.b.h0.g.f.i;
import d.b.h0.g.l.n;
import d.b.h0.g.q.a;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends d.b.h0.a.z0.b {
    public static final boolean o = k.f45772a;
    public String k;
    public Runnable m;
    public d.b.h0.g.p.b l = new d.b.h0.g.p.b();
    public d.b.h0.g.v.a n = new d.b.h0.g.v.a();

    /* renamed from: d.b.h0.g.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1025a implements d.b.h0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.u0.b f49299a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.y0.e.b f49300b;

        /* renamed from: d.b.h0.g.u.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1026a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.u0.a f49302e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f49303f;

            public RunnableC1026a(d.b.h0.a.u0.a aVar, int i) {
                this.f49302e = aVar;
                this.f49303f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.i) {
                    return;
                }
                a.c cVar = (a.c) this.f49302e;
                if (this.f49303f != 0 || cVar == null) {
                    return;
                }
                C1025a c1025a = C1025a.this;
                if (c1025a.f49299a == null) {
                    return;
                }
                if (c1025a.f49300b.i0()) {
                    if (!d.b.h0.g.f.d.m().n()) {
                        d.b.h0.a.c0.b.c(false);
                        C1025a.this.f49300b.u0(false);
                    } else {
                        a aVar = a.this;
                        aVar.B(aVar.f47861d).setVisibility(0);
                        a.this.F().p(a.this.f47863f);
                        d.b.h0.a.c0.a.b(true);
                        d.b.h0.a.c0.c.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f47861d);
                a.this.k = cVar.f49266a;
                C1025a.this.f49299a.a(0, cVar);
                a.this.f0(cVar.f49268c);
                d.b.h0.g.f0.a.b().e(cVar.f49268c);
            }
        }

        public C1025a(d.b.h0.a.u0.b bVar, d.b.h0.a.y0.e.b bVar2) {
            this.f49299a = bVar;
            this.f49300b = bVar2;
        }

        @Override // d.b.h0.a.u0.b
        public void a(int i, d.b.h0.a.u0.a aVar) {
            k0.W(a.this.m);
            a.this.m = new RunnableC1026a(aVar, i);
            k0.Z(a.this.m);
        }
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public FullScreenFloatView B(Activity activity) {
        super.B(activity);
        this.f47863f.setAutoAttachEnable(false);
        return this.f47863f;
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public d.b.h0.a.p.d.a F() {
        if (this.f47858a == null) {
            this.f47858a = d.b.h0.a.e0.w.d.L().V().d(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f47858a.o((ViewGroup) this.f47861d.findViewById(16908290));
        return this.f47858a;
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> G() {
        return c();
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public SwanAppPropertyWindow H(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f47864g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f47864g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f47864g);
        }
        return this.f47864g;
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public SwanCoreVersion L() {
        return d.b.h0.g.m.a.m().s();
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void P() {
        super.P();
        d.b.h0.g.m.a.C();
        d.b.h0.p.d.g(n.n() + File.separator + "tmp");
    }

    @Override // d.b.h0.a.z0.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return G();
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void a() {
        super.a();
        SwanAppActivity swanAppActivity = this.f47861d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f47861d.getLaunchInfo();
            d.b.h0.a.z1.k.f fVar = new d.b.h0.a.z1.k.f();
            fVar.f47972a = h.n(1);
            fVar.f47976e = launchInfo.G();
            fVar.f47974c = launchInfo.S();
            fVar.f47973b = "show";
            fVar.d(launchInfo.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(h.l(launchInfo.V()));
            h.onEvent(fVar);
        }
        d.b.h0.a.b1.b.h(true);
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void b() {
        super.b();
        d.b.h0.a.b1.b.h(false);
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> c() {
        int i;
        int i2;
        View decorView;
        SwanAppActivity swanAppActivity = this.f47861d;
        if (swanAppActivity == null) {
            return super.c();
        }
        Window window = swanAppActivity.getWindow();
        boolean z = false;
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.f47861d.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.f47861d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        if (o) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void f0(d.b.h0.g.z.a.a aVar) {
        d.b.h0.a.r1.e t = t();
        if (t != null) {
            t.p0(aVar);
        }
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public String h() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.b.h0.a.z0.d
    public boolean s() {
        return this.f47865h;
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public void u(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        super.u(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.b.h0.g.q.a.c(bVar, new C1025a(bVar2, bVar));
        d.b.h0.g.m.a.m().I(bVar);
        d.b.h0.g.m.a.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.b.h0.g.m.a.m().z(null);
    }

    @Override // d.b.h0.a.z0.b, d.b.h0.a.z0.d
    public d.b.h0.g.v.a v() {
        return this.n;
    }
}
