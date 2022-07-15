package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class x09 extends a19 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int i = 16384;
    public transient /* synthetic */ FieldHolder $fh;
    public final b19 d;
    public final long e;
    public final ByteBuffer f;
    public final UploadDataProvider g;
    public long h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x09 a;

        public b(x09 x09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x09Var;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.e : invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void d(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.a.f.remaining()) {
                    byteBuffer.put(this.a.f);
                    this.a.f.clear();
                    uploadDataSink.c(false);
                    this.a.d.quit();
                    return;
                }
                int limit = this.a.f.limit();
                this.a.f.limit(this.a.f.position() + byteBuffer.remaining());
                byteBuffer.put(this.a.f);
                this.a.f.limit(limit);
                uploadDataSink.c(false);
            }
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void e(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
            }
        }

        public /* synthetic */ b(x09 x09Var, a aVar) {
            this(x09Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755225264, "Lcom/repackage/x09;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755225264, "Lcom/repackage/x09;");
        }
    }

    public x09(y09 y09Var, long j, b19 b19Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y09Var, Long.valueOf(j), b19Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new b(this, null);
        if (y09Var == null) {
            throw null;
        }
        if (j >= 0) {
            this.e = j;
            this.f = ByteBuffer.allocate((int) Math.min(j, i));
            this.d = b19Var;
            this.h = 0L;
            return;
        }
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    @Override // com.repackage.a19
    public void f() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h < this.e) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // com.repackage.a19
    public UploadDataProvider g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (UploadDataProvider) invokeV.objValue;
    }

    @Override // com.repackage.a19
    public void j() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void o(int i2) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.h + i2 <= this.e) {
            return;
        }
        throw new ProtocolException("expected " + (this.e - this.h) + " bytes but received " + i2);
    }

    public final void p() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f.hasRemaining()) {
            return;
        }
        r();
    }

    public final void r() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e();
            this.f.flip();
            this.d.a();
            c();
        }
    }

    public final void s() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.h == this.e) {
            r();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            e();
            o(1);
            p();
            this.f.put((byte) i2);
            this.h++;
            s();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            e();
            if (bArr.length - i2 >= i3 && i2 >= 0 && i3 >= 0) {
                o(i3);
                int i4 = i3;
                while (i4 > 0) {
                    p();
                    int min = Math.min(i4, this.f.remaining());
                    this.f.put(bArr, (i2 + i3) - i4, min);
                    i4 -= min;
                }
                this.h += i3;
                s();
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
