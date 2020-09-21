package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public final class k extends v {
    private static final k oAh = new k();

    public static k ejx() {
        return oAh;
    }

    @Override // io.reactivex.v
    public v.c eja() {
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

    /* loaded from: classes25.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> oAk = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger oAl = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.oAl.incrementAndGet());
            this.oAk.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.oAk.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.ovU.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.oAk.clear();
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
        /* loaded from: classes25.dex */
        public final class a implements Runnable {
            final b oAm;

            a(b bVar) {
                this.oAm = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.oAm.disposed = true;
                c.this.oAk.remove(this.oAm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final long oAj;
        final Runnable ovU;

        b(Runnable runnable, Long l, int i) {
            this.ovU = runnable;
            this.oAj = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int L = io.reactivex.internal.functions.a.L(this.oAj, bVar.oAj);
            if (L == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return L;
        }
    }

    /* loaded from: classes25.dex */
    static final class a implements Runnable {
        private final c oAi;
        private final long oAj;
        private final Runnable ovU;

        a(Runnable runnable, c cVar, long j) {
            this.ovU = runnable;
            this.oAi = cVar;
            this.oAj = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.oAi.disposed) {
                long a = this.oAi.a(TimeUnit.MILLISECONDS);
                if (this.oAj > a) {
                    long j = this.oAj - a;
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
                if (!this.oAi.disposed) {
                    this.ovU.run();
                }
            }
        }
    }
}
