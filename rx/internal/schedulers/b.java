package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iBS;
    static final c iBT;
    static final C0382b iBU;
    final ThreadFactory iBE;
    final AtomicReference<C0382b> iBF = new AtomicReference<>(iBU);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iBS = intValue;
        iBT = new c(RxThreadFactory.NONE);
        iBT.unsubscribe();
        iBU = new C0382b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0382b {
        final int iCa;
        final c[] iCb;
        long n;

        C0382b(ThreadFactory threadFactory, int i) {
            this.iCa = i;
            this.iCb = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iCb[i2] = new c(threadFactory);
            }
        }

        public c ccI() {
            int i = this.iCa;
            if (i == 0) {
                return b.iBT;
            }
            c[] cVarArr = this.iCb;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iCb) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.iBE = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iBF.get().ccI());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0382b c0382b = new C0382b(this.iBE, iBS);
        if (!this.iBF.compareAndSet(iBU, c0382b)) {
            c0382b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0382b c0382b;
        do {
            c0382b = this.iBF.get();
            if (c0382b == iBU) {
                return;
            }
        } while (!this.iBF.compareAndSet(c0382b, iBU));
        c0382b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iBF.get().ccI().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iBV = new rx.internal.util.j();
        private final rx.subscriptions.b iBW = new rx.subscriptions.b();
        private final rx.internal.util.j iBX = new rx.internal.util.j(this.iBV, this.iBW);
        private final c iBY;

        a(c cVar) {
            this.iBY = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iBX.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iBX.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cdU() : this.iBY.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iBV);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cdU() : this.iBY.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iBW);
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
