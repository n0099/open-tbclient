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
/* loaded from: classes10.dex */
public class ex implements iq<ex, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77603a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f347a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77604b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77605c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77606d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77607e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77608f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77609g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77610h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77611i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77612j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte f348a;

    /* renamed from: a  reason: collision with other field name */
    public int f349a;

    /* renamed from: a  reason: collision with other field name */
    public String f350a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f351a;

    /* renamed from: b  reason: collision with other field name */
    public int f352b;

    /* renamed from: b  reason: collision with other field name */
    public String f353b;

    /* renamed from: c  reason: collision with other field name */
    public int f354c;

    /* renamed from: c  reason: collision with other field name */
    public String f355c;

    /* renamed from: d  reason: collision with other field name */
    public int f356d;

    /* renamed from: d  reason: collision with other field name */
    public String f357d;

    /* renamed from: e  reason: collision with other field name */
    public int f358e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375315, "Lcom/xiaomi/push/ex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375315, "Lcom/xiaomi/push/ex;");
                return;
            }
        }
        f347a = new jg("StatsEvent");
        f77603a = new iy("", (byte) 3, (short) 1);
        f77604b = new iy("", (byte) 8, (short) 2);
        f77605c = new iy("", (byte) 8, (short) 3);
        f77606d = new iy("", (byte) 11, (short) 4);
        f77607e = new iy("", (byte) 11, (short) 5);
        f77608f = new iy("", (byte) 8, (short) 6);
        f77609g = new iy("", (byte) 11, (short) 7);
        f77610h = new iy("", (byte) 11, (short) 8);
        f77611i = new iy("", (byte) 8, (short) 9);
        f77612j = new iy("", (byte) 8, (short) 10);
    }

    public ex() {
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
        this.f351a = new BitSet(6);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ex exVar) {
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
        int a11;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, exVar)) == null) {
            if (ex.class.equals(exVar.getClass())) {
                int compareTo = Boolean.valueOf(m301a()).compareTo(Boolean.valueOf(exVar.m301a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m301a() || (a11 = ir.a(this.f348a, exVar.f348a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(exVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = ir.a(this.f349a, exVar.f349a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(exVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = ir.a(this.f352b, exVar.f352b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(exVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f350a, exVar.f350a)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(exVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f353b, exVar.f353b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(exVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f354c, exVar.f354c)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(exVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f355c, exVar.f355c)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(exVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f357d, exVar.f357d)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(exVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f356d, exVar.f356d)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(exVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f358e, exVar.f358e)) == 0) {
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
                return a11;
            }
            return ex.class.getName().compareTo(exVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ex a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) {
            this.f348a = b2;
            a(true);
            return this;
        }
        return (ex) invokeB.objValue;
    }

    public ex a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f349a = i2;
            b(true);
            return this;
        }
        return (ex) invokeI.objValue;
    }

    public ex a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f350a = str;
            return this;
        }
        return (ex) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f350a == null) {
            throw new jc("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78036a;
            if (b2 == 0) {
                jbVar.f();
                if (!m301a()) {
                    throw new jc("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new jc("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new jc("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 3) {
                        this.f348a = jbVar.a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f349a = jbVar.m521a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f352b = jbVar.m521a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f350a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f353b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f354c = jbVar.m521a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f355c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f357d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f356d = jbVar.m521a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f358e = jbVar.m521a();
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
            this.f351a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m301a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f351a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m302a(ex exVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exVar)) == null) {
            if (exVar != null && this.f348a == exVar.f348a && this.f349a == exVar.f349a && this.f352b == exVar.f352b) {
                boolean d2 = d();
                boolean d3 = exVar.d();
                if ((d2 || d3) && !(d2 && d3 && this.f350a.equals(exVar.f350a))) {
                    return false;
                }
                boolean e2 = e();
                boolean e3 = exVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f353b.equals(exVar.f353b))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = exVar.f();
                if ((f2 || f3) && !(f2 && f3 && this.f354c == exVar.f354c)) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = exVar.g();
                if ((g2 || g3) && !(g2 && g3 && this.f355c.equals(exVar.f355c))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = exVar.h();
                if ((h2 || h3) && !(h2 && h3 && this.f357d.equals(exVar.f357d))) {
                    return false;
                }
                boolean i2 = i();
                boolean i3 = exVar.i();
                if ((i2 || i3) && !(i2 && i3 && this.f356d == exVar.f356d)) {
                    return false;
                }
                boolean j2 = j();
                boolean j3 = exVar.j();
                if (j2 || j3) {
                    return j2 && j3 && this.f358e == exVar.f358e;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ex b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f352b = i2;
            c(true);
            return this;
        }
        return (ex) invokeI.objValue;
    }

    public ex b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f353b = str;
            return this;
        }
        return (ex) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jbVar) == null) {
            a();
            jbVar.a(f347a);
            jbVar.a(f77603a);
            jbVar.a(this.f348a);
            jbVar.b();
            jbVar.a(f77604b);
            jbVar.a(this.f349a);
            jbVar.b();
            jbVar.a(f77605c);
            jbVar.a(this.f352b);
            jbVar.b();
            if (this.f350a != null) {
                jbVar.a(f77606d);
                jbVar.a(this.f350a);
                jbVar.b();
            }
            if (this.f353b != null && e()) {
                jbVar.a(f77607e);
                jbVar.a(this.f353b);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f77608f);
                jbVar.a(this.f354c);
                jbVar.b();
            }
            if (this.f355c != null && g()) {
                jbVar.a(f77609g);
                jbVar.a(this.f355c);
                jbVar.b();
            }
            if (this.f357d != null && h()) {
                jbVar.a(f77610h);
                jbVar.a(this.f357d);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f77611i);
                jbVar.a(this.f356d);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(f77612j);
                jbVar.a(this.f358e);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f351a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f351a.get(1) : invokeV.booleanValue;
    }

    public ex c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f354c = i2;
            d(true);
            return this;
        }
        return (ex) invokeI.objValue;
    }

    public ex c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f355c = str;
            return this;
        }
        return (ex) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f351a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f351a.get(2) : invokeV.booleanValue;
    }

    public ex d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f356d = i2;
            e(true);
            return this;
        }
        return (ex) invokeI.objValue;
    }

    public ex d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f357d = str;
            return this;
        }
        return (ex) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f351a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f350a != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f351a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f353b != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) {
            if (obj != null && (obj instanceof ex)) {
                return m302a((ex) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f351a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f351a.get(3) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f355c != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f357d != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f351a.get(4) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f351a.get(5) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            StringBuilder sb = new StringBuilder("StatsEvent(");
            sb.append("chid:");
            sb.append((int) this.f348a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            sb.append(this.f349a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("value:");
            sb.append(this.f352b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("connpt:");
            String str = this.f350a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("host:");
                String str2 = this.f353b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subvalue:");
                sb.append(this.f354c);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("annotation:");
                String str3 = this.f355c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("user:");
                String str4 = this.f357d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("time:");
                sb.append(this.f356d);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientIp:");
                sb.append(this.f358e);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
