package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int jZb;
    static final c jZc;
    static final C0490b jZd;
    final ThreadFactory agL;
    final AtomicReference<C0490b> jYN = new AtomicReference<>(jZd);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        jZb = intValue;
        jZc = new c(RxThreadFactory.NONE);
        jZc.unsubscribe();
        jZd = new C0490b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0490b {
        final int jZj;
        final c[] jZk;
        long n;

        C0490b(ThreadFactory threadFactory, int i) {
            this.jZj = i;
            this.jZk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.jZk[i2] = new c(threadFactory);
            }
        }

        public c cEl() {
            int i = this.jZj;
            if (i == 0) {
                return b.jZc;
            }
            c[] cVarArr = this.jZk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.jZk) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agL = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.jYN.get().cEl());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0490b c0490b = new C0490b(this.agL, jZb);
        if (!this.jYN.compareAndSet(jZd, c0490b)) {
            c0490b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0490b c0490b;
        do {
            c0490b = this.jYN.get();
            if (c0490b == jZd) {
                return;
            }
        } while (!this.jYN.compareAndSet(c0490b, jZd));
        c0490b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.jYN.get().cEl().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i jZe = new rx.internal.util.i();
        private final rx.subscriptions.b jZf = new rx.subscriptions.b();
        private final rx.internal.util.i jZg = new rx.internal.util.i(this.jZe, this.jZf);
        private final c jZh;

        a(c cVar) {
            this.jZh = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.jZg.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZg.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cFv() : this.jZh.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.jZe);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cFv() : this.jZh.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.jZf);
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
