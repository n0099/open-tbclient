package com.huawei.hms.framework.common;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes10.dex */
public class AssetsUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ExecutorService EXECUTOR_SERVICE;
    public static final int GET_SP_TIMEOUT = 5;
    public static final String TAG = "AssetsUtil";
    public static final String THREAD_NAME = "AssetsUtil_Operate";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-49411246, "Lcom/huawei/hms/framework/common/AssetsUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-49411246, "Lcom/huawei/hms/framework/common/AssetsUtil;");
                return;
            }
        }
        EXECUTOR_SERVICE = ExecutorsUtils.newSingleThreadExecutor(THREAD_NAME);
    }

    public AssetsUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String[] list(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context == null) {
                Logger.w(TAG, "context is null");
                return new String[0];
            }
            FutureTask futureTask = new FutureTask(new Callable<String[]>(context, str) { // from class: com.huawei.hms.framework.common.AssetsUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$path;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$path = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public String[] call() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.val$context.getAssets().list(this.val$path);
                    }
                    return (String[]) invokeV.objValue;
                }
            });
            EXECUTOR_SERVICE.execute(futureTask);
            try {
                return (String[]) futureTask.get(5L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Logger.w(TAG, "get local config files from sp task interrupted", e);
                return new String[0];
            } catch (ExecutionException e2) {
                Logger.w(TAG, "get local config files from sp task failed", e2);
                return new String[0];
            } catch (TimeoutException unused) {
                Logger.w(TAG, "get local config files from sp task timed out");
                return new String[0];
            } catch (Exception unused2) {
                Logger.w(TAG, "get local config files from sp task occur unknown Exception");
                return new String[0];
            } finally {
                futureTask.cancel(true);
            }
        }
        return (String[]) invokeLL.objValue;
    }

    public static InputStream open(Context context, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context == null) {
                Logger.w(TAG, "context is null");
                return null;
            }
            try {
                return context.getAssets().open(str);
            } catch (RuntimeException e) {
                Logger.e(TAG, "AssetManager has been destroyed", e);
                return null;
            }
        }
        return (InputStream) invokeLL.objValue;
    }
}
