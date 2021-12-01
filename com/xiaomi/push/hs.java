package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
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
/* loaded from: classes3.dex */
public class hs implements iq<hs, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f544a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f63043b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f63044c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f63045d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f63046e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f63047f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f63048g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f63049h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f63050i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f63051j;

    /* renamed from: k  reason: collision with root package name */
    public static final iy f63052k;
    public static final iy l;
    public static final iy m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f545a;

    /* renamed from: a  reason: collision with other field name */
    public long f546a;

    /* renamed from: a  reason: collision with other field name */
    public String f547a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f548a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f549a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f550a;

    /* renamed from: b  reason: collision with other field name */
    public int f551b;

    /* renamed from: b  reason: collision with other field name */
    public String f552b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f553b;

    /* renamed from: c  reason: collision with other field name */
    public int f554c;

    /* renamed from: c  reason: collision with other field name */
    public String f555c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f556c;

    /* renamed from: d  reason: collision with other field name */
    public String f557d;

    /* renamed from: e  reason: collision with other field name */
    public String f558e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372587, "Lcom/xiaomi/push/hs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372587, "Lcom/xiaomi/push/hs;");
                return;
            }
        }
        f544a = new jg("PushMetaInfo");
        a = new iy("", (byte) 11, (short) 1);
        f63043b = new iy("", (byte) 10, (short) 2);
        f63044c = new iy("", (byte) 11, (short) 3);
        f63045d = new iy("", (byte) 11, (short) 4);
        f63046e = new iy("", (byte) 11, (short) 5);
        f63047f = new iy("", (byte) 8, (short) 6);
        f63048g = new iy("", (byte) 11, (short) 7);
        f63049h = new iy("", (byte) 8, (short) 8);
        f63050i = new iy("", (byte) 8, (short) 9);
        f63051j = new iy("", (byte) 13, (short) 10);
        f63052k = new iy("", (byte) 13, (short) 11);
        l = new iy("", (byte) 2, (short) 12);
        m = new iy("", (byte) 13, (short) 13);
    }

    public hs() {
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
        this.f548a = new BitSet(5);
        this.f550a = false;
    }

    public hs(hs hsVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hsVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        BitSet bitSet = new BitSet(5);
        this.f548a = bitSet;
        bitSet.clear();
        this.f548a.or(hsVar.f548a);
        if (hsVar.m462a()) {
            this.f547a = hsVar.f547a;
        }
        this.f546a = hsVar.f546a;
        if (hsVar.m468c()) {
            this.f552b = hsVar.f552b;
        }
        if (hsVar.m469d()) {
            this.f555c = hsVar.f555c;
        }
        if (hsVar.e()) {
            this.f557d = hsVar.f557d;
        }
        this.f545a = hsVar.f545a;
        if (hsVar.g()) {
            this.f558e = hsVar.f558e;
        }
        this.f551b = hsVar.f551b;
        this.f554c = hsVar.f554c;
        if (hsVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hsVar.f549a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f549a = hashMap;
        }
        if (hsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hsVar.f553b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f553b = hashMap2;
        }
        this.f550a = hsVar.f550a;
        if (hsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hsVar.f556c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f556c = hashMap3;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f545a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
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
        int a12;
        int a13;
        int a14;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hsVar)) == null) {
            if (hs.class.equals(hsVar.getClass())) {
                int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(hsVar.m462a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m462a() || (a14 = ir.a(this.f547a, hsVar.f547a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m466b()).compareTo(Boolean.valueOf(hsVar.m466b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m466b() || (a13 = ir.a(this.f546a, hsVar.f546a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m468c()).compareTo(Boolean.valueOf(hsVar.m468c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m468c() || (a12 = ir.a(this.f552b, hsVar.f552b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m469d()).compareTo(Boolean.valueOf(hsVar.m469d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m469d() || (a11 = ir.a(this.f555c, hsVar.f555c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a10 = ir.a(this.f557d, hsVar.f557d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a9 = ir.a(this.f545a, hsVar.f545a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a8 = ir.a(this.f558e, hsVar.f558e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a7 = ir.a(this.f551b, hsVar.f551b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a6 = ir.a(this.f554c, hsVar.f554c)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a5 = ir.a(this.f549a, hsVar.f549a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a4 = ir.a(this.f553b, hsVar.f553b)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!m() || (a3 = ir.a(this.f550a, hsVar.f550a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!n() || (a2 = ir.a(this.f556c, hsVar.f556c)) == 0) {
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
                        return a12;
                    }
                    return a13;
                }
                return a14;
            }
            return hs.class.getName().compareTo(hsVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m457a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f546a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m458a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new hs(this) : (hs) invokeV.objValue;
    }

    public hs a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f545a = i2;
            b(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f547a = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public hs a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            this.f549a = map;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m459a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f547a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m460a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f549a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m461a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f547a == null) {
            throw new jc("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jbVar) != null) {
            return;
        }
        jbVar.m576a();
        while (true) {
            iy m572a = jbVar.m572a();
            byte b2 = m572a.a;
            if (b2 == 0) {
                jbVar.f();
                if (m466b()) {
                    m461a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m572a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f547a = jbVar.m577a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f546a = jbVar.m571a();
                        a(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f552b = jbVar.m577a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f555c = jbVar.m577a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f557d = jbVar.m577a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f545a = jbVar.m570a();
                        b(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f558e = jbVar.m577a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f551b = jbVar.m570a();
                        c(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f554c = jbVar.m570a();
                        d(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m574a = jbVar.m574a();
                        this.f549a = new HashMap(m574a.f819a * 2);
                        while (i2 < m574a.f819a) {
                            this.f549a.put(jbVar.m577a(), jbVar.m577a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        ja m574a2 = jbVar.m574a();
                        this.f553b = new HashMap(m574a2.f819a * 2);
                        while (i2 < m574a2.f819a) {
                            this.f553b.put(jbVar.m577a(), jbVar.m577a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f550a = jbVar.m581a();
                        e(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        ja m574a3 = jbVar.m574a();
                        this.f556c = new HashMap(m574a3.f819a * 2);
                        while (i2 < m574a3.f819a) {
                            this.f556c.put(jbVar.m577a(), jbVar.m577a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                default:
                    je.a(jbVar, b2);
                    break;
            }
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f549a == null) {
                this.f549a = new HashMap();
            }
            this.f549a.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f548a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f547a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hsVar)) == null) {
            if (hsVar == null) {
                return false;
            }
            boolean m462a = m462a();
            boolean m462a2 = hsVar.m462a();
            if (((m462a || m462a2) && !(m462a && m462a2 && this.f547a.equals(hsVar.f547a))) || this.f546a != hsVar.f546a) {
                return false;
            }
            boolean m468c = m468c();
            boolean m468c2 = hsVar.m468c();
            if ((m468c || m468c2) && !(m468c && m468c2 && this.f552b.equals(hsVar.f552b))) {
                return false;
            }
            boolean m469d = m469d();
            boolean m469d2 = hsVar.m469d();
            if ((m469d || m469d2) && !(m469d && m469d2 && this.f555c.equals(hsVar.f555c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hsVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f557d.equals(hsVar.f557d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hsVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f545a == hsVar.f545a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hsVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f558e.equals(hsVar.f558e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hsVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f551b == hsVar.f551b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hsVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f554c == hsVar.f554c)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hsVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f549a.equals(hsVar.f549a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hsVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f553b.equals(hsVar.f553b))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hsVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f550a == hsVar.f550a)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hsVar.n();
            if (n || n2) {
                return n && n2 && this.f556c.equals(hsVar.f556c);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f551b : invokeV.intValue;
    }

    public hs b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f551b = i2;
            c(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f552b = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m464b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f552b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m465b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f553b : (Map) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jbVar) == null) {
            m461a();
            jbVar.a(f544a);
            if (this.f547a != null) {
                jbVar.a(a);
                jbVar.a(this.f547a);
                jbVar.b();
            }
            jbVar.a(f63043b);
            jbVar.a(this.f546a);
            jbVar.b();
            if (this.f552b != null && m468c()) {
                jbVar.a(f63044c);
                jbVar.a(this.f552b);
                jbVar.b();
            }
            if (this.f555c != null && m469d()) {
                jbVar.a(f63045d);
                jbVar.a(this.f555c);
                jbVar.b();
            }
            if (this.f557d != null && e()) {
                jbVar.a(f63046e);
                jbVar.a(this.f557d);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f63047f);
                jbVar.a(this.f545a);
                jbVar.b();
            }
            if (this.f558e != null && g()) {
                jbVar.a(f63048g);
                jbVar.a(this.f558e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f63049h);
                jbVar.a(this.f551b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f63050i);
                jbVar.a(this.f554c);
                jbVar.b();
            }
            if (this.f549a != null && j()) {
                jbVar.a(f63051j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f549a.size()));
                for (Map.Entry<String, String> entry : this.f549a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f553b != null && k()) {
                jbVar.a(f63052k);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f553b.size()));
                for (Map.Entry<String, String> entry2 : this.f553b.entrySet()) {
                    jbVar.a(entry2.getKey());
                    jbVar.a(entry2.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (m()) {
                jbVar.a(l);
                jbVar.a(this.f550a);
                jbVar.b();
            }
            if (this.f556c != null && n()) {
                jbVar.a(m);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f556c.size()));
                for (Map.Entry<String, String> entry3 : this.f556c.entrySet()) {
                    jbVar.a(entry3.getKey());
                    jbVar.a(entry3.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m580a();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (this.f553b == null) {
                this.f553b = new HashMap();
            }
            this.f553b.put(str, str2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f548a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m466b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f548a.get(0) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f554c : invokeV.intValue;
    }

    public hs c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.f554c = i2;
            d(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f555c = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m467c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f555c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f548a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m468c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f552b != null : invokeV.booleanValue;
    }

    public hs d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f557d = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f557d : (String) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f548a.set(3, z);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m469d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f555c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f548a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f557d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) {
            if (obj != null && (obj instanceof hs)) {
                return m463a((hs) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f548a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f558e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f548a.get(2) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f548a.get(3) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f549a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f553b != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f550a : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f548a.get(4) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f556c != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMetaInfo(");
            sb.append("id:");
            String str = this.f547a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f546a);
            if (m468c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str2 = this.f552b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (m469d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("title:");
                String str3 = this.f555c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("description:");
                String str4 = this.f557d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyType:");
                sb.append(this.f545a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(HttpRetryStatistic.RETRY_URL);
                String str5 = this.f558e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f551b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyId:");
                sb.append(this.f554c);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f549a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(com.baidu.android.imsdk.retrieve.Constants.PATH_INTERNAL);
                Map<String, String> map2 = this.f553b;
                if (map2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map2);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ignoreRegInfo:");
                sb.append(this.f550a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("apsProperFields:");
                Map<String, String> map3 = this.f556c;
                if (map3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map3);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
