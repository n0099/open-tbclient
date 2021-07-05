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
public class OfflineCacheVodTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TASK_FAIL_REASON_CANCEL = 5;
    public static final int TASK_FAIL_REASON_CREATE_TASK_FAIL = 4;
    public static final int TASK_FAIL_REASON_OPEN_DATE_SOURCE = 2;
    public static final int TASK_FAIL_REASON_READ_FAIL = 3;
    public static final int TASK_FAIL_REASON_WRITE_FILE = 1;
    public static final int TASK_SUCCESS = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public long nativeTask;
    public OfflineCacheVodTaskListener taskListener;

    /* loaded from: classes7.dex */
    public interface OfflineCacheVodTaskListener {
        void onComplete(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(117629868, "Lcom/kwai/video/cache/OfflineCacheVodTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(117629868, "Lcom/kwai/video/cache/OfflineCacheVodTask;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public OfflineCacheVodTask() {
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
    private void onComplete(int i2) {
        OfflineCacheVodTaskListener offlineCacheVodTaskListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) || (offlineCacheVodTaskListener = this.taskListener) == null) {
            return;
        }
        offlineCacheVodTaskListener.onComplete(i2);
    }

    public synchronized void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                release();
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                new Thread(this, this.nativeTask) { // from class: com.kwai.video.cache.OfflineCacheVodTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OfflineCacheVodTask this$0;
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

    public synchronized void setNativeTask(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            synchronized (this) {
                this.nativeTask = j;
            }
        }
    }

    public synchronized void start(OfflineCacheVodTaskListener offlineCacheVodTaskListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, offlineCacheVodTaskListener) == null) {
            synchronized (this) {
                this.taskListener = offlineCacheVodTaskListener;
                nativeRun(this.nativeTask);
            }
        }
    }
}
