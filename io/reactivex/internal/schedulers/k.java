package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class k extends v {
    private static final k qkj = new k();

    public static k eLy() {
        return qkj;
    }

    @Override // io.reactivex.v
    public v.c eLe() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b E(Runnable runnable) {
        io.reactivex.d.a.H(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.d.a.H(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.d.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes3.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> qkm = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger qkn = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b F(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.qkn.incrementAndGet());
            this.qkm.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.qkm.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.qgf.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.qkm.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.G(new a(bVar));
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
        /* loaded from: classes3.dex */
        public final class a implements Runnable {
            final b qko;

            a(b bVar) {
                this.qko = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.qko.disposed = true;
                c.this.qkm.remove(this.qko);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable qgf;
        final long qkl;

        b(Runnable runnable, Long l, int i) {
            this.qgf = runnable;
            this.qkl = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int R = io.reactivex.internal.functions.a.R(this.qkl, bVar.qkl);
            if (R == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return R;
        }
    }

    /* loaded from: classes3.dex */
    static final class a implements Runnable {
        private final Runnable qgf;
        private final c qkk;
        private final long qkl;

        a(Runnable runnable, c cVar, long j) {
            this.qgf = runnable;
            this.qkk = cVar;
            this.qkl = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.qkk.disposed) {
                long a2 = this.qkk.a(TimeUnit.MILLISECONDS);
                if (this.qkl > a2) {
                    long j = this.qkl - a2;
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
                if (!this.qkk.disposed) {
                    this.qgf.run();
                }
            }
        }
    }
}
