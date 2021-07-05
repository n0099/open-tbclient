package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.xiaomi.push.du;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class fa {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f43096a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f359a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43097b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f360a;

    /* renamed from: a  reason: collision with other field name */
    public du.a f361a;

    /* renamed from: a  reason: collision with other field name */
    public String f362a;

    /* renamed from: a  reason: collision with other field name */
    public short f363a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f364b;

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
        f43097b = gn.a(5) + "-";
        f43096a = 0L;
        f359a = new byte[0];
    }

    public fa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f363a = (short) 2;
        this.f364b = f359a;
        this.f362a = null;
        this.f361a = new du.a();
        this.f360a = 1;
    }

    public fa(du.a aVar, short s, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Short.valueOf(s), bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f363a = (short) 2;
        this.f364b = f359a;
        this.f362a = null;
        this.f361a = aVar;
        this.f363a = s;
        this.f364b = bArr;
        this.f360a = 2;
    }

    @Deprecated
    public static fa a(gc gcVar, String str) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gcVar, str)) == null) {
            fa faVar = new fa();
            try {
                i2 = Integer.parseInt(gcVar.k());
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a("Blob parse chid err " + e2.getMessage());
                i2 = 1;
            }
            faVar.a(i2);
            faVar.a(gcVar.j());
            faVar.c(gcVar.m());
            faVar.b(gcVar.n());
            faVar.a("XMLMSG", (String) null);
            try {
                faVar.a(gcVar.m345a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    faVar.a((short) 3);
                } else {
                    faVar.a((short) 2);
                    faVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e3) {
                com.xiaomi.channel.commonutils.logger.b.m70a("Blob setPayload err： " + e3.getMessage());
            }
            return faVar;
        }
        return (fa) invokeLL.objValue;
    }

    public static fa a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, byteBuffer)) == null) {
            try {
                ByteBuffer slice = byteBuffer.slice();
                short s = slice.getShort(0);
                short s2 = slice.getShort(2);
                int i2 = slice.getInt(4);
                du.a aVar = new du.a();
                aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
                byte[] bArr = new byte[i2];
                slice.position(s2 + 8);
                slice.get(bArr, 0, i2);
                return new fa(aVar, s, bArr);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a("read Blob err :" + e2.getMessage());
                throw new IOException("Malformed Input");
            }
        }
        return (fa) invokeL.objValue;
    }

    public static synchronized String d() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            synchronized (fa.class) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f43097b);
                long j = f43096a;
                f43096a = 1 + j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f361a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m302a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f361a.m254c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo303a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f363a);
            byteBuffer.putShort((short) this.f361a.a());
            byteBuffer.putInt(this.f364b.length);
            int position = byteBuffer.position();
            this.f361a.m280a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f361a.a());
            byteBuffer.position(position + this.f361a.a());
            byteBuffer.put(this.f364b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m304a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f363a : invokeV.shortValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f361a.a(i2);
        }
    }

    public void a(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            if (j != 0) {
                this.f361a.a(j);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f361a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f361a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f361a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f361a.c(str);
            this.f361a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f361a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f363a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f361a.c(0);
                this.f364b = bArr;
                return;
            }
            this.f361a.c(1);
            this.f364b = com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m305a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f361a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m306a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fb.a(this, this.f364b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m307a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f361a.e() == 1) {
                return fb.a(this, com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), this.f364b));
            }
            if (this.f361a.e() == 0) {
                return fb.a(this, this.f364b);
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("unknow cipher = " + this.f361a.e());
            return fb.a(this, this.f364b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f361a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m308b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f361a.m256d() : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f362a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f361a.b() + 8 + this.f364b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m309c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f361a.m260f() : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f361a.a(parseLong);
            this.f361a.a(substring);
            this.f361a.b(substring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m70a("Blob parse user err " + e2.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String m258e = this.f361a.m258e();
            if ("ID_NOT_AVAILABLE".equals(m258e)) {
                return null;
            }
            if (this.f361a.g()) {
                return m258e;
            }
            String d2 = d();
            this.f361a.e(d2);
            return d2;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f362a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f361a.b()) {
                return Long.toString(this.f361a.a()) + TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f361a.a() + "/" + this.f361a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m302a() + "; type=" + ((int) m304a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
