package d.a.q.d.d;

import android.os.Bundle;
import com.baidu.helios.bridge.multiprocess.g;
import d.a.q.d.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b extends d.a.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile g f64207g;

    /* renamed from: h  reason: collision with root package name */
    public volatile d.a.q.d.c.a f64208h;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p = new Object();
    public Object q = new Object();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f64209i = true;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.f64208h = new d.a.q.d.c.a();
            b.this.f64208h.b(b.this.f64167e);
            b.this.f64208h.c(b.this.f64168f);
            b.this.j = true;
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.a.q.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1777b implements Callable<Boolean> {
        public CallableC1777b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b bVar = b.this;
            bVar.f64207g = new g(bVar, bVar.o);
            b.this.f64207g.b(b.this.f64167e);
            b.this.f64207g.c(b.this.f64168f);
            b.this.k = true;
            if (b.this.f64207g.n()) {
                b.this.n = true;
                return Boolean.TRUE;
            }
            b.this.n = false;
            b.this.f64209i = false;
            b.this.p();
            return Boolean.FALSE;
        }
    }

    public b(String str) {
        this.o = str;
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        if (this.f64209i) {
            s();
            if (this.n) {
                this.f64207g.a(str, bundle, cVar);
                return;
            }
        }
        m();
        this.f64208h.a(str, bundle, cVar);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        if (this.f64209i) {
            s();
            if (this.n) {
                return this.f64207g.d(str);
            }
        }
        m();
        return this.f64208h.d(str);
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        if (this.f64209i) {
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
        if (this.f64209i) {
            s();
            if (this.n) {
                a.d f2 = this.f64207g.f(str, bundle);
                if (f2.b()) {
                    return f2;
                }
                this.f64209i = false;
            }
        }
        m();
        return this.f64208h.f(str, bundle);
    }

    public void j() {
        this.f64209i = false;
        p();
    }

    public final void m() {
        if (this.f64209i || this.j) {
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
        this.m = this.f64167e.f64172d.submit(new a());
    }

    public final void s() {
        if (this.f64209i) {
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
        this.l = this.f64167e.f64172d.submit(new CallableC1777b());
    }
}
