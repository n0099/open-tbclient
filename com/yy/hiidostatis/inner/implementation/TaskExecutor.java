package com.yy.hiidostatis.inner.implementation;

import com.yy.hiidostatis.api.ExecutorProvider;
import com.yy.hiidostatis.inner.implementation.ITaskExecutor;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.mobile.perf.taskexecutor.IQueueTaskExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class TaskExecutor extends AbstractTaskExecutor {
    public ScheduledExecutorService mExecutor;
    public final ITaskExecutor.OnTaskRejectedListener mOnTaskRejectedListener;
    public IQueueTaskExecutor singleTaskExecutor;

    public TaskExecutor(ITaskExecutor.OnTaskRejectedListener onTaskRejectedListener) {
        this(onTaskRejectedListener, "Statis_SDK_Worker");
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public ITaskExecutor.OnTaskRejectedListener getOnTaskRejectedListener() {
        return this.mOnTaskRejectedListener;
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public void submitTask(Runnable runnable) {
        try {
            if (this.singleTaskExecutor != null) {
                this.singleTaskExecutor.execute(runnable, 0L);
            } else {
                this.mExecutor.execute(runnable);
            }
        } catch (Throwable unused) {
            ThreadPool.getPool().executeQueue(runnable);
        }
    }

    public TaskExecutor(ITaskExecutor.OnTaskRejectedListener onTaskRejectedListener, final String str) {
        if (ExecutorProvider.getIyyTaskExecutor() != null) {
            try {
                this.singleTaskExecutor = ExecutorProvider.getIyyTaskExecutor().createAQueueExcuter();
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
        if (this.singleTaskExecutor == null) {
            this.mExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.yy.hiidostatis.inner.implementation.TaskExecutor.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName(str);
                    thread.setPriority(1);
                    return thread;
                }
            });
        }
        this.mOnTaskRejectedListener = onTaskRejectedListener;
    }

    @Override // com.yy.hiidostatis.inner.implementation.AbstractTaskExecutor
    public void submitTask(Runnable runnable, int i2) {
        try {
            if (this.singleTaskExecutor != null) {
                this.singleTaskExecutor.execute(runnable, i2);
            } else {
                this.mExecutor.schedule(runnable, i2, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable unused) {
            ThreadPool.getPool().executeQueue(runnable);
        }
    }
}
