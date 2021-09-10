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
/* loaded from: classes10.dex */
public class ig implements iq<ig, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77943a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f696a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77944b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77945c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77946d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77947e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77948f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77949g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77950h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77951i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77952j;
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
    public int f697a;

    /* renamed from: a  reason: collision with other field name */
    public long f698a;

    /* renamed from: a  reason: collision with other field name */
    public hu f699a;

    /* renamed from: a  reason: collision with other field name */
    public String f700a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f701a;

    /* renamed from: b  reason: collision with other field name */
    public int f702b;

    /* renamed from: b  reason: collision with other field name */
    public long f703b;

    /* renamed from: b  reason: collision with other field name */
    public String f704b;

    /* renamed from: c  reason: collision with other field name */
    public long f705c;

    /* renamed from: c  reason: collision with other field name */
    public String f706c;

    /* renamed from: d  reason: collision with other field name */
    public String f707d;

    /* renamed from: e  reason: collision with other field name */
    public String f708e;

    /* renamed from: f  reason: collision with other field name */
    public String f709f;

    /* renamed from: g  reason: collision with other field name */
    public String f710g;

    /* renamed from: h  reason: collision with other field name */
    public String f711h;

    /* renamed from: i  reason: collision with other field name */
    public String f712i;

    /* renamed from: j  reason: collision with other field name */
    public String f713j;

    /* renamed from: k  reason: collision with other field name */
    public String f714k;

    /* renamed from: l  reason: collision with other field name */
    public String f715l;

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
        f696a = new jg("XmPushActionRegistrationResult");
        f77943a = new iy("", (byte) 11, (short) 1);
        f77944b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f77945c = new iy("", (byte) 11, (short) 3);
        f77946d = new iy("", (byte) 11, (short) 4);
        f77947e = new iy("", (byte) 10, (short) 6);
        f77948f = new iy("", (byte) 11, (short) 7);
        f77949g = new iy("", (byte) 11, (short) 8);
        f77950h = new iy("", (byte) 11, (short) 9);
        f77951i = new iy("", (byte) 11, (short) 10);
        f77952j = new iy("", (byte) 10, (short) 11);
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
        this.f701a = new BitSet(5);
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
                int compareTo = Boolean.valueOf(m484a()).compareTo(Boolean.valueOf(igVar.m484a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m484a() || (a19 = ir.a(this.f700a, igVar.f700a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m486b()).compareTo(Boolean.valueOf(igVar.m486b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m486b() || (a18 = ir.a(this.f699a, igVar.f699a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a17 = ir.a(this.f704b, igVar.f704b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f706c, igVar.f706c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f698a, igVar.f698a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f707d, igVar.f707d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f708e, igVar.f708e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f709f, igVar.f709f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f710g, igVar.f710g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f703b, igVar.f703b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f711h, igVar.f711h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f712i, igVar.f712i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f705c, igVar.f705c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f713j, igVar.f713j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f697a, igVar.f697a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f714k, igVar.f714k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f702b, igVar.f702b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f715l, igVar.f715l)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f698a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m482a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f704b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f704b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f706c != null) {
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
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f78036a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m483a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f700a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f699a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f704b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f706c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f698a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f707d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f708e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f709f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f710g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f703b = jbVar.m522a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f711h = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f712i = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f705c = jbVar.m522a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f713j = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f697a = jbVar.m521a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f714k = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f702b = jbVar.m521a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f715l = jbVar.m528a();
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
            this.f701a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f700a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a(ig igVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, igVar)) == null) {
            if (igVar == null) {
                return false;
            }
            boolean m484a = m484a();
            boolean m484a2 = igVar.m484a();
            if ((m484a || m484a2) && !(m484a && m484a2 && this.f700a.equals(igVar.f700a))) {
                return false;
            }
            boolean m486b = m486b();
            boolean m486b2 = igVar.m486b();
            if ((m486b || m486b2) && !(m486b && m486b2 && this.f699a.m422a(igVar.f699a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = igVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f704b.equals(igVar.f704b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = igVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f706c.equals(igVar.f706c))) || this.f698a != igVar.f698a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = igVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f707d.equals(igVar.f707d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = igVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f708e.equals(igVar.f708e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = igVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f709f.equals(igVar.f709f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = igVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f710g.equals(igVar.f710g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = igVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f703b == igVar.f703b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = igVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f711h.equals(igVar.f711h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = igVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f712i.equals(igVar.f712i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = igVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f705c == igVar.f705c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = igVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f713j.equals(igVar.f713j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = igVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f697a == igVar.f697a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = igVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f714k.equals(igVar.f714k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = igVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f702b == igVar.f702b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = igVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f715l.equals(igVar.f715l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f710g : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m483a();
            jbVar.a(f696a);
            if (this.f700a != null && m484a()) {
                jbVar.a(f77943a);
                jbVar.a(this.f700a);
                jbVar.b();
            }
            if (this.f699a != null && m486b()) {
                jbVar.a(f77944b);
                this.f699a.b(jbVar);
                jbVar.b();
            }
            if (this.f704b != null) {
                jbVar.a(f77945c);
                jbVar.a(this.f704b);
                jbVar.b();
            }
            if (this.f706c != null) {
                jbVar.a(f77946d);
                jbVar.a(this.f706c);
                jbVar.b();
            }
            jbVar.a(f77947e);
            jbVar.a(this.f698a);
            jbVar.b();
            if (this.f707d != null && f()) {
                jbVar.a(f77948f);
                jbVar.a(this.f707d);
                jbVar.b();
            }
            if (this.f708e != null && g()) {
                jbVar.a(f77949g);
                jbVar.a(this.f708e);
                jbVar.b();
            }
            if (this.f709f != null && h()) {
                jbVar.a(f77950h);
                jbVar.a(this.f709f);
                jbVar.b();
            }
            if (this.f710g != null && i()) {
                jbVar.a(f77951i);
                jbVar.a(this.f710g);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(f77952j);
                jbVar.a(this.f703b);
                jbVar.b();
            }
            if (this.f711h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f711h);
                jbVar.b();
            }
            if (this.f712i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f712i);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f705c);
                jbVar.b();
            }
            if (this.f713j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f713j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f697a);
                jbVar.b();
            }
            if (this.f714k != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f714k);
                jbVar.b();
            }
            if (q()) {
                jbVar.a(q);
                jbVar.a(this.f702b);
                jbVar.b();
            }
            if (this.f715l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f715l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f701a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m486b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f699a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f701a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f704b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f701a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f706c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f701a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f701a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof ig)) {
                return m485a((ig) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f707d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f708e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f709f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f710g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f701a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f711h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f712i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f701a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f713j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f701a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f714k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f701a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f715l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
            boolean z2 = false;
            if (m484a()) {
                sb.append("debug:");
                String str = this.f700a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m486b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f699a;
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
            String str2 = this.f704b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f706c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f698a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f707d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f708e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f709f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f710g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f703b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f711h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f712i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f705c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f713j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f697a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f714k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f702b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f715l;
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
