package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class k extends v {
    private static final k nzq = new k();

    public static k dIu() {
        return nzq;
    }

    @Override // io.reactivex.v
    public v.c dHY() {
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

    /* loaded from: classes5.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> nzt = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger nzu = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.nzu.incrementAndGet());
            this.nzt.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.nzt.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.nvf.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.nzt.clear();
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
        /* loaded from: classes5.dex */
        public final class a implements Runnable {
            final b nzv;

            a(b bVar) {
                this.nzv = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.nzv.disposed = true;
                c.this.nzt.remove(this.nzv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable nvf;
        final long nzs;

        b(Runnable runnable, Long l, int i) {
            this.nvf = runnable;
            this.nzs = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int ad = io.reactivex.internal.functions.a.ad(this.nzs, bVar.nzs);
            if (ad == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return ad;
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements Runnable {
        private final Runnable nvf;
        private final c nzr;
        private final long nzs;

        a(Runnable runnable, c cVar, long j) {
            this.nvf = runnable;
            this.nzr = cVar;
            this.nzs = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.nzr.disposed) {
                long a = this.nzr.a(TimeUnit.MILLISECONDS);
                if (this.nzs > a) {
                    try {
                        Thread.sleep(this.nzs - a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        io.reactivex.e.a.onError(e);
                        return;
                    }
                }
                if (!this.nzr.disposed) {
                    this.nvf.run();
                }
            }
        }
    }
}
