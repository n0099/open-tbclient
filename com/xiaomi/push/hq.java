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

    /* renamed from: a  reason: collision with root package name */
    public static final iy f43296a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f510a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f43297b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f43298c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f43299d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f43300e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f43301f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f43302g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f511a;

    /* renamed from: a  reason: collision with other field name */
    public long f512a;

    /* renamed from: a  reason: collision with other field name */
    public String f513a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f514a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f515a;

    /* renamed from: b  reason: collision with other field name */
    public int f516b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f517b;

    /* renamed from: c  reason: collision with other field name */
    public int f518c;

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
        f510a = new jg("OnlineConfigItem");
        f43296a = new iy("", (byte) 8, (short) 1);
        f43297b = new iy("", (byte) 8, (short) 2);
        f43298c = new iy("", (byte) 2, (short) 3);
        f43299d = new iy("", (byte) 8, (short) 4);
        f43300e = new iy("", (byte) 10, (short) 5);
        f43301f = new iy("", (byte) 11, (short) 6);
        f43302g = new iy("", (byte) 2, (short) 7);
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
        this.f514a = new BitSet(6);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f511a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m395a()).compareTo(Boolean.valueOf(hqVar.m395a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m395a() || (a8 = ir.a(this.f511a, hqVar.f511a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m397b()).compareTo(Boolean.valueOf(hqVar.m397b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m397b() || (a7 = ir.a(this.f516b, hqVar.f516b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m398c()).compareTo(Boolean.valueOf(hqVar.m398c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m398c() || (a6 = ir.a(this.f515a, hqVar.f515a)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hqVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = ir.a(this.f518c, hqVar.f518c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hqVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = ir.a(this.f512a, hqVar.f512a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hqVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = ir.a(this.f513a, hqVar.f513a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hqVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a2 = ir.a(this.f517b, hqVar.f517b)) == 0) {
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
    public long m392a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f512a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m393a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f513a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m394a() {
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
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f43494a;
            if (b2 == 0) {
                jbVar.f();
                m394a();
                return;
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 8) {
                        this.f511a = jbVar.m518a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f516b = jbVar.m518a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f515a = jbVar.m529a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f518c = jbVar.m518a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f512a = jbVar.m519a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f513a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f517b = jbVar.m529a();
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
            this.f514a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m395a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f514a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m396a(hq hqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hqVar)) == null) {
            if (hqVar == null) {
                return false;
            }
            boolean m395a = m395a();
            boolean m395a2 = hqVar.m395a();
            if ((m395a || m395a2) && !(m395a && m395a2 && this.f511a == hqVar.f511a)) {
                return false;
            }
            boolean m397b = m397b();
            boolean m397b2 = hqVar.m397b();
            if ((m397b || m397b2) && !(m397b && m397b2 && this.f516b == hqVar.f516b)) {
                return false;
            }
            boolean m398c = m398c();
            boolean m398c2 = hqVar.m398c();
            if ((m398c || m398c2) && !(m398c && m398c2 && this.f515a == hqVar.f515a)) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hqVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f518c == hqVar.f518c)) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hqVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f512a == hqVar.f512a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hqVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f513a.equals(hqVar.f513a))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hqVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f517b == hqVar.f517b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f516b : invokeV.intValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            m394a();
            jbVar.a(f510a);
            if (m395a()) {
                jbVar.a(f43296a);
                jbVar.a(this.f511a);
                jbVar.b();
            }
            if (m397b()) {
                jbVar.a(f43297b);
                jbVar.a(this.f516b);
                jbVar.b();
            }
            if (m398c()) {
                jbVar.a(f43298c);
                jbVar.a(this.f515a);
                jbVar.b();
            }
            if (d()) {
                jbVar.a(f43299d);
                jbVar.a(this.f518c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f43300e);
                jbVar.a(this.f512a);
                jbVar.b();
            }
            if (this.f513a != null && f()) {
                jbVar.a(f43301f);
                jbVar.a(this.f513a);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f43302g);
                jbVar.a(this.f517b);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f514a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m397b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f514a.get(1) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f518c : invokeV.intValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f514a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m398c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f514a.get(2) : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f514a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f514a.get(3) : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f514a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f514a.get(4) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof hq)) {
                return m396a((hq) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f514a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f513a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f517b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f514a.get(5) : invokeV.booleanValue;
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
            if (m395a()) {
                sb.append("key:");
                sb.append(this.f511a);
                z = false;
            } else {
                z = true;
            }
            if (m397b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("type:");
                sb.append(this.f516b);
                z = false;
            }
            if (m398c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("clear:");
                sb.append(this.f515a);
                z = false;
            }
            if (d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("intValue:");
                sb.append(this.f518c);
                z = false;
            }
            if (e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("longValue:");
                sb.append(this.f512a);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("stringValue:");
                String str = this.f513a;
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
                sb.append(this.f517b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
