package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
public class hn implements iu<hn, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1195a;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1196a;

    /* renamed from: a  reason: collision with other field name */
    public String f1197a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1198a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f1199a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1200a;

    /* renamed from: b  reason: collision with other field name */
    public long f1201b;

    /* renamed from: b  reason: collision with other field name */
    public String f1202b;

    /* renamed from: c  reason: collision with other field name */
    public String f1203c;

    /* renamed from: d  reason: collision with other field name */
    public String f1204d;

    /* renamed from: e  reason: collision with other field name */
    public String f1205e;

    /* renamed from: f  reason: collision with other field name */
    public String f1206f;

    /* renamed from: g  reason: collision with other field name */
    public String f1207g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372742, "Lcom/xiaomi/push/hn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372742, "Lcom/xiaomi/push/hn;");
                return;
            }
        }
        f1195a = new jk("ClientUploadDataItem");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", (byte) 10, (short) 4);
        e = new jc("", (byte) 10, (short) 5);
        f = new jc("", (byte) 2, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", StrictLineReader.CR, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
    }

    public hn() {
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
        this.f1198a = new BitSet(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hn hnVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hnVar)) == null) {
            if (hn.class.equals(hnVar.getClass())) {
                int compareTo = Boolean.valueOf(m1341a()).compareTo(Boolean.valueOf(hnVar.m1341a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1341a() || (a12 = iv.a(this.f1197a, hnVar.f1197a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1343b()).compareTo(Boolean.valueOf(hnVar.m1343b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1343b() || (a11 = iv.a(this.f1202b, hnVar.f1202b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1344c()).compareTo(Boolean.valueOf(hnVar.m1344c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1344c() || (a10 = iv.a(this.f1203c, hnVar.f1203c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m1345d()).compareTo(Boolean.valueOf(hnVar.m1345d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m1345d() || (a9 = iv.a(this.f1196a, hnVar.f1196a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m1346e()).compareTo(Boolean.valueOf(hnVar.m1346e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m1346e() || (a8 = iv.a(this.f1201b, hnVar.f1201b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = iv.a(this.f1200a, hnVar.f1200a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = iv.a(this.f1204d, hnVar.f1204d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = iv.a(this.f1205e, hnVar.f1205e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = iv.a(this.f1206f, hnVar.f1206f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hnVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = iv.a(this.f1199a, hnVar.f1199a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hnVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = iv.a(this.f1207g, hnVar.f1207g)) == 0) {
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
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1201b : invokeV.longValue;
    }

    public hn a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f1196a = j2;
            m1340a(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f1197a = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f1199a = map;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f1200a = z;
            c(true);
            return this;
        }
        return (hn) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1337a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1197a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m1338a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1199a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1339a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1339a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1197a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f1202b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1203c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f1196a = jfVar.m1482a();
                        m1340a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f1201b = jfVar.m1482a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f1200a = jfVar.m1492a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1204d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1205e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f1206f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m1485a = jfVar.m1485a();
                        this.f1199a = new HashMap(m1485a.f1531a * 2);
                        for (int i2 = 0; i2 < m1485a.f1531a; i2++) {
                            this.f1199a.put(jfVar.m1488a(), jfVar.m1488a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f1207g = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.f1199a == null) {
                this.f1199a = new HashMap();
            }
            this.f1199a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1340a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f1198a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1341a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1197a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1342a(hn hnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hnVar)) == null) {
            if (hnVar == null) {
                return false;
            }
            boolean m1341a = m1341a();
            boolean m1341a2 = hnVar.m1341a();
            if ((m1341a || m1341a2) && !(m1341a && m1341a2 && this.f1197a.equals(hnVar.f1197a))) {
                return false;
            }
            boolean m1343b = m1343b();
            boolean m1343b2 = hnVar.m1343b();
            if ((m1343b || m1343b2) && !(m1343b && m1343b2 && this.f1202b.equals(hnVar.f1202b))) {
                return false;
            }
            boolean m1344c = m1344c();
            boolean m1344c2 = hnVar.m1344c();
            if ((m1344c || m1344c2) && !(m1344c && m1344c2 && this.f1203c.equals(hnVar.f1203c))) {
                return false;
            }
            boolean m1345d = m1345d();
            boolean m1345d2 = hnVar.m1345d();
            if ((m1345d || m1345d2) && !(m1345d && m1345d2 && this.f1196a == hnVar.f1196a)) {
                return false;
            }
            boolean m1346e = m1346e();
            boolean m1346e2 = hnVar.m1346e();
            if ((m1346e || m1346e2) && !(m1346e && m1346e2 && this.f1201b == hnVar.f1201b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hnVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1200a == hnVar.f1200a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hnVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1204d.equals(hnVar.f1204d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hnVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1205e.equals(hnVar.f1205e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hnVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1206f.equals(hnVar.f1206f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hnVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f1199a.equals(hnVar.f1199a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hnVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f1207g.equals(hnVar.f1207g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hn b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f1201b = j2;
            b(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f1202b = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1203c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jfVar) == null) {
            m1339a();
            jfVar.a(f1195a);
            if (this.f1197a != null && m1341a()) {
                jfVar.a(a);
                jfVar.a(this.f1197a);
                jfVar.b();
            }
            if (this.f1202b != null && m1343b()) {
                jfVar.a(b);
                jfVar.a(this.f1202b);
                jfVar.b();
            }
            if (this.f1203c != null && m1344c()) {
                jfVar.a(c);
                jfVar.a(this.f1203c);
                jfVar.b();
            }
            if (m1345d()) {
                jfVar.a(d);
                jfVar.a(this.f1196a);
                jfVar.b();
            }
            if (m1346e()) {
                jfVar.a(e);
                jfVar.a(this.f1201b);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f1200a);
                jfVar.b();
            }
            if (this.f1204d != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1204d);
                jfVar.b();
            }
            if (this.f1205e != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f1205e);
                jfVar.b();
            }
            if (this.f1206f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f1206f);
                jfVar.b();
            }
            if (this.f1199a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f1199a.size()));
                for (Map.Entry<String, String> entry : this.f1199a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f1207g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f1207g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f1198a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1343b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f1202b != null : invokeV.booleanValue;
    }

    public hn c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f1203c = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1205e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f1198a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1344c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1203c != null : invokeV.booleanValue;
    }

    public hn d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f1204d = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f1206f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1345d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1198a.get(0) : invokeV.booleanValue;
    }

    public hn e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f1205e = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f1207g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m1346e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f1198a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hn)) {
                return m1342a((hn) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hn f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f1206f = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f1198a.get(2) : invokeV.booleanValue;
    }

    public hn g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f1207g = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f1204d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f1205e != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f1206f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f1199a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f1207g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m1341a()) {
                sb.append("channel:");
                String str = this.f1197a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m1343b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f1202b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m1344c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f1203c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m1345d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f1196a);
                z = false;
            }
            if (m1346e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f1201b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f1200a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f1204d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
                z = false;
            }
            if (h()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("sourcePackage:");
                String str5 = this.f1205e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
                z = false;
            }
            if (i()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("id:");
                String str6 = this.f1206f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
                z = false;
            }
            if (j()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("extra:");
                Map<String, String> map = this.f1199a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            } else {
                z2 = z;
            }
            if (k()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("pkgName:");
                String str7 = this.f1207g;
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
