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
    public static final int f67870g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f67871h;
    public static final C1881b i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f67872e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1881b> f67873f = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.i f67874e = new h.o.d.i();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f67875f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.i f67876g;

        /* renamed from: h  reason: collision with root package name */
        public final c f67877h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1879a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67878e;

            public C1879a(h.n.a aVar) {
                this.f67878e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67878e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1880b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f67880e;

            public C1880b(h.n.a aVar) {
                this.f67880e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f67880e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f67875f = bVar;
            this.f67876g = new h.o.d.i(this.f67874e, bVar);
            this.f67877h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67877h.i(new C1879a(aVar), 0L, null, this.f67874e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f67877h.j(new C1880b(aVar), j, timeUnit, this.f67875f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f67876g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f67876g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1881b {

        /* renamed from: a  reason: collision with root package name */
        public final int f67882a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f67883b;

        /* renamed from: c  reason: collision with root package name */
        public long f67884c;

        public C1881b(ThreadFactory threadFactory, int i) {
            this.f67882a = i;
            this.f67883b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f67883b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f67882a;
            if (i == 0) {
                return b.f67871h;
            }
            c[] cVarArr = this.f67883b;
            long j = this.f67884c;
            this.f67884c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f67883b) {
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
        f67870g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f67871h = cVar;
        cVar.unsubscribe();
        i = new C1881b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f67872e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f67873f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f67873f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1881b c1881b;
        C1881b c1881b2;
        do {
            c1881b = this.f67873f.get();
            c1881b2 = i;
            if (c1881b == c1881b2) {
                return;
            }
        } while (!this.f67873f.compareAndSet(c1881b, c1881b2));
        c1881b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1881b c1881b = new C1881b(this.f67872e, f67870g);
        if (this.f67873f.compareAndSet(i, c1881b)) {
            return;
        }
        c1881b.b();
    }
}
