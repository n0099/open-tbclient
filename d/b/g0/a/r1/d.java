package d.b.g0.a.r1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.r1.i;
import d.b.g0.a.y0.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class d extends d.b.g0.a.r1.a {
    public static final boolean l = d.b.g0.a.k.f45051a;
    public static d m;
    public static Handler n;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.a.p.a f45728e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<i.a>> f45729f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f45730g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f45731h;
    public Runnable i;
    public d.b.g0.l.l.f j;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f45732e;

        /* renamed from: d.b.g0.a.r1.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0778a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.i2.u0.b f45734e;

            public RunnableC0778a(d.b.g0.a.i2.u0.b bVar) {
                this.f45734e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f45734e.onCallback(a.this.f45732e);
            }
        }

        public a(i.a aVar) {
            this.f45732e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            for (d.b.g0.a.i2.u0.b bVar : d.this.f45729f) {
                if (z && !this.f45732e.d("event_flag_force_post", false)) {
                    bVar.onCallback(this.f45732e);
                } else {
                    d.g().post(new RunnableC0778a(bVar));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45736e;

        public b(d.b.g0.a.i2.u0.b bVar) {
            this.f45736e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f45729f.add(this.f45736e);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45738e;

        public c(d.b.g0.a.i2.u0.b bVar) {
            this.f45738e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f45729f.remove(this.f45738e);
        }
    }

    public d() {
        new c.a();
        this.f45729f = new HashSet();
        this.f45730g = 0;
        this.f45731h = new ArrayDeque();
        this.i = null;
        this.k = false;
    }

    public static d e() {
        d f2 = f();
        if (!f2.k) {
            f2.z();
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
                    m = new d.b.g0.a.r1.c();
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
        this.f45731h.offer(runnable);
        if (this.i == null) {
            while (!this.f45731h.isEmpty()) {
                Runnable poll = this.f45731h.poll();
                this.i = poll;
                if (poll != null) {
                    poll.run();
                }
                this.i = null;
            }
        }
    }

    public abstract d.b.g0.l.l.f d();

    @Override // d.b.g0.a.r1.h
    public void i(d.b.g0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new b(bVar));
        }
    }

    @Override // d.b.g0.a.r1.h
    public void l(String str, Bundle bundle) {
        t(new i.a(str, bundle));
    }

    @Override // d.b.g0.a.r1.h
    public d.b.g0.a.p.a o() {
        if (this.f45728e == null) {
            this.f45728e = new d.b.g0.a.p.a();
        }
        return this.f45728e;
    }

    @Override // d.b.g0.a.r1.h
    public void p(d.b.g0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new c(bVar));
        }
    }

    @Override // d.b.g0.a.r1.h
    public void r(String str) {
        l(str, null);
    }

    @Override // d.b.g0.a.r1.h
    public void t(i.a aVar) {
        if (l) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f45729f.size());
        }
        if (aVar != null) {
            A(new a(aVar));
        }
    }

    public d.b.g0.l.l.f y() {
        if (this.j == null) {
            this.j = d();
        }
        return this.j;
    }

    public final void z() {
        if (this.k) {
            return;
        }
        y();
        d.b.g0.a.n1.b.c.E();
    }
}
