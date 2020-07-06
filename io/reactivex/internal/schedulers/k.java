package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k nNz = new k();

    public static k dPS() {
        return nNz;
    }

    @Override // io.reactivex.v
    public v.c dPv() {
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
        final PriorityBlockingQueue<b> nNC = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger nND = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.nND.incrementAndGet());
            this.nNC.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.nNC.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.nJm.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.nNC.clear();
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
            final b nNE;

            a(b bVar) {
                this.nNE = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.nNE.disposed = true;
                c.this.nNC.remove(this.nNE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable nJm;
        final long nNB;

        b(Runnable runnable, Long l, int i) {
            this.nJm = runnable;
            this.nNB = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int M = io.reactivex.internal.functions.a.M(this.nNB, bVar.nNB);
            if (M == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return M;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable nJm;
        private final c nNA;
        private final long nNB;

        a(Runnable runnable, c cVar, long j) {
            this.nJm = runnable;
            this.nNA = cVar;
            this.nNB = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.nNA.disposed) {
                long a = this.nNA.a(TimeUnit.MILLISECONDS);
                if (this.nNB > a) {
                    long j = this.nNB - a;
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
                if (!this.nNA.disposed) {
                    this.nJm.run();
                }
            }
        }
    }
}
