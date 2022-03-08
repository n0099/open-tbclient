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
/* loaded from: classes7.dex */
public final class CacheUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            long j2 = dataSpec.absoluteStreamPosition;
            long j3 = dataSpec.length;
            if (j3 == -1) {
                j3 = cache.getContentLength(key);
            }
            cachingCounters.contentLength = j3;
            cachingCounters.alreadyCachedBytes = 0L;
            cachingCounters.newlyCachedBytes = 0L;
            long j4 = j2;
            long j5 = j3;
            while (j5 != 0) {
                int i2 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
                long cachedBytes = cache.getCachedBytes(key, j4, i2 != 0 ? j5 : Long.MAX_VALUE);
                if (cachedBytes > 0) {
                    cachingCounters.alreadyCachedBytes += cachedBytes;
                } else {
                    cachedBytes = -cachedBytes;
                    if (cachedBytes == Long.MAX_VALUE) {
                        return;
                    }
                }
                j4 += cachedBytes;
                if (i2 == 0) {
                    cachedBytes = 0;
                }
                j5 -= cachedBytes;
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

    public static long readAndDiscard(DataSpec dataSpec, long j2, long j3, DataSource dataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i2, CachingCounters cachingCounters) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{dataSpec, Long.valueOf(j2), Long.valueOf(j3), dataSource, bArr, priorityTaskManager, Integer.valueOf(i2), cachingCounters})) != null) {
            return invokeCommon.longValue;
        }
        DataSpec dataSpec2 = dataSpec;
        while (true) {
            if (priorityTaskManager != null) {
                priorityTaskManager.proceed(i2);
            }
            try {
                try {
                    if (!Thread.interrupted()) {
                        DataSpec dataSpec3 = new DataSpec(dataSpec2.uri, dataSpec2.postBody, j2, (dataSpec2.position + j2) - dataSpec2.absoluteStreamPosition, -1L, dataSpec2.key, dataSpec2.flags | 2);
                        try {
                            long open = dataSource.open(dataSpec3);
                            if (cachingCounters.contentLength == -1 && open != -1) {
                                cachingCounters.contentLength = dataSpec3.absoluteStreamPosition + open;
                            }
                            long j4 = 0;
                            while (true) {
                                if (j4 == j3) {
                                    break;
                                } else if (!Thread.interrupted()) {
                                    int read = dataSource.read(bArr, 0, j3 != -1 ? (int) Math.min(bArr.length, j3 - j4) : bArr.length);
                                    if (read == -1) {
                                        if (cachingCounters.contentLength == -1) {
                                            cachingCounters.contentLength = dataSpec3.absoluteStreamPosition + j4;
                                        }
                                    } else {
                                        long j5 = read;
                                        j4 += j5;
                                        cachingCounters.newlyCachedBytes += j5;
                                    }
                                } else {
                                    throw new InterruptedException();
                                }
                            }
                            return j4;
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

    public static void cache(DataSpec dataSpec, Cache cache, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i2, CachingCounters cachingCounters, boolean z) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{dataSpec, cache, cacheDataSource, bArr, priorityTaskManager, Integer.valueOf(i2), cachingCounters, Boolean.valueOf(z)}) != null) {
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
        long j2 = dataSpec.absoluteStreamPosition;
        long j3 = dataSpec.length;
        if (j3 == -1) {
            j3 = cache.getContentLength(key);
        }
        long j4 = j2;
        long j5 = j3;
        while (true) {
            long j6 = 0;
            if (j5 == 0) {
                return;
            }
            int i3 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
            long cachedBytes = cache.getCachedBytes(key, j4, i3 != 0 ? j5 : Long.MAX_VALUE);
            if (cachedBytes <= 0) {
                long j7 = -cachedBytes;
                if (readAndDiscard(dataSpec, j4, j7, cacheDataSource, bArr, priorityTaskManager, i2, cachingCounters3) < j7) {
                    if (z && i3 != 0) {
                        throw new EOFException();
                    }
                    return;
                }
                cachedBytes = j7;
            }
            j4 += cachedBytes;
            if (i3 != 0) {
                j6 = cachedBytes;
            }
            j5 -= j6;
        }
    }
}
