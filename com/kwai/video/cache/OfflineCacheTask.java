package com.kwai.video.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.anotations.CalledByNative;
/* loaded from: classes7.dex */
public class OfflineCacheTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeTask;
    public OfflineCacheTaskListener taskListener;

    /* loaded from: classes7.dex */
    public interface OfflineCacheTaskListener {
        void onCancelled();

        void onFailed(int i2);

        void onProgress(long j, long j2);

        void onStarted(long j, long j2, long j3);

        void onStopped(long j, long j2, String str);

        void onSuccessful();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(611198101, "Lcom/kwai/video/cache/OfflineCacheTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(611198101, "Lcom/kwai/video/cache/OfflineCacheTask;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public OfflineCacheTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.nativeTask = 0L;
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    @CalledByNative
    private void onCancelled() {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onCancelled();
    }

    @CalledByNative
    private void onFailed(int i2) {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onFailed(i2);
    }

    @CalledByNative
    private void onProgress(long j, long j2) {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onProgress(j, j2);
    }

    @CalledByNative
    private void onStarted(long j, long j2, long j3) {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onStarted(j, j2, j3);
    }

    @CalledByNative
    private void onStopped(long j, long j2, String str) {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onStopped(j, j2, str);
    }

    @CalledByNative
    private void onSuccessFul() {
        OfflineCacheTaskListener offlineCacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (offlineCacheTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheTaskListener.onSuccessful();
    }

    public synchronized void releaseAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                new Thread(this, this.nativeTask) { // from class: com.kwai.video.cache.OfflineCacheTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OfflineCacheTask this$0;
                    public final /* synthetic */ long val$task;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(r7)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$task = r7;
                    }

                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.nativeDispose(this.val$task);
                        }
                    }
                }.start();
                this.nativeTask = 0L;
            }
        }
    }

    public synchronized void run(OfflineCacheTaskListener offlineCacheTaskListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, offlineCacheTaskListener) == null) {
            synchronized (this) {
                this.taskListener = offlineCacheTaskListener;
                nativeRun(this.nativeTask);
            }
        }
    }

    public synchronized void setNativeTask(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            synchronized (this) {
                this.nativeTask = j;
            }
        }
    }
}
