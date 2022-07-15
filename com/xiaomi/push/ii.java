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
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ii implements iu<ii, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1358a;
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
    public static final jc n;
    public static final jc o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1359a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1360a;

    /* renamed from: a  reason: collision with other field name */
    public String f1361a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f1362a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1363a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f1364a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1365a;

    /* renamed from: b  reason: collision with other field name */
    public String f1366b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1367b;

    /* renamed from: c  reason: collision with other field name */
    public String f1368c;

    /* renamed from: d  reason: collision with other field name */
    public String f1369d;

    /* renamed from: e  reason: collision with other field name */
    public String f1370e;

    /* renamed from: f  reason: collision with other field name */
    public String f1371f;

    /* renamed from: g  reason: collision with other field name */
    public String f1372g;

    /* renamed from: h  reason: collision with other field name */
    public String f1373h;

    /* renamed from: i  reason: collision with other field name */
    public String f1374i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371936, "Lcom/xiaomi/push/ii;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371936, "Lcom/xiaomi/push/ii;");
                return;
            }
        }
        f1358a = new jk("XmPushActionNotification");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", (byte) 2, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", StrictLineReader.CR, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 13);
        m = new jc("", Constants.GZIP_CAST_TYPE, (short) 14);
        n = new jc("", (byte) 10, (short) 15);
        o = new jc("", (byte) 2, (short) 20);
    }

    public ii() {
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
        this.f1363a = new BitSet(3);
        this.f1365a = true;
        this.f1367b = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ii(String str, boolean z) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f1366b = str;
        this.f1365a = z;
        m1421a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        int a15;
        int a16;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iiVar)) == null) {
            if (ii.class.equals(iiVar.getClass())) {
                int compareTo = Boolean.valueOf(m1422a()).compareTo(Boolean.valueOf(iiVar.m1422a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1422a() || (a16 = iv.a(this.f1361a, iiVar.f1361a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1425b()).compareTo(Boolean.valueOf(iiVar.m1425b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1425b() || (a15 = iv.a(this.f1360a, iiVar.f1360a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1426c()).compareTo(Boolean.valueOf(iiVar.m1426c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1426c() || (a14 = iv.a(this.f1366b, iiVar.f1366b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a13 = iv.a(this.f1368c, iiVar.f1368c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a12 = iv.a(this.f1369d, iiVar.f1369d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a11 = iv.a(this.f1365a, iiVar.f1365a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a10 = iv.a(this.f1370e, iiVar.f1370e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a9 = iv.a(this.f1364a, iiVar.f1364a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a8 = iv.a(this.f1371f, iiVar.f1371f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a7 = iv.a(this.f1372g, iiVar.f1372g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a6 = iv.a(this.f1373h, iiVar.f1373h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a5 = iv.a(this.f1374i, iiVar.f1374i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iiVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a4 = iv.a(this.f1362a, iiVar.f1362a)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iiVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a3 = iv.a(this.f1359a, iiVar.f1359a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iiVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a2 = iv.a(this.f1367b, iiVar.f1367b)) == 0) {
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
                    return a15;
                }
                return a16;
            }
            return ii.class.getName().compareTo(iiVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hy a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1360a : (hy) invokeV.objValue;
    }

    public ii a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f1366b = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            this.f1362a = byteBuffer;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f1364a = map;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public ii a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f1365a = z;
            m1421a(true);
            return this;
        }
        return (ii) invokeZ.objValue;
    }

    public ii a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        return (ii) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1418a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1366b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m1419a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1364a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1420a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f1366b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                if (f()) {
                    m1420a();
                    return;
                }
                throw new jg("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1361a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1360a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1366b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1368c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1369d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f1365a = jfVar.m1492a();
                        m1421a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1370e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        je m1485a = jfVar.m1485a();
                        this.f1364a = new HashMap(m1485a.f1531a * 2);
                        for (int i2 = 0; i2 < m1485a.f1531a; i2++) {
                            this.f1364a.put(jfVar.m1488a(), jfVar.m1488a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f1371f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f1372g = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f1373h = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f1374i = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f1362a = jfVar.m1489a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f1359a = jfVar.m1482a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f1367b = jfVar.m1492a();
                        c(true);
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
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            if (this.f1364a == null) {
                this.f1364a = new HashMap();
            }
            this.f1364a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1421a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f1363a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1422a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1361a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1423a(ii iiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, iiVar)) == null) {
            if (iiVar == null) {
                return false;
            }
            boolean m1422a = m1422a();
            boolean m1422a2 = iiVar.m1422a();
            if ((m1422a || m1422a2) && !(m1422a && m1422a2 && this.f1361a.equals(iiVar.f1361a))) {
                return false;
            }
            boolean m1425b = m1425b();
            boolean m1425b2 = iiVar.m1425b();
            if ((m1425b || m1425b2) && !(m1425b && m1425b2 && this.f1360a.m1381a(iiVar.f1360a))) {
                return false;
            }
            boolean m1426c = m1426c();
            boolean m1426c2 = iiVar.m1426c();
            if ((m1426c || m1426c2) && !(m1426c && m1426c2 && this.f1366b.equals(iiVar.f1366b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iiVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1368c.equals(iiVar.f1368c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = iiVar.e();
            if (((e2 || e3) && !(e2 && e3 && this.f1369d.equals(iiVar.f1369d))) || this.f1365a != iiVar.f1365a) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iiVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1370e.equals(iiVar.f1370e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iiVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1364a.equals(iiVar.f1364a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iiVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1371f.equals(iiVar.f1371f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = iiVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f1372g.equals(iiVar.f1372g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = iiVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f1373h.equals(iiVar.f1373h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = iiVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f1374i.equals(iiVar.f1374i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = iiVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f1362a.equals(iiVar.f1362a))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = iiVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f1359a == iiVar.f1359a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = iiVar.o();
            if (o2 || o3) {
                return o2 && o3 && this.f1367b == iiVar.f1367b;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1424a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            a(iv.a(this.f1362a));
            return this.f1362a.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public ii b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f1368c = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1368c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jfVar) == null) {
            m1420a();
            jfVar.a(f1358a);
            if (this.f1361a != null && m1422a()) {
                jfVar.a(a);
                jfVar.a(this.f1361a);
                jfVar.b();
            }
            if (this.f1360a != null && m1425b()) {
                jfVar.a(b);
                this.f1360a.b(jfVar);
                jfVar.b();
            }
            if (this.f1366b != null) {
                jfVar.a(c);
                jfVar.a(this.f1366b);
                jfVar.b();
            }
            if (this.f1368c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f1368c);
                jfVar.b();
            }
            if (this.f1369d != null && e()) {
                jfVar.a(e);
                jfVar.a(this.f1369d);
                jfVar.b();
            }
            jfVar.a(f);
            jfVar.a(this.f1365a);
            jfVar.b();
            if (this.f1370e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1370e);
                jfVar.b();
            }
            if (this.f1364a != null && h()) {
                jfVar.a(h);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f1364a.size()));
                for (Map.Entry<String, String> entry : this.f1364a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f1371f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f1371f);
                jfVar.b();
            }
            if (this.f1372g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f1372g);
                jfVar.b();
            }
            if (this.f1373h != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f1373h);
                jfVar.b();
            }
            if (this.f1374i != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f1374i);
                jfVar.b();
            }
            if (this.f1362a != null && m()) {
                jfVar.a(m);
                jfVar.a(this.f1362a);
                jfVar.b();
            }
            if (n()) {
                jfVar.a(n);
                jfVar.a(this.f1359a);
                jfVar.b();
            }
            if (o()) {
                jfVar.a(o);
                jfVar.a(this.f1367b);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f1363a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1425b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1360a != null : invokeV.booleanValue;
    }

    public ii c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            this.f1369d = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f1371f : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f1363a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1426c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1366b != null : invokeV.booleanValue;
    }

    public ii d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            this.f1371f = str;
            return this;
        }
        return (ii) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1368c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f1369d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, obj)) == null) {
            if (obj != null && (obj instanceof ii)) {
                return m1423a((ii) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f1363a.get(0) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f1370e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f1364a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f1371f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f1372g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f1373h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f1374i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f1362a != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f1363a.get(1) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f1363a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionNotification(");
            boolean z2 = false;
            if (m1422a()) {
                sb.append("debug:");
                String str = this.f1361a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m1425b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f1360a;
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
            String str2 = this.f1366b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f1368c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                String str4 = this.f1369d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("requireAck:");
            sb.append(this.f1365a);
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("payload:");
                String str5 = this.f1370e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f1364a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f1371f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f1372g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f1373h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f1374i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("binaryExtra:");
                ByteBuffer byteBuffer = this.f1362a;
                if (byteBuffer == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    iv.a(byteBuffer, sb);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f1359a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("alreadyLogClickInXmq:");
                sb.append(this.f1367b);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
