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
/* loaded from: classes15.dex */
public final class a extends rx.g implements h {
    private static final long qwo;
    static final C1332a qwq;
    final ThreadFactory qkT;
    final AtomicReference<C1332a> qkU = new AtomicReference<>(qwq);
    private static final TimeUnit qlo = TimeUnit.SECONDS;
    static final c qwp = new c(RxThreadFactory.NONE);

    static {
        qwp.unsubscribe();
        qwq = new C1332a(null, 0L, null);
        qwq.shutdown();
        qwo = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1332a {
        private final ThreadFactory qkT;
        private final long qlr;
        private final ConcurrentLinkedQueue<c> qls;
        private final ScheduledExecutorService qlu;
        private final Future<?> qlv;
        private final rx.subscriptions.b qwr;

        C1332a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qkT = threadFactory;
            this.qlr = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qls = new ConcurrentLinkedQueue<>();
            this.qwr = new rx.subscriptions.b();
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.a.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread newThread = threadFactory.newThread(runnable);
                        newThread.setName(newThread.getName() + " (Evictor)");
                        return newThread;
                    }
                });
                g.b(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1332a.this.eMa();
                    }
                }, this.qlr, this.qlr, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qlu = scheduledExecutorService;
            this.qlv = scheduledFuture;
        }

        c eOG() {
            if (this.qwr.isUnsubscribed()) {
                return a.qwp;
            }
            while (!this.qls.isEmpty()) {
                c poll = this.qls.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qkT);
            this.qwr.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.ju(now() + this.qlr);
            this.qls.offer(cVar);
        }

        void eMa() {
            if (!this.qls.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qls.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eMb() <= now) {
                        if (this.qls.remove(next)) {
                            this.qwr.a(next);
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
                if (this.qlv != null) {
                    this.qlv.cancel(true);
                }
                if (this.qlu != null) {
                    this.qlu.shutdownNow();
                }
            } finally {
                this.qwr.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qkT = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1332a c1332a = new C1332a(this.qkT, qwo, qlo);
        if (!this.qkU.compareAndSet(qwq, c1332a)) {
            c1332a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1332a c1332a;
        do {
            c1332a = this.qkU.get();
            if (c1332a == qwq) {
                return;
            }
        } while (!this.qkU.compareAndSet(c1332a, qwq));
        c1332a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qkU.get());
    }

    /* loaded from: classes15.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1332a qwv;
        private final c qww;
        private final rx.subscriptions.b qwu = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1332a c1332a) {
            this.qwv = c1332a;
            this.qww = c1332a.eOG();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qww.c(this);
            }
            this.qwu.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qwv.a(this.qww);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qwu.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qwu.isUnsubscribed()) {
                return rx.subscriptions.e.ePN();
            }
            ScheduledAction b2 = this.qww.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qwu.add(b2);
            b2.addParent(this.qwu);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class c extends g {
        private long qly;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qly = 0L;
        }

        public long eMb() {
            return this.qly;
        }

        public void ju(long j) {
            this.qly = j;
        }
    }
}
