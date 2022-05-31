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
/* loaded from: classes6.dex */
public final class pz8 extends tz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final rz8 d;
    public final uz8 e;
    public final ByteBuffer f;
    public final UploadDataProvider g;
    public boolean h;
    public boolean i;
    public boolean j;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz8 a;

        public b(pz8 pz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz8Var;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void b(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
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
        public void c(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
            }
        }

        public /* synthetic */ b(pz8 pz8Var, a aVar) {
            this(pz8Var);
        }
    }

    public pz8(rz8 rz8Var, int i, uz8 uz8Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rz8Var, Integer.valueOf(i), uz8Var, Boolean.valueOf(z), Boolean.valueOf(z2)};
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
        if (rz8Var == null) {
            throw null;
        }
        if (i > 0) {
            this.f = ByteBuffer.allocate(i);
            this.d = rz8Var;
            this.e = uz8Var;
            this.i = z;
            this.j = z2;
            return;
        }
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // com.repackage.tz8, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // com.repackage.tz8
    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.repackage.tz8
    public UploadDataProvider f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (UploadDataProvider) invokeV.objValue;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.j && this.f.position() > 0) {
            q();
        }
    }

    @Override // com.repackage.tz8
    public void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void p() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f.hasRemaining()) {
            return;
        }
        q();
    }

    public final void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c();
            this.f.flip();
            this.e.b(this.d.getReadTimeout());
            a();
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
            c();
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
