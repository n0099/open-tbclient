package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> nju = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int nkv;
    private final BlockingQueue<Runnable> nkw;
    private final a nkx;
    private final AtomicInteger nky;
    private final AtomicInteger nkz;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.nkv = i;
        this.nkw = blockingQueue;
        this.nkx = new a();
        this.nky = new AtomicInteger(0);
        this.nkz = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.nkw.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.nkw.size());
        }
        int size = this.nkw.size();
        int i = this.nkz.get();
        if (size > i && this.nkz.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(nju, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dOr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOr() {
        int i = this.nky.get();
        while (i < this.nkv) {
            int i2 = i + 1;
            if (this.nky.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(nju, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.nkv));
                this.mExecutor.execute(this.nkx);
                return;
            }
            com.facebook.common.c.a.a(nju, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.nky.get();
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
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.nkw.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.nju, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.nky.decrementAndGet();
                if (!b.this.nkw.isEmpty()) {
                    b.this.dOr();
                } else {
                    com.facebook.common.c.a.a(b.nju, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.nky.decrementAndGet();
                if (!b.this.nkw.isEmpty()) {
                    b.this.dOr();
                } else {
                    com.facebook.common.c.a.a(b.nju, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
