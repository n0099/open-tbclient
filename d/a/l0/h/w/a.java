package d.a.l0.h.w;

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
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.f;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.k;
import d.a.l0.a.p.b.a.n;
import d.a.l0.a.v2.q0;
import d.a.l0.h.f.h;
import d.a.l0.h.f.i;
import d.a.l0.h.s.a;
import java.io.File;
@Service
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.g1.b {
    public static final boolean o = k.f43199a;
    public String k;
    public Runnable m;
    public d.a.l0.h.r.b l = new d.a.l0.h.r.b();
    public d.a.l0.h.x.a n = new d.a.l0.h.x.a();

    /* renamed from: d.a.l0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1055a implements d.a.l0.a.a1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a1.b f47712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.f1.e.b f47713b;

        /* renamed from: d.a.l0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1056a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.a1.a f47715e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f47716f;

            public RunnableC1056a(d.a.l0.a.a1.a aVar, int i2) {
                this.f47715e = aVar;
                this.f47716f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f41897i) {
                    return;
                }
                a.c cVar = (a.c) this.f47715e;
                if (this.f47716f != 0 || cVar == null) {
                    return;
                }
                C1055a c1055a = C1055a.this;
                if (c1055a.f47712a == null) {
                    return;
                }
                if (c1055a.f47713b.l0()) {
                    if (!d.a.l0.h.f.d.m().n()) {
                        d.a.l0.a.e0.b.c(false);
                        C1055a.this.f47713b.y0(false);
                    } else {
                        a aVar = a.this;
                        aVar.n(aVar.f41892d).setVisibility(0);
                        a.this.q().I(a.this.f41894f);
                        d.a.l0.a.e0.a.b(true);
                        d.a.l0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f41892d);
                a.this.k = cVar.f47674a;
                C1055a.this.f47712a.a(0, cVar);
                a.this.f0(cVar.f47676c);
                d.a.l0.h.i0.a.b().e(cVar.f47676c);
            }
        }

        public C1055a(d.a.l0.a.a1.b bVar, d.a.l0.a.f1.e.b bVar2) {
            this.f47712a = bVar;
            this.f47713b = bVar2;
        }

        @Override // d.a.l0.a.a1.b
        public void a(int i2, d.a.l0.a.a1.a aVar) {
            q0.a0(a.this.m);
            a.this.m = new RunnableC1056a(aVar, i2);
            q0.d0(a.this.m);
        }
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public String A() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public void G(d.a.l0.a.f1.e.b bVar, d.a.l0.a.a1.b bVar2) {
        super.G(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.l0.h.s.a.c(bVar, new C1055a(bVar2, bVar));
        d.a.l0.h.o.c.m().I(bVar);
        d.a.l0.h.o.c.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.a.l0.h.o.c.m().z(null);
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public d.a.l0.a.p.b.a.k H() {
        return this.n;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f41895g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f41895g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f41895g);
        }
        return this.f41895g;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public n M() {
        d.a.l0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.l0.h.n.a) U.n(d.a.l0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.k3();
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public SwanCoreVersion N() {
        return d.a.l0.h.o.c.m().s();
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public void P() {
        super.P();
        d.a.l0.h.o.c.C();
        d.a.l0.h.a0.b.f47120a.a().d(new JsObject());
        d.a.l0.t.d.j(d.a.l0.a.r0.n.n() + File.separator + "tmp");
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public n Q() {
        d.a.l0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.l0.h.n.a) U.n(d.a.l0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.i3();
    }

    @Override // d.a.l0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return r();
    }

    public final void f0(d.a.l0.h.c0.a.a aVar) {
        d.a.l0.a.a2.e F = F();
        if (F != null) {
            F.u0(aVar);
        }
    }

    @Override // d.a.l0.a.g1.d
    public boolean j() {
        return this.f41896h;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        super.n(activity);
        this.f41894f.setAutoAttachEnable(false);
        return this.f41894f;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public d.a.l0.a.p.e.a q() {
        if (this.f41889a == null) {
            this.f41889a = new h(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f41889a.H((ViewGroup) this.f41892d.findViewById(16908290));
        return this.f41889a;
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        return y();
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public void w() {
        super.w();
        SwanAppActivity swanAppActivity = this.f41892d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f41892d.getLaunchInfo();
            d.a.l0.a.j2.p.f fVar = new d.a.l0.a.j2.p.f();
            fVar.f43185a = d.a.l0.a.j2.k.m(1);
            fVar.f43190f = launchInfo.H();
            fVar.f43187c = launchInfo.T();
            fVar.f43186b = "show";
            fVar.d(launchInfo.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.l0.a.j2.k.k(launchInfo.W()));
            d.a.l0.a.j2.k.onEvent(fVar);
        }
        d.a.l0.a.i1.b.h(true);
        d.a.l0.h.a0.b.f47120a.a().j();
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    public void x() {
        super.x();
        d.a.l0.a.i1.b.h(false);
        d.a.l0.h.a0.b.f47120a.a().f();
    }

    @Override // d.a.l0.a.g1.b, d.a.l0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        int i2;
        int i3;
        View decorView;
        SwanAppActivity swanAppActivity = this.f41892d;
        if (swanAppActivity == null) {
            return super.y();
        }
        Window window = swanAppActivity.getWindow();
        boolean z = false;
        if (window == null || (decorView = window.getDecorView()) == null) {
            i2 = 0;
            i3 = 0;
        } else {
            i3 = decorView.getWidth();
            i2 = decorView.getHeight();
        }
        Display defaultDisplay = this.f41892d.getWindowManager().getDefaultDisplay();
        if (i3 == 0 || i2 == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i3 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        }
        if (this.f41892d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        if (o) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i2 + ",height:" + i3);
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
