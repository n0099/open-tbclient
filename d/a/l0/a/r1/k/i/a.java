package d.a.l0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import d.a.l0.a.a2.d;
import d.a.l0.a.r1.l.e;
import d.a.l0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f48166f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f48167g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48168b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48169c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f48170d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f48171e;

    /* renamed from: d.a.l0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0864a implements d.a.l0.a.r1.r.c.a {
        public C0864a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            a.this.f48168b = false;
            a.this.l();
            a.this.f48169c = false;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.f48168b = false;
            a.this.l();
            a.this.p();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            a.this.f48168b = true;
            a.this.o();
            a.this.q();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "IdleHandler";
        }
    }

    /* loaded from: classes3.dex */
    public class b implements MessageQueue.IdleHandler {
        public b() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            if (a.this.f48168b) {
                if (a.f48167g) {
                    a.this.m();
                }
            } else {
                a.this.l();
            }
            return a.this.f48168b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48174a = new a(null);
    }

    static {
        int f2 = e.f();
        f48166f = f2;
        f48167g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0864a c0864a) {
        this();
    }

    public static a k() {
        return c.f48174a;
    }

    public boolean j(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (f48166f > 0 && this.f48168b) {
            this.f48170d.add(runnable);
            return true;
        }
        q0.X(runnable);
        return false;
    }

    public final void l() {
        if (this.f48170d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f48170d) {
            d.i().post(runnable);
        }
        if (d.a.l0.a.f1.f.a.f45528a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f48170d.size());
        }
        this.f48170d.clear();
    }

    public final void m() {
        if (this.f48170d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f48170d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (d.a.l0.a.f1.f.a.f45528a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f48170d.size());
        }
    }

    public void n() {
        if (f48166f > 0) {
            d.a.l0.a.r1.r.a.f().h(this.f48171e, f48166f);
            this.f48168b = true;
        } else if (d.a.l0.a.f1.f.a.f45528a) {
            Log.e("SwanPerformance", "idle handler can't register. ab is closed");
        }
        q();
    }

    public final void o() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new b());
    }

    public final void p() {
        if (this.f48169c) {
            this.f48169c = false;
            d.a.l0.a.c1.a.g0().a();
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void q() {
        if (this.f48169c) {
            return;
        }
        this.f48169c = true;
        int o = e.o();
        d.a.l0.a.c1.a.g0().b(o);
        if (d.a.l0.a.f1.f.a.f45528a) {
            Log.d("SwanPerformance", "YaLog block time = " + o);
        }
    }

    public a() {
        this.f48168b = false;
        this.f48169c = false;
        this.f48170d = new CopyOnWriteArrayList();
        this.f48171e = new C0864a();
    }
}
