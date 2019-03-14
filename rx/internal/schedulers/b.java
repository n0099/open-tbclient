package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int jZJ;
    static final c jZK;
    static final C0490b jZL;
    final ThreadFactory agG;
    final AtomicReference<C0490b> jZv = new AtomicReference<>(jZL);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        jZJ = intValue;
        jZK = new c(RxThreadFactory.NONE);
        jZK.unsubscribe();
        jZL = new C0490b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0490b {
        final int jZR;
        final c[] jZS;
        long n;

        C0490b(ThreadFactory threadFactory, int i) {
            this.jZR = i;
            this.jZS = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.jZS[i2] = new c(threadFactory);
            }
        }

        public c cEw() {
            int i = this.jZR;
            if (i == 0) {
                return b.jZK;
            }
            c[] cVarArr = this.jZS;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.jZS) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.agG = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.jZv.get().cEw());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0490b c0490b = new C0490b(this.agG, jZJ);
        if (!this.jZv.compareAndSet(jZL, c0490b)) {
            c0490b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0490b c0490b;
        do {
            c0490b = this.jZv.get();
            if (c0490b == jZL) {
                return;
            }
        } while (!this.jZv.compareAndSet(c0490b, jZL));
        c0490b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.jZv.get().cEw().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i jZM = new rx.internal.util.i();
        private final rx.subscriptions.b jZN = new rx.subscriptions.b();
        private final rx.internal.util.i jZO = new rx.internal.util.i(this.jZM, this.jZN);
        private final c jZP;

        a(c cVar) {
            this.jZP = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.jZO.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZO.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cFG() : this.jZP.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.jZM);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cFG() : this.jZP.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.jZN);
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
