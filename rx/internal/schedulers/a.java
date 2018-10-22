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
    private static final long iBB;
    private static final TimeUnit iBC = TimeUnit.SECONDS;
    static final c iBD = new c(RxThreadFactory.NONE);
    static final C0381a iBE;
    final ThreadFactory iBF;
    final AtomicReference<C0381a> iBG = new AtomicReference<>(iBE);

    static {
        iBD.unsubscribe();
        iBE = new C0381a(null, 0L, null);
        iBE.shutdown();
        iBB = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0381a {
        private final ThreadFactory iBF;
        private final long iBH;
        private final ConcurrentLinkedQueue<c> iBI;
        private final rx.subscriptions.b iBJ;
        private final ScheduledExecutorService iBK;
        private final Future<?> iBL;

        C0381a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.iBF = threadFactory;
            this.iBH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iBI = new ConcurrentLinkedQueue<>();
            this.iBJ = new rx.subscriptions.b();
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
                        C0381a.this.ccG();
                    }
                }, this.iBH, this.iBH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iBK = scheduledExecutorService;
            this.iBL = scheduledFuture;
        }

        c ccF() {
            if (this.iBJ.isUnsubscribed()) {
                return a.iBD;
            }
            while (!this.iBI.isEmpty()) {
                c poll = this.iBI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.iBF);
            this.iBJ.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dK(now() + this.iBH);
            this.iBI.offer(cVar);
        }

        void ccG() {
            if (!this.iBI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iBI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ccH() <= now) {
                        if (this.iBI.remove(next)) {
                            this.iBJ.b(next);
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
                if (this.iBL != null) {
                    this.iBL.cancel(true);
                }
                if (this.iBK != null) {
                    this.iBK.shutdownNow();
                }
            } finally {
                this.iBJ.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.iBF = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0381a c0381a = new C0381a(this.iBF, iBB, iBC);
        if (!this.iBG.compareAndSet(iBE, c0381a)) {
            c0381a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0381a c0381a;
        do {
            c0381a = this.iBG.get();
            if (c0381a == iBE) {
                return;
            }
        } while (!this.iBG.compareAndSet(c0381a, iBE));
        c0381a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iBG.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0381a iBP;
        private final c iBQ;
        private final rx.subscriptions.b iBO = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0381a c0381a) {
            this.iBP = c0381a;
            this.iBQ = c0381a.ccF();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iBQ.a(this);
            }
            this.iBO.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iBP.a(this.iBQ);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iBO.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iBO.isUnsubscribed()) {
                return rx.subscriptions.e.cdU();
            }
            ScheduledAction b = this.iBQ.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iBO.add(b);
            b.addParent(this.iBO);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iBS;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iBS = 0L;
        }

        public long ccH() {
            return this.iBS;
        }

        public void dK(long j) {
            this.iBS = j;
        }
    }
}
