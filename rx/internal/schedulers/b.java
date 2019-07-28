package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class b extends rx.g implements h {
    static final int kyU;
    static final c kyV;
    static final C0517b kyW;
    final ThreadFactory ahu;
    final AtomicReference<C0517b> kyG = new AtomicReference<>(kyW);

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        kyU = intValue;
        kyV = new c(RxThreadFactory.NONE);
        kyV.unsubscribe();
        kyW = new C0517b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0517b {
        final int kzc;
        final c[] kzd;
        long n;

        C0517b(ThreadFactory threadFactory, int i) {
            this.kzc = i;
            this.kzd = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.kzd[i2] = new c(threadFactory);
            }
        }

        public c cPH() {
            int i = this.kzc;
            if (i == 0) {
                return b.kyV;
            }
            c[] cVarArr = this.kzd;
            long j = this.n;
            this.n = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void shutdown() {
            for (c cVar : this.kzd) {
                cVar.unsubscribe();
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.ahu = threadFactory;
        start();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new a(this.kyG.get().cPH());
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0517b c0517b = new C0517b(this.ahu, kyU);
        if (!this.kyG.compareAndSet(kyW, c0517b)) {
            c0517b.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0517b c0517b;
        do {
            c0517b = this.kyG.get();
            if (c0517b == kyW) {
                return;
            }
        } while (!this.kyG.compareAndSet(c0517b, kyW));
        c0517b.shutdown();
    }

    public k g(rx.functions.a aVar) {
        return this.kyG.get().cPH().b(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    /* loaded from: classes2.dex */
    static final class a extends g.a {
        private final rx.internal.util.i kyX = new rx.internal.util.i();
        private final rx.subscriptions.b kyY = new rx.subscriptions.b();
        private final rx.internal.util.i kyZ = new rx.internal.util.i(this.kyX, this.kyY);
        private final c kza;

        a(c cVar) {
            this.kza = cVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            this.kyZ.unsubscribe();
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kyZ.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(final rx.functions.a aVar) {
            return isUnsubscribed() ? rx.subscriptions.e.cQT() : this.kza.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.1
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, 0L, (TimeUnit) null, this.kyX);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.subscriptions.e.cQT() : this.kza.a(new rx.functions.a() { // from class: rx.internal.schedulers.b.a.2
                @Override // rx.functions.a
                public void call() {
                    if (!a.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit, this.kyY);
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
