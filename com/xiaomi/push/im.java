package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
public class im implements iu<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1437a;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hv f1438a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1439a;

    /* renamed from: a  reason: collision with other field name */
    public String f1440a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1441a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f1442a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1443a;

    /* renamed from: b  reason: collision with other field name */
    public String f1444b;

    /* renamed from: c  reason: collision with other field name */
    public String f1445c;

    /* renamed from: d  reason: collision with other field name */
    public String f1446d;

    /* renamed from: e  reason: collision with other field name */
    public String f1447e;

    /* renamed from: f  reason: collision with other field name */
    public String f1448f;

    /* renamed from: g  reason: collision with other field name */
    public String f1449g;

    /* renamed from: h  reason: collision with other field name */
    public String f1450h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371812, "Lcom/xiaomi/push/im;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371812, "Lcom/xiaomi/push/im;");
                return;
            }
        }
        f1437a = new jk("XmPushActionSendMessage");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 12, (short) 8);
        i = new jc("", (byte) 2, (short) 9);
        j = new jc("", StrictLineReader.CR, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
    }

    public im() {
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
        this.f1441a = new BitSet(1);
        this.f1443a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imVar)) == null) {
            if (im.class.equals(imVar.getClass())) {
                int compareTo = Boolean.valueOf(m1443a()).compareTo(Boolean.valueOf(imVar.m1443a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1443a() || (a13 = iv.a(this.f1440a, imVar.f1440a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1445b()).compareTo(Boolean.valueOf(imVar.m1445b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1445b() || (a12 = iv.a(this.f1439a, imVar.f1439a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1446c()).compareTo(Boolean.valueOf(imVar.m1446c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1446c() || (a11 = iv.a(this.f1444b, imVar.f1444b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m1447d()).compareTo(Boolean.valueOf(imVar.m1447d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m1447d() || (a10 = iv.a(this.f1445c, imVar.f1445c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m1448e()).compareTo(Boolean.valueOf(imVar.m1448e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m1448e() || (a9 = iv.a(this.f1446d, imVar.f1446d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m1449f()).compareTo(Boolean.valueOf(imVar.m1449f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m1449f() || (a8 = iv.a(this.f1447e, imVar.f1447e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = iv.a(this.f1448f, imVar.f1448f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = iv.a(this.f1438a, imVar.f1438a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = iv.a(this.f1443a, imVar.f1443a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = iv.a(this.f1442a, imVar.f1442a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = iv.a(this.f1449g, imVar.f1449g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = iv.a(this.f1450h, imVar.f1450h)) == 0) {
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
            return im.class.getName().compareTo(imVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hv a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1438a : (hv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1441a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1444b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1442a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f1444b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1445c != null) {
            } else {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1442a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1440a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1439a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1444b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1445c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1446d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f1447e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1448f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f1438a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f1443a = jfVar.m1492a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m1485a = jfVar.m1485a();
                        this.f1442a = new HashMap(m1485a.f1531a * 2);
                        for (int i2 = 0; i2 < m1485a.f1531a; i2++) {
                            this.f1442a.put(jfVar.m1488a(), jfVar.m1488a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f1449g = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f1450h = jfVar.m1488a();
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
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f1441a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1443a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f1440a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1444a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m1443a = m1443a();
            boolean m1443a2 = imVar.m1443a();
            if ((m1443a || m1443a2) && !(m1443a && m1443a2 && this.f1440a.equals(imVar.f1440a))) {
                return false;
            }
            boolean m1445b = m1445b();
            boolean m1445b2 = imVar.m1445b();
            if ((m1445b || m1445b2) && !(m1445b && m1445b2 && this.f1439a.m1381a(imVar.f1439a))) {
                return false;
            }
            boolean m1446c = m1446c();
            boolean m1446c2 = imVar.m1446c();
            if ((m1446c || m1446c2) && !(m1446c && m1446c2 && this.f1444b.equals(imVar.f1444b))) {
                return false;
            }
            boolean m1447d = m1447d();
            boolean m1447d2 = imVar.m1447d();
            if ((m1447d || m1447d2) && !(m1447d && m1447d2 && this.f1445c.equals(imVar.f1445c))) {
                return false;
            }
            boolean m1448e = m1448e();
            boolean m1448e2 = imVar.m1448e();
            if ((m1448e || m1448e2) && !(m1448e && m1448e2 && this.f1446d.equals(imVar.f1446d))) {
                return false;
            }
            boolean m1449f = m1449f();
            boolean m1449f2 = imVar.m1449f();
            if ((m1449f || m1449f2) && !(m1449f && m1449f2 && this.f1447e.equals(imVar.f1447e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1448f.equals(imVar.f1448f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1438a.m1364a(imVar.f1438a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1443a == imVar.f1443a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = imVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f1442a.equals(imVar.f1442a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = imVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f1449g.equals(imVar.f1449g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = imVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f1450h.equals(imVar.f1450h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1445c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m1442a();
            jfVar.a(f1437a);
            if (this.f1440a != null && m1443a()) {
                jfVar.a(a);
                jfVar.a(this.f1440a);
                jfVar.b();
            }
            if (this.f1439a != null && m1445b()) {
                jfVar.a(b);
                this.f1439a.b(jfVar);
                jfVar.b();
            }
            if (this.f1444b != null) {
                jfVar.a(c);
                jfVar.a(this.f1444b);
                jfVar.b();
            }
            if (this.f1445c != null) {
                jfVar.a(d);
                jfVar.a(this.f1445c);
                jfVar.b();
            }
            if (this.f1446d != null && m1448e()) {
                jfVar.a(e);
                jfVar.a(this.f1446d);
                jfVar.b();
            }
            if (this.f1447e != null && m1449f()) {
                jfVar.a(f);
                jfVar.a(this.f1447e);
                jfVar.b();
            }
            if (this.f1448f != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1448f);
                jfVar.b();
            }
            if (this.f1438a != null && h()) {
                jfVar.a(h);
                this.f1438a.b(jfVar);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f1443a);
                jfVar.b();
            }
            if (this.f1442a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f1442a.size()));
                for (Map.Entry<String, String> entry : this.f1442a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f1449g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f1449g);
                jfVar.b();
            }
            if (this.f1450h != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f1450h);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1445b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1439a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1447e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1446c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1444b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1448f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1447d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1445c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1449g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m1448e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1446d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m1444a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f1450h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m1449f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1447e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f1448f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f1438a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1441a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f1442a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f1449g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1450h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m1443a()) {
                sb.append("debug:");
                String str = this.f1440a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m1445b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f1439a;
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
            String str2 = this.f1444b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f1445c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m1448e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f1446d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m1449f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f1447e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f1448f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hv hvVar = this.f1438a;
                if (hvVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hvVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f1443a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f1442a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f1449g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f1450h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
