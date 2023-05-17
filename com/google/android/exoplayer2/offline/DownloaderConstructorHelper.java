package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
/* loaded from: classes9.dex */
public final class DownloaderConstructorHelper {
    public final Cache cache;
    public final DataSource.Factory cacheReadDataSourceFactory;
    public final DataSink.Factory cacheWriteDataSinkFactory;
    public final PriorityTaskManager priorityTaskManager;
    public final DataSource.Factory upstreamDataSourceFactory;

    public DownloaderConstructorHelper(Cache cache, DataSource.Factory factory) {
        this(cache, factory, null, null, null);
    }

    public DownloaderConstructorHelper(Cache cache, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager) {
        Assertions.checkNotNull(factory);
        this.cache = cache;
        this.upstreamDataSourceFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.priorityTaskManager = priorityTaskManager;
    }

    public CacheDataSource buildCacheDataSource(boolean z) {
        DataSource fileDataSource;
        DataSink cacheDataSink;
        PriorityDataSource priorityDataSource;
        DataSource.Factory factory = this.cacheReadDataSourceFactory;
        if (factory != null) {
            fileDataSource = factory.createDataSource();
        } else {
            fileDataSource = new FileDataSource();
        }
        DataSource dataSource = fileDataSource;
        if (z) {
            return new CacheDataSource(this.cache, DummyDataSource.INSTANCE, dataSource, null, 1, null);
        }
        DataSink.Factory factory2 = this.cacheWriteDataSinkFactory;
        if (factory2 != null) {
            cacheDataSink = factory2.createDataSink();
        } else {
            cacheDataSink = new CacheDataSink(this.cache, 2097152L);
        }
        DataSink dataSink = cacheDataSink;
        DataSource createDataSource = this.upstreamDataSourceFactory.createDataSource();
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager == null) {
            priorityDataSource = createDataSource;
        } else {
            priorityDataSource = new PriorityDataSource(createDataSource, priorityTaskManager, -1000);
        }
        return new CacheDataSource(this.cache, priorityDataSource, dataSource, dataSink, 1, null);
    }

    public Cache getCache() {
        return this.cache;
    }

    public PriorityTaskManager getPriorityTaskManager() {
        PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
        if (priorityTaskManager == null) {
            return new PriorityTaskManager();
        }
        return priorityTaskManager;
    }
}
