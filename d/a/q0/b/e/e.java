package d.a.q0.b.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class e extends InputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d f67014e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67015f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f67016g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f67017h;

    public e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67014e = dVar;
    }

    public final void g() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f67015f) {
                IOException iOException = this.f67017h;
                if (iOException != null) {
                    throw iOException;
                }
            } else if (n()) {
            } else {
                if (this.f67016g == null) {
                    this.f67016g = ByteBuffer.allocateDirect(32768);
                }
                this.f67016g.clear();
                this.f67014e.u(this.f67016g);
                IOException iOException2 = this.f67017h;
                if (iOException2 == null) {
                    ByteBuffer byteBuffer = this.f67016g;
                    if (byteBuffer != null) {
                        byteBuffer.flip();
                        return;
                    }
                    return;
                }
                throw iOException2;
            }
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer byteBuffer = this.f67016g;
            return byteBuffer != null && byteBuffer.hasRemaining();
        }
        return invokeV.booleanValue;
    }

    public void o(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iOException) == null) {
            this.f67017h = iOException;
            this.f67015f = true;
            this.f67016g = null;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g();
            if (n()) {
                return this.f67016g.get() & 255;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            g();
            if (n()) {
                int min = Math.min(this.f67016g.limit() - this.f67016g.position(), i3);
                this.f67016g.get(bArr, i2, min);
                return min;
            }
            return -1;
        }
        return invokeLII.intValue;
    }
}
