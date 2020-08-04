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
/* loaded from: classes6.dex */
public final class a extends rx.g implements h {
    private static final long onD;
    static final C0941a onF;
    final ThreadFactory nVm;
    final AtomicReference<C0941a> nVn = new AtomicReference<>(onF);
    private static final TimeUnit nVH = TimeUnit.SECONDS;
    static final c onE = new c(RxThreadFactory.NONE);

    static {
        onE.unsubscribe();
        onF = new C0941a(null, 0L, null);
        onF.shutdown();
        onD = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0941a {
        private final long nVK;
        private final ConcurrentLinkedQueue<c> nVL;
        private final ScheduledExecutorService nVN;
        private final Future<?> nVO;
        private final ThreadFactory nVm;
        private final rx.subscriptions.b onG;

        C0941a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nVm = threadFactory;
            this.nVK = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nVL = new ConcurrentLinkedQueue<>();
            this.onG = new rx.subscriptions.b();
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
                        C0941a.this.dTn();
                    }
                }, this.nVK, this.nVK, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nVN = scheduledExecutorService;
            this.nVO = scheduledFuture;
        }

        c dYk() {
            if (this.onG.isUnsubscribed()) {
                return a.onE;
            }
            while (!this.nVL.isEmpty()) {
                c poll = this.nVL.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.nVm);
            this.onG.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gy(now() + this.nVK);
            this.nVL.offer(cVar);
        }

        void dTn() {
            if (!this.nVL.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nVL.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dTo() <= now) {
                        if (this.nVL.remove(next)) {
                            this.onG.a(next);
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
                if (this.nVO != null) {
                    this.nVO.cancel(true);
                }
                if (this.nVN != null) {
                    this.nVN.shutdownNow();
                }
            } finally {
                this.onG.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.nVm = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0941a c0941a = new C0941a(this.nVm, onD, nVH);
        if (!this.nVn.compareAndSet(onF, c0941a)) {
            c0941a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0941a c0941a;
        do {
            c0941a = this.nVn.get();
            if (c0941a == onF) {
                return;
            }
        } while (!this.nVn.compareAndSet(c0941a, onF));
        c0941a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nVn.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0941a onK;
        private final c onL;
        private final rx.subscriptions.b onJ = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0941a c0941a) {
            this.onK = c0941a;
            this.onL = c0941a.dYk();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.onL.c(this);
            }
            this.onJ.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.onK.a(this.onL);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.onJ.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.onJ.isUnsubscribed()) {
                return rx.subscriptions.e.dZp();
            }
            ScheduledAction b = this.onL.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.onJ.add(b);
            b.addParent(this.onJ);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nVR;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nVR = 0L;
        }

        public long dTo() {
            return this.nVR;
        }

        public void gy(long j) {
            this.nVR = j;
        }
    }
}
