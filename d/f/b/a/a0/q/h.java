package d.f.b.a.a0.q;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final UUID f72293a;

        public a(UUID uuid, int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uuid, Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72293a = uuid;
        }
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, uuid, bArr)) == null) ? b(uuid, null, bArr) : (byte[]) invokeLL.objValue;
    }

    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, uuid, uuidArr, bArr)) == null) {
            boolean z = uuidArr != null;
            int length = bArr != null ? bArr.length : 0;
            int i2 = length + 32;
            if (z) {
                i2 += (uuidArr.length * 16) + 4;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.putInt(i2);
            allocate.putInt(d.f.b.a.a0.q.a.V);
            allocate.putInt(z ? 16777216 : 0);
            allocate.putLong(uuid.getMostSignificantBits());
            allocate.putLong(uuid.getLeastSignificantBits());
            if (z) {
                allocate.putInt(uuidArr.length);
                for (UUID uuid2 : uuidArr) {
                    allocate.putLong(uuid2.getMostSignificantBits());
                    allocate.putLong(uuid2.getLeastSignificantBits());
                }
            }
            if (length != 0) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            return allocate.array();
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static a c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            d.f.b.a.i0.l lVar = new d.f.b.a.i0.l(bArr);
            if (lVar.d() < 32) {
                return null;
            }
            lVar.J(0);
            if (lVar.i() == lVar.a() + 4 && lVar.i() == d.f.b.a.a0.q.a.V) {
                int c2 = d.f.b.a.a0.q.a.c(lVar.i());
                if (c2 > 1) {
                    Log.w("PsshAtomUtil", "Unsupported pssh version: " + c2);
                    return null;
                }
                UUID uuid = new UUID(lVar.q(), lVar.q());
                if (c2 == 1) {
                    lVar.K(lVar.B() * 16);
                }
                int B = lVar.B();
                if (B != lVar.a()) {
                    return null;
                }
                byte[] bArr2 = new byte[B];
                lVar.g(bArr2, 0, B);
                return new a(uuid, c2, bArr2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static UUID d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            a c2 = c(bArr);
            if (c2 == null) {
                return null;
            }
            return c2.f72293a;
        }
        return (UUID) invokeL.objValue;
    }
}
