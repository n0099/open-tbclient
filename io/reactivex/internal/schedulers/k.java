package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public final class k extends v {
    private static final k pQn = new k();

    public static k eAX() {
        return pQn;
    }

    @Override // io.reactivex.v
    public v.c eAA() {
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

    /* loaded from: classes17.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> pQq = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger pQr = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.pQr.incrementAndGet());
            this.pQq.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.pQq.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.pMa.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.pQq.clear();
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
        /* loaded from: classes17.dex */
        public final class a implements Runnable {
            final b pQs;

            a(b bVar) {
                this.pQs = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.pQs.disposed = true;
                c.this.pQq.remove(this.pQs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable pMa;
        final long pQp;

        b(Runnable runnable, Long l, int i) {
            this.pMa = runnable;
            this.pQp = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int N = io.reactivex.internal.functions.a.N(this.pQp, bVar.pQp);
            if (N == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return N;
        }
    }

    /* loaded from: classes17.dex */
    static final class a implements Runnable {
        private final Runnable pMa;
        private final c pQo;
        private final long pQp;

        a(Runnable runnable, c cVar, long j) {
            this.pMa = runnable;
            this.pQo = cVar;
            this.pQp = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.pQo.disposed) {
                long a2 = this.pQo.a(TimeUnit.MILLISECONDS);
                if (this.pQp > a2) {
                    long j = this.pQp - a2;
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
                if (!this.pQo.disposed) {
                    this.pMa.run();
                }
            }
        }
    }
}
