package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes4.dex */
public final class b extends rx.g implements h {
    static final int mWc;
    static final c nhB;
    static final C0737b nhC;
    final ThreadFactory aME;
    final AtomicReference<C0737b> mWe = new AtomicReference<>(nhC);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        mWc = intValue;
        nhB = new c(RxThreadFactory.NONE);
        nhB.unsubscribe();
        nhC = new C0737b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0737b {
        final int mWj;
        long n;
        final c[] nhI;

        C0737b(ThreadFactory threadFactory, int i) {
            this.mWj = i;
            this.nhI = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nhI[i2] = new c(threadFactory);
            }
        }

        public c dGG() {
            int i = this.mWj;
            if (i == 0) {
                return b.nhB;
            }
            c[] cVarArr = this.nhI;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nhI) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aME = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.mWe.get().dGG());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0737b c0737b = new C0737b(this.aME, mWc);
        if (!this.mWe.compareAndSet(nhC, c0737b)) {
            c0737b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0737b c0737b;
        do {
            c0737b = this.mWe.get();
            if (c0737b == nhC) {
                return;
            }
        } while (!this.mWe.compareAndSet(c0737b, nhC));
        c0737b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.mWe.get().dGG().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes4.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nhD = new rx.internal.util.i();
        private final rx.subscriptions.b nhE = new rx.subscriptions.b();
        private final rx.internal.util.i nhF = new rx.internal.util.i(this.nhD, this.nhE);
        private final c nhG;

        a(c cVar) {
            this.nhG = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nhF.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nhF.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dHK() : this.nhG.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nhD);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dHK() : this.nhG.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nhE);
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
