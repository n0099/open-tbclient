package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes3.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseNCodec baseNCodec;
    public final BaseNCodec.Context context;
    public final boolean doEncode;
    public final byte[] singleByte;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, baseNCodec, Boolean.valueOf(z)};
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
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.context.eof ? 1 : 0 : invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            synchronized (this) {
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int read = read(this.singleByte, 0, 1);
            while (read == 0) {
                read = read(this.singleByte, 0, 1);
            }
            if (read > 0) {
                byte b2 = this.singleByte[0];
                return b2 < 0 ? b2 + 256 : b2;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                throw new IOException("mark/reset not supported");
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("Negative skip length: " + j2);
            }
            byte[] bArr = new byte[512];
            long j3 = j2;
            while (j3 > 0 && (read = read(bArr, 0, (int) Math.min(512, j3))) != -1) {
                j3 -= read;
            }
            return j2 - j3;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (bArr != null) {
                if (i2 >= 0 && i3 >= 0) {
                    if (i2 > bArr.length || i2 + i3 > bArr.length) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (i3 == 0) {
                        return 0;
                    }
                    int i4 = 0;
                    while (i4 == 0) {
                        if (!this.baseNCodec.hasData(this.context)) {
                            byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                            int read = ((FilterInputStream) this).in.read(bArr2);
                            if (this.doEncode) {
                                this.baseNCodec.encode(bArr2, 0, read, this.context);
                            } else {
                                this.baseNCodec.decode(bArr2, 0, read, this.context);
                            }
                        }
                        i4 = this.baseNCodec.readResults(bArr, i2, i3, this.context);
                    }
                    return i4;
                }
                throw new IndexOutOfBoundsException();
            }
            throw null;
        }
        return invokeLII.intValue;
    }
}
