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
    public static final byte[] f1089a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f1090a;

    /* renamed from: a  reason: collision with other field name */
    public dx.a f1091a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.ao f1092a;

    /* renamed from: a  reason: collision with other field name */
    public String f1093a;

    /* renamed from: a  reason: collision with other field name */
    public short f1094a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f1095b;

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
        f1089a = new byte[0];
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
        this.f1094a = (short) 2;
        this.f1095b = f1089a;
        this.f1093a = null;
        this.f1092a = null;
        this.f1091a = new dx.a();
        this.f1090a = 1;
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
        this.f1094a = (short) 2;
        this.f1095b = f1089a;
        this.f1093a = null;
        this.f1092a = null;
        this.f1091a = aVar;
        this.f1094a = s;
        this.f1095b = bArr;
        this.f1090a = 2;
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
                com.xiaomi.channel.commonutils.logger.b.m1027a("Blob parse chid err " + e.getMessage());
                i = 1;
            }
            flVar.a(i);
            flVar.a(gnVar.j());
            flVar.c(gnVar.m());
            flVar.b(gnVar.n());
            flVar.a("XMLMSG", (String) null);
            try {
                flVar.a(gnVar.m1309a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    flVar.a((short) 3);
                } else {
                    flVar.a((short) 2);
                    flVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e2) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("Blob setPayload err： " + e2.getMessage());
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
                com.xiaomi.channel.commonutils.logger.b.m1027a("read Blob err :" + e.getMessage());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1091a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1273a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1091a.m1215c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo1274a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f1094a);
            byteBuffer.putShort((short) this.f1091a.a());
            byteBuffer.putInt(this.f1095b.length);
            int position = byteBuffer.position();
            this.f1091a.m1240a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f1091a.a());
            byteBuffer.position(position + this.f1091a.a());
            byteBuffer.put(this.f1095b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m1275a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1094a : invokeV.shortValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f1091a.a(i);
        }
    }

    public void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            if (j != 0) {
                this.f1091a.a(j);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f1091a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f1091a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f1091a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f1091a.c(str);
            this.f1091a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f1091a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f1094a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f1091a.c(0);
                this.f1095b = bArr;
                return;
            }
            this.f1091a.c(1);
            this.f1095b = com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1276a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1091a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1277a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fm.a(this, this.f1095b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1278a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f1091a.e() == 1) {
                return fm.a(this, com.xiaomi.push.service.bp.a(com.xiaomi.push.service.bp.a(str, e()), this.f1095b));
            }
            if (this.f1091a.e() == 0) {
                return fm.a(this, this.f1095b);
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a("unknow cipher = " + this.f1091a.e());
            return fm.a(this, this.f1095b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1091a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m1279b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1091a.m1217d() : (String) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            com.xiaomi.push.service.ao aoVar = new com.xiaomi.push.service.ao();
            this.f1092a = aoVar;
            aoVar.a = i;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f1093a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1091a.b() + 8 + this.f1095b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m1280c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1091a.m1221f() : (String) invokeV.objValue;
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
            this.f1091a.a(parseLong);
            this.f1091a.a(substring);
            this.f1091a.b(substring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m1027a("Blob parse user err " + e.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String m1219e = this.f1091a.m1219e();
            if ("ID_NOT_AVAILABLE".equals(m1219e)) {
                return null;
            }
            if (this.f1091a.g()) {
                return m1219e;
            }
            String d = d();
            this.f1091a.e(d);
            return d;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1093a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.f1091a.b()) {
                return Long.toString(this.f1091a.a()) + "@" + this.f1091a.a() + "/" + this.f1091a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m1273a() + "; type=" + ((int) m1275a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
