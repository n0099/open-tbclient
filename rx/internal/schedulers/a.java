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
    private static final long nQt;
    static final C0790a nQv;
    final ThreadFactory aNw;
    final AtomicReference<C0790a> nys = new AtomicReference<>(nQv);
    private static final TimeUnit nyM = TimeUnit.SECONDS;
    static final c nQu = new c(RxThreadFactory.NONE);

    static {
        nQu.unsubscribe();
        nQv = new C0790a(null, 0L, null);
        nQv.shutdown();
        nQt = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0790a {
        private final ThreadFactory aNw;
        private final rx.subscriptions.b nQw;
        private final long nyP;
        private final ConcurrentLinkedQueue<c> nyQ;
        private final ScheduledExecutorService nyS;
        private final Future<?> nyT;

        C0790a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService = null;
            this.aNw = threadFactory;
            this.nyP = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.nyQ = new ConcurrentLinkedQueue<>();
            this.nQw = new rx.subscriptions.b();
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
                        C0790a.this.dIs();
                    }
                }, this.nyP, this.nyP, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.nyS = scheduledExecutorService;
            this.nyT = scheduledFuture;
        }

        c dNi() {
            if (this.nQw.isUnsubscribed()) {
                return a.nQu;
            }
            while (!this.nyQ.isEmpty()) {
                c poll = this.nyQ.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.aNw);
            this.nQw.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.hf(now() + this.nyP);
            this.nyQ.offer(cVar);
        }

        void dIs() {
            if (!this.nyQ.isEmpty()) {
                long now = now();
                Iterator<c> it = this.nyQ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.dIt() <= now) {
                        if (this.nyQ.remove(next)) {
                            this.nQw.a(next);
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
                if (this.nyT != null) {
                    this.nyT.cancel(true);
                }
                if (this.nyS != null) {
                    this.nyS.shutdownNow();
                }
            } finally {
                this.nQw.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.aNw = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C0790a c0790a = new C0790a(this.aNw, nQt, nyM);
        if (!this.nys.compareAndSet(nQv, c0790a)) {
            c0790a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C0790a c0790a;
        do {
            c0790a = this.nys.get();
            if (c0790a == nQv) {
                return;
            }
        } while (!this.nys.compareAndSet(c0790a, nQv));
        c0790a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.nys.get());
    }

    /* loaded from: classes5.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C0790a nQA;
        private final c nQB;
        private final rx.subscriptions.b nQz = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C0790a c0790a) {
            this.nQA = c0790a;
            this.nQB = c0790a.dNi();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.nQB.c(this);
            }
            this.nQz.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.nQA.a(this.nQB);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.nQz.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.nQz.isUnsubscribed()) {
                return rx.subscriptions.e.dOn();
            }
            ScheduledAction b = this.nQB.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.nQz.add(b);
            b.addParent(this.nQz);
            return b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends g {
        private long nyW;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.nyW = 0L;
        }

        public long dIt() {
            return this.nyW;
        }

        public void hf(long j) {
            this.nyW = j;
        }
    }
}
