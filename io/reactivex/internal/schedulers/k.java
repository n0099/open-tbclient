package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class k extends v {
    private static final k qhp = new k();

    public static k eIm() {
        return qhp;
    }

    @Override // io.reactivex.v
    public v.c eHS() {
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
        final PriorityBlockingQueue<b> qhs = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger qht = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.qht.incrementAndGet());
            this.qhs.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.qhs.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.qdm.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.qhs.clear();
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
            final b qhu;

            a(b bVar) {
                this.qhu = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.qhu.disposed = true;
                c.this.qhs.remove(this.qhu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable qdm;
        final long qhr;

        b(Runnable runnable, Long l, int i) {
            this.qdm = runnable;
            this.qhr = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int S = io.reactivex.internal.functions.a.S(this.qhr, bVar.qhr);
            if (S == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return S;
        }
    }

    /* loaded from: classes5.dex */
    static final class a implements Runnable {
        private final Runnable qdm;
        private final c qhq;
        private final long qhr;

        a(Runnable runnable, c cVar, long j) {
            this.qdm = runnable;
            this.qhq = cVar;
            this.qhr = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.qhq.disposed) {
                long a2 = this.qhq.a(TimeUnit.MILLISECONDS);
                if (this.qhr > a2) {
                    long j = this.qhr - a2;
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
                if (!this.qhq.disposed) {
                    this.qdm.run();
                }
            }
        }
    }
}
