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
/* loaded from: classes6.dex */
public class j<R> implements a.c, DecodeJob.a<R> {

    /* renamed from: e  reason: collision with root package name */
    public static final c f35564e = new c();

    /* renamed from: a  reason: collision with root package name */
    public final e f35565a;

    /* renamed from: b  reason: collision with root package name */
    public DataSource f35566b;

    /* renamed from: c  reason: collision with root package name */
    public GlideException f35567c;

    /* renamed from: d  reason: collision with root package name */
    public n<?> f35568d;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f35569f;

    /* renamed from: g  reason: collision with root package name */
    public final Pools.Pool<j<?>> f35570g;

    /* renamed from: h  reason: collision with root package name */
    public final c f35571h;
    public final k i;
    public final com.kwad.sdk.glide.load.engine.b.a j;
    public final com.kwad.sdk.glide.load.engine.b.a k;
    public final com.kwad.sdk.glide.load.engine.b.a l;
    public final com.kwad.sdk.glide.load.engine.b.a m;
    public final AtomicInteger n;
    public com.kwad.sdk.glide.load.c o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public s<?> t;
    public boolean u;
    public boolean v;
    public DecodeJob<R> w;
    public volatile boolean x;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f35573b;

        public a(com.kwad.sdk.glide.request.g gVar) {
            this.f35573b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this) {
                if (j.this.f35565a.b(this.f35573b)) {
                    j.this.b(this.f35573b);
                }
                j.this.e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f35575b;

        public b(com.kwad.sdk.glide.request.g gVar) {
            this.f35575b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (j.this) {
                if (j.this.f35565a.b(this.f35575b)) {
                    j.this.f35568d.g();
                    j.this.a(this.f35575b);
                    j.this.c(this.f35575b);
                }
                j.this.e();
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class c {
        public <R> n<R> a(s<R> sVar, boolean z) {
            return new n<>(sVar, z, true);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final com.kwad.sdk.glide.request.g f35576a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f35577b;

        public d(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            this.f35576a = gVar;
            this.f35577b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f35576a.equals(((d) obj).f35576a);
            }
            return false;
        }

        public int hashCode() {
            return this.f35576a.hashCode();
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        public final List<d> f35578a;

        public e() {
            this(new ArrayList(2));
        }

        public e(List<d> list) {
            this.f35578a = list;
        }

        public static d c(com.kwad.sdk.glide.request.g gVar) {
            return new d(gVar, com.kwad.sdk.glide.g.e.b());
        }

        public void a(com.kwad.sdk.glide.request.g gVar) {
            this.f35578a.remove(c(gVar));
        }

        public void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
            this.f35578a.add(new d(gVar, executor));
        }

        public boolean a() {
            return this.f35578a.isEmpty();
        }

        public int b() {
            return this.f35578a.size();
        }

        public boolean b(com.kwad.sdk.glide.request.g gVar) {
            return this.f35578a.contains(c(gVar));
        }

        public void c() {
            this.f35578a.clear();
        }

        public e d() {
            return new e(new ArrayList(this.f35578a));
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f35578a.iterator();
        }
    }

    public j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, pool, f35564e);
    }

    @VisibleForTesting
    public j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool, c cVar) {
        this.f35565a = new e();
        this.f35569f = com.kwad.sdk.glide.g.a.c.a();
        this.n = new AtomicInteger();
        this.j = aVar;
        this.k = aVar2;
        this.l = aVar3;
        this.m = aVar4;
        this.i = kVar;
        this.f35570g = pool;
        this.f35571h = cVar;
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
        this.f35565a.c();
        this.o = null;
        this.f35568d = null;
        this.t = null;
        this.v = false;
        this.x = false;
        this.u = false;
        this.w.a(false);
        this.w = null;
        this.f35567c = null;
        this.f35566b = null;
        this.f35570g.release(this);
    }

    @VisibleForTesting
    public synchronized j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.o = cVar;
        this.p = z;
        this.q = z2;
        this.r = z3;
        this.s = z4;
        return this;
    }

    public synchronized void a(int i) {
        com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
        if (this.n.getAndAdd(i) == 0 && this.f35568d != null) {
            this.f35568d.g();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(GlideException glideException) {
        synchronized (this) {
            this.f35567c = glideException;
        }
        f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.glide.load.engine.s<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public void a(s<R> sVar, DataSource dataSource) {
        synchronized (this) {
            this.t = sVar;
            this.f35566b = dataSource;
        }
        c();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public synchronized void a(com.kwad.sdk.glide.request.g gVar) {
        try {
            gVar.a(this.f35568d, this.f35566b);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public synchronized void a(com.kwad.sdk.glide.request.g gVar, Executor executor) {
        Runnable aVar;
        this.f35569f.b();
        this.f35565a.a(gVar, executor);
        boolean z = true;
        if (this.u) {
            a(1);
            aVar = new b(gVar);
        } else if (this.v) {
            a(1);
            aVar = new a(gVar);
        } else {
            if (this.x) {
                z = false;
            }
            com.kwad.sdk.glide.g.j.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(aVar);
    }

    public boolean a() {
        return this.s;
    }

    public void b() {
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
    public synchronized void b(com.kwad.sdk.glide.request.g gVar) {
        try {
            gVar.a(this.f35567c);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    public void c() {
        synchronized (this) {
            this.f35569f.b();
            if (this.x) {
                this.t.d_();
                i();
            } else if (this.f35565a.a()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else {
                if (this.u) {
                    throw new IllegalStateException("Already have resource");
                }
                this.f35568d = this.f35571h.a(this.t, this.p);
                this.u = true;
                e d2 = this.f35565a.d();
                a(d2.b() + 1);
                this.i.a(this, this.o, this.f35568d);
                Iterator<d> it = d2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f35577b.execute(new b(next.f35576a));
                }
                e();
            }
        }
    }

    public synchronized void c(com.kwad.sdk.glide.request.g gVar) {
        boolean z;
        this.f35569f.b();
        this.f35565a.a(gVar);
        if (this.f35565a.a()) {
            b();
            if (!this.u && !this.v) {
                z = false;
                if (z && this.n.get() == 0) {
                    i();
                }
            }
            z = true;
            if (z) {
                i();
            }
        }
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        return this.f35569f;
    }

    public synchronized void e() {
        this.f35569f.b();
        com.kwad.sdk.glide.g.j.a(h(), "Not yet complete!");
        int decrementAndGet = this.n.decrementAndGet();
        com.kwad.sdk.glide.g.j.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.f35568d != null) {
                this.f35568d.h();
            }
            i();
        }
    }

    public void f() {
        synchronized (this) {
            this.f35569f.b();
            if (this.x) {
                i();
            } else if (this.f35565a.a()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else {
                if (this.v) {
                    throw new IllegalStateException("Already failed once");
                }
                this.v = true;
                com.kwad.sdk.glide.load.c cVar = this.o;
                e d2 = this.f35565a.d();
                a(d2.b() + 1);
                this.i.a(this, cVar, null);
                Iterator<d> it = d2.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    next.f35577b.execute(new a(next.f35576a));
                }
                e();
            }
        }
    }
}
