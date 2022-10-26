package com.facebook.common.streams;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class LimitedInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBytesToRead;
    public int mBytesToReadWhenMarked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedInputStream(InputStream inputStream, int i) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (inputStream != null) {
            if (i >= 0) {
                this.mBytesToRead = i;
                this.mBytesToReadWhenMarked = -1;
                return;
            }
            throw new IllegalArgumentException("limit must be >= 0");
        }
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Math.min(((FilterInputStream) this).in.available(), this.mBytesToRead);
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mBytesToRead == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.mBytesToRead--;
            }
            return read;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && ((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.mark(i);
            this.mBytesToReadWhenMarked = this.mBytesToRead;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j, this.mBytesToRead));
            this.mBytesToRead = (int) (this.mBytesToRead - skip);
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            int i3 = this.mBytesToRead;
            if (i3 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i, Math.min(i2, i3));
            if (read > 0) {
                this.mBytesToRead -= read;
            }
            return read;
        }
        return invokeLII.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.mBytesToReadWhenMarked != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.mBytesToRead = this.mBytesToReadWhenMarked;
                    return;
                }
                throw new IOException("mark not set");
            }
            throw new IOException("mark is not supported");
        }
    }
}
