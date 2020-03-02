package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k nzU = new k();

    public static k dJD() {
        return nzU;
    }

    @Override // io.reactivex.v
    public v.c dJh() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b C(Runnable runnable) {
        io.reactivex.e.a.F(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.F(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> nzX = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger nzY = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b D(Runnable runnable) {
            return c(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return c(new a(runnable, this, a2), a2);
        }

        io.reactivex.disposables.b c(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.nzY.incrementAndGet());
            this.nzX.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.nzX.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.nvJ.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.nzX.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.E(new a(bVar));
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
            final b nzZ;

            a(b bVar) {
                this.nzZ = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.nzZ.disposed = true;
                c.this.nzX.remove(this.nzZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable nvJ;
        final long nzW;

        b(Runnable runnable, Long l, int i) {
            this.nvJ = runnable;
            this.nzW = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int ac = io.reactivex.internal.functions.a.ac(this.nzW, bVar.nzW);
            if (ac == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return ac;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable nvJ;
        private final c nzV;
        private final long nzW;

        a(Runnable runnable, c cVar, long j) {
            this.nvJ = runnable;
            this.nzV = cVar;
            this.nzW = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.nzV.disposed) {
                long a = this.nzV.a(TimeUnit.MILLISECONDS);
                if (this.nzW > a) {
                    try {
                        Thread.sleep(this.nzW - a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        io.reactivex.e.a.onError(e);
                        return;
                    }
                }
                if (!this.nzV.disposed) {
                    this.nvJ.run();
                }
            }
        }
    }
}
