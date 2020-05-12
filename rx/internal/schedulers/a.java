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
    private static final long nmS;
    static final C0843a nmU;
    final ThreadFactory bos;
    final AtomicReference<C0843a> mUz = new AtomicReference<>(nmU);
    private static final TimeUnit mUT = TimeUnit.SECONDS;
    static final c nmT = new c(RxThreadFactory.NONE);

    static {
        nmT.unsubscribe();
        nmU = new C0843a(null, 0L, null);
        nmU.shutdown();
        nmS = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0843a {
        private final ThreadFactory bos;
        private final long mUW;
        private final ConcurrentLinkedQueue<c> mUX;
        private final ScheduledExecutorService mUZ;
        private final Future<?> mVa;
        private final rx.subscriptions.b nmV;

        C0843a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bos = threadFactory;
            this.mUW = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.mUX = new ConcurrentLinkedQueue<>();
            this.nmV = new rx.subscriptions.b();
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
                        C0843a.this.dCY();
                    }
                }, this.mUW, this.mUW, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.mUZ = scheduledExecutorService;
            this.mVa = scheduledFuture;
        }

        c dHV() {
            if (this.nmV.isUnsubscribed()) {
                return a.nmT;
            }
            while (!this.mUX.isEmpty()) {
                c poll = this.mUX.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bos);
            this.nmV.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gf(now() + this.mUW);
            this.mUX.offer(cVar);
        }

        void dCY() {
            if (!this.mUX.isEmpty()) {
                long now = now();
                Iterator<c> it = this.mUX.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dCZ() <= now) {
                        if (this.mUX.remove(next)) {
                            this.nmV.a(next);
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
                if (this.mVa != null) {
                    this.mVa.cancel(true);
                }
                if (this.mUZ != null) {
                    this.mUZ.shutdownNow();
                }
            } finally {
                this.nmV.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bos = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0843a c0843a = new C0843a(this.bos, nmS, mUT);
        if (!this.mUz.compareAndSet(nmU, c0843a)) {
            c0843a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0843a c0843a;
        do {
            c0843a = this.mUz.get();
            if (c0843a == nmU) {
                return;
            }
        } while (!this.mUz.compareAndSet(c0843a, nmU));
        c0843a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.mUz.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0843a nmZ;
        private final c nna;
        private final rx.subscriptions.b nmY = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0843a c0843a) {
            this.nmZ = c0843a;
            this.nna = c0843a.dHV();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nna.c(this);
            }
            this.nmY.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nmZ.a(this.nna);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nmY.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nmY.isUnsubscribed()) {
                return rx.subscriptions.e.dJa();
            }
            ScheduledAction b = this.nna.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nmY.add(b);
            b.addParent(this.nmY);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long mVd;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.mVd = 0L;
        }

        public long dCZ() {
            return this.mVd;
        }

        public void gf(long j) {
            this.mVd = j;
        }
    }
}
