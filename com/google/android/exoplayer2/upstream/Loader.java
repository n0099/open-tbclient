package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public final class Loader implements LoaderErrorThrower {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DONT_RETRY = 2;
    public static final int DONT_RETRY_FATAL = 3;
    public static final int RETRY = 0;
    public static final int RETRY_RESET_ERROR_COUNT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public LoadTask<? extends Loadable> currentTask;
    public final ExecutorService downloadExecutorService;
    public IOException fatalError;

    /* loaded from: classes4.dex */
    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        int onLoadError(T t, long j, long j2, IOException iOException);
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_CANCEL = 1;
        public static final int MSG_END_OF_SOURCE = 2;
        public static final int MSG_FATAL_ERROR = 4;
        public static final int MSG_IO_EXCEPTION = 3;
        public static final int MSG_START = 0;
        public static final String TAG = "LoadTask";
        public transient /* synthetic */ FieldHolder $fh;
        public final Callback<T> callback;
        public IOException currentError;
        public final int defaultMinRetryCount;
        public int errorCount;
        public volatile Thread executorThread;
        public final T loadable;
        public volatile boolean released;
        public final long startTimeMs;
        public final /* synthetic */ Loader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadTask(Loader loader, Looper looper, T t, Callback<T> callback, int i, long j) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {loader, looper, t, callback, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = loader;
            this.loadable = t;
            this.callback = callback;
            this.defaultMinRetryCount = i;
            this.startTimeMs = j;
        }

        private void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.currentError = null;
                this.this$0.downloadExecutorService.execute(this.this$0.currentTask);
            }
        }

        private void finish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.this$0.currentTask = null;
            }
        }

        private long getRetryDelayMillis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? Math.min((this.errorCount - 1) * 1000, 5000) : invokeV.longValue;
        }

        public void cancel(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.released = z;
                this.currentError = null;
                if (hasMessages(0)) {
                    removeMessages(0);
                    if (!z) {
                        sendEmptyMessage(1);
                    }
                } else {
                    this.loadable.cancelLoad();
                    if (this.executorThread != null) {
                        this.executorThread.interrupt();
                    }
                }
                if (z) {
                    finish();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.callback.onLoadCanceled(this.loadable, elapsedRealtime, elapsedRealtime - this.startTimeMs, true);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || this.released) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                execute();
            } else if (i != 4) {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.startTimeMs;
                if (this.loadable.isLoadCanceled()) {
                    this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.callback.onLoadCanceled(this.loadable, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    try {
                        this.callback.onLoadCompleted(this.loadable, elapsedRealtime, j);
                    } catch (RuntimeException e) {
                        Log.e(TAG, "Unexpected exception handling load completed", e);
                        this.this$0.fatalError = new UnexpectedLoaderException(e);
                    }
                } else if (i2 != 3) {
                } else {
                    IOException iOException = (IOException) message.obj;
                    this.currentError = iOException;
                    int onLoadError = this.callback.onLoadError(this.loadable, elapsedRealtime, j, iOException);
                    if (onLoadError == 3) {
                        this.this$0.fatalError = this.currentError;
                    } else if (onLoadError != 2) {
                        this.errorCount = onLoadError != 1 ? 1 + this.errorCount : 1;
                        start(getRetryDelayMillis());
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }

        public void maybeThrowError(int i) throws IOException {
            IOException iOException;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (iOException = this.currentError) != null && this.errorCount > i) {
                throw iOException;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    this.executorThread = Thread.currentThread();
                    if (!this.loadable.isLoadCanceled()) {
                        TraceUtil.beginSection("load:" + this.loadable.getClass().getSimpleName());
                        try {
                            this.loadable.load();
                            TraceUtil.endSection();
                        } catch (Throwable th) {
                            TraceUtil.endSection();
                            throw th;
                        }
                    }
                    if (this.released) {
                        return;
                    }
                    sendEmptyMessage(2);
                } catch (IOException e) {
                    if (this.released) {
                        return;
                    }
                    obtainMessage(3, e).sendToTarget();
                } catch (Error e2) {
                    Log.e(TAG, "Unexpected error loading stream", e2);
                    if (!this.released) {
                        obtainMessage(4, e2).sendToTarget();
                    }
                    throw e2;
                } catch (InterruptedException unused) {
                    Assertions.checkState(this.loadable.isLoadCanceled());
                    if (this.released) {
                        return;
                    }
                    sendEmptyMessage(2);
                } catch (Exception e3) {
                    Log.e(TAG, "Unexpected exception loading stream", e3);
                    if (this.released) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
                } catch (OutOfMemoryError e4) {
                    Log.e(TAG, "OutOfMemory error loading stream", e4);
                    if (this.released) {
                        return;
                    }
                    obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            }
        }

        public void start(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                Assertions.checkState(this.this$0.currentTask == null);
                this.this$0.currentTask = this;
                if (j > 0) {
                    sendEmptyMessageDelayed(0, j);
                } else {
                    execute();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Loadable {
        void cancelLoad();

        boolean isLoadCanceled();

        void load() throws IOException, InterruptedException;
    }

    /* loaded from: classes4.dex */
    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    /* loaded from: classes4.dex */
    public static final class ReleaseTask extends Handler implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ReleaseCallback callback;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {releaseCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callback = releaseCallback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.callback.onLoaderReleased();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getLooper().getThread().isAlive()) {
                sendEmptyMessage(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class UnexpectedLoaderException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedLoaderException(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public Loader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.downloadExecutorService = Util.newSingleThreadExecutor(str);
    }

    public void cancelLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.currentTask.cancel(false);
        }
    }

    public boolean isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.currentTask != null : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            maybeThrowError(Integer.MIN_VALUE);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            release(null);
        }
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, t, callback, i)) == null) {
            Looper myLooper = Looper.myLooper();
            Assertions.checkState(myLooper != null);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            new LoadTask(this, myLooper, t, callback, i, elapsedRealtime).start(0L);
            return elapsedRealtime;
        }
        return invokeLLI.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            IOException iOException = this.fatalError;
            if (iOException == null) {
                LoadTask<? extends Loadable> loadTask = this.currentTask;
                if (loadTask != null) {
                    if (i == Integer.MIN_VALUE) {
                        i = loadTask.defaultMinRetryCount;
                    }
                    loadTask.maybeThrowError(i);
                    return;
                }
                return;
            }
            throw iOException;
        }
    }

    public boolean release(ReleaseCallback releaseCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, releaseCallback)) == null) {
            LoadTask<? extends Loadable> loadTask = this.currentTask;
            boolean z = true;
            if (loadTask != null) {
                loadTask.cancel(true);
                if (releaseCallback != null) {
                    this.downloadExecutorService.execute(new ReleaseTask(releaseCallback));
                }
            } else if (releaseCallback != null) {
                releaseCallback.onLoaderReleased();
                this.downloadExecutorService.shutdown();
                return z;
            }
            z = false;
            this.downloadExecutorService.shutdown();
            return z;
        }
        return invokeL.booleanValue;
    }
}
