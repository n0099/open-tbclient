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
    private static final Class<?> lHl = b.class;
    private volatile int lIn;
    private final BlockingQueue<Runnable> lIo;
    private final a lIp;
    private final AtomicInteger lIq;
    private final AtomicInteger lIr;
    private final Executor mExecutor;
    private final String mName;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.lIn = i;
        this.lIo = blockingQueue;
        this.lIp = new a();
        this.lIq = new AtomicInteger(0);
        this.lIr = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.lIo.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.lIo.size());
        }
        int size = this.lIo.size();
        int i = this.lIr.get();
        if (size > i && this.lIr.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(lHl, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dkC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkC() {
        int i = this.lIq.get();
        while (i < this.lIn) {
            int i2 = i + 1;
            if (this.lIq.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(lHl, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.lIn));
                this.mExecutor.execute(this.lIp);
                return;
            }
            com.facebook.common.c.a.a(lHl, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.lIq.get();
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
                Runnable runnable = (Runnable) b.this.lIo.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.lHl, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.lIq.decrementAndGet();
                if (!b.this.lIo.isEmpty()) {
                    b.this.dkC();
                } else {
                    com.facebook.common.c.a.a(b.lHl, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.lIq.decrementAndGet();
                if (!b.this.lIo.isEmpty()) {
                    b.this.dkC();
                } else {
                    com.facebook.common.c.a.a(b.lHl, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
