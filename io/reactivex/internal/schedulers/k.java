package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class k extends v {
    private static final k pRQ = new k();

    public static k eAY() {
        return pRQ;
    }

    @Override // io.reactivex.v
    public v.c eAB() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b H(Runnable runnable) {
        io.reactivex.e.a.K(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.K(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> pRT = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger pRU = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return e(new a(runnable, this, a2), a2);
        }

        io.reactivex.disposables.b e(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.pRU.incrementAndGet());
            this.pRT.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.pRT.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.pND.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.pRT.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.J(new a(bVar));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public final class a implements Runnable {
            final b pRV;

            a(b bVar) {
                this.pRV = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.pRV.disposed = true;
                c.this.pRT.remove(this.pRV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable pND;
        final long pRS;

        b(Runnable runnable, Long l, int i) {
            this.pND = runnable;
            this.pRS = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int N = io.reactivex.internal.functions.a.N(this.pRS, bVar.pRS);
            if (N == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return N;
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements Runnable {
        private final Runnable pND;
        private final c pRR;
        private final long pRS;

        a(Runnable runnable, c cVar, long j) {
            this.pND = runnable;
            this.pRR = cVar;
            this.pRS = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.pRR.disposed) {
                long a2 = this.pRR.a(TimeUnit.MILLISECONDS);
                if (this.pRS > a2) {
                    long j = this.pRS - a2;
                    if (j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            io.reactivex.e.a.onError(e);
                            return;
                        }
                    }
                }
                if (!this.pRR.disposed) {
                    this.pND.run();
                }
            }
        }
    }
}
