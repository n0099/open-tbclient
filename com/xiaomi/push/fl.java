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
import com.xiaomi.push.dx;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class fl {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f393a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f394a;

    /* renamed from: a  reason: collision with other field name */
    public dx.a f395a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ao f396a;

    /* renamed from: a  reason: collision with other field name */
    public String f397a;

    /* renamed from: a  reason: collision with other field name */
    public short f398a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f399b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374726, "Lcom/xiaomi/push/fl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374726, "Lcom/xiaomi/push/fl;");
                return;
            }
        }
        b = gy.a(5) + "-";
        a = 0L;
        f393a = new byte[0];
    }

    public fl() {
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
        this.f398a = (short) 2;
        this.f399b = f393a;
        this.f397a = null;
        this.f396a = null;
        this.f395a = new dx.a();
        this.f394a = 1;
    }

    public fl(dx.a aVar, short s, byte[] bArr) {
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
        this.f398a = (short) 2;
        this.f399b = f393a;
        this.f397a = null;
        this.f396a = null;
        this.f395a = aVar;
        this.f398a = s;
        this.f399b = bArr;
        this.f394a = 2;
    }

    @Deprecated
    public static fl a(gn gnVar, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gnVar, str)) == null) {
            fl flVar = new fl();
            try {
                i = Integer.parseInt(gnVar.k());
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m99a("Blob parse chid err " + e.getMessage());
                i = 1;
            }
            flVar.a(i);
            flVar.a(gnVar.j());
            flVar.c(gnVar.m());
            flVar.b(gnVar.n());
            flVar.a("XMLMSG", (String) null);
            try {
                flVar.a(gnVar.m381a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    flVar.a((short) 3);
                } else {
                    flVar.a((short) 2);
                    flVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e2) {
                com.xiaomi.channel.commonutils.logger.b.m99a("Blob setPayload err： " + e2.getMessage());
            }
            return flVar;
        }
        return (fl) invokeLL.objValue;
    }

    public static fl a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            try {
                ByteBuffer slice = byteBuffer.slice();
                short s = slice.getShort(0);
                short s2 = slice.getShort(2);
                int i = slice.getInt(4);
                dx.a aVar = new dx.a();
                aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
                byte[] bArr = new byte[i];
                slice.position(s2 + 8);
                slice.get(bArr, 0, i);
                return new fl(aVar, s, bArr);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m99a("read Blob err :" + e.getMessage());
                throw new IOException("Malformed Input");
            }
        }
        return (fl) invokeL.objValue;
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (fl.class) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f395a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m345a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f395a.m287c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo346a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f398a);
            byteBuffer.putShort((short) this.f395a.a());
            byteBuffer.putInt(this.f399b.length);
            int position = byteBuffer.position();
            this.f395a.m312a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f395a.a());
            byteBuffer.position(position + this.f395a.a());
            byteBuffer.put(this.f399b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m347a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f398a : invokeV.shortValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f395a.a(i);
        }
    }

    public void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            if (j != 0) {
                this.f395a.a(j);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f395a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f395a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f395a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f395a.c(str);
            this.f395a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f395a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f398a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f395a.c(0);
                this.f399b = bArr;
                return;
            }
            this.f395a.c(1);
            this.f399b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m348a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f395a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m349a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fm.a(this, this.f399b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m350a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f395a.e() == 1) {
                return fm.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f399b));
            }
            if (this.f395a.e() == 0) {
                return fm.a(this, this.f399b);
            }
            com.xiaomi.channel.commonutils.logger.b.m99a("unknow cipher = " + this.f395a.e());
            return fm.a(this, this.f399b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f395a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m351b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f395a.m289d() : (String) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            com.xiaomi.push.service.ao aoVar = new com.xiaomi.push.service.ao();
            this.f396a = aoVar;
            aoVar.a = i;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f397a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f395a.b() + 8 + this.f399b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m352c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f395a.m293f() : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f395a.a(parseLong);
            this.f395a.a(substring);
            this.f395a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m99a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String m291e = this.f395a.m291e();
            if ("ID_NOT_AVAILABLE".equals(m291e)) {
                return null;
            }
            if (this.f395a.g()) {
                return m291e;
            }
            String d = d();
            this.f395a.e(d);
            return d;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f397a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f395a.b()) {
                return Long.toString(this.f395a.a()) + "@" + this.f395a.a() + "/" + this.f395a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m345a() + "; type=" + ((int) m347a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
