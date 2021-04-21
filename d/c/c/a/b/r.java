package d.c.c.a.b;

import d.c.c.a.b.z;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class r {

    /* renamed from: c  reason: collision with root package name */
    public Runnable f66483c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f66484d;

    /* renamed from: a  reason: collision with root package name */
    public int f66481a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f66482b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f66485e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f66486f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f66487g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f66484d == null) {
            this.f66484d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.c.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f66484d;
    }

    public void b(z.a aVar) {
        d(this.f66486f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f66487g.add(zVar);
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
                runnable = this.f66483c;
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
        return this.f66486f.size() + this.f66487g.size();
    }

    public final int f(z.a aVar) {
        int i = 0;
        for (z.a aVar2 : this.f66486f) {
            if (aVar2.j().equals(aVar.j())) {
                i++;
            }
        }
        return i;
    }

    public void g(z zVar) {
        d(this.f66487g, zVar, false);
    }

    public final void h() {
        if (this.f66486f.size() < this.f66481a && !this.f66485e.isEmpty()) {
            Iterator<z.a> it = this.f66485e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f66482b) {
                    it.remove();
                    this.f66486f.add(next);
                    a().execute(next);
                }
                if (this.f66486f.size() >= this.f66481a) {
                    return;
                }
            }
        }
    }
}
