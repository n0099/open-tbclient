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
    public Runnable f66388c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f66389d;

    /* renamed from: a  reason: collision with root package name */
    public int f66386a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f66387b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f66390e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f66391f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f66392g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f66389d == null) {
            this.f66389d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.c.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f66389d;
    }

    public void b(z.a aVar) {
        d(this.f66391f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f66392g.add(zVar);
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
                runnable = this.f66388c;
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
        return this.f66391f.size() + this.f66392g.size();
    }

    public final int f(z.a aVar) {
        int i = 0;
        for (z.a aVar2 : this.f66391f) {
            if (aVar2.j().equals(aVar.j())) {
                i++;
            }
        }
        return i;
    }

    public void g(z zVar) {
        d(this.f66392g, zVar, false);
    }

    public final void h() {
        if (this.f66391f.size() < this.f66386a && !this.f66390e.isEmpty()) {
            Iterator<z.a> it = this.f66390e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f66387b) {
                    it.remove();
                    this.f66391f.add(next);
                    a().execute(next);
                }
                if (this.f66391f.size() >= this.f66386a) {
                    return;
                }
            }
        }
    }
}
