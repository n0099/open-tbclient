package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class k extends v {
    private static final k pIG = new k();

    public static k eDq() {
        return pIG;
    }

    @Override // io.reactivex.v
    public v.c eCW() {
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
        final PriorityBlockingQueue<b> pIJ = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger pIK = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.pIK.incrementAndGet());
            this.pIJ.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.pIJ.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.pED.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.pIJ.clear();
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
            final b pIL;

            a(b bVar) {
                this.pIL = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.pIL.disposed = true;
                c.this.pIJ.remove(this.pIL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable pED;
        final long pII;

        b(Runnable runnable, Long l, int i) {
            this.pED = runnable;
            this.pII = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int M = io.reactivex.internal.functions.a.M(this.pII, bVar.pII);
            if (M == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return M;
        }
    }

    /* loaded from: classes9.dex */
    static final class a implements Runnable {
        private final Runnable pED;
        private final c pIH;
        private final long pII;

        a(Runnable runnable, c cVar, long j) {
            this.pED = runnable;
            this.pIH = cVar;
            this.pII = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.pIH.disposed) {
                long a2 = this.pIH.a(TimeUnit.MILLISECONDS);
                if (this.pII > a2) {
                    long j = this.pII - a2;
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
                if (!this.pIH.disposed) {
                    this.pED.run();
                }
            }
        }
    }
}
