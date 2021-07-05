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
public class CacheTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeTask;
    public CacheTaskListener taskListener;

    /* loaded from: classes7.dex */
    public interface CacheTaskListener {
        void onCancelled();

        void onFailed(int i2);

        void onProgress(long j, long j2);

        void onSuccessful();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1302745770, "Lcom/kwai/video/cache/CacheTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1302745770, "Lcom/kwai/video/cache/CacheTask;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public CacheTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private native void nativeCancel(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispose(long j);

    private native void nativeRun(long j);

    @CalledByNative
    private void onCancelled() {
        CacheTaskListener cacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (cacheTaskListener = this.taskListener) == null) {
            return;
        }
        cacheTaskListener.onCancelled();
    }

    @CalledByNative
    private void onFailed(int i2) {
        CacheTaskListener cacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65543, this, i2) == null) || (cacheTaskListener = this.taskListener) == null) {
            return;
        }
        cacheTaskListener.onFailed(i2);
    }

    @CalledByNative
    private void onProgress(long j, long j2) {
        CacheTaskListener cacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (cacheTaskListener = this.taskListener) == null) {
            return;
        }
        cacheTaskListener.onProgress(j, j2);
    }

    @CalledByNative
    private void onSuccessFul() {
        CacheTaskListener cacheTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (cacheTaskListener = this.taskListener) == null) {
            return;
        }
        cacheTaskListener.onSuccessful();
    }

    public synchronized void releaseAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                new Thread(this, this.nativeTask) { // from class: com.kwai.video.cache.CacheTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CacheTask this$0;
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

    public synchronized void run(CacheTaskListener cacheTaskListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheTaskListener) == null) {
            synchronized (this) {
                this.taskListener = cacheTaskListener;
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
