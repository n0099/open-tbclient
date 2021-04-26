package d.a.h0.g.u;

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
import d.a.h0.a.f;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import d.a.h0.g.f.i;
import d.a.h0.g.l.n;
import d.a.h0.g.q.a;
import java.io.File;
/* loaded from: classes3.dex */
public class a extends d.a.h0.a.z0.b {
    public static final boolean o = k.f43101a;
    public String k;
    public Runnable m;
    public d.a.h0.g.p.b l = new d.a.h0.g.p.b();
    public d.a.h0.g.v.a n = new d.a.h0.g.v.a();

    /* renamed from: d.a.h0.g.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0964a implements d.a.h0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.u0.b f46794a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.y0.e.b f46795b;

        /* renamed from: d.a.h0.g.u.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0965a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.u0.a f46797e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f46798f;

            public RunnableC0965a(d.a.h0.a.u0.a aVar, int i2) {
                this.f46797e = aVar;
                this.f46798f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f45301i) {
                    return;
                }
                a.c cVar = (a.c) this.f46797e;
                if (this.f46798f != 0 || cVar == null) {
                    return;
                }
                C0964a c0964a = C0964a.this;
                if (c0964a.f46794a == null) {
                    return;
                }
                if (c0964a.f46795b.i0()) {
                    if (!d.a.h0.g.f.d.m().n()) {
                        d.a.h0.a.c0.b.c(false);
                        C0964a.this.f46795b.u0(false);
                    } else {
                        a aVar = a.this;
                        aVar.p(aVar.f45296d).setVisibility(0);
                        a.this.s().G(a.this.f45298f);
                        d.a.h0.a.c0.a.b(true);
                        d.a.h0.a.c0.c.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                a.this.l.c(cVar, a.this.f45296d);
                a.this.k = cVar.f46760a;
                C0964a.this.f46794a.a(0, cVar);
                a.this.f0(cVar.f46762c);
                d.a.h0.g.f0.a.b().e(cVar.f46762c);
            }
        }

        public C0964a(d.a.h0.a.u0.b bVar, d.a.h0.a.y0.e.b bVar2) {
            this.f46794a = bVar;
            this.f46795b = bVar2;
        }

        @Override // d.a.h0.a.u0.b
        public void a(int i2, d.a.h0.a.u0.a aVar) {
            k0.W(a.this.m);
            a.this.m = new RunnableC0965a(aVar, i2);
            k0.Z(a.this.m);
        }
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public String A() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void G(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        super.G(bVar, bVar2);
        if (o) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.f0());
        }
        d.a.h0.g.q.a.c(bVar, new C0964a(bVar2, bVar));
        d.a.h0.g.m.a.m().I(bVar);
        d.a.h0.g.m.a.m().G(bVar);
        if (o) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        d.a.h0.g.m.a.m().z(null);
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public d.a.h0.g.v.a H() {
        return this.n;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.f45299g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
            SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
            this.f45299g = swanAppPropertyWindow;
            swanAppPropertyWindow.setVisibility(8);
            viewGroup.addView(this.f45299g);
        }
        return this.f45299g;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public SwanCoreVersion N() {
        return d.a.h0.g.m.a.m().s();
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void P() {
        super.P();
        d.a.h0.g.m.a.C();
        d.a.h0.p.d.g(n.n() + File.separator + "tmp");
    }

    @Override // d.a.h0.a.z0.b
    @NonNull
    public Pair<Integer, Integer> T() {
        return t();
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void a() {
        super.a();
        SwanAppActivity swanAppActivity = this.f45296d;
        if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
            b.a launchInfo = this.f45296d.getLaunchInfo();
            d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
            fVar.f45411a = h.n(1);
            fVar.f45415e = launchInfo.G();
            fVar.f45413c = launchInfo.S();
            fVar.f45412b = "show";
            fVar.d(launchInfo.n0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(h.l(launchInfo.V()));
            h.onEvent(fVar);
        }
        d.a.h0.a.b1.b.h(true);
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public void b() {
        super.b();
        d.a.h0.a.b1.b.h(false);
    }

    public final void f0(d.a.h0.g.z.a.a aVar) {
        d.a.h0.a.r1.e F = F();
        if (F != null) {
            F.p0(aVar);
        }
    }

    @Override // d.a.h0.a.z0.d
    public boolean l() {
        return this.f45300h;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public FullScreenFloatView p(Activity activity) {
        super.p(activity);
        this.f45298f.setAutoAttachEnable(false);
        return this.f45298f;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    public d.a.h0.a.p.d.a s() {
        if (this.f45293a == null) {
            this.f45293a = d.a.h0.a.e0.w.d.L().V().c(AppRuntime.getAppContext());
            i.h(true);
        }
        this.f45293a.E((ViewGroup) this.f45296d.findViewById(16908290));
        return this.f45293a;
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> t() {
        return y();
    }

    @Override // d.a.h0.a.z0.b, d.a.h0.a.z0.d
    @NonNull
    public Pair<Integer, Integer> y() {
        int i2;
        int i3;
        View decorView;
        SwanAppActivity swanAppActivity = this.f45296d;
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
        Display defaultDisplay = this.f45296d.getWindowManager().getDefaultDisplay();
        if (i3 == 0 || i2 == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i3 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        }
        if (this.f45296d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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
