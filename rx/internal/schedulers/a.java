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
    private static final long iBA;
    private static final TimeUnit iBB = TimeUnit.SECONDS;
    static final c iBC = new c(RxThreadFactory.NONE);
    static final C0381a iBD;
    final ThreadFactory iBE;
    final AtomicReference<C0381a> iBF = new AtomicReference<>(iBD);

    static {
        iBC.unsubscribe();
        iBD = new C0381a(null, 0L, null);
        iBD.shutdown();
        iBA = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0381a {
        private final ThreadFactory iBE;
        private final long iBG;
        private final ConcurrentLinkedQueue<c> iBH;
        private final rx.subscriptions.b iBI;
        private final ScheduledExecutorService iBJ;
        private final Future<?> iBK;

        C0381a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.iBE = threadFactory;
            this.iBG = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iBH = new ConcurrentLinkedQueue<>();
            this.iBI = new rx.subscriptions.b();
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
                }, this.iBG, this.iBG, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iBJ = scheduledExecutorService;
            this.iBK = scheduledFuture;
        }

        c ccF() {
            if (this.iBI.isUnsubscribed()) {
                return a.iBC;
            }
            while (!this.iBH.isEmpty()) {
                c poll = this.iBH.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.iBE);
            this.iBI.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dK(now() + this.iBG);
            this.iBH.offer(cVar);
        }

        void ccG() {
            if (!this.iBH.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iBH.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ccH() <= now) {
                        if (this.iBH.remove(next)) {
                            this.iBI.b(next);
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
                if (this.iBK != null) {
                    this.iBK.cancel(true);
                }
                if (this.iBJ != null) {
                    this.iBJ.shutdownNow();
                }
            } finally {
                this.iBI.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.iBE = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0381a c0381a = new C0381a(this.iBE, iBA, iBB);
        if (!this.iBF.compareAndSet(iBD, c0381a)) {
            c0381a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0381a c0381a;
        do {
            c0381a = this.iBF.get();
            if (c0381a == iBD) {
                return;
            }
        } while (!this.iBF.compareAndSet(c0381a, iBD));
        c0381a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iBF.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0381a iBO;
        private final c iBP;
        private final rx.subscriptions.b iBN = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0381a c0381a) {
            this.iBO = c0381a;
            this.iBP = c0381a.ccF();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iBP.a(this);
            }
            this.iBN.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iBO.a(this.iBP);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iBN.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iBN.isUnsubscribed()) {
                return rx.subscriptions.e.cdU();
            }
            ScheduledAction b = this.iBP.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iBN.add(b);
            b.addParent(this.iBN);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iBR;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iBR = 0L;
        }

        public long ccH() {
            return this.iBR;
        }

        public void dK(long j) {
            this.iBR = j;
        }
    }
}
