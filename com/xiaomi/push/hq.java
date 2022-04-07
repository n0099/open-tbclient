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
/* loaded from: classes8.dex */
public class hq implements iq<hq, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f491a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f492a;

    /* renamed from: a  reason: collision with other field name */
    public long f493a;

    /* renamed from: a  reason: collision with other field name */
    public String f494a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f495a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f496a;

    /* renamed from: b  reason: collision with other field name */
    public int f497b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f498b;

    /* renamed from: c  reason: collision with other field name */
    public int f499c;

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
        f491a = new jg("OnlineConfigItem");
        a = new iy("", (byte) 8, (short) 1);
        b = new iy("", (byte) 8, (short) 2);
        c = new iy("", (byte) 2, (short) 3);
        d = new iy("", (byte) 8, (short) 4);
        e = new iy("", (byte) 10, (short) 5);
        f = new iy("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new iy("", (byte) 2, (short) 7);
    }

    public hq() {
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
        this.f495a = new BitSet(6);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f492a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(hqVar.m433a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m433a() || (a8 = ir.a(this.f492a, hqVar.f492a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m435b()).compareTo(Boolean.valueOf(hqVar.m435b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m435b() || (a7 = ir.a(this.f497b, hqVar.f497b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m436c()).compareTo(Boolean.valueOf(hqVar.m436c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m436c() || (a6 = ir.a(this.f496a, hqVar.f496a)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hqVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = ir.a(this.f499c, hqVar.f499c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = ir.a(this.f493a, hqVar.f493a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = ir.a(this.f494a, hqVar.f494a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a2 = ir.a(this.f498b, hqVar.f498b)) == 0) {
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
    public long m430a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f493a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m431a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f494a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m432a() {
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
        jbVar.m562a();
        while (true) {
            iy m558a = jbVar.m558a();
            byte b2 = m558a.a;
            if (b2 == 0) {
                jbVar.f();
                m432a();
                return;
            }
            switch (m558a.f791a) {
                case 1:
                    if (b2 == 8) {
                        this.f492a = jbVar.m556a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f497b = jbVar.m556a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f496a = jbVar.m567a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f499c = jbVar.m556a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f493a = jbVar.m557a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f494a = jbVar.m563a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f498b = jbVar.m567a();
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
            this.f495a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f495a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a(hq hqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hqVar)) == null) {
            if (hqVar == null) {
                return false;
            }
            boolean m433a = m433a();
            boolean m433a2 = hqVar.m433a();
            if ((m433a || m433a2) && !(m433a && m433a2 && this.f492a == hqVar.f492a)) {
                return false;
            }
            boolean m435b = m435b();
            boolean m435b2 = hqVar.m435b();
            if ((m435b || m435b2) && !(m435b && m435b2 && this.f497b == hqVar.f497b)) {
                return false;
            }
            boolean m436c = m436c();
            boolean m436c2 = hqVar.m436c();
            if ((m436c || m436c2) && !(m436c && m436c2 && this.f496a == hqVar.f496a)) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hqVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f499c == hqVar.f499c)) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hqVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f493a == hqVar.f493a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hqVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f494a.equals(hqVar.f494a))) {
                return false;
            }
            boolean h = h();
            boolean h2 = hqVar.h();
            if (h || h2) {
                return h && h2 && this.f498b == hqVar.f498b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f497b : invokeV.intValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            m432a();
            jbVar.a(f491a);
            if (m433a()) {
                jbVar.a(a);
                jbVar.a(this.f492a);
                jbVar.b();
            }
            if (m435b()) {
                jbVar.a(b);
                jbVar.a(this.f497b);
                jbVar.b();
            }
            if (m436c()) {
                jbVar.a(c);
                jbVar.a(this.f496a);
                jbVar.b();
            }
            if (d()) {
                jbVar.a(d);
                jbVar.a(this.f499c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(e);
                jbVar.a(this.f493a);
                jbVar.b();
            }
            if (this.f494a != null && f()) {
                jbVar.a(f);
                jbVar.a(this.f494a);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(g);
                jbVar.a(this.f498b);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f495a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m435b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f495a.get(1) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f499c : invokeV.intValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f495a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m436c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f495a.get(2) : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f495a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f495a.get(3) : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f495a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f495a.get(4) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof hq)) {
                return m434a((hq) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f495a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f494a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f498b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f495a.get(5) : invokeV.booleanValue;
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
            if (m433a()) {
                sb.append("key:");
                sb.append(this.f492a);
                z = false;
            } else {
                z = true;
            }
            if (m435b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("type:");
                sb.append(this.f497b);
                z = false;
            }
            if (m436c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("clear:");
                sb.append(this.f496a);
                z = false;
            }
            if (d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("intValue:");
                sb.append(this.f499c);
                z = false;
            }
            if (e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("longValue:");
                sb.append(this.f493a);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("stringValue:");
                String str = this.f494a;
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
                sb.append(this.f498b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
