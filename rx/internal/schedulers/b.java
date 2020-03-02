package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final c nRv;
    static final C0799b nRw;
    static final int nyU;
    final ThreadFactory aRW;
    final AtomicReference<C0799b> nyW = new AtomicReference<>(nRw);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nyU = intValue;
        nRv = new c(RxThreadFactory.NONE);
        nRv.unsubscribe();
        nRw = new C0799b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0799b {
        long n;
        final c[] nRC;
        final int nzb;

        C0799b(ThreadFactory threadFactory, int i) {
            this.nzb = i;
            this.nRC = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nRC[i2] = new c(threadFactory);
            }
        }

        public c dOy() {
            int i = this.nzb;
            if (i == 0) {
                return b.nRv;
            }
            c[] cVarArr = this.nRC;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nRC) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aRW = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nyW.get().dOy());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0799b c0799b = new C0799b(this.aRW, nyU);
        if (!this.nyW.compareAndSet(nRw, c0799b)) {
            c0799b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0799b c0799b;
        do {
            c0799b = this.nyW.get();
            if (c0799b == nRw) {
                return;
            }
        } while (!this.nyW.compareAndSet(c0799b, nRw));
        c0799b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nyW.get().dOy().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final c nRA;
        private final rx.internal.util.i nRx = new rx.internal.util.i();
        private final rx.subscriptions.b nRy = new rx.subscriptions.b();
        private final rx.internal.util.i nRz = new rx.internal.util.i(this.nRx, this.nRy);

        a(c cVar) {
            this.nRA = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nRz.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRz.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dPC() : this.nRA.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nRx);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dPC() : this.nRA.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nRy);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
