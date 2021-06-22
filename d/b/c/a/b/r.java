package d.b.c.a.b;

import d.b.c.a.b.z;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class r {

    /* renamed from: c  reason: collision with root package name */
    public Runnable f69438c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f69439d;

    /* renamed from: a  reason: collision with root package name */
    public int f69436a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f69437b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f69440e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f69441f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f69442g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f69439d == null) {
            this.f69439d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.b.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f69439d;
    }

    public void b(z.a aVar) {
        d(this.f69441f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f69442g.add(zVar);
    }

    public final <T> void d(Deque<T> deque, T t, boolean z) {
        int e2;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    h();
                }
                e2 = e();
                runnable = this.f69438c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (e2 != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int e() {
        return this.f69441f.size() + this.f69442g.size();
    }

    public final int f(z.a aVar) {
        int i2 = 0;
        for (z.a aVar2 : this.f69441f) {
            if (aVar2.j().equals(aVar.j())) {
                i2++;
            }
        }
        return i2;
    }

    public void g(z zVar) {
        d(this.f69442g, zVar, false);
    }

    public final void h() {
        if (this.f69441f.size() < this.f69436a && !this.f69440e.isEmpty()) {
            Iterator<z.a> it = this.f69440e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f69437b) {
                    it.remove();
                    this.f69441f.add(next);
                    a().execute(next);
                }
                if (this.f69441f.size() >= this.f69436a) {
                    return;
                }
            }
        }
    }
}
