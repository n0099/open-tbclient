package d.a.i0.a.l0.o;

import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.j2.p.e;
import d.a.i0.a.k;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43169d = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43170e;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f43173c = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f43172b = new RunnableC0721a();

    /* renamed from: a  reason: collision with root package name */
    public final d.a.i0.a.l0.o.b f43171a = new d.a.i0.a.l0.o.b(new b());

    /* renamed from: d.a.i0.a.l0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0721a implements Runnable {
        public RunnableC0721a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f43173c.getAndDecrement();
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
            if (a.f43169d) {
                Log.d("WatchDogManager", "doConformCheck:" + j);
            }
            a.m();
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            if (d.a.i0.a.r1.l.b.l()) {
                a.m();
                a.i().o();
            }
        }
    }

    public static a i() {
        if (f43170e == null) {
            synchronized (a.class) {
                if (f43170e == null) {
                    f43170e = new a();
                }
            }
        }
        return f43170e;
    }

    public static void k() {
        a aVar = f43170e;
        if (aVar != null) {
            aVar.f43171a.d();
            if (f43169d) {
                Log.d("WatchDogManager", "WatchDog pausePeriodTask.");
            }
        }
    }

    public static void l() {
        a aVar = f43170e;
        if (aVar != null) {
            aVar.f43171a.h();
            if (f43169d) {
                Log.d("WatchDogManager", "WatchDog resumePeriodTask.");
            }
        }
    }

    public static synchronized void m() {
        synchronized (a.class) {
            if (f43170e != null) {
                f43170e.f43171a.g();
                f43170e = null;
                if (f43169d) {
                    Log.d("WatchDogManager", "WatchDog Release.");
                }
            }
        }
    }

    public final void f() {
        this.f43171a.e(new c());
    }

    public final void g() {
        boolean j = j();
        if (!j) {
            h("watchdog_block");
            f();
            this.f43171a.i();
        }
        if (f43169d) {
            Log.v("WatchDogManager", "doPeriodCheck:" + j);
        }
        this.f43173c.getAndIncrement();
        n();
    }

    public final void h(String str) {
        e eVar = new e();
        eVar.f43011a = "swan";
        eVar.f43012b = str;
        eVar.f43016f = d.a.i0.a.a2.d.g().getAppId();
        d.a.i0.a.j2.k.u("1619", eVar);
    }

    public final boolean j() {
        return this.f43173c.get() == 0;
    }

    public final void n() {
        d.a.i0.a.h0.l.a P = g.N().P();
        if (P instanceof d.a.i0.a.h0.l.e) {
            P.g().post(this.f43172b);
        } else {
            m();
        }
    }

    public void o() {
        this.f43171a.start();
        if (f43169d) {
            Log.d("WatchDogManager", "WatchDog Start.");
        }
    }
}
