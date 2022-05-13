package com.repackage;

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
public final class us {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public byte[] b;
    public byte c;
    public byte d;
    public short e;
    public int f;
    public byte[] g;
    public byte[] h;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final us a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                us usVar = new us(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
                usVar.d(new byte[2]);
                byte[] e = usVar.e();
                if (e != null) {
                    e[0] = 0;
                }
                byte[] e2 = usVar.e();
                if (e2 != null) {
                    e2[1] = 2;
                }
                usVar.g(new byte[2]);
                byte[] h = usVar.h();
                if (h != null) {
                    h[0] = -27;
                }
                byte[] h2 = usVar.h();
                if (h2 != null) {
                    h2[1] = -89;
                }
                return usVar;
            }
            return (us) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964025561, "Lcom/repackage/us;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964025561, "Lcom/repackage/us;");
                return;
            }
        }
        i = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public us() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((byte[]) objArr[0], (byte[]) objArr[1], ((Byte) objArr[2]).byteValue(), ((Byte) objArr[3]).byteValue(), ((Short) objArr[4]).shortValue(), ((Integer) objArr[5]).intValue(), (byte[]) objArr[6], (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public us(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i2, byte[] bArr3, byte[] bArr4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, bArr2, Byte.valueOf(b), Byte.valueOf(b2), Short.valueOf(s), Integer.valueOf(i2), bArr3, bArr4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.b = bArr2;
        this.c = b;
        this.d = b2;
        this.e = s;
        this.f = i2;
        this.g = bArr3;
        this.h = bArr4;
    }

    public final void a(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048576, this, b) == null) {
            this.c = b;
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f = i2;
        }
    }

    public final void c(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Short.valueOf(s)}) == null) {
            this.e = s;
        }
    }

    public final void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            this.a = bArr;
        }
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof us) {
                    us usVar = (us) obj;
                    if (Intrinsics.areEqual(this.a, usVar.a) && Intrinsics.areEqual(this.b, usVar.b)) {
                        if (this.c == usVar.c) {
                            if (this.d == usVar.d) {
                                if (this.e == usVar.e) {
                                    if (!(this.f == usVar.f) || !Intrinsics.areEqual(this.g, usVar.g) || !Intrinsics.areEqual(this.h, usVar.h)) {
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048582, this, b) == null) {
            this.d = b;
        }
    }

    public final void g(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            this.b = bArr;
        }
    }

    public final byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (byte[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            byte[] bArr = this.a;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            byte[] bArr2 = this.b;
            int hashCode2 = (((((((((hashCode + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
            byte[] bArr3 = this.g;
            int hashCode3 = (hashCode2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
            byte[] bArr4 = this.h;
            return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
        }
        return invokeV.intValue;
    }

    public final byte i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : invokeV.byteValue;
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.g = bArr;
        }
    }

    public final byte k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d : invokeV.byteValue;
    }

    public final void l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            this.h = bArr;
        }
    }

    public final short m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e : invokeV.shortValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : invokeV.intValue;
    }

    public final byte[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : (byte[]) invokeV.objValue;
    }

    public final byte[] p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.h : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "RecordParams(protocolVersion=" + Arrays.toString(this.a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.c) + ", schemeExtType=" + ((int) this.d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.e) + ", contentLen=" + this.f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.g) + ')';
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ us(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b, (i3 & 8) != 0 ? (byte) 0 : b2, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : bArr3, (i3 & 128) == 0 ? bArr4 : null);
    }
}
