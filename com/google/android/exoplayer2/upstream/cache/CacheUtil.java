package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
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
    public static final int DEFAULT_BUFFER_SIZE_BYTES = 131072;

    /* loaded from: classes7.dex */
    public static class CachingCounters {
        public volatile long alreadyCachedBytes;
        public volatile long contentLength = -1;
        public volatile long newlyCachedBytes;

        public long totalCachedBytes() {
            return this.alreadyCachedBytes + this.newlyCachedBytes;
        }
    }

    public static void cache(DataSpec dataSpec, Cache cache, DataSource dataSource, CachingCounters cachingCounters) throws IOException, InterruptedException {
        cache(dataSpec, cache, new CacheDataSource(cache, dataSource), new byte[131072], null, 0, cachingCounters, false);
    }

    public static void cache(DataSpec dataSpec, Cache cache, CacheDataSource cacheDataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, CachingCounters cachingCounters, boolean z) throws IOException, InterruptedException {
        long j;
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
            if (j5 != 0) {
                int i2 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
                if (i2 != 0) {
                    j = j5;
                } else {
                    j = Long.MAX_VALUE;
                }
                long cachedBytes = cache.getCachedBytes(key, j4, j);
                if (cachedBytes <= 0) {
                    long j7 = -cachedBytes;
                    if (readAndDiscard(dataSpec, j4, j7, cacheDataSource, bArr, priorityTaskManager, i, cachingCounters3) < j7) {
                        if (z && i2 != 0) {
                            throw new EOFException();
                        }
                        return;
                    }
                    cachedBytes = j7;
                }
                j4 += cachedBytes;
                if (i2 != 0) {
                    j6 = cachedBytes;
                }
                j5 -= j6;
            } else {
                return;
            }
        }
    }

    public static String generateKey(Uri uri) {
        return uri.toString();
    }

    public static String getKey(DataSpec dataSpec) {
        String str = dataSpec.key;
        if (str == null) {
            return generateKey(dataSpec.uri);
        }
        return str;
    }

    public static void getCached(DataSpec dataSpec, Cache cache, CachingCounters cachingCounters) {
        long j;
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
            int i = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
            if (i != 0) {
                j = j5;
            } else {
                j = Long.MAX_VALUE;
            }
            long cachedBytes = cache.getCachedBytes(key, j4, j);
            if (cachedBytes > 0) {
                cachingCounters.alreadyCachedBytes += cachedBytes;
            } else {
                cachedBytes = -cachedBytes;
                if (cachedBytes == Long.MAX_VALUE) {
                    return;
                }
            }
            j4 += cachedBytes;
            if (i == 0) {
                cachedBytes = 0;
            }
            j5 -= cachedBytes;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long readAndDiscard(DataSpec dataSpec, long j, long j2, DataSource dataSource, byte[] bArr, PriorityTaskManager priorityTaskManager, int i, CachingCounters cachingCounters) throws IOException, InterruptedException {
        int length;
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
                                    if (j2 != -1) {
                                        length = (int) Math.min(bArr.length, j2 - j3);
                                    } else {
                                        length = bArr.length;
                                    }
                                    int read = dataSource.read(bArr, 0, length);
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
                        } catch (PriorityTaskManager.PriorityTooLowException unused) {
                            dataSpec2 = dataSpec3;
                        }
                    } else {
                        throw new InterruptedException();
                        break;
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
        NavigableSet<CacheSpan> cachedSpans = cache.getCachedSpans(str);
        if (cachedSpans == null) {
            return;
        }
        for (CacheSpan cacheSpan : cachedSpans) {
            try {
                cache.removeSpan(cacheSpan);
            } catch (Cache.CacheException unused) {
            }
        }
    }
}
