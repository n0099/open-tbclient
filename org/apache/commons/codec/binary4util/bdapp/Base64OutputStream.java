package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;
@SuppressLint({"BDThrowableCheck"})
@Deprecated
/* loaded from: classes8.dex */
public class Base64OutputStream extends FilterOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public static byte[] EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public int bpos;
    public byte[] buffer;
    public final Base64.Coder coder;
    public final int flags;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2059536727, "Lorg/apache/commons/codec/binary4util/bdapp/Base64OutputStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2059536727, "Lorg/apache/commons/codec/binary4util/bdapp/Base64OutputStream;");
                return;
            }
        }
        EMPTY = new byte[0];
    }

    private void flushBuffer() throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (i = this.bpos) > 0) {
            internalWrite(this.buffer, 0, i, false);
            this.bpos = 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Base64OutputStream(OutputStream outputStream, int i) {
        this(outputStream, i, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OutputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Base64OutputStream(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((OutputStream) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.buffer = null;
        this.bpos = 0;
        this.flags = i;
        if (z) {
            this.coder = new Base64.Encoder(i, null);
        } else {
            this.coder = new Base64.Decoder(i, null);
        }
    }

    private byte[] embiggen(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, bArr, i)) == null) {
            if (bArr != null && bArr.length >= i) {
                return bArr;
            }
            return new byte[i];
        }
        return (byte[]) invokeLI.objValue;
    }

    private void internalWrite(byte[] bArr, int i, int i2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Base64.Coder coder = this.coder;
            coder.output = embiggen(coder.output, coder.maxOutputSize(i2));
            if (this.coder.process(bArr, i, i2, z)) {
                OutputStream outputStream = ((FilterOutputStream) this).out;
                Base64.Coder coder2 = this.coder;
                outputStream.write(coder2.output, 0, coder2.op);
                return;
            }
            throw new IOException("bad base-64");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                flushBuffer();
                internalWrite(EMPTY, 0, 0, true);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            try {
                if ((this.flags & 16) == 0) {
                    ((FilterOutputStream) this).out.close();
                } else {
                    ((FilterOutputStream) this).out.flush();
                }
            } catch (IOException e2) {
                if (e != null) {
                    e = e2;
                }
            }
            if (e == null) {
                return;
            }
            throw e;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.buffer == null) {
                this.buffer = new byte[1024];
            }
            int i2 = this.bpos;
            byte[] bArr = this.buffer;
            if (i2 >= bArr.length) {
                internalWrite(bArr, 0, i2, false);
                this.bpos = 0;
            }
            byte[] bArr2 = this.buffer;
            int i3 = this.bpos;
            this.bpos = i3 + 1;
            bArr2[i3] = (byte) i;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i, i2) != null) || i2 <= 0) {
            return;
        }
        flushBuffer();
        internalWrite(bArr, i, i2, false);
    }
}
