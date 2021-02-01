package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes5.dex */
public final class b extends rx.g implements h {
    static final c qCb;
    static final C1326b qCc;
    static final int qqu;
    final ThreadFactory qqw;
    final AtomicReference<C1326b> qqx = new AtomicReference<>(qCc);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        qqu = intValue;
        qCb = new c(RxThreadFactory.NONE);
        qCb.unsubscribe();
        qCc = new C1326b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1326b {
        long n;
        final c[] qCi;
        final int qqC;

        C1326b(ThreadFactory threadFactory, int i) {
            this.qqC = i;
            this.qCi = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qCi[i2] = new c(threadFactory);
            }
        }

        public c eNh() {
            int i = this.qqC;
            if (i == 0) {
                return b.qCb;
            }
            c[] cVarArr = this.qCi;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qCi) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.qqw = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.qqx.get().eNh());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1326b c1326b = new C1326b(this.qqw, qqu);
        if (!this.qqx.compareAndSet(qCc, c1326b)) {
            c1326b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1326b c1326b;
        do {
            c1326b = this.qqx.get();
            if (c1326b == qCc) {
                return;
            }
        } while (!this.qqx.compareAndSet(c1326b, qCc));
        c1326b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.qqx.get().eNh().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes5.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qCd = new rx.internal.util.i();
        private final rx.subscriptions.b qCe = new rx.subscriptions.b();
        private final rx.internal.util.i qCf = new rx.internal.util.i(this.qCd, this.qCe);
        private final c qCg;

        a(c cVar) {
            this.qCg = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qCf.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qCf.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eOn() : this.qCg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qCd);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eOn() : this.qCg.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qCe);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
