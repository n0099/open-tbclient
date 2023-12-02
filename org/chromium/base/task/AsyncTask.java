package org.chromium.base.task;

import android.os.Binder;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.DoNotInline;
import org.chromium.base.task.AsyncTask;
import org.chromium.base.task.PostTask;
import org.chromium.base.task.TaskTraits;
/* loaded from: classes2.dex */
public abstract class AsyncTask<Result> {
    public static final String TAG = "AsyncTask";
    public static final Executor THREAD_POOL_EXECUTOR = new Executor() { // from class: com.baidu.tieba.omc
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, runnable);
            }
        }
    };
    public static final Executor SERIAL_EXECUTOR = new SerialExecutor();
    public static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = new StealRunnableHandler();
    public volatile int mStatus = 0;
    public final AtomicBoolean mCancelled = new AtomicBoolean();
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    public final Callable<Result> mWorker = new Callable<Result>() { // from class: org.chromium.base.task.AsyncTask.1
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            AsyncTask.this.mTaskInvoked.set(true);
            Result result = null;
            try {
                result = (Result) AsyncTask.this.doInBackground();
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    };
    public final AsyncTask<Result>.NamedFutureTask mFuture = new NamedFutureTask(this.mWorker);

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    @WorkerThread
    public abstract Result doInBackground();

    @MainThread
    public void onCancelled() {
    }

    @MainThread
    public abstract void onPostExecute(Result result);

    @MainThread
    public void onPreExecute() {
    }

    /* loaded from: classes2.dex */
    public class NamedFutureTask extends FutureTask<Result> {
        public NamedFutureTask(Callable<Result> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e.toString(), new Object[0]);
            } catch (CancellationException unused) {
                AsyncTask.this.postResultIfNotInvoked(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            }
        }

        public Class getBlamedClass() {
            return AsyncTask.this.getClass();
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent scoped = TraceEvent.scoped("AsyncTask.run: " + AsyncTask.this.mFuture.getBlamedClass());
            try {
                super.run();
                if (scoped != null) {
                    scoped.close();
                }
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class StealRunnableHandler implements RejectedExecutionHandler {
        public StealRunnableHandler() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }

    private void executionPreamble() {
        if (this.mStatus != 0) {
            int i = this.mStatus;
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            } else {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
        }
        this.mStatus = 1;
        onPreExecute();
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        threadPoolExecutor.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        threadPoolExecutor.shutdown();
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: finish */
    public void a(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(final Result result) {
        if (this instanceof BackgroundOnlyAsyncTask) {
            this.mStatus = 2;
        } else {
            ThreadUtils.postOnUiThread(new Runnable() { // from class: com.baidu.tieba.nmc
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        AsyncTask.this.a(result);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    @MainThread
    public final AsyncTask<Result> executeOnExecutor(Executor executor) {
        executionPreamble();
        executor.execute(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner taskRunner) {
        executionPreamble();
        taskRunner.postTask(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits taskTraits) {
        executionPreamble();
        PostTask.postTask(taskTraits, this.mFuture);
        return this;
    }

    @MainThread
    public void onCancelled(Result result) {
        onCancelled();
    }

    @DoNotInline
    public final Result get() throws InterruptedException, ExecutionException {
        StackTraceElement[] stackTrace;
        String str;
        if (getStatus() != 2 && ThreadUtils.runningOnUiThread()) {
            if (new Exception().getStackTrace().length > 1) {
                str = stackTrace[1].getClassName() + IStringUtil.EXTENSION_SEPARATOR + stackTrace[1].getMethodName() + IStringUtil.EXTENSION_SEPARATOR;
            } else {
                str = "";
            }
            TraceEvent scoped = TraceEvent.scoped(str + "AsyncTask.get");
            try {
                Result result = this.mFuture.get();
                if (scoped != null) {
                    scoped.close();
                    return result;
                }
                return result;
            } catch (Throwable th) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return this.mFuture.get();
    }
}
