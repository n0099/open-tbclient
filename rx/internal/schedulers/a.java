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
/* loaded from: classes4.dex */
public final class a extends rx.g implements h {
    private static final long nhq;
    static final C0736a nhs;
    final ThreadFactory aME;
    final AtomicReference<C0736a> mWe = new AtomicReference<>(nhs);
    private static final TimeUnit mWy = TimeUnit.SECONDS;
    static final c nhr = new c(RxThreadFactory.NONE);

    static {
        nhr.unsubscribe();
        nhs = new C0736a(null, 0L, null);
        nhs.shutdown();
        nhq = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0736a {
        private final ThreadFactory aME;
        private final long mWB;
        private final ConcurrentLinkedQueue<c> mWC;
        private final ScheduledExecutorService mWE;
        private final Future<?> mWF;
        private final rx.subscriptions.b nht;

        C0736a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aME = threadFactory;
            this.mWB = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mWC = new ConcurrentLinkedQueue<>();
            this.nht = new rx.subscriptions.b();
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
                        C0736a.this.dEg();
                    }
                }, this.mWB, this.mWB, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mWE = scheduledExecutorService;
            this.mWF = scheduledFuture;
        }

        c dGF() {
            if (this.nht.isUnsubscribed()) {
                return a.nhr;
            }
            while (!this.mWC.isEmpty()) {
                c poll = this.mWC.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aME);
            this.nht.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gT(now() + this.mWB);
            this.mWC.offer(cVar);
        }

        void dEg() {
            if (!this.mWC.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mWC.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dEh() <= now) {
                        if (this.mWC.remove(next)) {
                            this.nht.a(next);
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
                if (this.mWF != null) {
                    this.mWF.cancel(true);
                }
                if (this.mWE != null) {
                    this.mWE.shutdownNow();
                }
            } finally {
                this.nht.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aME = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0736a c0736a = new C0736a(this.aME, nhq, mWy);
        if (!this.mWe.compareAndSet(nhs, c0736a)) {
            c0736a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0736a c0736a;
        do {
            c0736a = this.mWe.get();
            if (c0736a == nhs) {
                return;
            }
        } while (!this.mWe.compareAndSet(c0736a, nhs));
        c0736a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.mWe.get());
    }

    /* loaded from: classes4.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0736a nhx;
        private final c nhy;
        private final rx.subscriptions.b nhw = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0736a c0736a) {
            this.nhx = c0736a;
            this.nhy = c0736a.dGF();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nhy.c(this);
            }
            this.nhw.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nhx.a(this.nhy);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nhw.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nhw.isUnsubscribed()) {
                return rx.subscriptions.e.dHK();
            }
            ScheduledAction b = this.nhy.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nhw.add(b);
            b.addParent(this.nhw);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class c extends g {
        private long mWI;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mWI = 0L;
        }

        public long dEh() {
            return this.mWI;
        }

        public void gT(long j) {
            this.mWI = j;
        }
    }
}
