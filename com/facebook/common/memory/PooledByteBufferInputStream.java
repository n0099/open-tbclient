package com.facebook.common.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes7.dex */
public class PooledByteBufferInputStream extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    public int mMark;
    @VisibleForTesting
    public int mOffset;
    @VisibleForTesting
    public final PooledByteBuffer mPooledByteBuffer;

    @Override // java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pooledByteBuffer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(!pooledByteBuffer.isClosed());
        this.mPooledByteBuffer = (PooledByteBuffer) Preconditions.checkNotNull(pooledByteBuffer);
        this.mOffset = 0;
        this.mMark = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mPooledByteBuffer.size() - this.mOffset;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (available() <= 0) {
                return -1;
            }
            PooledByteBuffer pooledByteBuffer = this.mPooledByteBuffer;
            int i = this.mOffset;
            this.mOffset = i + 1;
            return pooledByteBuffer.read(i) & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mOffset = this.mMark;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mMark = this.mOffset;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            return read(bArr, 0, bArr.length);
        }
        return invokeL.intValue;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            int min = Math.min((int) j, available());
            this.mOffset += min;
            return min;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
                int available = available();
                if (available <= 0) {
                    return -1;
                }
                if (i2 <= 0) {
                    return 0;
                }
                int min = Math.min(available, i2);
                this.mPooledByteBuffer.read(this.mOffset, bArr, i, min);
                this.mOffset += min;
                return min;
            }
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
        }
        return invokeLII.intValue;
    }
}
