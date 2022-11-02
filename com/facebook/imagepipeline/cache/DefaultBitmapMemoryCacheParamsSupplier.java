package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
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
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CACHE_ENTRIES = 256;
    public static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    public static final long PARAMS_CHECK_INTERVAL_MS;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityManager mActivityManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(9579466, "Lcom/facebook/imagepipeline/cache/DefaultBitmapMemoryCacheParamsSupplier;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(9579466, "Lcom/facebook/imagepipeline/cache/DefaultBitmapMemoryCacheParamsSupplier;");
                return;
            }
        }
        PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, PARAMS_CHECK_INTERVAL_MS);
        }
        return (MemoryCacheParams) invokeV.objValue;
    }

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivityManager = activityManager;
    }

    private int getMaxCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int min = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
            if (min < 33554432) {
                return 4194304;
            }
            if (min < 67108864) {
                return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
            }
            if (Build.VERSION.SDK_INT < 11) {
                return 8388608;
            }
            return min / 4;
        }
        return invokeV.intValue;
    }
}
