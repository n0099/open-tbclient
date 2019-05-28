package rx.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
import rx.internal.util.RxThreadFactory;
import rx.k;
/* loaded from: classes2.dex */
public final class a extends rx.g implements h {
    private static final long kra;
    private static final TimeUnit krb = TimeUnit.SECONDS;
    static final c krc = new c(RxThreadFactory.NONE);
    static final C0510a krd;
    final ThreadFactory agV;
    final AtomicReference<C0510a> kre = new AtomicReference<>(krd);

    static {
        krc.unsubscribe();
        krd = new C0510a(null, 0L, null);
        krd.shutdown();
        kra = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0510a {
        private final ThreadFactory agV;
        private final long krf;
        private final ConcurrentLinkedQueue<c> krg;
        private final rx.subscriptions.b krh;
        private final ScheduledExecutorService kri;
        private final Future<?> krj;

        C0510a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agV = threadFactory;
            this.krf = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.krg = new ConcurrentLinkedQueue<>();
            this.krh = new rx.subscriptions.b();
            if (timeUnit != null) {
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.a.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                g.b(newScheduledThreadPool);
                scheduledExecutorService = newScheduledThreadPool;
                scheduledFuture = newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C0510a.this.cLR();
                    }
                }, this.krf, this.krf, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kri = scheduledExecutorService;
            this.krj = scheduledFuture;
        }

        c cLQ() {
            if (this.krh.isUnsubscribed()) {
                return a.krc;
            }
            while (!this.krg.isEmpty()) {
                c poll = this.krg.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agV);
            this.krh.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eM(now() + this.krf);
            this.krg.offer(cVar);
        }

        void cLR() {
            if (!this.krg.isEmpty()) {
                long now = now();
                Iterator<c> it = this.krg.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cLS() <= now) {
                        if (this.krg.remove(next)) {
                            this.krh.a(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        long now() {
            return System.nanoTime();
        }

        void shutdown() {
            try {
                if (this.krj != null) {
                    this.krj.cancel(true);
                }
                if (this.kri != null) {
                    this.kri.shutdownNow();
                }
            } finally {
                this.krh.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agV = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0510a c0510a = new C0510a(this.agV, kra, krb);
        if (!this.kre.compareAndSet(krd, c0510a)) {
            c0510a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0510a c0510a;
        do {
            c0510a = this.kre.get();
            if (c0510a == krd) {
                return;
            }
        } while (!this.kre.compareAndSet(c0510a, krd));
        c0510a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kre.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0510a krn;
        private final c kro;
        private final rx.subscriptions.b krm = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0510a c0510a) {
            this.krn = c0510a;
            this.kro = c0510a.cLQ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kro.c(this);
            }
            this.krm.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.krn.a(this.kro);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krm.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.krm.isUnsubscribed()) {
                return rx.subscriptions.e.cNd();
            }
            ScheduledAction b = this.kro.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.krm.add(b);
            b.addParent(this.krm);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long krr;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.krr = 0L;
        }

        public long cLS() {
            return this.krr;
        }

        public void eM(long j) {
            this.krr = j;
        }
    }
}
