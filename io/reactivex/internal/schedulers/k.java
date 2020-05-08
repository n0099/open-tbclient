package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k mVw = new k();

    public static k dCZ() {
        return mVw;
    }

    @Override // io.reactivex.v
    public v.c dCC() {
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
        final PriorityBlockingQueue<b> mVz = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger mVA = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.mVA.incrementAndGet());
            this.mVz.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.mVz.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.mRb.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.mVz.clear();
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
            final b mVB;

            a(b bVar) {
                this.mVB = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mVB.disposed = true;
                c.this.mVz.remove(this.mVB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable mRb;
        final long mVy;

        b(Runnable runnable, Long l, int i) {
            this.mRb = runnable;
            this.mVy = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int K = io.reactivex.internal.functions.a.K(this.mVy, bVar.mVy);
            if (K == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return K;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable mRb;
        private final c mVx;
        private final long mVy;

        a(Runnable runnable, c cVar, long j) {
            this.mRb = runnable;
            this.mVx = cVar;
            this.mVy = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mVx.disposed) {
                long a = this.mVx.a(TimeUnit.MILLISECONDS);
                if (this.mVy > a) {
                    long j = this.mVy - a;
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
                if (!this.mVx.disposed) {
                    this.mRb.run();
                }
            }
        }
    }
}
