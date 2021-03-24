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
    public static final int f67865g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f67866h;
    public static final C1880b i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67867e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1880b> f67868f = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.i f67869e = new h.o.d.i();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f67870f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.i f67871g;

        /* renamed from: h  reason: collision with root package name */
        public final c f67872h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1878a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67873e;

            public C1878a(h.n.a aVar) {
                this.f67873e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67873e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1879b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67875e;

            public C1879b(h.n.a aVar) {
                this.f67875e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67875e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f67870f = bVar;
            this.f67871g = new h.o.d.i(this.f67869e, bVar);
            this.f67872h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67872h.i(new C1878a(aVar), 0L, null, this.f67869e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67872h.j(new C1879b(aVar), j, timeUnit, this.f67870f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67871g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67871g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1880b {

        /* renamed from: a  reason: collision with root package name */
        public final int f67877a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f67878b;

        /* renamed from: c  reason: collision with root package name */
        public long f67879c;

        public C1880b(ThreadFactory threadFactory, int i) {
            this.f67877a = i;
            this.f67878b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f67878b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f67877a;
            if (i == 0) {
                return b.f67866h;
            }
            c[] cVarArr = this.f67878b;
            long j = this.f67879c;
            this.f67879c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f67878b) {
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
        f67865g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f67866h = cVar;
        cVar.unsubscribe();
        i = new C1880b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f67867e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f67868f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67868f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1880b c1880b;
        C1880b c1880b2;
        do {
            c1880b = this.f67868f.get();
            c1880b2 = i;
            if (c1880b == c1880b2) {
                return;
            }
        } while (!this.f67868f.compareAndSet(c1880b, c1880b2));
        c1880b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1880b c1880b = new C1880b(this.f67867e, f67865g);
        if (this.f67868f.compareAndSet(i, c1880b)) {
            return;
        }
        c1880b.b();
    }
}
