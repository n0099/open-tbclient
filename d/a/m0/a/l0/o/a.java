package d.a.m0.a.l0.o;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.j2.p.e;
import d.a.m0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47127d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47128e;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f47131c = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f47130b = new RunnableC0791a();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.m0.a.l0.o.b f47129a = new d.a.m0.a.l0.o.b(new b());

    /* renamed from: d.a.m0.a.l0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0791a implements Runnable {
        public RunnableC0791a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f47131c.getAndDecrement();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j = a.this.j();
            if (!j) {
                a.this.h("watchdog_frozen");
            }
            if (a.f47127d) {
                Log.d("WatchDogManager", "doConformCheck:" + j);
            }
            a.m();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.m0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            if (d.a.m0.a.r1.l.b.l()) {
                a.m();
                a.i().o();
            }
        }
    }

    public static a i() {
        if (f47128e == null) {
            synchronized (a.class) {
                if (f47128e == null) {
                    f47128e = new a();
                }
            }
        }
        return f47128e;
    }

    public static void k() {
        a aVar = f47128e;
        if (aVar != null) {
            aVar.f47129a.d();
            if (f47127d) {
                Log.d("WatchDogManager", "WatchDog pausePeriodTask.");
            }
        }
    }

    public static void l() {
        a aVar = f47128e;
        if (aVar != null) {
            aVar.f47129a.h();
            if (f47127d) {
                Log.d("WatchDogManager", "WatchDog resumePeriodTask.");
            }
        }
    }

    public static synchronized void m() {
        synchronized (a.class) {
            if (f47128e != null) {
                f47128e.f47129a.g();
                f47128e = null;
                if (f47127d) {
                    Log.d("WatchDogManager", "WatchDog Release.");
                }
            }
        }
    }

    public final void f() {
        this.f47129a.e(new c());
    }

    public final void g() {
        boolean j = j();
        if (!j) {
            h("watchdog_block");
            f();
            this.f47129a.i();
        }
        if (f47127d) {
            Log.v("WatchDogManager", "doPeriodCheck:" + j);
        }
        this.f47131c.getAndIncrement();
        n();
    }

    public final void h(String str) {
        e eVar = new e();
        eVar.f46969a = "swan";
        eVar.f46970b = str;
        eVar.f46974f = d.a.m0.a.a2.d.g().getAppId();
        d.a.m0.a.j2.k.u("1619", eVar);
    }

    public final boolean j() {
        return this.f47131c.get() == 0;
    }

    public final void n() {
        d.a.m0.a.h0.l.a P = g.N().P();
        if (P instanceof d.a.m0.a.h0.l.e) {
            P.g().post(this.f47130b);
        } else {
            m();
        }
    }

    public void o() {
        this.f47129a.start();
        if (f47127d) {
            Log.d("WatchDogManager", "WatchDog Start.");
        }
    }
}
