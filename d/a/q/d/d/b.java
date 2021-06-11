package d.a.q.d.d;

import android.os.Bundle;
import com.baidu.helios.bridge.multiprocess.g;
import d.a.q.d.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class b extends d.a.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile g f67801g;

    /* renamed from: h  reason: collision with root package name */
    public volatile d.a.q.d.c.a f67802h;
    public volatile boolean k;
    public volatile Future<Boolean> l;
    public volatile Future<Boolean> m;
    public volatile boolean n;
    public String o;
    public Object p = new Object();
    public Object q = new Object();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f67803i = true;
    public volatile boolean j = false;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b.this.f67802h = new d.a.q.d.c.a();
            b.this.f67802h.b(b.this.f67761e);
            b.this.f67802h.c(b.this.f67762f);
            b.this.j = true;
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.a.q.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1838b implements Callable<Boolean> {
        public CallableC1838b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            b bVar = b.this;
            bVar.f67801g = new g(bVar, bVar.o);
            b.this.f67801g.b(b.this.f67761e);
            b.this.f67801g.c(b.this.f67762f);
            b.this.k = true;
            if (b.this.f67801g.n()) {
                b.this.n = true;
                return Boolean.TRUE;
            }
            b.this.n = false;
            b.this.f67803i = false;
            b.this.p();
            return Boolean.FALSE;
        }
    }

    public b(String str) {
        this.o = str;
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        if (this.f67803i) {
            s();
            if (this.n) {
                this.f67801g.a(str, bundle, cVar);
                return;
            }
        }
        m();
        this.f67802h.a(str, bundle, cVar);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        if (this.f67803i) {
            s();
            if (this.n) {
                return this.f67801g.d(str);
            }
        }
        m();
        return this.f67802h.d(str);
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        if (this.f67803i) {
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
        if (this.f67803i) {
            s();
            if (this.n) {
                a.d f2 = this.f67801g.f(str, bundle);
                if (f2.b()) {
                    return f2;
                }
                this.f67803i = false;
            }
        }
        m();
        return this.f67802h.f(str, bundle);
    }

    public void j() {
        this.f67803i = false;
        p();
    }

    public final void m() {
        if (this.f67803i || this.j) {
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
        this.m = this.f67761e.f67766d.submit(new a());
    }

    public final void s() {
        if (this.f67803i) {
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
        this.l = this.f67761e.f67766d.submit(new CallableC1838b());
    }
}
