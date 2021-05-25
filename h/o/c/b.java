package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes7.dex */
public final class b extends h.g implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final int f68605g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f68606h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1934b f68607i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68608e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1934b> f68609f = new AtomicReference<>(f68607i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f68610e = new h.o.d.h();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f68611f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f68612g;

        /* renamed from: h  reason: collision with root package name */
        public final c f68613h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1932a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68614e;

            public C1932a(h.n.a aVar) {
                this.f68614e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68614e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1933b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68616e;

            public C1933b(h.n.a aVar) {
                this.f68616e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68616e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f68611f = bVar;
            this.f68612g = new h.o.d.h(this.f68610e, bVar);
            this.f68613h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68613h.i(new C1932a(aVar), 0L, null, this.f68610e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68613h.j(new C1933b(aVar), j, timeUnit, this.f68611f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68612g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68612g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1934b {

        /* renamed from: a  reason: collision with root package name */
        public final int f68618a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f68619b;

        /* renamed from: c  reason: collision with root package name */
        public long f68620c;

        public C1934b(ThreadFactory threadFactory, int i2) {
            this.f68618a = i2;
            this.f68619b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f68619b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f68618a;
            if (i2 == 0) {
                return b.f68606h;
            }
            c[] cVarArr = this.f68619b;
            long j = this.f68620c;
            this.f68620c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f68619b) {
                cVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends g {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f68605g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f68606h = cVar;
        cVar.unsubscribe();
        f68607i = new C1934b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f68608e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f68609f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68609f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1934b c1934b;
        C1934b c1934b2;
        do {
            c1934b = this.f68609f.get();
            c1934b2 = f68607i;
            if (c1934b == c1934b2) {
                return;
            }
        } while (!this.f68609f.compareAndSet(c1934b, c1934b2));
        c1934b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1934b c1934b = new C1934b(this.f68608e, f68605g);
        if (this.f68609f.compareAndSet(f68607i, c1934b)) {
            return;
        }
        c1934b.b();
    }
}
