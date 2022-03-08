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
/* loaded from: classes8.dex */
public class ik implements iq<ik, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f749a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f59905b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f59906c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f59907d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f59908e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f59909f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f59910g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f59911h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f59912i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f750a;

    /* renamed from: a  reason: collision with other field name */
    public hu f751a;

    /* renamed from: a  reason: collision with other field name */
    public String f752a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f753a;

    /* renamed from: b  reason: collision with other field name */
    public String f754b;

    /* renamed from: c  reason: collision with other field name */
    public String f755c;

    /* renamed from: d  reason: collision with other field name */
    public String f756d;

    /* renamed from: e  reason: collision with other field name */
    public String f757e;

    /* renamed from: f  reason: collision with other field name */
    public String f758f;

    /* renamed from: g  reason: collision with other field name */
    public String f759g;

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
        f749a = new jg("XmPushActionSubscriptionResult");
        a = new iy("", (byte) 11, (short) 1);
        f59905b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f59906c = new iy("", (byte) 11, (short) 3);
        f59907d = new iy("", (byte) 11, (short) 4);
        f59908e = new iy("", (byte) 10, (short) 6);
        f59909f = new iy("", (byte) 11, (short) 7);
        f59910g = new iy("", (byte) 11, (short) 8);
        f59911h = new iy("", (byte) 11, (short) 9);
        f59912i = new iy("", (byte) 11, (short) 10);
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
        this.f753a = new BitSet(1);
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
                int compareTo = Boolean.valueOf(m561a()).compareTo(Boolean.valueOf(ikVar.m561a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m561a() || (a10 = ir.a(this.f752a, ikVar.f752a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m563b()).compareTo(Boolean.valueOf(ikVar.m563b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m563b() || (a9 = ir.a(this.f751a, ikVar.f751a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m564c()).compareTo(Boolean.valueOf(ikVar.m564c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m564c() || (a8 = ir.a(this.f754b, ikVar.f754b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = ir.a(this.f755c, ikVar.f755c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = ir.a(this.f750a, ikVar.f750a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = ir.a(this.f756d, ikVar.f756d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = ir.a(this.f757e, ikVar.f757e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = ir.a(this.f758f, ikVar.f758f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = ir.a(this.f759g, ikVar.f759g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f754b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m560a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f754b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m587a();
        while (true) {
            iy m583a = jbVar.m583a();
            byte b2 = m583a.a;
            if (b2 == 0) {
                jbVar.f();
                m560a();
                return;
            }
            switch (m583a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f752a = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f751a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f754b = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f755c = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f750a = jbVar.m582a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f756d = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f757e = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f758f = jbVar.m588a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f759g = jbVar.m588a();
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
            this.f753a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m561a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f752a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m562a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m561a = m561a();
            boolean m561a2 = ikVar.m561a();
            if ((m561a || m561a2) && !(m561a && m561a2 && this.f752a.equals(ikVar.f752a))) {
                return false;
            }
            boolean m563b = m563b();
            boolean m563b2 = ikVar.m563b();
            if ((m563b || m563b2) && !(m563b && m563b2 && this.f751a.m482a(ikVar.f751a))) {
                return false;
            }
            boolean m564c = m564c();
            boolean m564c2 = ikVar.m564c();
            if ((m564c || m564c2) && !(m564c && m564c2 && this.f754b.equals(ikVar.f754b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f755c.equals(ikVar.f755c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ikVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f750a == ikVar.f750a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f756d.equals(ikVar.f756d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f757e.equals(ikVar.f757e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f758f.equals(ikVar.f758f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f759g.equals(ikVar.f759g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f757e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m560a();
            jbVar.a(f749a);
            if (this.f752a != null && m561a()) {
                jbVar.a(a);
                jbVar.a(this.f752a);
                jbVar.b();
            }
            if (this.f751a != null && m563b()) {
                jbVar.a(f59905b);
                this.f751a.b(jbVar);
                jbVar.b();
            }
            if (this.f754b != null) {
                jbVar.a(f59906c);
                jbVar.a(this.f754b);
                jbVar.b();
            }
            if (this.f755c != null && d()) {
                jbVar.a(f59907d);
                jbVar.a(this.f755c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f59908e);
                jbVar.a(this.f750a);
                jbVar.b();
            }
            if (this.f756d != null && f()) {
                jbVar.a(f59909f);
                jbVar.a(this.f756d);
                jbVar.b();
            }
            if (this.f757e != null && g()) {
                jbVar.a(f59910g);
                jbVar.a(this.f757e);
                jbVar.b();
            }
            if (this.f758f != null && h()) {
                jbVar.a(f59911h);
                jbVar.a(this.f758f);
                jbVar.b();
            }
            if (this.f759g != null && i()) {
                jbVar.a(f59912i);
                jbVar.a(this.f759g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m591a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m563b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f751a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f759g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m564c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f754b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f755c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f753a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m562a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f756d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f757e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f758f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f759g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
            boolean z2 = false;
            if (m561a()) {
                sb.append("debug:");
                String str = this.f752a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m563b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f751a;
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
            String str2 = this.f754b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f755c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f750a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f756d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f757e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f758f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f759g;
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
