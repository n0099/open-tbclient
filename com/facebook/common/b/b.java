package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes12.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> lGm = b.class;
    private volatile int lHo;
    private final BlockingQueue<Runnable> lHp;
    private final a lHq;
    private final AtomicInteger lHr;
    private final AtomicInteger lHs;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lHo = i;
        this.lHp = blockingQueue;
        this.lHq = new a();
        this.lHr = new AtomicInteger(0);
        this.lHs = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lHp.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lHp.size());
        }
        int size = this.lHp.size();
        int i = this.lHs.get();
        if (size > i && this.lHs.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lGm, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        djk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        int i = this.lHr.get();
        while (i < this.lHo) {
            int i2 = i + 1;
            if (this.lHr.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lGm, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lHo));
                this.mExecutor.execute(this.lHq);
                return;
            }
            com.facebook.common.c.a.a(lGm, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lHr.get();
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
    /* loaded from: classes12.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.lHp.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lGm, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lHr.decrementAndGet();
                if (!b.this.lHp.isEmpty()) {
                    b.this.djk();
                } else {
                    com.facebook.common.c.a.a(b.lGm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lHr.decrementAndGet();
                if (!b.this.lHp.isEmpty()) {
                    b.this.djk();
                } else {
                    com.facebook.common.c.a.a(b.lGm, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
