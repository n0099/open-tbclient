package org.apache.commons.codec.binary4util;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes9.dex */
public class BaseNCodecOutputStream extends FilterOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseNCodec baseNCodec;
    public final BaseNCodec.Context context;
    public final boolean doEncode;
    public final byte[] singleByte;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z) {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, baseNCodec, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.baseNCodec = baseNCodec;
        this.doEncode = z;
    }

    private void flush(boolean z) throws IOException {
        byte[] bArr;
        int readResults;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, this, z) == null) {
            int available = this.baseNCodec.available(this.context);
            if (available > 0 && (readResults = this.baseNCodec.readResults((bArr = new byte[available]), 0, available, this.context)) > 0) {
                ((FilterOutputStream) this).out.write(bArr, 0, readResults);
            }
            if (z) {
                ((FilterOutputStream) this).out.flush();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            eof();
            flush();
            ((FilterOutputStream) this).out.close();
        }
    }

    public void eof() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.doEncode) {
                this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
            } else {
                this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            byte[] bArr = this.singleByte;
            bArr[0] = (byte) i2;
            write(bArr, 0, 1);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i2, i3) == null) {
            if (bArr == null) {
                throw null;
            }
            if (i2 >= 0 && i3 >= 0) {
                if (i2 > bArr.length || i2 + i3 > bArr.length) {
                    throw new IndexOutOfBoundsException();
                }
                if (i3 > 0) {
                    if (this.doEncode) {
                        this.baseNCodec.encode(bArr, i2, i3, this.context);
                    } else {
                        this.baseNCodec.decode(bArr, i2, i3, this.context);
                    }
                    flush(false);
                    return;
                }
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            flush(true);
        }
    }
}
