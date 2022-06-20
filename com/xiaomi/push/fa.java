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
public class fa implements iu<fa, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f329a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte f330a;

    /* renamed from: a  reason: collision with other field name */
    public int f331a;

    /* renamed from: a  reason: collision with other field name */
    public String f332a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f333a;

    /* renamed from: b  reason: collision with other field name */
    public int f334b;

    /* renamed from: b  reason: collision with other field name */
    public String f335b;

    /* renamed from: c  reason: collision with other field name */
    public int f336c;

    /* renamed from: c  reason: collision with other field name */
    public String f337c;

    /* renamed from: d  reason: collision with other field name */
    public int f338d;

    /* renamed from: d  reason: collision with other field name */
    public String f339d;

    /* renamed from: e  reason: collision with other field name */
    public int f340e;

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
        f329a = new jk("StatsEvent");
        a = new jc("", (byte) 3, (short) 1);
        b = new jc("", (byte) 8, (short) 2);
        c = new jc("", (byte) 8, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 8, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new jc("", (byte) 8, (short) 9);
        j = new jc("", (byte) 8, (short) 10);
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
        this.f333a = new BitSet(6);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fa faVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, faVar)) == null) {
            if (fa.class.equals(faVar.getClass())) {
                int compareTo = Boolean.valueOf(m317a()).compareTo(Boolean.valueOf(faVar.m317a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m317a() || (a11 = iv.a(this.f330a, faVar.f330a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(faVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = iv.a(this.f331a, faVar.f331a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(faVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = iv.a(this.f334b, faVar.f334b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(faVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f332a, faVar.f332a)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(faVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f335b, faVar.f335b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(faVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f336c, faVar.f336c)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(faVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f337c, faVar.f337c)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(faVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f339d, faVar.f339d)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(faVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f338d, faVar.f338d)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(faVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f340e, faVar.f340e)) == 0) {
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
            return fa.class.getName().compareTo(faVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public fa a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) {
            this.f330a = b2;
            a(true);
            return this;
        }
        return (fa) invokeB.objValue;
    }

    public fa a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.f331a = i2;
            b(true);
            return this;
        }
        return (fa) invokeI.objValue;
    }

    public fa a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f332a = str;
            return this;
        }
        return (fa) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f332a == null) {
            throw new jg("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jfVar) != null) {
            return;
        }
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                if (!m317a()) {
                    throw new jg("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!b()) {
                    throw new jg("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (c()) {
                    a();
                    return;
                } else {
                    throw new jg("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (m540a.f802a) {
                case 1:
                    if (b2 == 3) {
                        this.f330a = jfVar.a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f331a = jfVar.m538a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f334b = jfVar.m538a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f332a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f335b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f336c = jfVar.m538a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f337c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f339d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f338d = jfVar.m538a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f340e = jfVar.m538a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f333a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m317a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f333a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m318a(fa faVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, faVar)) == null) {
            if (faVar != null && this.f330a == faVar.f330a && this.f331a == faVar.f331a && this.f334b == faVar.f334b) {
                boolean d2 = d();
                boolean d3 = faVar.d();
                if ((d2 || d3) && !(d2 && d3 && this.f332a.equals(faVar.f332a))) {
                    return false;
                }
                boolean e2 = e();
                boolean e3 = faVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f335b.equals(faVar.f335b))) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = faVar.f();
                if ((f2 || f3) && !(f2 && f3 && this.f336c == faVar.f336c)) {
                    return false;
                }
                boolean g2 = g();
                boolean g3 = faVar.g();
                if ((g2 || g3) && !(g2 && g3 && this.f337c.equals(faVar.f337c))) {
                    return false;
                }
                boolean h2 = h();
                boolean h3 = faVar.h();
                if ((h2 || h3) && !(h2 && h3 && this.f339d.equals(faVar.f339d))) {
                    return false;
                }
                boolean i2 = i();
                boolean i3 = faVar.i();
                if ((i2 || i3) && !(i2 && i3 && this.f338d == faVar.f338d)) {
                    return false;
                }
                boolean j2 = j();
                boolean j3 = faVar.j();
                if (j2 || j3) {
                    return j2 && j3 && this.f340e == faVar.f340e;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public fa b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.f334b = i2;
            c(true);
            return this;
        }
        return (fa) invokeI.objValue;
    }

    public fa b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f335b = str;
            return this;
        }
        return (fa) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jfVar) == null) {
            a();
            jfVar.a(f329a);
            jfVar.a(a);
            jfVar.a(this.f330a);
            jfVar.b();
            jfVar.a(b);
            jfVar.a(this.f331a);
            jfVar.b();
            jfVar.a(c);
            jfVar.a(this.f334b);
            jfVar.b();
            if (this.f332a != null) {
                jfVar.a(d);
                jfVar.a(this.f332a);
                jfVar.b();
            }
            if (this.f335b != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f335b);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f336c);
                jfVar.b();
            }
            if (this.f337c != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f337c);
                jfVar.b();
            }
            if (this.f339d != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f339d);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f338d);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f340e);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f333a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f333a.get(1) : invokeV.booleanValue;
    }

    public fa c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.f336c = i2;
            d(true);
            return this;
        }
        return (fa) invokeI.objValue;
    }

    public fa c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f337c = str;
            return this;
        }
        return (fa) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f333a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f333a.get(2) : invokeV.booleanValue;
    }

    public fa d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f338d = i2;
            e(true);
            return this;
        }
        return (fa) invokeI.objValue;
    }

    public fa d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f339d = str;
            return this;
        }
        return (fa) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.f333a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f332a != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f333a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f335b != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) {
            if (obj != null && (obj instanceof fa)) {
                return m318a((fa) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.f333a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f333a.get(3) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f337c != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f339d != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f333a.get(4) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f333a.get(5) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            StringBuilder sb = new StringBuilder("StatsEvent(");
            sb.append("chid:");
            sb.append((int) this.f330a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("type:");
            sb.append(this.f331a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("value:");
            sb.append(this.f334b);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("connpt:");
            String str = this.f332a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("host:");
                String str2 = this.f335b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("subvalue:");
                sb.append(this.f336c);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("annotation:");
                String str3 = this.f337c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("user:");
                String str4 = this.f339d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("time:");
                sb.append(this.f338d);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientIp:");
                sb.append(this.f340e);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
