package d.a.m0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import d.a.m0.n.i.i.g.f;
import d.a.m0.n.i.i.g.g;
import d.a.m0.n.i.i.g.l;
import d.a.m0.n.i.l.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f51815a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f51816b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f51817c;

    /* renamed from: d  reason: collision with root package name */
    public f f51818d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f51819e = new AtomicBoolean(false);
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.n.i.i.g.b f51820f;

    /* renamed from: g  reason: collision with root package name */
    public final l f51821g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.m0.n.i.i.g.a f51822h;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.n.i.i.g.b {
        public a() {
        }

        @Override // d.a.m0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            b.this.f51818d = fVar;
        }

        @Override // d.a.m0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            if (b.this.f51818d == fVar) {
                b.this.f51818d = null;
            }
        }
    }

    /* renamed from: d.a.m0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1136b implements d.a.m0.n.i.i.g.a {
        public C1136b() {
        }

        @Override // d.a.m0.n.i.i.g.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f51820f = aVar;
        this.f51821g = new l(aVar);
        this.f51822h = new C1136b();
        this.f51815a = new c();
        this.f51816b = new LinkedBlockingQueue();
        this.f51817c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f51816b);
        c(this.f51815a);
    }

    public void c(d.a.m0.n.i.i.g.b bVar) {
        this.f51821g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f51815a != null) {
            if (z) {
                return this.f51815a.g();
            }
            return this.f51815a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f51818d == null) {
            return false;
        }
        Object f2 = this.f51818d.f();
        if (f2 instanceof d.a.m0.n.h.f) {
            d.a.m0.n.h.f fVar = (d.a.m0.n.h.f) f2;
            if (d.a.m0.n.c.f51766a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f51794g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f51794g, str);
        } else if (f2 instanceof a.C1137a) {
            a.C1137a c1137a = (a.C1137a) f2;
            if (d.a.m0.n.c.f51766a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1137a.f51864b + ", checking id: " + str);
            }
            return TextUtils.equals(c1137a.f51864b, str);
        } else {
            if (d.a.m0.n.c.f51766a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f51815a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.a.m0.n.h.f) {
                    d.a.m0.n.h.f fVar = (d.a.m0.n.h.f) f3;
                    if (d.a.m0.n.c.f51766a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f51794g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f51794g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1137a) {
                    a.C1137a c1137a = (a.C1137a) f3;
                    if (d.a.m0.n.c.f51766a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1137a.f51864b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1137a.f51864b, str)) {
                        return true;
                    }
                } else if (d.a.m0.n.c.f51766a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f51815a.h(fVar);
        if (d.a.m0.n.c.f51766a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f51815a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f51816b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.a.m0.n.i.i.g.b bVar) {
        this.f51821g.d(bVar);
    }

    public synchronized void j() {
        if (this.f51816b.size() < 1) {
            this.f51817c.execute(new g(this.f51819e, this.f51821g, this.f51822h));
        }
    }
}
