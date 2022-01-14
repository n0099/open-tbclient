package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes4.dex */
public class hq implements iq<hq, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f515a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61213b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61214c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61215d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61216e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61217f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61218g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f516a;

    /* renamed from: a  reason: collision with other field name */
    public long f517a;

    /* renamed from: a  reason: collision with other field name */
    public String f518a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f519a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f520a;

    /* renamed from: b  reason: collision with other field name */
    public int f521b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f522b;

    /* renamed from: c  reason: collision with other field name */
    public int f523c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372649, "Lcom/xiaomi/push/hq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372649, "Lcom/xiaomi/push/hq;");
                return;
            }
        }
        f515a = new jg("OnlineConfigItem");
        a = new iy("", (byte) 8, (short) 1);
        f61213b = new iy("", (byte) 8, (short) 2);
        f61214c = new iy("", (byte) 2, (short) 3);
        f61215d = new iy("", (byte) 8, (short) 4);
        f61216e = new iy("", (byte) 10, (short) 5);
        f61217f = new iy("", (byte) 11, (short) 6);
        f61218g = new iy("", (byte) 2, (short) 7);
    }

    public hq() {
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
        this.f519a = new BitSet(6);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f516a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hq hqVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hqVar)) == null) {
            if (hq.class.equals(hqVar.getClass())) {
                int compareTo = Boolean.valueOf(m459a()).compareTo(Boolean.valueOf(hqVar.m459a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m459a() || (a8 = ir.a(this.f516a, hqVar.f516a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m461b()).compareTo(Boolean.valueOf(hqVar.m461b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m461b() || (a7 = ir.a(this.f521b, hqVar.f521b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m462c()).compareTo(Boolean.valueOf(hqVar.m462c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m462c() || (a6 = ir.a(this.f520a, hqVar.f520a)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hqVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = ir.a(this.f523c, hqVar.f523c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = ir.a(this.f517a, hqVar.f517a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = ir.a(this.f518a, hqVar.f518a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a2 = ir.a(this.f522b, hqVar.f522b)) == 0) {
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
            return hq.class.getName().compareTo(hqVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m456a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f517a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m457a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f518a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m458a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jbVar) != null) {
            return;
        }
        jbVar.m588a();
        while (true) {
            iy m584a = jbVar.m584a();
            byte b2 = m584a.a;
            if (b2 == 0) {
                jbVar.f();
                m458a();
                return;
            }
            switch (m584a.f815a) {
                case 1:
                    if (b2 == 8) {
                        this.f516a = jbVar.m582a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f521b = jbVar.m582a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f520a = jbVar.m593a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f523c = jbVar.m582a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f517a = jbVar.m583a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f518a = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f522b = jbVar.m593a();
                        f(true);
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
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f519a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m459a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f519a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m460a(hq hqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hqVar)) == null) {
            if (hqVar == null) {
                return false;
            }
            boolean m459a = m459a();
            boolean m459a2 = hqVar.m459a();
            if ((m459a || m459a2) && !(m459a && m459a2 && this.f516a == hqVar.f516a)) {
                return false;
            }
            boolean m461b = m461b();
            boolean m461b2 = hqVar.m461b();
            if ((m461b || m461b2) && !(m461b && m461b2 && this.f521b == hqVar.f521b)) {
                return false;
            }
            boolean m462c = m462c();
            boolean m462c2 = hqVar.m462c();
            if ((m462c || m462c2) && !(m462c && m462c2 && this.f520a == hqVar.f520a)) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hqVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f523c == hqVar.f523c)) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hqVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f517a == hqVar.f517a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hqVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f518a.equals(hqVar.f518a))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hqVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f522b == hqVar.f522b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f521b : invokeV.intValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            m458a();
            jbVar.a(f515a);
            if (m459a()) {
                jbVar.a(a);
                jbVar.a(this.f516a);
                jbVar.b();
            }
            if (m461b()) {
                jbVar.a(f61213b);
                jbVar.a(this.f521b);
                jbVar.b();
            }
            if (m462c()) {
                jbVar.a(f61214c);
                jbVar.a(this.f520a);
                jbVar.b();
            }
            if (d()) {
                jbVar.a(f61215d);
                jbVar.a(this.f523c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f61216e);
                jbVar.a(this.f517a);
                jbVar.b();
            }
            if (this.f518a != null && f()) {
                jbVar.a(f61217f);
                jbVar.a(this.f518a);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f61218g);
                jbVar.a(this.f522b);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f519a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m461b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f519a.get(1) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f523c : invokeV.intValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f519a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m462c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f519a.get(2) : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f519a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f519a.get(3) : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f519a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f519a.get(4) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof hq)) {
                return m460a((hq) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f519a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f518a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f522b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f519a.get(5) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            StringBuilder sb = new StringBuilder("OnlineConfigItem(");
            boolean z2 = false;
            if (m459a()) {
                sb.append("key:");
                sb.append(this.f516a);
                z = false;
            } else {
                z = true;
            }
            if (m461b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("type:");
                sb.append(this.f521b);
                z = false;
            }
            if (m462c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("clear:");
                sb.append(this.f520a);
                z = false;
            }
            if (d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("intValue:");
                sb.append(this.f523c);
                z = false;
            }
            if (e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("longValue:");
                sb.append(this.f517a);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("stringValue:");
                String str = this.f518a;
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                sb.append(str);
            } else {
                z2 = z;
            }
            if (h()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("boolValue:");
                sb.append(this.f522b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
