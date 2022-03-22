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
/* loaded from: classes7.dex */
public class hv implements iq<hv, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f545a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44393b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44394c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44395d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44396e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44397f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44398g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44399h;
    public static final iy i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public static final iy n;
    public static final iy o;
    public static final iy p;
    public static final iy q;
    public static final iy r;
    public static final iy s;
    public static final iy t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f546a;

    /* renamed from: a  reason: collision with other field name */
    public long f547a;

    /* renamed from: a  reason: collision with other field name */
    public hu f548a;

    /* renamed from: a  reason: collision with other field name */
    public ii f549a;

    /* renamed from: a  reason: collision with other field name */
    public String f550a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f551a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f552a;

    /* renamed from: a  reason: collision with other field name */
    public short f553a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f554a;

    /* renamed from: b  reason: collision with other field name */
    public String f555b;

    /* renamed from: b  reason: collision with other field name */
    public short f556b;

    /* renamed from: c  reason: collision with other field name */
    public String f557c;

    /* renamed from: d  reason: collision with other field name */
    public String f558d;

    /* renamed from: e  reason: collision with other field name */
    public String f559e;

    /* renamed from: f  reason: collision with other field name */
    public String f560f;

    /* renamed from: g  reason: collision with other field name */
    public String f561g;

    /* renamed from: h  reason: collision with other field name */
    public String f562h;

    /* renamed from: i  reason: collision with other field name */
    public String f563i;

    /* renamed from: j  reason: collision with other field name */
    public String f564j;

    /* renamed from: k  reason: collision with other field name */
    public String f565k;

    /* renamed from: l  reason: collision with other field name */
    public String f566l;

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
        f545a = new jg("XmPushActionAckMessage");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44393b = new iy("", (byte) 12, (short) 2);
        f44394c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44395d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44396e = new iy("", (byte) 10, (short) 5);
        f44397f = new iy("", Constants.GZIP_CAST_TYPE, (short) 6);
        f44398g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44399h = new iy("", (byte) 12, (short) 8);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new iy("", (byte) 2, (short) 11);
        l = new iy("", Constants.GZIP_CAST_TYPE, (short) 12);
        m = new iy("", Constants.GZIP_CAST_TYPE, (short) 13);
        n = new iy("", Constants.GZIP_CAST_TYPE, (short) 14);
        o = new iy("", (byte) 6, (short) 15);
        p = new iy("", (byte) 6, (short) 16);
        q = new iy("", Constants.GZIP_CAST_TYPE, (short) 20);
        r = new iy("", Constants.GZIP_CAST_TYPE, (short) 21);
        s = new iy("", (byte) 8, (short) 22);
        t = new iy("", (byte) 13, (short) 23);
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
        this.f551a = new BitSet(5);
        this.f554a = false;
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
        int a20;
        int a21;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hvVar)) == null) {
            if (hv.class.equals(hvVar.getClass())) {
                int compareTo = Boolean.valueOf(m462a()).compareTo(Boolean.valueOf(hvVar.m462a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m462a() || (a21 = ir.a(this.f550a, hvVar.f550a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a20 = ir.a(this.f548a, hvVar.f548a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a19 = ir.a(this.f555b, hvVar.f555b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a18 = ir.a(this.f557c, hvVar.f557c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a17 = ir.a(this.f547a, hvVar.f547a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a16 = ir.a(this.f558d, hvVar.f558d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hvVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a15 = ir.a(this.f559e, hvVar.f559e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hvVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a14 = ir.a(this.f549a, hvVar.f549a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hvVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a13 = ir.a(this.f560f, hvVar.f560f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hvVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a12 = ir.a(this.f561g, hvVar.f561g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hvVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a11 = ir.a(this.f554a, hvVar.f554a)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hvVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a10 = ir.a(this.f562h, hvVar.f562h)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hvVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a9 = ir.a(this.f563i, hvVar.f563i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hvVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a8 = ir.a(this.f564j, hvVar.f564j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hvVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a7 = ir.a(this.f553a, hvVar.f553a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hvVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a6 = ir.a(this.f556b, hvVar.f556b)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hvVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a5 = ir.a(this.f565k, hvVar.f565k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hvVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a4 = ir.a(this.f566l, hvVar.f566l)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hvVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a3 = ir.a(this.f546a, hvVar.f546a)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hvVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a2 = ir.a(this.f552a, hvVar.f552a)) == 0) {
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
            return hv.class.getName().compareTo(hvVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hv a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            this.f547a = j2;
            a(true);
            return this;
        }
        return (hv) invokeJ.objValue;
    }

    public hv a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f555b = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public hv a(short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Short.valueOf(s2)})) == null) {
            this.f553a = s2;
            c(true);
            return this;
        }
        return (hv) invokeCommon.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f555b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f557c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jbVar) != null) {
            return;
        }
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f550a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f548a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f555b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f557c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f547a = jbVar.m561a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f558d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f559e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ii iiVar = new ii();
                        this.f549a = iiVar;
                        iiVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f560f = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f561g = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f554a = jbVar.m571a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f562h = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f563i = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f564j = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f553a = jbVar.m569a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f556b = jbVar.m569a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f565k = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f566l = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f546a = jbVar.m560a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        ja m564a = jbVar.m564a();
                        this.f552a = new HashMap(m564a.f795a * 2);
                        for (int i2 = 0; i2 < m564a.f795a; i2++) {
                            this.f552a.put(jbVar.m567a(), jbVar.m567a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f551a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m462a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f550a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a(hv hvVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hvVar)) == null) {
            if (hvVar == null) {
                return false;
            }
            boolean m462a = m462a();
            boolean m462a2 = hvVar.m462a();
            if ((m462a || m462a2) && !(m462a && m462a2 && this.f550a.equals(hvVar.f550a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f548a.m461a(hvVar.f548a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f555b.equals(hvVar.f555b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f557c.equals(hvVar.f557c))) || this.f547a != hvVar.f547a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f558d.equals(hvVar.f558d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hvVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f559e.equals(hvVar.f559e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hvVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f549a.m531a(hvVar.f549a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hvVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f560f.equals(hvVar.f560f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hvVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f561g.equals(hvVar.f561g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hvVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f554a == hvVar.f554a)) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hvVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f562h.equals(hvVar.f562h))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hvVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f563i.equals(hvVar.f563i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hvVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f564j.equals(hvVar.f564j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hvVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f553a == hvVar.f553a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hvVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f556b == hvVar.f556b)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hvVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f565k.equals(hvVar.f565k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hvVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f566l.equals(hvVar.f566l))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = hvVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f546a == hvVar.f546a)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = hvVar.t();
            if (t2 || t3) {
                return t2 && t3 && this.f552a.equals(hvVar.f552a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hv b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f557c = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            a();
            jbVar.a(f545a);
            if (this.f550a != null && m462a()) {
                jbVar.a(a);
                jbVar.a(this.f550a);
                jbVar.b();
            }
            if (this.f548a != null && b()) {
                jbVar.a(f44393b);
                this.f548a.b(jbVar);
                jbVar.b();
            }
            if (this.f555b != null) {
                jbVar.a(f44394c);
                jbVar.a(this.f555b);
                jbVar.b();
            }
            if (this.f557c != null) {
                jbVar.a(f44395d);
                jbVar.a(this.f557c);
                jbVar.b();
            }
            jbVar.a(f44396e);
            jbVar.a(this.f547a);
            jbVar.b();
            if (this.f558d != null && f()) {
                jbVar.a(f44397f);
                jbVar.a(this.f558d);
                jbVar.b();
            }
            if (this.f559e != null && g()) {
                jbVar.a(f44398g);
                jbVar.a(this.f559e);
                jbVar.b();
            }
            if (this.f549a != null && h()) {
                jbVar.a(f44399h);
                this.f549a.b(jbVar);
                jbVar.b();
            }
            if (this.f560f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f560f);
                jbVar.b();
            }
            if (this.f561g != null && j()) {
                jbVar.a(j);
                jbVar.a(this.f561g);
                jbVar.b();
            }
            if (k()) {
                jbVar.a(k);
                jbVar.a(this.f554a);
                jbVar.b();
            }
            if (this.f562h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f562h);
                jbVar.b();
            }
            if (this.f563i != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f563i);
                jbVar.b();
            }
            if (this.f564j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f564j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f553a);
                jbVar.b();
            }
            if (p()) {
                jbVar.a(p);
                jbVar.a(this.f556b);
                jbVar.b();
            }
            if (this.f565k != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f565k);
                jbVar.b();
            }
            if (this.f566l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f566l);
                jbVar.b();
            }
            if (s()) {
                jbVar.a(s);
                jbVar.a(this.f546a);
                jbVar.b();
            }
            if (this.f552a != null && t()) {
                jbVar.a(t);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f552a.size()));
                for (Map.Entry<String, String> entry : this.f552a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f551a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f548a != null : invokeV.booleanValue;
    }

    public hv c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f558d = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f551a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f555b != null : invokeV.booleanValue;
    }

    public hv d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f559e = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f551a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f557c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f551a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f551a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hv)) {
                return m463a((hv) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f558d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f559e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f549a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f560f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f561g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f551a.get(1) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f562h != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f563i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f564j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f551a.get(2) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f551a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f565k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f566l != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f551a.get(4) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f552a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
            boolean z2 = false;
            if (m462a()) {
                sb.append("debug:");
                String str = this.f550a;
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
                hu huVar = this.f548a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f555b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f557c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f547a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str4 = this.f558d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str5 = this.f559e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("request:");
                ii iiVar = this.f549a;
                if (iiVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(iiVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f560f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f561g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f554a);
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f562h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("callbackUrl:");
                String str9 = this.f563i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f564j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceStatus:");
                sb.append((int) this.f553a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("geoMsgStatus:");
                sb.append((int) this.f556b);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f565k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f566l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f546a);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f552a;
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
