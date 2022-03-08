package com.facebook.imagepipeline.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes7.dex */
public class EncodedMemoryCacheFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncodedMemoryCacheFactory() {
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

    public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, countingMemoryCache, imageCacheStatsTracker)) == null) {
            imageCacheStatsTracker.registerEncodedMemoryCache(countingMemoryCache);
            return new InstrumentedMemoryCache<>(countingMemoryCache, new MemoryCacheTracker<CacheKey>(imageCacheStatsTracker) { // from class: com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory.1
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

                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCacheMiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$imageCacheStatsTracker.onMemoryCacheMiss();
                    }
                }

                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCachePut() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.val$imageCacheStatsTracker.onMemoryCachePut();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
                public void onCacheHit(CacheKey cacheKey) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cacheKey) == null) {
                        this.val$imageCacheStatsTracker.onMemoryCacheHit(cacheKey);
                    }
                }
            });
        }
        return (InstrumentedMemoryCache) invokeLL.objValue;
    }
}
