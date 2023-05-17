package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes9.dex */
public final class CacheDataSource implements DataSource {
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    public final boolean blockOnCache;
    public long bytesRemaining;
    public final Cache cache;
    public final DataSource cacheReadDataSource;
    public final DataSource cacheWriteDataSource;
    public DataSource currentDataSource;
    public boolean currentRequestIgnoresCache;
    public boolean currentRequestUnbounded;
    @Nullable
    public final EventListener eventListener;
    public int flags;
    public final boolean ignoreCacheForUnsetLengthRequests;
    public final boolean ignoreCacheOnError;
    public String key;
    public CacheSpan lockedSpan;
    public long readPosition;
    public boolean seenCacheError;
    public long totalCachedBytesRead;
    public final DataSource upstreamDataSource;
    public Uri uri;

    /* loaded from: classes9.dex */
    public interface EventListener {
        void onCachedBytesRead(long j, long j2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes9.dex */
    public @interface Flags {
    }

    public CacheDataSource(Cache cache, DataSource dataSource) {
        this(cache, dataSource, 0, 2097152L);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i) {
        this(cache, dataSource, i, 2097152L);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, int i, long j) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, j), i, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, @Nullable EventListener eventListener) {
        boolean z;
        boolean z2;
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.blockOnCache = z;
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.ignoreCacheOnError = z2;
        this.ignoreCacheForUnsetLengthRequests = (i & 4) != 0;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
            this.currentDataSource = null;
            this.currentRequestUnbounded = false;
        } finally {
            CacheSpan cacheSpan = this.lockedSpan;
            if (cacheSpan != null) {
                this.cache.releaseHoleSpan(cacheSpan);
                this.lockedSpan = null;
            }
        }
    }

    private void notifyBytesRead() {
        EventListener eventListener = this.eventListener;
        if (eventListener != null && this.totalCachedBytesRead > 0) {
            eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0L;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        this.uri = null;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == this.upstreamDataSource) {
            return dataSource.getUri();
        }
        return this.uri;
    }

    private void handleBeforeThrow(IOException iOException) {
        if (this.currentDataSource == this.cacheReadDataSource || (iOException instanceof Cache.CacheException)) {
            this.seenCacheError = true;
        }
    }

    private void setContentLength(long j) throws IOException {
        if (this.currentDataSource == this.cacheWriteDataSource) {
            this.cache.setContentLength(this.key, j);
        }
    }

    private boolean openNextSource(boolean z) throws IOException {
        CacheSpan startReadWrite;
        long j;
        DataSpec dataSpec;
        boolean z2;
        IOException iOException = null;
        if (this.currentRequestIgnoresCache) {
            startReadWrite = null;
        } else if (this.blockOnCache) {
            try {
                startReadWrite = this.cache.startReadWrite(this.key, this.readPosition);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            startReadWrite = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
        }
        if (startReadWrite == null) {
            this.currentDataSource = this.upstreamDataSource;
            dataSpec = new DataSpec(this.uri, this.readPosition, this.bytesRemaining, this.key, this.flags);
        } else if (startReadWrite.isCached) {
            Uri fromFile = Uri.fromFile(startReadWrite.file);
            long j2 = this.readPosition - startReadWrite.position;
            long j3 = startReadWrite.length - j2;
            long j4 = this.bytesRemaining;
            if (j4 != -1) {
                j3 = Math.min(j3, j4);
            }
            DataSpec dataSpec2 = new DataSpec(fromFile, this.readPosition, j2, j3, this.key, this.flags);
            this.currentDataSource = this.cacheReadDataSource;
            dataSpec = dataSpec2;
        } else {
            if (startReadWrite.isOpenEnded()) {
                j = this.bytesRemaining;
            } else {
                j = startReadWrite.length;
                long j5 = this.bytesRemaining;
                if (j5 != -1) {
                    j = Math.min(j, j5);
                }
            }
            dataSpec = new DataSpec(this.uri, this.readPosition, j, this.key, this.flags);
            DataSource dataSource = this.cacheWriteDataSource;
            if (dataSource != null) {
                this.currentDataSource = dataSource;
                this.lockedSpan = startReadWrite;
            } else {
                this.currentDataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(startReadWrite);
            }
        }
        boolean z3 = true;
        if (dataSpec.length == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.currentRequestUnbounded = z2;
        long j6 = 0;
        try {
            j6 = this.currentDataSource.open(dataSpec);
        } catch (IOException e) {
            if (!z && this.currentRequestUnbounded) {
                for (Throwable th = e; th != null; th = th.getCause()) {
                    if ((th instanceof DataSourceException) && ((DataSourceException) th).reason == 0) {
                        break;
                    }
                }
            }
            iOException = e;
            if (iOException == null) {
                z3 = false;
            } else {
                throw iOException;
            }
        }
        if (this.currentRequestUnbounded && j6 != -1) {
            this.bytesRemaining = j6;
            setContentLength(dataSpec.position + j6);
        }
        return z3;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        boolean z;
        try {
            this.uri = dataSpec.uri;
            this.flags = dataSpec.flags;
            this.key = CacheUtil.getKey(dataSpec);
            this.readPosition = dataSpec.position;
            if ((this.ignoreCacheOnError && this.seenCacheError) || (dataSpec.length == -1 && this.ignoreCacheForUnsetLengthRequests)) {
                z = true;
            } else {
                z = false;
            }
            this.currentRequestIgnoresCache = z;
            if (dataSpec.length == -1 && !z) {
                long contentLength = this.cache.getContentLength(this.key);
                this.bytesRemaining = contentLength;
                if (contentLength != -1) {
                    long j = contentLength - dataSpec.position;
                    this.bytesRemaining = j;
                    if (j <= 0) {
                        throw new DataSourceException(0);
                    }
                }
                openNextSource(true);
                return this.bytesRemaining;
            }
            this.bytesRemaining = dataSpec.length;
            openNextSource(true);
            return this.bytesRemaining;
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = this.currentDataSource.read(bArr, i, i2);
            if (read >= 0) {
                if (this.currentDataSource == this.cacheReadDataSource) {
                    this.totalCachedBytesRead += read;
                }
                long j = read;
                this.readPosition += j;
                if (this.bytesRemaining != -1) {
                    this.bytesRemaining -= j;
                }
            } else {
                if (this.currentRequestUnbounded) {
                    setContentLength(this.readPosition);
                    this.bytesRemaining = 0L;
                }
                closeCurrentSource();
                if ((this.bytesRemaining > 0 || this.bytesRemaining == -1) && openNextSource(false)) {
                    return read(bArr, i, i2);
                }
            }
            return read;
        } catch (IOException e) {
            handleBeforeThrow(e);
            throw e;
        }
    }
}
