package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public final class k extends v {
    private static final k qsw = new k();

    public static k eKs() {
        return qsw;
    }

    @Override // io.reactivex.v
    public v.c eJY() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b B(Runnable runnable) {
        io.reactivex.d.a.E(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.d.a.E(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.d.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes6.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> qsz = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger qsA = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
            return f(runnable, b(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b c(Runnable runnable, long j, TimeUnit timeUnit) {
            long b = b(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return f(new a(runnable, this, b), b);
        }

        io.reactivex.disposables.b f(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.qsA.incrementAndGet());
            this.qsz.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.qsz.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.qot.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.qsz.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.D(new a(bVar));
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
        /* loaded from: classes6.dex */
        public final class a implements Runnable {
            final b qsB;

            a(b bVar) {
                this.qsB = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.qsB.disposed = true;
                c.this.qsz.remove(this.qsB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable qot;
        final long qsy;

        b(Runnable runnable, Long l, int i) {
            this.qot = runnable;
            this.qsy = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int W = io.reactivex.internal.functions.a.W(this.qsy, bVar.qsy);
            if (W == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return W;
        }
    }

    /* loaded from: classes6.dex */
    static final class a implements Runnable {
        private final Runnable qot;
        private final c qsx;
        private final long qsy;

        a(Runnable runnable, c cVar, long j) {
            this.qot = runnable;
            this.qsx = cVar;
            this.qsy = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.qsx.disposed) {
                long b = this.qsx.b(TimeUnit.MILLISECONDS);
                if (this.qsy > b) {
                    long j = this.qsy - b;
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
                if (!this.qsx.disposed) {
                    this.qot.run();
                }
            }
        }
    }
}
