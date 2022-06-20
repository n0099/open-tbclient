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
/* loaded from: classes8.dex */
public class hw implements iu<hw, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f528a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public static final jc k;
    public static final jc l;
    public static final jc m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f529a;

    /* renamed from: a  reason: collision with other field name */
    public long f530a;

    /* renamed from: a  reason: collision with other field name */
    public String f531a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f532a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f533a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f534a;

    /* renamed from: b  reason: collision with other field name */
    public int f535b;

    /* renamed from: b  reason: collision with other field name */
    public String f536b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f537b;

    /* renamed from: c  reason: collision with other field name */
    public int f538c;

    /* renamed from: c  reason: collision with other field name */
    public String f539c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f540c;

    /* renamed from: d  reason: collision with other field name */
    public String f541d;

    /* renamed from: e  reason: collision with other field name */
    public String f542e;

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
        f528a = new jk("PushMetaInfo");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 10, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 8, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 8, (short) 8);
        i = new jc("", (byte) 8, (short) 9);
        j = new jc("", (byte) 13, (short) 10);
        k = new jc("", (byte) 13, (short) 11);
        l = new jc("", (byte) 2, (short) 12);
        m = new jc("", (byte) 13, (short) 13);
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
        this.f532a = new BitSet(5);
        this.f534a = false;
    }

    public hw(hw hwVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hwVar};
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
        this.f532a = bitSet;
        bitSet.clear();
        this.f532a.or(hwVar.f532a);
        if (hwVar.m429a()) {
            this.f531a = hwVar.f531a;
        }
        this.f530a = hwVar.f530a;
        if (hwVar.m435c()) {
            this.f536b = hwVar.f536b;
        }
        if (hwVar.m436d()) {
            this.f539c = hwVar.f539c;
        }
        if (hwVar.e()) {
            this.f541d = hwVar.f541d;
        }
        this.f529a = hwVar.f529a;
        if (hwVar.g()) {
            this.f542e = hwVar.f542e;
        }
        this.f535b = hwVar.f535b;
        this.f538c = hwVar.f538c;
        if (hwVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hwVar.f533a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f533a = hashMap;
        }
        if (hwVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hwVar.f537b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f537b = hashMap2;
        }
        this.f534a = hwVar.f534a;
        if (hwVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hwVar.f540c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f540c = hashMap3;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f529a : invokeV.intValue;
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
        int a12;
        int a13;
        int a14;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hwVar)) == null) {
            if (hw.class.equals(hwVar.getClass())) {
                int compareTo = Boolean.valueOf(m429a()).compareTo(Boolean.valueOf(hwVar.m429a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m429a() || (a14 = iv.a(this.f531a, hwVar.f531a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m433b()).compareTo(Boolean.valueOf(hwVar.m433b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m433b() || (a13 = iv.a(this.f530a, hwVar.f530a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m435c()).compareTo(Boolean.valueOf(hwVar.m435c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m435c() || (a12 = iv.a(this.f536b, hwVar.f536b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m436d()).compareTo(Boolean.valueOf(hwVar.m436d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m436d() || (a11 = iv.a(this.f539c, hwVar.f539c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a10 = iv.a(this.f541d, hwVar.f541d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a9 = iv.a(this.f529a, hwVar.f529a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a8 = iv.a(this.f542e, hwVar.f542e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a7 = iv.a(this.f535b, hwVar.f535b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a6 = iv.a(this.f538c, hwVar.f538c)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a5 = iv.a(this.f533a, hwVar.f533a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a4 = iv.a(this.f537b, hwVar.f537b)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!m() || (a3 = iv.a(this.f534a, hwVar.f534a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!n() || (a2 = iv.a(this.f540c, hwVar.f540c)) == 0) {
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
            return hw.class.getName().compareTo(hwVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m424a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f530a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m425a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new hw(this) : (hw) invokeV.objValue;
    }

    public hw a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f529a = i2;
            b(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f531a = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public hw a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            this.f533a = map;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m426a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f531a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m427a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f533a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m428a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f531a == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jfVar) != null) {
            return;
        }
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                if (m433b()) {
                    m428a();
                    return;
                }
                throw new jg("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m540a.f802a) {
                case 1:
                    if (b2 == 11) {
                        this.f531a = jfVar.m545a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f530a = jfVar.m539a();
                        a(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f536b = jfVar.m545a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f539c = jfVar.m545a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f541d = jfVar.m545a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f529a = jfVar.m538a();
                        b(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f542e = jfVar.m545a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f535b = jfVar.m538a();
                        c(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f538c = jfVar.m538a();
                        d(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        je m542a = jfVar.m542a();
                        this.f533a = new HashMap(m542a.f804a * 2);
                        while (i2 < m542a.f804a) {
                            this.f533a.put(jfVar.m545a(), jfVar.m545a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        je m542a2 = jfVar.m542a();
                        this.f537b = new HashMap(m542a2.f804a * 2);
                        while (i2 < m542a2.f804a) {
                            this.f537b.put(jfVar.m545a(), jfVar.m545a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f534a = jfVar.m549a();
                        e(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        je m542a3 = jfVar.m542a();
                        this.f540c = new HashMap(m542a3.f804a * 2);
                        while (i2 < m542a3.f804a) {
                            this.f540c.put(jfVar.m545a(), jfVar.m545a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                default:
                    ji.a(jfVar, b2);
                    break;
            }
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f533a == null) {
                this.f533a = new HashMap();
            }
            this.f533a.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f532a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f531a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hwVar)) == null) {
            if (hwVar == null) {
                return false;
            }
            boolean m429a = m429a();
            boolean m429a2 = hwVar.m429a();
            if (((m429a || m429a2) && !(m429a && m429a2 && this.f531a.equals(hwVar.f531a))) || this.f530a != hwVar.f530a) {
                return false;
            }
            boolean m435c = m435c();
            boolean m435c2 = hwVar.m435c();
            if ((m435c || m435c2) && !(m435c && m435c2 && this.f536b.equals(hwVar.f536b))) {
                return false;
            }
            boolean m436d = m436d();
            boolean m436d2 = hwVar.m436d();
            if ((m436d || m436d2) && !(m436d && m436d2 && this.f539c.equals(hwVar.f539c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f541d.equals(hwVar.f541d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f529a == hwVar.f529a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hwVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f542e.equals(hwVar.f542e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hwVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f535b == hwVar.f535b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hwVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f538c == hwVar.f538c)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hwVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f533a.equals(hwVar.f533a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hwVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f537b.equals(hwVar.f537b))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hwVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f534a == hwVar.f534a)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hwVar.n();
            if (n || n2) {
                return n && n2 && this.f540c.equals(hwVar.f540c);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f535b : invokeV.intValue;
    }

    public hw b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f535b = i2;
            c(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f536b = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m431b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f536b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m432b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f537b : (Map) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jfVar) == null) {
            m428a();
            jfVar.a(f528a);
            if (this.f531a != null) {
                jfVar.a(a);
                jfVar.a(this.f531a);
                jfVar.b();
            }
            jfVar.a(b);
            jfVar.a(this.f530a);
            jfVar.b();
            if (this.f536b != null && m435c()) {
                jfVar.a(c);
                jfVar.a(this.f536b);
                jfVar.b();
            }
            if (this.f539c != null && m436d()) {
                jfVar.a(d);
                jfVar.a(this.f539c);
                jfVar.b();
            }
            if (this.f541d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f541d);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f529a);
                jfVar.b();
            }
            if (this.f542e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f542e);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(h);
                jfVar.a(this.f535b);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f538c);
                jfVar.b();
            }
            if (this.f533a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f533a.size()));
                for (Map.Entry<String, String> entry : this.f533a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f537b != null && k()) {
                jfVar.a(k);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f537b.size()));
                for (Map.Entry<String, String> entry2 : this.f537b.entrySet()) {
                    jfVar.a(entry2.getKey());
                    jfVar.a(entry2.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (m()) {
                jfVar.a(l);
                jfVar.a(this.f534a);
                jfVar.b();
            }
            if (this.f540c != null && n()) {
                jfVar.a(m);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f540c.size()));
                for (Map.Entry<String, String> entry3 : this.f540c.entrySet()) {
                    jfVar.a(entry3.getKey());
                    jfVar.a(entry3.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (this.f537b == null) {
                this.f537b = new HashMap();
            }
            this.f537b.put(str, str2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f532a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m433b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f532a.get(0) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f538c : invokeV.intValue;
    }

    public hw c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.f538c = i2;
            d(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f539c = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m434c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f539c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f532a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m435c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f536b != null : invokeV.booleanValue;
    }

    public hw d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f541d = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f541d : (String) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f532a.set(3, z);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m436d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f539c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f532a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f541d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) {
            if (obj != null && (obj instanceof hw)) {
                return m430a((hw) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f532a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f542e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f532a.get(2) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f532a.get(3) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f533a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f537b != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f534a : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f532a.get(4) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f540c != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMetaInfo(");
            sb.append("id:");
            String str = this.f531a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f530a);
            if (m435c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str2 = this.f536b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (m436d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("title:");
                String str3 = this.f539c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("description:");
                String str4 = this.f541d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyType:");
                sb.append(this.f529a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(HttpRetryStatistic.RETRY_URL);
                String str5 = this.f542e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f535b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyId:");
                sb.append(this.f538c);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f533a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("internal:");
                Map<String, String> map2 = this.f537b;
                if (map2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map2);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ignoreRegInfo:");
                sb.append(this.f534a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("apsProperFields:");
                Map<String, String> map3 = this.f540c;
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
