package d.b.g0.g.u;

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
import d.b.g0.a.f;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import d.b.g0.g.f.i;
import d.b.g0.g.l.n;
import d.b.g0.g.q.a;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.z0.b {
    public static final boolean o = k.f45050a;
    public String k;
    public Runnable m;
    public d.b.g0.g.p.b l = new d.b.g0.g.p.b();
    public d.b.g0.g.v.a n = new d.b.g0.g.v.a();

    /* renamed from: d.b.g0.g.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0992a implements d.b.g0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.u0.b f48577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.y0.e.b f48578b;

        /* renamed from: d.b.g0.g.u.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0993a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.u0.a f48580e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f48581f;

            public RunnableC0993a(d.b.g0.a.u0.a aVar, int i) {
                this.f48580e = aVar;
                this.f48581f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.i) {
                    return;
                }
                a.c cVar = (a.c) this.f48580e;
                if (this.f48581f != 0 || cVar == null) {
                    return;
                }
                C0992a c0992a = C0992a.this;
                if (c0992a.f48577a == null) {
                    return;
                }
                if (c0992a.f48578b.i0()) {
                    if (!d.b.g0.g.f.d.m().n()) {
                        d.b.g0.a.c0.b.c(false);
                        C0992a.this.f48578b.u0(false);
                    } else {
                        a aVar = a.this;
                        aVar.B(aVar.f47139d).setVisibility(0);
                        a.this.F().p(a.this.f47141f);
                        d.b.g0.a.c0.a.b(true);
                        d.b.g0.a.c0.c.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f47139d);
                a.this.k = cVar.f48544a;
                C0992a.this.f48577a.a(0, cVar);
                a.this.f0(cVar.f48546c);
                d.b.g0.g.f0.a.b().e(cVar.f48546c);
            }
        }

        public C0992a(d.b.g0.a.u0.b bVar, d.b.g0.a.y0.e.b bVar2) {
            this.f48577a = bVar;
            this.f48578b = bVar2;
        }

        @Override // d.b.g0.a.u0.b
        public void a(int i, d.b.g0.a.u0.a aVar) {
            k0.W(a.this.m);
            a.this.m = new RunnableC0993a(aVar, i);
            k0.Z(a.this.m);
        }
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public FullScreenFloatView B(Activity activity) {
        super.B(activity);
        this.f47141f.setAutoAttachEnable(false);
        return this.f47141f;
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public d.b.g0.a.p.d.a F() {
        if (this.f47136a == null) {
            this.f47136a = d.b.g0.a.e0.w.d.L().V().d(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f47136a.o((ViewGroup) this.f47139d.findViewById(16908290));
        return this.f47136a;
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> G() {
        return c();
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public SwanAppPropertyWindow H(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f47142g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f47142g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f47142g);
        }
        return this.f47142g;
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public SwanCoreVersion L() {
        return d.b.g0.g.m.a.m().s();
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public void P() {
        super.P();
        d.b.g0.g.m.a.C();
        d.b.g0.p.d.g(n.n() + File.separator + "tmp");
    }

    @Override // d.b.g0.a.z0.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return G();
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public void a() {
        super.a();
        SwanAppActivity swanAppActivity = this.f47139d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f47139d.getLaunchInfo();
            d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
            fVar.f47250a = h.n(1);
            fVar.f47254e = launchInfo.G();
            fVar.f47252c = launchInfo.S();
            fVar.f47251b = "show";
            fVar.d(launchInfo.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(h.l(launchInfo.V()));
            h.onEvent(fVar);
        }
        d.b.g0.a.b1.b.h(true);
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public void b() {
        super.b();
        d.b.g0.a.b1.b.h(false);
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> c() {
        int i;
        int i2;
        View decorView;
        SwanAppActivity swanAppActivity = this.f47139d;
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
        Display defaultDisplay = this.f47139d.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.f47139d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        if (o) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void f0(d.b.g0.g.z.a.a aVar) {
        d.b.g0.a.r1.e t = t();
        if (t != null) {
            t.p0(aVar);
        }
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public String h() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.b.g0.a.z0.d
    public boolean s() {
        return this.f47143h;
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public void u(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
        super.u(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.b.g0.g.q.a.c(bVar, new C0992a(bVar2, bVar));
        d.b.g0.g.m.a.m().I(bVar);
        d.b.g0.g.m.a.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.b.g0.g.m.a.m().z(null);
    }

    @Override // d.b.g0.a.z0.b, d.b.g0.a.z0.d
    public d.b.g0.g.v.a v() {
        return this.n;
    }
}
