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
    private static final long kyC;
    private static final TimeUnit kyD = TimeUnit.SECONDS;
    static final c kyE = new c(RxThreadFactory.NONE);
    static final C0510a kyF;
    final ThreadFactory ahu;
    final AtomicReference<C0510a> kyG = new AtomicReference<>(kyF);

    static {
        kyE.unsubscribe();
        kyF = new C0510a(null, 0L, null);
        kyF.shutdown();
        kyC = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0510a {
        private final ThreadFactory ahu;
        private final long kyH;
        private final ConcurrentLinkedQueue<c> kyI;
        private final rx.subscriptions.b kyJ;
        private final ScheduledExecutorService kyK;
        private final Future<?> kyL;

        C0510a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ahu = threadFactory;
            this.kyH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.kyI = new ConcurrentLinkedQueue<>();
            this.kyJ = new rx.subscriptions.b();
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
                        C0510a.this.cPF();
                    }
                }, this.kyH, this.kyH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kyK = scheduledExecutorService;
            this.kyL = scheduledFuture;
        }

        c cPE() {
            if (this.kyJ.isUnsubscribed()) {
                return a.kyE;
            }
            while (!this.kyI.isEmpty()) {
                c poll = this.kyI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ahu);
            this.kyJ.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eV(now() + this.kyH);
            this.kyI.offer(cVar);
        }

        void cPF() {
            if (!this.kyI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.kyI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cPG() <= now) {
                        if (this.kyI.remove(next)) {
                            this.kyJ.a(next);
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
                if (this.kyL != null) {
                    this.kyL.cancel(true);
                }
                if (this.kyK != null) {
                    this.kyK.shutdownNow();
                }
            } finally {
                this.kyJ.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ahu = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0510a c0510a = new C0510a(this.ahu, kyC, kyD);
        if (!this.kyG.compareAndSet(kyF, c0510a)) {
            c0510a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0510a c0510a;
        do {
            c0510a = this.kyG.get();
            if (c0510a == kyF) {
                return;
            }
        } while (!this.kyG.compareAndSet(c0510a, kyF));
        c0510a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kyG.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0510a kyP;
        private final c kyQ;
        private final rx.subscriptions.b kyO = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0510a c0510a) {
            this.kyP = c0510a;
            this.kyQ = c0510a.cPE();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kyQ.c(this);
            }
            this.kyO.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.kyP.a(this.kyQ);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kyO.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.kyO.isUnsubscribed()) {
                return rx.subscriptions.e.cQT();
            }
            ScheduledAction b = this.kyQ.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.kyO.add(b);
            b.addParent(this.kyO);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kyT;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kyT = 0L;
        }

        public long cPG() {
            return this.kyT;
        }

        public void eV(long j) {
            this.kyT = j;
        }
    }
}
