package d.a.h0.a.z0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.z0.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class f implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45326b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f45327c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f45328d;

    /* renamed from: a  reason: collision with root package name */
    public d f45329a = new b(this, null);

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.h0.a.z0.b {
        public b(f fVar) {
        }

        @Override // d.a.h0.a.z0.b
        public void R() {
            super.R();
        }

        @Override // d.a.h0.a.z0.d
        public boolean l() {
            return this.f45300h;
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public static f V() {
        if (f45328d == null) {
            synchronized (f.class) {
                if (f45328d == null) {
                    f45328d = new f();
                }
            }
        }
        return f45328d;
    }

    public static synchronized void d0() {
        synchronized (f.class) {
            if (f45328d == null) {
                return;
            }
            if (f45328d.f45329a != null) {
                f45328d.f45329a.P();
            }
            f45328d = null;
        }
    }

    public String A() {
        return this.f45329a.A();
    }

    public d.a.h0.a.p.d.d B(String str) {
        return this.f45329a.B(str);
    }

    public AbsoluteLayout C(String str) {
        return this.f45329a.C(str);
    }

    public String D() {
        return this.f45329a.D();
    }

    public void E(Context context) {
        this.f45329a.E(context);
    }

    @Nullable
    public d.a.h0.a.r1.e F() {
        return this.f45329a.F();
    }

    public void G(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        this.f45329a.G(bVar, bVar2);
    }

    public d.a.h0.g.v.a H() {
        return this.f45329a.H();
    }

    public d.a.h0.a.a2.f.c I() {
        return this.f45329a.I();
    }

    public d.a.h0.a.e0.l.e J() {
        return this.f45329a.J();
    }

    public SwanAppPropertyWindow L(Activity activity) {
        return this.f45329a.L(activity);
    }

    public SwanCoreVersion N() {
        return this.f45329a.N();
    }

    public boolean O() {
        return this.f45329a.O();
    }

    public void R(int i2) {
        if (a0()) {
            return;
        }
        if (i2 == 0) {
            this.f45329a = new c();
        } else if (i2 != 1) {
        } else {
            this.f45329a = new d.a.h0.g.u.a();
        }
    }

    public void S() {
        long decrementAndGet = f45327c.decrementAndGet();
        if (decrementAndGet <= 0) {
            f45328d.f45329a.K();
        }
        if (f45326b) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    public long T() {
        return f45327c.get();
    }

    public String U() {
        return k0.n().d();
    }

    @Nullable
    public d.a.h0.a.e0.l.f W() {
        SwanAppActivity v;
        d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
        if (O == null || (v = O.v()) == null) {
            return null;
        }
        return v.getSwanAppFragmentManager();
    }

    public d.a.h0.g.k0.d X() {
        return this.f45329a.Q();
    }

    public d.a.h0.g.k0.d Y() {
        return this.f45329a.M();
    }

    public boolean Z() {
        return a0() && this.f45329a.getActivity() != null;
    }

    public void a() {
        this.f45329a.a();
    }

    public boolean a0() {
        d dVar = this.f45329a;
        return (dVar == null || (dVar instanceof b)) ? false : true;
    }

    public void b() {
        this.f45329a.b();
    }

    public void b0() {
        long incrementAndGet = f45327c.incrementAndGet();
        if (f45326b) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public String c() {
        return this.f45329a.c();
    }

    public void c0() {
        if (f45326b) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        d.a.h0.a.w0.a.F().a();
        if (f45326b) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.g();
        p.j(new a(this), "computation");
        d.a.h0.a.t.c.n.e.d(AppRuntime.getAppContext());
        if (f45326b) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void d() {
        this.f45329a.d();
    }

    public void e(d.a.h0.a.y0.e.b bVar, d.a.h0.a.u0.b bVar2) {
        this.f45329a.e(bVar, bVar2);
    }

    public void exit() {
        this.f45329a.exit();
    }

    @NonNull
    public d.a.h0.a.r1.n.c f(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.f45329a.f(str, swanAppConfigData, str2);
    }

    @NonNull
    public d.a.h0.a.r1.n.c g(String str) {
        return this.f45329a.g(str);
    }

    public SwanAppActivity getActivity() {
        return this.f45329a.getActivity();
    }

    public String h() {
        return this.f45329a.h();
    }

    @Override // d.a.h0.a.z0.e.b
    public void i(int i2) {
        this.f45329a.i(i2);
    }

    public d.a.h0.a.p.d.c j() {
        return this.f45329a.j();
    }

    public d.a.h0.a.r1.n.c k(String str) {
        return this.f45329a.k(str);
    }

    public void m(Context context) {
        this.f45329a.m(context);
    }

    public void n(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !a0()) {
            R(swanAppActivity.getFrameType());
        }
        if (a0()) {
            this.f45329a.n(swanAppActivity);
        }
    }

    public void o(String str, d.a.h0.a.k0.b.a aVar) {
        this.f45329a.o(str, aVar);
    }

    public FullScreenFloatView p(Activity activity) {
        return this.f45329a.p(activity);
    }

    public void q() {
        this.f45329a.q();
    }

    public void r() {
        this.f45329a.r();
    }

    @DebugTrace
    public d.a.h0.a.p.d.a s() {
        return this.f45329a.s();
    }

    @NonNull
    public Pair<Integer, Integer> t() {
        return this.f45329a.t();
    }

    public SwanAppConfigData u() {
        return this.f45329a.u();
    }

    public void v(Intent intent) {
        this.f45329a.v(intent);
    }

    public void w() {
        this.f45329a.w();
    }

    public void x(d.a.h0.a.k0.b.a aVar) {
        this.f45329a.x(aVar);
    }

    @NonNull
    public Pair<Integer, Integer> y() {
        return this.f45329a.y();
    }

    public void z(d.a.h0.a.k0.b.d dVar, boolean z) {
        this.f45329a.z(dVar, z);
    }
}
