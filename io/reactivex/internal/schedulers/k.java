package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class k extends v {
    private static final k oqh = new k();

    public static k efr() {
        return oqh;
    }

    @Override // io.reactivex.v
    public v.c eeU() {
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

    /* loaded from: classes7.dex */
    static final class c extends v.c implements io.reactivex.disposables.b {
        volatile boolean disposed;
        final PriorityBlockingQueue<b> oqk = new PriorityBlockingQueue<>();
        private final AtomicInteger wip = new AtomicInteger();
        final AtomicInteger oql = new AtomicInteger();

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
            b bVar = new b(runnable, Long.valueOf(j), this.oql.incrementAndGet());
            this.oqk.add(bVar);
            if (this.wip.getAndIncrement() == 0) {
                int i = 1;
                while (!this.disposed) {
                    b poll = this.oqk.poll();
                    if (poll != null) {
                        if (!poll.disposed) {
                            poll.olR.run();
                        }
                    } else {
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                        i = addAndGet;
                    }
                }
                this.oqk.clear();
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
        /* loaded from: classes7.dex */
        public final class a implements Runnable {
            final b oqm;

            a(b bVar) {
                this.oqm = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.oqm.disposed = true;
                c.this.oqk.remove(this.oqm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        final int count;
        volatile boolean disposed;
        final Runnable olR;
        final long oqj;

        b(Runnable runnable, Long l, int i) {
            this.olR = runnable;
            this.oqj = l.longValue();
            this.count = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int O = io.reactivex.internal.functions.a.O(this.oqj, bVar.oqj);
            if (O == 0) {
                return io.reactivex.internal.functions.a.compare(this.count, bVar.count);
            }
            return O;
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements Runnable {
        private final Runnable olR;
        private final c oqi;
        private final long oqj;

        a(Runnable runnable, c cVar, long j) {
            this.olR = runnable;
            this.oqi = cVar;
            this.oqj = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.oqi.disposed) {
                long a = this.oqi.a(TimeUnit.MILLISECONDS);
                if (this.oqj > a) {
                    long j = this.oqj - a;
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
                if (!this.oqi.disposed) {
                    this.olR.run();
                }
            }
        }
    }
}
