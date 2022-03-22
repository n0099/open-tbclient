package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ix extends jb {
    public static /* synthetic */ Interceptable $ic;
    public static final jg a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f784a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f785a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f786a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44511b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f787b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44512c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f788c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f44513d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f44514e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f44515f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f44516g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f44517h;

    /* loaded from: classes7.dex */
    public static class a implements jd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f789a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44518b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(false, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(boolean z, boolean z2) {
            this(z, z2, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public a(boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f789a = false;
            this.f44518b = true;
            this.f789a = z;
            this.f44518b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.jd
        public jb a(jl jlVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jlVar)) == null) {
                ix ixVar = new ix(jlVar, this.f789a, this.f44518b);
                int i = this.a;
                if (i != 0) {
                    ixVar.b(i);
                }
                return ixVar;
            }
            return (jb) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371471, "Lcom/xiaomi/push/ix;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371471, "Lcom/xiaomi/push/ix;");
                return;
            }
        }
        a = new jg();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ix(jl jlVar, boolean z, boolean z2) {
        super(jlVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jlVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jl) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f785a = false;
        this.f44511b = true;
        this.f44512c = false;
        this.f786a = new byte[1];
        this.f787b = new byte[2];
        this.f788c = new byte[4];
        this.f44513d = new byte[8];
        this.f44514e = new byte[1];
        this.f44515f = new byte[2];
        this.f44516g = new byte[4];
        this.f44517h = new byte[8];
        this.f785a = z;
        this.f44511b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, this, bArr, i, i2)) == null) {
            c(i2);
            return ((jb) this).a.b(bArr, i, i2);
        }
        return invokeLII.intValue;
    }

    @Override // com.xiaomi.push.jb
    public byte a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (((jb) this).a.b() < 1) {
                a(this.f44514e, 0, 1);
                return this.f44514e[0];
            }
            byte b2 = ((jb) this).a.m573a()[((jb) this).a.a()];
            ((jb) this).a.a(1);
            return b2;
        }
        return invokeV.byteValue;
    }

    @Override // com.xiaomi.push.jb
    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Double.longBitsToDouble(a()) : invokeV.doubleValue;
    }

    @Override // com.xiaomi.push.jb
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = this.f44516g;
            int i = 0;
            if (((jb) this).a.b() >= 4) {
                bArr = ((jb) this).a.m573a();
                i = ((jb) this).a.a();
                ((jb) this).a.a(4);
            } else {
                a(this.f44516g, 0, 4);
            }
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }
        return invokeV.intValue;
    }

    @Override // com.xiaomi.push.jb
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] bArr = this.f44517h;
            int i = 0;
            if (((jb) this).a.b() >= 8) {
                bArr = ((jb) this).a.m573a();
                i = ((jb) this).a.a();
                ((jb) this).a.a(8);
            } else {
                a(this.f44517h, 0, 8);
            }
            return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        }
        return invokeV.longValue;
    }

    @Override // com.xiaomi.push.jb
    public iy a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            byte a2 = a();
            return new iy("", a2, a2 == 0 ? (short) 0 : a());
        }
        return (iy) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public iz a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new iz(a(), a()) : (iz) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public ja a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ja(a(), a(), a()) : (ja) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public jf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new jf(a(), a()) : (jf) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public jg a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a : (jg) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int a2 = a();
            if (((jb) this).a.b() >= a2) {
                try {
                    String str = new String(((jb) this).a.m573a(), ((jb) this).a.a(), a2, "UTF-8");
                    ((jb) this).a.a(a2);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new iv("JVM DOES NOT SUPPORT UTF-8");
                }
            }
            return a(a2);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            try {
                c(i);
                byte[] bArr = new byte[i];
                ((jb) this).a.b(bArr, 0, i);
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new iv("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // com.xiaomi.push.jb
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int a2 = a();
            c(a2);
            if (((jb) this).a.b() >= a2) {
                ByteBuffer wrap = ByteBuffer.wrap(((jb) this).a.m573a(), ((jb) this).a.a(), a2);
                ((jb) this).a.a(a2);
                return wrap;
            }
            byte[] bArr = new byte[a2];
            ((jb) this).a.b(bArr, 0, a2);
            return ByteBuffer.wrap(bArr);
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb
    public short a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.f44515f;
            int i = 0;
            if (((jb) this).a.b() >= 2) {
                bArr = ((jb) this).a.m573a();
                i = ((jb) this).a.a();
                ((jb) this).a.a(2);
            } else {
                a(this.f44515f, 0, 2);
            }
            return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
        }
        return invokeV.shortValue;
    }

    @Override // com.xiaomi.push.jb
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048590, this, b2) == null) {
            byte[] bArr = this.f786a;
            bArr[0] = b2;
            ((jb) this).a.m572a(bArr, 0, 1);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            byte[] bArr = this.f788c;
            bArr[0] = (byte) ((i >> 24) & 255);
            bArr[1] = (byte) ((i >> 16) & 255);
            bArr[2] = (byte) ((i >> 8) & 255);
            bArr[3] = (byte) (i & 255);
            ((jb) this).a.m572a(bArr, 0, 4);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            byte[] bArr = this.f44513d;
            bArr[0] = (byte) ((j >> 56) & 255);
            bArr[1] = (byte) ((j >> 48) & 255);
            bArr[2] = (byte) ((j >> 40) & 255);
            bArr[3] = (byte) ((j >> 32) & 255);
            bArr[4] = (byte) ((j >> 24) & 255);
            bArr[5] = (byte) ((j >> 16) & 255);
            bArr[6] = (byte) ((j >> 8) & 255);
            bArr[7] = (byte) (j & 255);
            ((jb) this).a.m572a(bArr, 0, 8);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(iy iyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iyVar) == null) {
            a(iyVar.a);
            a(iyVar.f791a);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(iz izVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, izVar) == null) {
            a(izVar.a);
            a(izVar.f792a);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(ja jaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jaVar) == null) {
            a(jaVar.a);
            a(jaVar.f44519b);
            a(jaVar.f795a);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(jg jgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jgVar) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                a(bytes.length);
                ((jb) this).a.m572a(bytes, 0, bytes.length);
            } catch (UnsupportedEncodingException unused) {
                throw new iv("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, byteBuffer) == null) {
            int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
            a(limit);
            ((jb) this).a.m572a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Short.valueOf(s)}) == null) {
            byte[] bArr = this.f787b;
            bArr[0] = (byte) ((s >> 8) & 255);
            bArr[1] = (byte) (s & 255);
            ((jb) this).a.m572a(bArr, 0, 2);
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            a(z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.xiaomi.push.jb
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.jb
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.f784a = i;
            this.f44512c = true;
        }
    }

    @Override // com.xiaomi.push.jb
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            a((byte) 0);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (i < 0) {
                throw new iv("Negative length: " + i);
            } else if (this.f44512c) {
                int i2 = this.f784a - i;
                this.f784a = i2;
                if (i2 >= 0) {
                    return;
                }
                throw new iv("Message length exceeded: " + i);
            }
        }
    }

    @Override // com.xiaomi.push.jb
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jb
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }
}
