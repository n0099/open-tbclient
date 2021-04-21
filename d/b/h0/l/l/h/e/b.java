package d.b.h0.l.l.h.e;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.l.l.h.f.f;
import d.b.h0.l.l.h.f.g;
import d.b.h0.l.l.h.f.l;
import d.b.h0.l.l.j.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f49658a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f49659b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f49660c;

    /* renamed from: d  reason: collision with root package name */
    public f f49661d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f49662e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.l.l.h.f.b f49663f;

    /* renamed from: g  reason: collision with root package name */
    public l f49664g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.l.l.h.f.a f49665h;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.l.l.h.f.b {
        public a() {
        }

        @Override // d.b.h0.l.l.h.f.b
        public <T> void a(f<T> fVar) {
            b.this.f49661d = fVar;
        }

        @Override // d.b.h0.l.l.h.f.b
        public <T> void b(f<T> fVar) {
            if (b.this.f49661d == fVar) {
                b.this.f49661d = null;
            }
        }
    }

    /* renamed from: d.b.h0.l.l.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1051b implements d.b.h0.l.l.h.f.a {
        public C1051b() {
        }

        @Override // d.b.h0.l.l.h.f.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f49663f = aVar;
        this.f49664g = new l(aVar);
        this.f49665h = new C1051b();
        this.f49658a = new c();
        this.f49659b = new LinkedBlockingQueue();
        this.f49660c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f49659b);
        c(this.f49658a);
    }

    public void c(d.b.h0.l.l.h.f.b bVar) {
        this.f49664g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f49658a != null) {
            if (z) {
                return this.f49658a.g();
            }
            return this.f49658a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f49661d == null) {
            return false;
        }
        Object f2 = this.f49661d.f();
        if (f2 instanceof d.b.h0.l.k.f) {
            d.b.h0.l.k.f fVar = (d.b.h0.l.k.f) f2;
            if (d.b.h0.l.f.f49610a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f49644g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f49644g, str);
        } else if (f2 instanceof a.C1052a) {
            a.C1052a c1052a = (a.C1052a) f2;
            if (d.b.h0.l.f.f49610a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1052a.f49699b + ", checking id: " + str);
            }
            return TextUtils.equals(c1052a.f49699b, str);
        } else {
            if (d.b.h0.l.f.f49610a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f49658a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.b.h0.l.k.f) {
                    d.b.h0.l.k.f fVar = (d.b.h0.l.k.f) f3;
                    if (d.b.h0.l.f.f49610a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f49644g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f49644g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1052a) {
                    a.C1052a c1052a = (a.C1052a) f3;
                    if (d.b.h0.l.f.f49610a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1052a.f49699b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1052a.f49699b, str)) {
                        return true;
                    }
                } else if (d.b.h0.l.f.f49610a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f49658a.h(fVar);
        if (d.b.h0.l.f.f49610a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f49658a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f49659b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.b.h0.l.l.h.f.b bVar) {
        this.f49664g.d(bVar);
    }

    public synchronized void j() {
        if (this.f49659b.size() < 1) {
            this.f49660c.execute(new g(this.f49662e, this.f49664g, this.f49665h));
        }
    }
}
