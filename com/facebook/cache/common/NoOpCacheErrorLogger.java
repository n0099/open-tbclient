package com.facebook.cache.common;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class NoOpCacheErrorLogger implements CacheErrorLogger {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static NoOpCacheErrorLogger sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-5892229, "Lcom/facebook/cache/common/NoOpCacheErrorLogger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-5892229, "Lcom/facebook/cache/common/NoOpCacheErrorLogger;");
        }
    }

    @Override // com.facebook.cache.common.CacheErrorLogger
    public void logError(CacheErrorLogger.CacheErrorCategory cacheErrorCategory, Class cls, String str, @Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, cacheErrorCategory, cls, str, th) == null) {
        }
    }

    public NoOpCacheErrorLogger() {
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

    public static synchronized NoOpCacheErrorLogger getInstance() {
        InterceptResult invokeV;
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (NoOpCacheErrorLogger.class) {
                if (sInstance == null) {
                    sInstance = new NoOpCacheErrorLogger();
                }
                noOpCacheErrorLogger = sInstance;
            }
            return noOpCacheErrorLogger;
        }
        return (NoOpCacheErrorLogger) invokeV.objValue;
    }
}
