package d.a.l0.a.l0.o;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.j2.p.e;
import d.a.l0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43343d = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43344e;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f43347c = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f43346b = new RunnableC0732a();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.l0.a.l0.o.b f43345a = new d.a.l0.a.l0.o.b(new b());

    /* renamed from: d.a.l0.a.l0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0732a implements Runnable {
        public RunnableC0732a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f43347c.getAndDecrement();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j = a.this.j();
            if (!j) {
                a.this.h("watchdog_frozen");
            }
            if (a.f43343d) {
                Log.d("WatchDogManager", "doConformCheck:" + j);
            }
            a.m();
        }
    }

    /* loaded from: classes2.dex */
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
        if (f43344e == null) {
            synchronized (a.class) {
                if (f43344e == null) {
                    f43344e = new a();
                }
            }
        }
        return f43344e;
    }

    public static void k() {
        a aVar = f43344e;
        if (aVar != null) {
            aVar.f43345a.d();
            if (f43343d) {
                Log.d("WatchDogManager", "WatchDog pausePeriodTask.");
            }
        }
    }

    public static void l() {
        a aVar = f43344e;
        if (aVar != null) {
            aVar.f43345a.h();
            if (f43343d) {
                Log.d("WatchDogManager", "WatchDog resumePeriodTask.");
            }
        }
    }

    public static synchronized void m() {
        synchronized (a.class) {
            if (f43344e != null) {
                f43344e.f43345a.g();
                f43344e = null;
                if (f43343d) {
                    Log.d("WatchDogManager", "WatchDog Release.");
                }
            }
        }
    }

    public final void f() {
        this.f43345a.e(new c());
    }

    public final void g() {
        boolean j = j();
        if (!j) {
            h("watchdog_block");
            f();
            this.f43345a.i();
        }
        if (f43343d) {
            Log.v("WatchDogManager", "doPeriodCheck:" + j);
        }
        this.f43347c.getAndIncrement();
        n();
    }

    public final void h(String str) {
        e eVar = new e();
        eVar.f43185a = "swan";
        eVar.f43186b = str;
        eVar.f43190f = d.a.l0.a.a2.d.g().getAppId();
        d.a.l0.a.j2.k.u("1619", eVar);
    }

    public final boolean j() {
        return this.f43347c.get() == 0;
    }

    public final void n() {
        d.a.l0.a.h0.l.a P = g.N().P();
        if (P instanceof d.a.l0.a.h0.l.e) {
            P.g().post(this.f43346b);
        } else {
            m();
        }
    }

    public void o() {
        this.f43345a.start();
        if (f43343d) {
            Log.d("WatchDogManager", "WatchDog Start.");
        }
    }
}
