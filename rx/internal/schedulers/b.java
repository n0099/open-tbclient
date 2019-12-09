package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int kCj;
    static final c kCk;
    static final C0607b kCl;
    final ThreadFactory aAW;
    final AtomicReference<C0607b> kBV = new AtomicReference<>(kCl);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        kCj = intValue;
        kCk = new c(RxThreadFactory.NONE);
        kCk.unsubscribe();
        kCl = new C0607b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0607b {
        final int kCr;
        final c[] kCs;
        long n;

        C0607b(ThreadFactory threadFactory, int i) {
            this.kCr = i;
            this.kCs = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kCs[i2] = new c(threadFactory);
            }
        }

        public c cOR() {
            int i = this.kCr;
            if (i == 0) {
                return b.kCk;
            }
            c[] cVarArr = this.kCs;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kCs) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.aAW = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kBV.get().cOR());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0607b c0607b = new C0607b(this.aAW, kCj);
        if (!this.kBV.compareAndSet(kCl, c0607b)) {
            c0607b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0607b c0607b;
        do {
            c0607b = this.kBV.get();
            if (c0607b == kCl) {
                return;
            }
        } while (!this.kBV.compareAndSet(c0607b, kCl));
        c0607b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kBV.get().cOR().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kCm = new rx.internal.util.i();
        private final rx.subscriptions.b kCn = new rx.subscriptions.b();
        private final rx.internal.util.i kCo = new rx.internal.util.i(this.kCm, this.kCn);
        private final c kCp;

        a(c cVar) {
            this.kCp = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kCo.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCo.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cQd() : this.kCp.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kCm);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cQd() : this.kCp.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.kCn);
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
