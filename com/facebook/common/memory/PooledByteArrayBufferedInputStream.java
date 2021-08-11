package com.facebook.common.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes9.dex */
public class PooledByteArrayBufferedInputStream extends InputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PooledByteInputStream";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBufferOffset;
    public int mBufferedSize;
    public final byte[] mByteArray;
    public boolean mClosed;
    public final InputStream mInputStream;
    public final ResourceReleaser<byte[]> mResourceReleaser;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bArr, resourceReleaser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputStream = (InputStream) Preconditions.checkNotNull(inputStream);
        this.mByteArray = (byte[]) Preconditions.checkNotNull(bArr);
        this.mResourceReleaser = (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser);
        this.mBufferedSize = 0;
        this.mBufferOffset = 0;
        this.mClosed = false;
    }

    private boolean ensureDataInBuffer() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mBufferOffset < this.mBufferedSize) {
                return true;
            }
            int read = this.mInputStream.read(this.mByteArray);
            if (read <= 0) {
                return false;
            }
            this.mBufferedSize = read;
            this.mBufferOffset = 0;
            return true;
        }
        return invokeV.booleanValue;
    }

    private void ensureNotClosed() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
            ensureNotClosed();
            return (this.mBufferedSize - this.mBufferOffset) + this.mInputStream.available();
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mResourceReleaser.release(this.mByteArray);
        super.close();
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.mClosed) {
                FLog.e(TAG, "Finalized without closing");
                close();
            }
            super.finalize();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
            ensureNotClosed();
            if (ensureDataInBuffer()) {
                byte[] bArr = this.mByteArray;
                int i2 = this.mBufferOffset;
                this.mBufferOffset = i2 + 1;
                return bArr[i2] & 255;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
            ensureNotClosed();
            int i2 = this.mBufferedSize;
            int i3 = this.mBufferOffset;
            long j3 = i2 - i3;
            if (j3 >= j2) {
                this.mBufferOffset = (int) (i3 + j2);
                return j2;
            }
            this.mBufferOffset = i2;
            return j3 + this.mInputStream.skip(j2 - j3);
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            Preconditions.checkState(this.mBufferOffset <= this.mBufferedSize);
            ensureNotClosed();
            if (ensureDataInBuffer()) {
                int min = Math.min(this.mBufferedSize - this.mBufferOffset, i3);
                System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i2, min);
                this.mBufferOffset += min;
                return min;
            }
            return -1;
        }
        return invokeLII.intValue;
    }
}
