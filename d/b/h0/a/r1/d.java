package d.b.h0.a.r1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.h0.a.r1.i;
import d.b.h0.a.y0.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class d extends d.b.h0.a.r1.a {
    public static final boolean l = d.b.h0.a.k.f45772a;
    public static d m;
    public static Handler n;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.a.p.a f46449e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.b.h0.a.i2.u0.b<i.a>> f46450f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f46451g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f46452h;
    public Runnable i;
    public d.b.h0.l.l.f j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f46453e;

        /* renamed from: d.b.h0.a.r1.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0810a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.i2.u0.b f46455e;

            public RunnableC0810a(d.b.h0.a.i2.u0.b bVar) {
                this.f46455e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f46455e.onCallback(a.this.f46453e);
            }
        }

        public a(i.a aVar) {
            this.f46453e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            for (d.b.h0.a.i2.u0.b bVar : d.this.f46450f) {
                if (z && !this.f46453e.d("event_flag_force_post", false)) {
                    bVar.onCallback(this.f46453e);
                } else {
                    d.g().post(new RunnableC0810a(bVar));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f46457e;

        public b(d.b.h0.a.i2.u0.b bVar) {
            this.f46457e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46450f.add(this.f46457e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f46459e;

        public c(d.b.h0.a.i2.u0.b bVar) {
            this.f46459e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46450f.remove(this.f46459e);
        }
    }

    public d() {
        new c.a();
        this.f46450f = new HashSet();
        this.f46451g = 0;
        this.f46452h = new ArrayDeque();
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
                    m = new d.b.h0.a.r1.c();
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
        this.f46452h.offer(runnable);
        if (this.i == null) {
            while (!this.f46452h.isEmpty()) {
                Runnable poll = this.f46452h.poll();
                this.i = poll;
                if (poll != null) {
                    poll.run();
                }
                this.i = null;
            }
        }
    }

    public abstract d.b.h0.l.l.f d();

    @Override // d.b.h0.a.r1.h
    public void i(d.b.h0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new b(bVar));
        }
    }

    @Override // d.b.h0.a.r1.h
    public void l(String str, Bundle bundle) {
        t(new i.a(str, bundle));
    }

    @Override // d.b.h0.a.r1.h
    public d.b.h0.a.p.a o() {
        if (this.f46449e == null) {
            this.f46449e = new d.b.h0.a.p.a();
        }
        return this.f46449e;
    }

    @Override // d.b.h0.a.r1.h
    public void p(d.b.h0.a.i2.u0.b<i.a> bVar) {
        if (bVar != null) {
            A(new c(bVar));
        }
    }

    @Override // d.b.h0.a.r1.h
    public void r(String str) {
        l(str, null);
    }

    @Override // d.b.h0.a.r1.h
    public void t(i.a aVar) {
        if (l) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f46450f.size());
        }
        if (aVar != null) {
            A(new a(aVar));
        }
    }

    public d.b.h0.l.l.f y() {
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
        d.b.h0.a.n1.b.c.E();
    }
}
