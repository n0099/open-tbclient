package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes14.dex */
public final class b extends rx.g implements h {
    static final int pQQ;
    static final c qjn;
    static final C1110b qjo;
    final ThreadFactory pQS;
    final AtomicReference<C1110b> pQT = new AtomicReference<>(qjo);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        pQQ = intValue;
        qjn = new c(RxThreadFactory.NONE);
        qjn.unsubscribe();
        qjo = new C1110b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C1110b {
        long n;
        final int pQY;
        final c[] qju;

        C1110b(ThreadFactory threadFactory, int i) {
            this.pQY = i;
            this.qju = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.qju[i2] = new c(threadFactory);
            }
        }

        public c eFV() {
            int i = this.pQY;
            if (i == 0) {
                return b.qjn;
            }
            c[] cVarArr = this.qju;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.qju) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.pQS = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.pQT.get().eFV());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1110b c1110b = new C1110b(this.pQS, pQQ);
        if (!this.pQT.compareAndSet(qjo, c1110b)) {
            c1110b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1110b c1110b;
        do {
            c1110b = this.pQT.get();
            if (c1110b == qjo) {
                return;
            }
        } while (!this.pQT.compareAndSet(c1110b, qjo));
        c1110b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.pQT.get().eFV().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes14.dex */
    static final class a extends g.a {
        private final rx.internal.util.i qjp = new rx.internal.util.i();
        private final rx.subscriptions.b qjq = new rx.subscriptions.b();
        private final rx.internal.util.i qjr = new rx.internal.util.i(this.qjp, this.qjq);
        private final c qjs;

        a(c cVar) {
            this.qjs = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.qjr.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qjr.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.eGZ() : this.qjs.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.qjp);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.eGZ() : this.qjs.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.qjq);
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
