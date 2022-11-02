package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class DownloaderConstructorHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Cache cache;
    public final DataSource.Factory cacheReadDataSourceFactory;
    public final DataSink.Factory cacheWriteDataSinkFactory;
    public final PriorityTaskManager priorityTaskManager;
    public final DataSource.Factory upstreamDataSourceFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloaderConstructorHelper(Cache cache, DataSource.Factory factory) {
        this(cache, factory, null, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, factory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], (DataSource.Factory) objArr2[1], (DataSource.Factory) objArr2[2], (DataSink.Factory) objArr2[3], (PriorityTaskManager) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public DownloaderConstructorHelper(Cache cache, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, factory, factory2, factory3, priorityTaskManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Assertions.checkNotNull(factory);
        this.cache = cache;
        this.upstreamDataSourceFactory = factory;
        this.cacheReadDataSourceFactory = factory2;
        this.cacheWriteDataSinkFactory = factory3;
        this.priorityTaskManager = priorityTaskManager;
    }

    public CacheDataSource buildCacheDataSource(boolean z) {
        InterceptResult invokeZ;
        DataSource fileDataSource;
        DataSink cacheDataSink;
        PriorityDataSource priorityDataSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
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
        return (CacheDataSource) invokeZ.objValue;
    }

    public Cache getCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cache;
        }
        return (Cache) invokeV.objValue;
    }

    public PriorityTaskManager getPriorityTaskManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            if (priorityTaskManager == null) {
                return new PriorityTaskManager();
            }
            return priorityTaskManager;
        }
        return (PriorityTaskManager) invokeV.objValue;
    }
}
