package com.yy.hiidostatis.inner.implementation;

import com.yy.hiidostatis.inner.implementation.ITaskExecutor;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.concurrent.RejectedExecutionException;
/* loaded from: classes2.dex */
public abstract class AbstractTaskExecutor implements ITaskExecutor {
    public abstract ITaskExecutor.OnTaskRejectedListener getOnTaskRejectedListener();

    public boolean isTerminated() {
        return false;
    }

    public abstract void submitTask(Runnable runnable);

    public abstract void submitTask(Runnable runnable, int i);

    /* loaded from: classes2.dex */
    public class Task implements Runnable {
        public Runnable mRunnable;

        public Task(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.mRunnable;
            if (runnable == null) {
                return;
            }
            L.brief("Begin run task %s", runnable);
            try {
                runnable.run();
            } catch (RejectedExecutionException unused) {
                if (runnable instanceof ITaskExecutor.ExecutorTask) {
                    AbstractTaskExecutor.this.getOnTaskRejectedListener().onRejectedTask((ITaskExecutor.ExecutorTask) runnable);
                }
            } catch (Throwable th) {
                L.error(this, "Exception when run task %s", th);
            }
            L.brief("End run task.", new Object[0]);
        }
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(ITaskExecutor.ExecutorTask executorTask) {
        submitTask(new Task(executorTask));
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(ITaskExecutor.ExecutorTask executorTask, int i) {
        submitTask(new Task(executorTask), i);
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(Runnable runnable) {
        submitTask(new Task(runnable));
    }

    @Override // com.yy.hiidostatis.inner.implementation.ITaskExecutor
    public void submit(Runnable runnable, int i) {
        submitTask(new Task(runnable), i);
    }
}
