package d.f.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.hash.HashCode;
import d.f.d.a.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes8.dex */
public abstract class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f71379a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71380b;

    /* renamed from: c  reason: collision with root package name */
    public final int f71381c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(int i2) {
        this(i2, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    @Override // d.f.d.d.f
    public final HashCode e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m();
            this.f71379a.flip();
            if (this.f71379a.remaining() > 0) {
                p(this.f71379a);
                ByteBuffer byteBuffer = this.f71379a;
                byteBuffer.position(byteBuffer.limit());
            }
            return l();
        }
        return (HashCode) invokeV.objValue;
    }

    @Override // d.f.d.d.c, d.f.d.d.f
    public final f h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            q(ByteBuffer.wrap(bArr, i2, i3).order(ByteOrder.LITTLE_ENDIAN));
            return this;
        }
        return (f) invokeLII.objValue;
    }

    @Override // d.f.d.d.f
    public final f i(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, byteBuffer)) == null) {
            ByteOrder order = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                q(byteBuffer);
                return this;
            } finally {
                byteBuffer.order(order);
            }
        }
        return (f) invokeL.objValue;
    }

    @Override // d.f.d.d.c
    public final f k(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2)})) == null) {
            this.f71379a.putChar(c2);
            n();
            return this;
        }
        return (f) invokeCommon.objValue;
    }

    public abstract HashCode l();

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f71379a.flip();
            while (this.f71379a.remaining() >= this.f71381c) {
                o(this.f71379a);
            }
            this.f71379a.compact();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f71379a.remaining() >= 8) {
            return;
        }
        m();
    }

    public abstract void o(ByteBuffer byteBuffer);

    public abstract void p(ByteBuffer byteBuffer);

    public final f q(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, byteBuffer)) == null) {
            if (byteBuffer.remaining() <= this.f71379a.remaining()) {
                this.f71379a.put(byteBuffer);
                n();
                return this;
            }
            int position = this.f71380b - this.f71379a.position();
            for (int i2 = 0; i2 < position; i2++) {
                this.f71379a.put(byteBuffer.get());
            }
            m();
            while (byteBuffer.remaining() >= this.f71381c) {
                o(byteBuffer);
            }
            this.f71379a.put(byteBuffer);
            return this;
        }
        return (f) invokeL.objValue;
    }

    public d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n.d(i3 % i2 == 0);
        this.f71379a = ByteBuffer.allocate(i3 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f71380b = i3;
        this.f71381c = i2;
    }

    @Override // d.f.d.d.f, d.f.d.d.j
    public final f a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.f71379a.putInt(i2);
            n();
            return this;
        }
        return (f) invokeI.objValue;
    }

    @Override // d.f.d.d.f, d.f.d.d.j
    public final f b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.f71379a.putLong(j);
            n();
            return this;
        }
        return (f) invokeJ.objValue;
    }
}
