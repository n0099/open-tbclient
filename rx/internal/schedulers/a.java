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
    private static final long nRi;
    static final C0798a nRk;
    final ThreadFactory aRV;
    final AtomicReference<C0798a> nyU = new AtomicReference<>(nRk);
    private static final TimeUnit nzo = TimeUnit.SECONDS;
    static final c nRj = new c(RxThreadFactory.NONE);

    static {
        nRj.unsubscribe();
        nRk = new C0798a(null, 0L, null);
        nRk.shutdown();
        nRi = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0798a {
        private final ThreadFactory aRV;
        private final rx.subscriptions.b nRl;
        private final long nzr;
        private final ConcurrentLinkedQueue<c> nzs;
        private final ScheduledExecutorService nzu;
        private final Future<?> nzv;

        C0798a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aRV = threadFactory;
            this.nzr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nzs = new ConcurrentLinkedQueue<>();
            this.nRl = new rx.subscriptions.b();
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
                        C0798a.this.dJz();
                    }
                }, this.nzr, this.nzr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nzu = scheduledExecutorService;
            this.nzv = scheduledFuture;
        }

        c dOv() {
            if (this.nRl.isUnsubscribed()) {
                return a.nRj;
            }
            while (!this.nzs.isEmpty()) {
                c poll = this.nzs.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aRV);
            this.nRl.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hd(now() + this.nzr);
            this.nzs.offer(cVar);
        }

        void dJz() {
            if (!this.nzs.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nzs.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dJA() <= now) {
                        if (this.nzs.remove(next)) {
                            this.nRl.a(next);
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
                if (this.nzv != null) {
                    this.nzv.cancel(true);
                }
                if (this.nzu != null) {
                    this.nzu.shutdownNow();
                }
            } finally {
                this.nRl.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aRV = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0798a c0798a = new C0798a(this.aRV, nRi, nzo);
        if (!this.nyU.compareAndSet(nRk, c0798a)) {
            c0798a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0798a c0798a;
        do {
            c0798a = this.nyU.get();
            if (c0798a == nRk) {
                return;
            }
        } while (!this.nyU.compareAndSet(c0798a, nRk));
        c0798a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nyU.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0798a nRp;
        private final c nRq;
        private final rx.subscriptions.b nRo = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0798a c0798a) {
            this.nRp = c0798a;
            this.nRq = c0798a.dOv();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nRq.c(this);
            }
            this.nRo.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nRp.a(this.nRq);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nRo.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nRo.isUnsubscribed()) {
                return rx.subscriptions.e.dPA();
            }
            ScheduledAction b = this.nRq.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nRo.add(b);
            b.addParent(this.nRo);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nzy;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nzy = 0L;
        }

        public long dJA() {
            return this.nzy;
        }

        public void hd(long j) {
            this.nzy = j;
        }
    }
}
