package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public final class w09 extends a19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y09 d;
    public final b19 e;
    public final ByteBuffer f;
    public final UploadDataProvider g;
    public boolean h;
    public boolean i;
    public boolean j;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w09 a;

        public b(w09 w09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w09Var;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void d(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.a.f.remaining()) {
                    byteBuffer.put(this.a.f);
                    this.a.f.clear();
                    uploadDataSink.c(this.a.h);
                    if (!this.a.h) {
                        this.a.e.quit();
                        return;
                    } else if (this.a.i) {
                        this.a.e.quit();
                        return;
                    } else {
                        return;
                    }
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

        public /* synthetic */ b(w09 w09Var, a aVar) {
            this(w09Var);
        }
    }

    public w09(y09 y09Var, int i, b19 b19Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y09Var, Integer.valueOf(i), b19Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new b(this, null);
        this.h = false;
        this.i = false;
        this.j = false;
        if (y09Var == null) {
            throw null;
        }
        if (i > 0) {
            this.f = ByteBuffer.allocate(i);
            this.d = y09Var;
            this.e = b19Var;
            this.i = z;
            this.j = z2;
            return;
        }
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // com.repackage.a19, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.close();
            if (this.h) {
                return;
            }
            this.h = true;
            this.f.flip();
            if (this.i) {
                this.e.b(this.d.getReadTimeout());
            }
        }
    }

    @Override // com.repackage.a19
    public void f() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.j && this.f.position() > 0) {
            r();
        }
    }

    @Override // com.repackage.a19
    public UploadDataProvider g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.g : (UploadDataProvider) invokeV.objValue;
    }

    @Override // com.repackage.a19
    public void j() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void p() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f.hasRemaining()) {
            return;
        }
        r();
    }

    public final void r() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e();
            this.f.flip();
            this.e.b(this.d.getReadTimeout());
            c();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            p();
            this.f.put((byte) i);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i, i2) == null) {
            e();
            if (bArr.length - i < i2 || i < 0 || i2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i3 = i2;
            while (i3 > 0) {
                int min = Math.min(i3, this.f.remaining());
                this.f.put(bArr, (i + i2) - i3, min);
                i3 -= min;
                p();
            }
        }
    }
}
