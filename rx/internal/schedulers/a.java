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
    static final C0999a oHA;
    private static final long oHy;
    final ThreadFactory opi;
    final AtomicReference<C0999a> opj = new AtomicReference<>(oHA);
    private static final TimeUnit opE = TimeUnit.SECONDS;
    static final c oHz = new c(RxThreadFactory.NONE);

    static {
        oHz.unsubscribe();
        oHA = new C0999a(null, 0L, null);
        oHA.shutdown();
        oHy = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0999a {
        private final rx.subscriptions.b oHB;
        private final long opH;
        private final ConcurrentLinkedQueue<c> opI;
        private final ScheduledExecutorService opK;
        private final Future<?> opL;
        private final ThreadFactory opi;

        C0999a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.opi = threadFactory;
            this.opH = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.opI = new ConcurrentLinkedQueue<>();
            this.oHB = new rx.subscriptions.b();
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
                        C0999a.this.efp();
                    }
                }, this.opH, this.opH, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.opK = scheduledExecutorService;
            this.opL = scheduledFuture;
        }

        c eko() {
            if (this.oHB.isUnsubscribed()) {
                return a.oHz;
            }
            while (!this.opI.isEmpty()) {
                c poll = this.opI.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.opi);
            this.oHB.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gL(now() + this.opH);
            this.opI.offer(cVar);
        }

        void efp() {
            if (!this.opI.isEmpty()) {
                long now = now();
                Iterator<c> it = this.opI.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.efq() <= now) {
                        if (this.opI.remove(next)) {
                            this.oHB.a(next);
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
                if (this.opL != null) {
                    this.opL.cancel(true);
                }
                if (this.opK != null) {
                    this.opK.shutdownNow();
                }
            } finally {
                this.oHB.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.opi = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0999a c0999a = new C0999a(this.opi, oHy, opE);
        if (!this.opj.compareAndSet(oHA, c0999a)) {
            c0999a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0999a c0999a;
        do {
            c0999a = this.opj.get();
            if (c0999a == oHA) {
                return;
            }
        } while (!this.opj.compareAndSet(c0999a, oHA));
        c0999a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.opj.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0999a oHF;
        private final c oHG;
        private final rx.subscriptions.b oHE = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0999a c0999a) {
            this.oHF = c0999a;
            this.oHG = c0999a.eko();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.oHG.c(this);
            }
            this.oHE.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.oHF.a(this.oHG);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.oHE.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.oHE.isUnsubscribed()) {
                return rx.subscriptions.e.elt();
            }
            ScheduledAction b = this.oHG.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.oHE.add(b);
            b.addParent(this.oHE);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long opO;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.opO = 0L;
        }

        public long efq() {
            return this.opO;
        }

        public void gL(long j) {
            this.opO = j;
        }
    }
}
