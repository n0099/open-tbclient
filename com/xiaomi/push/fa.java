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
/* loaded from: classes10.dex */
public class fa {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f77974a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f363a;

    /* renamed from: b  reason: collision with root package name */
    public static String f77975b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f364a;

    /* renamed from: a  reason: collision with other field name */
    public du.a f365a;

    /* renamed from: a  reason: collision with other field name */
    public String f366a;

    /* renamed from: a  reason: collision with other field name */
    public short f367a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f368b;

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
        f77975b = gn.a(5) + "-";
        f77974a = 0L;
        f363a = new byte[0];
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
        this.f367a = (short) 2;
        this.f368b = f363a;
        this.f366a = null;
        this.f365a = new du.a();
        this.f364a = 1;
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
        this.f367a = (short) 2;
        this.f368b = f363a;
        this.f366a = null;
        this.f365a = aVar;
        this.f367a = s;
        this.f368b = bArr;
        this.f364a = 2;
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
                com.xiaomi.channel.commonutils.logger.b.m73a("Blob parse chid err " + e2.getMessage());
                i2 = 1;
            }
            faVar.a(i2);
            faVar.a(gcVar.j());
            faVar.c(gcVar.m());
            faVar.b(gcVar.n());
            faVar.a("XMLMSG", (String) null);
            try {
                faVar.a(gcVar.m348a().getBytes("utf8"), str);
                if (TextUtils.isEmpty(str)) {
                    faVar.a((short) 3);
                } else {
                    faVar.a((short) 2);
                    faVar.a("SECMSG", (String) null);
                }
            } catch (UnsupportedEncodingException e3) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Blob setPayload err： " + e3.getMessage());
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
                int i2 = slice.getInt(4);
                du.a aVar = new du.a();
                aVar.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
                byte[] bArr = new byte[i2];
                slice.position(s2 + 8);
                slice.get(bArr, 0, i2);
                return new fa(aVar, s, bArr);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("read Blob err :" + e2.getMessage());
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
                sb2.append(f77975b);
                long j2 = f77974a;
                f77974a = 1 + j2;
                sb2.append(Long.toString(j2));
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f365a.c() : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m305a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f365a.m257c() : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo306a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(c());
            }
            byteBuffer.putShort(this.f367a);
            byteBuffer.putShort((short) this.f365a.a());
            byteBuffer.putInt(this.f368b.length);
            int position = byteBuffer.position();
            this.f365a.m283a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f365a.a());
            byteBuffer.position(position + this.f365a.a());
            byteBuffer.put(this.f368b);
            return byteBuffer;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m307a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f367a : invokeV.shortValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f365a.a(i2);
        }
    }

    public void a(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            if (j2 != 0) {
                this.f365a.a(j2);
            }
            if (!TextUtils.isEmpty(str)) {
                this.f365a.a(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f365a.b(str2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f365a.e(str);
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("command should not be empty");
            }
            this.f365a.c(str);
            this.f365a.a();
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f365a.d(str2);
        }
    }

    public void a(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f367a = s;
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bArr, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f365a.c(0);
                this.f368b = bArr;
                return;
            }
            this.f365a.c(1);
            this.f368b = com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), bArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m308a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f365a.j() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m309a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? fb.a(this, this.f368b) : (byte[]) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m310a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (this.f365a.e() == 1) {
                return fb.a(this, com.xiaomi.push.service.be.a(com.xiaomi.push.service.be.a(str, e()), this.f368b));
            }
            if (this.f365a.e() == 0) {
                return fb.a(this, this.f368b);
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("unknow cipher = " + this.f365a.e());
            return fb.a(this, this.f368b);
        }
        return (byte[]) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f365a.f() : invokeV.intValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m311b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f365a.m259d() : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f366a = str;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f365a.b() + 8 + this.f368b.length : invokeV.intValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m312c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f365a.m263f() : (String) invokeV.objValue;
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
            this.f365a.a(parseLong);
            this.f365a.a(substring);
            this.f365a.b(substring2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Blob parse user err " + e2.getMessage());
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            String m261e = this.f365a.m261e();
            if ("ID_NOT_AVAILABLE".equals(m261e)) {
                return null;
            }
            if (this.f365a.g()) {
                return m261e;
            }
            String d2 = d();
            this.f365a.e(d2);
            return d2;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f366a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f365a.b()) {
                return Long.toString(this.f365a.a()) + TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f365a.a() + "/" + this.f365a.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "Blob [chid=" + a() + "; Id=" + e() + "; cmd=" + m305a() + "; type=" + ((int) m307a()) + "; from=" + g() + " ]";
        }
        return (String) invokeV.objValue;
    }
}
