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
/* loaded from: classes5.dex */
public final class a extends rx.g implements h {
    private static final long nQo;
    static final C0790a nQq;
    final ThreadFactory aNw;
    final AtomicReference<C0790a> nyn = new AtomicReference<>(nQq);
    private static final TimeUnit nyH = TimeUnit.SECONDS;
    static final c nQp = new c(RxThreadFactory.NONE);

    static {
        nQp.unsubscribe();
        nQq = new C0790a(null, 0L, null);
        nQq.shutdown();
        nQo = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0790a {
        private final ThreadFactory aNw;
        private final rx.subscriptions.b nQr;
        private final long nyK;
        private final ConcurrentLinkedQueue<c> nyL;
        private final ScheduledExecutorService nyN;
        private final Future<?> nyO;

        C0790a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aNw = threadFactory;
            this.nyK = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nyL = new ConcurrentLinkedQueue<>();
            this.nQr = new rx.subscriptions.b();
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
                        C0790a.this.dIq();
                    }
                }, this.nyK, this.nyK, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nyN = scheduledExecutorService;
            this.nyO = scheduledFuture;
        }

        c dNg() {
            if (this.nQr.isUnsubscribed()) {
                return a.nQp;
            }
            while (!this.nyL.isEmpty()) {
                c poll = this.nyL.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aNw);
            this.nQr.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hf(now() + this.nyK);
            this.nyL.offer(cVar);
        }

        void dIq() {
            if (!this.nyL.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nyL.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dIr() <= now) {
                        if (this.nyL.remove(next)) {
                            this.nQr.a(next);
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
                if (this.nyO != null) {
                    this.nyO.cancel(true);
                }
                if (this.nyN != null) {
                    this.nyN.shutdownNow();
                }
            } finally {
                this.nQr.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0790a c0790a = new C0790a(this.aNw, nQo, nyH);
        if (!this.nyn.compareAndSet(nQq, c0790a)) {
            c0790a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0790a c0790a;
        do {
            c0790a = this.nyn.get();
            if (c0790a == nQq) {
                return;
            }
        } while (!this.nyn.compareAndSet(c0790a, nQq));
        c0790a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nyn.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0790a nQv;
        private final c nQw;
        private final rx.subscriptions.b nQu = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0790a c0790a) {
            this.nQv = c0790a;
            this.nQw = c0790a.dNg();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nQw.c(this);
            }
            this.nQu.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nQv.a(this.nQw);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nQu.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nQu.isUnsubscribed()) {
                return rx.subscriptions.e.dOl();
            }
            ScheduledAction b = this.nQw.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nQu.add(b);
            b.addParent(this.nQu);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long nyR;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nyR = 0L;
        }

        public long dIr() {
            return this.nyR;
        }

        public void hf(long j) {
            this.nyR = j;
        }
    }
}
