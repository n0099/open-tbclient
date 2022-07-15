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
public class hu implements iu<hu, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1226a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f1227a;

    /* renamed from: a  reason: collision with other field name */
    public long f1228a;

    /* renamed from: a  reason: collision with other field name */
    public String f1229a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1230a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1231a;

    /* renamed from: b  reason: collision with other field name */
    public int f1232b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1233b;

    /* renamed from: c  reason: collision with other field name */
    public int f1234c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372525, "Lcom/xiaomi/push/hu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372525, "Lcom/xiaomi/push/hu;");
                return;
            }
        }
        f1226a = new jk("OnlineConfigItem");
        a = new jc("", (byte) 8, (short) 1);
        b = new jc("", (byte) 8, (short) 2);
        c = new jc("", (byte) 2, (short) 3);
        d = new jc("", (byte) 8, (short) 4);
        e = new jc("", (byte) 10, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", (byte) 2, (short) 7);
    }

    public hu() {
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
        this.f1230a = new BitSet(6);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1227a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, huVar)) == null) {
            if (hu.class.equals(huVar.getClass())) {
                int compareTo = Boolean.valueOf(m1357a()).compareTo(Boolean.valueOf(huVar.m1357a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1357a() || (a8 = iv.a(this.f1227a, huVar.f1227a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1359b()).compareTo(Boolean.valueOf(huVar.m1359b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1359b() || (a7 = iv.a(this.f1232b, huVar.f1232b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1360c()).compareTo(Boolean.valueOf(huVar.m1360c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1360c() || (a6 = iv.a(this.f1231a, huVar.f1231a)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a5 = iv.a(this.f1234c, huVar.f1234c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a4 = iv.a(this.f1228a, huVar.f1228a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a3 = iv.a(this.f1229a, huVar.f1229a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!h() || (a2 = iv.a(this.f1233b, huVar.f1233b)) == 0) {
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
            return hu.class.getName().compareTo(huVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m1354a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1228a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1355a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1229a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1356a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1356a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 8) {
                        this.f1227a = jfVar.m1481a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f1232b = jfVar.m1481a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f1231a = jfVar.m1492a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f1234c = jfVar.m1481a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f1228a = jfVar.m1482a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f1229a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f1233b = jfVar.m1492a();
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
            this.f1230a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1357a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1230a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1358a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, huVar)) == null) {
            if (huVar == null) {
                return false;
            }
            boolean m1357a = m1357a();
            boolean m1357a2 = huVar.m1357a();
            if ((m1357a || m1357a2) && !(m1357a && m1357a2 && this.f1227a == huVar.f1227a)) {
                return false;
            }
            boolean m1359b = m1359b();
            boolean m1359b2 = huVar.m1359b();
            if ((m1359b || m1359b2) && !(m1359b && m1359b2 && this.f1232b == huVar.f1232b)) {
                return false;
            }
            boolean m1360c = m1360c();
            boolean m1360c2 = huVar.m1360c();
            if ((m1360c || m1360c2) && !(m1360c && m1360c2 && this.f1231a == huVar.f1231a)) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = huVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1234c == huVar.f1234c)) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = huVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1228a == huVar.f1228a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = huVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1229a.equals(huVar.f1229a))) {
                return false;
            }
            boolean h = h();
            boolean h2 = huVar.h();
            if (h || h2) {
                return h && h2 && this.f1233b == huVar.f1233b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1232b : invokeV.intValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m1356a();
            jfVar.a(f1226a);
            if (m1357a()) {
                jfVar.a(a);
                jfVar.a(this.f1227a);
                jfVar.b();
            }
            if (m1359b()) {
                jfVar.a(b);
                jfVar.a(this.f1232b);
                jfVar.b();
            }
            if (m1360c()) {
                jfVar.a(c);
                jfVar.a(this.f1231a);
                jfVar.b();
            }
            if (d()) {
                jfVar.a(d);
                jfVar.a(this.f1234c);
                jfVar.b();
            }
            if (e()) {
                jfVar.a(e);
                jfVar.a(this.f1228a);
                jfVar.b();
            }
            if (this.f1229a != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1229a);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(g);
                jfVar.a(this.f1233b);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f1230a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1359b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1230a.get(1) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1234c : invokeV.intValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f1230a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1360c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1230a.get(2) : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f1230a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1230a.get(3) : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f1230a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1230a.get(4) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof hu)) {
                return m1358a((hu) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f1230a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1229a != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1233b : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1230a.get(5) : invokeV.booleanValue;
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
            if (m1357a()) {
                sb.append("key:");
                sb.append(this.f1227a);
                z = false;
            } else {
                z = true;
            }
            if (m1359b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("type:");
                sb.append(this.f1232b);
                z = false;
            }
            if (m1360c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("clear:");
                sb.append(this.f1231a);
                z = false;
            }
            if (d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("intValue:");
                sb.append(this.f1234c);
                z = false;
            }
            if (e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("longValue:");
                sb.append(this.f1228a);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("stringValue:");
                String str = this.f1229a;
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
                sb.append(this.f1233b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
