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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], (DataSource.Factory) objArr2[1], (DataSource.Factory) objArr2[2], (DataSink.Factory) objArr2[3], (PriorityTaskManager) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public CacheDataSource buildCacheDataSource(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataSource.Factory factory = this.cacheReadDataSourceFactory;
            DataSource createDataSource = factory != null ? factory.createDataSource() : new FileDataSource();
            if (z) {
                return new CacheDataSource(this.cache, DummyDataSource.INSTANCE, createDataSource, null, 1, null);
            }
            DataSink.Factory factory2 = this.cacheWriteDataSinkFactory;
            DataSink createDataSink = factory2 != null ? factory2.createDataSink() : new CacheDataSink(this.cache, 2097152L);
            DataSource createDataSource2 = this.upstreamDataSourceFactory.createDataSource();
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            return new CacheDataSource(this.cache, priorityTaskManager == null ? createDataSource2 : new PriorityDataSource(createDataSource2, priorityTaskManager, -1000), createDataSource, createDataSink, 1, null);
        }
        return (CacheDataSource) invokeZ.objValue;
    }

    public Cache getCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cache : (Cache) invokeV.objValue;
    }

    public PriorityTaskManager getPriorityTaskManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PriorityTaskManager priorityTaskManager = this.priorityTaskManager;
            return priorityTaskManager != null ? priorityTaskManager : new PriorityTaskManager();
        }
        return (PriorityTaskManager) invokeV.objValue;
    }

    public DownloaderConstructorHelper(Cache cache, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, factory, factory2, factory3, priorityTaskManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
