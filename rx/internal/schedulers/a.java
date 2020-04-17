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
    private static final long nmP;
    static final C0822a nmR;
    final ThreadFactory bon;
    final AtomicReference<C0822a> mUw = new AtomicReference<>(nmR);
    private static final TimeUnit mUQ = TimeUnit.SECONDS;
    static final c nmQ = new c(RxThreadFactory.NONE);

    static {
        nmQ.unsubscribe();
        nmR = new C0822a(null, 0L, null);
        nmR.shutdown();
        nmP = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0822a {
        private final ThreadFactory bon;
        private final long mUT;
        private final ConcurrentLinkedQueue<c> mUU;
        private final ScheduledExecutorService mUW;
        private final Future<?> mUX;
        private final rx.subscriptions.b nmS;

        C0822a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bon = threadFactory;
            this.mUT = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mUU = new ConcurrentLinkedQueue<>();
            this.nmS = new rx.subscriptions.b();
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
                        C0822a.this.dDb();
                    }
                }, this.mUT, this.mUT, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mUW = scheduledExecutorService;
            this.mUX = scheduledFuture;
        }

        c dHY() {
            if (this.nmS.isUnsubscribed()) {
                return a.nmQ;
            }
            while (!this.mUU.isEmpty()) {
                c poll = this.mUU.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bon);
            this.nmS.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gf(now() + this.mUT);
            this.mUU.offer(cVar);
        }

        void dDb() {
            if (!this.mUU.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mUU.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dDc() <= now) {
                        if (this.mUU.remove(next)) {
                            this.nmS.a(next);
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
                if (this.mUX != null) {
                    this.mUX.cancel(true);
                }
                if (this.mUW != null) {
                    this.mUW.shutdownNow();
                }
            } finally {
                this.nmS.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bon = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0822a c0822a = new C0822a(this.bon, nmP, mUQ);
        if (!this.mUw.compareAndSet(nmR, c0822a)) {
            c0822a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0822a c0822a;
        do {
            c0822a = this.mUw.get();
            if (c0822a == nmR) {
                return;
            }
        } while (!this.mUw.compareAndSet(c0822a, nmR));
        c0822a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.mUw.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0822a nmW;
        private final c nmX;
        private final rx.subscriptions.b nmV = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0822a c0822a) {
            this.nmW = c0822a;
            this.nmX = c0822a.dHY();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nmX.c(this);
            }
            this.nmV.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nmW.a(this.nmX);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nmV.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nmV.isUnsubscribed()) {
                return rx.subscriptions.e.dJd();
            }
            ScheduledAction b = this.nmX.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nmV.add(b);
            b.addParent(this.nmV);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long mVa;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mVa = 0L;
        }

        public long dDc() {
            return this.mVa;
        }

        public void gf(long j) {
            this.mVa = j;
        }
    }
}
