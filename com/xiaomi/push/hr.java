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
/* loaded from: classes10.dex */
public class hr implements iq<hr, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77654a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f523a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77655b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77656c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77657d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77658e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77659f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77660g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77661h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77662i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77663j;
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
    public long f524a;

    /* renamed from: a  reason: collision with other field name */
    public hs f525a;

    /* renamed from: a  reason: collision with other field name */
    public hu f526a;

    /* renamed from: a  reason: collision with other field name */
    public String f527a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f528a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f529a;

    /* renamed from: b  reason: collision with other field name */
    public long f530b;

    /* renamed from: b  reason: collision with other field name */
    public String f531b;

    /* renamed from: c  reason: collision with other field name */
    public long f532c;

    /* renamed from: c  reason: collision with other field name */
    public String f533c;

    /* renamed from: d  reason: collision with other field name */
    public String f534d;

    /* renamed from: e  reason: collision with other field name */
    public String f535e;

    /* renamed from: f  reason: collision with other field name */
    public String f536f;

    /* renamed from: g  reason: collision with other field name */
    public String f537g;

    /* renamed from: h  reason: collision with other field name */
    public String f538h;

    /* renamed from: i  reason: collision with other field name */
    public String f539i;

    /* renamed from: j  reason: collision with other field name */
    public String f540j;

    /* renamed from: k  reason: collision with other field name */
    public String f541k;

    /* renamed from: l  reason: collision with other field name */
    public String f542l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372618, "Lcom/xiaomi/push/hr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372618, "Lcom/xiaomi/push/hr;");
                return;
            }
        }
        f523a = new jg("PushMessage");
        f77654a = new iy("", StandardMessageCodec.LIST, (short) 1);
        f77655b = new iy("", (byte) 11, (short) 2);
        f77656c = new iy("", (byte) 11, (short) 3);
        f77657d = new iy("", (byte) 11, (short) 4);
        f77658e = new iy("", (byte) 10, (short) 5);
        f77659f = new iy("", (byte) 10, (short) 6);
        f77660g = new iy("", (byte) 11, (short) 7);
        f77661h = new iy("", (byte) 11, (short) 8);
        f77662i = new iy("", (byte) 11, (short) 9);
        f77663j = new iy("", (byte) 11, (short) 10);
        k = new iy("", (byte) 11, (short) 11);
        l = new iy("", StandardMessageCodec.LIST, (short) 12);
        m = new iy("", (byte) 11, (short) 13);
        n = new iy("", (byte) 2, (short) 14);
        o = new iy("", (byte) 11, (short) 15);
        p = new iy("", (byte) 10, (short) 16);
        q = new iy("", (byte) 11, (short) 20);
        r = new iy("", (byte) 11, (short) 21);
    }

    public hr() {
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
        this.f528a = new BitSet(4);
        this.f529a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hr hrVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hrVar)) == null) {
            if (hr.class.equals(hrVar.getClass())) {
                int compareTo = Boolean.valueOf(m404a()).compareTo(Boolean.valueOf(hrVar.m404a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m404a() || (a19 = ir.a(this.f526a, hrVar.f526a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m406b()).compareTo(Boolean.valueOf(hrVar.m406b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m406b() || (a18 = ir.a(this.f527a, hrVar.f527a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m407c()).compareTo(Boolean.valueOf(hrVar.m407c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m407c() || (a17 = ir.a(this.f531b, hrVar.f531b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f533c, hrVar.f533c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f524a, hrVar.f524a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f530b, hrVar.f530b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f534d, hrVar.f534d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f535e, hrVar.f535e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hrVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f536f, hrVar.f536f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hrVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f537g, hrVar.f537g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hrVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f538h, hrVar.f538h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hrVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f525a, hrVar.f525a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hrVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f539i, hrVar.f539i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hrVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f529a, hrVar.f529a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hrVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f540j, hrVar.f540j)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hrVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f532c, hrVar.f532c)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hrVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f541k, hrVar.f541k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hrVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f542l, hrVar.f542l)) == 0) {
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
            return hr.class.getName().compareTo(hrVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f524a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m402a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f527a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m403a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f527a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f531b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f533c != null) {
            } else {
                throw new jc("Required field 'payload' was not present! Struct: " + toString());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f77856a;
            if (b2 == 0) {
                jbVar.f();
                m403a();
                return;
            }
            short s = m523a.f814a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f541k = jbVar.m528a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f526a = huVar;
                            huVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f527a = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f531b = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f533c = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f524a = jbVar.m522a();
                            a(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f530b = jbVar.m522a();
                            b(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f534d = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f535e = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f536f = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f537g = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f538h = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hs hsVar = new hs();
                            this.f525a = hsVar;
                            hsVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f539i = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f529a = jbVar.m532a();
                            c(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f540j = jbVar.m528a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f532c = jbVar.m522a();
                            d(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    default:
                        je.a(jbVar, b2);
                        break;
                }
                jbVar.g();
            } else {
                if (b2 == 11) {
                    this.f542l = jbVar.m528a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f528a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m404a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f526a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m405a(hr hrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hrVar)) == null) {
            if (hrVar == null) {
                return false;
            }
            boolean m404a = m404a();
            boolean m404a2 = hrVar.m404a();
            if ((m404a || m404a2) && !(m404a && m404a2 && this.f526a.m422a(hrVar.f526a))) {
                return false;
            }
            boolean m406b = m406b();
            boolean m406b2 = hrVar.m406b();
            if ((m406b || m406b2) && !(m406b && m406b2 && this.f527a.equals(hrVar.f527a))) {
                return false;
            }
            boolean m407c = m407c();
            boolean m407c2 = hrVar.m407c();
            if ((m407c || m407c2) && !(m407c && m407c2 && this.f531b.equals(hrVar.f531b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hrVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f533c.equals(hrVar.f533c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hrVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f524a == hrVar.f524a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hrVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f530b == hrVar.f530b)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hrVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f534d.equals(hrVar.f534d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hrVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f535e.equals(hrVar.f535e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hrVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f536f.equals(hrVar.f536f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hrVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f537g.equals(hrVar.f537g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hrVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f538h.equals(hrVar.f538h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hrVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f525a.m414a(hrVar.f525a))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hrVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f539i.equals(hrVar.f539i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hrVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f529a == hrVar.f529a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hrVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f540j.equals(hrVar.f540j))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hrVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f532c == hrVar.f532c)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hrVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f541k.equals(hrVar.f541k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hrVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f542l.equals(hrVar.f542l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f531b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m403a();
            jbVar.a(f523a);
            if (this.f526a != null && m404a()) {
                jbVar.a(f77654a);
                this.f526a.b(jbVar);
                jbVar.b();
            }
            if (this.f527a != null) {
                jbVar.a(f77655b);
                jbVar.a(this.f527a);
                jbVar.b();
            }
            if (this.f531b != null) {
                jbVar.a(f77656c);
                jbVar.a(this.f531b);
                jbVar.b();
            }
            if (this.f533c != null) {
                jbVar.a(f77657d);
                jbVar.a(this.f533c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f77658e);
                jbVar.a(this.f524a);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f77659f);
                jbVar.a(this.f530b);
                jbVar.b();
            }
            if (this.f534d != null && g()) {
                jbVar.a(f77660g);
                jbVar.a(this.f534d);
                jbVar.b();
            }
            if (this.f535e != null && h()) {
                jbVar.a(f77661h);
                jbVar.a(this.f535e);
                jbVar.b();
            }
            if (this.f536f != null && i()) {
                jbVar.a(f77662i);
                jbVar.a(this.f536f);
                jbVar.b();
            }
            if (this.f537g != null && j()) {
                jbVar.a(f77663j);
                jbVar.a(this.f537g);
                jbVar.b();
            }
            if (this.f538h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f538h);
                jbVar.b();
            }
            if (this.f525a != null && l()) {
                jbVar.a(l);
                this.f525a.b(jbVar);
                jbVar.b();
            }
            if (this.f539i != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f539i);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f529a);
                jbVar.b();
            }
            if (this.f540j != null && o()) {
                jbVar.a(o);
                jbVar.a(this.f540j);
                jbVar.b();
            }
            if (p()) {
                jbVar.a(p);
                jbVar.a(this.f532c);
                jbVar.b();
            }
            if (this.f541k != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f541k);
                jbVar.b();
            }
            if (this.f542l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f542l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f528a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m406b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f527a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f533c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f528a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m407c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f531b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f528a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f533c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f528a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof hr)) {
                return m405a((hr) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f528a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f534d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f535e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f536f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f537g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f538h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f525a != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f539i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f528a.get(2) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f540j != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f528a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f541k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f542l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMessage(");
            if (m404a()) {
                sb.append("to:");
                hu huVar = this.f526a;
                if (huVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(huVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str = this.f527a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f531b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str3 = this.f533c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createAt:");
                sb.append(this.f524a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ttl:");
                sb.append(this.f530b);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("collapseKey:");
                String str4 = this.f534d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f535e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str6 = this.f536f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f537g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str8 = this.f538h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f525a;
                if (hsVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hsVar);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f539i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f529a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f540j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f532c);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f541k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f542l;
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
