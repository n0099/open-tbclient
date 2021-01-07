package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes15.dex */
public final class b extends rx.g implements h {
    static final int qkR;
    static final C1333b qwA;
    static final c qwz;
    final ThreadFactory qkT;
    final AtomicReference<C1333b> qkU = new AtomicReference<>(qwA);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qkR = intValue;
        qwz = new c(RxThreadFactory.NONE);
        qwz.unsubscribe();
        qwA = new C1333b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1333b {
        long n;
        final int qkZ;
        final c[] qwG;

        C1333b(ThreadFactory threadFactory, int i) {
            this.qkZ = i;
            this.qwG = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qwG[i2] = new c(threadFactory);
            }
        }

        public c eOH() {
            int i = this.qkZ;
            if (i == 0) {
                return b.qwz;
            }
            c[] cVarArr = this.qwG;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qwG) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qkU.get().eOH());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1333b c1333b = new C1333b(this.qkT, qkR);
        if (!this.qkU.compareAndSet(qwA, c1333b)) {
            c1333b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1333b c1333b;
        do {
            c1333b = this.qkU.get();
            if (c1333b == qwA) {
                return;
            }
        } while (!this.qkU.compareAndSet(c1333b, qwA));
        c1333b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qkU.get().eOH().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes15.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qwB = new rx.internal.util.i();
        private final rx.subscriptions.b qwC = new rx.subscriptions.b();
        private final rx.internal.util.i qwD = new rx.internal.util.i(this.qwB, this.qwC);
        private final c qwE;

        a(c cVar) {
            this.qwE = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qwD.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qwD.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.ePN() : this.qwE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qwB);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.ePN() : this.qwE.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qwC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
