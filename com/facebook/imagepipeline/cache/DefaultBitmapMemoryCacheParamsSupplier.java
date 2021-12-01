package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Supplier;
/* loaded from: classes12.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CACHE_ENTRIES = 256;
    public static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public final ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activityManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mActivityManager = activityManager;
    }

    private int getMaxCacheSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE) : (MemoryCacheParams) invokeV.objValue;
    }
}
