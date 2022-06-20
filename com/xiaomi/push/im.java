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
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class im implements iu<im, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f710a;
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
    public hv f711a;

    /* renamed from: a  reason: collision with other field name */
    public hy f712a;

    /* renamed from: a  reason: collision with other field name */
    public String f713a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f714a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f715a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f716a;

    /* renamed from: b  reason: collision with other field name */
    public String f717b;

    /* renamed from: c  reason: collision with other field name */
    public String f718c;

    /* renamed from: d  reason: collision with other field name */
    public String f719d;

    /* renamed from: e  reason: collision with other field name */
    public String f720e;

    /* renamed from: f  reason: collision with other field name */
    public String f721f;

    /* renamed from: g  reason: collision with other field name */
    public String f722g;

    /* renamed from: h  reason: collision with other field name */
    public String f723h;

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
        f710a = new jk("XmPushActionSendMessage");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 12, (short) 8);
        i = new jc("", (byte) 2, (short) 9);
        j = new jc("", (byte) 13, (short) 10);
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
        this.f714a = new BitSet(1);
        this.f716a = true;
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
                int compareTo = Boolean.valueOf(m500a()).compareTo(Boolean.valueOf(imVar.m500a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m500a() || (a13 = iv.a(this.f713a, imVar.f713a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m502b()).compareTo(Boolean.valueOf(imVar.m502b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m502b() || (a12 = iv.a(this.f712a, imVar.f712a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m503c()).compareTo(Boolean.valueOf(imVar.m503c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m503c() || (a11 = iv.a(this.f717b, imVar.f717b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m504d()).compareTo(Boolean.valueOf(imVar.m504d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m504d() || (a10 = iv.a(this.f718c, imVar.f718c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m505e()).compareTo(Boolean.valueOf(imVar.m505e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m505e() || (a9 = iv.a(this.f719d, imVar.f719d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m506f()).compareTo(Boolean.valueOf(imVar.m506f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m506f() || (a8 = iv.a(this.f720e, imVar.f720e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = iv.a(this.f721f, imVar.f721f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = iv.a(this.f711a, imVar.f711a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = iv.a(this.f716a, imVar.f716a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = iv.a(this.f715a, imVar.f715a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = iv.a(this.f722g, imVar.f722g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = iv.a(this.f723h, imVar.f723h)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f711a : (hv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m498a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f717b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m499a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f717b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f718c != null) {
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
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                m499a();
                return;
            }
            switch (m540a.f802a) {
                case 1:
                    if (b2 == 11) {
                        this.f713a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f712a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f717b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f718c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f719d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f720e = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f721f = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f711a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f716a = jfVar.m549a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m542a = jfVar.m542a();
                        this.f715a = new HashMap(m542a.f804a * 2);
                        for (int i2 = 0; i2 < m542a.f804a; i2++) {
                            this.f715a.put(jfVar.m545a(), jfVar.m545a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f722g = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f723h = jfVar.m545a();
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
            this.f714a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m500a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f713a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m501a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m500a = m500a();
            boolean m500a2 = imVar.m500a();
            if ((m500a || m500a2) && !(m500a && m500a2 && this.f713a.equals(imVar.f713a))) {
                return false;
            }
            boolean m502b = m502b();
            boolean m502b2 = imVar.m502b();
            if ((m502b || m502b2) && !(m502b && m502b2 && this.f712a.m438a(imVar.f712a))) {
                return false;
            }
            boolean m503c = m503c();
            boolean m503c2 = imVar.m503c();
            if ((m503c || m503c2) && !(m503c && m503c2 && this.f717b.equals(imVar.f717b))) {
                return false;
            }
            boolean m504d = m504d();
            boolean m504d2 = imVar.m504d();
            if ((m504d || m504d2) && !(m504d && m504d2 && this.f718c.equals(imVar.f718c))) {
                return false;
            }
            boolean m505e = m505e();
            boolean m505e2 = imVar.m505e();
            if ((m505e || m505e2) && !(m505e && m505e2 && this.f719d.equals(imVar.f719d))) {
                return false;
            }
            boolean m506f = m506f();
            boolean m506f2 = imVar.m506f();
            if ((m506f || m506f2) && !(m506f && m506f2 && this.f720e.equals(imVar.f720e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f721f.equals(imVar.f721f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f711a.m421a(imVar.f711a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f716a == imVar.f716a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = imVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f715a.equals(imVar.f715a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = imVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f722g.equals(imVar.f722g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = imVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f723h.equals(imVar.f723h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f718c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m499a();
            jfVar.a(f710a);
            if (this.f713a != null && m500a()) {
                jfVar.a(a);
                jfVar.a(this.f713a);
                jfVar.b();
            }
            if (this.f712a != null && m502b()) {
                jfVar.a(b);
                this.f712a.b(jfVar);
                jfVar.b();
            }
            if (this.f717b != null) {
                jfVar.a(c);
                jfVar.a(this.f717b);
                jfVar.b();
            }
            if (this.f718c != null) {
                jfVar.a(d);
                jfVar.a(this.f718c);
                jfVar.b();
            }
            if (this.f719d != null && m505e()) {
                jfVar.a(e);
                jfVar.a(this.f719d);
                jfVar.b();
            }
            if (this.f720e != null && m506f()) {
                jfVar.a(f);
                jfVar.a(this.f720e);
                jfVar.b();
            }
            if (this.f721f != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f721f);
                jfVar.b();
            }
            if (this.f711a != null && h()) {
                jfVar.a(h);
                this.f711a.b(jfVar);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f716a);
                jfVar.b();
            }
            if (this.f715a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f715a.size()));
                for (Map.Entry<String, String> entry : this.f715a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f722g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f722g);
                jfVar.b();
            }
            if (this.f723h != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f723h);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m502b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f712a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f720e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m503c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f717b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f721f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m504d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f718c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f722g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m505e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f719d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m501a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f723h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m506f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f720e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f721f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f711a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f714a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f715a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f722g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f723h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m500a()) {
                sb.append("debug:");
                String str = this.f713a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m502b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f712a;
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
            String str2 = this.f717b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f718c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m505e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f719d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m506f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f720e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f721f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hv hvVar = this.f711a;
                if (hvVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hvVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f716a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f715a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f722g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f723h;
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
