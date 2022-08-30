package com.google.android.exoplayer2.upstream.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor, Comparator<CacheSpan> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long currentSize;
    public final TreeSet<CacheSpan> leastRecentlyUsed;
    public final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maxBytes = j;
        this.leastRecentlyUsed = new TreeSet<>(this);
    }

    private void evictCache(Cache cache, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, this, cache, j) == null) {
            while (this.currentSize + j > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
                try {
                    cache.removeSpan(this.leastRecentlyUsed.first());
                } catch (Cache.CacheException unused) {
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onCacheInitialized() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cache, cacheSpan) == null) {
            this.leastRecentlyUsed.add(cacheSpan);
            this.currentSize += cacheSpan.length;
            evictCache(cache, 0L);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cache, cacheSpan) == null) {
            this.leastRecentlyUsed.remove(cacheSpan);
            this.currentSize -= cacheSpan.length;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.Listener
    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, cache, cacheSpan, cacheSpan2) == null) {
            onSpanRemoved(cache, cacheSpan);
            onSpanAdded(cache, cacheSpan2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.CacheEvictor
    public void onStartFile(Cache cache, String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cache, str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            evictCache(cache, j2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cacheSpan, cacheSpan2)) == null) {
            long j = cacheSpan.lastAccessTimestamp;
            long j2 = cacheSpan2.lastAccessTimestamp;
            if (j - j2 == 0) {
                return cacheSpan.compareTo(cacheSpan2);
            }
            return j < j2 ? -1 : 1;
        }
        return invokeLL.intValue;
    }
}
