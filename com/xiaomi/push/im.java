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
    public static final jk f741a;
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
    public hv f742a;

    /* renamed from: a  reason: collision with other field name */
    public hy f743a;

    /* renamed from: a  reason: collision with other field name */
    public String f744a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f745a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f746a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f747a;

    /* renamed from: b  reason: collision with other field name */
    public String f748b;

    /* renamed from: c  reason: collision with other field name */
    public String f749c;

    /* renamed from: d  reason: collision with other field name */
    public String f750d;

    /* renamed from: e  reason: collision with other field name */
    public String f751e;

    /* renamed from: f  reason: collision with other field name */
    public String f752f;

    /* renamed from: g  reason: collision with other field name */
    public String f753g;

    /* renamed from: h  reason: collision with other field name */
    public String f754h;

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
        f741a = new jk("XmPushActionSendMessage");
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
        this.f745a = new BitSet(1);
        this.f747a = true;
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
                int compareTo = Boolean.valueOf(m515a()).compareTo(Boolean.valueOf(imVar.m515a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m515a() || (a13 = iv.a(this.f744a, imVar.f744a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m517b()).compareTo(Boolean.valueOf(imVar.m517b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m517b() || (a12 = iv.a(this.f743a, imVar.f743a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m518c()).compareTo(Boolean.valueOf(imVar.m518c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m518c() || (a11 = iv.a(this.f748b, imVar.f748b)) == 0) {
                            int compareTo4 = Boolean.valueOf(m519d()).compareTo(Boolean.valueOf(imVar.m519d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m519d() || (a10 = iv.a(this.f749c, imVar.f749c)) == 0) {
                                int compareTo5 = Boolean.valueOf(m520e()).compareTo(Boolean.valueOf(imVar.m520e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m520e() || (a9 = iv.a(this.f750d, imVar.f750d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(m521f()).compareTo(Boolean.valueOf(imVar.m521f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!m521f() || (a8 = iv.a(this.f751e, imVar.f751e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = iv.a(this.f752f, imVar.f752f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = iv.a(this.f742a, imVar.f742a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = iv.a(this.f747a, imVar.f747a)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = iv.a(this.f746a, imVar.f746a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = iv.a(this.f753g, imVar.f753g)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = iv.a(this.f754h, imVar.f754h)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f742a : (hv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m513a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f748b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m514a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f748b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f749c != null) {
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
        jfVar.m559a();
        while (true) {
            jc m555a = jfVar.m555a();
            byte b2 = m555a.a;
            if (b2 == 0) {
                jfVar.f();
                m514a();
                return;
            }
            switch (m555a.f833a) {
                case 1:
                    if (b2 == 11) {
                        this.f744a = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f743a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f748b = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f749c = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f750d = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f751e = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f752f = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f742a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f747a = jfVar.m564a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m557a = jfVar.m557a();
                        this.f746a = new HashMap(m557a.f835a * 2);
                        for (int i2 = 0; i2 < m557a.f835a; i2++) {
                            this.f746a.put(jfVar.m560a(), jfVar.m560a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f753g = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f754h = jfVar.m560a();
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
            this.f745a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m515a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f744a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m516a(im imVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imVar)) == null) {
            if (imVar == null) {
                return false;
            }
            boolean m515a = m515a();
            boolean m515a2 = imVar.m515a();
            if ((m515a || m515a2) && !(m515a && m515a2 && this.f744a.equals(imVar.f744a))) {
                return false;
            }
            boolean m517b = m517b();
            boolean m517b2 = imVar.m517b();
            if ((m517b || m517b2) && !(m517b && m517b2 && this.f743a.m453a(imVar.f743a))) {
                return false;
            }
            boolean m518c = m518c();
            boolean m518c2 = imVar.m518c();
            if ((m518c || m518c2) && !(m518c && m518c2 && this.f748b.equals(imVar.f748b))) {
                return false;
            }
            boolean m519d = m519d();
            boolean m519d2 = imVar.m519d();
            if ((m519d || m519d2) && !(m519d && m519d2 && this.f749c.equals(imVar.f749c))) {
                return false;
            }
            boolean m520e = m520e();
            boolean m520e2 = imVar.m520e();
            if ((m520e || m520e2) && !(m520e && m520e2 && this.f750d.equals(imVar.f750d))) {
                return false;
            }
            boolean m521f = m521f();
            boolean m521f2 = imVar.m521f();
            if ((m521f || m521f2) && !(m521f && m521f2 && this.f751e.equals(imVar.f751e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = imVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f752f.equals(imVar.f752f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = imVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f742a.m436a(imVar.f742a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = imVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f747a == imVar.f747a)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = imVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f746a.equals(imVar.f746a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = imVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f753g.equals(imVar.f753g))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = imVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f754h.equals(imVar.f754h);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f749c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m514a();
            jfVar.a(f741a);
            if (this.f744a != null && m515a()) {
                jfVar.a(a);
                jfVar.a(this.f744a);
                jfVar.b();
            }
            if (this.f743a != null && m517b()) {
                jfVar.a(b);
                this.f743a.b(jfVar);
                jfVar.b();
            }
            if (this.f748b != null) {
                jfVar.a(c);
                jfVar.a(this.f748b);
                jfVar.b();
            }
            if (this.f749c != null) {
                jfVar.a(d);
                jfVar.a(this.f749c);
                jfVar.b();
            }
            if (this.f750d != null && m520e()) {
                jfVar.a(e);
                jfVar.a(this.f750d);
                jfVar.b();
            }
            if (this.f751e != null && m521f()) {
                jfVar.a(f);
                jfVar.a(this.f751e);
                jfVar.b();
            }
            if (this.f752f != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f752f);
                jfVar.b();
            }
            if (this.f742a != null && h()) {
                jfVar.a(h);
                this.f742a.b(jfVar);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f747a);
                jfVar.b();
            }
            if (this.f746a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f746a.size()));
                for (Map.Entry<String, String> entry : this.f746a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f753g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f753g);
                jfVar.b();
            }
            if (this.f754h != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f754h);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m563a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m517b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f743a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f751e : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m518c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f748b != null : invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f752f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m519d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f749c != null : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f753g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m520e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f750d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof im)) {
                return m516a((im) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f754h : (String) invokeV.objValue;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m521f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f751e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f752f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f742a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f745a.get(0) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f746a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f753g != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f754h != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
            boolean z2 = false;
            if (m515a()) {
                sb.append("debug:");
                String str = this.f744a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m517b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f743a;
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
            String str2 = this.f748b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f749c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (m520e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f750d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (m521f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f751e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str6 = this.f752f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("message:");
                hv hvVar = this.f742a;
                if (hvVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hvVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f747a);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("params:");
                Map<String, String> map = this.f746a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f753g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str8 = this.f754h;
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
