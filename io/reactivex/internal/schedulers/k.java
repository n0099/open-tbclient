package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class k extends v {
    private static final k qlR = new k();

    public static k eMc() {
        return qlR;
    }

    @Override // io.reactivex.v
    public v.c eLI() {
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

    /* loaded from: classes5.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> qlU = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger qlV = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.qlV.incrementAndGet());
            this.qlU.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.qlU.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.qhN.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.qlU.clear();
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
        /* loaded from: classes5.dex */
        public final class a implements Runnable {
            final b qlW;

            a(b bVar) {
                this.qlW = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.qlW.disposed = true;
                c.this.qlU.remove(this.qlW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable qhN;
        final long qlT;

        b(Runnable runnable, Long l, int i) {
            this.qhN = runnable;
            this.qlT = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int S = io.reactivex.internal.functions.a.S(this.qlT, bVar.qlT);
            if (S == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return S;
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements Runnable {
        private final Runnable qhN;
        private final c qlS;
        private final long qlT;

        a(Runnable runnable, c cVar, long j) {
            this.qhN = runnable;
            this.qlS = cVar;
            this.qlT = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.qlS.disposed) {
                long a2 = this.qlS.a(TimeUnit.MILLISECONDS);
                if (this.qlT > a2) {
                    long j = this.qlT - a2;
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
                if (!this.qlS.disposed) {
                    this.qhN.run();
                }
            }
        }
    }
}
