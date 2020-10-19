package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes16.dex */
public final class b extends rx.g implements h {
    static final int oOw;
    static final c pgW;
    static final C1015b pgX;
    final ThreadFactory oOy;
    final AtomicReference<C1015b> oOz = new AtomicReference<>(pgX);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        oOw = intValue;
        pgW = new c(RxThreadFactory.NONE);
        pgW.unsubscribe();
        pgX = new C1015b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C1015b {
        long n;
        final int oOE;
        final c[] phd;

        C1015b(ThreadFactory threadFactory, int i) {
            this.oOE = i;
            this.phd = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.phd[i2] = new c(threadFactory);
            }
        }

        public c esh() {
            int i = this.oOE;
            if (i == 0) {
                return b.pgW;
            }
            c[] cVarArr = this.phd;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.phd) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.oOy = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.oOz.get().esh());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1015b c1015b = new C1015b(this.oOy, oOw);
        if (!this.oOz.compareAndSet(pgX, c1015b)) {
            c1015b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1015b c1015b;
        do {
            c1015b = this.oOz.get();
            if (c1015b == pgX) {
                return;
            }
        } while (!this.oOz.compareAndSet(c1015b, pgX));
        c1015b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.oOz.get().esh().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes16.dex */
    static final class a extends g.a {
        private final rx.internal.util.i pgY = new rx.internal.util.i();
        private final rx.subscriptions.b pgZ = new rx.subscriptions.b();
        private final rx.internal.util.i pha = new rx.internal.util.i(this.pgY, this.pgZ);
        private final c phb;

        a(c cVar) {
            this.phb = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.pha.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.pha.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.etl() : this.phb.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.pgY);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.etl() : this.phb.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.pgZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
