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
    private static final long krd;
    private static final TimeUnit kre = TimeUnit.SECONDS;
    static final c krf = new c(RxThreadFactory.NONE);
    static final C0510a krg;
    final ThreadFactory agV;
    final AtomicReference<C0510a> krh = new AtomicReference<>(krg);

    static {
        krf.unsubscribe();
        krg = new C0510a(null, 0L, null);
        krg.shutdown();
        krd = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0510a {
        private final ThreadFactory agV;
        private final long kri;
        private final ConcurrentLinkedQueue<c> krj;
        private final rx.subscriptions.b krk;
        private final ScheduledExecutorService krl;
        private final Future<?> krm;

        C0510a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agV = threadFactory;
            this.kri = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.krj = new ConcurrentLinkedQueue<>();
            this.krk = new rx.subscriptions.b();
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
                        C0510a.this.cLQ();
                    }
                }, this.kri, this.kri, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.krl = scheduledExecutorService;
            this.krm = scheduledFuture;
        }

        c cLP() {
            if (this.krk.isUnsubscribed()) {
                return a.krf;
            }
            while (!this.krj.isEmpty()) {
                c poll = this.krj.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agV);
            this.krk.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eM(now() + this.kri);
            this.krj.offer(cVar);
        }

        void cLQ() {
            if (!this.krj.isEmpty()) {
                long now = now();
                Iterator<c> it = this.krj.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cLR() <= now) {
                        if (this.krj.remove(next)) {
                            this.krk.a(next);
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
                if (this.krm != null) {
                    this.krm.cancel(true);
                }
                if (this.krl != null) {
                    this.krl.shutdownNow();
                }
            } finally {
                this.krk.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agV = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0510a c0510a = new C0510a(this.agV, krd, kre);
        if (!this.krh.compareAndSet(krg, c0510a)) {
            c0510a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0510a c0510a;
        do {
            c0510a = this.krh.get();
            if (c0510a == krg) {
                return;
            }
        } while (!this.krh.compareAndSet(c0510a, krg));
        c0510a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.krh.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0510a krq;
        private final c krr;
        private final rx.subscriptions.b krp = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0510a c0510a) {
            this.krq = c0510a;
            this.krr = c0510a.cLP();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.krr.c(this);
            }
            this.krp.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.krq.a(this.krr);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.krp.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.krp.isUnsubscribed()) {
                return rx.subscriptions.e.cNc();
            }
            ScheduledAction b = this.krr.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.krp.add(b);
            b.addParent(this.krp);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kru;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kru = 0L;
        }

        public long cLR() {
            return this.kru;
        }

        public void eM(long j) {
            this.kru = j;
        }
    }
}
