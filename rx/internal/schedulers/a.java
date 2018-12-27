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
    private static final long iND;
    private static final TimeUnit iNE = TimeUnit.SECONDS;
    static final c iNF = new c(RxThreadFactory.NONE);
    static final C0423a iNG;
    final ThreadFactory ahS;
    final AtomicReference<C0423a> iNH = new AtomicReference<>(iNG);

    static {
        iNF.unsubscribe();
        iNG = new C0423a(null, 0L, null);
        iNG.shutdown();
        iND = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0423a {
        private final ThreadFactory ahS;
        private final long iNI;
        private final ConcurrentLinkedQueue<c> iNJ;
        private final rx.subscriptions.b iNK;
        private final ScheduledExecutorService iNL;
        private final Future<?> iNM;

        C0423a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ahS = threadFactory;
            this.iNI = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.iNJ = new ConcurrentLinkedQueue<>();
            this.iNK = new rx.subscriptions.b();
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
                        C0423a.this.ceW();
                    }
                }, this.iNI, this.iNI, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.iNL = scheduledExecutorService;
            this.iNM = scheduledFuture;
        }

        c ceV() {
            if (this.iNK.isUnsubscribed()) {
                return a.iNF;
            }
            while (!this.iNJ.isEmpty()) {
                c poll = this.iNJ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ahS);
            this.iNK.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.dR(now() + this.iNI);
            this.iNJ.offer(cVar);
        }

        void ceW() {
            if (!this.iNJ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.iNJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.ceX() <= now) {
                        if (this.iNJ.remove(next)) {
                            this.iNK.b(next);
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
                if (this.iNM != null) {
                    this.iNM.cancel(true);
                }
                if (this.iNL != null) {
                    this.iNL.shutdownNow();
                }
            } finally {
                this.iNK.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ahS = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0423a c0423a = new C0423a(this.ahS, iND, iNE);
        if (!this.iNH.compareAndSet(iNG, c0423a)) {
            c0423a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0423a c0423a;
        do {
            c0423a = this.iNH.get();
            if (c0423a == iNG) {
                return;
            }
        } while (!this.iNH.compareAndSet(c0423a, iNG));
        c0423a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.iNH.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0423a iNQ;
        private final c iNR;
        private final rx.subscriptions.b iNP = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0423a c0423a) {
            this.iNQ = c0423a;
            this.iNR = c0423a.ceV();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.iNR.a(this);
            }
            this.iNP.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.iNQ.a(this.iNR);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.iNP.isUnsubscribed();
        }

        @Override // rx.g.a
        public k a(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.iNP.isUnsubscribed()) {
                return rx.subscriptions.e.cgk();
            }
            ScheduledAction b = this.iNR.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.iNP.add(b);
            b.addParent(this.iNP);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long iNT;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.iNT = 0L;
        }

        public long ceX() {
            return this.iNT;
        }

        public void dR(long j) {
            this.iNT = j;
        }
    }
}
