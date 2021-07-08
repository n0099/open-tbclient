package com.facebook.common.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class PooledByteStreams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TEMP_BUF_SIZE = 16384;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteArrayPool mByteArrayPool;
    public final int mTempBufSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 16384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteArrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ByteArrayPool) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, inputStream, outputStream)) != null) {
            return invokeLL.longValue;
        }
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.mTempBufSize);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.mByteArrayPool.release(bArr);
            }
        }
    }

    @VisibleForTesting
    public PooledByteStreams(ByteArrayPool byteArrayPool, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteArrayPool, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        this.mTempBufSize = i2;
        this.mByteArrayPool = byteArrayPool;
    }

    public long copy(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{inputStream, outputStream, Long.valueOf(j)})) == null) {
            long j2 = 0;
            Preconditions.checkState(j > 0);
            byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
            while (j2 < j) {
                try {
                    int read = inputStream.read(bArr, 0, (int) Math.min(this.mTempBufSize, j - j2));
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    j2 += read;
                } finally {
                    this.mByteArrayPool.release(bArr);
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }
}
