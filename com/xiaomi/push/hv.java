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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class hv implements iq<hv, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f78217a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f568a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f78218b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f78219c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f78220d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f78221e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f78222f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f78223g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f78224h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f78225i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f78226j;
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
    public int f569a;

    /* renamed from: a  reason: collision with other field name */
    public long f570a;

    /* renamed from: a  reason: collision with other field name */
    public hu f571a;

    /* renamed from: a  reason: collision with other field name */
    public ii f572a;

    /* renamed from: a  reason: collision with other field name */
    public String f573a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f574a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f575a;

    /* renamed from: a  reason: collision with other field name */
    public short f576a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f577a;

    /* renamed from: b  reason: collision with other field name */
    public String f578b;

    /* renamed from: b  reason: collision with other field name */
    public short f579b;

    /* renamed from: c  reason: collision with other field name */
    public String f580c;

    /* renamed from: d  reason: collision with other field name */
    public String f581d;

    /* renamed from: e  reason: collision with other field name */
    public String f582e;

    /* renamed from: f  reason: collision with other field name */
    public String f583f;

    /* renamed from: g  reason: collision with other field name */
    public String f584g;

    /* renamed from: h  reason: collision with other field name */
    public String f585h;

    /* renamed from: i  reason: collision with other field name */
    public String f586i;

    /* renamed from: j  reason: collision with other field name */
    public String f587j;

    /* renamed from: k  reason: collision with other field name */
    public String f588k;

    /* renamed from: l  reason: collision with other field name */
    public String f589l;

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
        f568a = new jg("XmPushActionAckMessage");
        f78217a = new iy("", (byte) 11, (short) 1);
        f78218b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f78219c = new iy("", (byte) 11, (short) 3);
        f78220d = new iy("", (byte) 11, (short) 4);
        f78221e = new iy("", (byte) 10, (short) 5);
        f78222f = new iy("", (byte) 11, (short) 6);
        f78223g = new iy("", (byte) 11, (short) 7);
        f78224h = new iy("", StandardMessageCodec.LIST, (short) 8);
        f78225i = new iy("", (byte) 11, (short) 9);
        f78226j = new iy("", (byte) 11, (short) 10);
        k = new iy("", (byte) 2, (short) 11);
        l = new iy("", (byte) 11, (short) 12);
        m = new iy("", (byte) 11, (short) 13);
        n = new iy("", (byte) 11, (short) 14);
        o = new iy("", (byte) 6, (short) 15);
        p = new iy("", (byte) 6, (short) 16);
        q = new iy("", (byte) 11, (short) 20);
        r = new iy("", (byte) 11, (short) 21);
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
        this.f574a = new BitSet(5);
        this.f577a = false;
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
                int compareTo = Boolean.valueOf(m423a()).compareTo(Boolean.valueOf(hvVar.m423a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m423a() || (a21 = ir.a(this.f573a, hvVar.f573a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hvVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a20 = ir.a(this.f571a, hvVar.f571a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hvVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a19 = ir.a(this.f578b, hvVar.f578b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hvVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a18 = ir.a(this.f580c, hvVar.f580c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hvVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a17 = ir.a(this.f570a, hvVar.f570a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hvVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a16 = ir.a(this.f581d, hvVar.f581d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hvVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a15 = ir.a(this.f582e, hvVar.f582e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hvVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a14 = ir.a(this.f572a, hvVar.f572a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hvVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a13 = ir.a(this.f583f, hvVar.f583f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hvVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a12 = ir.a(this.f584g, hvVar.f584g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hvVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a11 = ir.a(this.f577a, hvVar.f577a)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hvVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a10 = ir.a(this.f585h, hvVar.f585h)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hvVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a9 = ir.a(this.f586i, hvVar.f586i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hvVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a8 = ir.a(this.f587j, hvVar.f587j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hvVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a7 = ir.a(this.f576a, hvVar.f576a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hvVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a6 = ir.a(this.f579b, hvVar.f579b)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hvVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a5 = ir.a(this.f588k, hvVar.f588k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hvVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a4 = ir.a(this.f589l, hvVar.f589l)) == 0) {
                                                                                        int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hvVar.s()));
                                                                                        if (compareTo19 != 0) {
                                                                                            return compareTo19;
                                                                                        }
                                                                                        if (!s() || (a3 = ir.a(this.f569a, hvVar.f569a)) == 0) {
                                                                                            int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hvVar.t()));
                                                                                            if (compareTo20 != 0) {
                                                                                                return compareTo20;
                                                                                            }
                                                                                            if (!t() || (a2 = ir.a(this.f575a, hvVar.f575a)) == 0) {
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
            this.f570a = j2;
            a(true);
            return this;
        }
        return (hv) invokeJ.objValue;
    }

    public hv a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f578b = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public hv a(short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Short.valueOf(s2)})) == null) {
            this.f576a = s2;
            c(true);
            return this;
        }
        return (hv) invokeCommon.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f578b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f580c != null) {
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
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78390a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    a();
                    return;
                }
                throw new jc("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f573a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f571a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f578b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f580c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f570a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f581d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f582e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        ii iiVar = new ii();
                        this.f572a = iiVar;
                        iiVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f583f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f584g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f577a = jbVar.m532a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f585h = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f586i = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f587j = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f576a = jbVar.m530a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f579b = jbVar.m530a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f588k = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f589l = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f569a = jbVar.m521a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        ja m525a = jbVar.m525a();
                        this.f575a = new HashMap(m525a.f818a * 2);
                        for (int i2 = 0; i2 < m525a.f818a; i2++) {
                            this.f575a.put(jbVar.m528a(), jbVar.m528a());
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
            this.f574a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m423a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f573a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m424a(hv hvVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hvVar)) == null) {
            if (hvVar == null) {
                return false;
            }
            boolean m423a = m423a();
            boolean m423a2 = hvVar.m423a();
            if ((m423a || m423a2) && !(m423a && m423a2 && this.f573a.equals(hvVar.f573a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = hvVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f571a.m422a(hvVar.f571a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hvVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f578b.equals(hvVar.f578b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hvVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f580c.equals(hvVar.f580c))) || this.f570a != hvVar.f570a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hvVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f581d.equals(hvVar.f581d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hvVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f582e.equals(hvVar.f582e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hvVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f572a.m492a(hvVar.f572a))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hvVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f583f.equals(hvVar.f583f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hvVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f584g.equals(hvVar.f584g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hvVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f577a == hvVar.f577a)) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hvVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f585h.equals(hvVar.f585h))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hvVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f586i.equals(hvVar.f586i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hvVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f587j.equals(hvVar.f587j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hvVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f576a == hvVar.f576a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hvVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f579b == hvVar.f579b)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hvVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f588k.equals(hvVar.f588k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hvVar.r();
            if ((r2 || r3) && !(r2 && r3 && this.f589l.equals(hvVar.f589l))) {
                return false;
            }
            boolean s2 = s();
            boolean s3 = hvVar.s();
            if ((s2 || s3) && !(s2 && s3 && this.f569a == hvVar.f569a)) {
                return false;
            }
            boolean t2 = t();
            boolean t3 = hvVar.t();
            if (t2 || t3) {
                return t2 && t3 && this.f575a.equals(hvVar.f575a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hv b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f580c = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jbVar) == null) {
            a();
            jbVar.a(f568a);
            if (this.f573a != null && m423a()) {
                jbVar.a(f78217a);
                jbVar.a(this.f573a);
                jbVar.b();
            }
            if (this.f571a != null && b()) {
                jbVar.a(f78218b);
                this.f571a.b(jbVar);
                jbVar.b();
            }
            if (this.f578b != null) {
                jbVar.a(f78219c);
                jbVar.a(this.f578b);
                jbVar.b();
            }
            if (this.f580c != null) {
                jbVar.a(f78220d);
                jbVar.a(this.f580c);
                jbVar.b();
            }
            jbVar.a(f78221e);
            jbVar.a(this.f570a);
            jbVar.b();
            if (this.f581d != null && f()) {
                jbVar.a(f78222f);
                jbVar.a(this.f581d);
                jbVar.b();
            }
            if (this.f582e != null && g()) {
                jbVar.a(f78223g);
                jbVar.a(this.f582e);
                jbVar.b();
            }
            if (this.f572a != null && h()) {
                jbVar.a(f78224h);
                this.f572a.b(jbVar);
                jbVar.b();
            }
            if (this.f583f != null && i()) {
                jbVar.a(f78225i);
                jbVar.a(this.f583f);
                jbVar.b();
            }
            if (this.f584g != null && j()) {
                jbVar.a(f78226j);
                jbVar.a(this.f584g);
                jbVar.b();
            }
            if (k()) {
                jbVar.a(k);
                jbVar.a(this.f577a);
                jbVar.b();
            }
            if (this.f585h != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f585h);
                jbVar.b();
            }
            if (this.f586i != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f586i);
                jbVar.b();
            }
            if (this.f587j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f587j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f576a);
                jbVar.b();
            }
            if (p()) {
                jbVar.a(p);
                jbVar.a(this.f579b);
                jbVar.b();
            }
            if (this.f588k != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f588k);
                jbVar.b();
            }
            if (this.f589l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f589l);
                jbVar.b();
            }
            if (s()) {
                jbVar.a(s);
                jbVar.a(this.f569a);
                jbVar.b();
            }
            if (this.f575a != null && t()) {
                jbVar.a(t);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f575a.size()));
                for (Map.Entry<String, String> entry : this.f575a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f574a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f571a != null : invokeV.booleanValue;
    }

    public hv c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f581d = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f574a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f578b != null : invokeV.booleanValue;
    }

    public hv d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f582e = str;
            return this;
        }
        return (hv) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f574a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f580c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f574a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f574a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hv)) {
                return m424a((hv) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f581d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f582e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f572a != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f583f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f584g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f574a.get(1) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f585h != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f586i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f587j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f574a.get(2) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f574a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f588k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f589l != null : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f574a.get(4) : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f575a != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
            boolean z2 = false;
            if (m423a()) {
                sb.append("debug:");
                String str = this.f573a;
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
                hu huVar = this.f571a;
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
            String str2 = this.f578b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f580c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("messageTs:");
            sb.append(this.f570a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str4 = this.f581d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str5 = this.f582e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("request:");
                ii iiVar = this.f572a;
                if (iiVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(iiVar);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f583f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f584g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f577a);
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str8 = this.f585h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("callbackUrl:");
                String str9 = this.f586i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f587j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceStatus:");
                sb.append((int) this.f576a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("geoMsgStatus:");
                sb.append((int) this.f579b);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f588k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f589l;
                if (str12 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str12);
                }
            }
            if (s()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("passThrough:");
                sb.append(this.f569a);
            }
            if (t()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("extra:");
                Map<String, String> map = this.f575a;
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
