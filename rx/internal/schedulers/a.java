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
    private static final long onB;
    static final C0941a onD;
    final ThreadFactory nVk;
    final AtomicReference<C0941a> nVl = new AtomicReference<>(onD);
    private static final TimeUnit nVF = TimeUnit.SECONDS;
    static final c onC = new c(RxThreadFactory.NONE);

    static {
        onC.unsubscribe();
        onD = new C0941a(null, 0L, null);
        onD.shutdown();
        onB = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0941a {
        private final long nVI;
        private final ConcurrentLinkedQueue<c> nVJ;
        private final ScheduledExecutorService nVL;
        private final Future<?> nVM;
        private final ThreadFactory nVk;
        private final rx.subscriptions.b onE;

        C0941a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.nVk = threadFactory;
            this.nVI = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nVJ = new ConcurrentLinkedQueue<>();
            this.onE = new rx.subscriptions.b();
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
                        C0941a.this.dTm();
                    }
                }, this.nVI, this.nVI, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nVL = scheduledExecutorService;
            this.nVM = scheduledFuture;
        }

        c dYj() {
            if (this.onE.isUnsubscribed()) {
                return a.onC;
            }
            while (!this.nVJ.isEmpty()) {
                c poll = this.nVJ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.nVk);
            this.onE.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gy(now() + this.nVI);
            this.nVJ.offer(cVar);
        }

        void dTm() {
            if (!this.nVJ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nVJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dTn() <= now) {
                        if (this.nVJ.remove(next)) {
                            this.onE.a(next);
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
                if (this.nVM != null) {
                    this.nVM.cancel(true);
                }
                if (this.nVL != null) {
                    this.nVL.shutdownNow();
                }
            } finally {
                this.onE.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.nVk = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0941a c0941a = new C0941a(this.nVk, onB, nVF);
        if (!this.nVl.compareAndSet(onD, c0941a)) {
            c0941a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0941a c0941a;
        do {
            c0941a = this.nVl.get();
            if (c0941a == onD) {
                return;
            }
        } while (!this.nVl.compareAndSet(c0941a, onD));
        c0941a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nVl.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0941a onI;
        private final c onJ;
        private final rx.subscriptions.b onH = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0941a c0941a) {
            this.onI = c0941a;
            this.onJ = c0941a.dYj();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.onJ.c(this);
            }
            this.onH.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.onI.a(this.onJ);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.onH.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.onH.isUnsubscribed()) {
                return rx.subscriptions.e.dZo();
            }
            ScheduledAction b = this.onJ.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.onH.add(b);
            b.addParent(this.onH);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nVP;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nVP = 0L;
        }

        public long dTn() {
            return this.nVP;
        }

        public void gy(long j) {
            this.nVP = j;
        }
    }
}
