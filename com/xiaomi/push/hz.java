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
public class hz implements iu<hz, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f561a;
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
    public int f562a;

    /* renamed from: a  reason: collision with other field name */
    public long f563a;

    /* renamed from: a  reason: collision with other field name */
    public hy f564a;

    /* renamed from: a  reason: collision with other field name */
    public im f565a;

    /* renamed from: a  reason: collision with other field name */
    public String f566a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f567a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f568a;

    /* renamed from: a  reason: collision with other field name */
    public short f569a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f570a;

    /* renamed from: b  reason: collision with other field name */
    public String f571b;

    /* renamed from: b  reason: collision with other field name */
    public short f572b;

    /* renamed from: c  reason: collision with other field name */
    public String f573c;

    /* renamed from: d  reason: collision with other field name */
    public String f574d;

    /* renamed from: e  reason: collision with other field name */
    public String f575e;

    /* renamed from: f  reason: collision with other field name */
    public String f576f;

    /* renamed from: g  reason: collision with other field name */
    public String f577g;

    /* renamed from: h  reason: collision with other field name */
    public String f578h;

    /* renamed from: i  reason: collision with other field name */
    public String f579i;

    /* renamed from: j  reason: collision with other field name */
    public String f580j;

    /* renamed from: k  reason: collision with other field name */
    public String f581k;

    /* renamed from: l  reason: collision with other field name */
    public String f582l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372370, "Lcom/xiaomi/push/hz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372370, "Lcom/xiaomi/push/hz;");
                return;
            }
        }
        f561a = new jk("XmPushActionAckMessage");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 12, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new jc("", (byte) 2, (short) 11);
        l = new jc("", Constants.GZIP_CAST_TYPE, (short) 12);
        m = new jc("", Constants.GZIP_CAST_TYPE, (short) 13);
        n = new jc("", Constants.GZIP_CAST_TYPE, (short) 14);
        o = new jc("", (byte) 6, (short) 15);
        p = new jc("", (byte) 6, (short) 16);
        q = new jc("", Constants.GZIP_CAST_TYPE, (short) 20);
        r = new jc("", Constants.GZIP_CAST_TYPE, (short) 21);
        s = new jc("", (byte) 8, (short) 22);
        t = new jc("", StrictLineReader.CR, (short) 23);
    }

    public hz() {
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
        this.f567a = new BitSet(5);
        this.f570a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hzVar)) == null) {
            if (hz.class.equals(hzVar.getClass())) {
                int compareTo = Boolean.valueOf(m444a()).compareTo(Boolean.valueOf(hzVar.m444a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m444a() || (a21 = iv.a(this.f566a, hzVar.f566a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a20 = iv.a(this.f564a, hzVar.f564a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a19 = iv.a(this.f571b, hzVar.f571b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hzVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a18 = iv.a(this.f573c, hzVar.f573c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a17 = iv.a(this.f563a, hzVar.f563a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a16 = iv.a(this.f574d, hzVar.f574d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a15 = iv.a(this.f575e, hzVar.f575e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a14 = iv.a(this.f565a, hzVar.f565a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a13 = iv.a(this.f576f, hzVar.f576f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a12 = iv.a(this.f577g, hzVar.f577g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a11 = iv.a(this.f570a, hzVar.f570a)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hzVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a10 = iv.a(this.f578h, hzVar.f578h)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a9 = iv.a(this.f579i, hzVar.f579i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a8 = iv.a(this.f580j, hzVar.f580j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hzVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a7 = iv.a(this.f569a, hzVar.f569a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hzVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a6 = iv.a(this.f572b, hzVar.f572b)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hzVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a5 = iv.a(this.f581k, hzVar.f581k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hzVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a4 = iv.a(this.f582l, hzVar.f582l)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hzVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a3 = iv.a(this.f562a, hzVar.f562a)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hzVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a2 = iv.a(this.f568a, hzVar.f568a)) == 0) {
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
            return hz.class.getName().compareTo(hzVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hz a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f563a = j2;
            a(true);
            return this;
        }
        return (hz) invokeJ.objValue;
    }

    public hz a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f571b = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public hz a(short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Short.valueOf(s2)})) == null) {
            this.f569a = s2;
            c(true);
            return this;
        }
        return (hz) invokeCommon.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f571b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f573c != null) {
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
        jfVar.m549a();
        while (true) {
            jc m545a = jfVar.m545a();
            byte b2 = m545a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jg("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (m545a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f566a = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f564a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f571b = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f573c = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f563a = jfVar.m544a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f574d = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f575e = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        im imVar = new im();
                        this.f565a = imVar;
                        imVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f576f = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f577g = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f570a = jfVar.m554a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f578h = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f579i = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f580j = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f569a = jfVar.m552a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f572b = jfVar.m552a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f581k = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f582l = jfVar.m550a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f562a = jfVar.m543a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        je m547a = jfVar.m547a();
                        this.f568a = new HashMap(m547a.f812a * 2);
                        for (int i2 = 0; i2 < m547a.f812a; i2++) {
                            this.f568a.put(jfVar.m550a(), jfVar.m550a());
                        }
                        jfVar.h();
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
            this.f567a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m444a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f566a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m445a(hz hzVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hzVar)) == null) {
            if (hzVar == null) {
                return false;
            }
            boolean m444a = m444a();
            boolean m444a2 = hzVar.m444a();
            if ((m444a || m444a2) && !(m444a && m444a2 && this.f566a.equals(hzVar.f566a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = hzVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f564a.m443a(hzVar.f564a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hzVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f571b.equals(hzVar.f571b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hzVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f573c.equals(hzVar.f573c))) || this.f563a != hzVar.f563a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hzVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f574d.equals(hzVar.f574d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hzVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f575e.equals(hzVar.f575e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hzVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f565a.m506a(hzVar.f565a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hzVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f576f.equals(hzVar.f576f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hzVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f577g.equals(hzVar.f577g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hzVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f570a == hzVar.f570a)) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hzVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f578h.equals(hzVar.f578h))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hzVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f579i.equals(hzVar.f579i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hzVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f580j.equals(hzVar.f580j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hzVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f569a == hzVar.f569a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hzVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f572b == hzVar.f572b)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hzVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f581k.equals(hzVar.f581k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hzVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f582l.equals(hzVar.f582l))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = hzVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f562a == hzVar.f562a)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = hzVar.t();
            if (t2 || t3) {
                return t2 && t3 && this.f568a.equals(hzVar.f568a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hz b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f573c = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            a();
            jfVar.a(f561a);
            if (this.f566a != null && m444a()) {
                jfVar.a(a);
                jfVar.a(this.f566a);
                jfVar.b();
            }
            if (this.f564a != null && b()) {
                jfVar.a(b);
                this.f564a.b(jfVar);
                jfVar.b();
            }
            if (this.f571b != null) {
                jfVar.a(c);
                jfVar.a(this.f571b);
                jfVar.b();
            }
            if (this.f573c != null) {
                jfVar.a(d);
                jfVar.a(this.f573c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f563a);
            jfVar.b();
            if (this.f574d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f574d);
                jfVar.b();
            }
            if (this.f575e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f575e);
                jfVar.b();
            }
            if (this.f565a != null && h()) {
                jfVar.a(h);
                this.f565a.b(jfVar);
                jfVar.b();
            }
            if (this.f576f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f576f);
                jfVar.b();
            }
            if (this.f577g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f577g);
                jfVar.b();
            }
            if (k()) {
                jfVar.a(k);
                jfVar.a(this.f570a);
                jfVar.b();
            }
            if (this.f578h != null && l()) {
                jfVar.a(l);
                jfVar.a(this.f578h);
                jfVar.b();
            }
            if (this.f579i != null && m()) {
                jfVar.a(m);
                jfVar.a(this.f579i);
                jfVar.b();
            }
            if (this.f580j != null && n()) {
                jfVar.a(n);
                jfVar.a(this.f580j);
                jfVar.b();
            }
            if (o()) {
                jfVar.a(o);
                jfVar.a(this.f569a);
                jfVar.b();
            }
            if (p()) {
                jfVar.a(p);
                jfVar.a(this.f572b);
                jfVar.b();
            }
            if (this.f581k != null && q()) {
                jfVar.a(q);
                jfVar.a(this.f581k);
                jfVar.b();
            }
            if (this.f582l != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f582l);
                jfVar.b();
            }
            if (s()) {
                jfVar.a(s);
                jfVar.a(this.f562a);
                jfVar.b();
            }
            if (this.f568a != null && t()) {
                jfVar.a(t);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f568a.size()));
                for (Map.Entry<String, String> entry : this.f568a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m553a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f567a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f564a != null : invokeV.booleanValue;
    }

    public hz c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f574d = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f567a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f571b != null : invokeV.booleanValue;
    }

    public hz d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f575e = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f567a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f573c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f567a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f567a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hz)) {
                return m445a((hz) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f574d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f575e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f565a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f576f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f577g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f567a.get(1) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f578h != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f579i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f580j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f567a.get(2) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f567a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f581k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f582l != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f567a.get(4) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f568a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
            boolean z2 = false;
            if (m444a()) {
                sb.append("debug:");
                String str = this.f566a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f564a;
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
            String str2 = this.f571b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f573c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f563a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str4 = this.f574d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str5 = this.f575e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("request:");
                im imVar = this.f565a;
                if (imVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(imVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f576f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f577g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f570a);
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f578h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("callbackUrl:");
                String str9 = this.f579i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f580j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceStatus:");
                sb.append((int) this.f569a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("geoMsgStatus:");
                sb.append((int) this.f572b);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f581k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f582l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f562a);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f568a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
