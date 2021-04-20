package d.b.g0.l.l.h.e;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.l.l.h.f.f;
import d.b.g0.l.l.h.f.g;
import d.b.g0.l.l.h.f.l;
import d.b.g0.l.l.j.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f49329a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f49330b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f49331c;

    /* renamed from: d  reason: collision with root package name */
    public f f49332d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f49333e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.l.l.h.f.b f49334f;

    /* renamed from: g  reason: collision with root package name */
    public l f49335g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.l.l.h.f.a f49336h;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.l.l.h.f.b {
        public a() {
        }

        @Override // d.b.g0.l.l.h.f.b
        public <T> void a(f<T> fVar) {
            b.this.f49332d = fVar;
        }

        @Override // d.b.g0.l.l.h.f.b
        public <T> void b(f<T> fVar) {
            if (b.this.f49332d == fVar) {
                b.this.f49332d = null;
            }
        }
    }

    /* renamed from: d.b.g0.l.l.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1031b implements d.b.g0.l.l.h.f.a {
        public C1031b() {
        }

        @Override // d.b.g0.l.l.h.f.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f49334f = aVar;
        this.f49335g = new l(aVar);
        this.f49336h = new C1031b();
        this.f49329a = new c();
        this.f49330b = new LinkedBlockingQueue();
        this.f49331c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f49330b);
        c(this.f49329a);
    }

    public void c(d.b.g0.l.l.h.f.b bVar) {
        this.f49335g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f49329a != null) {
            if (z) {
                return this.f49329a.g();
            }
            return this.f49329a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f49332d == null) {
            return false;
        }
        Object f2 = this.f49332d.f();
        if (f2 instanceof d.b.g0.l.k.f) {
            d.b.g0.l.k.f fVar = (d.b.g0.l.k.f) f2;
            if (d.b.g0.l.f.f49281a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f49315g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f49315g, str);
        } else if (f2 instanceof a.C1032a) {
            a.C1032a c1032a = (a.C1032a) f2;
            if (d.b.g0.l.f.f49281a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1032a.f49370b + ", checking id: " + str);
            }
            return TextUtils.equals(c1032a.f49370b, str);
        } else {
            if (d.b.g0.l.f.f49281a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f49329a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.b.g0.l.k.f) {
                    d.b.g0.l.k.f fVar = (d.b.g0.l.k.f) f3;
                    if (d.b.g0.l.f.f49281a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f49315g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f49315g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1032a) {
                    a.C1032a c1032a = (a.C1032a) f3;
                    if (d.b.g0.l.f.f49281a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1032a.f49370b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1032a.f49370b, str)) {
                        return true;
                    }
                } else if (d.b.g0.l.f.f49281a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f49329a.h(fVar);
        if (d.b.g0.l.f.f49281a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f49329a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f49330b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.b.g0.l.l.h.f.b bVar) {
        this.f49335g.d(bVar);
    }

    public synchronized void j() {
        if (this.f49330b.size() < 1) {
            this.f49331c.execute(new g(this.f49333e, this.f49335g, this.f49336h));
        }
    }
}
