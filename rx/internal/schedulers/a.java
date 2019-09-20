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
    private static final long kCa;
    private static final TimeUnit kCb = TimeUnit.SECONDS;
    static final c kCc = new c(RxThreadFactory.NONE);
    static final C0522a kCd;
    final ThreadFactory ahQ;
    final AtomicReference<C0522a> kCe = new AtomicReference<>(kCd);

    static {
        kCc.unsubscribe();
        kCd = new C0522a(null, 0L, null);
        kCd.shutdown();
        kCa = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0522a {
        private final ThreadFactory ahQ;
        private final long kCf;
        private final ConcurrentLinkedQueue<c> kCg;
        private final rx.subscriptions.b kCh;
        private final ScheduledExecutorService kCi;
        private final Future<?> kCj;

        C0522a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.ahQ = threadFactory;
            this.kCf = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.kCg = new ConcurrentLinkedQueue<>();
            this.kCh = new rx.subscriptions.b();
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
                        C0522a.this.cQM();
                    }
                }, this.kCf, this.kCf, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.kCi = scheduledExecutorService;
            this.kCj = scheduledFuture;
        }

        c cQL() {
            if (this.kCh.isUnsubscribed()) {
                return a.kCc;
            }
            while (!this.kCg.isEmpty()) {
                c poll = this.kCg.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.ahQ);
            this.kCh.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.eY(now() + this.kCf);
            this.kCg.offer(cVar);
        }

        void cQM() {
            if (!this.kCg.isEmpty()) {
                long now = now();
                Iterator<c> it = this.kCg.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.cQN() <= now) {
                        if (this.kCg.remove(next)) {
                            this.kCh.a(next);
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
                if (this.kCj != null) {
                    this.kCj.cancel(true);
                }
                if (this.kCi != null) {
                    this.kCi.shutdownNow();
                }
            } finally {
                this.kCh.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.ahQ = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0522a c0522a = new C0522a(this.ahQ, kCa, kCb);
        if (!this.kCe.compareAndSet(kCd, c0522a)) {
            c0522a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0522a c0522a;
        do {
            c0522a = this.kCe.get();
            if (c0522a == kCd) {
                return;
            }
        } while (!this.kCe.compareAndSet(c0522a, kCd));
        c0522a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.kCe.get());
    }

    /* loaded from: classes2.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0522a kCn;
        private final c kCo;
        private final rx.subscriptions.b kCm = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0522a c0522a) {
            this.kCn = c0522a;
            this.kCo = c0522a.cQL();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.kCo.c(this);
            }
            this.kCm.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.kCn.a(this.kCo);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.kCm.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.kCm.isUnsubscribed()) {
                return rx.subscriptions.e.cSa();
            }
            ScheduledAction b = this.kCo.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.kCm.add(b);
            b.addParent(this.kCm);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c extends g {
        private long kCr;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.kCr = 0L;
        }

        public long cQN() {
            return this.kCr;
        }

        public void eY(long j) {
            this.kCr = j;
        }
    }
}
