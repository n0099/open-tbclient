package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k nWk = new k();

    public static k dTp() {
        return nWk;
    }

    @Override // io.reactivex.v
    public v.c dSS() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b I(Runnable runnable) {
        io.reactivex.e.a.L(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.L(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> nWn = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger nWo = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b J(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.nWo.incrementAndGet());
            this.nWn.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.nWn.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.nRW.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.nWn.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.K(new a(bVar));
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
            final b nWp;

            a(b bVar) {
                this.nWp = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.nWp.disposed = true;
                c.this.nWn.remove(this.nWp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable nRW;
        final long nWm;

        b(Runnable runnable, Long l, int i) {
            this.nRW = runnable;
            this.nWm = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int O = io.reactivex.internal.functions.a.O(this.nWm, bVar.nWm);
            if (O == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return O;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable nRW;
        private final c nWl;
        private final long nWm;

        a(Runnable runnable, c cVar, long j) {
            this.nRW = runnable;
            this.nWl = cVar;
            this.nWm = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.nWl.disposed) {
                long a = this.nWl.a(TimeUnit.MILLISECONDS);
                if (this.nWm > a) {
                    long j = this.nWm - a;
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
                if (!this.nWl.disposed) {
                    this.nRW.run();
                }
            }
        }
    }
}
