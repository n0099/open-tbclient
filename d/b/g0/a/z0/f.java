package d.b.g0.a.z0;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.z0.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class f implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47561b = k.f45443a;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f47562c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f47563d;

    /* renamed from: a  reason: collision with root package name */
    public d f47564a = new b(this, null);

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.a.z0.b {
        public b(f fVar) {
        }

        @Override // d.b.g0.a.z0.b
        public void R() {
            super.R();
        }

        @Override // d.b.g0.a.z0.d
        public boolean s() {
            return this.f47536h;
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public static f V() {
        if (f47563d == null) {
            synchronized (f.class) {
                if (f47563d == null) {
                    f47563d = new f();
                }
            }
        }
        return f47563d;
    }

    public static synchronized void d0() {
        synchronized (f.class) {
            if (f47563d == null) {
                return;
            }
            if (f47563d.f47564a != null) {
                f47563d.f47564a.P();
            }
            f47563d = null;
        }
    }

    public d.b.g0.a.e0.l.e A() {
        return this.f47564a.A();
    }

    public FullScreenFloatView B(Activity activity) {
        return this.f47564a.B(activity);
    }

    public void C() {
        this.f47564a.C();
    }

    public void D() {
        this.f47564a.D();
    }

    @DebugTrace
    public d.b.g0.a.p.d.a F() {
        return this.f47564a.F();
    }

    @NonNull
    public Pair<Integer, Integer> G() {
        return this.f47564a.G();
    }

    public SwanAppPropertyWindow H(Activity activity) {
        return this.f47564a.H(activity);
    }

    public SwanAppConfigData I() {
        return this.f47564a.I();
    }

    public void J(Intent intent) {
        this.f47564a.J(intent);
    }

    public SwanCoreVersion L() {
        return this.f47564a.L();
    }

    public void M() {
        this.f47564a.M();
    }

    public void N(d.b.g0.a.k0.b.a aVar) {
        this.f47564a.N(aVar);
    }

    public boolean O() {
        return this.f47564a.O();
    }

    public void R(int i) {
        if (a0()) {
            return;
        }
        if (i == 0) {
            this.f47564a = new c();
        } else if (i != 1) {
        } else {
            this.f47564a = new d.b.g0.g.u.a();
        }
    }

    public void S() {
        long decrementAndGet = f47562c.decrementAndGet();
        if (decrementAndGet <= 0) {
            f47563d.f47564a.E();
        }
        if (f47561b) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    public long T() {
        return f47562c.get();
    }

    public String U() {
        return k0.n().d();
    }

    @Nullable
    public d.b.g0.a.e0.l.f W() {
        SwanAppActivity n;
        d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
        if (O == null || (n = O.n()) == null) {
            return null;
        }
        return n.getSwanAppFragmentManager();
    }

    public d.b.g0.g.k0.d X() {
        return this.f47564a.Q();
    }

    public d.b.g0.g.k0.d Y() {
        return this.f47564a.K();
    }

    public boolean Z() {
        return a0() && this.f47564a.getActivity() != null;
    }

    public void a() {
        this.f47564a.a();
    }

    public boolean a0() {
        d dVar = this.f47564a;
        return (dVar == null || (dVar instanceof b)) ? false : true;
    }

    public void b() {
        this.f47564a.b();
    }

    public void b0() {
        long incrementAndGet = f47562c.incrementAndGet();
        if (f47561b) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    @NonNull
    public Pair<Integer, Integer> c() {
        return this.f47564a.c();
    }

    public void c0() {
        if (f47561b) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        d.b.g0.a.w0.a.F().a();
        if (f47561b) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.g();
        p.j(new a(this), "computation");
        d.b.g0.a.t.c.n.e.d(AppRuntime.getAppContext());
        if (f47561b) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public String d() {
        return this.f47564a.d();
    }

    public void e(d.b.g0.a.k0.b.d dVar, boolean z) {
        this.f47564a.e(dVar, z);
    }

    public void exit() {
        this.f47564a.exit();
    }

    public void f() {
        this.f47564a.f();
    }

    public void g(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
        this.f47564a.g(bVar, bVar2);
    }

    public SwanAppActivity getActivity() {
        return this.f47564a.getActivity();
    }

    public String h() {
        return this.f47564a.h();
    }

    @NonNull
    public d.b.g0.a.r1.n.c i(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.f47564a.i(str, swanAppConfigData, str2);
    }

    public d.b.g0.a.p.d.d j(String str) {
        return this.f47564a.j(str);
    }

    @NonNull
    public d.b.g0.a.r1.n.c k(String str) {
        return this.f47564a.k(str);
    }

    public String l() {
        return this.f47564a.l();
    }

    public AbsoluteLayout m(String str) {
        return this.f47564a.m(str);
    }

    @Override // d.b.g0.a.z0.e.b
    public void n(int i) {
        this.f47564a.n(i);
    }

    public d.b.g0.a.p.d.c o() {
        return this.f47564a.o();
    }

    public String p() {
        return this.f47564a.p();
    }

    public void q(Context context) {
        this.f47564a.q(context);
    }

    public d.b.g0.a.r1.n.c r(String str) {
        return this.f47564a.r(str);
    }

    @Nullable
    public d.b.g0.a.r1.e t() {
        return this.f47564a.t();
    }

    public void u(d.b.g0.a.y0.e.b bVar, d.b.g0.a.u0.b bVar2) {
        this.f47564a.u(bVar, bVar2);
    }

    public d.b.g0.g.v.a v() {
        return this.f47564a.v();
    }

    public void w(Context context) {
        this.f47564a.w(context);
    }

    public void x(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !a0()) {
            R(swanAppActivity.getFrameType());
        }
        if (a0()) {
            this.f47564a.x(swanAppActivity);
        }
    }

    public d.b.g0.a.a2.f.c y() {
        return this.f47564a.y();
    }

    public void z(String str, d.b.g0.a.k0.b.a aVar) {
        this.f47564a.z(str, aVar);
    }
}
