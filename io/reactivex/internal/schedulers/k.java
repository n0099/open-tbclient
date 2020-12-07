package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class k extends v {
    private static final k pIE = new k();

    public static k eDp() {
        return pIE;
    }

    @Override // io.reactivex.v
    public v.c eCV() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b G(Runnable runnable) {
        io.reactivex.d.a.J(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.d.a.J(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.d.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes9.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> pIH = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger pII = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b H(Runnable runnable) {
            return f(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return f(new a(runnable, this, a2), a2);
        }

        io.reactivex.disposables.b f(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.pII.incrementAndGet());
            this.pIH.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.pIH.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.pEB.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.pIH.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.I(new a(bVar));
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
        /* loaded from: classes9.dex */
        public final class a implements Runnable {
            final b pIJ;

            a(b bVar) {
                this.pIJ = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.pIJ.disposed = true;
                c.this.pIH.remove(this.pIJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable pEB;
        final long pIG;

        b(Runnable runnable, Long l, int i) {
            this.pEB = runnable;
            this.pIG = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int M = io.reactivex.internal.functions.a.M(this.pIG, bVar.pIG);
            if (M == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return M;
        }
    }

    /* loaded from: classes9.dex */
    static final class a implements Runnable {
        private final Runnable pEB;
        private final c pIF;
        private final long pIG;

        a(Runnable runnable, c cVar, long j) {
            this.pEB = runnable;
            this.pIF = cVar;
            this.pIG = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.pIF.disposed) {
                long a2 = this.pIF.a(TimeUnit.MILLISECONDS);
                if (this.pIG > a2) {
                    long j = this.pIG - a2;
                    if (j > 0) {
                        try {
                            Thread.sleep(j);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            io.reactivex.d.a.onError(e);
                            return;
                        }
                    }
                }
                if (!this.pIF.disposed) {
                    this.pEB.run();
                }
            }
        }
    }
}
