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
/* loaded from: classes12.dex */
public class TailAppendingInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMarkedTailOffset;
    public final byte[] mTail;
    public int mTailOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailAppendingInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bArr};
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
        if (inputStream == null) {
            throw null;
        }
        if (bArr != null) {
            this.mTail = bArr;
            return;
        }
        throw null;
    }

    private int readNextTailByte() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int i2 = this.mTailOffset;
            byte[] bArr = this.mTail;
            if (i2 >= bArr.length) {
                return -1;
            }
            this.mTailOffset = i2 + 1;
            return bArr[i2] & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && ((FilterInputStream) this).in.markSupported()) {
            super.mark(i2);
            this.mMarkedTailOffset = this.mTailOffset;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int read = ((FilterInputStream) this).in.read();
            return read != -1 ? read : readNextTailByte();
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (((FilterInputStream) this).in.markSupported()) {
                ((FilterInputStream) this).in.reset();
                this.mTailOffset = this.mMarkedTailOffset;
                return;
            }
            throw new IOException("mark is not supported");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) ? read(bArr, 0, bArr.length) : invokeL.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i2, i3)) == null) {
            int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
            if (read != -1) {
                return read;
            }
            int i4 = 0;
            if (i3 == 0) {
                return 0;
            }
            while (i4 < i3) {
                int readNextTailByte = readNextTailByte();
                if (readNextTailByte == -1) {
                    break;
                }
                bArr[i2 + i4] = (byte) readNextTailByte;
                i4++;
            }
            if (i4 > 0) {
                return i4;
            }
            return -1;
        }
        return invokeLII.intValue;
    }
}
