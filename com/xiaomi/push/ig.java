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
/* loaded from: classes2.dex */
public class ig implements iq<ig, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f71238a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f697a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f71239b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f71240c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f71241d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f71242e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f71243f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f71244g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f71245h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f71246i;
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
    public int f698a;

    /* renamed from: a  reason: collision with other field name */
    public long f699a;

    /* renamed from: a  reason: collision with other field name */
    public hu f700a;

    /* renamed from: a  reason: collision with other field name */
    public String f701a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f702a;

    /* renamed from: b  reason: collision with other field name */
    public int f703b;

    /* renamed from: b  reason: collision with other field name */
    public long f704b;

    /* renamed from: b  reason: collision with other field name */
    public String f705b;

    /* renamed from: c  reason: collision with other field name */
    public long f706c;

    /* renamed from: c  reason: collision with other field name */
    public String f707c;

    /* renamed from: d  reason: collision with other field name */
    public String f708d;

    /* renamed from: e  reason: collision with other field name */
    public String f709e;

    /* renamed from: f  reason: collision with other field name */
    public String f710f;

    /* renamed from: g  reason: collision with other field name */
    public String f711g;

    /* renamed from: h  reason: collision with other field name */
    public String f712h;

    /* renamed from: i  reason: collision with other field name */
    public String f713i;

    /* renamed from: j  reason: collision with other field name */
    public String f714j;

    /* renamed from: k  reason: collision with other field name */
    public String f715k;

    /* renamed from: l  reason: collision with other field name */
    public String f716l;

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
        f697a = new jg("XmPushActionRegistrationResult");
        f71238a = new iy("", (byte) 11, (short) 1);
        f71239b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f71240c = new iy("", (byte) 11, (short) 3);
        f71241d = new iy("", (byte) 11, (short) 4);
        f71242e = new iy("", (byte) 10, (short) 6);
        f71243f = new iy("", (byte) 11, (short) 7);
        f71244g = new iy("", (byte) 11, (short) 8);
        f71245h = new iy("", (byte) 11, (short) 9);
        f71246i = new iy("", (byte) 11, (short) 10);
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
        this.f702a = new BitSet(5);
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
                if (!m484a() || (a19 = ir.a(this.f701a, igVar.f701a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m486b()).compareTo(Boolean.valueOf(igVar.m486b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m486b() || (a18 = ir.a(this.f700a, igVar.f700a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a17 = ir.a(this.f705b, igVar.f705b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f707c, igVar.f707c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f699a, igVar.f699a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f708d, igVar.f708d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f709e, igVar.f709e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f710f, igVar.f710f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f711g, igVar.f711g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f704b, igVar.f704b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f712h, igVar.f712h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f713i, igVar.f713i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f706c, igVar.f706c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f714j, igVar.f714j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f698a, igVar.f698a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f715k, igVar.f715k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f703b, igVar.f703b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f716l, igVar.f716l)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f699a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m482a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f705b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m483a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f705b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f707c != null) {
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
            byte b2 = m523a.f71328a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m483a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m523a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f701a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f700a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f705b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f707c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f699a = jbVar.m522a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f708d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f709e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f710f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f711g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f704b = jbVar.m522a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f712h = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f713i = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f706c = jbVar.m522a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f714j = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f698a = jbVar.m521a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f715k = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f703b = jbVar.m521a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f716l = jbVar.m528a();
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
            this.f702a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m484a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f701a != null : invokeV.booleanValue;
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
            if ((m484a || m484a2) && !(m484a && m484a2 && this.f701a.equals(igVar.f701a))) {
                return false;
            }
            boolean m486b = m486b();
            boolean m486b2 = igVar.m486b();
            if ((m486b || m486b2) && !(m486b && m486b2 && this.f700a.m422a(igVar.f700a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = igVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f705b.equals(igVar.f705b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = igVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f707c.equals(igVar.f707c))) || this.f699a != igVar.f699a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = igVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f708d.equals(igVar.f708d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = igVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f709e.equals(igVar.f709e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = igVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f710f.equals(igVar.f710f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = igVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f711g.equals(igVar.f711g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = igVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f704b == igVar.f704b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = igVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f712h.equals(igVar.f712h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = igVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f713i.equals(igVar.f713i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = igVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f706c == igVar.f706c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = igVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f714j.equals(igVar.f714j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = igVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f698a == igVar.f698a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = igVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f715k.equals(igVar.f715k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = igVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f703b == igVar.f703b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = igVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f716l.equals(igVar.f716l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f711g : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m483a();
            jbVar.a(f697a);
            if (this.f701a != null && m484a()) {
                jbVar.a(f71238a);
                jbVar.a(this.f701a);
                jbVar.b();
            }
            if (this.f700a != null && m486b()) {
                jbVar.a(f71239b);
                this.f700a.b(jbVar);
                jbVar.b();
            }
            if (this.f705b != null) {
                jbVar.a(f71240c);
                jbVar.a(this.f705b);
                jbVar.b();
            }
            if (this.f707c != null) {
                jbVar.a(f71241d);
                jbVar.a(this.f707c);
                jbVar.b();
            }
            jbVar.a(f71242e);
            jbVar.a(this.f699a);
            jbVar.b();
            if (this.f708d != null && f()) {
                jbVar.a(f71243f);
                jbVar.a(this.f708d);
                jbVar.b();
            }
            if (this.f709e != null && g()) {
                jbVar.a(f71244g);
                jbVar.a(this.f709e);
                jbVar.b();
            }
            if (this.f710f != null && h()) {
                jbVar.a(f71245h);
                jbVar.a(this.f710f);
                jbVar.b();
            }
            if (this.f711g != null && i()) {
                jbVar.a(f71246i);
                jbVar.a(this.f711g);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f704b);
                jbVar.b();
            }
            if (this.f712h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f712h);
                jbVar.b();
            }
            if (this.f713i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f713i);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f706c);
                jbVar.b();
            }
            if (this.f714j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f714j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f698a);
                jbVar.b();
            }
            if (this.f715k != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f715k);
                jbVar.b();
            }
            if (q()) {
                jbVar.a(q);
                jbVar.a(this.f703b);
                jbVar.b();
            }
            if (this.f716l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f716l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f702a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m486b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f700a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f702a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f705b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f702a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f707c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f702a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f702a.get(0) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f708d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f709e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f710f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f711g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f702a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f712h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f713i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f702a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f714j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f702a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f715k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f702a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f716l != null : invokeV.booleanValue;
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
                String str = this.f701a;
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
                hu huVar = this.f700a;
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
            String str2 = this.f705b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f707c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f699a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f708d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f709e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f710f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f711g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f704b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f712h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f713i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f706c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f714j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f698a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f715k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f703b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f716l;
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
