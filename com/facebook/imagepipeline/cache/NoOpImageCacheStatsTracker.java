package com.facebook.imagepipeline.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
/* loaded from: classes4.dex */
public class NoOpImageCacheStatsTracker implements ImageCacheStatsTracker {
    public static /* synthetic */ Interceptable $ic;
    public static NoOpImageCacheStatsTracker sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1430025291, "Lcom/facebook/imagepipeline/cache/NoOpImageCacheStatsTracker;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1430025291, "Lcom/facebook/imagepipeline/cache/NoOpImageCacheStatsTracker;");
        }
    }

    public NoOpImageCacheStatsTracker() {
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

    public static synchronized NoOpImageCacheStatsTracker getInstance() {
        InterceptResult invokeV;
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (NoOpImageCacheStatsTracker.class) {
                if (sInstance == null) {
                    sInstance = new NoOpImageCacheStatsTracker();
                }
                noOpImageCacheStatsTracker = sInstance;
            }
            return noOpImageCacheStatsTracker;
        }
        return (NoOpImageCacheStatsTracker) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheHit(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCacheMiss(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onBitmapCachePut(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheGetFail(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheHit(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCacheMiss(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onDiskCachePut(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheHit(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCacheMiss(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onMemoryCachePut(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaHit(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void onStagingAreaMiss(CacheKey cacheKey) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cacheKey) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerBitmapMemoryCache(MemoryCache<?, ?> memoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, memoryCache) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.cache.ImageCacheStatsTracker
    public void registerEncodedMemoryCache(MemoryCache<?, ?> memoryCache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, memoryCache) == null) {
        }
    }
}
