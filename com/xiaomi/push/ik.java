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
/* loaded from: classes6.dex */
public class ik implements iq<ik, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40451a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f744a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40452b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40453c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40454d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40455e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40456f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40457g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40458h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f40459i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f745a;

    /* renamed from: a  reason: collision with other field name */
    public hu f746a;

    /* renamed from: a  reason: collision with other field name */
    public String f747a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f748a;

    /* renamed from: b  reason: collision with other field name */
    public String f749b;

    /* renamed from: c  reason: collision with other field name */
    public String f750c;

    /* renamed from: d  reason: collision with other field name */
    public String f751d;

    /* renamed from: e  reason: collision with other field name */
    public String f752e;

    /* renamed from: f  reason: collision with other field name */
    public String f753f;

    /* renamed from: g  reason: collision with other field name */
    public String f754g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371874, "Lcom/xiaomi/push/ik;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371874, "Lcom/xiaomi/push/ik;");
                return;
            }
        }
        f744a = new jg("XmPushActionSubscriptionResult");
        f40451a = new iy("", (byte) 11, (short) 1);
        f40452b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f40453c = new iy("", (byte) 11, (short) 3);
        f40454d = new iy("", (byte) 11, (short) 4);
        f40455e = new iy("", (byte) 10, (short) 6);
        f40456f = new iy("", (byte) 11, (short) 7);
        f40457g = new iy("", (byte) 11, (short) 8);
        f40458h = new iy("", (byte) 11, (short) 9);
        f40459i = new iy("", (byte) 11, (short) 10);
    }

    public ik() {
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
        this.f748a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ikVar)) == null) {
            if (ik.class.equals(ikVar.getClass())) {
                int compareTo = Boolean.valueOf(m498a()).compareTo(Boolean.valueOf(ikVar.m498a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m498a() || (a10 = ir.a(this.f747a, ikVar.f747a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m500b()).compareTo(Boolean.valueOf(ikVar.m500b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m500b() || (a9 = ir.a(this.f746a, ikVar.f746a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m501c()).compareTo(Boolean.valueOf(ikVar.m501c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m501c() || (a8 = ir.a(this.f749b, ikVar.f749b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f750c, ikVar.f750c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f745a, ikVar.f745a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f751d, ikVar.f751d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f752e, ikVar.f752e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f753f, ikVar.f753f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f754g, ikVar.f754g)) == 0) {
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
            return ik.class.getName().compareTo(ikVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f749b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m497a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f749b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40508a;
            if (b2 == 0) {
                jbVar.f();
                m497a();
                return;
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f747a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f746a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f749b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f750c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f745a = jbVar.m519a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f751d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f752e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f753f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f754g = jbVar.m525a();
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
            this.f748a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m498a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f747a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m499a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m498a = m498a();
            boolean m498a2 = ikVar.m498a();
            if ((m498a || m498a2) && !(m498a && m498a2 && this.f747a.equals(ikVar.f747a))) {
                return false;
            }
            boolean m500b = m500b();
            boolean m500b2 = ikVar.m500b();
            if ((m500b || m500b2) && !(m500b && m500b2 && this.f746a.m419a(ikVar.f746a))) {
                return false;
            }
            boolean m501c = m501c();
            boolean m501c2 = ikVar.m501c();
            if ((m501c || m501c2) && !(m501c && m501c2 && this.f749b.equals(ikVar.f749b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f750c.equals(ikVar.f750c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ikVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f745a == ikVar.f745a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f751d.equals(ikVar.f751d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f752e.equals(ikVar.f752e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f753f.equals(ikVar.f753f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f754g.equals(ikVar.f754g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f752e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m497a();
            jbVar.a(f744a);
            if (this.f747a != null && m498a()) {
                jbVar.a(f40451a);
                jbVar.a(this.f747a);
                jbVar.b();
            }
            if (this.f746a != null && m500b()) {
                jbVar.a(f40452b);
                this.f746a.b(jbVar);
                jbVar.b();
            }
            if (this.f749b != null) {
                jbVar.a(f40453c);
                jbVar.a(this.f749b);
                jbVar.b();
            }
            if (this.f750c != null && d()) {
                jbVar.a(f40454d);
                jbVar.a(this.f750c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f40455e);
                jbVar.a(this.f745a);
                jbVar.b();
            }
            if (this.f751d != null && f()) {
                jbVar.a(f40456f);
                jbVar.a(this.f751d);
                jbVar.b();
            }
            if (this.f752e != null && g()) {
                jbVar.a(f40457g);
                jbVar.a(this.f752e);
                jbVar.b();
            }
            if (this.f753f != null && h()) {
                jbVar.a(f40458h);
                jbVar.a(this.f753f);
                jbVar.b();
            }
            if (this.f754g != null && i()) {
                jbVar.a(f40459i);
                jbVar.a(this.f754g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m500b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f746a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f754g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m501c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f749b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f750c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f748a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m499a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f751d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f752e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f753f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f754g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
            boolean z2 = false;
            if (m498a()) {
                sb.append("debug:");
                String str = this.f747a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m500b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f746a;
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
            String str2 = this.f749b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f750c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f745a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f751d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f752e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f753f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f754g;
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
