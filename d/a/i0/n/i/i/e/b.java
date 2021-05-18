package d.a.i0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import d.a.i0.n.i.i.g.f;
import d.a.i0.n.i.i.g.g;
import d.a.i0.n.i.i.g.l;
import d.a.i0.n.i.l.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f47857a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f47858b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f47859c;

    /* renamed from: d  reason: collision with root package name */
    public f f47860d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f47861e = new AtomicBoolean(false);
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final d.a.i0.n.i.i.g.b f47862f;

    /* renamed from: g  reason: collision with root package name */
    public final l f47863g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.n.i.i.g.a f47864h;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.n.i.i.g.b {
        public a() {
        }

        @Override // d.a.i0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            b.this.f47860d = fVar;
        }

        @Override // d.a.i0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            if (b.this.f47860d == fVar) {
                b.this.f47860d = null;
            }
        }
    }

    /* renamed from: d.a.i0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1066b implements d.a.i0.n.i.i.g.a {
        public C1066b() {
        }

        @Override // d.a.i0.n.i.i.g.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f47862f = aVar;
        this.f47863g = new l(aVar);
        this.f47864h = new C1066b();
        this.f47857a = new c();
        this.f47858b = new LinkedBlockingQueue();
        this.f47859c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f47858b);
        c(this.f47857a);
    }

    public void c(d.a.i0.n.i.i.g.b bVar) {
        this.f47863g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f47857a != null) {
            if (z) {
                return this.f47857a.g();
            }
            return this.f47857a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f47860d == null) {
            return false;
        }
        Object f2 = this.f47860d.f();
        if (f2 instanceof d.a.i0.n.h.f) {
            d.a.i0.n.h.f fVar = (d.a.i0.n.h.f) f2;
            if (d.a.i0.n.c.f47808a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f47836g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f47836g, str);
        } else if (f2 instanceof a.C1067a) {
            a.C1067a c1067a = (a.C1067a) f2;
            if (d.a.i0.n.c.f47808a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1067a.f47906b + ", checking id: " + str);
            }
            return TextUtils.equals(c1067a.f47906b, str);
        } else {
            if (d.a.i0.n.c.f47808a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f47857a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.a.i0.n.h.f) {
                    d.a.i0.n.h.f fVar = (d.a.i0.n.h.f) f3;
                    if (d.a.i0.n.c.f47808a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f47836g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f47836g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1067a) {
                    a.C1067a c1067a = (a.C1067a) f3;
                    if (d.a.i0.n.c.f47808a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1067a.f47906b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1067a.f47906b, str)) {
                        return true;
                    }
                } else if (d.a.i0.n.c.f47808a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f47857a.h(fVar);
        if (d.a.i0.n.c.f47808a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f47857a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f47858b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.a.i0.n.i.i.g.b bVar) {
        this.f47863g.d(bVar);
    }

    public synchronized void j() {
        if (this.f47858b.size() < 1) {
            this.f47859c.execute(new g(this.f47861e, this.f47863g, this.f47864h));
        }
    }
}
