package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int jZc;
    static final c jZd;
    static final C0490b jZe;
    final ThreadFactory agM;
    final AtomicReference<C0490b> jYO = new AtomicReference<>(jZe);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        jZc = intValue;
        jZd = new c(RxThreadFactory.NONE);
        jZd.unsubscribe();
        jZe = new C0490b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0490b {
        final int jZk;
        final c[] jZl;
        long n;

        C0490b(ThreadFactory threadFactory, int i) {
            this.jZk = i;
            this.jZl = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.jZl[i2] = new c(threadFactory);
            }
        }

        public c cEl() {
            int i = this.jZk;
            if (i == 0) {
                return b.jZd;
            }
            c[] cVarArr = this.jZl;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.jZl) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agM = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.jYO.get().cEl());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0490b c0490b = new C0490b(this.agM, jZc);
        if (!this.jYO.compareAndSet(jZe, c0490b)) {
            c0490b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0490b c0490b;
        do {
            c0490b = this.jYO.get();
            if (c0490b == jZe) {
                return;
            }
        } while (!this.jYO.compareAndSet(c0490b, jZe));
        c0490b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.jYO.get().cEl().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i jZf = new rx.internal.util.i();
        private final rx.subscriptions.b jZg = new rx.subscriptions.b();
        private final rx.internal.util.i jZh = new rx.internal.util.i(this.jZf, this.jZg);
        private final c jZi;

        a(c cVar) {
            this.jZi = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.jZh.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZh.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cFv() : this.jZi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.jZf);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cFv() : this.jZi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.jZg);
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
