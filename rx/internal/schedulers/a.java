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
    private static final long kCI;
    private static final TimeUnit kCJ = TimeUnit.SECONDS;
    static final c kCK = new c(RxThreadFactory.NONE);
    static final C0623a kCL;
    final ThreadFactory aBo;
    final AtomicReference<C0623a> kCM = new AtomicReference<>(kCL);

    static {
        kCK.unsubscribe();
        kCL = new C0623a(null, 0L, null);
        kCL.shutdown();
        kCI = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0623a {
        private final ThreadFactory aBo;
        private final long kCN;
        private final ConcurrentLinkedQueue<c> kCO;
        private final rx.subscriptions.b kCP;
        private final ScheduledExecutorService kCQ;
        private final Future<?> kCR;

        C0623a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aBo = threadFactory;
            this.kCN = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.kCO = new ConcurrentLinkedQueue<>();
            this.kCP = new rx.subscriptions.b();
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
                        C0623a.this.cOR();
                    }
                }, this.kCN, this.kCN, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kCQ = scheduledExecutorService;
            this.kCR = scheduledFuture;
        }

        c cOQ() {
            if (this.kCP.isUnsubscribed()) {
                return a.kCK;
            }
            while (!this.kCO.isEmpty()) {
                c poll = this.kCO.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aBo);
            this.kCP.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.et(now() + this.kCN);
            this.kCO.offer(cVar);
        }

        void cOR() {
            if (!this.kCO.isEmpty()) {
                long now = now();
                Iterator<c> it = this.kCO.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cOS() <= now) {
                        if (this.kCO.remove(next)) {
                            this.kCP.a(next);
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
                if (this.kCR != null) {
                    this.kCR.cancel(true);
                }
                if (this.kCQ != null) {
                    this.kCQ.shutdownNow();
                }
            } finally {
                this.kCP.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aBo = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0623a c0623a = new C0623a(this.aBo, kCI, kCJ);
        if (!this.kCM.compareAndSet(kCL, c0623a)) {
            c0623a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0623a c0623a;
        do {
            c0623a = this.kCM.get();
            if (c0623a == kCL) {
                return;
            }
        } while (!this.kCM.compareAndSet(c0623a, kCL));
        c0623a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kCM.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0623a kCV;
        private final c kCW;
        private final rx.subscriptions.b kCU = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0623a c0623a) {
            this.kCV = c0623a;
            this.kCW = c0623a.cOQ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kCW.c(this);
            }
            this.kCU.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.kCV.a(this.kCW);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCU.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.kCU.isUnsubscribed()) {
                return rx.subscriptions.e.cQf();
            }
            ScheduledAction b = this.kCW.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.kCU.add(b);
            b.addParent(this.kCU);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kCZ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kCZ = 0L;
        }

        public long cOS() {
            return this.kCZ;
        }

        public void et(long j) {
            this.kCZ = j;
        }
    }
}
