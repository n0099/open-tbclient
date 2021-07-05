package d.a.t0.b.e;

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
/* loaded from: classes9.dex */
public final class c extends f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int m = 16384;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final g f70508h;

    /* renamed from: i  reason: collision with root package name */
    public final long f70509i;
    public final ByteBuffer j;
    public final UploadDataProvider k;
    public long l;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends UploadDataProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f70510e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70510e = cVar;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70510e.f70509i : invokeV.longValue;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void h(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadDataSink, byteBuffer) == null) {
                if (byteBuffer.remaining() >= this.f70510e.j.remaining()) {
                    byteBuffer.put(this.f70510e.j);
                    this.f70510e.j.clear();
                    uploadDataSink.c(false);
                    this.f70510e.f70508h.quit();
                    return;
                }
                int limit = this.f70510e.j.limit();
                this.f70510e.j.limit(this.f70510e.j.position() + byteBuffer.remaining());
                byteBuffer.put(this.f70510e.j);
                this.f70510e.j.limit(limit);
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

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-263799619, "Ld/a/t0/b/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-263799619, "Ld/a/t0/b/e/c;");
        }
    }

    public c(d dVar, long j, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Long.valueOf(j), gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new b(this, null);
        if (dVar == null) {
            throw null;
        }
        if (j >= 0) {
            this.f70509i = j;
            this.j = ByteBuffer.allocate((int) Math.min(j, m));
            this.f70508h = gVar;
            this.l = 0L;
            return;
        }
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    public final void A() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.l == this.f70509i) {
            z();
        }
    }

    @Override // d.a.t0.b.e.f
    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.l < this.f70509i) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // d.a.t0.b.e.f
    public UploadDataProvider r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (UploadDataProvider) invokeV.objValue;
    }

    @Override // d.a.t0.b.e.f
    public void s() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            n();
            x(1);
            y();
            this.j.put((byte) i2);
            this.l++;
            A();
        }
    }

    public final void x(int i2) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.l + i2 <= this.f70509i) {
            return;
        }
        throw new ProtocolException("expected " + (this.f70509i - this.l) + " bytes but received " + i2);
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
            this.f70508h.a();
            g();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            n();
            if (bArr.length - i2 >= i3 && i2 >= 0 && i3 >= 0) {
                x(i3);
                int i4 = i3;
                while (i4 > 0) {
                    y();
                    int min = Math.min(i4, this.j.remaining());
                    this.j.put(bArr, (i2 + i3) - i4, min);
                    i4 -= min;
                }
                this.l += i3;
                A();
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
