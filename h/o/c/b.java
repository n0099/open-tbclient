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
    public static final int f67882g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f67883h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1867b f67884i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67885e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1867b> f67886f = new AtomicReference<>(f67884i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f67887e = new h.o.d.h();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f67888f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f67889g;

        /* renamed from: h  reason: collision with root package name */
        public final c f67890h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1865a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67891e;

            public C1865a(h.n.a aVar) {
                this.f67891e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67891e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1866b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67893e;

            public C1866b(h.n.a aVar) {
                this.f67893e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67893e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f67888f = bVar;
            this.f67889g = new h.o.d.h(this.f67887e, bVar);
            this.f67890h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67890h.i(new C1865a(aVar), 0L, null, this.f67887e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67890h.j(new C1866b(aVar), j, timeUnit, this.f67888f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67889g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67889g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1867b {

        /* renamed from: a  reason: collision with root package name */
        public final int f67895a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f67896b;

        /* renamed from: c  reason: collision with root package name */
        public long f67897c;

        public C1867b(ThreadFactory threadFactory, int i2) {
            this.f67895a = i2;
            this.f67896b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f67896b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f67895a;
            if (i2 == 0) {
                return b.f67883h;
            }
            c[] cVarArr = this.f67896b;
            long j = this.f67897c;
            this.f67897c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f67896b) {
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
        f67882g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f67883h = cVar;
        cVar.unsubscribe();
        f67884i = new C1867b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f67885e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f67886f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67886f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1867b c1867b;
        C1867b c1867b2;
        do {
            c1867b = this.f67886f.get();
            c1867b2 = f67884i;
            if (c1867b == c1867b2) {
                return;
            }
        } while (!this.f67886f.compareAndSet(c1867b, c1867b2));
        c1867b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1867b c1867b = new C1867b(this.f67885e, f67882g);
        if (this.f67886f.compareAndSet(f67884i, c1867b)) {
            return;
        }
        c1867b.b();
    }
}
