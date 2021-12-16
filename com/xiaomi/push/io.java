package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes4.dex */
public class io implements iq<io, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f794a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f63778b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f63779c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f63780d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f63781e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f63782f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f63783g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f63784h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f63785i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f795a;

    /* renamed from: a  reason: collision with other field name */
    public hu f796a;

    /* renamed from: a  reason: collision with other field name */
    public String f797a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f798a;

    /* renamed from: b  reason: collision with other field name */
    public String f799b;

    /* renamed from: c  reason: collision with other field name */
    public String f800c;

    /* renamed from: d  reason: collision with other field name */
    public String f801d;

    /* renamed from: e  reason: collision with other field name */
    public String f802e;

    /* renamed from: f  reason: collision with other field name */
    public String f803f;

    /* renamed from: g  reason: collision with other field name */
    public String f804g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371750, "Lcom/xiaomi/push/io;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371750, "Lcom/xiaomi/push/io;");
                return;
            }
        }
        f794a = new jg("XmPushActionUnSubscriptionResult");
        a = new iy("", (byte) 11, (short) 1);
        f63778b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f63779c = new iy("", (byte) 11, (short) 3);
        f63780d = new iy("", (byte) 11, (short) 4);
        f63781e = new iy("", (byte) 10, (short) 6);
        f63782f = new iy("", (byte) 11, (short) 7);
        f63783g = new iy("", (byte) 11, (short) 8);
        f63784h = new iy("", (byte) 11, (short) 9);
        f63785i = new iy("", (byte) 11, (short) 10);
    }

    public io() {
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
        this.f798a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ioVar)) == null) {
            if (io.class.equals(ioVar.getClass())) {
                int compareTo = Boolean.valueOf(m562a()).compareTo(Boolean.valueOf(ioVar.m562a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m562a() || (a10 = ir.a(this.f797a, ioVar.f797a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m564b()).compareTo(Boolean.valueOf(ioVar.m564b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m564b() || (a9 = ir.a(this.f796a, ioVar.f796a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m565c()).compareTo(Boolean.valueOf(ioVar.m565c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m565c() || (a8 = ir.a(this.f799b, ioVar.f799b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f800c, ioVar.f800c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f795a, ioVar.f795a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f801d, ioVar.f801d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f802e, ioVar.f802e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f803f, ioVar.f803f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f804g, ioVar.f804g)) == 0) {
                                                    return 0;
                                                }
                                                return a2;
                                            }
                                            return a3;
                                        }
                                        return a4;
                                    }
                                    return a5;
                                }
                                return a6;
                            }
                            return a7;
                        }
                        return a8;
                    }
                    return a9;
                }
                return a10;
            }
            return io.class.getName().compareTo(ioVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f799b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m561a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f799b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m576a();
        while (true) {
            iy m572a = jbVar.m572a();
            byte b2 = m572a.a;
            if (b2 == 0) {
                jbVar.f();
                m561a();
                return;
            }
            switch (m572a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f797a = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f796a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f799b = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f800c = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f795a = jbVar.m571a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f801d = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f802e = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f803f = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f804g = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f798a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m562a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f797a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m563a(io ioVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ioVar)) == null) {
            if (ioVar == null) {
                return false;
            }
            boolean m562a = m562a();
            boolean m562a2 = ioVar.m562a();
            if ((m562a || m562a2) && !(m562a && m562a2 && this.f797a.equals(ioVar.f797a))) {
                return false;
            }
            boolean m564b = m564b();
            boolean m564b2 = ioVar.m564b();
            if ((m564b || m564b2) && !(m564b && m564b2 && this.f796a.m471a(ioVar.f796a))) {
                return false;
            }
            boolean m565c = m565c();
            boolean m565c2 = ioVar.m565c();
            if ((m565c || m565c2) && !(m565c && m565c2 && this.f799b.equals(ioVar.f799b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ioVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f800c.equals(ioVar.f800c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ioVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f795a == ioVar.f795a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ioVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f801d.equals(ioVar.f801d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ioVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f802e.equals(ioVar.f802e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ioVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f803f.equals(ioVar.f803f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ioVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f804g.equals(ioVar.f804g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f802e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m561a();
            jbVar.a(f794a);
            if (this.f797a != null && m562a()) {
                jbVar.a(a);
                jbVar.a(this.f797a);
                jbVar.b();
            }
            if (this.f796a != null && m564b()) {
                jbVar.a(f63778b);
                this.f796a.b(jbVar);
                jbVar.b();
            }
            if (this.f799b != null) {
                jbVar.a(f63779c);
                jbVar.a(this.f799b);
                jbVar.b();
            }
            if (this.f800c != null && d()) {
                jbVar.a(f63780d);
                jbVar.a(this.f800c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f63781e);
                jbVar.a(this.f795a);
                jbVar.b();
            }
            if (this.f801d != null && f()) {
                jbVar.a(f63782f);
                jbVar.a(this.f801d);
                jbVar.b();
            }
            if (this.f802e != null && g()) {
                jbVar.a(f63783g);
                jbVar.a(this.f802e);
                jbVar.b();
            }
            if (this.f803f != null && h()) {
                jbVar.a(f63784h);
                jbVar.a(this.f803f);
                jbVar.b();
            }
            if (this.f804g != null && i()) {
                jbVar.a(f63785i);
                jbVar.a(this.f804g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m580a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m564b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f796a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f804g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m565c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f799b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f800c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f798a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof io)) {
                return m563a((io) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f801d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f802e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f803f != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f804g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
            boolean z2 = false;
            if (m562a()) {
                sb.append("debug:");
                String str = this.f797a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m564b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f796a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f799b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f800c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f795a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f801d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f802e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f803f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f804g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
