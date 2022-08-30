package com.google.android.exoplayer2.upstream.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public final class CacheDataSink implements DataSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bufferSize;
    public ReusableBufferedOutputStream bufferedOutputStream;
    public final Cache cache;
    public DataSpec dataSpec;
    public long dataSpecBytesWritten;
    public File file;
    public final long maxCacheFileSize;
    public OutputStream outputStream;
    public long outputStreamBytesWritten;
    public FileOutputStream underlyingFileOutputStream;

    /* loaded from: classes7.dex */
    public static class CacheDataSinkException extends Cache.CacheException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iOException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheDataSink(Cache cache, long j) {
        this(cache, j, 20480);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Cache) objArr2[0], ((Long) objArr2[1]).longValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void closeCurrentOutputStream() throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (outputStream = this.outputStream) == null) {
            return;
        }
        try {
            outputStream.flush();
            this.underlyingFileOutputStream.getFD().sync();
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file = this.file;
            this.file = null;
            this.cache.commitFile(file);
        } catch (Throwable th) {
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file2 = this.file;
            this.file = null;
            file2.delete();
            throw th;
        }
    }

    private void openNextOutputStream() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            long j = this.dataSpec.length;
            long min = j == -1 ? this.maxCacheFileSize : Math.min(j - this.dataSpecBytesWritten, this.maxCacheFileSize);
            Cache cache = this.cache;
            DataSpec dataSpec = this.dataSpec;
            this.file = cache.startFile(dataSpec.key, this.dataSpecBytesWritten + dataSpec.absoluteStreamPosition, min);
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            this.underlyingFileOutputStream = fileOutputStream;
            if (this.bufferSize > 0) {
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.bufferedOutputStream;
                if (reusableBufferedOutputStream == null) {
                    this.bufferedOutputStream = new ReusableBufferedOutputStream(this.underlyingFileOutputStream, this.bufferSize);
                } else {
                    reusableBufferedOutputStream.reset(fileOutputStream);
                }
                this.outputStream = this.bufferedOutputStream;
            } else {
                this.outputStream = fileOutputStream;
            }
            this.outputStreamBytesWritten = 0L;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws CacheDataSinkException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.dataSpec == null) {
            return;
        }
        try {
            closeCurrentOutputStream();
        } catch (IOException e) {
            throw new CacheDataSinkException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(DataSpec dataSpec) throws CacheDataSinkException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSpec) == null) {
            if (dataSpec.length == -1 && !dataSpec.isFlagSet(2)) {
                this.dataSpec = null;
                return;
            }
            this.dataSpec = dataSpec;
            this.dataSpecBytesWritten = 0L;
            try {
                openNextOutputStream();
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i, int i2) throws CacheDataSinkException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) == null) || this.dataSpec == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                    closeCurrentOutputStream();
                    openNextOutputStream();
                }
                int min = (int) Math.min(i2 - i3, this.maxCacheFileSize - this.outputStreamBytesWritten);
                this.outputStream.write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.outputStreamBytesWritten += j;
                this.dataSpecBytesWritten += j;
            } catch (IOException e) {
                throw new CacheDataSinkException(e);
            }
        }
    }

    public CacheDataSink(Cache cache, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cache, Long.valueOf(j), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cache = (Cache) Assertions.checkNotNull(cache);
        this.maxCacheFileSize = j;
        this.bufferSize = i;
    }
}
