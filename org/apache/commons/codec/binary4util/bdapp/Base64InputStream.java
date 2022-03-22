package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;
@SuppressLint({"BDThrowableCheck"})
@Deprecated
/* loaded from: classes8.dex */
public class Base64InputStream extends FilterInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 2048;
    public static byte[] EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final Base64.Coder coder;
    public boolean eof;
    public byte[] inputBuffer;
    public int outputEnd;
    public int outputStart;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(686750996, "Lorg/apache/commons/codec/binary4util/bdapp/Base64InputStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(686750996, "Lorg/apache/commons/codec/binary4util/bdapp/Base64InputStream;");
                return;
            }
        }
        EMPTY = new byte[0];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64InputStream(InputStream inputStream, int i) {
        this(inputStream, i, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void refill() throws IOException {
        boolean process;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.eof) {
            return;
        }
        int read = ((FilterInputStream) this).in.read(this.inputBuffer);
        if (read == -1) {
            this.eof = true;
            process = this.coder.process(EMPTY, 0, 0, true);
        } else {
            process = this.coder.process(this.inputBuffer, 0, read, false);
        }
        if (process) {
            this.outputEnd = this.coder.op;
            this.outputStart = 0;
            return;
        }
        throw new IOException("bad base-64");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.outputEnd - this.outputStart : invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((FilterInputStream) this).in.close();
            this.inputBuffer = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.outputStart >= this.outputEnd) {
                refill();
            }
            int i = this.outputStart;
            if (i >= this.outputEnd) {
                return -1;
            }
            byte[] bArr = this.coder.output;
            this.outputStart = i + 1;
            return bArr[i] & 255;
        }
        return invokeV.intValue;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (this.outputStart >= this.outputEnd) {
                refill();
            }
            int i = this.outputStart;
            int i2 = this.outputEnd;
            if (i >= i2) {
                return 0L;
            }
            long min = Math.min(j, i2 - i);
            this.outputStart = (int) (this.outputStart + min);
            return min;
        }
        return invokeJ.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Base64InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((InputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.eof = false;
        this.inputBuffer = new byte[2048];
        if (z) {
            this.coder = new Base64.Encoder(i, null);
        } else {
            this.coder = new Base64.Decoder(i, null);
        }
        Base64.Coder coder = this.coder;
        coder.output = new byte[coder.maxOutputSize(2048)];
        this.outputStart = 0;
        this.outputEnd = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            if (this.outputStart >= this.outputEnd) {
                refill();
            }
            int i3 = this.outputStart;
            int i4 = this.outputEnd;
            if (i3 >= i4) {
                return -1;
            }
            int min = Math.min(i2, i4 - i3);
            System.arraycopy(this.coder.output, this.outputStart, bArr, i, min);
            this.outputStart += min;
            return min;
        }
        return invokeLII.intValue;
    }
}
