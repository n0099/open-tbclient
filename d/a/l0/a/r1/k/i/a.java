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
    public static final int f44492f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f44493g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44494b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44495c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f44496d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f44497e;

    /* renamed from: d.a.l0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0808a implements d.a.l0.a.r1.r.c.a {
        public C0808a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            a.this.f44494b = false;
            a.this.l();
            a.this.f44495c = false;
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.f44494b = false;
            a.this.l();
            a.this.p();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            a.this.f44494b = true;
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
            if (a.this.f44494b) {
                if (a.f44493g) {
                    a.this.m();
                }
            } else {
                a.this.l();
            }
            return a.this.f44494b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44500a = new a(null);
    }

    static {
        int f2 = e.f();
        f44492f = f2;
        f44493g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0808a c0808a) {
        this();
    }

    public static a k() {
        return c.f44500a;
    }

    public boolean j(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (f44492f > 0 && this.f44494b) {
            this.f44496d.add(runnable);
            return true;
        }
        q0.X(runnable);
        return false;
    }

    public final void l() {
        if (this.f44496d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f44496d) {
            d.i().post(runnable);
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f44496d.size());
        }
        this.f44496d.clear();
    }

    public final void m() {
        if (this.f44496d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f44496d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (d.a.l0.a.f1.f.a.f41852a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f44496d.size());
        }
    }

    public void n() {
        if (f44492f > 0) {
            d.a.l0.a.r1.r.a.f().h(this.f44497e, f44492f);
            this.f44494b = true;
        } else if (d.a.l0.a.f1.f.a.f41852a) {
            Log.e("SwanPerformance", "idle handler can't register. ab is closed");
        }
        q();
    }

    public final void o() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new b());
    }

    public final void p() {
        if (this.f44495c) {
            this.f44495c = false;
            d.a.l0.a.c1.a.g0().a();
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void q() {
        if (this.f44495c) {
            return;
        }
        this.f44495c = true;
        int o = e.o();
        d.a.l0.a.c1.a.g0().b(o);
        if (d.a.l0.a.f1.f.a.f41852a) {
            Log.d("SwanPerformance", "YaLog block time = " + o);
        }
    }

    public a() {
        this.f44494b = false;
        this.f44495c = false;
        this.f44496d = new CopyOnWriteArrayList();
        this.f44497e = new C0808a();
    }
}
