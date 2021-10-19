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
/* loaded from: classes10.dex */
public class hs implements iq<hs, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f78198a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f543a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f78199b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f78200c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f78201d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f78202e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f78203f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f78204g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f78205h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f78206i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f78207j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f544a;

    /* renamed from: a  reason: collision with other field name */
    public long f545a;

    /* renamed from: a  reason: collision with other field name */
    public String f546a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f547a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f548a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f549a;

    /* renamed from: b  reason: collision with other field name */
    public int f550b;

    /* renamed from: b  reason: collision with other field name */
    public String f551b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f552b;

    /* renamed from: c  reason: collision with other field name */
    public int f553c;

    /* renamed from: c  reason: collision with other field name */
    public String f554c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f555c;

    /* renamed from: d  reason: collision with other field name */
    public String f556d;

    /* renamed from: e  reason: collision with other field name */
    public String f557e;

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
        f543a = new jg("PushMetaInfo");
        f78198a = new iy("", (byte) 11, (short) 1);
        f78199b = new iy("", (byte) 10, (short) 2);
        f78200c = new iy("", (byte) 11, (short) 3);
        f78201d = new iy("", (byte) 11, (short) 4);
        f78202e = new iy("", (byte) 11, (short) 5);
        f78203f = new iy("", (byte) 8, (short) 6);
        f78204g = new iy("", (byte) 11, (short) 7);
        f78205h = new iy("", (byte) 8, (short) 8);
        f78206i = new iy("", (byte) 8, (short) 9);
        f78207j = new iy("", (byte) 13, (short) 10);
        k = new iy("", (byte) 13, (short) 11);
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
        this.f547a = new BitSet(5);
        this.f549a = false;
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
        this.f547a = bitSet;
        bitSet.clear();
        this.f547a.or(hsVar.f547a);
        if (hsVar.m413a()) {
            this.f546a = hsVar.f546a;
        }
        this.f545a = hsVar.f545a;
        if (hsVar.m419c()) {
            this.f551b = hsVar.f551b;
        }
        if (hsVar.m420d()) {
            this.f554c = hsVar.f554c;
        }
        if (hsVar.e()) {
            this.f556d = hsVar.f556d;
        }
        this.f544a = hsVar.f544a;
        if (hsVar.g()) {
            this.f557e = hsVar.f557e;
        }
        this.f550b = hsVar.f550b;
        this.f553c = hsVar.f553c;
        if (hsVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hsVar.f548a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f548a = hashMap;
        }
        if (hsVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hsVar.f552b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f552b = hashMap2;
        }
        this.f549a = hsVar.f549a;
        if (hsVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hsVar.f555c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f555c = hashMap3;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f544a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m413a()).compareTo(Boolean.valueOf(hsVar.m413a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m413a() || (a14 = ir.a(this.f546a, hsVar.f546a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m417b()).compareTo(Boolean.valueOf(hsVar.m417b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m417b() || (a13 = ir.a(this.f545a, hsVar.f545a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m419c()).compareTo(Boolean.valueOf(hsVar.m419c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m419c() || (a12 = ir.a(this.f551b, hsVar.f551b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m420d()).compareTo(Boolean.valueOf(hsVar.m420d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m420d() || (a11 = ir.a(this.f554c, hsVar.f554c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hsVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a10 = ir.a(this.f556d, hsVar.f556d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hsVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a9 = ir.a(this.f544a, hsVar.f544a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hsVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a8 = ir.a(this.f557e, hsVar.f557e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hsVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a7 = ir.a(this.f550b, hsVar.f550b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hsVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a6 = ir.a(this.f553c, hsVar.f553c)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hsVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a5 = ir.a(this.f548a, hsVar.f548a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hsVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a4 = ir.a(this.f552b, hsVar.f552b)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hsVar.m()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!m() || (a3 = ir.a(this.f549a, hsVar.f549a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hsVar.n()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!n() || (a2 = ir.a(this.f555c, hsVar.f555c)) == 0) {
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
    public long m408a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f545a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hs m409a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new hs(this) : (hs) invokeV.objValue;
    }

    public hs a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f544a = i2;
            b(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f546a = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public hs a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            this.f548a = map;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m410a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f546a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m411a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f548a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m412a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f546a == null) {
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
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78390a;
            if (b2 == 0) {
                jbVar.f();
                if (m417b()) {
                    m412a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f546a = jbVar.m528a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f545a = jbVar.m522a();
                        a(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f551b = jbVar.m528a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f554c = jbVar.m528a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f556d = jbVar.m528a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f544a = jbVar.m521a();
                        b(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f557e = jbVar.m528a();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f550b = jbVar.m521a();
                        c(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f553c = jbVar.m521a();
                        d(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m525a = jbVar.m525a();
                        this.f548a = new HashMap(m525a.f818a * 2);
                        while (i2 < m525a.f818a) {
                            this.f548a.put(jbVar.m528a(), jbVar.m528a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        ja m525a2 = jbVar.m525a();
                        this.f552b = new HashMap(m525a2.f818a * 2);
                        while (i2 < m525a2.f818a) {
                            this.f552b.put(jbVar.m528a(), jbVar.m528a());
                            i2++;
                        }
                        jbVar.h();
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f549a = jbVar.m532a();
                        e(true);
                        break;
                    }
                    je.a(jbVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        ja m525a3 = jbVar.m525a();
                        this.f555c = new HashMap(m525a3.f818a * 2);
                        while (i2 < m525a3.f818a) {
                            this.f555c.put(jbVar.m528a(), jbVar.m528a());
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
            if (this.f548a == null) {
                this.f548a = new HashMap();
            }
            this.f548a.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f547a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m413a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f546a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m414a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hsVar)) == null) {
            if (hsVar == null) {
                return false;
            }
            boolean m413a = m413a();
            boolean m413a2 = hsVar.m413a();
            if (((m413a || m413a2) && !(m413a && m413a2 && this.f546a.equals(hsVar.f546a))) || this.f545a != hsVar.f545a) {
                return false;
            }
            boolean m419c = m419c();
            boolean m419c2 = hsVar.m419c();
            if ((m419c || m419c2) && !(m419c && m419c2 && this.f551b.equals(hsVar.f551b))) {
                return false;
            }
            boolean m420d = m420d();
            boolean m420d2 = hsVar.m420d();
            if ((m420d || m420d2) && !(m420d && m420d2 && this.f554c.equals(hsVar.f554c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hsVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f556d.equals(hsVar.f556d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hsVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f544a == hsVar.f544a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hsVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f557e.equals(hsVar.f557e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hsVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f550b == hsVar.f550b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hsVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f553c == hsVar.f553c)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hsVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f548a.equals(hsVar.f548a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hsVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f552b.equals(hsVar.f552b))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hsVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f549a == hsVar.f549a)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hsVar.n();
            if (n || n2) {
                return n && n2 && this.f555c.equals(hsVar.f555c);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f550b : invokeV.intValue;
    }

    public hs b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f550b = i2;
            c(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f551b = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m415b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f551b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m416b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f552b : (Map) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jbVar) == null) {
            m412a();
            jbVar.a(f543a);
            if (this.f546a != null) {
                jbVar.a(f78198a);
                jbVar.a(this.f546a);
                jbVar.b();
            }
            jbVar.a(f78199b);
            jbVar.a(this.f545a);
            jbVar.b();
            if (this.f551b != null && m419c()) {
                jbVar.a(f78200c);
                jbVar.a(this.f551b);
                jbVar.b();
            }
            if (this.f554c != null && m420d()) {
                jbVar.a(f78201d);
                jbVar.a(this.f554c);
                jbVar.b();
            }
            if (this.f556d != null && e()) {
                jbVar.a(f78202e);
                jbVar.a(this.f556d);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f78203f);
                jbVar.a(this.f544a);
                jbVar.b();
            }
            if (this.f557e != null && g()) {
                jbVar.a(f78204g);
                jbVar.a(this.f557e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f78205h);
                jbVar.a(this.f550b);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f78206i);
                jbVar.a(this.f553c);
                jbVar.b();
            }
            if (this.f548a != null && j()) {
                jbVar.a(f78207j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f548a.size()));
                for (Map.Entry<String, String> entry : this.f548a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f552b != null && k()) {
                jbVar.a(k);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f552b.size()));
                for (Map.Entry<String, String> entry2 : this.f552b.entrySet()) {
                    jbVar.a(entry2.getKey());
                    jbVar.a(entry2.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (m()) {
                jbVar.a(l);
                jbVar.a(this.f549a);
                jbVar.b();
            }
            if (this.f555c != null && n()) {
                jbVar.a(m);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f555c.size()));
                for (Map.Entry<String, String> entry3 : this.f555c.entrySet()) {
                    jbVar.a(entry3.getKey());
                    jbVar.a(entry3.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (this.f552b == null) {
                this.f552b = new HashMap();
            }
            this.f552b.put(str, str2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f547a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m417b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f547a.get(0) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f553c : invokeV.intValue;
    }

    public hs c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.f553c = i2;
            d(true);
            return this;
        }
        return (hs) invokeI.objValue;
    }

    public hs c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f554c = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m418c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f554c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f547a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m419c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f551b != null : invokeV.booleanValue;
    }

    public hs d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f556d = str;
            return this;
        }
        return (hs) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f556d : (String) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f547a.set(3, z);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m420d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f554c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f547a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f556d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) {
            if (obj != null && (obj instanceof hs)) {
                return m414a((hs) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f547a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f557e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f547a.get(2) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f547a.get(3) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f548a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f552b != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f549a : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f547a.get(4) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f555c != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMetaInfo(");
            sb.append("id:");
            String str = this.f546a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f545a);
            if (m419c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str2 = this.f551b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (m420d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("title:");
                String str3 = this.f554c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("description:");
                String str4 = this.f556d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyType:");
                sb.append(this.f544a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(HttpRetryStatistic.RETRY_URL);
                String str5 = this.f557e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f550b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyId:");
                sb.append(this.f553c);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f548a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(com.baidu.android.imsdk.retrieve.Constants.PATH_INTERNAL);
                Map<String, String> map2 = this.f552b;
                if (map2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map2);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ignoreRegInfo:");
                sb.append(this.f549a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("apsProperFields:");
                Map<String, String> map3 = this.f555c;
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
