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
    private static final long qBQ;
    static final C1325a qBS;
    final ThreadFactory qqw;
    final AtomicReference<C1325a> qqx = new AtomicReference<>(qBS);
    private static final TimeUnit qqR = TimeUnit.SECONDS;
    static final c qBR = new c(RxThreadFactory.NONE);

    static {
        qBR.unsubscribe();
        qBS = new C1325a(null, 0L, null);
        qBS.shutdown();
        qBQ = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1325a {
        private final rx.subscriptions.b qBT;
        private final long qqU;
        private final ConcurrentLinkedQueue<c> qqV;
        private final ScheduledExecutorService qqX;
        private final Future<?> qqY;
        private final ThreadFactory qqw;

        C1325a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qqw = threadFactory;
            this.qqU = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qqV = new ConcurrentLinkedQueue<>();
            this.qBT = new rx.subscriptions.b();
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
                        C1325a.this.eKA();
                    }
                }, this.qqU, this.qqU, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qqX = scheduledExecutorService;
            this.qqY = scheduledFuture;
        }

        c eNg() {
            if (this.qBT.isUnsubscribed()) {
                return a.qBR;
            }
            while (!this.qqV.isEmpty()) {
                c poll = this.qqV.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qqw);
            this.qBT.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jx(now() + this.qqU);
            this.qqV.offer(cVar);
        }

        void eKA() {
            if (!this.qqV.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qqV.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eKB() <= now) {
                        if (this.qqV.remove(next)) {
                            this.qBT.a(next);
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
                if (this.qqY != null) {
                    this.qqY.cancel(true);
                }
                if (this.qqX != null) {
                    this.qqX.shutdownNow();
                }
            } finally {
                this.qBT.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qqw = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1325a c1325a = new C1325a(this.qqw, qBQ, qqR);
        if (!this.qqx.compareAndSet(qBS, c1325a)) {
            c1325a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1325a c1325a;
        do {
            c1325a = this.qqx.get();
            if (c1325a == qBS) {
                return;
            }
        } while (!this.qqx.compareAndSet(c1325a, qBS));
        c1325a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qqx.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1325a qBX;
        private final c qBY;
        private final rx.subscriptions.b qBW = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1325a c1325a) {
            this.qBX = c1325a;
            this.qBY = c1325a.eNg();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.qBY.c(this);
            }
            this.qBW.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.qBX.a(this.qBY);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.qBW.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.qBW.isUnsubscribed()) {
                return rx.subscriptions.e.eOn();
            }
            ScheduledAction b2 = this.qBY.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.qBW.add(b2);
            b2.addParent(this.qBW);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long qrb;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qrb = 0L;
        }

        public long eKB() {
            return this.qrb;
        }

        public void jx(long j) {
            this.qrb = j;
        }
    }
}
