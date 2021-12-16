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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class hw implements iq<hw, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f591a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f63651b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f63652c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f63653d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f63654e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f63655f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f63656g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f63657h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f63658i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f63659j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f592a;

    /* renamed from: a  reason: collision with other field name */
    public hu f593a;

    /* renamed from: a  reason: collision with other field name */
    public String f594a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f595a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f596a;

    /* renamed from: b  reason: collision with other field name */
    public String f597b;

    /* renamed from: c  reason: collision with other field name */
    public String f598c;

    /* renamed from: d  reason: collision with other field name */
    public String f599d;

    /* renamed from: e  reason: collision with other field name */
    public String f600e;

    /* renamed from: f  reason: collision with other field name */
    public String f601f;

    /* renamed from: g  reason: collision with other field name */
    public String f602g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372463, "Lcom/xiaomi/push/hw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372463, "Lcom/xiaomi/push/hw;");
                return;
            }
        }
        f591a = new jg("XmPushActionAckNotification");
        a = new iy("", (byte) 11, (short) 1);
        f63651b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f63652c = new iy("", (byte) 11, (short) 3);
        f63653d = new iy("", (byte) 11, (short) 4);
        f63654e = new iy("", (byte) 11, (short) 5);
        f63655f = new iy("", (byte) 10, (short) 7);
        f63656g = new iy("", (byte) 11, (short) 8);
        f63657h = new iy("", (byte) 13, (short) 9);
        f63658i = new iy("", (byte) 11, (short) 10);
        f63659j = new iy("", (byte) 11, (short) 11);
    }

    public hw() {
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
        this.f595a = new BitSet(1);
        this.f592a = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hwVar)) == null) {
            if (hw.class.equals(hwVar.getClass())) {
                int compareTo = Boolean.valueOf(m476a()).compareTo(Boolean.valueOf(hwVar.m476a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m476a() || (a11 = ir.a(this.f594a, hwVar.f594a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m478b()).compareTo(Boolean.valueOf(hwVar.m478b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m478b() || (a10 = ir.a(this.f593a, hwVar.f593a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = ir.a(this.f597b, hwVar.f597b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f598c, hwVar.f598c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f599d, hwVar.f599d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f592a, hwVar.f592a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f600e, hwVar.f600e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f596a, hwVar.f596a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f601f, hwVar.f601f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f602g, hwVar.f602g)) == 0) {
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
            return hw.class.getName().compareTo(hwVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hw a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f592a = j2;
            a(true);
            return this;
        }
        return (hw) invokeJ.objValue;
    }

    public hw a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, huVar)) == null) {
            this.f593a = huVar;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public hw a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f597b = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f597b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m474a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f596a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m475a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f597b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, jbVar) != null) {
            return;
        }
        jbVar.m576a();
        while (true) {
            iy m572a = jbVar.m572a();
            byte b2 = m572a.a;
            if (b2 == 0) {
                jbVar.f();
                m475a();
                return;
            }
            switch (m572a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f594a = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f593a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f597b = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f598c = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f599d = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f592a = jbVar.m571a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f600e = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        ja m574a = jbVar.m574a();
                        this.f596a = new HashMap(m574a.f819a * 2);
                        for (int i2 = 0; i2 < m574a.f819a; i2++) {
                            this.f596a.put(jbVar.m577a(), jbVar.m577a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f601f = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f602g = jbVar.m577a();
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
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f595a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m476a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f594a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m477a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, hwVar)) == null) {
            if (hwVar == null) {
                return false;
            }
            boolean m476a = m476a();
            boolean m476a2 = hwVar.m476a();
            if ((m476a || m476a2) && !(m476a && m476a2 && this.f594a.equals(hwVar.f594a))) {
                return false;
            }
            boolean m478b = m478b();
            boolean m478b2 = hwVar.m478b();
            if ((m478b || m478b2) && !(m478b && m478b2 && this.f593a.m471a(hwVar.f593a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hwVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f597b.equals(hwVar.f597b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hwVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f598c.equals(hwVar.f598c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f599d.equals(hwVar.f599d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f592a == hwVar.f592a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hwVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f600e.equals(hwVar.f600e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hwVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f596a.equals(hwVar.f596a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hwVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f601f.equals(hwVar.f601f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hwVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f602g.equals(hwVar.f602g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hw b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f598c = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f599d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jbVar) == null) {
            m475a();
            jbVar.a(f591a);
            if (this.f594a != null && m476a()) {
                jbVar.a(a);
                jbVar.a(this.f594a);
                jbVar.b();
            }
            if (this.f593a != null && m478b()) {
                jbVar.a(f63651b);
                this.f593a.b(jbVar);
                jbVar.b();
            }
            if (this.f597b != null) {
                jbVar.a(f63652c);
                jbVar.a(this.f597b);
                jbVar.b();
            }
            if (this.f598c != null && d()) {
                jbVar.a(f63653d);
                jbVar.a(this.f598c);
                jbVar.b();
            }
            if (this.f599d != null && e()) {
                jbVar.a(f63654e);
                jbVar.a(this.f599d);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f63655f);
                jbVar.a(this.f592a);
                jbVar.b();
            }
            if (this.f600e != null && g()) {
                jbVar.a(f63656g);
                jbVar.a(this.f600e);
                jbVar.b();
            }
            if (this.f596a != null && h()) {
                jbVar.a(f63657h);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f596a.size()));
                for (Map.Entry<String, String> entry : this.f596a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f601f != null && i()) {
                jbVar.a(f63658i);
                jbVar.a(this.f601f);
                jbVar.b();
            }
            if (this.f602g != null && j()) {
                jbVar.a(f63659j);
                jbVar.a(this.f602g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m580a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m478b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f593a != null : invokeV.booleanValue;
    }

    public hw c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f599d = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f597b != null : invokeV.booleanValue;
    }

    public hw d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f600e = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f598c != null : invokeV.booleanValue;
    }

    public hw e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f601f = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f599d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hw)) {
                return m477a((hw) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f595a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f600e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f596a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f601f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f602g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
            boolean z2 = false;
            if (m476a()) {
                sb.append("debug:");
                String str = this.f594a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m478b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f593a;
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
            String str2 = this.f597b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f598c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f599d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f592a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str5 = this.f600e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f596a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f601f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f602g;
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
