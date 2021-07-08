package d.a.c.e.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class a extends OutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f41494e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41495f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f41496g;

    public a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41494e = i2;
        this.f41495f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f41496g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41496g.clear() : (Buffer) invokeV.objValue;
    }

    public synchronized void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                write(13);
                write(10);
            }
        }
    }

    public synchronized void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            synchronized (this) {
                if (i2 > this.f41496g.capacity()) {
                    ByteBuffer byteBuffer = this.f41496g;
                    int position = this.f41496g.position();
                    this.f41496g = ByteBuffer.allocateDirect(((i2 / this.f41495f) + 1) * this.f41495f);
                    byteBuffer.clear();
                    this.f41496g.clear();
                    this.f41496g.put(byteBuffer);
                    this.f41496g.position(position);
                }
            }
        }
    }

    public Buffer r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41496g.flip() : (Buffer) invokeV.objValue;
    }

    public ByteBuffer s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41496g : (ByteBuffer) invokeV.objValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41496g.remaining() : invokeV.intValue;
    }

    public synchronized void u(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                write(str.getBytes("UTF-8"));
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            synchronized (this) {
                if (this.f41496g.position() + 1 > this.f41496g.capacity()) {
                    o(this.f41496g.capacity() + 1);
                }
                this.f41496g.put((byte) i2);
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, bArr, i2, i3) == null) {
            synchronized (this) {
                if (this.f41496g.position() + i3 > this.f41496g.capacity()) {
                    o(this.f41496g.capacity() + i3);
                }
                this.f41496g.put(bArr, i2, i3);
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            synchronized (this) {
                write(bArr, 0, bArr.length);
            }
        }
    }
}
