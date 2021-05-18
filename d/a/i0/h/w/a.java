package d.a.i0.h.w;

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
import d.a.i0.a.f;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.n;
import d.a.i0.a.v2.q0;
import d.a.i0.h.f.h;
import d.a.i0.h.f.i;
import d.a.i0.h.s.a;
import java.io.File;
@Service
/* loaded from: classes3.dex */
public class a extends d.a.i0.a.g1.b {
    public static final boolean o = k.f43025a;
    public String k;
    public Runnable m;
    public d.a.i0.h.r.b l = new d.a.i0.h.r.b();
    public d.a.i0.h.x.a n = new d.a.i0.h.x.a();

    /* renamed from: d.a.i0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1044a implements d.a.i0.a.a1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a1.b f47536a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.f1.e.b f47537b;

        /* renamed from: d.a.i0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1045a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.a1.a f47539e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f47540f;

            public RunnableC1045a(d.a.i0.a.a1.a aVar, int i2) {
                this.f47539e = aVar;
                this.f47540f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f41723i) {
                    return;
                }
                a.c cVar = (a.c) this.f47539e;
                if (this.f47540f != 0 || cVar == null) {
                    return;
                }
                C1044a c1044a = C1044a.this;
                if (c1044a.f47536a == null) {
                    return;
                }
                if (c1044a.f47537b.l0()) {
                    if (!d.a.i0.h.f.d.m().n()) {
                        d.a.i0.a.e0.b.c(false);
                        C1044a.this.f47537b.y0(false);
                    } else {
                        a aVar = a.this;
                        aVar.n(aVar.f41718d).setVisibility(0);
                        a.this.q().I(a.this.f41720f);
                        d.a.i0.a.e0.a.b(true);
                        d.a.i0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f41718d);
                a.this.k = cVar.f47498a;
                C1044a.this.f47536a.a(0, cVar);
                a.this.f0(cVar.f47500c);
                d.a.i0.h.i0.a.b().e(cVar.f47500c);
            }
        }

        public C1044a(d.a.i0.a.a1.b bVar, d.a.i0.a.f1.e.b bVar2) {
            this.f47536a = bVar;
            this.f47537b = bVar2;
        }

        @Override // d.a.i0.a.a1.b
        public void a(int i2, d.a.i0.a.a1.a aVar) {
            q0.a0(a.this.m);
            a.this.m = new RunnableC1045a(aVar, i2);
            q0.d0(a.this.m);
        }
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public String A() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void G(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        super.G(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.i0.h.s.a.c(bVar, new C1044a(bVar2, bVar));
        d.a.i0.h.o.c.m().I(bVar);
        d.a.i0.h.o.c.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.a.i0.h.o.c.m().z(null);
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public d.a.i0.a.p.b.a.k H() {
        return this.n;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f41721g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f41721g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f41721g);
        }
        return this.f41721g;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public n M() {
        d.a.i0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.i0.h.n.a) U.n(d.a.i0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.k3();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public SwanCoreVersion N() {
        return d.a.i0.h.o.c.m().s();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void P() {
        super.P();
        d.a.i0.h.o.c.C();
        d.a.i0.h.a0.b.f46944a.a().d(new JsObject());
        d.a.i0.t.d.j(d.a.i0.a.r0.n.n() + File.separator + "tmp");
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public n Q() {
        d.a.i0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.i0.h.n.a) U.n(d.a.i0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.i3();
    }

    @Override // d.a.i0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return r();
    }

    public final void f0(d.a.i0.h.c0.a.a aVar) {
        d.a.i0.a.a2.e F = F();
        if (F != null) {
            F.u0(aVar);
        }
    }

    @Override // d.a.i0.a.g1.d
    public boolean j() {
        return this.f41722h;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        super.n(activity);
        this.f41720f.setAutoAttachEnable(false);
        return this.f41720f;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public d.a.i0.a.p.e.a q() {
        if (this.f41715a == null) {
            this.f41715a = new h(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f41715a.H((ViewGroup) this.f41718d.findViewById(16908290));
        return this.f41715a;
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        return y();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void w() {
        super.w();
        SwanAppActivity swanAppActivity = this.f41718d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f41718d.getLaunchInfo();
            d.a.i0.a.j2.p.f fVar = new d.a.i0.a.j2.p.f();
            fVar.f43011a = d.a.i0.a.j2.k.m(1);
            fVar.f43016f = launchInfo.H();
            fVar.f43013c = launchInfo.T();
            fVar.f43012b = "show";
            fVar.d(launchInfo.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.i0.a.j2.k.k(launchInfo.W()));
            d.a.i0.a.j2.k.onEvent(fVar);
        }
        d.a.i0.a.i1.b.h(true);
        d.a.i0.h.a0.b.f46944a.a().j();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    public void x() {
        super.x();
        d.a.i0.a.i1.b.h(false);
        d.a.i0.h.a0.b.f46944a.a().f();
    }

    @Override // d.a.i0.a.g1.b, d.a.i0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        int i2;
        int i3;
        View decorView;
        SwanAppActivity swanAppActivity = this.f41718d;
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
        Display defaultDisplay = this.f41718d.getWindowManager().getDefaultDisplay();
        if (i3 == 0 || i2 == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i3 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        }
        if (this.f41718d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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
