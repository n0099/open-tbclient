package d.a.m0.a.g1;

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
import d.a.m0.a.g1.e;
import d.a.m0.a.k;
import d.a.m0.a.p.b.a.n;
import d.a.m0.a.v2.q0;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class f implements e.b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45706b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static AtomicLong f45707c = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    public static volatile f f45708d;

    /* renamed from: a  reason: collision with root package name */
    public d f45709a = new b();

    /* loaded from: classes3.dex */
    public class b extends d.a.m0.a.g1.b {
        public b(f fVar) {
        }

        @Override // d.a.m0.a.g1.b
        public void R() {
            super.R();
        }

        @Override // d.a.m0.a.g1.d
        public boolean j() {
            return this.f45680h;
        }
    }

    public static f V() {
        if (f45708d == null) {
            synchronized (f.class) {
                if (f45708d == null) {
                    f45708d = new f();
                }
            }
        }
        return f45708d;
    }

    public static synchronized void c0() {
        synchronized (f.class) {
            if (f45708d == null) {
                return;
            }
            if (f45708d.f45709a != null) {
                f45708d.f45709a.P();
            }
            f45708d = null;
        }
    }

    public String A() {
        return this.f45709a.A();
    }

    public d.a.m0.a.p.e.d B(String str) {
        return this.f45709a.B(str);
    }

    public AbsoluteLayout C(String str) {
        return this.f45709a.C(str);
    }

    public String D() {
        return this.f45709a.D();
    }

    public void E(Context context) {
        this.f45709a.E(context);
    }

    @Nullable
    public d.a.m0.a.a2.e F() {
        return this.f45709a.F();
    }

    public void G(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        this.f45709a.G(bVar, bVar2);
    }

    public d.a.m0.a.p.b.a.k H() {
        return this.f45709a.H();
    }

    public d.a.m0.a.k2.f.d I() {
        return this.f45709a.I();
    }

    public d.a.m0.a.h0.g.f J() {
        return this.f45709a.J();
    }

    public SwanAppPropertyWindow L(Activity activity) {
        return this.f45709a.L(activity);
    }

    public SwanCoreVersion N() {
        return this.f45709a.N();
    }

    public boolean O() {
        return this.f45709a.O();
    }

    public void R(int i2) {
        if (a0()) {
            return;
        }
        if (i2 == 0) {
            this.f45709a = new c();
        } else if (i2 != 1) {
        } else {
            this.f45709a = d.a.m0.a.c1.b.a();
        }
    }

    public void S() {
        long decrementAndGet = f45707c.decrementAndGet();
        SwanAppActivity x = d.a.m0.a.a2.d.g().x();
        if (decrementAndGet <= 0 && x != null && x.isBackground()) {
            this.f45709a.K();
        }
        if (f45706b) {
            StringBuilder sb = new StringBuilder();
            sb.append("decrementBgThreadAliveCount: count = ");
            sb.append(decrementAndGet);
            sb.append("isBackground = ");
            sb.append(x != null && x.isBackground());
            Log.i("SwanAppController", sb.toString());
        }
    }

    public long T() {
        return f45707c.get();
    }

    public String U() {
        return q0.n().f();
    }

    @Nullable
    public d.a.m0.a.h0.g.g W() {
        SwanAppActivity activity = V().getActivity();
        if (activity == null) {
            return null;
        }
        return activity.getSwanAppFragmentManager();
    }

    public n X() {
        return this.f45709a.Q();
    }

    public n Y() {
        return this.f45709a.M();
    }

    public boolean Z() {
        return a0() && this.f45709a.getActivity() != null;
    }

    public String a() {
        return this.f45709a.a();
    }

    public boolean a0() {
        d dVar = this.f45709a;
        return (dVar == null || (dVar instanceof b)) ? false : true;
    }

    public void b() {
        this.f45709a.b();
    }

    public void b0() {
        long incrementAndGet = f45707c.incrementAndGet();
        if (f45706b) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void c(d.a.m0.a.f1.e.b bVar, d.a.m0.a.a1.b bVar2) {
        this.f45709a.c(bVar, bVar2);
    }

    @NonNull
    public d.a.m0.a.a2.n.g d(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.f45709a.d(str, swanAppConfigData, str2);
    }

    @NonNull
    public d.a.m0.a.a2.n.g e(String str) {
        return this.f45709a.e(str);
    }

    public void exit() {
        this.f45709a.exit();
    }

    public String f() {
        return this.f45709a.f();
    }

    @Override // d.a.m0.a.g1.e.b
    public void g(int i2) {
        this.f45709a.g(i2);
    }

    public SwanAppActivity getActivity() {
        return this.f45709a.getActivity();
    }

    public d.a.m0.a.p.e.c h() {
        return this.f45709a.h();
    }

    public d.a.m0.a.a2.n.g i(String str) {
        return this.f45709a.i(str);
    }

    public void k(Context context) {
        this.f45709a.k(context);
    }

    public void l(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !a0()) {
            R(swanAppActivity.getFrameType());
        }
        if (a0()) {
            this.f45709a.l(swanAppActivity);
        }
    }

    public void m(String str, d.a.m0.a.o0.d.a aVar) {
        this.f45709a.m(str, aVar);
    }

    public FullScreenFloatView n(Activity activity) {
        return this.f45709a.n(activity);
    }

    public void o() {
        this.f45709a.o();
    }

    public void p() {
        this.f45709a.p();
    }

    @DebugTrace
    public d.a.m0.a.p.e.a q() {
        return this.f45709a.q();
    }

    @NonNull
    public Pair<Integer, Integer> r() {
        return this.f45709a.r();
    }

    public SwanAppConfigData s() {
        return this.f45709a.s();
    }

    public void t(Intent intent) {
        this.f45709a.t(intent);
    }

    public void u() {
        this.f45709a.u();
    }

    public void v(d.a.m0.a.o0.d.a aVar) {
        this.f45709a.v(aVar);
    }

    public void w() {
        this.f45709a.w();
    }

    public void x() {
        this.f45709a.x();
    }

    @NonNull
    public Pair<Integer, Integer> y() {
        return this.f45709a.y();
    }

    public void z(d.a.m0.a.o0.d.d dVar, boolean z) {
        this.f45709a.z(dVar, z);
    }
}
