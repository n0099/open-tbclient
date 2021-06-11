package d.a.l0.a.l0.o;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.j2.p.e;
import d.a.l0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47019d = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47020e;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f47023c = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f47022b = new RunnableC0788a();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.a.l0.o.b f47021a = new d.a.l0.a.l0.o.b(new b());

    /* renamed from: d.a.l0.a.l0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0788a implements Runnable {
        public RunnableC0788a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f47023c.getAndDecrement();
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
            if (a.f47019d) {
                Log.d("WatchDogManager", "doConformCheck:" + j);
            }
            a.m();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements d.a.l0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            if (d.a.l0.a.r1.l.b.l()) {
                a.m();
                a.i().o();
            }
        }
    }

    public static a i() {
        if (f47020e == null) {
            synchronized (a.class) {
                if (f47020e == null) {
                    f47020e = new a();
                }
            }
        }
        return f47020e;
    }

    public static void k() {
        a aVar = f47020e;
        if (aVar != null) {
            aVar.f47021a.d();
            if (f47019d) {
                Log.d("WatchDogManager", "WatchDog pausePeriodTask.");
            }
        }
    }

    public static void l() {
        a aVar = f47020e;
        if (aVar != null) {
            aVar.f47021a.h();
            if (f47019d) {
                Log.d("WatchDogManager", "WatchDog resumePeriodTask.");
            }
        }
    }

    public static synchronized void m() {
        synchronized (a.class) {
            if (f47020e != null) {
                f47020e.f47021a.g();
                f47020e = null;
                if (f47019d) {
                    Log.d("WatchDogManager", "WatchDog Release.");
                }
            }
        }
    }

    public final void f() {
        this.f47021a.e(new c());
    }

    public final void g() {
        boolean j = j();
        if (!j) {
            h("watchdog_block");
            f();
            this.f47021a.i();
        }
        if (f47019d) {
            Log.v("WatchDogManager", "doPeriodCheck:" + j);
        }
        this.f47023c.getAndIncrement();
        n();
    }

    public final void h(String str) {
        e eVar = new e();
        eVar.f46861a = "swan";
        eVar.f46862b = str;
        eVar.f46866f = d.a.l0.a.a2.d.g().getAppId();
        d.a.l0.a.j2.k.u("1619", eVar);
    }

    public final boolean j() {
        return this.f47023c.get() == 0;
    }

    public final void n() {
        d.a.l0.a.h0.l.a P = g.N().P();
        if (P instanceof d.a.l0.a.h0.l.e) {
            P.g().post(this.f47022b);
        } else {
            m();
        }
    }

    public void o() {
        this.f47021a.start();
        if (f47019d) {
            Log.d("WatchDogManager", "WatchDog Start.");
        }
    }
}
