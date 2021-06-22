package d.a.m0.a.r1.k.i;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import d.a.m0.a.a2.d;
import d.a.m0.a.r1.l.e;
import d.a.m0.a.v2.q0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f48274f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f48275g;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48276b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48277c;

    /* renamed from: d  reason: collision with root package name */
    public List<Runnable> f48278d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.r1.r.c.a f48279e;

    /* renamed from: d.a.m0.a.r1.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0867a implements d.a.m0.a.r1.r.c.a {
        public C0867a() {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void b() {
            a.this.f48276b = false;
            a.this.l();
            a.this.f48277c = false;
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.f48276b = false;
            a.this.l();
            a.this.p();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void d(String str) {
            a.this.f48276b = true;
            a.this.o();
            a.this.q();
        }

        @Override // d.a.m0.a.r1.r.c.a
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
            if (a.this.f48276b) {
                if (a.f48275g) {
                    a.this.m();
                }
            } else {
                a.this.l();
            }
            return a.this.f48276b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48282a = new a(null);
    }

    static {
        int f2 = e.f();
        f48274f = f2;
        f48275g = f2 % 10 == 1;
    }

    public /* synthetic */ a(C0867a c0867a) {
        this();
    }

    public static a k() {
        return c.f48282a;
    }

    public boolean j(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (f48274f > 0 && this.f48276b) {
            this.f48278d.add(runnable);
            return true;
        }
        q0.X(runnable);
        return false;
    }

    public final void l() {
        if (this.f48278d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (Runnable runnable : this.f48278d) {
            d.i().post(runnable);
        }
        if (d.a.m0.a.f1.f.a.f45636a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle all, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f48278d.size());
        }
        this.f48278d.clear();
    }

    public final void m() {
        if (this.f48278d.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Runnable remove = this.f48278d.remove(0);
        if (remove != null) {
            d.i().post(remove);
        }
        if (d.a.m0.a.f1.f.a.f45636a) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d("SwanPerformance", "idle handle one, cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + this.f48278d.size());
        }
    }

    public void n() {
        if (f48274f > 0) {
            d.a.m0.a.r1.r.a.f().h(this.f48279e, f48274f);
            this.f48276b = true;
        } else if (d.a.m0.a.f1.f.a.f45636a) {
            Log.e("SwanPerformance", "idle handler can't register. ab is closed");
        }
        q();
    }

    public final void o() {
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new b());
    }

    public final void p() {
        if (this.f48277c) {
            this.f48277c = false;
            d.a.m0.a.c1.a.g0().a();
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "YaLog notify");
            }
        }
    }

    public final void q() {
        if (this.f48277c) {
            return;
        }
        this.f48277c = true;
        int o = e.o();
        d.a.m0.a.c1.a.g0().b(o);
        if (d.a.m0.a.f1.f.a.f45636a) {
            Log.d("SwanPerformance", "YaLog block time = " + o);
        }
    }

    public a() {
        this.f48276b = false;
        this.f48277c = false;
        this.f48278d = new CopyOnWriteArrayList();
        this.f48279e = new C0867a();
    }
}
