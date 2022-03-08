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

    public LeastRecentlyUsedCacheEvictor(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maxBytes = j2;
        this.leastRecentlyUsed = new TreeSet<>(this);
    }

    private void evictCache(Cache cache, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, this, cache, j2) == null) {
            while (this.currentSize + j2 > this.maxBytes && !this.leastRecentlyUsed.isEmpty()) {
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
    public void onStartFile(Cache cache, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{cache, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            evictCache(cache, j3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cacheSpan, cacheSpan2)) == null) {
            long j2 = cacheSpan.lastAccessTimestamp;
            long j3 = cacheSpan2.lastAccessTimestamp;
            if (j2 - j3 == 0) {
                return cacheSpan.compareTo(cacheSpan2);
            }
            return j2 < j3 ? -1 : 1;
        }
        return invokeLL.intValue;
    }
}
