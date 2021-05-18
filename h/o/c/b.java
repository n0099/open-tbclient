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
    public static final int f68562g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f68563h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1930b f68564i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68565e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1930b> f68566f = new AtomicReference<>(f68564i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f68567e = new h.o.d.h();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f68568f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f68569g;

        /* renamed from: h  reason: collision with root package name */
        public final c f68570h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1928a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68571e;

            public C1928a(h.n.a aVar) {
                this.f68571e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68571e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1929b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68573e;

            public C1929b(h.n.a aVar) {
                this.f68573e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68573e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f68568f = bVar;
            this.f68569g = new h.o.d.h(this.f68567e, bVar);
            this.f68570h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68570h.i(new C1928a(aVar), 0L, null, this.f68567e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68570h.j(new C1929b(aVar), j, timeUnit, this.f68568f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68569g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68569g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1930b {

        /* renamed from: a  reason: collision with root package name */
        public final int f68575a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f68576b;

        /* renamed from: c  reason: collision with root package name */
        public long f68577c;

        public C1930b(ThreadFactory threadFactory, int i2) {
            this.f68575a = i2;
            this.f68576b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f68576b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f68575a;
            if (i2 == 0) {
                return b.f68563h;
            }
            c[] cVarArr = this.f68576b;
            long j = this.f68577c;
            this.f68577c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f68576b) {
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
        f68562g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f68563h = cVar;
        cVar.unsubscribe();
        f68564i = new C1930b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f68565e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f68566f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68566f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1930b c1930b;
        C1930b c1930b2;
        do {
            c1930b = this.f68566f.get();
            c1930b2 = f68564i;
            if (c1930b == c1930b2) {
                return;
            }
        } while (!this.f68566f.compareAndSet(c1930b, c1930b2));
        c1930b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1930b c1930b = new C1930b(this.f68565e, f68562g);
        if (this.f68566f.compareAndSet(f68564i, c1930b)) {
            return;
        }
        c1930b.b();
    }
}
