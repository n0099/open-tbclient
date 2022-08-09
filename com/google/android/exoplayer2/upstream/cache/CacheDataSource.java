package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public final class CacheDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes5.dex */
    public interface EventListener {
        void onCachedBytesRead(long j, long j2);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface Flags {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheDataSource(Cache cache, DataSource dataSource) {
        this(cache, dataSource, 0, 2097152L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {cache, dataSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], (DataSource) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (dataSource = this.currentDataSource) == null) {
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

    private void handleBeforeThrow(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, iOException) == null) {
            if (this.currentDataSource == this.cacheReadDataSource || (iOException instanceof Cache.CacheException)) {
                this.seenCacheError = true;
            }
        }
    }

    private void notifyBytesRead() {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (eventListener = this.eventListener) == null || this.totalCachedBytesRead <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
    }

    private boolean openNextSource(boolean z) throws IOException {
        InterceptResult invokeZ;
        CacheSpan startReadWrite;
        long j;
        DataSpec dataSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, this, z)) == null) {
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
            boolean z2 = true;
            this.currentRequestUnbounded = dataSpec.length == -1;
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
                if (iOException != null) {
                    throw iOException;
                }
                z2 = false;
            }
            if (this.currentRequestUnbounded && j6 != -1) {
                this.bytesRemaining = j6;
                setContentLength(dataSpec.position + j6);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    private void setContentLength(long j) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65544, this, j) == null) && this.currentDataSource == this.cacheWriteDataSource) {
            this.cache.setContentLength(this.key, j);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.uri = null;
            notifyBytesRead();
            try {
                closeCurrentSource();
            } catch (IOException e) {
                handleBeforeThrow(e);
                throw e;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DataSource dataSource = this.currentDataSource;
            return dataSource == this.upstreamDataSource ? dataSource.getUri() : this.uri;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            try {
                this.uri = dataSpec.uri;
                this.flags = dataSpec.flags;
                this.key = CacheUtil.getKey(dataSpec);
                this.readPosition = dataSpec.position;
                boolean z = (this.ignoreCacheOnError && this.seenCacheError) || (dataSpec.length == -1 && this.ignoreCacheForUnsetLengthRequests);
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
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
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
        return invokeLII.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheDataSource(Cache cache, DataSource dataSource, int i) {
        this(cache, dataSource, i, 2097152L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {cache, dataSource, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], (DataSource) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheDataSource(Cache cache, DataSource dataSource, int i, long j) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, j), i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {cache, dataSource, Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], (DataSource) objArr2[1], (DataSource) objArr2[2], (DataSink) objArr2[3], ((Integer) objArr2[4]).intValue(), (EventListener) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, int i, @Nullable EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, dataSource, dataSource2, dataSink, Integer.valueOf(i), eventListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = (i & 1) != 0;
        this.ignoreCacheOnError = (i & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i & 4) != 0;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }
}
