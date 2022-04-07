package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.NavigableSet;
/* loaded from: classes4.dex */
public final class CacheUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class CachingCounters {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long alreadyCachedBytes;
        public volatile long contentLength;
        public volatile long newlyCachedBytes;

        public CachingCounters() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.contentLength = -1L;
        }

        public long totalCachedBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.alreadyCachedBytes + this.newlyCachedBytes : invokeV.longValue;
        }
    }

    public CacheUtil() {
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

    public static void cache(DataSpec dataSpec, Cache cache, DataSource dataSource, CachingCounters cachingCounters) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, dataSpec, cache, dataSource, cachingCounters) == null) {
            cache(dataSpec, cache, new CacheDataSource(cache, dataSource), new byte[131072], null, 0, cachingCounters, false);
        }
    }

    public static String generateKey(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) ? uri.toString() : (String) invokeL.objValue;
    }

    public static void getCached(DataSpec dataSpec, Cache cache, CachingCounters cachingCounters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dataSpec, cache, cachingCounters) == null) {
            String key = getKey(dataSpec);
            long j = dataSpec.absoluteStreamPosition;
            long j2 = dataSpec.length;
            if (j2 == -1) {
                j2 = cache.getContentLength(key);
            }
            cachingCounters.contentLength = j2;
            cachingCounters.alreadyCachedBytes = 0L;
            cachingCounters.newlyCachedBytes = 0L;
            long j3 = j;
            long j4 = j2;
            while (j4 != 0) {
                int i = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
                long cachedBytes = cache.getCachedBytes(key, j3, i != 0 ? j4 : Long.MAX_VALUE);
                if (cachedBytes > 0) {
                    cachingCounters.alreadyCachedBytes += cachedBytes;
                } else {
                    cachedBytes = -cachedBytes;
                    if (cachedBytes == Long.MAX_VALUE) {
                        return;
                    }
                }
                j3 += cachedBytes;
                if (i == 0) {
                    cachedBytes = 0;
                }
                j4 -= cachedBytes;
            }
        }
    }

    public static String getKey(DataSpec dataSpec) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dataSpec)) == null) {
            String str = dataSpec.key;
            return str != null ? str : generateKey(dataSpec.uri);
        }
        return (String) invokeL.objValue;
    }

    public static long readAndDiscard(DataSpec dataSpec, long j, long j2, DataSource dataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, CachingCounters cachingCounters) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{dataSpec, Long.valueOf(j), Long.valueOf(j2), dataSource, bArr, priorityTaskManager, Integer.valueOf(i), cachingCounters})) != null) {
            return invokeCommon.longValue;
        }
        DataSpec dataSpec2 = dataSpec;
        while (true) {
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(i);
            }
            try {
                try {
                    if (!Thread.interrupted()) {
                        DataSpec dataSpec3 = new DataSpec(dataSpec2.uri, dataSpec2.postBody, j, (dataSpec2.position + j) - dataSpec2.absoluteStreamPosition, -1L, dataSpec2.key, dataSpec2.flags | 2);
                        try {
                            long open = dataSource.open(dataSpec3);
                            if (cachingCounters.contentLength == -1 && open != -1) {
                                cachingCounters.contentLength = dataSpec3.absoluteStreamPosition + open;
                            }
                            long j3 = 0;
                            while (true) {
                                if (j3 == j2) {
                                    break;
                                } else if (!Thread.interrupted()) {
                                    int read = dataSource.read(bArr, 0, j2 != -1 ? (int) Math.min(bArr.length, j2 - j3) : bArr.length);
                                    if (read == -1) {
                                        if (cachingCounters.contentLength == -1) {
                                            cachingCounters.contentLength = dataSpec3.absoluteStreamPosition + j3;
                                        }
                                    } else {
                                        long j4 = read;
                                        j3 += j4;
                                        cachingCounters.newlyCachedBytes += j4;
                                    }
                                } else {
                                    throw new InterruptedException();
                                }
                            }
                            return j3;
                        } catch (PriorityTaskManager.PriorityTooLowException unused) {
                            dataSpec2 = dataSpec3;
                        }
                    } else {
                        throw new InterruptedException();
                    }
                } catch (PriorityTaskManager.PriorityTooLowException unused2) {
                }
                Util.closeQuietly(dataSource);
            } finally {
                Util.closeQuietly(dataSource);
            }
        }
    }

    public static void remove(Cache cache, String str) {
        NavigableSet<CacheSpan> cachedSpans;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, cache, str) == null) || (cachedSpans = cache.getCachedSpans(str)) == null) {
            return;
        }
        for (CacheSpan cacheSpan : cachedSpans) {
            try {
                cache.removeSpan(cacheSpan);
            } catch (Cache.CacheException unused) {
            }
        }
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, CachingCounters cachingCounters, boolean z) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{dataSpec, cache, cacheDataSource, bArr, priorityTaskManager, Integer.valueOf(i), cachingCounters, Boolean.valueOf(z)}) != null) {
            return;
        }
        CachingCounters cachingCounters2 = cachingCounters;
        Assertions.checkNotNull(cacheDataSource);
        Assertions.checkNotNull(bArr);
        if (cachingCounters2 != null) {
            getCached(dataSpec, cache, cachingCounters2);
        } else {
            cachingCounters2 = new CachingCounters();
        }
        CachingCounters cachingCounters3 = cachingCounters2;
        String key = getKey(dataSpec);
        long j = dataSpec.absoluteStreamPosition;
        long j2 = dataSpec.length;
        if (j2 == -1) {
            j2 = cache.getContentLength(key);
        }
        long j3 = j;
        long j4 = j2;
        while (true) {
            long j5 = 0;
            if (j4 == 0) {
                return;
            }
            int i2 = (j4 > (-1L) ? 1 : (j4 == (-1L) ? 0 : -1));
            long cachedBytes = cache.getCachedBytes(key, j3, i2 != 0 ? j4 : Long.MAX_VALUE);
            if (cachedBytes <= 0) {
                long j6 = -cachedBytes;
                if (readAndDiscard(dataSpec, j3, j6, cacheDataSource, bArr, priorityTaskManager, i, cachingCounters3) < j6) {
                    if (z && i2 != 0) {
                        throw new EOFException();
                    }
                    return;
                }
                cachedBytes = j6;
            }
            j3 += cachedBytes;
            if (i2 != 0) {
                j5 = cachedBytes;
            }
            j4 -= j5;
        }
    }
}
