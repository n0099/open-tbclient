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
/* loaded from: classes8.dex */
public class jb extends jf {
    public static /* synthetic */ Interceptable $ic;
    public static final jk a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f826a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f827a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f828a;
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f829b;
    public boolean c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f830c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;

    /* loaded from: classes8.dex */
    public static class a implements jh {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f831a;
        public boolean b;

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
            this.f831a = false;
            this.b = true;
            this.f831a = z;
            this.b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.jh
        public jf a(jp jpVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jpVar)) == null) {
                jb jbVar = new jb(jpVar, this.f831a, this.b);
                int i = this.a;
                if (i != 0) {
                    jbVar.b(i);
                }
                return jbVar;
            }
            return (jf) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371192, "Lcom/xiaomi/push/jb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371192, "Lcom/xiaomi/push/jb;");
                return;
            }
        }
        a = new jk();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(jp jpVar, boolean z, boolean z2) {
        super(jpVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jpVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jp) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f827a = false;
        this.b = true;
        this.c = false;
        this.f828a = new byte[1];
        this.f829b = new byte[2];
        this.f830c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f827a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, this, bArr, i, i2)) == null) {
            c(i2);
            return ((jf) this).a.b(bArr, i, i2);
        }
        return invokeLII.intValue;
    }

    @Override // com.xiaomi.push.jf
    public byte a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (((jf) this).a.b() < 1) {
                a(this.e, 0, 1);
                return this.e[0];
            }
            byte b = ((jf) this).a.mo630a()[((jf) this).a.a()];
            ((jf) this).a.a(1);
            return b;
        }
        return invokeV.byteValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public double mo615a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Double.longBitsToDouble(mo617a()) : invokeV.doubleValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public int mo616a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = this.g;
            int i = 0;
            if (((jf) this).a.b() >= 4) {
                bArr = ((jf) this).a.mo630a();
                i = ((jf) this).a.a();
                ((jf) this).a.a(4);
            } else {
                a(this.g, 0, 4);
            }
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }
        return invokeV.intValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public long mo617a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            byte[] bArr = this.h;
            int i = 0;
            if (((jf) this).a.b() >= 8) {
                bArr = ((jf) this).a.mo630a();
                i = ((jf) this).a.a();
                ((jf) this).a.a(8);
            } else {
                a(this.h, 0, 8);
            }
            return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
        }
        return invokeV.longValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jc mo618a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            byte a2 = a();
            return new jc("", a2, a2 == 0 ? (short) 0 : mo625a());
        }
        return (jc) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jd mo619a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new jd(a(), mo616a()) : (jd) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public je mo620a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new je(a(), a(), mo616a()) : (je) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jj mo621a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new jj(a(), mo616a()) : (jj) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public jk mo622a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a : (jk) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public String mo623a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int mo616a = mo616a();
            if (((jf) this).a.b() >= mo616a) {
                try {
                    String str = new String(((jf) this).a.mo630a(), ((jf) this).a.a(), mo616a, "UTF-8");
                    ((jf) this).a.a(mo616a);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new iz("JVM DOES NOT SUPPORT UTF-8");
                }
            }
            return a(mo616a);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.jf.a(I)V */
    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            try {
                c(i);
                byte[] bArr = new byte[i];
                ((jf) this).a.b(bArr, 0, i);
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new iz("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return (String) invokeI.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo624a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int mo616a = mo616a();
            c(mo616a);
            if (((jf) this).a.b() >= mo616a) {
                ByteBuffer wrap = ByteBuffer.wrap(((jf) this).a.mo630a(), ((jf) this).a.a(), mo616a);
                ((jf) this).a.a(mo616a);
                return wrap;
            }
            byte[] bArr = new byte[mo616a];
            ((jf) this).a.b(bArr, 0, mo616a);
            return ByteBuffer.wrap(bArr);
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public short mo625a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            byte[] bArr = this.f;
            int i = 0;
            if (((jf) this).a.b() >= 2) {
                bArr = ((jf) this).a.mo630a();
                i = ((jf) this).a.a();
                ((jf) this).a.a(2);
            } else {
                a(this.f, 0, 2);
            }
            return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
        }
        return invokeV.shortValue;
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void mo626a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048590, this, b) == null) {
            byte[] bArr = this.f828a;
            bArr[0] = b;
            ((jf) this).a.mo629a(bArr, 0, 1);
        }
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public void mo627a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            byte[] bArr = this.f830c;
            bArr[0] = (byte) ((i >> 24) & 255);
            bArr[1] = (byte) ((i >> 16) & 255);
            bArr[2] = (byte) ((i >> 8) & 255);
            bArr[3] = (byte) (i & 255);
            ((jf) this).a.mo629a(bArr, 0, 4);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            byte[] bArr = this.d;
            bArr[0] = (byte) ((j >> 56) & 255);
            bArr[1] = (byte) ((j >> 48) & 255);
            bArr[2] = (byte) ((j >> 40) & 255);
            bArr[3] = (byte) ((j >> 32) & 255);
            bArr[4] = (byte) ((j >> 24) & 255);
            bArr[5] = (byte) ((j >> 16) & 255);
            bArr[6] = (byte) ((j >> 8) & 255);
            bArr[7] = (byte) (j & 255);
            ((jf) this).a.mo629a(bArr, 0, 8);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(jc jcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jcVar) == null) {
            a(jcVar.a);
            a(jcVar.f833a);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(jd jdVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jdVar) == null) {
            a(jdVar.a);
            mo627a(jdVar.f834a);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(je jeVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jeVar) == null) {
            a(jeVar.a);
            a(jeVar.b);
            mo627a(jeVar.f835a);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(jk jkVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jkVar) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                mo627a(bytes.length);
                ((jf) this).a.mo629a(bytes, 0, bytes.length);
            } catch (UnsupportedEncodingException unused) {
                throw new iz("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, byteBuffer) == null) {
            int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
            mo627a(limit);
            ((jf) this).a.mo629a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Short.valueOf(s)}) == null) {
            byte[] bArr = this.f829b;
            bArr[0] = (byte) ((s >> 8) & 255);
            bArr[1] = (byte) (s & 255);
            ((jf) this).a.mo629a(bArr, 0, 2);
        }
    }

    @Override // com.xiaomi.push.jf
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            a(z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.xiaomi.push.jf
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo628a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? a() == 1 : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.jf
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.f826a = i;
            this.c = true;
        }
    }

    @Override // com.xiaomi.push.jf
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
                throw new iz("Negative length: " + i);
            } else if (this.c) {
                int i2 = this.f826a - i;
                this.f826a = i2;
                if (i2 >= 0) {
                    return;
                }
                throw new iz("Message length exceeded: " + i);
            }
        }
    }

    @Override // com.xiaomi.push.jf
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    @Override // com.xiaomi.push.jf
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }
}
