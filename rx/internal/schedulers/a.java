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
    private static final long jZg;
    private static final TimeUnit jZh = TimeUnit.SECONDS;
    static final c jZi = new c(RxThreadFactory.NONE);
    static final C0391a jZj;
    final ThreadFactory agF;
    final AtomicReference<C0391a> jZk = new AtomicReference<>(jZj);

    static {
        jZi.unsubscribe();
        jZj = new C0391a(null, 0L, null);
        jZj.shutdown();
        jZg = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0391a {
        private final ThreadFactory agF;
        private final long jZl;
        private final ConcurrentLinkedQueue<c> jZm;
        private final rx.subscriptions.b jZn;
        private final ScheduledExecutorService jZo;
        private final Future<?> jZp;

        C0391a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.agF = threadFactory;
            this.jZl = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.jZm = new ConcurrentLinkedQueue<>();
            this.jZn = new rx.subscriptions.b();
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
                        C0391a.this.cEh();
                    }
                }, this.jZl, this.jZl, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.jZo = scheduledExecutorService;
            this.jZp = scheduledFuture;
        }

        c cEg() {
            if (this.jZn.isUnsubscribed()) {
                return a.jZi;
            }
            while (!this.jZm.isEmpty()) {
                c poll = this.jZm.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.agF);
            this.jZn.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eo(now() + this.jZl);
            this.jZm.offer(cVar);
        }

        void cEh() {
            if (!this.jZm.isEmpty()) {
                long now = now();
                Iterator<c> it = this.jZm.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cEi() <= now) {
                        if (this.jZm.remove(next)) {
                            this.jZn.a(next);
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
                if (this.jZp != null) {
                    this.jZp.cancel(true);
                }
                if (this.jZo != null) {
                    this.jZo.shutdownNow();
                }
            } finally {
                this.jZn.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.agF = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0391a c0391a = new C0391a(this.agF, jZg, jZh);
        if (!this.jZk.compareAndSet(jZj, c0391a)) {
            c0391a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0391a c0391a;
        do {
            c0391a = this.jZk.get();
            if (c0391a == jZj) {
                return;
            }
        } while (!this.jZk.compareAndSet(c0391a, jZj));
        c0391a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.jZk.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0391a jZt;
        private final c jZu;
        private final rx.subscriptions.b jZs = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0391a c0391a) {
            this.jZt = c0391a;
            this.jZu = c0391a.cEg();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.jZu.c(this);
            }
            this.jZs.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.jZt.a(this.jZu);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.jZs.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.jZs.isUnsubscribed()) {
                return rx.subscriptions.e.cFt();
            }
            ScheduledAction b = this.jZu.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.jZs.add(b);
            b.addParent(this.jZs);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long jZx;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.jZx = 0L;
        }

        public long cEi() {
            return this.jZx;
        }

        public void eo(long j) {
            this.jZx = j;
        }
    }
}
