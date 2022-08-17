package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes4.dex */
public class EncodedMemoryCacheFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncodedMemoryCacheFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, memoryCache, imageCacheStatsTracker)) == null) {
            imageCacheStatsTracker.registerEncodedMemoryCache(memoryCache);
            return new InstrumentedMemoryCache<>(memoryCache, new MemoryCacheTracker<CacheKey>(imageCacheStatsTracker) { // from class: com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        this.val$imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCacheMiss(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onMemoryCacheMiss(cacheKey);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCachePut(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onMemoryCachePut(cacheKey);
                    }
                }
            });
        }
        return (InstrumentedMemoryCache) invokeLL.objValue;
    }
}
