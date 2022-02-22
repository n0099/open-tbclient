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
/* loaded from: classes4.dex */
public class hr implements iq<hr, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f524a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61431b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61432c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61433d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61434e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61435f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61436g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61437h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f61438i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f61439j;
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
    public long f525a;

    /* renamed from: a  reason: collision with other field name */
    public hs f526a;

    /* renamed from: a  reason: collision with other field name */
    public hu f527a;

    /* renamed from: a  reason: collision with other field name */
    public String f528a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f529a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f530a;

    /* renamed from: b  reason: collision with other field name */
    public long f531b;

    /* renamed from: b  reason: collision with other field name */
    public String f532b;

    /* renamed from: c  reason: collision with other field name */
    public long f533c;

    /* renamed from: c  reason: collision with other field name */
    public String f534c;

    /* renamed from: d  reason: collision with other field name */
    public String f535d;

    /* renamed from: e  reason: collision with other field name */
    public String f536e;

    /* renamed from: f  reason: collision with other field name */
    public String f537f;

    /* renamed from: g  reason: collision with other field name */
    public String f538g;

    /* renamed from: h  reason: collision with other field name */
    public String f539h;

    /* renamed from: i  reason: collision with other field name */
    public String f540i;

    /* renamed from: j  reason: collision with other field name */
    public String f541j;

    /* renamed from: k  reason: collision with other field name */
    public String f542k;

    /* renamed from: l  reason: collision with other field name */
    public String f543l;

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
        f524a = new jg("PushMessage");
        a = new iy("", StandardMessageCodec.LIST, (short) 1);
        f61431b = new iy("", (byte) 11, (short) 2);
        f61432c = new iy("", (byte) 11, (short) 3);
        f61433d = new iy("", (byte) 11, (short) 4);
        f61434e = new iy("", (byte) 10, (short) 5);
        f61435f = new iy("", (byte) 10, (short) 6);
        f61436g = new iy("", (byte) 11, (short) 7);
        f61437h = new iy("", (byte) 11, (short) 8);
        f61438i = new iy("", (byte) 11, (short) 9);
        f61439j = new iy("", (byte) 11, (short) 10);
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
        this.f529a = new BitSet(4);
        this.f530a = false;
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
                int compareTo = Boolean.valueOf(m464a()).compareTo(Boolean.valueOf(hrVar.m464a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m464a() || (a19 = ir.a(this.f527a, hrVar.f527a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m466b()).compareTo(Boolean.valueOf(hrVar.m466b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m466b() || (a18 = ir.a(this.f528a, hrVar.f528a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m467c()).compareTo(Boolean.valueOf(hrVar.m467c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m467c() || (a17 = ir.a(this.f532b, hrVar.f532b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f534c, hrVar.f534c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f525a, hrVar.f525a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f531b, hrVar.f531b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f535d, hrVar.f535d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f536e, hrVar.f536e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hrVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f537f, hrVar.f537f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hrVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f538g, hrVar.f538g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hrVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f539h, hrVar.f539h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hrVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f526a, hrVar.f526a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hrVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f540i, hrVar.f540i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hrVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f530a, hrVar.f530a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hrVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f541j, hrVar.f541j)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hrVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f533c, hrVar.f533c)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hrVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f542k, hrVar.f542k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hrVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f543l, hrVar.f543l)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f525a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m462a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f528a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m463a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f528a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f532b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f534c != null) {
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
        jbVar.m587a();
        while (true) {
            iy m583a = jbVar.m583a();
            byte b2 = m583a.a;
            if (b2 == 0) {
                jbVar.f();
                m463a();
                return;
            }
            short s = m583a.f815a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f542k = jbVar.m588a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f527a = huVar;
                            huVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f528a = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f532b = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f534c = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f525a = jbVar.m582a();
                            a(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f531b = jbVar.m582a();
                            b(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f535d = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f536e = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f537f = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f538g = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f539h = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hs hsVar = new hs();
                            this.f526a = hsVar;
                            hsVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f540i = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f530a = jbVar.m592a();
                            c(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f541j = jbVar.m588a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f533c = jbVar.m582a();
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
                    this.f543l = jbVar.m588a();
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
            this.f529a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m464a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f527a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m465a(hr hrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hrVar)) == null) {
            if (hrVar == null) {
                return false;
            }
            boolean m464a = m464a();
            boolean m464a2 = hrVar.m464a();
            if ((m464a || m464a2) && !(m464a && m464a2 && this.f527a.m482a(hrVar.f527a))) {
                return false;
            }
            boolean m466b = m466b();
            boolean m466b2 = hrVar.m466b();
            if ((m466b || m466b2) && !(m466b && m466b2 && this.f528a.equals(hrVar.f528a))) {
                return false;
            }
            boolean m467c = m467c();
            boolean m467c2 = hrVar.m467c();
            if ((m467c || m467c2) && !(m467c && m467c2 && this.f532b.equals(hrVar.f532b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hrVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f534c.equals(hrVar.f534c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hrVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f525a == hrVar.f525a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hrVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f531b == hrVar.f531b)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hrVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f535d.equals(hrVar.f535d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hrVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f536e.equals(hrVar.f536e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hrVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f537f.equals(hrVar.f537f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hrVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f538g.equals(hrVar.f538g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hrVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f539h.equals(hrVar.f539h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hrVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f526a.m474a(hrVar.f526a))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hrVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f540i.equals(hrVar.f540i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hrVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f530a == hrVar.f530a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hrVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f541j.equals(hrVar.f541j))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hrVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f533c == hrVar.f533c)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hrVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f542k.equals(hrVar.f542k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hrVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f543l.equals(hrVar.f543l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f532b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m463a();
            jbVar.a(f524a);
            if (this.f527a != null && m464a()) {
                jbVar.a(a);
                this.f527a.b(jbVar);
                jbVar.b();
            }
            if (this.f528a != null) {
                jbVar.a(f61431b);
                jbVar.a(this.f528a);
                jbVar.b();
            }
            if (this.f532b != null) {
                jbVar.a(f61432c);
                jbVar.a(this.f532b);
                jbVar.b();
            }
            if (this.f534c != null) {
                jbVar.a(f61433d);
                jbVar.a(this.f534c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f61434e);
                jbVar.a(this.f525a);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f61435f);
                jbVar.a(this.f531b);
                jbVar.b();
            }
            if (this.f535d != null && g()) {
                jbVar.a(f61436g);
                jbVar.a(this.f535d);
                jbVar.b();
            }
            if (this.f536e != null && h()) {
                jbVar.a(f61437h);
                jbVar.a(this.f536e);
                jbVar.b();
            }
            if (this.f537f != null && i()) {
                jbVar.a(f61438i);
                jbVar.a(this.f537f);
                jbVar.b();
            }
            if (this.f538g != null && j()) {
                jbVar.a(f61439j);
                jbVar.a(this.f538g);
                jbVar.b();
            }
            if (this.f539h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f539h);
                jbVar.b();
            }
            if (this.f526a != null && l()) {
                jbVar.a(l);
                this.f526a.b(jbVar);
                jbVar.b();
            }
            if (this.f540i != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f540i);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f530a);
                jbVar.b();
            }
            if (this.f541j != null && o()) {
                jbVar.a(o);
                jbVar.a(this.f541j);
                jbVar.b();
            }
            if (p()) {
                jbVar.a(p);
                jbVar.a(this.f533c);
                jbVar.b();
            }
            if (this.f542k != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f542k);
                jbVar.b();
            }
            if (this.f543l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f543l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m591a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f529a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m466b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f528a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f534c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f529a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m467c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f532b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f529a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f534c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f529a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof hr)) {
                return m465a((hr) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f529a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f535d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f536e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f537f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f538g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f539h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f526a != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f540i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f529a.get(2) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f541j != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f529a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f542k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f543l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMessage(");
            if (m464a()) {
                sb.append("to:");
                hu huVar = this.f527a;
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
            String str = this.f528a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f532b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str3 = this.f534c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createAt:");
                sb.append(this.f525a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ttl:");
                sb.append(this.f531b);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("collapseKey:");
                String str4 = this.f535d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f536e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str6 = this.f537f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f538g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str8 = this.f539h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f526a;
                if (hsVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hsVar);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f540i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f530a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f541j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f533c);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f542k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f543l;
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
