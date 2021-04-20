package d.b.p.d.d;

import android.os.Bundle;
import com.baidu.helios.bridge.multiprocess.g;
import d.b.p.d.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b extends d.b.p.d.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile g f64990g;

    /* renamed from: h  reason: collision with root package name */
    public volatile d.b.p.d.c.a f64991h;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p = new Object();
    public Object q = new Object();
    public volatile boolean i = true;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.f64991h = new d.b.p.d.c.a();
            b.this.f64991h.b(b.this.f64951e);
            b.this.f64991h.c(b.this.f64952f);
            b.this.j = true;
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.b.p.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1757b implements Callable<Boolean> {
        public CallableC1757b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b bVar = b.this;
            bVar.f64990g = new g(bVar, bVar.o);
            b.this.f64990g.b(b.this.f64951e);
            b.this.f64990g.c(b.this.f64952f);
            b.this.k = true;
            if (b.this.f64990g.n()) {
                b.this.n = true;
                return Boolean.TRUE;
            }
            b.this.n = false;
            b.this.i = false;
            b.this.p();
            return Boolean.FALSE;
        }
    }

    public b(String str) {
        this.o = str;
    }

    @Override // d.b.p.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        if (this.i) {
            s();
            if (this.n) {
                this.f64990g.a(str, bundle, cVar);
                return;
            }
        }
        m();
        this.f64991h.a(str, bundle, cVar);
    }

    @Override // d.b.p.d.a
    public boolean d(String str) {
        if (this.i) {
            s();
            if (this.n) {
                return this.f64990g.d(str);
            }
        }
        m();
        return this.f64991h.d(str);
    }

    @Override // d.b.p.d.a
    public void e(a.b bVar) {
        if (this.i) {
            synchronized (this.p) {
                v();
            }
            return;
        }
        synchronized (this.q) {
            p();
        }
    }

    @Override // d.b.p.d.a
    public a.d f(String str, Bundle bundle) {
        if (this.i) {
            s();
            if (this.n) {
                a.d f2 = this.f64990g.f(str, bundle);
                if (f2.b()) {
                    return f2;
                }
                this.i = false;
            }
        }
        m();
        return this.f64991h.f(str, bundle);
    }

    public void j() {
        this.i = false;
        p();
    }

    public final void m() {
        if (this.i || this.j) {
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
        this.m = this.f64951e.f64956d.submit(new a());
    }

    public final void s() {
        if (this.i) {
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
        this.l = this.f64951e.f64956d.submit(new CallableC1757b());
    }
}
