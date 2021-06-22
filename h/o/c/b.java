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
    public static final int f71965g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f71966h;

    /* renamed from: i  reason: collision with root package name */
    public static final C1986b f71967i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f71968e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1986b> f71969f = new AtomicReference<>(f71967i);

    /* loaded from: classes8.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.h f71970e = new h.o.d.h();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f71971f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.h f71972g;

        /* renamed from: h  reason: collision with root package name */
        public final c f71973h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1984a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71974e;

            public C1984a(h.n.a aVar) {
                this.f71974e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f71974e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1985b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f71976e;

            public C1985b(h.n.a aVar) {
                this.f71976e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f71976e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f71971f = bVar;
            this.f71972g = new h.o.d.h(this.f71970e, bVar);
            this.f71973h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f71973h.i(new C1984a(aVar), 0L, null, this.f71970e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f71973h.j(new C1985b(aVar), j, timeUnit, this.f71971f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f71972g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f71972g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1986b {

        /* renamed from: a  reason: collision with root package name */
        public final int f71978a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f71979b;

        /* renamed from: c  reason: collision with root package name */
        public long f71980c;

        public C1986b(ThreadFactory threadFactory, int i2) {
            this.f71978a = i2;
            this.f71979b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f71979b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f71978a;
            if (i2 == 0) {
                return b.f71966h;
            }
            c[] cVarArr = this.f71979b;
            long j = this.f71980c;
            this.f71980c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f71979b) {
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
        f71965g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f71966h = cVar;
        cVar.unsubscribe();
        f71967i = new C1986b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f71968e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f71969f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f71969f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1986b c1986b;
        C1986b c1986b2;
        do {
            c1986b = this.f71969f.get();
            c1986b2 = f71967i;
            if (c1986b == c1986b2) {
                return;
            }
        } while (!this.f71969f.compareAndSet(c1986b, c1986b2));
        c1986b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1986b c1986b = new C1986b(this.f71968e, f71965g);
        if (this.f71969f.compareAndSet(f71967i, c1986b)) {
            return;
        }
        c1986b.b();
    }
}
