package g.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.brotli.dec.BrotliRuntimeException;
/* loaded from: classes2.dex */
public class b extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f72622e;

    /* renamed from: f  reason: collision with root package name */
    public int f72623f;

    /* renamed from: g  reason: collision with root package name */
    public int f72624g;

    /* renamed from: h  reason: collision with root package name */
    public final j f72625h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), (byte[]) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j.a(this.f72625h);
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f72624g >= this.f72623f) {
                byte[] bArr = this.f72622e;
                int read = read(bArr, 0, bArr.length);
                this.f72623f = read;
                this.f72624g = 0;
                if (read == -1) {
                    return -1;
                }
            }
            byte[] bArr2 = this.f72622e;
            int i2 = this.f72624g;
            this.f72624g = i2 + 1;
            return bArr2[i2] & 255;
        }
        return invokeV.intValue;
    }

    public b(InputStream inputStream, int i2, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j jVar = new j();
        this.f72625h = jVar;
        if (i2 <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i2);
        } else if (inputStream != null) {
            this.f72622e = new byte[i2];
            this.f72623f = 0;
            this.f72624g = 0;
            try {
                j.c(jVar, inputStream);
                if (bArr != null) {
                    d.s(this.f72625h, bArr);
                }
            } catch (BrotliRuntimeException e2) {
                throw new IOException("Brotli decoder initialization failed", e2);
            }
        } else {
            throw new IllegalArgumentException("source is null");
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Bad offset: " + i2);
            } else if (i3 >= 0) {
                int i4 = i2 + i3;
                if (i4 > bArr.length) {
                    throw new IllegalArgumentException("Buffer overflow: " + i4 + " > " + bArr.length);
                } else if (i3 == 0) {
                    return 0;
                } else {
                    int max = Math.max(this.f72623f - this.f72624g, 0);
                    if (max != 0) {
                        max = Math.min(max, i3);
                        System.arraycopy(this.f72622e, this.f72624g, bArr, i2, max);
                        this.f72624g += max;
                        i2 += max;
                        i3 -= max;
                        if (i3 == 0) {
                            return max;
                        }
                    }
                    try {
                        this.f72625h.Z = bArr;
                        this.f72625h.U = i2;
                        this.f72625h.V = i3;
                        this.f72625h.W = 0;
                        d.i(this.f72625h);
                        if (this.f72625h.W == 0) {
                            return -1;
                        }
                        return this.f72625h.W + max;
                    } catch (BrotliRuntimeException e2) {
                        throw new IOException("Brotli stream decoding failed", e2);
                    }
                }
            } else {
                throw new IllegalArgumentException("Bad length: " + i3);
            }
        }
        return invokeLII.intValue;
    }
}
