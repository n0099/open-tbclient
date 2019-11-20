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
    private static final long kBR;
    private static final TimeUnit kBS = TimeUnit.SECONDS;
    static final c kBT = new c(RxThreadFactory.NONE);
    static final C0611a kBU;
    final ThreadFactory aAW;
    final AtomicReference<C0611a> kBV = new AtomicReference<>(kBU);

    static {
        kBT.unsubscribe();
        kBU = new C0611a(null, 0L, null);
        kBU.shutdown();
        kBR = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0611a {
        private final ThreadFactory aAW;
        private final long kBW;
        private final ConcurrentLinkedQueue<c> kBX;
        private final rx.subscriptions.b kBY;
        private final ScheduledExecutorService kBZ;
        private final Future<?> kCa;

        C0611a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aAW = threadFactory;
            this.kBW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.kBX = new ConcurrentLinkedQueue<>();
            this.kBY = new rx.subscriptions.b();
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
                        C0611a.this.cOP();
                    }
                }, this.kBW, this.kBW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kBZ = scheduledExecutorService;
            this.kCa = scheduledFuture;
        }

        c cOO() {
            if (this.kBY.isUnsubscribed()) {
                return a.kBT;
            }
            while (!this.kBX.isEmpty()) {
                c poll = this.kBX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aAW);
            this.kBY.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.es(now() + this.kBW);
            this.kBX.offer(cVar);
        }

        void cOP() {
            if (!this.kBX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.kBX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cOQ() <= now) {
                        if (this.kBX.remove(next)) {
                            this.kBY.a(next);
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
                if (this.kCa != null) {
                    this.kCa.cancel(true);
                }
                if (this.kBZ != null) {
                    this.kBZ.shutdownNow();
                }
            } finally {
                this.kBY.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aAW = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0611a c0611a = new C0611a(this.aAW, kBR, kBS);
        if (!this.kBV.compareAndSet(kBU, c0611a)) {
            c0611a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0611a c0611a;
        do {
            c0611a = this.kBV.get();
            if (c0611a == kBU) {
                return;
            }
        } while (!this.kBV.compareAndSet(c0611a, kBU));
        c0611a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kBV.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0611a kCe;
        private final c kCf;
        private final rx.subscriptions.b kCd = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0611a c0611a) {
            this.kCe = c0611a;
            this.kCf = c0611a.cOO();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kCf.c(this);
            }
            this.kCd.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.kCe.a(this.kCf);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCd.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.kCd.isUnsubscribed()) {
                return rx.subscriptions.e.cQd();
            }
            ScheduledAction b = this.kCf.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.kCd.add(b);
            b.addParent(this.kCd);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kCi;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kCi = 0L;
        }

        public long cOQ() {
            return this.kCi;
        }

        public void es(long j) {
            this.kCi = j;
        }
    }
}
