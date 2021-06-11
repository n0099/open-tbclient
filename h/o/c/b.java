package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes8.dex */
public final class b extends h.g implements h {

    /* renamed from: g  reason: collision with root package name */
    public static final int f71861g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f71862h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1983b f71863i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f71864e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1983b> f71865f = new AtomicReference<>(f71863i);

    /* loaded from: classes8.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f71866e = new h.o.d.h();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f71867f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f71868g;

        /* renamed from: h  reason: collision with root package name */
        public final c f71869h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1981a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71870e;

            public C1981a(h.n.a aVar) {
                this.f71870e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f71870e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1982b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71872e;

            public C1982b(h.n.a aVar) {
                this.f71872e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f71872e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f71867f = bVar;
            this.f71868g = new h.o.d.h(this.f71866e, bVar);
            this.f71869h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f71869h.i(new C1981a(aVar), 0L, null, this.f71866e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f71869h.j(new C1982b(aVar), j, timeUnit, this.f71867f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71868g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71868g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1983b {

        /* renamed from: a  reason: collision with root package name */
        public final int f71874a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f71875b;

        /* renamed from: c  reason: collision with root package name */
        public long f71876c;

        public C1983b(ThreadFactory threadFactory, int i2) {
            this.f71874a = i2;
            this.f71875b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f71875b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f71874a;
            if (i2 == 0) {
                return b.f71862h;
            }
            c[] cVarArr = this.f71875b;
            long j = this.f71876c;
            this.f71876c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f71875b) {
                cVar.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
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
        f71861g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f71862h = cVar;
        cVar.unsubscribe();
        f71863i = new C1983b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f71864e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f71865f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f71865f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1983b c1983b;
        C1983b c1983b2;
        do {
            c1983b = this.f71865f.get();
            c1983b2 = f71863i;
            if (c1983b == c1983b2) {
                return;
            }
        } while (!this.f71865f.compareAndSet(c1983b, c1983b2));
        c1983b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1983b c1983b = new C1983b(this.f71864e, f71861g);
        if (this.f71865f.compareAndSet(f71863i, c1983b)) {
            return;
        }
        c1983b.b();
    }
}
