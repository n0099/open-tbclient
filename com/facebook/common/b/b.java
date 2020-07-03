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
    private static final Class<?> mHo = b.class;
    private final Executor mExecutor;
    private volatile int mIr;
    private final BlockingQueue<Runnable> mIt;
    private final a mIu;
    private final AtomicInteger mIv;
    private final AtomicInteger mIw;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mIr = i;
        this.mIt = blockingQueue;
        this.mIu = new a();
        this.mIv = new AtomicInteger(0);
        this.mIw = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mIt.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mIt.size());
        }
        int size = this.mIt.size();
        int i = this.mIw.get();
        if (size > i && this.mIw.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(mHo, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dza() {
        int i = this.mIv.get();
        while (i < this.mIr) {
            int i2 = i + 1;
            if (this.mIv.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(mHo, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mIr));
                this.mExecutor.execute(this.mIu);
                return;
            }
            com.facebook.common.c.a.a(mHo, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mIv.get();
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
                Runnable runnable = (Runnable) b.this.mIt.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.mHo, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.mIv.decrementAndGet();
                if (!b.this.mIt.isEmpty()) {
                    b.this.dza();
                } else {
                    com.facebook.common.c.a.a(b.mHo, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.mIv.decrementAndGet();
                if (!b.this.mIt.isEmpty()) {
                    b.this.dza();
                } else {
                    com.facebook.common.c.a.a(b.mHo, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
