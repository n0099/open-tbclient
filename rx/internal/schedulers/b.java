package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes4.dex */
public final class b extends rx.g implements h {
    static final c qDd;
    static final C1310b qDe;
    static final int qrw;
    final ThreadFactory qry;
    final AtomicReference<C1310b> qrz = new AtomicReference<>(qDe);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qrw = intValue;
        qDd = new c(RxThreadFactory.NONE);
        qDd.unsubscribe();
        qDe = new C1310b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1310b {
        long n;
        final c[] qDk;
        final int qrE;

        C1310b(ThreadFactory threadFactory, int i) {
            this.qrE = i;
            this.qDk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qDk[i2] = new c(threadFactory);
            }
        }

        public c eMX() {
            int i = this.qrE;
            if (i == 0) {
                return b.qDd;
            }
            c[] cVarArr = this.qDk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qDk) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qry = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qrz.get().eMX());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1310b c1310b = new C1310b(this.qry, qrw);
        if (!this.qrz.compareAndSet(qDe, c1310b)) {
            c1310b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1310b c1310b;
        do {
            c1310b = this.qrz.get();
            if (c1310b == qDe) {
                return;
            }
        } while (!this.qrz.compareAndSet(c1310b, qDe));
        c1310b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qrz.get().eMX().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes4.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qDf = new rx.internal.util.i();
        private final rx.subscriptions.b qDg = new rx.subscriptions.b();
        private final rx.internal.util.i qDh = new rx.internal.util.i(this.qDf, this.qDg);
        private final c qDi;

        a(c cVar) {
            this.qDi = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qDh.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qDh.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eOd() : this.qDi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qDf);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eOd() : this.qDi.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qDg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
