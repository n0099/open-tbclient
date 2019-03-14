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
    private static final long jZr;
    private static final TimeUnit jZs = TimeUnit.SECONDS;
    static final c jZt = new c(RxThreadFactory.NONE);
    static final C0489a jZu;
    final ThreadFactory agG;
    final AtomicReference<C0489a> jZv = new AtomicReference<>(jZu);

    static {
        jZt.unsubscribe();
        jZu = new C0489a(null, 0L, null);
        jZu.shutdown();
        jZr = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0489a {
        private final ThreadFactory agG;
        private final Future<?> jZA;
        private final long jZw;
        private final ConcurrentLinkedQueue<c> jZx;
        private final rx.subscriptions.b jZy;
        private final ScheduledExecutorService jZz;

        C0489a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agG = threadFactory;
            this.jZw = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.jZx = new ConcurrentLinkedQueue<>();
            this.jZy = new rx.subscriptions.b();
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
                        C0489a.this.cEu();
                    }
                }, this.jZw, this.jZw, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.jZz = scheduledExecutorService;
            this.jZA = scheduledFuture;
        }

        c cEt() {
            if (this.jZy.isUnsubscribed()) {
                return a.jZt;
            }
            while (!this.jZx.isEmpty()) {
                c poll = this.jZx.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agG);
            this.jZy.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eo(now() + this.jZw);
            this.jZx.offer(cVar);
        }

        void cEu() {
            if (!this.jZx.isEmpty()) {
                long now = now();
                Iterator<c> it = this.jZx.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cEv() <= now) {
                        if (this.jZx.remove(next)) {
                            this.jZy.a(next);
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
                if (this.jZA != null) {
                    this.jZA.cancel(true);
                }
                if (this.jZz != null) {
                    this.jZz.shutdownNow();
                }
            } finally {
                this.jZy.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agG = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0489a c0489a = new C0489a(this.agG, jZr, jZs);
        if (!this.jZv.compareAndSet(jZu, c0489a)) {
            c0489a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0489a c0489a;
        do {
            c0489a = this.jZv.get();
            if (c0489a == jZu) {
                return;
            }
        } while (!this.jZv.compareAndSet(c0489a, jZu));
        c0489a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.jZv.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0489a jZE;
        private final c jZF;
        private final rx.subscriptions.b jZD = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0489a c0489a) {
            this.jZE = c0489a;
            this.jZF = c0489a.cEt();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.jZF.c(this);
            }
            this.jZD.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.jZE.a(this.jZF);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZD.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.jZD.isUnsubscribed()) {
                return rx.subscriptions.e.cFG();
            }
            ScheduledAction b = this.jZF.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.jZD.add(b);
            b.addParent(this.jZD);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long jZI;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.jZI = 0L;
        }

        public long cEv() {
            return this.jZI;
        }

        public void eo(long j) {
            this.jZI = j;
        }
    }
}
