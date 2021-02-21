package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class k extends v {
    private static final k qrU = new k();

    public static k eKK() {
        return qrU;
    }

    @Override // io.reactivex.v
    public v.c eKq() {
        return new c();
    }

    k() {
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b D(Runnable runnable) {
        io.reactivex.d.a.G(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.v
    public io.reactivex.disposables.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.d.a.G(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.d.a.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }

    /* loaded from: classes5.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> qrX = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger qrY = new AtomicInteger();

        c() {
        }

        @Override // io.reactivex.v.c
        public io.reactivex.disposables.b E(Runnable runnable) {
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
            b bVar = new b(runnable, Long.valueOf(j), this.qrY.incrementAndGet());
            this.qrX.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.qrX.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.qnR.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.qrX.clear();
                return EmptyDisposable.INSTANCE;
            }
            return io.reactivex.disposables.c.F(new a(bVar));
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
            final b qrZ;

            a(b bVar) {
                this.qrZ = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.qrZ.disposed = true;
                c.this.qrX.remove(this.qrZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable qnR;
        final long qrW;

        b(Runnable runnable, Long l, int i) {
            this.qnR = runnable;
            this.qrW = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int W = io.reactivex.internal.functions.a.W(this.qrW, bVar.qrW);
            if (W == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return W;
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements Runnable {
        private final Runnable qnR;
        private final c qrV;
        private final long qrW;

        a(Runnable runnable, c cVar, long j) {
            this.qnR = runnable;
            this.qrV = cVar;
            this.qrW = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.qrV.disposed) {
                long a2 = this.qrV.a(TimeUnit.MILLISECONDS);
                if (this.qrW > a2) {
                    long j = this.qrW - a2;
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
                if (!this.qrV.disposed) {
                    this.qnR.run();
                }
            }
        }
    }
}
