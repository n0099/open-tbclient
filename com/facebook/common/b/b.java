package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes13.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> mHr = b.class;
    private final Executor mExecutor;
    private volatile int mIv;
    private final BlockingQueue<Runnable> mIw;
    private final a mIx;
    private final AtomicInteger mIy;
    private final AtomicInteger mIz;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mIv = i;
        this.mIw = blockingQueue;
        this.mIx = new a();
        this.mIy = new AtomicInteger(0);
        this.mIz = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mIw.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mIw.size());
        }
        int size = this.mIw.size();
        int i = this.mIz.get();
        if (size > i && this.mIz.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mHr, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dze() {
        int i = this.mIy.get();
        while (i < this.mIv) {
            int i2 = i + 1;
            if (this.mIy.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mHr, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mIv));
                this.mExecutor.execute(this.mIx);
                return;
            }
            com.facebook.common.c.a.a(mHr, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mIy.get();
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
    /* loaded from: classes13.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.mIw.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mHr, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mIy.decrementAndGet();
                if (!b.this.mIw.isEmpty()) {
                    b.this.dze();
                } else {
                    com.facebook.common.c.a.a(b.mHr, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mIy.decrementAndGet();
                if (!b.this.mIw.isEmpty()) {
                    b.this.dze();
                } else {
                    com.facebook.common.c.a.a(b.mHr, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
