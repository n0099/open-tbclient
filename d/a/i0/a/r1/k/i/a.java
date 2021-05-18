package d.a.i0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import d.a.i0.a.a2.d;
import d.a.i0.a.r1.l.e;
import d.a.i0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f44316f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f44317g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44318b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44319c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f44320d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.r1.r.c.a f44321e;

    /* renamed from: d.a.i0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0797a implements d.a.i0.a.r1.r.c.a {
        public C0797a() {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void b() {
            a.this.f44318b = false;
            a.this.l();
            a.this.f44319c = false;
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.f44318b = false;
            a.this.l();
            a.this.p();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void d(String str) {
            a.this.f44318b = true;
            a.this.o();
            a.this.q();
        }

        @Override // d.a.i0.a.r1.r.c.a
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
            if (a.this.f44318b) {
                if (a.f44317g) {
                    a.this.m();
                }
            } else {
                a.this.l();
            }
            return a.this.f44318b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44324a = new a(null);
    }

    static {
        int f2 = e.f();
        f44316f = f2;
        f44317g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0797a c0797a) {
        this();
    }

    public static a k() {
        return c.f44324a;
    }

    public boolean j(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (f44316f > 0 && this.f44318b) {
            this.f44320d.add(runnable);
            return true;
        }
        q0.X(runnable);
        return false;
    }

    public final void l() {
        if (this.f44320d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f44320d) {
            d.i().post(runnable);
        }
        if (d.a.i0.a.f1.f.a.f41678a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f44320d.size());
        }
        this.f44320d.clear();
    }

    public final void m() {
        if (this.f44320d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f44320d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (d.a.i0.a.f1.f.a.f41678a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f44320d.size());
        }
    }

    public void n() {
        if (f44316f > 0) {
            d.a.i0.a.r1.r.a.f().h(this.f44321e, f44316f);
            this.f44318b = true;
        } else if (d.a.i0.a.f1.f.a.f41678a) {
            Log.e("SwanPerformance", "idle handler can't register. ab is closed");
        }
        q();
    }

    public final void o() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new b());
    }

    public final void p() {
        if (this.f44319c) {
            this.f44319c = false;
            d.a.i0.a.c1.a.g0().a();
            if (d.a.i0.a.f1.f.a.f41678a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void q() {
        if (this.f44319c) {
            return;
        }
        this.f44319c = true;
        int o = e.o();
        d.a.i0.a.c1.a.g0().b(o);
        if (d.a.i0.a.f1.f.a.f41678a) {
            Log.d("SwanPerformance", "YaLog block time = " + o);
        }
    }

    public a() {
        this.f44318b = false;
        this.f44319c = false;
        this.f44320d = new CopyOnWriteArrayList();
        this.f44321e = new C0797a();
    }
}
