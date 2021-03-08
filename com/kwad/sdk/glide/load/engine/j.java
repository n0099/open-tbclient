package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
class j<R> implements a.c, DecodeJob.a<R> {
    private static final c e = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f6763a;
    DataSource b;
    GlideException c;
    n<?> d;
    private final com.kwad.sdk.glide.g.a.c f;
    private final Pools.Pool<j<?>> g;
    private final c h;
    private final k i;
    private final com.kwad.sdk.glide.load.engine.b.a j;
    private final com.kwad.sdk.glide.load.engine.b.a k;
    private final com.kwad.sdk.glide.load.engine.b.a l;
    private final com.kwad.sdk.glide.load.engine.b.a m;
    private final AtomicInteger n;
    private com.kwad.sdk.glide.load.c o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private s<?> t;
    private boolean u;
    private boolean v;
    private DecodeJob<R> w;
    private volatile boolean x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private final com.kwad.sdk.glide.request.g b;

        a(com.kwad.sdk.glide.request.g gVar) {
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this) {
                if (j.this.f6763a.b(this.b)) {
                    j.this.b(this.b);
                }
                j.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private final com.kwad.sdk.glide.request.g b;

        b(com.kwad.sdk.glide.request.g gVar) {
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this) {
                if (j.this.f6763a.b(this.b)) {
                    j.this.d.g();
                    j.this.a(this.b);
                    j.this.c(this.b);
                }
                j.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class c {
        c() {
        }

        public <R> n<R> a(s<R> sVar, boolean z) {
            return new n<>(sVar, z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final com.kwad.sdk.glide.request.g f6766a;
        final Executor b;

        d(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            this.f6766a = gVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f6766a.equals(((d) obj).f6766a);
            }
            return false;
        }

        public int hashCode() {
            return this.f6766a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f6767a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> list) {
            this.f6767a = list;
        }

        private static d c(com.kwad.sdk.glide.request.g gVar) {
            return new d(gVar, com.kwad.sdk.glide.g.e.b());
        }

        void a(com.kwad.sdk.glide.request.g gVar) {
            this.f6767a.remove(c(gVar));
        }

        void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            this.f6767a.add(new d(gVar, executor));
        }

        boolean a() {
            return this.f6767a.isEmpty();
        }

        int b() {
            return this.f6767a.size();
        }

        boolean b(com.kwad.sdk.glide.request.g gVar) {
            return this.f6767a.contains(c(gVar));
        }

        void c() {
            this.f6767a.clear();
        }

        e d() {
            return new e(new ArrayList(this.f6767a));
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f6767a.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, pool, e);
    }

    @VisibleForTesting
    j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool, c cVar) {
        this.f6763a = new e();
        this.f = com.kwad.sdk.glide.g.a.c.a();
        this.n = new AtomicInteger();
        this.j = aVar;
        this.k = aVar2;
        this.l = aVar3;
        this.m = aVar4;
        this.i = kVar;
        this.g = pool;
        this.h = cVar;
    }

    private com.kwad.sdk.glide.load.engine.b.a g() {
        return this.q ? this.l : this.r ? this.m : this.k;
    }

    private boolean h() {
        return this.v || this.u || this.x;
    }

    private synchronized void i() {
        if (this.o == null) {
            throw new IllegalArgumentException();
        }
        this.f6763a.c();
        this.o = null;
        this.d = null;
        this.t = null;
        this.v = false;
        this.x = false;
        this.u = false;
        this.w.a(false);
        this.w = null;
        this.c = null;
        this.b = null;
        this.g.release(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.o = cVar;
        this.p = z;
        this.q = z2;
        this.r = z3;
        this.s = z4;
        return this;
    }

    synchronized void a(int i) {
        com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
        if (this.n.getAndAdd(i) == 0 && this.d != null) {
            this.d.g();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(GlideException glideException) {
        synchronized (this) {
            this.c = glideException;
        }
        f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.kwad.sdk.glide.load.engine.s<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(s<R> sVar, DataSource dataSource) {
        synchronized (this) {
            this.t = sVar;
            this.b = dataSource;
        }
        c();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    synchronized void a(com.kwad.sdk.glide.request.g gVar) {
        try {
            gVar.a(this.d, this.b);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
        synchronized (this) {
            this.f.b();
            this.f6763a.a(gVar, executor);
            if (this.u) {
                a(1);
                executor.execute(new b(gVar));
            } else if (this.v) {
                a(1);
                executor.execute(new a(gVar));
            } else {
                com.kwad.sdk.glide.g.j.a(this.x ? false : true, "Cannot add callbacks to a cancelled EngineJob");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.s;
    }

    void b() {
        if (h()) {
            return;
        }
        this.x = true;
        this.w.b();
        this.i.a(this, this.o);
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        this.w = decodeJob;
        (decodeJob.a() ? this.j : g()).execute(decodeJob);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    synchronized void b(com.kwad.sdk.glide.request.g gVar) {
        try {
            gVar.a(this.c);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void c() {
        synchronized (this) {
            this.f.b();
            if (this.x) {
                this.t.d_();
                i();
            } else if (this.f6763a.a()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else {
                if (this.u) {
                    throw new IllegalStateException("Already have resource");
                }
                this.d = this.h.a(this.t, this.p);
                this.u = true;
                e d2 = this.f6763a.d();
                a(d2.b() + 1);
                this.i.a(this, this.o, this.d);
                Iterator<d> it = d2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.b.execute(new b(next.f6766a));
                }
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(com.kwad.sdk.glide.request.g gVar) {
        this.f.b();
        this.f6763a.a(gVar);
        if (this.f6763a.a()) {
            b();
            if ((this.u || this.v) && this.n.get() == 0) {
                i();
            }
        }
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f;
    }

    synchronized void e() {
        this.f.b();
        com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
        int decrementAndGet = this.n.decrementAndGet();
        com.kwad.sdk.glide.g.j.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.d != null) {
                this.d.h();
            }
            i();
        }
    }

    void f() {
        synchronized (this) {
            this.f.b();
            if (this.x) {
                i();
            } else if (this.f6763a.a()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else {
                if (this.v) {
                    throw new IllegalStateException("Already failed once");
                }
                this.v = true;
                com.kwad.sdk.glide.load.c cVar = this.o;
                e d2 = this.f6763a.d();
                a(d2.b() + 1);
                this.i.a(this, cVar, null);
                Iterator<d> it = d2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.b.execute(new a(next.f6766a));
                }
                e();
            }
        }
    }
}
