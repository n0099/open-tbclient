package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> pnm = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int poo;
    private final BlockingQueue<Runnable> poq;
    private final a por;
    private final AtomicInteger pot;
    private final AtomicInteger pou;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.poo = i;
        this.poq = blockingQueue;
        this.por = new a();
        this.pot = new AtomicInteger(0);
        this.pou = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.poq.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.poq.size());
        }
        int size = this.poq.size();
        int i = this.pou.get();
        if (size > i && this.pou.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(pnm, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        epZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void epZ() {
        int i = this.pot.get();
        while (i < this.poo) {
            int i2 = i + 1;
            if (this.pot.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(pnm, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.poo));
                this.mExecutor.execute(this.por);
                return;
            }
            com.facebook.common.c.a.c(pnm, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.pot.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.poq.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.c(b.pnm, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.pot.decrementAndGet();
                if (!b.this.poq.isEmpty()) {
                    b.this.epZ();
                } else {
                    com.facebook.common.c.a.a(b.pnm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.pot.decrementAndGet();
                if (!b.this.poq.isEmpty()) {
                    b.this.epZ();
                } else {
                    com.facebook.common.c.a.a(b.pnm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
