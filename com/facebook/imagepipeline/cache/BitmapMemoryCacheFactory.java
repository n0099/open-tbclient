package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;
/* loaded from: classes11.dex */
public class BitmapMemoryCacheFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapMemoryCacheFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(MemoryCache<CacheKey, CloseableImage> memoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, memoryCache, imageCacheStatsTracker)) == null) {
            imageCacheStatsTracker.registerBitmapMemoryCache(memoryCache);
            return new InstrumentedMemoryCache<>(memoryCache, new MemoryCacheTracker<CacheKey>(imageCacheStatsTracker) { // from class: com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageCacheStatsTracker val$imageCacheStatsTracker;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {imageCacheStatsTracker};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$imageCacheStatsTracker = imageCacheStatsTracker;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCacheHit(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onBitmapCacheHit(cacheKey);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCacheMiss(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onBitmapCacheMiss(cacheKey);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCachePut(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onBitmapCachePut(cacheKey);
                    }
                }
            });
        }
        return (InstrumentedMemoryCache) invokeLL.objValue;
    }
}
