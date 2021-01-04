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
    private static final long quG;
    static final C1291a quI;
    final ThreadFactory qjl;
    final AtomicReference<C1291a> qjm = new AtomicReference<>(quI);
    private static final TimeUnit qjG = TimeUnit.SECONDS;
    static final c quH = new c(RxThreadFactory.NONE);

    static {
        quH.unsubscribe();
        quI = new C1291a(null, 0L, null);
        quI.shutdown();
        quG = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C1291a {
        private final long qjJ;
        private final ConcurrentLinkedQueue<c> qjK;
        private final ScheduledExecutorService qjM;
        private final Future<?> qjN;
        private final ThreadFactory qjl;
        private final rx.subscriptions.b quJ;

        C1291a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.qjl = threadFactory;
            this.qjJ = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.qjK = new ConcurrentLinkedQueue<>();
            this.quJ = new rx.subscriptions.b();
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
                        C1291a.this.eLw();
                    }
                }, this.qjJ, this.qjJ, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
                scheduledExecutorService = null;
            }
            this.qjM = scheduledExecutorService;
            this.qjN = scheduledFuture;
        }

        c eOc() {
            if (this.quJ.isUnsubscribed()) {
                return a.quH;
            }
            while (!this.qjK.isEmpty()) {
                c poll = this.qjK.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.qjl);
            this.quJ.add(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.jr(now() + this.qjJ);
            this.qjK.offer(cVar);
        }

        void eLw() {
            if (!this.qjK.isEmpty()) {
                long now = now();
                Iterator<c> it = this.qjK.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.eLx() <= now) {
                        if (this.qjK.remove(next)) {
                            this.quJ.a(next);
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
                if (this.qjN != null) {
                    this.qjN.cancel(true);
                }
                if (this.qjM != null) {
                    this.qjM.shutdownNow();
                }
            } finally {
                this.quJ.unsubscribe();
            }
        }
    }

    public a(ThreadFactory threadFactory) {
        this.qjl = threadFactory;
        start();
    }

    @Override // rx.internal.schedulers.h
    public void start() {
        C1291a c1291a = new C1291a(this.qjl, quG, qjG);
        if (!this.qjm.compareAndSet(quI, c1291a)) {
            c1291a.shutdown();
        }
    }

    @Override // rx.internal.schedulers.h
    public void shutdown() {
        C1291a c1291a;
        do {
            c1291a = this.qjm.get();
            if (c1291a == quI) {
                return;
            }
        } while (!this.qjm.compareAndSet(c1291a, quI));
        c1291a.shutdown();
    }

    @Override // rx.g
    public g.a createWorker() {
        return new b(this.qjm.get());
    }

    /* loaded from: classes15.dex */
    static final class b extends g.a implements rx.functions.a {
        private final C1291a quN;
        private final c quO;
        private final rx.subscriptions.b quM = new rx.subscriptions.b();
        final AtomicBoolean once = new AtomicBoolean();

        b(C1291a c1291a) {
            this.quN = c1291a;
            this.quO = c1291a.eOc();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.quO.c(this);
            }
            this.quM.unsubscribe();
        }

        @Override // rx.functions.a
        public void call() {
            this.quN.a(this.quO);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.quM.isUnsubscribed();
        }

        @Override // rx.g.a
        public k c(rx.functions.a aVar) {
            return a(aVar, 0L, null);
        }

        @Override // rx.g.a
        public k a(final rx.functions.a aVar, long j, TimeUnit timeUnit) {
            if (this.quM.isUnsubscribed()) {
                return rx.subscriptions.e.ePj();
            }
            ScheduledAction b2 = this.quO.b(new rx.functions.a() { // from class: rx.internal.schedulers.a.b.1
                @Override // rx.functions.a
                public void call() {
                    if (!b.this.isUnsubscribed()) {
                        aVar.call();
                    }
                }
            }, j, timeUnit);
            this.quM.add(b2);
            b2.addParent(this.quM);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static final class c extends g {
        private long qjQ;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.qjQ = 0L;
        }

        public long eLx() {
            return this.qjQ;
        }

        public void jr(long j) {
            this.qjQ = j;
        }
    }
}
