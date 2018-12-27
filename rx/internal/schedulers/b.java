package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int iNU;
    static final c iNV;
    static final C0424b iNW;
    final ThreadFactory ahS;
    final AtomicReference<C0424b> iNH = new AtomicReference<>(iNW);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        iNU = intValue;
        iNV = new c(RxThreadFactory.NONE);
        iNV.unsubscribe();
        iNW = new C0424b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0424b {
        final int iOc;
        final c[] iOd;
        long n;

        C0424b(ThreadFactory threadFactory, int i) {
            this.iOc = i;
            this.iOd = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.iOd[i2] = new c(threadFactory);
            }
        }

        public c ceY() {
            int i = this.iOc;
            if (i == 0) {
                return b.iNV;
            }
            c[] cVarArr = this.iOd;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.iOd) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ahS = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.iNH.get().ceY());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0424b c0424b = new C0424b(this.ahS, iNU);
        if (!this.iNH.compareAndSet(iNW, c0424b)) {
            c0424b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0424b c0424b;
        do {
            c0424b = this.iNH.get();
            if (c0424b == iNW) {
                return;
            }
        } while (!this.iNH.compareAndSet(c0424b, iNW));
        c0424b.shutdown();
    }

    public k e(rx.functions.a aVar) {
        return this.iNH.get().ceY().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.j iNX = new rx.internal.util.j();
        private final rx.subscriptions.b iNY = new rx.subscriptions.b();
        private final rx.internal.util.j iNZ = new rx.internal.util.j(this.iNX, this.iNY);
        private final c iOa;

        a(c cVar) {
            this.iOa = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.iNZ.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iNZ.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cgk() : this.iOa.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.iNX);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cgk() : this.iOa.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.iNY);
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
