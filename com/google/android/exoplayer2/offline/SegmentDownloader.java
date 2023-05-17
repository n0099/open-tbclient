package com.google.android.exoplayer2.offline;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes9.dex */
public abstract class SegmentDownloader<M, K> implements Downloader {
    public static final int BUFFER_SIZE_BYTES = 131072;
    public final Cache cache;
    public final CacheDataSource dataSource;
    public volatile long downloadedBytes;
    public volatile int downloadedSegments;
    public K[] keys;
    public M manifest;
    public final Uri manifestUri;
    public final CacheDataSource offlineDataSource;
    public final PriorityTaskManager priorityTaskManager;
    public volatile int totalSegments;

    public abstract List<Segment> getAllSegments(DataSource dataSource, M m, boolean z) throws InterruptedException, IOException;

    public abstract M getManifest(DataSource dataSource, Uri uri) throws IOException;

    public abstract List<Segment> getSegments(DataSource dataSource, M m, K[] kArr, boolean z) throws InterruptedException, IOException;

    /* loaded from: classes9.dex */
    public static class Segment implements Comparable<Segment> {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long j, DataSpec dataSpec) {
            this.startTimeUs = j;
            this.dataSpec = dataSpec;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull Segment segment) {
            int i = ((this.startTimeUs - segment.startTimeUs) > 0L ? 1 : ((this.startTimeUs - segment.startTimeUs) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            if (i < 0) {
                return -1;
            }
            return 1;
        }
    }

    public SegmentDownloader(Uri uri, DownloaderConstructorHelper downloaderConstructorHelper) {
        this.manifestUri = uri;
        this.cache = downloaderConstructorHelper.getCache();
        this.dataSource = downloaderConstructorHelper.buildCacheDataSource(false);
        this.offlineDataSource = downloaderConstructorHelper.buildCacheDataSource(true);
        this.priorityTaskManager = downloaderConstructorHelper.getPriorityTaskManager();
        resetCounters();
    }

    private DataSource getDataSource(boolean z) {
        if (z) {
            return this.offlineDataSource;
        }
        return this.dataSource;
    }

    private M getManifestIfNeeded(boolean z) throws IOException {
        if (this.manifest == null) {
            this.manifest = getManifest(getDataSource(z), this.manifestUri);
        }
        return this.manifest;
    }

    private void notifyListener(Downloader.ProgressListener progressListener) {
        if (progressListener != null) {
            progressListener.onDownloadProgress(this, getDownloadPercentage(), this.downloadedBytes);
        }
    }

    private void remove(Uri uri) {
        CacheUtil.remove(this.cache, CacheUtil.generateKey(uri));
    }

    public final void selectRepresentations(K[] kArr) {
        K[] kArr2;
        if (kArr != null) {
            kArr2 = (K[]) ((Object[]) kArr.clone());
        } else {
            kArr2 = null;
        }
        this.keys = kArr2;
        resetCounters();
    }

    private synchronized List<Segment> initStatus(boolean z) throws IOException, InterruptedException {
        List<Segment> allSegments;
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
            CacheUtil.getCached(allSegments.get(size).dataSpec, this.cache, cachingCounters);
            this.downloadedBytes += cachingCounters.alreadyCachedBytes;
            if (cachingCounters.alreadyCachedBytes == cachingCounters.contentLength) {
                this.downloadedSegments++;
                allSegments.remove(size);
            }
        }
        return allSegments;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final synchronized void download(@Nullable Downloader.ProgressListener progressListener) throws IOException, InterruptedException {
        this.priorityTaskManager.add(-1000);
        getManifestIfNeeded(false);
        List<Segment> initStatus = initStatus(false);
        notifyListener(progressListener);
        Collections.sort(initStatus);
        byte[] bArr = new byte[131072];
        CacheUtil.CachingCounters cachingCounters = new CacheUtil.CachingCounters();
        for (int i = 0; i < initStatus.size(); i++) {
            CacheUtil.cache(initStatus.get(i).dataSpec, this.cache, this.dataSource, bArr, this.priorityTaskManager, -1000, cachingCounters, true);
            this.downloadedBytes += cachingCounters.newlyCachedBytes;
            this.downloadedSegments++;
            notifyListener(progressListener);
        }
        this.priorityTaskManager.remove(-1000);
    }

    private void resetCounters() {
        this.totalSegments = -1;
        this.downloadedSegments = -1;
        this.downloadedBytes = -1L;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public float getDownloadPercentage() {
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

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final int getDownloadedSegments() {
        return this.downloadedSegments;
    }

    public final M getManifest() throws IOException {
        return getManifestIfNeeded(false);
    }

    public final int getTotalSegments() {
        return this.totalSegments;
    }

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void init() throws InterruptedException, IOException {
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

    @Override // com.google.android.exoplayer2.offline.Downloader
    public final void remove() throws InterruptedException {
        List<Segment> list;
        try {
            getManifestIfNeeded(true);
        } catch (IOException unused) {
        }
        resetCounters();
        M m = this.manifest;
        if (m != null) {
            try {
                list = getAllSegments(this.offlineDataSource, m, true);
            } catch (IOException unused2) {
                list = null;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    remove(list.get(i).dataSpec.uri);
                }
            }
            this.manifest = null;
        }
        remove(this.manifestUri);
    }
}
