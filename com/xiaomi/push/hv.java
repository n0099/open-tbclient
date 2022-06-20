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
/* loaded from: classes8.dex */
public class hv implements iu<hv, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f508a;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f509a;

    /* renamed from: a  reason: collision with other field name */
    public hw f510a;

    /* renamed from: a  reason: collision with other field name */
    public hy f511a;

    /* renamed from: a  reason: collision with other field name */
    public String f512a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f513a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f514a;

    /* renamed from: b  reason: collision with other field name */
    public long f515b;

    /* renamed from: b  reason: collision with other field name */
    public String f516b;

    /* renamed from: c  reason: collision with other field name */
    public long f517c;

    /* renamed from: c  reason: collision with other field name */
    public String f518c;

    /* renamed from: d  reason: collision with other field name */
    public String f519d;

    /* renamed from: e  reason: collision with other field name */
    public String f520e;

    /* renamed from: f  reason: collision with other field name */
    public String f521f;

    /* renamed from: g  reason: collision with other field name */
    public String f522g;

    /* renamed from: h  reason: collision with other field name */
    public String f523h;

    /* renamed from: i  reason: collision with other field name */
    public String f524i;

    /* renamed from: j  reason: collision with other field name */
    public String f525j;

    /* renamed from: k  reason: collision with other field name */
    public String f526k;

    /* renamed from: l  reason: collision with other field name */
    public String f527l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372494, "Lcom/xiaomi/push/hv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372494, "Lcom/xiaomi/push/hv;");
                return;
            }
        }
        f508a = new jk("PushMessage");
        a = new jc("", (byte) 12, (short) 1);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 5);
        f = new jc("", (byte) 10, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new jc("", (byte) 12, (short) 12);
        m = new jc("", Constants.GZIP_CAST_TYPE, (short) 13);
        n = new jc("", (byte) 2, (short) 14);
        o = new jc("", Constants.GZIP_CAST_TYPE, (short) 15);
        p = new jc("", (byte) 10, (short) 16);
        q = new jc("", Constants.GZIP_CAST_TYPE, (short) 20);
        r = new jc("", Constants.GZIP_CAST_TYPE, (short) 21);
    }

    public hv() {
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
        this.f513a = new BitSet(4);
        this.f514a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hv hvVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hvVar)) == null) {
            if (hv.class.equals(hvVar.getClass())) {
                int compareTo = Boolean.valueOf(m420a()).compareTo(Boolean.valueOf(hvVar.m420a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m420a() || (a19 = iv.a(this.f511a, hvVar.f511a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m422b()).compareTo(Boolean.valueOf(hvVar.m422b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m422b() || (a18 = iv.a(this.f512a, hvVar.f512a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m423c()).compareTo(Boolean.valueOf(hvVar.m423c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m423c() || (a17 = iv.a(this.f516b, hvVar.f516b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = iv.a(this.f518c, hvVar.f518c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = iv.a(this.f509a, hvVar.f509a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = iv.a(this.f515b, hvVar.f515b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hvVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = iv.a(this.f519d, hvVar.f519d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hvVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = iv.a(this.f520e, hvVar.f520e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hvVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = iv.a(this.f521f, hvVar.f521f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hvVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = iv.a(this.f522g, hvVar.f522g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hvVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = iv.a(this.f523h, hvVar.f523h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hvVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = iv.a(this.f510a, hvVar.f510a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hvVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = iv.a(this.f524i, hvVar.f524i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hvVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = iv.a(this.f514a, hvVar.f514a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hvVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = iv.a(this.f525j, hvVar.f525j)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hvVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = iv.a(this.f517c, hvVar.f517c)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hvVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = iv.a(this.f526k, hvVar.f526k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hvVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = iv.a(this.f527l, hvVar.f527l)) == 0) {
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
            return hv.class.getName().compareTo(hvVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f509a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m418a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f512a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m419a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f512a == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f516b == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f518c != null) {
            } else {
                throw new jg("Required field 'payload' was not present! Struct: " + toString());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                m419a();
                return;
            }
            short s = m540a.f802a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f526k = jfVar.m545a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hy hyVar = new hy();
                            this.f511a = hyVar;
                            hyVar.a(jfVar);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f512a = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f516b = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f518c = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f509a = jfVar.m539a();
                            a(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f515b = jfVar.m539a();
                            b(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f519d = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f520e = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f521f = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f522g = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f523h = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hw hwVar = new hw();
                            this.f510a = hwVar;
                            hwVar.a(jfVar);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f524i = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f514a = jfVar.m549a();
                            c(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f525j = jfVar.m545a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f517c = jfVar.m539a();
                            d(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    default:
                        ji.a(jfVar, b2);
                        break;
                }
                jfVar.g();
            } else {
                if (b2 == 11) {
                    this.f527l = jfVar.m545a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f513a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m420a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f511a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a(hv hvVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hvVar)) == null) {
            if (hvVar == null) {
                return false;
            }
            boolean m420a = m420a();
            boolean m420a2 = hvVar.m420a();
            if ((m420a || m420a2) && !(m420a && m420a2 && this.f511a.m438a(hvVar.f511a))) {
                return false;
            }
            boolean m422b = m422b();
            boolean m422b2 = hvVar.m422b();
            if ((m422b || m422b2) && !(m422b && m422b2 && this.f512a.equals(hvVar.f512a))) {
                return false;
            }
            boolean m423c = m423c();
            boolean m423c2 = hvVar.m423c();
            if ((m423c || m423c2) && !(m423c && m423c2 && this.f516b.equals(hvVar.f516b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f518c.equals(hvVar.f518c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hvVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f509a == hvVar.f509a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f515b == hvVar.f515b)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hvVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f519d.equals(hvVar.f519d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hvVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f520e.equals(hvVar.f520e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hvVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f521f.equals(hvVar.f521f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hvVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f522g.equals(hvVar.f522g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hvVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f523h.equals(hvVar.f523h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hvVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f510a.m430a(hvVar.f510a))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hvVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f524i.equals(hvVar.f524i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hvVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f514a == hvVar.f514a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hvVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f525j.equals(hvVar.f525j))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hvVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f517c == hvVar.f517c)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hvVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f526k.equals(hvVar.f526k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hvVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f527l.equals(hvVar.f527l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f516b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jfVar) == null) {
            m419a();
            jfVar.a(f508a);
            if (this.f511a != null && m420a()) {
                jfVar.a(a);
                this.f511a.b(jfVar);
                jfVar.b();
            }
            if (this.f512a != null) {
                jfVar.a(b);
                jfVar.a(this.f512a);
                jfVar.b();
            }
            if (this.f516b != null) {
                jfVar.a(c);
                jfVar.a(this.f516b);
                jfVar.b();
            }
            if (this.f518c != null) {
                jfVar.a(d);
                jfVar.a(this.f518c);
                jfVar.b();
            }
            if (e()) {
                jfVar.a(e);
                jfVar.a(this.f509a);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f515b);
                jfVar.b();
            }
            if (this.f519d != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f519d);
                jfVar.b();
            }
            if (this.f520e != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f520e);
                jfVar.b();
            }
            if (this.f521f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f521f);
                jfVar.b();
            }
            if (this.f522g != null && j()) {
                jfVar.a(j);
                jfVar.a(this.f522g);
                jfVar.b();
            }
            if (this.f523h != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f523h);
                jfVar.b();
            }
            if (this.f510a != null && l()) {
                jfVar.a(l);
                this.f510a.b(jfVar);
                jfVar.b();
            }
            if (this.f524i != null && m()) {
                jfVar.a(m);
                jfVar.a(this.f524i);
                jfVar.b();
            }
            if (n()) {
                jfVar.a(n);
                jfVar.a(this.f514a);
                jfVar.b();
            }
            if (this.f525j != null && o()) {
                jfVar.a(o);
                jfVar.a(this.f525j);
                jfVar.b();
            }
            if (p()) {
                jfVar.a(p);
                jfVar.a(this.f517c);
                jfVar.b();
            }
            if (this.f526k != null && q()) {
                jfVar.a(q);
                jfVar.a(this.f526k);
                jfVar.b();
            }
            if (this.f527l != null && r()) {
                jfVar.a(r);
                jfVar.a(this.f527l);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f513a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m422b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f512a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f518c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f513a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m423c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f516b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f513a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f518c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f513a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof hv)) {
                return m421a((hv) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f513a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f519d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f520e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f521f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f522g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f523h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f510a != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f524i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f513a.get(2) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f525j != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f513a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f526k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f527l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMessage(");
            if (m420a()) {
                sb.append("to:");
                hy hyVar = this.f511a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str = this.f512a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f516b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str3 = this.f518c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createAt:");
                sb.append(this.f509a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ttl:");
                sb.append(this.f515b);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("collapseKey:");
                String str4 = this.f519d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f520e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str6 = this.f521f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f522g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str8 = this.f523h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hw hwVar = this.f510a;
                if (hwVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hwVar);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f524i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f514a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f525j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f517c);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f526k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f527l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
