package d.a.l0.a.a2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.i;
import d.a.l0.a.f1.e.f.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class d extends d.a.l0.a.a2.a {
    public static final boolean m = d.a.l0.a.k.f46875a;
    public static volatile d n;
    public static Handler o;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.p.a f44412e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<i.a>> f44413f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f44414g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f44415h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f44416i;
    public d.a.l0.n.i.g j;
    public d.a.l0.a.c2.f.g0.a k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f44417e;

        /* renamed from: d.a.l0.a.a2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0621a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.v2.e1.b f44419e;

            public RunnableC0621a(d.a.l0.a.v2.e1.b bVar) {
                this.f44419e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f44419e.onCallback(a.this.f44417e);
            }
        }

        public a(i.a aVar) {
            this.f44417e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            for (d.a.l0.a.v2.e1.b bVar : d.this.f44413f) {
                if (z && !this.f44417e.e("event_flag_force_post", false)) {
                    bVar.onCallback(this.f44417e);
                } else {
                    d.i().post(new RunnableC0621a(bVar));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44421e;

        public b(d.a.l0.a.v2.e1.b bVar) {
            this.f44421e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f44413f.add(this.f44421e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44423e;

        public c(d.a.l0.a.v2.e1.b bVar) {
            this.f44423e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f44413f.remove(this.f44423e);
        }
    }

    public d() {
        new c.a();
        this.f44413f = new HashSet();
        this.f44414g = 0;
        this.f44415h = new ArrayDeque();
        this.f44416i = null;
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
                    n = new d.a.l0.a.a2.c();
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

    @Override // d.a.l0.a.a2.h
    public void A(i.a aVar) {
        if (m) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f44413f.size());
        }
        if (aVar != null) {
            E(new a(aVar));
        }
    }

    @Override // d.a.l0.a.a2.h
    public d.a.l0.a.c2.f.g0.a B() {
        if (this.k == null) {
            this.k = f();
        }
        return this.k;
    }

    public final void D() {
        d.a.l0.a.c2.f.g0.a B = B();
        if (B != null) {
            B.f();
        }
    }

    public final synchronized void E(@NonNull Runnable runnable) {
        this.f44415h.offer(runnable);
        if (this.f44416i == null) {
            while (!this.f44415h.isEmpty()) {
                Runnable poll = this.f44415h.poll();
                this.f44416i = poll;
                if (poll != null) {
                    poll.run();
                }
                this.f44416i = null;
            }
        }
    }

    public abstract d.a.l0.n.i.g e();

    public abstract d.a.l0.a.c2.f.g0.a f();

    public d.a.l0.n.i.g j() {
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
        d.a.l0.a.v1.b.c.G();
        this.l = true;
    }

    @Override // d.a.l0.a.a2.h
    public void p(d.a.l0.a.v2.e1.b<i.a> bVar) {
        if (bVar != null) {
            E(new c(bVar));
        }
    }

    @Override // d.a.l0.a.a2.h
    public void q(String str) {
        w(str, null);
    }

    @Override // d.a.l0.a.a2.h
    public void v(d.a.l0.a.v2.e1.b<i.a> bVar) {
        if (bVar != null) {
            E(new b(bVar));
        }
    }

    @Override // d.a.l0.a.a2.h
    public void w(String str, Bundle bundle) {
        A(new i.a(str, bundle));
    }

    @Override // d.a.l0.a.a2.h
    public d.a.l0.a.p.a y() {
        if (this.f44412e == null) {
            this.f44412e = new d.a.l0.a.p.a();
        }
        return this.f44412e;
    }
}
