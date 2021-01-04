package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes15.dex */
public final class b extends rx.g implements h {
    static final int qjj;
    static final c quR;
    static final C1292b quS;
    final ThreadFactory qjl;
    final AtomicReference<C1292b> qjm = new AtomicReference<>(quS);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qjj = intValue;
        quR = new c(RxThreadFactory.NONE);
        quR.unsubscribe();
        quS = new C1292b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1292b {
        long n;
        final int qjr;
        final c[] quY;

        C1292b(ThreadFactory threadFactory, int i) {
            this.qjr = i;
            this.quY = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.quY[i2] = new c(threadFactory);
            }
        }

        public c eOd() {
            int i = this.qjr;
            if (i == 0) {
                return b.quR;
            }
            c[] cVarArr = this.quY;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.quY) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qjm.get().eOd());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1292b c1292b = new C1292b(this.qjl, qjj);
        if (!this.qjm.compareAndSet(quS, c1292b)) {
            c1292b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1292b c1292b;
        do {
            c1292b = this.qjm.get();
            if (c1292b == quS) {
                return;
            }
        } while (!this.qjm.compareAndSet(c1292b, quS));
        c1292b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qjm.get().eOd().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes15.dex */
    static final class a extends g.a {
        private final rx.internal.util.i quT = new rx.internal.util.i();
        private final rx.subscriptions.b quU = new rx.subscriptions.b();
        private final rx.internal.util.i quV = new rx.internal.util.i(this.quT, this.quU);
        private final c quW;

        a(c cVar) {
            this.quW = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.quV.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.quV.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.ePj() : this.quW.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.quT);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.ePj() : this.quW.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.quU);
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
