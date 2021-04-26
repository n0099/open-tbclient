package d.a.h0.a.r1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.h0.a.r1.i;
import d.a.h0.a.y0.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class d extends d.a.h0.a.r1.a {
    public static final boolean l = d.a.h0.a.k.f43101a;
    public static d m;
    public static Handler n;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.a.p.a f43810e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.h0.a.i2.u0.b<i.a>> f43811f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f43812g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f43813h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f43814i;
    public d.a.h0.l.l.f j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f43815e;

        /* renamed from: d.a.h0.a.r1.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0749a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.i2.u0.b f43817e;

            public RunnableC0749a(d.a.h0.a.i2.u0.b bVar) {
                this.f43817e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f43817e.onCallback(a.this.f43815e);
            }
        }

        public a(i.a aVar) {
            this.f43815e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            for (d.a.h0.a.i2.u0.b bVar : d.this.f43811f) {
                if (z && !this.f43815e.d("event_flag_force_post", false)) {
                    bVar.onCallback(this.f43815e);
                } else {
                    d.g().post(new RunnableC0749a(bVar));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43819e;

        public b(d.a.h0.a.i2.u0.b bVar) {
            this.f43819e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f43811f.add(this.f43819e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43821e;

        public c(d.a.h0.a.i2.u0.b bVar) {
            this.f43821e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f43811f.remove(this.f43821e);
        }
    }

    public d() {
        new c.a();
        this.f43811f = new HashSet();
        this.f43812g = 0;
        this.f43813h = new ArrayDeque();
        this.f43814i = null;
        this.k = false;
    }

    public static d e() {
        d f2 = f();
        if (!f2.k) {
            f2.i();
        }
        return f2;
    }

    public static d f() {
        d dVar = m;
        if (dVar instanceof j) {
            return dVar;
        }
        synchronized (d.class) {
            if (m instanceof j) {
                return m;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                j jVar = new j();
                m = jVar;
                return jVar;
            } else if (current.isSwanService) {
                if (!(m instanceof l)) {
                    m = new l();
                }
                return m;
            } else {
                if (m == null) {
                    m = new d.a.h0.a.r1.c();
                }
                return m;
            }
        }
    }

    public static Handler g() {
        if (n == null) {
            n = new Handler(Looper.getMainLooper());
        }
        return n;
    }

    public final synchronized void A(@NonNull Runnable runnable) {
        this.f43813h.offer(runnable);
        if (this.f43814i == null) {
            while (!this.f43813h.isEmpty()) {
                Runnable poll = this.f43813h.poll();
                this.f43814i = poll;
                if (poll != null) {
                    poll.run();
                }
                this.f43814i = null;
            }
        }
    }

    public abstract d.a.h0.l.l.f d();

    public d.a.h0.l.l.f h() {
        if (this.j == null) {
            this.j = d();
        }
        return this.j;
    }

    public final void i() {
        if (this.k) {
            return;
        }
        h();
        d.a.h0.a.n1.b.c.E();
    }

    @Override // d.a.h0.a.r1.h
    public void n(d.a.h0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new c(bVar));
        }
    }

    @Override // d.a.h0.a.r1.h
    public void o(String str) {
        u(str, null);
    }

    @Override // d.a.h0.a.r1.h
    public void t(d.a.h0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new b(bVar));
        }
    }

    @Override // d.a.h0.a.r1.h
    public void u(String str, Bundle bundle) {
        y(new i.a(str, bundle));
    }

    @Override // d.a.h0.a.r1.h
    public d.a.h0.a.p.a w() {
        if (this.f43810e == null) {
            this.f43810e = new d.a.h0.a.p.a();
        }
        return this.f43810e;
    }

    @Override // d.a.h0.a.r1.h
    public void y(i.a aVar) {
        if (l) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f43811f.size());
        }
        if (aVar != null) {
            A(new a(aVar));
        }
    }
}
