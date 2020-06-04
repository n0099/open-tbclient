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
    private static final long nJc;
    static final C0906a nJe;
    final ThreadFactory bvS;
    final AtomicReference<C0906a> nqM = new AtomicReference<>(nJe);
    private static final TimeUnit nrg = TimeUnit.SECONDS;
    static final c nJd = new c(RxThreadFactory.NONE);

    static {
        nJd.unsubscribe();
        nJe = new C0906a(null, 0L, null);
        nJe.shutdown();
        nJc = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0906a {
        private final ThreadFactory bvS;
        private final rx.subscriptions.b nJf;
        private final long nrj;
        private final ConcurrentLinkedQueue<c> nrk;
        private final ScheduledExecutorService nrm;
        private final Future<?> nrn;

        C0906a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.bvS = threadFactory;
            this.nrj = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nrk = new ConcurrentLinkedQueue<>();
            this.nJf = new rx.subscriptions.b();
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
                        C0906a.this.dLg();
                    }
                }, this.nrj, this.nrj, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nrm = scheduledExecutorService;
            this.nrn = scheduledFuture;
        }

        c dQd() {
            if (this.nJf.isUnsubscribed()) {
                return a.nJd;
            }
            while (!this.nrk.isEmpty()) {
                c poll = this.nrk.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.bvS);
            this.nJf.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.gg(now() + this.nrj);
            this.nrk.offer(cVar);
        }

        void dLg() {
            if (!this.nrk.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nrk.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dLh() <= now) {
                        if (this.nrk.remove(next)) {
                            this.nJf.a(next);
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
                if (this.nrn != null) {
                    this.nrn.cancel(true);
                }
                if (this.nrm != null) {
                    this.nrm.shutdownNow();
                }
            } finally {
                this.nJf.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.bvS = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0906a c0906a = new C0906a(this.bvS, nJc, nrg);
        if (!this.nqM.compareAndSet(nJe, c0906a)) {
            c0906a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0906a c0906a;
        do {
            c0906a = this.nqM.get();
            if (c0906a == nJe) {
                return;
            }
        } while (!this.nqM.compareAndSet(c0906a, nJe));
        c0906a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nqM.get());
    }

    /* loaded from: classes6.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0906a nJj;
        private final c nJk;
        private final rx.subscriptions.b nJi = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0906a c0906a) {
            this.nJj = c0906a;
            this.nJk = c0906a.dQd();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nJk.c(this);
            }
            this.nJi.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nJj.a(this.nJk);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nJi.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nJi.isUnsubscribed()) {
                return rx.subscriptions.e.dRi();
            }
            ScheduledAction b = this.nJk.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nJi.add(b);
            b.addParent(this.nJi);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class c extends g {
        private long nrq;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nrq = 0L;
        }

        public long dLh() {
            return this.nrq;
        }

        public void gg(long j) {
            this.nrq = j;
        }
    }
}
