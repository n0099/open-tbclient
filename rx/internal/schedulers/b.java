package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int mUu;
    static final c nna;
    static final C0823b nnb;
    final ThreadFactory bon;
    final AtomicReference<C0823b> mUw = new AtomicReference<>(nnb);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        mUu = intValue;
        nna = new c(RxThreadFactory.NONE);
        nna.unsubscribe();
        nnb = new C0823b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0823b {
        final int mUB;
        long n;
        final c[] nnh;

        C0823b(ThreadFactory threadFactory, int i) {
            this.mUB = i;
            this.nnh = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nnh[i2] = new c(threadFactory);
            }
        }

        public c dHZ() {
            int i = this.mUB;
            if (i == 0) {
                return b.nna;
            }
            c[] cVarArr = this.nnh;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nnh) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.bon = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.mUw.get().dHZ());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0823b c0823b = new C0823b(this.bon, mUu);
        if (!this.mUw.compareAndSet(nnb, c0823b)) {
            c0823b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0823b c0823b;
        do {
            c0823b = this.mUw.get();
            if (c0823b == nnb) {
                return;
            }
        } while (!this.mUw.compareAndSet(c0823b, nnb));
        c0823b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.mUw.get().dHZ().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nnc = new rx.internal.util.i();
        private final rx.subscriptions.b nnd = new rx.subscriptions.b();
        private final rx.internal.util.i nne = new rx.internal.util.i(this.nnc, this.nnd);
        private final c nnf;

        a(c cVar) {
            this.nnf = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nne.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nne.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dJd() : this.nnf.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nnc);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dJd() : this.nnf.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nnd);
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
