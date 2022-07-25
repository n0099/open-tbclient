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
    public static final byte[] f369a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f370a;

    /* renamed from: a  reason: collision with other field name */
    public dx.a f371a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ao f372a;

    /* renamed from: a  reason: collision with other field name */
    public String f373a;

    /* renamed from: a  reason: collision with other field name */
    public short f374a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f375b;

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
        f369a = new byte[0];
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
        this.f374a = (short) 2;
        this.f375b = f369a;
        this.f373a = null;
        this.f372a = null;
        this.f371a = new dx.a();
        this.f370a = 1;
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
        this.f374a = (short) 2;
        this.f375b = f369a;
        this.f373a = null;
        this.f372a = null;
        this.f371a = aVar;
        this.f374a = s;
        this.f375b = bArr;
        this.f370a = 2;
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
                com.xiaomi.channel.commonutils.logger.b.m89a("Blob parse chid err " + e.getMessage());
                i = 1;
            }
            flVar.a(i);
            flVar.a(gnVar.j());
            flVar.c(gnVar.m());
            flVar.b(gnVar.n());
            flVar.a("XMLMSG", (String) null);
            try {
                flVar.a(gnVar.m371a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    flVar.a((short) 3);
                } else {
                    flVar.a((short) 2);
                    flVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e2) {
                com.xiaomi.channel.commonutils.logger.b.m89a("Blob setPayload err： " + e2.getMessage());
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
                com.xiaomi.channel.commonutils.logger.b.m89a("read Blob err :" + e.getMessage());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f371a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m335a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f371a.m277c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo336a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f374a);
            byteBuffer.putShort((short) this.f371a.a());
            byteBuffer.putInt(this.f375b.length);
            int position = byteBuffer.position();
            this.f371a.m302a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f371a.a());
            byteBuffer.position(position + this.f371a.a());
            byteBuffer.put(this.f375b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m337a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f374a : invokeV.shortValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f371a.a(i);
        }
    }

    public void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            if (j != 0) {
                this.f371a.a(j);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f371a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f371a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f371a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f371a.c(str);
            this.f371a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f371a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f374a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f371a.c(0);
                this.f375b = bArr;
                return;
            }
            this.f371a.c(1);
            this.f375b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m338a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f371a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m339a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fm.a(this, this.f375b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m340a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f371a.e() == 1) {
                return fm.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f375b));
            }
            if (this.f371a.e() == 0) {
                return fm.a(this, this.f375b);
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("unknow cipher = " + this.f371a.e());
            return fm.a(this, this.f375b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f371a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m341b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f371a.m279d() : (String) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            com.xiaomi.push.service.ao aoVar = new com.xiaomi.push.service.ao();
            this.f372a = aoVar;
            aoVar.a = i;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f373a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f371a.b() + 8 + this.f375b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m342c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f371a.m283f() : (String) invokeV.objValue;
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
            this.f371a.a(parseLong);
            this.f371a.a(substring);
            this.f371a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m89a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String m281e = this.f371a.m281e();
            if ("ID_NOT_AVAILABLE".equals(m281e)) {
                return null;
            }
            if (this.f371a.g()) {
                return m281e;
            }
            String d = d();
            this.f371a.e(d);
            return d;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f373a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f371a.b()) {
                return Long.toString(this.f371a.a()) + "@" + this.f371a.a() + "/" + this.f371a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m335a() + "; type=" + ((int) m337a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
