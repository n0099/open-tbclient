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
    private static final long nRk;
    static final C0798a nRm;
    final ThreadFactory aRW;
    final AtomicReference<C0798a> nyW = new AtomicReference<>(nRm);
    private static final TimeUnit nzq = TimeUnit.SECONDS;
    static final c nRl = new c(RxThreadFactory.NONE);

    static {
        nRl.unsubscribe();
        nRm = new C0798a(null, 0L, null);
        nRm.shutdown();
        nRk = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0798a {
        private final ThreadFactory aRW;
        private final rx.subscriptions.b nRn;
        private final long nzt;
        private final ConcurrentLinkedQueue<c> nzu;
        private final ScheduledExecutorService nzw;
        private final Future<?> nzx;

        C0798a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aRW = threadFactory;
            this.nzt = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzu = new ConcurrentLinkedQueue<>();
            this.nRn = new rx.subscriptions.b();
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
                        C0798a.this.dJB();
                    }
                }, this.nzt, this.nzt, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzw = scheduledExecutorService;
            this.nzx = scheduledFuture;
        }

        c dOx() {
            if (this.nRn.isUnsubscribed()) {
                return a.nRl;
            }
            while (!this.nzu.isEmpty()) {
                c poll = this.nzu.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRW);
            this.nRn.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzt);
            this.nzu.offer(cVar);
        }

        void dJB() {
            if (!this.nzu.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzu.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJC() <= now) {
                        if (this.nzu.remove(next)) {
                            this.nRn.a(next);
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
                if (this.nzx != null) {
                    this.nzx.cancel(true);
                }
                if (this.nzw != null) {
                    this.nzw.shutdownNow();
                }
            } finally {
                this.nRn.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aRW = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0798a c0798a = new C0798a(this.aRW, nRk, nzq);
        if (!this.nyW.compareAndSet(nRm, c0798a)) {
            c0798a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0798a c0798a;
        do {
            c0798a = this.nyW.get();
            if (c0798a == nRm) {
                return;
            }
        } while (!this.nyW.compareAndSet(c0798a, nRm));
        c0798a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nyW.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0798a nRr;
        private final c nRs;
        private final rx.subscriptions.b nRq = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0798a c0798a) {
            this.nRr = c0798a;
            this.nRs = c0798a.dOx();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nRs.c(this);
            }
            this.nRq.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nRr.a(this.nRs);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRq.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nRq.isUnsubscribed()) {
                return rx.subscriptions.e.dPC();
            }
            ScheduledAction b = this.nRs.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nRq.add(b);
            b.addParent(this.nRq);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nzA;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzA = 0L;
        }

        public long dJC() {
            return this.nzA;
        }

        public void hd(long j) {
            this.nzA = j;
        }
    }
}
