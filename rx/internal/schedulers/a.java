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
    private static final long nTi;
    static final C0799a nTk;
    final ThreadFactory aSk;
    final AtomicReference<C0799a> nAU = new AtomicReference<>(nTk);
    private static final TimeUnit nBo = TimeUnit.SECONDS;
    static final c nTj = new c(RxThreadFactory.NONE);

    static {
        nTj.unsubscribe();
        nTk = new C0799a(null, 0L, null);
        nTk.shutdown();
        nTi = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0799a {
        private final ThreadFactory aSk;
        private final long nBr;
        private final ConcurrentLinkedQueue<c> nBs;
        private final ScheduledExecutorService nBu;
        private final Future<?> nBv;
        private final rx.subscriptions.b nTl;

        C0799a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aSk = threadFactory;
            this.nBr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nBs = new ConcurrentLinkedQueue<>();
            this.nTl = new rx.subscriptions.b();
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
                        C0799a.this.dKc();
                    }
                }, this.nBr, this.nBr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nBu = scheduledExecutorService;
            this.nBv = scheduledFuture;
        }

        c dOY() {
            if (this.nTl.isUnsubscribed()) {
                return a.nTj;
            }
            while (!this.nBs.isEmpty()) {
                c poll = this.nBs.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aSk);
            this.nTl.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.he(now() + this.nBr);
            this.nBs.offer(cVar);
        }

        void dKc() {
            if (!this.nBs.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nBs.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dKd() <= now) {
                        if (this.nBs.remove(next)) {
                            this.nTl.a(next);
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
                if (this.nBv != null) {
                    this.nBv.cancel(true);
                }
                if (this.nBu != null) {
                    this.nBu.shutdownNow();
                }
            } finally {
                this.nTl.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aSk = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0799a c0799a = new C0799a(this.aSk, nTi, nBo);
        if (!this.nAU.compareAndSet(nTk, c0799a)) {
            c0799a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0799a c0799a;
        do {
            c0799a = this.nAU.get();
            if (c0799a == nTk) {
                return;
            }
        } while (!this.nAU.compareAndSet(c0799a, nTk));
        c0799a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nAU.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0799a nTp;
        private final c nTq;
        private final rx.subscriptions.b nTo = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0799a c0799a) {
            this.nTp = c0799a;
            this.nTq = c0799a.dOY();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nTq.c(this);
            }
            this.nTo.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nTp.a(this.nTq);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nTo.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nTo.isUnsubscribed()) {
                return rx.subscriptions.e.dQd();
            }
            ScheduledAction b = this.nTq.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nTo.add(b);
            b.addParent(this.nTo);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nBy;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nBy = 0L;
        }

        public long dKd() {
            return this.nBy;
        }

        public void he(long j) {
            this.nBy = j;
        }
    }
}
