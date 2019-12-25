package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class k extends v {
    private static final k mXd = new k();

    public static k dEi() {
        return mXd;
    }

    @Override // io.reactivex.v
    public v.c dDP() {
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

    /* loaded from: classes4.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> mXg = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger mXh = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b C(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.mXh.incrementAndGet());
            this.mXg.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.mXg.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.mSX.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.mXg.clear();
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
        /* loaded from: classes4.dex */
        public final class a implements Runnable {
            final b mXi;

            a(b bVar) {
                this.mXi = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mXi.disposed = true;
                c.this.mXg.remove(this.mXi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable mSX;
        final long mXf;

        b(Runnable runnable, Long l, int i) {
            this.mSX = runnable;
            this.mXf = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int ac = io.reactivex.internal.functions.a.ac(this.mXf, bVar.mXf);
            if (ac == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return ac;
        }
    }

    /* loaded from: classes4.dex */
    static final class a implements Runnable {
        private final Runnable mSX;
        private final c mXe;
        private final long mXf;

        a(Runnable runnable, c cVar, long j) {
            this.mSX = runnable;
            this.mXe = cVar;
            this.mXf = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mXe.disposed) {
                long a = this.mXe.a(TimeUnit.MILLISECONDS);
                if (this.mXf > a) {
                    try {
                        Thread.sleep(this.mXf - a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        io.reactivex.d.a.onError(e);
                        return;
                    }
                }
                if (!this.mXe.disposed) {
                    this.mSX.run();
                }
            }
        }
    }
}
