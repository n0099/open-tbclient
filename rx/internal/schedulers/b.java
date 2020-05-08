package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes6.dex */
public final class b extends rx.g implements h {
    static final int mUx;
    static final c nnd;
    static final C0844b nne;
    final ThreadFactory bos;
    final AtomicReference<C0844b> mUz = new AtomicReference<>(nne);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        mUx = intValue;
        nnd = new c(RxThreadFactory.NONE);
        nnd.unsubscribe();
        nne = new C0844b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0844b {
        final int mUE;
        long n;
        final c[] nnk;

        C0844b(ThreadFactory threadFactory, int i) {
            this.mUE = i;
            this.nnk = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.nnk[i2] = new c(threadFactory);
            }
        }

        public c dHV() {
            int i = this.mUE;
            if (i == 0) {
                return b.nnd;
            }
            c[] cVarArr = this.nnk;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.nnk) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.bos = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.mUz.get().dHV());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0844b c0844b = new C0844b(this.bos, mUx);
        if (!this.mUz.compareAndSet(nne, c0844b)) {
            c0844b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0844b c0844b;
        do {
            c0844b = this.mUz.get();
            if (c0844b == nne) {
                return;
            }
        } while (!this.mUz.compareAndSet(c0844b, nne));
        c0844b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.mUz.get().dHV().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes6.dex */
    static final class a extends g.a {
        private final rx.internal.util.i nnf = new rx.internal.util.i();
        private final rx.subscriptions.b nng = new rx.subscriptions.b();
        private final rx.internal.util.i nnh = new rx.internal.util.i(this.nnf, this.nng);
        private final c nni;

        a(c cVar) {
            this.nni = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.nnh.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nnh.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.dIZ() : this.nni.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.nnf);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.dIZ() : this.nni.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.nng);
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
