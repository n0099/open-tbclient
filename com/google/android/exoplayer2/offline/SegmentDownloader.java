package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.offline.Downloader;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class SegmentDownloader implements Downloader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE_BYTES = 131072;
    public transient /* synthetic */ FieldHolder $fh;
    public final Cache cache;
    public final CacheDataSource dataSource;
    public volatile long downloadedBytes;
    public volatile int downloadedSegments;
    public Object[] keys;
    public Object manifest;
    public final Uri manifestUri;
    public final CacheDataSource offlineDataSource;
    public final PriorityTaskManager priorityTaskManager;
    public volatile int totalSegments;

    public abstract List getAllSegments(DataSource dataSource, Object obj, boolean z) throws InterruptedException, IOException;

    public abstract Object getManifest(DataSource dataSource, Uri uri) throws IOException;

    public abstract List getSegments(DataSource dataSource, Object obj, Object[] objArr, boolean z) throws InterruptedException, IOException;

    /* loaded from: classes7.dex */
    public class Segment implements Comparable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), dataSpec};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(Segment segment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, segment)) == null) {
                int i = ((this.startTimeUs - segment.startTimeUs) > 0L ? 1 : ((this.startTimeUs - segment.startTimeUs) == 0L ? 0 : -1));
                if (i == 0) {
                    return 0;
                }
                if (i < 0) {
                    return -1;
                }
                return 1;
            }
            return invokeL.intValue;
        }
    }

    public SegmentDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, downloaderConstructorHelper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.manifestUri = uri;
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.buildCacheDataSource(false);
        this.offlineDataSource = downloaderConstructorHelper.buildCacheDataSource(true);
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
        resetCounters();
    }

    private DataSource getDataSource(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) {
            if (z) {
                return this.offlineDataSource;
            }
            return this.dataSource;
        }
        return (DataSource) invokeZ.objValue;
    }

    private Object getManifestIfNeeded(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, this, z)) == null) {
            if (this.manifest == null) {
                this.manifest = getManifest(getDataSource(z), this.manifestUri);
            }
            return this.manifest;
        }
        return invokeZ.objValue;
    }

    private void notifyListener(Downloader.ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, progressListener) == null) && progressListener != null) {
            progressListener.onDownloadProgress(this, getDownloadPercentage(), this.downloadedBytes);
        }
    }

    private void remove(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, uri) == null) {
            CacheUtil.remove(this.cache, CacheUtil.generateKey(uri));
        }
    }

    public final void selectRepresentations(Object[] objArr) {
        Object[] objArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, objArr) == null) {
            if (objArr != null) {
                objArr2 = (Object[]) objArr.clone();
            } else {
                objArr2 = null;
            }
            this.keys = objArr2;
            resetCounters();
        }
    }

    private synchronized List initStatus(boolean z) throws IOException, InterruptedException {
        InterceptResult invokeZ;
        List allSegments;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, this, z)) == null) {
            synchronized (this) {
                DataSource dataSource = getDataSource(z);
                if (this.keys != null && this.keys.length > 0) {
                    allSegments = getSegments(dataSource, this.manifest, this.keys, z);
                } else {
                    allSegments = getAllSegments(dataSource, this.manifest, z);
                }
                CacheUtil.CachingCounters cachingCounters = new CacheUtil.CachingCounters();
                this.totalSegments = allSegments.size();
                this.downloadedSegments = 0;
                this.downloadedBytes = 0L;
                for (int size = allSegments.size() - 1; size >= 0; size--) {
                    CacheUtil.getCached(((Segment) allSegments.get(size)).dataSpec, this.cache, cachingCounters);
                    this.downloadedBytes += cachingCounters.alreadyCachedBytes;
                    if (cachingCounters.alreadyCachedBytes == cachingCounters.contentLength) {
                        this.downloadedSegments++;
                        allSegments.remove(size);
                    }
                }
            }
            return allSegments;
        }
        return (List) invokeZ.objValue;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final synchronized void download(Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, progressListener) == null) {
            synchronized (this) {
                this.priorityTaskManager.add(-1000);
                getManifestIfNeeded(false);
                List initStatus = initStatus(false);
                notifyListener(progressListener);
                Collections.sort(initStatus);
                byte[] bArr = new byte[131072];
                CacheUtil.CachingCounters cachingCounters = new CacheUtil.CachingCounters();
                for (int i = 0; i < initStatus.size(); i++) {
                    CacheUtil.cache(((Segment) initStatus.get(i)).dataSpec, this.cache, this.dataSource, bArr, this.priorityTaskManager, -1000, cachingCounters, true);
                    this.downloadedBytes += cachingCounters.newlyCachedBytes;
                    this.downloadedSegments++;
                    notifyListener(progressListener);
                }
                this.priorityTaskManager.remove(-1000);
            }
        }
    }

    private void resetCounters() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.totalSegments = -1;
            this.downloadedSegments = -1;
            this.downloadedBytes = -1L;
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public float getDownloadPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.totalSegments;
            int i2 = this.downloadedSegments;
            if (i != -1 && i2 != -1) {
                if (i == 0) {
                    return 100.0f;
                }
                return (i2 * 100.0f) / i;
            }
            return Float.NaN;
        }
        return invokeV.floatValue;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final long getDownloadedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.downloadedBytes;
        }
        return invokeV.longValue;
    }

    public final int getDownloadedSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.downloadedSegments;
        }
        return invokeV.intValue;
    }

    public final Object getManifest() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getManifestIfNeeded(false);
        }
        return invokeV.objValue;
    }

    public final int getTotalSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.totalSegments;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void init() throws InterruptedException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                getManifestIfNeeded(true);
                try {
                    initStatus(true);
                } catch (IOException | InterruptedException e) {
                    resetCounters();
                    throw e;
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() throws InterruptedException {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                getManifestIfNeeded(true);
            } catch (IOException unused) {
            }
            resetCounters();
            Object obj = this.manifest;
            if (obj != null) {
                try {
                    list = getAllSegments(this.offlineDataSource, obj, true);
                } catch (IOException unused2) {
                    list = null;
                }
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        remove(((Segment) list.get(i)).dataSpec.uri);
                    }
                }
                this.manifest = null;
            }
            remove(this.manifestUri);
        }
    }
}
