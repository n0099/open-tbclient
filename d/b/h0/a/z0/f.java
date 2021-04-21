package d.b.h0.a.z0;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.z0.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class f implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47890b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f47891c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f47892d;

    /* renamed from: a  reason: collision with root package name */
    public d f47893a = new b(this, null);

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.h0.a.z0.b {
        public b(f fVar) {
        }

        @Override // d.b.h0.a.z0.b
        public void R() {
            super.R();
        }

        @Override // d.b.h0.a.z0.d
        public boolean s() {
            return this.f47865h;
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    public static f V() {
        if (f47892d == null) {
            synchronized (f.class) {
                if (f47892d == null) {
                    f47892d = new f();
                }
            }
        }
        return f47892d;
    }

    public static synchronized void d0() {
        synchronized (f.class) {
            if (f47892d == null) {
                return;
            }
            if (f47892d.f47893a != null) {
                f47892d.f47893a.P();
            }
            f47892d = null;
        }
    }

    public d.b.h0.a.e0.l.e A() {
        return this.f47893a.A();
    }

    public FullScreenFloatView B(Activity activity) {
        return this.f47893a.B(activity);
    }

    public void C() {
        this.f47893a.C();
    }

    public void D() {
        this.f47893a.D();
    }

    @DebugTrace
    public d.b.h0.a.p.d.a F() {
        return this.f47893a.F();
    }

    @NonNull
    public Pair<Integer, Integer> G() {
        return this.f47893a.G();
    }

    public SwanAppPropertyWindow H(Activity activity) {
        return this.f47893a.H(activity);
    }

    public SwanAppConfigData I() {
        return this.f47893a.I();
    }

    public void J(Intent intent) {
        this.f47893a.J(intent);
    }

    public SwanCoreVersion L() {
        return this.f47893a.L();
    }

    public void M() {
        this.f47893a.M();
    }

    public void N(d.b.h0.a.k0.b.a aVar) {
        this.f47893a.N(aVar);
    }

    public boolean O() {
        return this.f47893a.O();
    }

    public void R(int i) {
        if (a0()) {
            return;
        }
        if (i == 0) {
            this.f47893a = new c();
        } else if (i != 1) {
        } else {
            this.f47893a = new d.b.h0.g.u.a();
        }
    }

    public void S() {
        long decrementAndGet = f47891c.decrementAndGet();
        if (decrementAndGet <= 0) {
            f47892d.f47893a.E();
        }
        if (f47890b) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    public long T() {
        return f47891c.get();
    }

    public String U() {
        return k0.n().d();
    }

    @Nullable
    public d.b.h0.a.e0.l.f W() {
        SwanAppActivity n;
        d.b.h0.a.r1.e O = d.b.h0.a.r1.e.O();
        if (O == null || (n = O.n()) == null) {
            return null;
        }
        return n.getSwanAppFragmentManager();
    }

    public d.b.h0.g.k0.d X() {
        return this.f47893a.Q();
    }

    public d.b.h0.g.k0.d Y() {
        return this.f47893a.K();
    }

    public boolean Z() {
        return a0() && this.f47893a.getActivity() != null;
    }

    public void a() {
        this.f47893a.a();
    }

    public boolean a0() {
        d dVar = this.f47893a;
        return (dVar == null || (dVar instanceof b)) ? false : true;
    }

    public void b() {
        this.f47893a.b();
    }

    public void b0() {
        long incrementAndGet = f47891c.incrementAndGet();
        if (f47890b) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    @NonNull
    public Pair<Integer, Integer> c() {
        return this.f47893a.c();
    }

    public void c0() {
        if (f47890b) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        d.b.h0.a.w0.a.F().a();
        if (f47890b) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.g();
        p.j(new a(this), "computation");
        d.b.h0.a.t.c.n.e.d(AppRuntime.getAppContext());
        if (f47890b) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public String d() {
        return this.f47893a.d();
    }

    public void e(d.b.h0.a.k0.b.d dVar, boolean z) {
        this.f47893a.e(dVar, z);
    }

    public void exit() {
        this.f47893a.exit();
    }

    public void f() {
        this.f47893a.f();
    }

    public void g(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        this.f47893a.g(bVar, bVar2);
    }

    public SwanAppActivity getActivity() {
        return this.f47893a.getActivity();
    }

    public String h() {
        return this.f47893a.h();
    }

    @NonNull
    public d.b.h0.a.r1.n.c i(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.f47893a.i(str, swanAppConfigData, str2);
    }

    public d.b.h0.a.p.d.d j(String str) {
        return this.f47893a.j(str);
    }

    @NonNull
    public d.b.h0.a.r1.n.c k(String str) {
        return this.f47893a.k(str);
    }

    public String l() {
        return this.f47893a.l();
    }

    public AbsoluteLayout m(String str) {
        return this.f47893a.m(str);
    }

    @Override // d.b.h0.a.z0.e.b
    public void n(int i) {
        this.f47893a.n(i);
    }

    public d.b.h0.a.p.d.c o() {
        return this.f47893a.o();
    }

    public String p() {
        return this.f47893a.p();
    }

    public void q(Context context) {
        this.f47893a.q(context);
    }

    public d.b.h0.a.r1.n.c r(String str) {
        return this.f47893a.r(str);
    }

    @Nullable
    public d.b.h0.a.r1.e t() {
        return this.f47893a.t();
    }

    public void u(d.b.h0.a.y0.e.b bVar, d.b.h0.a.u0.b bVar2) {
        this.f47893a.u(bVar, bVar2);
    }

    public d.b.h0.g.v.a v() {
        return this.f47893a.v();
    }

    public void w(Context context) {
        this.f47893a.w(context);
    }

    public void x(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !a0()) {
            R(swanAppActivity.getFrameType());
        }
        if (a0()) {
            this.f47893a.x(swanAppActivity);
        }
    }

    public d.b.h0.a.a2.f.c y() {
        return this.f47893a.y();
    }

    public void z(String str, d.b.h0.a.k0.b.a aVar) {
        this.f47893a.z(str, aVar);
    }
}
