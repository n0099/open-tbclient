package d.f.d.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes8.dex */
public abstract class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f70924a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70924a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // d.f.d.d.f, d.f.d.d.j
    public /* bridge */ /* synthetic */ j a(int i2) {
        a(i2);
        return this;
    }

    @Override // d.f.d.d.f, d.f.d.d.j
    public /* bridge */ /* synthetic */ j b(long j) {
        b(j);
        return this;
    }

    @Override // d.f.d.d.c, d.f.d.d.j
    public /* bridge */ /* synthetic */ j f(byte[] bArr) {
        j(bArr);
        return this;
    }

    @Override // d.f.d.d.c, d.f.d.d.f
    public f h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            n.v(i2, i2 + i3, bArr.length);
            p(bArr, i2, i3);
            return this;
        }
        return (f) invokeLII.objValue;
    }

    @Override // d.f.d.d.f
    public f i(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteBuffer)) == null) {
            n(byteBuffer);
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // d.f.d.d.c
    public f j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            n.p(bArr);
            o(bArr);
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // d.f.d.d.c
    public f k(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.f70924a.putChar(c2);
            l(2);
            return this;
        }
        return (f) invokeCommon.objValue;
    }

    public final f l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            try {
                p(this.f70924a.array(), 0, i2);
                return this;
            } finally {
                this.f70924a.clear();
            }
        }
        return (f) invokeI.objValue;
    }

    public abstract void m(byte b2);

    public void n(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            if (byteBuffer.hasArray()) {
                p(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                m(byteBuffer.get());
            }
        }
    }

    public void o(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bArr) == null) {
            p(bArr, 0, bArr.length);
        }
    }

    public abstract void p(byte[] bArr, int i2, int i3);

    @Override // d.f.d.d.f, d.f.d.d.j
    public f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f70924a.putInt(i2);
            l(4);
            return this;
        }
        return (f) invokeI.objValue;
    }

    @Override // d.f.d.d.f, d.f.d.d.j
    public f b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.f70924a.putLong(j);
            l(8);
            return this;
        }
        return (f) invokeJ.objValue;
    }
}
