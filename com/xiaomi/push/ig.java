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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes6.dex */
public class ig implements iq<ig, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40418a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f692a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40419b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40420c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40421d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40422e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40423f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40424g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40425h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f40426i;
    public static final iy j;
    public static final iy k;
    public static final iy l;
    public static final iy m;
    public static final iy n;
    public static final iy o;
    public static final iy p;
    public static final iy q;
    public static final iy r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f693a;

    /* renamed from: a  reason: collision with other field name */
    public long f694a;

    /* renamed from: a  reason: collision with other field name */
    public hu f695a;

    /* renamed from: a  reason: collision with other field name */
    public String f696a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f697a;

    /* renamed from: b  reason: collision with other field name */
    public int f698b;

    /* renamed from: b  reason: collision with other field name */
    public long f699b;

    /* renamed from: b  reason: collision with other field name */
    public String f700b;

    /* renamed from: c  reason: collision with other field name */
    public long f701c;

    /* renamed from: c  reason: collision with other field name */
    public String f702c;

    /* renamed from: d  reason: collision with other field name */
    public String f703d;

    /* renamed from: e  reason: collision with other field name */
    public String f704e;

    /* renamed from: f  reason: collision with other field name */
    public String f705f;

    /* renamed from: g  reason: collision with other field name */
    public String f706g;

    /* renamed from: h  reason: collision with other field name */
    public String f707h;

    /* renamed from: i  reason: collision with other field name */
    public String f708i;

    /* renamed from: j  reason: collision with other field name */
    public String f709j;

    /* renamed from: k  reason: collision with other field name */
    public String f710k;

    /* renamed from: l  reason: collision with other field name */
    public String f711l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371998, "Lcom/xiaomi/push/ig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371998, "Lcom/xiaomi/push/ig;");
                return;
            }
        }
        f692a = new jg("XmPushActionRegistrationResult");
        f40418a = new iy("", (byte) 11, (short) 1);
        f40419b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f40420c = new iy("", (byte) 11, (short) 3);
        f40421d = new iy("", (byte) 11, (short) 4);
        f40422e = new iy("", (byte) 10, (short) 6);
        f40423f = new iy("", (byte) 11, (short) 7);
        f40424g = new iy("", (byte) 11, (short) 8);
        f40425h = new iy("", (byte) 11, (short) 9);
        f40426i = new iy("", (byte) 11, (short) 10);
        j = new iy("", (byte) 10, (short) 11);
        k = new iy("", (byte) 11, (short) 12);
        l = new iy("", (byte) 11, (short) 13);
        m = new iy("", (byte) 10, (short) 14);
        n = new iy("", (byte) 11, (short) 15);
        o = new iy("", (byte) 8, (short) 16);
        p = new iy("", (byte) 11, (short) 17);
        q = new iy("", (byte) 8, (short) 18);
        r = new iy("", (byte) 11, (short) 19);
    }

    public ig() {
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
        this.f697a = new BitSet(5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, igVar)) == null) {
            if (ig.class.equals(igVar.getClass())) {
                int compareTo = Boolean.valueOf(m481a()).compareTo(Boolean.valueOf(igVar.m481a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m481a() || (a19 = ir.a(this.f696a, igVar.f696a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m483b()).compareTo(Boolean.valueOf(igVar.m483b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m483b() || (a18 = ir.a(this.f695a, igVar.f695a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a17 = ir.a(this.f700b, igVar.f700b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f702c, igVar.f702c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f694a, igVar.f694a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f703d, igVar.f703d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f704e, igVar.f704e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f705f, igVar.f705f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f706g, igVar.f706g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f699b, igVar.f699b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f707h, igVar.f707h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f708i, igVar.f708i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f701c, igVar.f701c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f709j, igVar.f709j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f693a, igVar.f693a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f710k, igVar.f710k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f698b, igVar.f698b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f711l, igVar.f711l)) == 0) {
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
            return ig.class.getName().compareTo(igVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f694a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m479a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f700b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m480a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f700b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f702c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jbVar) != null) {
            return;
        }
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40508a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m480a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f696a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f695a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f700b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f702c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f694a = jbVar.m519a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f703d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f704e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f705f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f706g = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f699b = jbVar.m519a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f707h = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f708i = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f701c = jbVar.m519a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f709j = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f693a = jbVar.m518a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f710k = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f698b = jbVar.m518a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f711l = jbVar.m525a();
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
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f697a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m481a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f696a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m482a(ig igVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, igVar)) == null) {
            if (igVar == null) {
                return false;
            }
            boolean m481a = m481a();
            boolean m481a2 = igVar.m481a();
            if ((m481a || m481a2) && !(m481a && m481a2 && this.f696a.equals(igVar.f696a))) {
                return false;
            }
            boolean m483b = m483b();
            boolean m483b2 = igVar.m483b();
            if ((m483b || m483b2) && !(m483b && m483b2 && this.f695a.m419a(igVar.f695a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = igVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f700b.equals(igVar.f700b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = igVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f702c.equals(igVar.f702c))) || this.f694a != igVar.f694a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = igVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f703d.equals(igVar.f703d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = igVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f704e.equals(igVar.f704e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = igVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f705f.equals(igVar.f705f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = igVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f706g.equals(igVar.f706g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = igVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f699b == igVar.f699b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = igVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f707h.equals(igVar.f707h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = igVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f708i.equals(igVar.f708i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = igVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f701c == igVar.f701c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = igVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f709j.equals(igVar.f709j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = igVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f693a == igVar.f693a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = igVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f710k.equals(igVar.f710k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = igVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f698b == igVar.f698b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = igVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f711l.equals(igVar.f711l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f706g : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m480a();
            jbVar.a(f692a);
            if (this.f696a != null && m481a()) {
                jbVar.a(f40418a);
                jbVar.a(this.f696a);
                jbVar.b();
            }
            if (this.f695a != null && m483b()) {
                jbVar.a(f40419b);
                this.f695a.b(jbVar);
                jbVar.b();
            }
            if (this.f700b != null) {
                jbVar.a(f40420c);
                jbVar.a(this.f700b);
                jbVar.b();
            }
            if (this.f702c != null) {
                jbVar.a(f40421d);
                jbVar.a(this.f702c);
                jbVar.b();
            }
            jbVar.a(f40422e);
            jbVar.a(this.f694a);
            jbVar.b();
            if (this.f703d != null && f()) {
                jbVar.a(f40423f);
                jbVar.a(this.f703d);
                jbVar.b();
            }
            if (this.f704e != null && g()) {
                jbVar.a(f40424g);
                jbVar.a(this.f704e);
                jbVar.b();
            }
            if (this.f705f != null && h()) {
                jbVar.a(f40425h);
                jbVar.a(this.f705f);
                jbVar.b();
            }
            if (this.f706g != null && i()) {
                jbVar.a(f40426i);
                jbVar.a(this.f706g);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f699b);
                jbVar.b();
            }
            if (this.f707h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f707h);
                jbVar.b();
            }
            if (this.f708i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f708i);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f701c);
                jbVar.b();
            }
            if (this.f709j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f709j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f693a);
                jbVar.b();
            }
            if (this.f710k != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f710k);
                jbVar.b();
            }
            if (q()) {
                jbVar.a(q);
                jbVar.a(this.f698b);
                jbVar.b();
            }
            if (this.f711l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f711l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f697a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m483b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f695a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f697a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f700b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f697a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f702c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f697a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f697a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof ig)) {
                return m482a((ig) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f703d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f704e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f705f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f706g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f697a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f707h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f708i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f697a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f709j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f697a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f710k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f697a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f711l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
            boolean z2 = false;
            if (m481a()) {
                sb.append("debug:");
                String str = this.f696a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m483b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f695a;
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
            String str2 = this.f700b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f702c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f694a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f703d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f704e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f705f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f706g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f699b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f707h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f708i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f701c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f709j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f693a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f710k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f698b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f711l;
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
