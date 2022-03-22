package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class fa {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f340a;

    /* renamed from: b  reason: collision with root package name */
    public static String f44241b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f341a;

    /* renamed from: a  reason: collision with other field name */
    public du.a f342a;

    /* renamed from: a  reason: collision with other field name */
    public String f343a;

    /* renamed from: a  reason: collision with other field name */
    public short f344a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f345b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375067, "Lcom/xiaomi/push/fa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375067, "Lcom/xiaomi/push/fa;");
                return;
            }
        }
        f44241b = gn.a(5) + "-";
        a = 0L;
        f340a = new byte[0];
    }

    public fa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f344a = (short) 2;
        this.f345b = f340a;
        this.f343a = null;
        this.f342a = new du.a();
        this.f341a = 1;
    }

    public fa(du.a aVar, short s, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Short.valueOf(s), bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f344a = (short) 2;
        this.f345b = f340a;
        this.f343a = null;
        this.f342a = aVar;
        this.f344a = s;
        this.f345b = bArr;
        this.f341a = 2;
    }

    @Deprecated
    public static fa a(gc gcVar, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gcVar, str)) == null) {
            fa faVar = new fa();
            try {
                i = Integer.parseInt(gcVar.k());
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m112a("Blob parse chid err " + e2.getMessage());
                i = 1;
            }
            faVar.a(i);
            faVar.a(gcVar.j());
            faVar.c(gcVar.m());
            faVar.b(gcVar.n());
            faVar.a("XMLMSG", (String) null);
            try {
                faVar.a(gcVar.m387a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    faVar.a((short) 3);
                } else {
                    faVar.a((short) 2);
                    faVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e3) {
                com.xiaomi.channel.commonutils.logger.b.m112a("Blob setPayload err： " + e3.getMessage());
            }
            return faVar;
        }
        return (fa) invokeLL.objValue;
    }

    public static fa a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            try {
                ByteBuffer slice = byteBuffer.slice();
                short s = slice.getShort(0);
                short s2 = slice.getShort(2);
                int i = slice.getInt(4);
                du.a aVar = new du.a();
                aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
                byte[] bArr = new byte[i];
                slice.position(s2 + 8);
                slice.get(bArr, 0, i);
                return new fa(aVar, s, bArr);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m112a("read Blob err :" + e2.getMessage());
                throw new IOException("Malformed Input");
            }
        }
        return (fa) invokeL.objValue;
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (fa.class) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f44241b);
                long j = a;
                a = 1 + j;
                sb2.append(Long.toString(j));
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f342a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m344a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f342a.m296c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo345a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f344a);
            byteBuffer.putShort((short) this.f342a.a());
            byteBuffer.putInt(this.f345b.length);
            int position = byteBuffer.position();
            this.f342a.m322a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f342a.a());
            byteBuffer.position(position + this.f342a.a());
            byteBuffer.put(this.f345b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m346a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f344a : invokeV.shortValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f342a.a(i);
        }
    }

    public void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            if (j != 0) {
                this.f342a.a(j);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f342a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f342a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f342a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f342a.c(str);
            this.f342a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f342a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f344a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f342a.c(0);
                this.f345b = bArr;
                return;
            }
            this.f342a.c(1);
            this.f345b = com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m347a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f342a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m348a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fb.a(this, this.f345b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m349a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f342a.e() == 1) {
                return fb.a(this, com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), this.f345b));
            }
            if (this.f342a.e() == 0) {
                return fb.a(this, this.f345b);
            }
            com.xiaomi.channel.commonutils.logger.b.m112a("unknow cipher = " + this.f342a.e());
            return fb.a(this, this.f345b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f342a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m350b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f342a.m298d() : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f343a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f342a.b() + 8 + this.f345b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m351c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f342a.m302f() : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f342a.a(parseLong);
            this.f342a.a(substring);
            this.f342a.b(substring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m112a("Blob parse user err " + e2.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String m300e = this.f342a.m300e();
            if ("ID_NOT_AVAILABLE".equals(m300e)) {
                return null;
            }
            if (this.f342a.g()) {
                return m300e;
            }
            String d2 = d();
            this.f342a.e(d2);
            return d2;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f343a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f342a.b()) {
                return Long.toString(this.f342a.a()) + "@" + this.f342a.a() + "/" + this.f342a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m344a() + "; type=" + ((int) m346a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
