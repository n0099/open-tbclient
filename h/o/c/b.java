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
    public static final int f69027g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f69028h;
    public static final C1920b i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f69029e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1920b> f69030f = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.i f69031e = new h.o.d.i();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f69032f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.i f69033g;

        /* renamed from: h  reason: collision with root package name */
        public final c f69034h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1918a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69035e;

            public C1918a(h.n.a aVar) {
                this.f69035e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f69035e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1919b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f69037e;

            public C1919b(h.n.a aVar) {
                this.f69037e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f69037e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f69032f = bVar;
            this.f69033g = new h.o.d.i(this.f69031e, bVar);
            this.f69034h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f69034h.i(new C1918a(aVar), 0L, null, this.f69031e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f69034h.j(new C1919b(aVar), j, timeUnit, this.f69032f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f69033g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f69033g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1920b {

        /* renamed from: a  reason: collision with root package name */
        public final int f69039a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f69040b;

        /* renamed from: c  reason: collision with root package name */
        public long f69041c;

        public C1920b(ThreadFactory threadFactory, int i) {
            this.f69039a = i;
            this.f69040b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f69040b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f69039a;
            if (i == 0) {
                return b.f69028h;
            }
            c[] cVarArr = this.f69040b;
            long j = this.f69041c;
            this.f69041c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f69040b) {
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
        f69027g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f69028h = cVar;
        cVar.unsubscribe();
        i = new C1920b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f69029e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f69030f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f69030f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1920b c1920b;
        C1920b c1920b2;
        do {
            c1920b = this.f69030f.get();
            c1920b2 = i;
            if (c1920b == c1920b2) {
                return;
            }
        } while (!this.f69030f.compareAndSet(c1920b, c1920b2));
        c1920b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1920b c1920b = new C1920b(this.f69029e, f69027g);
        if (this.f69030f.compareAndSet(i, c1920b)) {
            return;
        }
        c1920b.b();
    }
}
