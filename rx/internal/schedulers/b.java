package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iDD;
    static final c iDE;
    static final C0410b iDF;
    final ThreadFactory iDp;
    final AtomicReference<C0410b> iDq = new AtomicReference<>(iDF);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iDD = intValue;
        iDE = new c(RxThreadFactory.NONE);
        iDE.unsubscribe();
        iDF = new C0410b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0410b {
        final int iDL;
        final c[] iDM;
        long n;

        C0410b(ThreadFactory threadFactory, int i) {
            this.iDL = i;
            this.iDM = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iDM[i2] = new c(threadFactory);
            }
        }

        public c ccf() {
            int i = this.iDL;
            if (i == 0) {
                return b.iDE;
            }
            c[] cVarArr = this.iDM;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iDM) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.iDp = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iDq.get().ccf());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0410b c0410b = new C0410b(this.iDp, iDD);
        if (!this.iDq.compareAndSet(iDF, c0410b)) {
            c0410b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0410b c0410b;
        do {
            c0410b = this.iDq.get();
            if (c0410b == iDF) {
                return;
            }
        } while (!this.iDq.compareAndSet(c0410b, iDF));
        c0410b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iDq.get().ccf().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iDG = new rx.internal.util.j();
        private final rx.subscriptions.b iDH = new rx.subscriptions.b();
        private final rx.internal.util.j iDI = new rx.internal.util.j(this.iDG, this.iDH);
        private final c iDJ;

        a(c cVar) {
            this.iDJ = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iDI.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iDI.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cdr() : this.iDJ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iDG);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cdr() : this.iDJ.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iDH);
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
