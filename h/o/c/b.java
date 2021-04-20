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
    public static final int f68880g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f68881h;
    public static final C1916b i;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadFactory f68882e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<C1916b> f68883f = new AtomicReference<>(i);

    /* loaded from: classes7.dex */
    public static final class a extends g.a {

        /* renamed from: e  reason: collision with root package name */
        public final h.o.d.i f68884e = new h.o.d.i();

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f68885f;

        /* renamed from: g  reason: collision with root package name */
        public final h.o.d.i f68886g;

        /* renamed from: h  reason: collision with root package name */
        public final c f68887h;

        /* renamed from: h.o.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1914a implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68888e;

            public C1914a(h.n.a aVar) {
                this.f68888e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68888e.call();
            }
        }

        /* renamed from: h.o.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1915b implements h.n.a {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.n.a f68890e;

            public C1915b(h.n.a aVar) {
                this.f68890e = aVar;
            }

            @Override // h.n.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f68890e.call();
            }
        }

        public a(c cVar) {
            h.u.b bVar = new h.u.b();
            this.f68885f = bVar;
            this.f68886g = new h.o.d.i(this.f68884e, bVar);
            this.f68887h = cVar;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68887h.i(new C1914a(aVar), 0L, null, this.f68884e);
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return h.u.e.c();
            }
            return this.f68887h.j(new C1915b(aVar), j, timeUnit, this.f68885f);
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68886g.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68886g.unsubscribe();
        }
    }

    /* renamed from: h.o.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1916b {

        /* renamed from: a  reason: collision with root package name */
        public final int f68892a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f68893b;

        /* renamed from: c  reason: collision with root package name */
        public long f68894c;

        public C1916b(ThreadFactory threadFactory, int i) {
            this.f68892a = i;
            this.f68893b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f68893b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f68892a;
            if (i == 0) {
                return b.f68881h;
            }
            c[] cVarArr = this.f68893b;
            long j = this.f68894c;
            this.f68894c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f68893b) {
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
        f68880g = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f68881h = cVar;
        cVar.unsubscribe();
        i = new C1916b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f68882e = threadFactory;
        start();
    }

    public k a(h.n.a aVar) {
        return this.f68883f.get().a().h(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // h.g
    public g.a createWorker() {
        return new a(this.f68883f.get().a());
    }

    @Override // h.o.c.h
    public void shutdown() {
        C1916b c1916b;
        C1916b c1916b2;
        do {
            c1916b = this.f68883f.get();
            c1916b2 = i;
            if (c1916b == c1916b2) {
                return;
            }
        } while (!this.f68883f.compareAndSet(c1916b, c1916b2));
        c1916b.b();
    }

    @Override // h.o.c.h
    public void start() {
        C1916b c1916b = new C1916b(this.f68882e, f68880g);
        if (this.f68883f.compareAndSet(i, c1916b)) {
            return;
        }
        c1916b.b();
    }
}
