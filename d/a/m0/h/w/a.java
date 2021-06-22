package d.a.m0.h.w;

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
import d.a.m0.a.f;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.p.b.a.n;
import d.a.m0.a.v2.q0;
import d.a.m0.h.f.h;
import d.a.m0.h.f.i;
import d.a.m0.h.s.a;
import java.io.File;
@Service
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.g1.b {
    public static final boolean o = k.f46983a;
    public String k;
    public Runnable m;
    public d.a.m0.h.r.b l = new d.a.m0.h.r.b();
    public d.a.m0.h.x.a n = new d.a.m0.h.x.a();

    /* renamed from: d.a.m0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1114a implements d.a.m0.a.a1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a1.b f51494a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.f1.e.b f51495b;

        /* renamed from: d.a.m0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1115a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.a1.a f51497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f51498f;

            public RunnableC1115a(d.a.m0.a.a1.a aVar, int i2) {
                this.f51497e = aVar;
                this.f51498f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f45681i) {
                    return;
                }
                a.c cVar = (a.c) this.f51497e;
                if (this.f51498f != 0 || cVar == null) {
                    return;
                }
                C1114a c1114a = C1114a.this;
                if (c1114a.f51494a == null) {
                    return;
                }
                if (c1114a.f51495b.l0()) {
                    if (!d.a.m0.h.f.d.m().n()) {
                        d.a.m0.a.e0.b.c(false);
                        C1114a.this.f51495b.y0(false);
                    } else {
                        a aVar = a.this;
                        aVar.n(aVar.f45676d).setVisibility(0);
                        a.this.q().I(a.this.f45678f);
                        d.a.m0.a.e0.a.b(true);
                        d.a.m0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f45676d);
                a.this.k = cVar.f51456a;
                C1114a.this.f51494a.a(0, cVar);
                a.this.f0(cVar.f51458c);
                d.a.m0.h.i0.a.b().e(cVar.f51458c);
            }
        }

        public C1114a(d.a.m0.a.a1.b bVar, d.a.m0.a.f1.e.b bVar2) {
            this.f51494a = bVar;
            this.f51495b = bVar2;
        }

        @Override // d.a.m0.a.a1.b
        public void a(int i2, d.a.m0.a.a1.a aVar) {
            q0.a0(a.this.m);
            a.this.m = new RunnableC1115a(aVar, i2);
            q0.d0(a.this.m);
        }
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public String A() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void G(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        super.G(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.i0());
        }
        d.a.m0.h.s.a.c(bVar, new C1114a(bVar2, bVar));
        d.a.m0.h.o.c.m().I(bVar);
        d.a.m0.h.o.c.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.a.m0.h.o.c.m().z(null);
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public d.a.m0.a.p.b.a.k H() {
        return this.n;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f45679g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f45679g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f45679g);
        }
        return this.f45679g;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public n M() {
        d.a.m0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.m0.h.n.a) U.n(d.a.m0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.k3();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public SwanCoreVersion N() {
        return d.a.m0.h.o.c.m().s();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void P() {
        super.P();
        d.a.m0.h.o.c.C();
        d.a.m0.h.a0.b.f50902a.a().d(new JsObject());
        d.a.m0.t.d.j(d.a.m0.a.r0.n.n() + File.separator + "tmp");
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public n Q() {
        d.a.m0.h.n.a aVar;
        g U = U();
        if (U == null || (aVar = (d.a.m0.h.n.a) U.n(d.a.m0.h.n.a.class)) == null) {
            return null;
        }
        return aVar.i3();
    }

    @Override // d.a.m0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return r();
    }

    public final void f0(d.a.m0.h.c0.a.a aVar) {
        d.a.m0.a.a2.e F = F();
        if (F != null) {
            F.u0(aVar);
        }
    }

    @Override // d.a.m0.a.g1.d
    public boolean j() {
        return this.f45680h;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        super.n(activity);
        this.f45678f.setAutoAttachEnable(false);
        return this.f45678f;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public d.a.m0.a.p.e.a q() {
        if (this.f45673a == null) {
            this.f45673a = new h(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f45673a.H((ViewGroup) this.f45676d.findViewById(16908290));
        return this.f45673a;
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        return y();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void w() {
        super.w();
        SwanAppActivity swanAppActivity = this.f45676d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f45676d.getLaunchInfo();
            d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
            fVar.f46969a = d.a.m0.a.j2.k.m(1);
            fVar.f46974f = launchInfo.H();
            fVar.f46971c = launchInfo.T();
            fVar.f46970b = "show";
            fVar.d(launchInfo.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.m0.a.j2.k.k(launchInfo.W()));
            d.a.m0.a.j2.k.onEvent(fVar);
        }
        d.a.m0.a.i1.b.h(true);
        d.a.m0.h.a0.b.f50902a.a().j();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    public void x() {
        super.x();
        d.a.m0.a.i1.b.h(false);
        d.a.m0.h.a0.b.f50902a.a().f();
    }

    @Override // d.a.m0.a.g1.b, d.a.m0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        int i2;
        int i3;
        View decorView;
        SwanAppActivity swanAppActivity = this.f45676d;
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
        Display defaultDisplay = this.f45676d.getWindowManager().getDefaultDisplay();
        if (i3 == 0 || i2 == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i3 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        }
        if (this.f45676d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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
