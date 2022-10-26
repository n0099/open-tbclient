package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ProgressiveDownloader implements Downloader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE_BYTES = 131072;
    public transient /* synthetic */ FieldHolder $fh;
    public final Cache cache;
    public final CacheUtil.CachingCounters cachingCounters;
    public final CacheDataSource dataSource;
    public final DataSpec dataSpec;
    public final PriorityTaskManager priorityTaskManager;

    public ProgressiveDownloader(String str, String str2, DownloaderConstructorHelper downloaderConstructorHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, downloaderConstructorHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dataSpec = new DataSpec(Uri.parse(str), 0L, -1L, str2, 0);
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.buildCacheDataSource(false);
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
        this.cachingCounters = new CacheUtil.CachingCounters();
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void download(Downloader.ProgressListener progressListener) throws InterruptedException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, progressListener) == null) {
            this.priorityTaskManager.add(-1000);
            try {
                CacheUtil.cache(this.dataSpec, this.cache, this.dataSource, new byte[131072], this.priorityTaskManager, -1000, this.cachingCounters, true);
                if (progressListener != null) {
                    progressListener.onDownloadProgress(this, 100.0f, this.cachingCounters.contentLength);
                }
            } finally {
                this.priorityTaskManager.remove(-1000);
            }
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public float getDownloadPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.cachingCounters.contentLength;
            if (j == -1) {
                return Float.NaN;
            }
            return (((float) this.cachingCounters.totalCachedBytes()) * 100.0f) / ((float) j);
        }
        return invokeV.floatValue;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public long getDownloadedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cachingCounters.totalCachedBytes();
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CacheUtil.getCached(this.dataSpec, this.cache, this.cachingCounters);
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CacheUtil.remove(this.cache, CacheUtil.getKey(this.dataSpec));
        }
    }
}
