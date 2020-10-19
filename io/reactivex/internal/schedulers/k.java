package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public final class k extends v {
    private static final k oPw = new k();

    public static k enj() {
        return oPw;
    }

    @Override // io.reactivex.v
    public v.c emL() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b F(Runnable runnable) {
        io.reactivex.e.a.I(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.I(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes17.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> oPz = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger oPA = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b G(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.oPA.incrementAndGet());
            this.oPz.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.oPz.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.oLj.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.oPz.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.H(new a(bVar));
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
            final b oPB;

            a(b bVar) {
                this.oPB = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.oPB.disposed = true;
                c.this.oPz.remove(this.oPB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable oLj;
        final long oPy;

        b(Runnable runnable, Long l, int i) {
            this.oLj = runnable;
            this.oPy = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int L = io.reactivex.internal.functions.a.L(this.oPy, bVar.oPy);
            if (L == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return L;
        }
    }

    /* loaded from: classes17.dex */
    static final class a implements Runnable {
        private final Runnable oLj;
        private final c oPx;
        private final long oPy;

        a(Runnable runnable, c cVar, long j) {
            this.oLj = runnable;
            this.oPx = cVar;
            this.oPy = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.oPx.disposed) {
                long a2 = this.oPx.a(TimeUnit.MILLISECONDS);
                if (this.oPy > a2) {
                    long j = this.oPy - a2;
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
                if (!this.oPx.disposed) {
                    this.oLj.run();
                }
            }
        }
    }
}
