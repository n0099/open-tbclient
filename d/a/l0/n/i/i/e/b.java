package d.a.l0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.n.i.i.g.f;
import d.a.l0.n.i.i.g.g;
import d.a.l0.n.i.i.g.l;
import d.a.l0.n.i.l.a;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f51707a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f51708b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f51709c;

    /* renamed from: d  reason: collision with root package name */
    public f f51710d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f51711e = new AtomicBoolean(false);
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final d.a.l0.n.i.i.g.b f51712f;

    /* renamed from: g  reason: collision with root package name */
    public final l f51713g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.l0.n.i.i.g.a f51714h;

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.n.i.i.g.b {
        public a() {
        }

        @Override // d.a.l0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            b.this.f51710d = fVar;
        }

        @Override // d.a.l0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            if (b.this.f51710d == fVar) {
                b.this.f51710d = null;
            }
        }
    }

    /* renamed from: d.a.l0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1133b implements d.a.l0.n.i.i.g.a {
        public C1133b() {
        }

        @Override // d.a.l0.n.i.i.g.a
        public Runnable a(boolean z) {
            return b.this.d(z);
        }
    }

    public b() {
        a aVar = new a();
        this.f51712f = aVar;
        this.f51713g = new l(aVar);
        this.f51714h = new C1133b();
        this.f51707a = new c();
        this.f51708b = new LinkedBlockingQueue();
        this.f51709c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f51708b);
        c(this.f51707a);
    }

    public void c(d.a.l0.n.i.i.g.b bVar) {
        this.f51713g.c(bVar);
    }

    public synchronized Runnable d(boolean z) {
        if (this.f51707a != null) {
            if (z) {
                return this.f51707a.g();
            }
            return this.f51707a.i();
        }
        return null;
    }

    public synchronized boolean e(String str) {
        if (this.f51710d == null) {
            return false;
        }
        Object f2 = this.f51710d.f();
        if (f2 instanceof d.a.l0.n.h.f) {
            d.a.l0.n.h.f fVar = (d.a.l0.n.h.f) f2;
            if (d.a.l0.n.c.f51658a) {
                Log.v("PMSThreadQueue", "Current PMSPkgMain appId: " + fVar.f51686g + ", checking id: " + str);
            }
            return TextUtils.equals(fVar.f51686g, str);
        } else if (f2 instanceof a.C1134a) {
            a.C1134a c1134a = (a.C1134a) f2;
            if (d.a.l0.n.c.f51658a) {
                Log.v("PMSThreadQueue", "Current Item appId: " + c1134a.f51756b + ", checking id: " + str);
            }
            return TextUtils.equals(c1134a.f51756b, str);
        } else {
            if (d.a.l0.n.c.f51658a) {
                Log.v("PMSThreadQueue", "Current model type not match: " + f2.getClass().getSimpleName());
            }
            return false;
        }
    }

    public synchronized boolean f(String str) {
        Iterator<f> f2 = this.f51707a.f();
        while (f2.hasNext()) {
            f next = f2.next();
            if (next != null) {
                Object f3 = next.f();
                if (f3 instanceof d.a.l0.n.h.f) {
                    d.a.l0.n.h.f fVar = (d.a.l0.n.h.f) f3;
                    if (d.a.l0.n.c.f51658a) {
                        Log.v("PMSThreadQueue", "Queue PMSPkgMain appId: " + fVar.f51686g + ", checking id: " + str);
                    }
                    if (TextUtils.equals(fVar.f51686g, str)) {
                        return true;
                    }
                } else if (f3 instanceof a.C1134a) {
                    a.C1134a c1134a = (a.C1134a) f3;
                    if (d.a.l0.n.c.f51658a) {
                        Log.v("PMSThreadQueue", "Queue Item appId: " + c1134a.f51756b + ", checking id: " + str);
                    }
                    if (TextUtils.equals(c1134a.f51756b, str)) {
                        return true;
                    }
                } else if (d.a.l0.n.c.f51658a) {
                    Log.v("PMSThreadQueue", "Queue model type not match: " + f3.getClass().getSimpleName());
                }
            }
        }
        return false;
    }

    public synchronized <T> void g(f<T> fVar) {
        this.f51707a.h(fVar);
        if (d.a.l0.n.c.f51658a) {
            Log.d("PMSThreadQueue", "put Task:" + fVar);
            Log.d("PMSThreadQueue", "current WaitingQueue===>" + this.f51707a);
            Log.d("PMSThreadQueue", "current WorkingQueue===>" + this.f51708b);
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        g(fVar);
        j();
    }

    public void i(d.a.l0.n.i.i.g.b bVar) {
        this.f51713g.d(bVar);
    }

    public synchronized void j() {
        if (this.f51708b.size() < 1) {
            this.f51709c.execute(new g(this.f51711e, this.f51713g, this.f51714h));
        }
    }
}
