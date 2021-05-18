package d.a.i0.a.a2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.i0.a.a2.i;
import d.a.i0.a.f1.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class d extends d.a.i0.a.a2.a {
    public static final boolean m = d.a.i0.a.k.f43025a;
    public static volatile d n;
    public static Handler o;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.p.a f40562e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.i0.a.v2.e1.b<i.a>> f40563f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f40564g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f40565h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f40566i;
    public d.a.i0.n.i.g j;
    public d.a.i0.a.c2.f.g0.a k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f40567e;

        /* renamed from: d.a.i0.a.a2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0554a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.v2.e1.b f40569e;

            public RunnableC0554a(d.a.i0.a.v2.e1.b bVar) {
                this.f40569e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f40569e.onCallback(a.this.f40567e);
            }
        }

        public a(i.a aVar) {
            this.f40567e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            for (d.a.i0.a.v2.e1.b bVar : d.this.f40563f) {
                if (z && !this.f40567e.e("event_flag_force_post", false)) {
                    bVar.onCallback(this.f40567e);
                } else {
                    d.i().post(new RunnableC0554a(bVar));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f40571e;

        public b(d.a.i0.a.v2.e1.b bVar) {
            this.f40571e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f40563f.add(this.f40571e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f40573e;

        public c(d.a.i0.a.v2.e1.b bVar) {
            this.f40573e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f40563f.remove(this.f40573e);
        }
    }

    public d() {
        new c.a();
        this.f40563f = new HashSet();
        this.f40564g = 0;
        this.f40565h = new ArrayDeque();
        this.f40566i = null;
        this.l = false;
    }

    public static d g() {
        d h2 = h();
        if (!h2.l) {
            h2.k();
        }
        return h2;
    }

    public static d h() {
        if (n instanceof j) {
            return n;
        }
        synchronized (d.class) {
            if (n instanceof j) {
                return n;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                n = new j();
                return n;
            } else if (current.isSwanService) {
                if (!(n instanceof l)) {
                    n = new l();
                }
                return n;
            } else {
                if (n == null) {
                    n = new d.a.i0.a.a2.c();
                }
                return n;
            }
        }
    }

    public static Handler i() {
        if (o == null) {
            o = new Handler(Looper.getMainLooper());
        }
        return o;
    }

    @Override // d.a.i0.a.a2.h
    public void A(i.a aVar) {
        if (m) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f40563f.size());
        }
        if (aVar != null) {
            E(new a(aVar));
        }
    }

    @Override // d.a.i0.a.a2.h
    public d.a.i0.a.c2.f.g0.a B() {
        if (this.k == null) {
            this.k = f();
        }
        return this.k;
    }

    public final void D() {
        d.a.i0.a.c2.f.g0.a B = B();
        if (B != null) {
            B.f();
        }
    }

    public final synchronized void E(@NonNull Runnable runnable) {
        this.f40565h.offer(runnable);
        if (this.f40566i == null) {
            while (!this.f40565h.isEmpty()) {
                Runnable poll = this.f40565h.poll();
                this.f40566i = poll;
                if (poll != null) {
                    poll.run();
                }
                this.f40566i = null;
            }
        }
    }

    public abstract d.a.i0.n.i.g e();

    public abstract d.a.i0.a.c2.f.g0.a f();

    public d.a.i0.n.i.g j() {
        if (this.j == null) {
            this.j = e();
        }
        return this.j;
    }

    public final void k() {
        if (this.l) {
            return;
        }
        D();
        j();
        d.a.i0.a.v1.b.c.G();
        this.l = true;
    }

    @Override // d.a.i0.a.a2.h
    public void p(d.a.i0.a.v2.e1.b<i.a> bVar) {
        if (bVar != null) {
            E(new c(bVar));
        }
    }

    @Override // d.a.i0.a.a2.h
    public void q(String str) {
        w(str, null);
    }

    @Override // d.a.i0.a.a2.h
    public void v(d.a.i0.a.v2.e1.b<i.a> bVar) {
        if (bVar != null) {
            E(new b(bVar));
        }
    }

    @Override // d.a.i0.a.a2.h
    public void w(String str, Bundle bundle) {
        A(new i.a(str, bundle));
    }

    @Override // d.a.i0.a.a2.h
    public d.a.i0.a.p.a y() {
        if (this.f40562e == null) {
            this.f40562e = new d.a.i0.a.p.a();
        }
        return this.f40562e;
    }
}
