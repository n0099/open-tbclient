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
    private static final long kzI;
    private static final TimeUnit kzJ = TimeUnit.SECONDS;
    static final c kzK = new c(RxThreadFactory.NONE);
    static final C0516a kzL;
    final ThreadFactory ahu;
    final AtomicReference<C0516a> kzM = new AtomicReference<>(kzL);

    static {
        kzK.unsubscribe();
        kzL = new C0516a(null, 0L, null);
        kzL.shutdown();
        kzI = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0516a {
        private final ThreadFactory ahu;
        private final long kzN;
        private final ConcurrentLinkedQueue<c> kzO;
        private final rx.subscriptions.b kzP;
        private final ScheduledExecutorService kzQ;
        private final Future<?> kzR;

        C0516a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ahu = threadFactory;
            this.kzN = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.kzO = new ConcurrentLinkedQueue<>();
            this.kzP = new rx.subscriptions.b();
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
                        C0516a.this.cQa();
                    }
                }, this.kzN, this.kzN, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kzQ = scheduledExecutorService;
            this.kzR = scheduledFuture;
        }

        c cPZ() {
            if (this.kzP.isUnsubscribed()) {
                return a.kzK;
            }
            while (!this.kzO.isEmpty()) {
                c poll = this.kzO.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ahu);
            this.kzP.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eV(now() + this.kzN);
            this.kzO.offer(cVar);
        }

        void cQa() {
            if (!this.kzO.isEmpty()) {
                long now = now();
                Iterator<c> it = this.kzO.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cQb() <= now) {
                        if (this.kzO.remove(next)) {
                            this.kzP.a(next);
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
                if (this.kzR != null) {
                    this.kzR.cancel(true);
                }
                if (this.kzQ != null) {
                    this.kzQ.shutdownNow();
                }
            } finally {
                this.kzP.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ahu = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0516a c0516a = new C0516a(this.ahu, kzI, kzJ);
        if (!this.kzM.compareAndSet(kzL, c0516a)) {
            c0516a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0516a c0516a;
        do {
            c0516a = this.kzM.get();
            if (c0516a == kzL) {
                return;
            }
        } while (!this.kzM.compareAndSet(c0516a, kzL));
        c0516a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kzM.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0516a kzV;
        private final c kzW;
        private final rx.subscriptions.b kzU = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0516a c0516a) {
            this.kzV = c0516a;
            this.kzW = c0516a.cPZ();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kzW.c(this);
            }
            this.kzU.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.kzV.a(this.kzW);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kzU.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.kzU.isUnsubscribed()) {
                return rx.subscriptions.e.cRo();
            }
            ScheduledAction b = this.kzW.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.kzU.add(b);
            b.addParent(this.kzU);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kzZ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kzZ = 0L;
        }

        public long cQb() {
            return this.kzZ;
        }

        public void eV(long j) {
            this.kzZ = j;
        }
    }
}
