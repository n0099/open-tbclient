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
    public static final jk f679a;
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
    public int f680a;

    /* renamed from: a  reason: collision with other field name */
    public long f681a;

    /* renamed from: a  reason: collision with other field name */
    public hy f682a;

    /* renamed from: a  reason: collision with other field name */
    public String f683a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f684a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f685a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f686a;

    /* renamed from: b  reason: collision with other field name */
    public int f687b;

    /* renamed from: b  reason: collision with other field name */
    public long f688b;

    /* renamed from: b  reason: collision with other field name */
    public String f689b;

    /* renamed from: c  reason: collision with other field name */
    public long f690c;

    /* renamed from: c  reason: collision with other field name */
    public String f691c;

    /* renamed from: d  reason: collision with other field name */
    public String f692d;

    /* renamed from: e  reason: collision with other field name */
    public String f693e;

    /* renamed from: f  reason: collision with other field name */
    public String f694f;

    /* renamed from: g  reason: collision with other field name */
    public String f695g;

    /* renamed from: h  reason: collision with other field name */
    public String f696h;

    /* renamed from: i  reason: collision with other field name */
    public String f697i;

    /* renamed from: j  reason: collision with other field name */
    public String f698j;

    /* renamed from: k  reason: collision with other field name */
    public String f699k;

    /* renamed from: l  reason: collision with other field name */
    public String f700l;

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
        f679a = new jk("XmPushActionRegistrationResult");
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
        this.f684a = new BitSet(6);
        this.f686a = false;
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
                int compareTo = Boolean.valueOf(m492a()).compareTo(Boolean.valueOf(ikVar.m492a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m492a() || (a21 = iv.a(this.f683a, ikVar.f683a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m494b()).compareTo(Boolean.valueOf(ikVar.m494b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m494b() || (a20 = iv.a(this.f682a, ikVar.f682a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m495c()).compareTo(Boolean.valueOf(ikVar.m495c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m495c() || (a19 = iv.a(this.f689b, ikVar.f689b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a18 = iv.a(this.f691c, ikVar.f691c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a17 = iv.a(this.f681a, ikVar.f681a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a16 = iv.a(this.f692d, ikVar.f692d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a15 = iv.a(this.f693e, ikVar.f693e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a14 = iv.a(this.f694f, ikVar.f694f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a13 = iv.a(this.f695g, ikVar.f695g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a12 = iv.a(this.f688b, ikVar.f688b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a11 = iv.a(this.f696h, ikVar.f696h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a10 = iv.a(this.f697i, ikVar.f697i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ikVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a9 = iv.a(this.f690c, ikVar.f690c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ikVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a8 = iv.a(this.f698j, ikVar.f698j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ikVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a7 = iv.a(this.f680a, ikVar.f680a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ikVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a6 = iv.a(this.f699k, ikVar.f699k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ikVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a5 = iv.a(this.f687b, ikVar.f687b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ikVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a4 = iv.a(this.f700l, ikVar.f700l)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ikVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a3 = iv.a(this.f686a, ikVar.f686a)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ikVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a2 = iv.a(this.f685a, ikVar.f685a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f681a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m489a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f689b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m490a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f685a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m491a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f689b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f691c != null) {
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
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    m491a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m540a.f802a) {
                case 1:
                    if (b2 == 11) {
                        this.f683a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f682a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f689b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f691c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f681a = jfVar.m539a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f692d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f693e = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f694f = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f695g = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f688b = jfVar.m539a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f696h = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f697i = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f690c = jfVar.m539a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f698j = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f680a = jfVar.m538a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f699k = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f687b = jfVar.m538a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f700l = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f686a = jfVar.m549a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        jd m541a = jfVar.m541a();
                        this.f685a = new ArrayList(m541a.f803a);
                        for (int i2 = 0; i2 < m541a.f803a; i2++) {
                            this.f685a.add(jfVar.m545a());
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
            this.f684a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m492a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f683a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m493a(ik ikVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ikVar)) == null) {
            if (ikVar == null) {
                return false;
            }
            boolean m492a = m492a();
            boolean m492a2 = ikVar.m492a();
            if ((m492a || m492a2) && !(m492a && m492a2 && this.f683a.equals(ikVar.f683a))) {
                return false;
            }
            boolean m494b = m494b();
            boolean m494b2 = ikVar.m494b();
            if ((m494b || m494b2) && !(m494b && m494b2 && this.f682a.m438a(ikVar.f682a))) {
                return false;
            }
            boolean m495c = m495c();
            boolean m495c2 = ikVar.m495c();
            if ((m495c || m495c2) && !(m495c && m495c2 && this.f689b.equals(ikVar.f689b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ikVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f691c.equals(ikVar.f691c))) || this.f681a != ikVar.f681a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ikVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f692d.equals(ikVar.f692d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ikVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f693e.equals(ikVar.f693e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ikVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f694f.equals(ikVar.f694f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ikVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f695g.equals(ikVar.f695g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ikVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f688b == ikVar.f688b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ikVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f696h.equals(ikVar.f696h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ikVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f697i.equals(ikVar.f697i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = ikVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f690c == ikVar.f690c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = ikVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f698j.equals(ikVar.f698j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = ikVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f680a == ikVar.f680a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = ikVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f699k.equals(ikVar.f699k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = ikVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f687b == ikVar.f687b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = ikVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f700l.equals(ikVar.f700l))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = ikVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f686a == ikVar.f686a)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = ikVar.t();
            if (t2 || t3) {
                return t2 && t3 && this.f685a.equals(ikVar.f685a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f694f : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m491a();
            jfVar.a(f679a);
            if (this.f683a != null && m492a()) {
                jfVar.a(a);
                jfVar.a(this.f683a);
                jfVar.b();
            }
            if (this.f682a != null && m494b()) {
                jfVar.a(b);
                this.f682a.b(jfVar);
                jfVar.b();
            }
            if (this.f689b != null) {
                jfVar.a(c);
                jfVar.a(this.f689b);
                jfVar.b();
            }
            if (this.f691c != null) {
                jfVar.a(d);
                jfVar.a(this.f691c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f681a);
            jfVar.b();
            if (this.f692d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f692d);
                jfVar.b();
            }
            if (this.f693e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f693e);
                jfVar.b();
            }
            if (this.f694f != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f694f);
                jfVar.b();
            }
            if (this.f695g != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f695g);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f688b);
                jfVar.b();
            }
            if (this.f696h != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f696h);
                jfVar.b();
            }
            if (this.f697i != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f697i);
                jfVar.b();
            }
            if (m()) {
                jfVar.a(m);
                jfVar.a(this.f690c);
                jfVar.b();
            }
            if (this.f698j != null && n()) {
                jfVar.a(n);
                jfVar.a(this.f698j);
                jfVar.b();
            }
            if (o()) {
                jfVar.a(o);
                jfVar.a(this.f680a);
                jfVar.b();
            }
            if (this.f699k != null && p()) {
                jfVar.a(p);
                jfVar.a(this.f699k);
                jfVar.b();
            }
            if (q()) {
                jfVar.a(q);
                jfVar.a(this.f687b);
                jfVar.b();
            }
            if (this.f700l != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f700l);
                jfVar.b();
            }
            if (s()) {
                jfVar.a(s);
                jfVar.a(this.f686a);
                jfVar.b();
            }
            if (this.f685a != null && t()) {
                jfVar.a(t);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f685a.size()));
                for (String str : this.f685a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f684a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m494b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f682a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f695g : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f684a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m495c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f689b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f684a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f691c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f684a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f684a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof ik)) {
                return m493a((ik) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f684a.set(5, z);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f692d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f693e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f694f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f695g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f684a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f696h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f697i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f684a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f698j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f684a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f699k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f684a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f700l != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f684a.get(5) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f685a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
            boolean z2 = false;
            if (m492a()) {
                sb.append("debug:");
                String str = this.f683a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m494b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f682a;
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
            String str2 = this.f689b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f691c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f681a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f692d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f693e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f694f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f695g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f688b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f696h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f697i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f690c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f698j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f680a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f699k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f687b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f700l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isHybridFrame:");
                sb.append(this.f686a);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("autoMarkPkgs:");
                List<String> list = this.f685a;
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
