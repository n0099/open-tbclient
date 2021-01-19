package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes14.dex */
public final class b extends rx.g implements h {
    static final int qgq;
    static final c qrY;
    static final C1316b qrZ;
    final ThreadFactory qgs;
    final AtomicReference<C1316b> qgt = new AtomicReference<>(qrZ);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qgq = intValue;
        qrY = new c(RxThreadFactory.NONE);
        qrY.unsubscribe();
        qrZ = new C1316b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1316b {
        long n;
        final int qgy;
        final c[] qsf;

        C1316b(ThreadFactory threadFactory, int i) {
            this.qgy = i;
            this.qsf = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qsf[i2] = new c(threadFactory);
            }
        }

        public c eKR() {
            int i = this.qgy;
            if (i == 0) {
                return b.qrY;
            }
            c[] cVarArr = this.qsf;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qsf) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qgs = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qgt.get().eKR());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1316b c1316b = new C1316b(this.qgs, qgq);
        if (!this.qgt.compareAndSet(qrZ, c1316b)) {
            c1316b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1316b c1316b;
        do {
            c1316b = this.qgt.get();
            if (c1316b == qrZ) {
                return;
            }
        } while (!this.qgt.compareAndSet(c1316b, qrZ));
        c1316b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qgt.get().eKR().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes14.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qsa = new rx.internal.util.i();
        private final rx.subscriptions.b qsb = new rx.subscriptions.b();
        private final rx.internal.util.i qsc = new rx.internal.util.i(this.qsa, this.qsb);
        private final c qsd;

        a(c cVar) {
            this.qsd = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qsc.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qsc.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eLX() : this.qsd.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qsa);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eLX() : this.qsd.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qsb);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
