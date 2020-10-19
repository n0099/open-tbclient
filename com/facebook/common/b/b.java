package com.facebook.common.b;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class b extends AbstractExecutorService {
    private static final Class<?> nJf = b.class;
    private final Executor mExecutor;
    private final String mName;
    private volatile int nKg;
    private final BlockingQueue<Runnable> nKh;
    private final a nKi;
    private final AtomicInteger nKj;
    private final AtomicInteger nKk;

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.nKg = i;
        this.nKh = blockingQueue;
        this.nKi = new a();
        this.nKj = new AtomicInteger(0);
        this.nKk = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.nKh.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.nKh.size());
        }
        int size = this.nKh.size();
        int i = this.nKk.get();
        if (size > i && this.nKk.compareAndSet(i, size)) {
            com.facebook.common.c.a.a(nJf, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        dWj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWj() {
        int i = this.nKj.get();
        while (i < this.nKg) {
            int i2 = i + 1;
            if (this.nKj.compareAndSet(i, i2)) {
                com.facebook.common.c.a.a(nJf, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.nKg));
                this.mExecutor.execute(this.nKi);
                return;
            }
            com.facebook.common.c.a.a(nJf, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.nKj.get();
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
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) b.this.nKh.poll();
                if (runnable == null) {
                    com.facebook.common.c.a.a(b.nJf, "%s: Worker has nothing to run", b.this.mName);
                } else {
                    runnable.run();
                }
                int decrementAndGet = b.this.nKj.decrementAndGet();
                if (!b.this.nKh.isEmpty()) {
                    b.this.dWj();
                } else {
                    com.facebook.common.c.a.a(b.nJf, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = b.this.nKj.decrementAndGet();
                if (!b.this.nKh.isEmpty()) {
                    b.this.dWj();
                } else {
                    com.facebook.common.c.a.a(b.nJf, "%s: worker finished; %d workers left", b.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }
}
