package d.a.q.d.d;

import android.os.Bundle;
import com.baidu.helios.bridge.multiprocess.g;
import d.a.q.d.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b extends d.a.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile g f64083g;

    /* renamed from: h  reason: collision with root package name */
    public volatile d.a.q.d.c.a f64084h;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p = new Object();
    public Object q = new Object();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f64085i = true;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.f64084h = new d.a.q.d.c.a();
            b.this.f64084h.b(b.this.f64043e);
            b.this.f64084h.c(b.this.f64044f);
            b.this.j = true;
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.a.q.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1780b implements Callable<Boolean> {
        public CallableC1780b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b bVar = b.this;
            bVar.f64083g = new g(bVar, bVar.o);
            b.this.f64083g.b(b.this.f64043e);
            b.this.f64083g.c(b.this.f64044f);
            b.this.k = true;
            if (b.this.f64083g.n()) {
                b.this.n = true;
                return Boolean.TRUE;
            }
            b.this.n = false;
            b.this.f64085i = false;
            b.this.p();
            return Boolean.FALSE;
        }
    }

    public b(String str) {
        this.o = str;
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        if (this.f64085i) {
            s();
            if (this.n) {
                this.f64083g.a(str, bundle, cVar);
                return;
            }
        }
        m();
        this.f64084h.a(str, bundle, cVar);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        if (this.f64085i) {
            s();
            if (this.n) {
                return this.f64083g.d(str);
            }
        }
        m();
        return this.f64084h.d(str);
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        if (this.f64085i) {
            synchronized (this.p) {
                v();
            }
            return;
        }
        synchronized (this.q) {
            p();
        }
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        if (this.f64085i) {
            s();
            if (this.n) {
                a.d f2 = this.f64083g.f(str, bundle);
                if (f2.b()) {
                    return f2;
                }
                this.f64085i = false;
            }
        }
        m();
        return this.f64084h.f(str, bundle);
    }

    public void j() {
        this.f64085i = false;
        p();
    }

    public final void m() {
        if (this.f64085i || this.j) {
            return;
        }
        synchronized (this.q) {
            p();
        }
        try {
            this.m.get();
        } catch (Exception unused) {
        }
    }

    public final void p() {
        if (this.j || this.m != null) {
            return;
        }
        this.m = this.f64043e.f64048d.submit(new a());
    }

    public final void s() {
        if (this.f64085i) {
            if (!this.k) {
                synchronized (this.p) {
                    v();
                }
            }
            try {
                this.l.get();
            } catch (Exception unused) {
            }
        }
    }

    public final void v() {
        if (this.k || this.l != null) {
            return;
        }
        this.l = this.f64043e.f64048d.submit(new CallableC1780b());
    }
}
