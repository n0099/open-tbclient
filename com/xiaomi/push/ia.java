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
import com.bumptech.glide.disklrucache.StrictLineReader;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ia implements iu<ia, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1302a;
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
    public long f1303a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1304a;

    /* renamed from: a  reason: collision with other field name */
    public String f1305a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1306a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f1307a;

    /* renamed from: b  reason: collision with other field name */
    public String f1308b;

    /* renamed from: c  reason: collision with other field name */
    public String f1309c;

    /* renamed from: d  reason: collision with other field name */
    public String f1310d;

    /* renamed from: e  reason: collision with other field name */
    public String f1311e;

    /* renamed from: f  reason: collision with other field name */
    public String f1312f;

    /* renamed from: g  reason: collision with other field name */
    public String f1313g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372184, "Lcom/xiaomi/push/ia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372184, "Lcom/xiaomi/push/ia;");
                return;
            }
        }
        f1302a = new jk("XmPushActionAckNotification");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 10, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", StrictLineReader.CR, (short) 9);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
    }

    public ia() {
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
        this.f1306a = new BitSet(1);
        this.f1303a = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ia iaVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iaVar)) == null) {
            if (ia.class.equals(iaVar.getClass())) {
                int compareTo = Boolean.valueOf(m1386a()).compareTo(Boolean.valueOf(iaVar.m1386a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1386a() || (a11 = iv.a(this.f1305a, iaVar.f1305a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1388b()).compareTo(Boolean.valueOf(iaVar.m1388b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1388b() || (a10 = iv.a(this.f1304a, iaVar.f1304a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iaVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = iv.a(this.f1308b, iaVar.f1308b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iaVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f1309c, iaVar.f1309c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iaVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f1310d, iaVar.f1310d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iaVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f1303a, iaVar.f1303a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iaVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f1311e, iaVar.f1311e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iaVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f1307a, iaVar.f1307a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iaVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f1312f, iaVar.f1312f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iaVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f1313g, iaVar.f1313g)) == 0) {
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
            return ia.class.getName().compareTo(iaVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ia a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f1303a = j2;
            a(true);
            return this;
        }
        return (ia) invokeJ.objValue;
    }

    public ia a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hyVar)) == null) {
            this.f1304a = hyVar;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public ia a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f1308b = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1308b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m1384a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1307a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1385a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f1308b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1385a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1305a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1304a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1308b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1309c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1310d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f1303a = jfVar.m1482a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1311e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        je m1485a = jfVar.m1485a();
                        this.f1307a = new HashMap(m1485a.f1531a * 2);
                        for (int i2 = 0; i2 < m1485a.f1531a; i2++) {
                            this.f1307a.put(jfVar.m1488a(), jfVar.m1488a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f1312f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f1313g = jfVar.m1488a();
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
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f1306a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1386a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1305a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1387a(ia iaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iaVar)) == null) {
            if (iaVar == null) {
                return false;
            }
            boolean m1386a = m1386a();
            boolean m1386a2 = iaVar.m1386a();
            if ((m1386a || m1386a2) && !(m1386a && m1386a2 && this.f1305a.equals(iaVar.f1305a))) {
                return false;
            }
            boolean m1388b = m1388b();
            boolean m1388b2 = iaVar.m1388b();
            if ((m1388b || m1388b2) && !(m1388b && m1388b2 && this.f1304a.m1381a(iaVar.f1304a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = iaVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f1308b.equals(iaVar.f1308b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iaVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1309c.equals(iaVar.f1309c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = iaVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1310d.equals(iaVar.f1310d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iaVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1303a == iaVar.f1303a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iaVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1311e.equals(iaVar.f1311e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iaVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1307a.equals(iaVar.f1307a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iaVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1312f.equals(iaVar.f1312f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iaVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f1313g.equals(iaVar.f1313g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ia b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f1309c = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1310d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jfVar) == null) {
            m1385a();
            jfVar.a(f1302a);
            if (this.f1305a != null && m1386a()) {
                jfVar.a(a);
                jfVar.a(this.f1305a);
                jfVar.b();
            }
            if (this.f1304a != null && m1388b()) {
                jfVar.a(b);
                this.f1304a.b(jfVar);
                jfVar.b();
            }
            if (this.f1308b != null) {
                jfVar.a(c);
                jfVar.a(this.f1308b);
                jfVar.b();
            }
            if (this.f1309c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f1309c);
                jfVar.b();
            }
            if (this.f1310d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f1310d);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f1303a);
                jfVar.b();
            }
            if (this.f1311e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1311e);
                jfVar.b();
            }
            if (this.f1307a != null && h()) {
                jfVar.a(h);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f1307a.size()));
                for (Map.Entry<String, String> entry : this.f1307a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f1312f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f1312f);
                jfVar.b();
            }
            if (this.f1313g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f1313g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1388b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1304a != null : invokeV.booleanValue;
    }

    public ia c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f1310d = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1308b != null : invokeV.booleanValue;
    }

    public ia d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f1311e = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f1309c != null : invokeV.booleanValue;
    }

    public ia e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f1312f = str;
            return this;
        }
        return (ia) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1310d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof ia)) {
                return m1387a((ia) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1306a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1311e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1307a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1312f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f1313g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
            boolean z2 = false;
            if (m1386a()) {
                sb.append("debug:");
                String str = this.f1305a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m1388b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f1304a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f1308b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f1309c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f1310d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f1303a);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str5 = this.f1311e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f1307a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f1312f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f1313g;
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
