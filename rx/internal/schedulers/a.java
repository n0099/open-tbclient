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
    private static final long kqZ;
    private static final TimeUnit kra = TimeUnit.SECONDS;
    static final c krb = new c(RxThreadFactory.NONE);
    static final C0510a krc;
    final ThreadFactory agV;
    final AtomicReference<C0510a> krd = new AtomicReference<>(krc);

    static {
        krb.unsubscribe();
        krc = new C0510a(null, 0L, null);
        krc.shutdown();
        kqZ = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0510a {
        private final ThreadFactory agV;
        private final long kre;
        private final ConcurrentLinkedQueue<c> krf;
        private final rx.subscriptions.b krg;
        private final ScheduledExecutorService krh;
        private final Future<?> kri;

        C0510a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agV = threadFactory;
            this.kre = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.krf = new ConcurrentLinkedQueue<>();
            this.krg = new rx.subscriptions.b();
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
                        C0510a.this.cLP();
                    }
                }, this.kre, this.kre, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.krh = scheduledExecutorService;
            this.kri = scheduledFuture;
        }

        c cLO() {
            if (this.krg.isUnsubscribed()) {
                return a.krb;
            }
            while (!this.krf.isEmpty()) {
                c poll = this.krf.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agV);
            this.krg.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eM(now() + this.kre);
            this.krf.offer(cVar);
        }

        void cLP() {
            if (!this.krf.isEmpty()) {
                long now = now();
                Iterator<c> it = this.krf.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cLQ() <= now) {
                        if (this.krf.remove(next)) {
                            this.krg.a(next);
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
                if (this.kri != null) {
                    this.kri.cancel(true);
                }
                if (this.krh != null) {
                    this.krh.shutdownNow();
                }
            } finally {
                this.krg.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agV = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0510a c0510a = new C0510a(this.agV, kqZ, kra);
        if (!this.krd.compareAndSet(krc, c0510a)) {
            c0510a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0510a c0510a;
        do {
            c0510a = this.krd.get();
            if (c0510a == krc) {
                return;
            }
        } while (!this.krd.compareAndSet(c0510a, krc));
        c0510a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.krd.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0510a krm;
        private final c krn;
        private final rx.subscriptions.b krl = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0510a c0510a) {
            this.krm = c0510a;
            this.krn = c0510a.cLO();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.krn.c(this);
            }
            this.krl.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.krm.a(this.krn);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krl.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.krl.isUnsubscribed()) {
                return rx.subscriptions.e.cNb();
            }
            ScheduledAction b = this.krn.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.krl.add(b);
            b.addParent(this.krl);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long krq;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.krq = 0L;
        }

        public long cLQ() {
            return this.krq;
        }

        public void eM(long j) {
            this.krq = j;
        }
    }
}
