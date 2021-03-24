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
    public Runnable f65542c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f65543d;

    /* renamed from: a  reason: collision with root package name */
    public int f65540a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f65541b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f65544e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f65545f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f65546g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f65543d == null) {
            this.f65543d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.c.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f65543d;
    }

    public void b(z.a aVar) {
        d(this.f65545f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f65546g.add(zVar);
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
                runnable = this.f65542c;
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
        return this.f65545f.size() + this.f65546g.size();
    }

    public final int f(z.a aVar) {
        int i = 0;
        for (z.a aVar2 : this.f65545f) {
            if (aVar2.j().equals(aVar.j())) {
                i++;
            }
        }
        return i;
    }

    public void g(z zVar) {
        d(this.f65546g, zVar, false);
    }

    public final void h() {
        if (this.f65545f.size() < this.f65540a && !this.f65544e.isEmpty()) {
            Iterator<z.a> it = this.f65544e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f65541b) {
                    it.remove();
                    this.f65545f.add(next);
                    a().execute(next);
                }
                if (this.f65545f.size() >= this.f65540a) {
                    return;
                }
            }
        }
    }
}
