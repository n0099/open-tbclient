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
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class hw implements iu<hw, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f535a;
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
    public int f536a;

    /* renamed from: a  reason: collision with other field name */
    public long f537a;

    /* renamed from: a  reason: collision with other field name */
    public String f538a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f539a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f540a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f541a;

    /* renamed from: b  reason: collision with other field name */
    public int f542b;

    /* renamed from: b  reason: collision with other field name */
    public String f543b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f544b;

    /* renamed from: c  reason: collision with other field name */
    public int f545c;

    /* renamed from: c  reason: collision with other field name */
    public String f546c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f547c;

    /* renamed from: d  reason: collision with other field name */
    public String f548d;

    /* renamed from: e  reason: collision with other field name */
    public String f549e;

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
        f535a = new jk("PushMetaInfo");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 10, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 8, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 8, (short) 8);
        i = new jc("", (byte) 8, (short) 9);
        j = new jc("", StrictLineReader.CR, (short) 10);
        k = new jc("", StrictLineReader.CR, (short) 11);
        l = new jc("", (byte) 2, (short) 12);
        m = new jc("", StrictLineReader.CR, (short) 13);
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
        this.f539a = new BitSet(5);
        this.f541a = false;
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
        this.f539a = bitSet;
        bitSet.clear();
        this.f539a.or(hwVar.f539a);
        if (hwVar.m434a()) {
            this.f538a = hwVar.f538a;
        }
        this.f537a = hwVar.f537a;
        if (hwVar.m440c()) {
            this.f543b = hwVar.f543b;
        }
        if (hwVar.m441d()) {
            this.f546c = hwVar.f546c;
        }
        if (hwVar.e()) {
            this.f548d = hwVar.f548d;
        }
        this.f536a = hwVar.f536a;
        if (hwVar.g()) {
            this.f549e = hwVar.f549e;
        }
        this.f542b = hwVar.f542b;
        this.f545c = hwVar.f545c;
        if (hwVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hwVar.f540a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f540a = hashMap;
        }
        if (hwVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hwVar.f544b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f544b = hashMap2;
        }
        this.f541a = hwVar.f541a;
        if (hwVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hwVar.f547c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f547c = hashMap3;
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f536a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m434a()).compareTo(Boolean.valueOf(hwVar.m434a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m434a() || (a14 = iv.a(this.f538a, hwVar.f538a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m438b()).compareTo(Boolean.valueOf(hwVar.m438b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m438b() || (a13 = iv.a(this.f537a, hwVar.f537a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m440c()).compareTo(Boolean.valueOf(hwVar.m440c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m440c() || (a12 = iv.a(this.f543b, hwVar.f543b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m441d()).compareTo(Boolean.valueOf(hwVar.m441d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m441d() || (a11 = iv.a(this.f546c, hwVar.f546c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a10 = iv.a(this.f548d, hwVar.f548d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a9 = iv.a(this.f536a, hwVar.f536a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a8 = iv.a(this.f549e, hwVar.f549e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a7 = iv.a(this.f542b, hwVar.f542b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a6 = iv.a(this.f545c, hwVar.f545c)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a5 = iv.a(this.f540a, hwVar.f540a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a4 = iv.a(this.f544b, hwVar.f544b)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!m() || (a3 = iv.a(this.f541a, hwVar.f541a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!n() || (a2 = iv.a(this.f547c, hwVar.f547c)) == 0) {
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
    public long m429a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f537a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m430a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new hw(this) : (hw) invokeV.objValue;
    }

    public hw a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.f536a = i2;
            b(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f538a = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public hw a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, map)) == null) {
            this.f540a = map;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m431a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f538a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m432a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f540a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m433a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f538a == null) {
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
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                if (m438b()) {
                    m433a();
                    return;
                }
                throw new jg("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (m545a.f809a) {
                case 1:
                    if (b2 == 11) {
                        this.f538a = jfVar.m550a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f537a = jfVar.m544a();
                        a(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f543b = jfVar.m550a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f546c = jfVar.m550a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f548d = jfVar.m550a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f536a = jfVar.m543a();
                        b(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f549e = jfVar.m550a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f542b = jfVar.m543a();
                        c(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f545c = jfVar.m543a();
                        d(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        je m547a = jfVar.m547a();
                        this.f540a = new HashMap(m547a.f811a * 2);
                        while (i2 < m547a.f811a) {
                            this.f540a.put(jfVar.m550a(), jfVar.m550a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        je m547a2 = jfVar.m547a();
                        this.f544b = new HashMap(m547a2.f811a * 2);
                        while (i2 < m547a2.f811a) {
                            this.f544b.put(jfVar.m550a(), jfVar.m550a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f541a = jfVar.m554a();
                        e(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        je m547a3 = jfVar.m547a();
                        this.f547c = new HashMap(m547a3.f811a * 2);
                        while (i2 < m547a3.f811a) {
                            this.f547c.put(jfVar.m550a(), jfVar.m550a());
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
            if (this.f540a == null) {
                this.f540a = new HashMap();
            }
            this.f540a.put(str, str2);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f539a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f538a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m435a(hw hwVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, hwVar)) == null) {
            if (hwVar == null) {
                return false;
            }
            boolean m434a = m434a();
            boolean m434a2 = hwVar.m434a();
            if (((m434a || m434a2) && !(m434a && m434a2 && this.f538a.equals(hwVar.f538a))) || this.f537a != hwVar.f537a) {
                return false;
            }
            boolean m440c = m440c();
            boolean m440c2 = hwVar.m440c();
            if ((m440c || m440c2) && !(m440c && m440c2 && this.f543b.equals(hwVar.f543b))) {
                return false;
            }
            boolean m441d = m441d();
            boolean m441d2 = hwVar.m441d();
            if ((m441d || m441d2) && !(m441d && m441d2 && this.f546c.equals(hwVar.f546c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hwVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f548d.equals(hwVar.f548d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hwVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f536a == hwVar.f536a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hwVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f549e.equals(hwVar.f549e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hwVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f542b == hwVar.f542b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hwVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f545c == hwVar.f545c)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hwVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f540a.equals(hwVar.f540a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hwVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f544b.equals(hwVar.f544b))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hwVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f541a == hwVar.f541a)) {
                return false;
            }
            boolean n = n();
            boolean n2 = hwVar.n();
            if (n || n2) {
                return n && n2 && this.f547c.equals(hwVar.f547c);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f542b : invokeV.intValue;
    }

    public hw b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f542b = i2;
            c(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f543b = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m436b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f543b : (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m437b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f544b : (Map) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jfVar) == null) {
            m433a();
            jfVar.a(f535a);
            if (this.f538a != null) {
                jfVar.a(a);
                jfVar.a(this.f538a);
                jfVar.b();
            }
            jfVar.a(b);
            jfVar.a(this.f537a);
            jfVar.b();
            if (this.f543b != null && m440c()) {
                jfVar.a(c);
                jfVar.a(this.f543b);
                jfVar.b();
            }
            if (this.f546c != null && m441d()) {
                jfVar.a(d);
                jfVar.a(this.f546c);
                jfVar.b();
            }
            if (this.f548d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f548d);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f536a);
                jfVar.b();
            }
            if (this.f549e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f549e);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(h);
                jfVar.a(this.f542b);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f545c);
                jfVar.b();
            }
            if (this.f540a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f540a.size()));
                for (Map.Entry<String, String> entry : this.f540a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f544b != null && k()) {
                jfVar.a(k);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f544b.size()));
                for (Map.Entry<String, String> entry2 : this.f544b.entrySet()) {
                    jfVar.a(entry2.getKey());
                    jfVar.a(entry2.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (m()) {
                jfVar.a(l);
                jfVar.a(this.f541a);
                jfVar.b();
            }
            if (this.f547c != null && n()) {
                jfVar.a(m);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f547c.size()));
                for (Map.Entry<String, String> entry3 : this.f547c.entrySet()) {
                    jfVar.a(entry3.getKey());
                    jfVar.a(entry3.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) {
            if (this.f544b == null) {
                this.f544b = new HashMap();
            }
            this.f544b.put(str, str2);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f539a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m438b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f539a.get(0) : invokeV.booleanValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f545c : invokeV.intValue;
    }

    public hw c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.f545c = i2;
            d(true);
            return this;
        }
        return (hw) invokeI.objValue;
    }

    public hw c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f546c = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m439c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f546c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f539a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m440c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f543b != null : invokeV.booleanValue;
    }

    public hw d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.f548d = str;
            return this;
        }
        return (hw) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f548d : (String) invokeV.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f539a.set(3, z);
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m441d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f546c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.f539a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f548d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, obj)) == null) {
            if (obj != null && (obj instanceof hw)) {
                return m435a((hw) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f539a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f549e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f539a.get(2) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f539a.get(3) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f540a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f544b != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f541a : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f539a.get(4) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.f547c != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMetaInfo(");
            sb.append("id:");
            String str = this.f538a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f537a);
            if (m440c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str2 = this.f543b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (m441d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("title:");
                String str3 = this.f546c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("description:");
                String str4 = this.f548d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyType:");
                sb.append(this.f536a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(HttpRetryStatistic.RETRY_URL);
                String str5 = this.f549e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f542b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("notifyId:");
                sb.append(this.f545c);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f540a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("internal:");
                Map<String, String> map2 = this.f544b;
                if (map2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map2);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ignoreRegInfo:");
                sb.append(this.f541a);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("apsProperFields:");
                Map<String, String> map3 = this.f547c;
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
