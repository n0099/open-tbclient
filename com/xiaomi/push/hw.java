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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hw implements iq<hw, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f567a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
    public static final iy i;
    public static final iy j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f568a;

    /* renamed from: a  reason: collision with other field name */
    public hu f569a;

    /* renamed from: a  reason: collision with other field name */
    public String f570a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f571a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f572a;

    /* renamed from: b  reason: collision with other field name */
    public String f573b;

    /* renamed from: c  reason: collision with other field name */
    public String f574c;

    /* renamed from: d  reason: collision with other field name */
    public String f575d;

    /* renamed from: e  reason: collision with other field name */
    public String f576e;

    /* renamed from: f  reason: collision with other field name */
    public String f577f;

    /* renamed from: g  reason: collision with other field name */
    public String f578g;

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
        f567a = new jg("XmPushActionAckNotification");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new iy("", (byte) 12, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new iy("", (byte) 10, (short) 7);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new iy("", (byte) 13, (short) 9);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
        j = new iy("", Constants.GZIP_CAST_TYPE, (short) 11);
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
        this.f571a = new BitSet(1);
        this.f568a = 0L;
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
                int compareTo = Boolean.valueOf(m463a()).compareTo(Boolean.valueOf(hwVar.m463a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m463a() || (a11 = ir.a(this.f570a, hwVar.f570a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m465b()).compareTo(Boolean.valueOf(hwVar.m465b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m465b() || (a10 = ir.a(this.f569a, hwVar.f569a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hwVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = ir.a(this.f573b, hwVar.f573b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hwVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f574c, hwVar.f574c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f575d, hwVar.f575d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f568a, hwVar.f568a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f576e, hwVar.f576e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f572a, hwVar.f572a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f577f, hwVar.f577f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f578g, hwVar.f578g)) == 0) {
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
            this.f568a = j2;
            a(true);
            return this;
        }
        return (hw) invokeJ.objValue;
    }

    public hw a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, huVar)) == null) {
            this.f569a = huVar;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public hw a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f573b = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f573b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m461a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f572a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m462a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f573b == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, jbVar) != null) {
            return;
        }
        jbVar.m563a();
        while (true) {
            iy m559a = jbVar.m559a();
            byte b2 = m559a.a;
            if (b2 == 0) {
                jbVar.f();
                m462a();
                return;
            }
            switch (m559a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f570a = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f569a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f573b = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f574c = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f575d = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f568a = jbVar.m558a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f576e = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        ja m561a = jbVar.m561a();
                        this.f572a = new HashMap(m561a.f795a * 2);
                        for (int i2 = 0; i2 < m561a.f795a; i2++) {
                            this.f572a.put(jbVar.m564a(), jbVar.m564a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f577f = jbVar.m564a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f578g = jbVar.m564a();
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
            this.f571a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f570a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m464a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, hwVar)) == null) {
            if (hwVar == null) {
                return false;
            }
            boolean m463a = m463a();
            boolean m463a2 = hwVar.m463a();
            if ((m463a || m463a2) && !(m463a && m463a2 && this.f570a.equals(hwVar.f570a))) {
                return false;
            }
            boolean m465b = m465b();
            boolean m465b2 = hwVar.m465b();
            if ((m465b || m465b2) && !(m465b && m465b2 && this.f569a.m458a(hwVar.f569a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hwVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f573b.equals(hwVar.f573b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hwVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f574c.equals(hwVar.f574c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f575d.equals(hwVar.f575d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f568a == hwVar.f568a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hwVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f576e.equals(hwVar.f576e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hwVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f572a.equals(hwVar.f572a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hwVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f577f.equals(hwVar.f577f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hwVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f578g.equals(hwVar.f578g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hw b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f574c = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f575d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jbVar) == null) {
            m462a();
            jbVar.a(f567a);
            if (this.f570a != null && m463a()) {
                jbVar.a(a);
                jbVar.a(this.f570a);
                jbVar.b();
            }
            if (this.f569a != null && m465b()) {
                jbVar.a(b);
                this.f569a.b(jbVar);
                jbVar.b();
            }
            if (this.f573b != null) {
                jbVar.a(c);
                jbVar.a(this.f573b);
                jbVar.b();
            }
            if (this.f574c != null && d()) {
                jbVar.a(d);
                jbVar.a(this.f574c);
                jbVar.b();
            }
            if (this.f575d != null && e()) {
                jbVar.a(e);
                jbVar.a(this.f575d);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f);
                jbVar.a(this.f568a);
                jbVar.b();
            }
            if (this.f576e != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f576e);
                jbVar.b();
            }
            if (this.f572a != null && h()) {
                jbVar.a(h);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f572a.size()));
                for (Map.Entry<String, String> entry : this.f572a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f577f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f577f);
                jbVar.b();
            }
            if (this.f578g != null && j()) {
                jbVar.a(j);
                jbVar.a(this.f578g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m567a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m465b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f569a != null : invokeV.booleanValue;
    }

    public hw c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f575d = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f573b != null : invokeV.booleanValue;
    }

    public hw d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f576e = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f574c != null : invokeV.booleanValue;
    }

    public hw e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f577f = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f575d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hw)) {
                return m464a((hw) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f571a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f576e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f572a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f577f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f578g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
            boolean z2 = false;
            if (m463a()) {
                sb.append("debug:");
                String str = this.f570a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m465b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f569a;
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
            String str2 = this.f573b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f574c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f575d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f568a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str5 = this.f576e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f572a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f577f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f578g;
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
