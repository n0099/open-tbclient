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
    private static final long oHQ;
    static final C0999a oHS;
    final ThreadFactory opB;
    final AtomicReference<C0999a> opC = new AtomicReference<>(oHS);
    private static final TimeUnit opW = TimeUnit.SECONDS;
    static final c oHR = new c(RxThreadFactory.NONE);

    static {
        oHR.unsubscribe();
        oHS = new C0999a(null, 0L, null);
        oHS.shutdown();
        oHQ = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0999a {
        private final rx.subscriptions.b oHT;
        private final ThreadFactory opB;
        private final long opZ;
        private final ConcurrentLinkedQueue<c> oqa;
        private final ScheduledExecutorService oqc;
        private final Future<?> oqd;

        C0999a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.opB = threadFactory;
            this.opZ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.oqa = new ConcurrentLinkedQueue<>();
            this.oHT = new rx.subscriptions.b();
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
                        C0999a.this.efy();
                    }
                }, this.opZ, this.opZ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.oqc = scheduledExecutorService;
            this.oqd = scheduledFuture;
        }

        c ekx() {
            if (this.oHT.isUnsubscribed()) {
                return a.oHR;
            }
            while (!this.oqa.isEmpty()) {
                c poll = this.oqa.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.opB);
            this.oHT.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gN(now() + this.opZ);
            this.oqa.offer(cVar);
        }

        void efy() {
            if (!this.oqa.isEmpty()) {
                long now = now();
                Iterator<c> it = this.oqa.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.efz() <= now) {
                        if (this.oqa.remove(next)) {
                            this.oHT.a(next);
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
                if (this.oqd != null) {
                    this.oqd.cancel(true);
                }
                if (this.oqc != null) {
                    this.oqc.shutdownNow();
                }
            } finally {
                this.oHT.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.opB = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0999a c0999a = new C0999a(this.opB, oHQ, opW);
        if (!this.opC.compareAndSet(oHS, c0999a)) {
            c0999a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0999a c0999a;
        do {
            c0999a = this.opC.get();
            if (c0999a == oHS) {
                return;
            }
        } while (!this.opC.compareAndSet(c0999a, oHS));
        c0999a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.opC.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0999a oHX;
        private final c oHY;
        private final rx.subscriptions.b oHW = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0999a c0999a) {
            this.oHX = c0999a;
            this.oHY = c0999a.ekx();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.oHY.c(this);
            }
            this.oHW.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.oHX.a(this.oHY);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oHW.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.oHW.isUnsubscribed()) {
                return rx.subscriptions.e.elC();
            }
            ScheduledAction b = this.oHY.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.oHW.add(b);
            b.addParent(this.oHW);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long oqg;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.oqg = 0L;
        }

        public long efz() {
            return this.oqg;
        }

        public void gN(long j) {
            this.oqg = j;
        }
    }
}
