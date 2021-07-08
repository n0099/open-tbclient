package d.a.n0.c.a.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f49098a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f49099b;

    /* renamed from: c  reason: collision with root package name */
    public byte f49100c;

    /* renamed from: d  reason: collision with root package name */
    public byte f49101d;

    /* renamed from: e  reason: collision with root package name */
    public short f49102e;

    /* renamed from: f  reason: collision with root package name */
    public int f49103f;

    /* renamed from: g  reason: collision with root package name */
    public long f49104g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f49105h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f49106i;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public final e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e eVar = new e(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
                eVar.n(new byte[2]);
                byte[] e2 = eVar.e();
                if (e2 != null) {
                    e2[0] = 0;
                }
                byte[] e3 = eVar.e();
                if (e3 != null) {
                    e3[1] = 3;
                }
                eVar.m(new byte[2]);
                byte[] d2 = eVar.d();
                if (d2 != null) {
                    d2[0] = -27;
                }
                byte[] d3 = eVar.d();
                if (d3 != null) {
                    d3[1] = -89;
                }
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-583092994, "Ld/a/n0/c/a/i/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-583092994, "Ld/a/n0/c/a/i/e;");
                return;
            }
        }
        j = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((byte[]) objArr[0], (byte[]) objArr[1], ((Byte) objArr[2]).byteValue(), ((Byte) objArr[3]).byteValue(), ((Short) objArr[4]).shortValue(), ((Integer) objArr[5]).intValue(), ((Long) objArr[6]).longValue(), (byte[]) objArr[7], (byte[]) objArr[8], ((Integer) objArr[9]).intValue(), (DefaultConstructorMarker) objArr[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, long j2, byte[] bArr3, byte[] bArr4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, bArr2, Byte.valueOf(b2), Byte.valueOf(b3), Short.valueOf(s), Integer.valueOf(i2), Long.valueOf(j2), bArr3, bArr4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49098a = bArr;
        this.f49099b = bArr2;
        this.f49100c = b2;
        this.f49101d = b3;
        this.f49102e = s;
        this.f49103f = i2;
        this.f49104g = j2;
        this.f49105h = bArr3;
        this.f49106i = bArr4;
    }

    public final byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49106i : (byte[]) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49103f : invokeV.intValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49104g : invokeV.longValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49099b : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49098a : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof e) {
                    e eVar = (e) obj;
                    return Intrinsics.areEqual(this.f49098a, eVar.f49098a) && Intrinsics.areEqual(this.f49099b, eVar.f49099b) && this.f49100c == eVar.f49100c && this.f49101d == eVar.f49101d && this.f49102e == eVar.f49102e && this.f49103f == eVar.f49103f && this.f49104g == eVar.f49104g && Intrinsics.areEqual(this.f49105h, eVar.f49105h) && Intrinsics.areEqual(this.f49106i, eVar.f49106i);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f49105h : (byte[]) invokeV.objValue;
    }

    public final byte g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49101d : invokeV.byteValue;
    }

    public final short h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f49102e : invokeV.shortValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            byte[] bArr = this.f49098a;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            byte[] bArr2 = this.f49099b;
            int hashCode2 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j2 = this.f49104g;
            int i2 = (((((((((((hashCode + hashCode2) * 31) + this.f49100c) * 31) + this.f49101d) * 31) + this.f49102e) * 31) + this.f49103f) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            byte[] bArr3 = this.f49105h;
            int hashCode3 = (i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
            byte[] bArr4 = this.f49106i;
            return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
        }
        return invokeV.intValue;
    }

    public final byte i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49100c : invokeV.byteValue;
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.f49106i = bArr;
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f49103f = i2;
        }
    }

    public final void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.f49104g = j2;
        }
    }

    public final void m(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bArr) == null) {
            this.f49099b = bArr;
        }
    }

    public final void n(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            this.f49098a = bArr;
        }
    }

    public final void o(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            this.f49105h = bArr;
        }
    }

    public final void p(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048593, this, b2) == null) {
            this.f49101d = b2;
        }
    }

    public final void q(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f49102e = s;
        }
    }

    public final void r(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048595, this, b2) == null) {
            this.f49100c = b2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "RecordParams(protocolVersion=" + Arrays.toString(this.f49098a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.f49100c) + ", schemeExtType=" + ((int) this.f49101d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.f49102e) + ", contentLen=" + this.f49103f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "identity=" + this.f49104g + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.f49105h) + ')';
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ e(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, long j2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b2, (i3 & 8) != 0 ? (byte) 0 : b3, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? 0L : j2, (i3 & 128) != 0 ? null : bArr3, (i3 & 256) == 0 ? bArr4 : null);
    }
}
