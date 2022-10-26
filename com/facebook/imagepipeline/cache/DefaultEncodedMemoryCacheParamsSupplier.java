package com.facebook.imagepipeline.cache;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final long PARAMS_CHECK_INTERVAL_MS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1183752605, "Lcom/facebook/imagepipeline/cache/DefaultEncodedMemoryCacheParamsSupplier;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1183752605, "Lcom/facebook/imagepipeline/cache/DefaultEncodedMemoryCacheParamsSupplier;");
                return;
            }
        }
        PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
    }

    public DefaultEncodedMemoryCacheParamsSupplier() {
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

    private int getMaxCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min < 16777216) {
                return 1048576;
            }
            if (min < 33554432) {
                return 2097152;
            }
            return 4194304;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int maxCacheSize = getMaxCacheSize();
            return new MemoryCacheParams(maxCacheSize, Integer.MAX_VALUE, maxCacheSize, Integer.MAX_VALUE, maxCacheSize / 8, PARAMS_CHECK_INTERVAL_MS);
        }
        return (MemoryCacheParams) invokeV.objValue;
    }
}
