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
    public Runnable f65603c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f65604d;

    /* renamed from: a  reason: collision with root package name */
    public int f65601a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f65602b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f65605e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f65606f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f65607g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f65604d == null) {
            this.f65604d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.b.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f65604d;
    }

    public void b(z.a aVar) {
        d(this.f65606f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f65607g.add(zVar);
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
                runnable = this.f65603c;
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
        return this.f65606f.size() + this.f65607g.size();
    }

    public final int f(z.a aVar) {
        int i2 = 0;
        for (z.a aVar2 : this.f65606f) {
            if (aVar2.j().equals(aVar.j())) {
                i2++;
            }
        }
        return i2;
    }

    public void g(z zVar) {
        d(this.f65607g, zVar, false);
    }

    public final void h() {
        if (this.f65606f.size() < this.f65601a && !this.f65605e.isEmpty()) {
            Iterator<z.a> it = this.f65605e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f65602b) {
                    it.remove();
                    this.f65606f.add(next);
                    a().execute(next);
                }
                if (this.f65606f.size() >= this.f65601a) {
                    return;
                }
            }
        }
    }
}
