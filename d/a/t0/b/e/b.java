package d.a.t0.b.e;

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
/* loaded from: classes9.dex */
public final class b extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final d f70505h;

    /* renamed from: i  reason: collision with root package name */
    public final g f70506i;
    public final ByteBuffer j;
    public final UploadDataProvider k;
    public boolean l;
    public boolean m;
    public boolean n;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.t0.b.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1950b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f70507e;

        public C1950b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70507e = bVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return -1L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void h(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.f70507e.j.remaining()) {
                    byteBuffer.put(this.f70507e.j);
                    this.f70507e.j.clear();
                    uploadDataSink.c(this.f70507e.l);
                    if (!this.f70507e.l) {
                        this.f70507e.f70506i.quit();
                        return;
                    } else if (this.f70507e.m) {
                        this.f70507e.f70506i.quit();
                        return;
                    } else {
                        return;
                    }
                }
                int limit = this.f70507e.j.limit();
                this.f70507e.j.limit(this.f70507e.j.position() + byteBuffer.remaining());
                byteBuffer.put(this.f70507e.j);
                this.f70507e.j.limit(limit);
                uploadDataSink.c(false);
            }
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void i(UploadDataSink uploadDataSink) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uploadDataSink) == null) {
                uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
            }
        }

        public /* synthetic */ C1950b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(d dVar, int i2, g gVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i2), gVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new C1950b(this, null);
        this.l = false;
        this.m = false;
        this.n = false;
        if (dVar == null) {
            throw null;
        }
        if (i2 > 0) {
            this.j = ByteBuffer.allocate(i2);
            this.f70505h = dVar;
            this.f70506i = gVar;
            this.m = z;
            this.n = z2;
            return;
        }
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // d.a.t0.b.e.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.close();
            if (this.l) {
                return;
            }
            this.l = true;
            this.j.flip();
            if (this.m) {
                this.f70506i.b(this.f70505h.getReadTimeout());
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.n && this.j.position() > 0) {
            z();
        }
    }

    @Override // d.a.t0.b.e.f
    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // d.a.t0.b.e.f
    public UploadDataProvider r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (UploadDataProvider) invokeV.objValue;
    }

    @Override // d.a.t0.b.e.f
    public void s() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            y();
            this.j.put((byte) i2);
        }
    }

    public final void y() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.j.hasRemaining()) {
            return;
        }
        z();
    }

    public final void z() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n();
            this.j.flip();
            this.f70506i.b(this.f70505h.getReadTimeout());
            g();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            n();
            if (bArr.length - i2 < i3 || i2 < 0 || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            int i4 = i3;
            while (i4 > 0) {
                int min = Math.min(i4, this.j.remaining());
                this.j.put(bArr, (i2 + i3) - i4, min);
                i4 -= min;
                y();
            }
        }
    }
}
