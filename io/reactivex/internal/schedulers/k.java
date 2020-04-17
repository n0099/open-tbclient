package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k mVt = new k();

    public static k dDd() {
        return mVt;
    }

    @Override // io.reactivex.v
    public v.c dCG() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b H(Runnable runnable) {
        io.reactivex.e.a.K(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.e.a.K(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.e.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> mVw = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger mVx = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b I(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.mVx.incrementAndGet());
            this.mVw.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.mVw.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.mQY.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.mVw.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.J(new a(bVar));
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
            final b mVy;

            a(b bVar) {
                this.mVy = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mVy.disposed = true;
                c.this.mVw.remove(this.mVy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable mQY;
        final long mVv;

        b(Runnable runnable, Long l, int i) {
            this.mQY = runnable;
            this.mVv = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int K = io.reactivex.internal.functions.a.K(this.mVv, bVar.mVv);
            if (K == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return K;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable mQY;
        private final c mVu;
        private final long mVv;

        a(Runnable runnable, c cVar, long j) {
            this.mQY = runnable;
            this.mVu = cVar;
            this.mVv = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mVu.disposed) {
                long a = this.mVu.a(TimeUnit.MILLISECONDS);
                if (this.mVv > a) {
                    long j = this.mVv - a;
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
                if (!this.mVu.disposed) {
                    this.mQY.run();
                }
            }
        }
    }
}
