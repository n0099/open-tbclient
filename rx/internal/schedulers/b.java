package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes14.dex */
public final class b extends rx.g implements h {
    static final int qgp;
    static final c qrX;
    static final C1316b qrY;
    final ThreadFactory qgr;
    final AtomicReference<C1316b> qgs = new AtomicReference<>(qrY);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qgp = intValue;
        qrX = new c(RxThreadFactory.NONE);
        qrX.unsubscribe();
        qrY = new C1316b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1316b {
        long n;
        final int qgx;
        final c[] qse;

        C1316b(ThreadFactory threadFactory, int i) {
            this.qgx = i;
            this.qse = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qse[i2] = new c(threadFactory);
            }
        }

        public c eKR() {
            int i = this.qgx;
            if (i == 0) {
                return b.qrX;
            }
            c[] cVarArr = this.qse;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qse) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qgr = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qgs.get().eKR());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1316b c1316b = new C1316b(this.qgr, qgp);
        if (!this.qgs.compareAndSet(qrY, c1316b)) {
            c1316b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1316b c1316b;
        do {
            c1316b = this.qgs.get();
            if (c1316b == qrY) {
                return;
            }
        } while (!this.qgs.compareAndSet(c1316b, qrY));
        c1316b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qgs.get().eKR().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes14.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qrZ = new rx.internal.util.i();
        private final rx.subscriptions.b qsa = new rx.subscriptions.b();
        private final rx.internal.util.i qsb = new rx.internal.util.i(this.qrZ, this.qsa);
        private final c qsc;

        a(c cVar) {
            this.qsc = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qsb.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qsb.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eLX() : this.qsc.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qrZ);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eLX() : this.qsc.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qsa);
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
