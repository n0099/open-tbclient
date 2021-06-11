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
    public Runnable f69334c;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f69335d;

    /* renamed from: a  reason: collision with root package name */
    public int f69332a = 64;

    /* renamed from: b  reason: collision with root package name */
    public int f69333b = 5;

    /* renamed from: e  reason: collision with root package name */
    public final Deque<z.a> f69336e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    public final Deque<z.a> f69337f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Deque<z> f69338g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f69335d == null) {
            this.f69335d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), d.b.c.a.b.a.e.o("OkHttp Dispatcher", false));
        }
        return this.f69335d;
    }

    public void b(z.a aVar) {
        d(this.f69337f, aVar, true);
    }

    public synchronized void c(z zVar) {
        this.f69338g.add(zVar);
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
                runnable = this.f69334c;
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
        return this.f69337f.size() + this.f69338g.size();
    }

    public final int f(z.a aVar) {
        int i2 = 0;
        for (z.a aVar2 : this.f69337f) {
            if (aVar2.j().equals(aVar.j())) {
                i2++;
            }
        }
        return i2;
    }

    public void g(z zVar) {
        d(this.f69338g, zVar, false);
    }

    public final void h() {
        if (this.f69337f.size() < this.f69332a && !this.f69336e.isEmpty()) {
            Iterator<z.a> it = this.f69336e.iterator();
            while (it.hasNext()) {
                z.a next = it.next();
                if (f(next) < this.f69333b) {
                    it.remove();
                    this.f69337f.add(next);
                    a().execute(next);
                }
                if (this.f69337f.size() >= this.f69332a) {
                    return;
                }
            }
        }
    }
}
