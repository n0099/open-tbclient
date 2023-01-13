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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ik implements iu<ik, Object>, Serializable, Cloneable {
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
    public static final jc m;
    public static final jc n;
    public static final jc o;
    public static final jc p;
    public static final jc q;
    public static final jc r;
    public static final jc s;
    public static final jc t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f711a;

    /* renamed from: a  reason: collision with other field name */
    public long f712a;

    /* renamed from: a  reason: collision with other field name */
    public hy f713a;

    /* renamed from: a  reason: collision with other field name */
    public String f714a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f715a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f716a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f717a;

    /* renamed from: b  reason: collision with other field name */
    public int f718b;

    /* renamed from: b  reason: collision with other field name */
    public long f719b;

    /* renamed from: b  reason: collision with other field name */
    public String f720b;

    /* renamed from: c  reason: collision with other field name */
    public long f721c;

    /* renamed from: c  reason: collision with other field name */
    public String f722c;

    /* renamed from: d  reason: collision with other field name */
    public String f723d;

    /* renamed from: e  reason: collision with other field name */
    public String f724e;

    /* renamed from: f  reason: collision with other field name */
    public String f725f;

    /* renamed from: g  reason: collision with other field name */
    public String f726g;

    /* renamed from: h  reason: collision with other field name */
    public String f727h;

    /* renamed from: i  reason: collision with other field name */
    public String f728i;

    /* renamed from: j  reason: collision with other field name */
    public String f729j;

    /* renamed from: k  reason: collision with other field name */
    public String f730k;

    /* renamed from: l  reason: collision with other field name */
    public String f731l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371874, "Lcom/xiaomi/push/ik;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371874, "Lcom/xiaomi/push/ik;");
                return;
            }
        }
        f710a = new jk("XmPushActionRegistrationResult");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        j = new jc("", (byte) 10, (short) 11);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 13);
        m = new jc("", (byte) 10, (short) 14);
        n = new jc("", Constants.GZIP_CAST_TYPE, (short) 15);
        o = new jc("", (byte) 8, (short) 16);
        p = new jc("", Constants.GZIP_CAST_TYPE, (short) 17);
        q = new jc("", (byte) 8, (short) 18);
        r = new jc("", Constants.GZIP_CAST_TYPE, (short) 19);
        s = new jc("", (byte) 2, (short) 20);
        t = new jc("", (byte) 15, (short) 21);
    }

    public ik() {
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
        this.f715a = new BitSet(6);
        this.f717a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
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
        int a17;
        int a18;
        int a19;
        int a20;
        int a21;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ikVar)) == null) {
            if (ik.class.equals(ikVar.getClass())) {
                int compareTo = Boolean.valueOf(m570a()).compareTo(Boolean.valueOf(ikVar.m570a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m570a() || (a21 = iv.a(this.f714a, ikVar.f714a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m572b()).compareTo(Boolean.valueOf(ikVar.m572b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m572b() || (a20 = iv.a(this.f713a, ikVar.f713a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m573c()).compareTo(Boolean.valueOf(ikVar.m573c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m573c() || (a19 = iv.a(this.f720b, ikVar.f720b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a18 = iv.a(this.f722c, ikVar.f722c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a17 = iv.a(this.f712a, ikVar.f712a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a16 = iv.a(this.f723d, ikVar.f723d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a15 = iv.a(this.f724e, ikVar.f724e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a14 = iv.a(this.f725f, ikVar.f725f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a13 = iv.a(this.f726g, ikVar.f726g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a12 = iv.a(this.f719b, ikVar.f719b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a11 = iv.a(this.f727h, ikVar.f727h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a10 = iv.a(this.f728i, ikVar.f728i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ikVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a9 = iv.a(this.f721c, ikVar.f721c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ikVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a8 = iv.a(this.f729j, ikVar.f729j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ikVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a7 = iv.a(this.f711a, ikVar.f711a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ikVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a6 = iv.a(this.f730k, ikVar.f730k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ikVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a5 = iv.a(this.f718b, ikVar.f718b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ikVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a4 = iv.a(this.f731l, ikVar.f731l)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ikVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a3 = iv.a(this.f717a, ikVar.f717a)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ikVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a2 = iv.a(this.f716a, ikVar.f716a)) == 0) {
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
                                return a17;
                            }
                            return a18;
                        }
                        return a19;
                    }
                    return a20;
                }
                return a21;
            }
            return ik.class.getName().compareTo(ikVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f712a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m567a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f720b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m568a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f716a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m569a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f720b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f722c != null) {
            } else {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jfVar) != null) {
            return;
        }
        jfVar.mo622a();
        while (true) {
            jc mo618a = jfVar.mo618a();
            byte b2 = mo618a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    m569a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo618a.f833a) {
                case 1:
                    if (b2 == 11) {
                        this.f714a = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f713a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f720b = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f722c = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f712a = jfVar.mo617a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f723d = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f724e = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f725f = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f726g = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f719b = jfVar.mo617a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f727h = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f728i = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f721c = jfVar.mo617a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f729j = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f711a = jfVar.mo616a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f730k = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f718b = jfVar.mo616a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f731l = jfVar.mo623a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f717a = jfVar.mo628a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        jd mo619a = jfVar.mo619a();
                        this.f716a = new ArrayList(mo619a.f834a);
                        for (int i2 = 0; i2 < mo619a.f834a; i2++) {
                            this.f716a.add(jfVar.mo623a());
                        }
                        jfVar.i();
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
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f715a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m570a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f714a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m571a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m570a = m570a();
            boolean m570a2 = ikVar.m570a();
            if ((m570a || m570a2) && !(m570a && m570a2 && this.f714a.equals(ikVar.f714a))) {
                return false;
            }
            boolean m572b = m572b();
            boolean m572b2 = ikVar.m572b();
            if ((m572b || m572b2) && !(m572b && m572b2 && this.f713a.m516a(ikVar.f713a))) {
                return false;
            }
            boolean m573c = m573c();
            boolean m573c2 = ikVar.m573c();
            if ((m573c || m573c2) && !(m573c && m573c2 && this.f720b.equals(ikVar.f720b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f722c.equals(ikVar.f722c))) || this.f712a != ikVar.f712a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f723d.equals(ikVar.f723d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f724e.equals(ikVar.f724e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f725f.equals(ikVar.f725f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f726g.equals(ikVar.f726g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ikVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f719b == ikVar.f719b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ikVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f727h.equals(ikVar.f727h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ikVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f728i.equals(ikVar.f728i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ikVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f721c == ikVar.f721c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ikVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f729j.equals(ikVar.f729j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ikVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f711a == ikVar.f711a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = ikVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f730k.equals(ikVar.f730k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = ikVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f718b == ikVar.f718b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = ikVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f731l.equals(ikVar.f731l))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = ikVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f717a == ikVar.f717a)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = ikVar.t();
            if (t2 || t3) {
                return t2 && t3 && this.f716a.equals(ikVar.f716a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f725f : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m569a();
            jfVar.a(f710a);
            if (this.f714a != null && m570a()) {
                jfVar.a(a);
                jfVar.a(this.f714a);
                jfVar.b();
            }
            if (this.f713a != null && m572b()) {
                jfVar.a(b);
                this.f713a.b(jfVar);
                jfVar.b();
            }
            if (this.f720b != null) {
                jfVar.a(c);
                jfVar.a(this.f720b);
                jfVar.b();
            }
            if (this.f722c != null) {
                jfVar.a(d);
                jfVar.a(this.f722c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f712a);
            jfVar.b();
            if (this.f723d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f723d);
                jfVar.b();
            }
            if (this.f724e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f724e);
                jfVar.b();
            }
            if (this.f725f != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f725f);
                jfVar.b();
            }
            if (this.f726g != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f726g);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f719b);
                jfVar.b();
            }
            if (this.f727h != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f727h);
                jfVar.b();
            }
            if (this.f728i != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f728i);
                jfVar.b();
            }
            if (m()) {
                jfVar.a(m);
                jfVar.a(this.f721c);
                jfVar.b();
            }
            if (this.f729j != null && n()) {
                jfVar.a(n);
                jfVar.a(this.f729j);
                jfVar.b();
            }
            if (o()) {
                jfVar.a(o);
                jfVar.mo627a(this.f711a);
                jfVar.b();
            }
            if (this.f730k != null && p()) {
                jfVar.a(p);
                jfVar.a(this.f730k);
                jfVar.b();
            }
            if (q()) {
                jfVar.a(q);
                jfVar.mo627a(this.f718b);
                jfVar.b();
            }
            if (this.f731l != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f731l);
                jfVar.b();
            }
            if (s()) {
                jfVar.a(s);
                jfVar.a(this.f717a);
                jfVar.b();
            }
            if (this.f716a != null && t()) {
                jfVar.a(t);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f716a.size()));
                for (String str : this.f716a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.mo626a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f715a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m572b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f713a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f726g : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f715a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m573c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f720b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f715a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f722c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f715a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f715a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m571a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f715a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f723d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f724e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f725f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f726g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f715a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f727h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f728i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f715a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f729j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f715a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f730k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f715a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f731l != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f715a.get(5) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f716a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
            boolean z2 = false;
            if (m570a()) {
                sb.append("debug:");
                String str = this.f714a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m572b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f713a;
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
            String str2 = this.f720b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f722c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f712a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f723d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f724e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f725f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f726g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f719b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f727h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f728i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f721c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f729j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f711a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f730k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f718b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f731l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f717a);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("autoMarkPkgs:");
                List<String> list = this.f716a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
