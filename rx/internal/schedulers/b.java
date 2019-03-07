package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final C0392b jZA;
    static final int jZy;
    static final c jZz;
    final ThreadFactory agF;
    final AtomicReference<C0392b> jZk = new AtomicReference<>(jZA);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        jZy = intValue;
        jZz = new c(RxThreadFactory.NONE);
        jZz.unsubscribe();
        jZA = new C0392b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0392b {
        final int jZG;
        final c[] jZH;
        long n;

        C0392b(ThreadFactory threadFactory, int i) {
            this.jZG = i;
            this.jZH = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.jZH[i2] = new c(threadFactory);
            }
        }

        public c cEj() {
            int i = this.jZG;
            if (i == 0) {
                return b.jZz;
            }
            c[] cVarArr = this.jZH;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.jZH) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agF = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.jZk.get().cEj());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0392b c0392b = new C0392b(this.agF, jZy);
        if (!this.jZk.compareAndSet(jZA, c0392b)) {
            c0392b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0392b c0392b;
        do {
            c0392b = this.jZk.get();
            if (c0392b == jZA) {
                return;
            }
        } while (!this.jZk.compareAndSet(c0392b, jZA));
        c0392b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.jZk.get().cEj().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i jZB = new rx.internal.util.i();
        private final rx.subscriptions.b jZC = new rx.subscriptions.b();
        private final rx.internal.util.i jZD = new rx.internal.util.i(this.jZB, this.jZC);
        private final c jZE;

        a(c cVar) {
            this.jZE = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.jZD.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZD.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cFt() : this.jZE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.jZB);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cFt() : this.jZE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.jZC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
