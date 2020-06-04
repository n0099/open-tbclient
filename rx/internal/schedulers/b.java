package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final c nJn;
    static final C0907b nJo;
    static final int nqK;
    final ThreadFactory bvS;
    final AtomicReference<C0907b> nqM = new AtomicReference<>(nJo);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        nqK = intValue;
        nJn = new c(RxThreadFactory.NONE);
        nJn.unsubscribe();
        nJo = new C0907b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0907b {
        long n;
        final c[] nJu;
        final int nqR;

        C0907b(ThreadFactory threadFactory, int i) {
            this.nqR = i;
            this.nJu = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nJu[i2] = new c(threadFactory);
            }
        }

        public c dQe() {
            int i = this.nqR;
            if (i == 0) {
                return b.nJn;
            }
            c[] cVarArr = this.nJu;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nJu) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.nqM.get().dQe());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0907b c0907b = new C0907b(this.bvS, nqK);
        if (!this.nqM.compareAndSet(nJo, c0907b)) {
            c0907b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0907b c0907b;
        do {
            c0907b = this.nqM.get();
            if (c0907b == nJo) {
                return;
            }
        } while (!this.nqM.compareAndSet(c0907b, nJo));
        c0907b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.nqM.get().dQe().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nJp = new rx.internal.util.i();
        private final rx.subscriptions.b nJq = new rx.subscriptions.b();
        private final rx.internal.util.i nJr = new rx.internal.util.i(this.nJp, this.nJq);
        private final c nJs;

        a(c cVar) {
            this.nJs = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nJr.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nJr.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dRi() : this.nJs.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nJp);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dRi() : this.nJs.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nJq);
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
