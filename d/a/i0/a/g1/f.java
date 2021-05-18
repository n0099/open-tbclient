package d.a.i0.a.g1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.i0.a.g1.e;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.n;
import d.a.i0.a.v2.q0;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class f implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f41748b = k.f43025a;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f41749c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f41750d;

    /* renamed from: a  reason: collision with root package name */
    public d f41751a = new b();

    /* loaded from: classes3.dex */
    public class b extends d.a.i0.a.g1.b {
        public b(f fVar) {
        }

        @Override // d.a.i0.a.g1.b
        public void R() {
            super.R();
        }

        @Override // d.a.i0.a.g1.d
        public boolean j() {
            return this.f41722h;
        }
    }

    public static f V() {
        if (f41750d == null) {
            synchronized (f.class) {
                if (f41750d == null) {
                    f41750d = new f();
                }
            }
        }
        return f41750d;
    }

    public static synchronized void c0() {
        synchronized (f.class) {
            if (f41750d == null) {
                return;
            }
            if (f41750d.f41751a != null) {
                f41750d.f41751a.P();
            }
            f41750d = null;
        }
    }

    public String A() {
        return this.f41751a.A();
    }

    public d.a.i0.a.p.e.d B(String str) {
        return this.f41751a.B(str);
    }

    public AbsoluteLayout C(String str) {
        return this.f41751a.C(str);
    }

    public String D() {
        return this.f41751a.D();
    }

    public void E(Context context) {
        this.f41751a.E(context);
    }

    @Nullable
    public d.a.i0.a.a2.e F() {
        return this.f41751a.F();
    }

    public void G(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        this.f41751a.G(bVar, bVar2);
    }

    public d.a.i0.a.p.b.a.k H() {
        return this.f41751a.H();
    }

    public d.a.i0.a.k2.f.d I() {
        return this.f41751a.I();
    }

    public d.a.i0.a.h0.g.f J() {
        return this.f41751a.J();
    }

    public SwanAppPropertyWindow L(Activity activity) {
        return this.f41751a.L(activity);
    }

    public SwanCoreVersion N() {
        return this.f41751a.N();
    }

    public boolean O() {
        return this.f41751a.O();
    }

    public void R(int i2) {
        if (a0()) {
            return;
        }
        if (i2 == 0) {
            this.f41751a = new c();
        } else if (i2 != 1) {
        } else {
            this.f41751a = d.a.i0.a.c1.b.a();
        }
    }

    public void S() {
        long decrementAndGet = f41749c.decrementAndGet();
        SwanAppActivity x = d.a.i0.a.a2.d.g().x();
        if (decrementAndGet <= 0 && x != null && x.isBackground()) {
            this.f41751a.K();
        }
        if (f41748b) {
            StringBuilder sb = new StringBuilder();
            sb.append("decrementBgThreadAliveCount: count = ");
            sb.append(decrementAndGet);
            sb.append("isBackground = ");
            sb.append(x != null && x.isBackground());
            Log.i("SwanAppController", sb.toString());
        }
    }

    public long T() {
        return f41749c.get();
    }

    public String U() {
        return q0.n().f();
    }

    @Nullable
    public d.a.i0.a.h0.g.g W() {
        SwanAppActivity activity = V().getActivity();
        if (activity == null) {
            return null;
        }
        return activity.getSwanAppFragmentManager();
    }

    public n X() {
        return this.f41751a.Q();
    }

    public n Y() {
        return this.f41751a.M();
    }

    public boolean Z() {
        return a0() && this.f41751a.getActivity() != null;
    }

    public String a() {
        return this.f41751a.a();
    }

    public boolean a0() {
        d dVar = this.f41751a;
        return (dVar == null || (dVar instanceof b)) ? false : true;
    }

    public void b() {
        this.f41751a.b();
    }

    public void b0() {
        long incrementAndGet = f41749c.incrementAndGet();
        if (f41748b) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void c(d.a.i0.a.f1.e.b bVar, d.a.i0.a.a1.b bVar2) {
        this.f41751a.c(bVar, bVar2);
    }

    @NonNull
    public d.a.i0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.f41751a.d(str, swanAppConfigData, str2);
    }

    @NonNull
    public d.a.i0.a.a2.n.g e(String str) {
        return this.f41751a.e(str);
    }

    public void exit() {
        this.f41751a.exit();
    }

    public String f() {
        return this.f41751a.f();
    }

    @Override // d.a.i0.a.g1.e.b
    public void g(int i2) {
        this.f41751a.g(i2);
    }

    public SwanAppActivity getActivity() {
        return this.f41751a.getActivity();
    }

    public d.a.i0.a.p.e.c h() {
        return this.f41751a.h();
    }

    public d.a.i0.a.a2.n.g i(String str) {
        return this.f41751a.i(str);
    }

    public void k(Context context) {
        this.f41751a.k(context);
    }

    public void l(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !a0()) {
            R(swanAppActivity.getFrameType());
        }
        if (a0()) {
            this.f41751a.l(swanAppActivity);
        }
    }

    public void m(String str, d.a.i0.a.o0.d.a aVar) {
        this.f41751a.m(str, aVar);
    }

    public FullScreenFloatView n(Activity activity) {
        return this.f41751a.n(activity);
    }

    public void o() {
        this.f41751a.o();
    }

    public void p() {
        this.f41751a.p();
    }

    @DebugTrace
    public d.a.i0.a.p.e.a q() {
        return this.f41751a.q();
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        return this.f41751a.r();
    }

    public SwanAppConfigData s() {
        return this.f41751a.s();
    }

    public void t(Intent intent) {
        this.f41751a.t(intent);
    }

    public void u() {
        this.f41751a.u();
    }

    public void v(d.a.i0.a.o0.d.a aVar) {
        this.f41751a.v(aVar);
    }

    public void w() {
        this.f41751a.w();
    }

    public void x() {
        this.f41751a.x();
    }

    @NonNull
    public Pair<Integer, Integer> y() {
        return this.f41751a.y();
    }

    public void z(d.a.i0.a.o0.d.d dVar, boolean z) {
        this.f41751a.z(dVar, z);
    }
}
