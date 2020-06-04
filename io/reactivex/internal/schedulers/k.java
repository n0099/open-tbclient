package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k nrJ = new k();

    public static k dLi() {
        return nrJ;
    }

    @Override // io.reactivex.v
    public v.c dKL() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b J(Runnable runnable) {
        io.reactivex.e.a.M(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.M(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> nrM = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger nrN = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b K(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return d(new a(runnable, this, a2), a2);
        }

        io.reactivex.disposables.b d(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.nrN.incrementAndGet());
            this.nrM.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.nrM.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.nnu.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.nrM.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.L(new a(bVar));
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
        /* loaded from: classes7.dex */
        public final class a implements Runnable {
            final b nrO;

            a(b bVar) {
                this.nrO = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.nrO.disposed = true;
                c.this.nrM.remove(this.nrO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable nnu;
        final long nrL;

        b(Runnable runnable, Long l, int i) {
            this.nnu = runnable;
            this.nrL = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int L = io.reactivex.internal.functions.a.L(this.nrL, bVar.nrL);
            if (L == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return L;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable nnu;
        private final c nrK;
        private final long nrL;

        a(Runnable runnable, c cVar, long j) {
            this.nnu = runnable;
            this.nrK = cVar;
            this.nrL = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.nrK.disposed) {
                long a = this.nrK.a(TimeUnit.MILLISECONDS);
                if (this.nrL > a) {
                    long j = this.nrL - a;
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
                if (!this.nrK.disposed) {
                    this.nnu.run();
                }
            }
        }
    }
}
