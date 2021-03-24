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
    public c f48936a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f48937b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f48938c;

    /* renamed from: d  reason: collision with root package name */
    public f f48939d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f48940e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.l.l.h.f.b f48941f;

    /* renamed from: g  reason: collision with root package name */
    public l f48942g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.l.l.h.f.a f48943h;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.l.l.h.f.b {
        public a() {
        }

        @Override // d.b.g0.l.l.h.f.b
        public <T> void a(f<T> fVar) {
            b.this.f48939d = fVar;
        }

        @Override // d.b.g0.l.l.h.f.b
        public <T> void b(f<T> fVar) {
            if (b.this.f48939d == fVar) {
                b.this.f48939d = null;
            }
        }
    }

    /* renamed from: d.b.g0.l.l.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1018b implements d.b.g0.l.l.h.f.a {
        public C1018b() {
        }

        @Override // d.b.g0.l.l.h.f.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f48941f = aVar;
        this.f48942g = new l(aVar);
        this.f48943h = new C1018b();
        this.f48936a = new c();
        this.f48937b = new LinkedBlockingQueue();
        this.f48938c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f48937b);
        c(this.f48936a);
    }

    public void c(d.b.g0.l.l.h.f.b bVar) {
        this.f48942g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f48936a != null) {
            if (z) {
                return this.f48936a.g();
            }
            return this.f48936a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f48939d == null) {
            return false;
        }
        Object f2 = this.f48939d.f();
        if (f2 instanceof d.b.g0.l.k.f) {
            d.b.g0.l.k.f fVar = (d.b.g0.l.k.f) f2;
            if (d.b.g0.l.f.f48888a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f48922g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f48922g, str);
        } else if (f2 instanceof a.C1019a) {
            a.C1019a c1019a = (a.C1019a) f2;
            if (d.b.g0.l.f.f48888a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1019a.f48977b + ", checking id: " + str);
            }
            return TextUtils.equals(c1019a.f48977b, str);
        } else {
            if (d.b.g0.l.f.f48888a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f48936a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.b.g0.l.k.f) {
                    d.b.g0.l.k.f fVar = (d.b.g0.l.k.f) f3;
                    if (d.b.g0.l.f.f48888a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f48922g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f48922g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1019a) {
                    a.C1019a c1019a = (a.C1019a) f3;
                    if (d.b.g0.l.f.f48888a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1019a.f48977b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1019a.f48977b, str)) {
                        return true;
                    }
                } else if (d.b.g0.l.f.f48888a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f48936a.h(fVar);
        if (d.b.g0.l.f.f48888a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f48936a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f48937b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.b.g0.l.l.h.f.b bVar) {
        this.f48942g.d(bVar);
    }

    public synchronized void j() {
        if (this.f48937b.size() < 1) {
            this.f48938c.execute(new g(this.f48940e, this.f48942g, this.f48943h));
        }
    }
}
