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
/* loaded from: classes10.dex */
public class ik implements iq<ik, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77798a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f748a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77799b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77800c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77801d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77802e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77803f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77804g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77805h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77806i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f749a;

    /* renamed from: a  reason: collision with other field name */
    public hu f750a;

    /* renamed from: a  reason: collision with other field name */
    public String f751a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f752a;

    /* renamed from: b  reason: collision with other field name */
    public String f753b;

    /* renamed from: c  reason: collision with other field name */
    public String f754c;

    /* renamed from: d  reason: collision with other field name */
    public String f755d;

    /* renamed from: e  reason: collision with other field name */
    public String f756e;

    /* renamed from: f  reason: collision with other field name */
    public String f757f;

    /* renamed from: g  reason: collision with other field name */
    public String f758g;

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
        f748a = new jg("XmPushActionSubscriptionResult");
        f77798a = new iy("", (byte) 11, (short) 1);
        f77799b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f77800c = new iy("", (byte) 11, (short) 3);
        f77801d = new iy("", (byte) 11, (short) 4);
        f77802e = new iy("", (byte) 10, (short) 6);
        f77803f = new iy("", (byte) 11, (short) 7);
        f77804g = new iy("", (byte) 11, (short) 8);
        f77805h = new iy("", (byte) 11, (short) 9);
        f77806i = new iy("", (byte) 11, (short) 10);
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
        this.f752a = new BitSet(1);
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
                int compareTo = Boolean.valueOf(m501a()).compareTo(Boolean.valueOf(ikVar.m501a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m501a() || (a10 = ir.a(this.f751a, ikVar.f751a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m503b()).compareTo(Boolean.valueOf(ikVar.m503b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m503b() || (a9 = ir.a(this.f750a, ikVar.f750a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m504c()).compareTo(Boolean.valueOf(ikVar.m504c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m504c() || (a8 = ir.a(this.f753b, ikVar.f753b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f754c, ikVar.f754c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f749a, ikVar.f749a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f755d, ikVar.f755d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f756e, ikVar.f756e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f757f, ikVar.f757f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f758g, ikVar.f758g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f753b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m500a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f753b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f77856a;
            if (b2 == 0) {
                jbVar.f();
                m500a();
                return;
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f751a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f750a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f753b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f754c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f749a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f755d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f756e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f757f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f758g = jbVar.m528a();
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
            this.f752a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m501a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f751a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m502a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m501a = m501a();
            boolean m501a2 = ikVar.m501a();
            if ((m501a || m501a2) && !(m501a && m501a2 && this.f751a.equals(ikVar.f751a))) {
                return false;
            }
            boolean m503b = m503b();
            boolean m503b2 = ikVar.m503b();
            if ((m503b || m503b2) && !(m503b && m503b2 && this.f750a.m422a(ikVar.f750a))) {
                return false;
            }
            boolean m504c = m504c();
            boolean m504c2 = ikVar.m504c();
            if ((m504c || m504c2) && !(m504c && m504c2 && this.f753b.equals(ikVar.f753b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f754c.equals(ikVar.f754c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ikVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f749a == ikVar.f749a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f755d.equals(ikVar.f755d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f756e.equals(ikVar.f756e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f757f.equals(ikVar.f757f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f758g.equals(ikVar.f758g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f756e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m500a();
            jbVar.a(f748a);
            if (this.f751a != null && m501a()) {
                jbVar.a(f77798a);
                jbVar.a(this.f751a);
                jbVar.b();
            }
            if (this.f750a != null && m503b()) {
                jbVar.a(f77799b);
                this.f750a.b(jbVar);
                jbVar.b();
            }
            if (this.f753b != null) {
                jbVar.a(f77800c);
                jbVar.a(this.f753b);
                jbVar.b();
            }
            if (this.f754c != null && d()) {
                jbVar.a(f77801d);
                jbVar.a(this.f754c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f77802e);
                jbVar.a(this.f749a);
                jbVar.b();
            }
            if (this.f755d != null && f()) {
                jbVar.a(f77803f);
                jbVar.a(this.f755d);
                jbVar.b();
            }
            if (this.f756e != null && g()) {
                jbVar.a(f77804g);
                jbVar.a(this.f756e);
                jbVar.b();
            }
            if (this.f757f != null && h()) {
                jbVar.a(f77805h);
                jbVar.a(this.f757f);
                jbVar.b();
            }
            if (this.f758g != null && i()) {
                jbVar.a(f77806i);
                jbVar.a(this.f758g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m503b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f750a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f758g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m504c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f753b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f754c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f752a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m502a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f755d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f756e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f757f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f758g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
            boolean z2 = false;
            if (m501a()) {
                sb.append("debug:");
                String str = this.f751a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m503b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f750a;
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
            String str2 = this.f753b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f754c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f749a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f755d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f756e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f757f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f758g;
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
