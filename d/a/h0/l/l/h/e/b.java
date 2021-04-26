package d.a.h0.l.l.h.e;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.l.l.h.f.f;
import d.a.h0.l.l.h.f.g;
import d.a.h0.l.l.h.f.l;
import d.a.h0.l.l.j.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f47168a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f47169b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f47170c;

    /* renamed from: d  reason: collision with root package name */
    public f f47171d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f47172e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.l.l.h.f.b f47173f;

    /* renamed from: g  reason: collision with root package name */
    public l f47174g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.l.l.h.f.a f47175h;

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.l.l.h.f.b {
        public a() {
        }

        @Override // d.a.h0.l.l.h.f.b
        public <T> void a(f<T> fVar) {
            b.this.f47171d = fVar;
        }

        @Override // d.a.h0.l.l.h.f.b
        public <T> void b(f<T> fVar) {
            if (b.this.f47171d == fVar) {
                b.this.f47171d = null;
            }
        }
    }

    /* renamed from: d.a.h0.l.l.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0990b implements d.a.h0.l.l.h.f.a {
        public C0990b() {
        }

        @Override // d.a.h0.l.l.h.f.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f47173f = aVar;
        this.f47174g = new l(aVar);
        this.f47175h = new C0990b();
        this.f47168a = new c();
        this.f47169b = new LinkedBlockingQueue();
        this.f47170c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f47169b);
        c(this.f47168a);
    }

    public void c(d.a.h0.l.l.h.f.b bVar) {
        this.f47174g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f47168a != null) {
            if (z) {
                return this.f47168a.g();
            }
            return this.f47168a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f47171d == null) {
            return false;
        }
        Object f2 = this.f47171d.f();
        if (f2 instanceof d.a.h0.l.k.f) {
            d.a.h0.l.k.f fVar = (d.a.h0.l.k.f) f2;
            if (d.a.h0.l.f.f47117a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f47153g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f47153g, str);
        } else if (f2 instanceof a.C0991a) {
            a.C0991a c0991a = (a.C0991a) f2;
            if (d.a.h0.l.f.f47117a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c0991a.f47211b + ", checking id: " + str);
            }
            return TextUtils.equals(c0991a.f47211b, str);
        } else {
            if (d.a.h0.l.f.f47117a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f47168a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.a.h0.l.k.f) {
                    d.a.h0.l.k.f fVar = (d.a.h0.l.k.f) f3;
                    if (d.a.h0.l.f.f47117a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f47153g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f47153g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C0991a) {
                    a.C0991a c0991a = (a.C0991a) f3;
                    if (d.a.h0.l.f.f47117a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c0991a.f47211b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c0991a.f47211b, str)) {
                        return true;
                    }
                } else if (d.a.h0.l.f.f47117a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f47168a.h(fVar);
        if (d.a.h0.l.f.f47117a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f47168a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f47169b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.a.h0.l.l.h.f.b bVar) {
        this.f47174g.d(bVar);
    }

    public synchronized void j() {
        if (this.f47169b.size() < 1) {
            this.f47170c.execute(new g(this.f47172e, this.f47174g, this.f47175h));
        }
    }
}
