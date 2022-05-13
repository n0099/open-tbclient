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
public class hr implements iq<hr, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f500a;
    public static final iy b;
    public static final iy c;
    public static final iy d;
    public static final iy e;
    public static final iy f;
    public static final iy g;
    public static final iy h;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f501a;

    /* renamed from: a  reason: collision with other field name */
    public hs f502a;

    /* renamed from: a  reason: collision with other field name */
    public hu f503a;

    /* renamed from: a  reason: collision with other field name */
    public String f504a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f505a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f506a;

    /* renamed from: b  reason: collision with other field name */
    public long f507b;

    /* renamed from: b  reason: collision with other field name */
    public String f508b;

    /* renamed from: c  reason: collision with other field name */
    public long f509c;

    /* renamed from: c  reason: collision with other field name */
    public String f510c;

    /* renamed from: d  reason: collision with other field name */
    public String f511d;

    /* renamed from: e  reason: collision with other field name */
    public String f512e;

    /* renamed from: f  reason: collision with other field name */
    public String f513f;

    /* renamed from: g  reason: collision with other field name */
    public String f514g;

    /* renamed from: h  reason: collision with other field name */
    public String f515h;

    /* renamed from: i  reason: collision with other field name */
    public String f516i;

    /* renamed from: j  reason: collision with other field name */
    public String f517j;

    /* renamed from: k  reason: collision with other field name */
    public String f518k;

    /* renamed from: l  reason: collision with other field name */
    public String f519l;

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
        f500a = new jg("PushMessage");
        a = new iy("", (byte) 12, (short) 1);
        b = new iy("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new iy("", (byte) 10, (short) 5);
        f = new iy("", (byte) 10, (short) 6);
        g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
        k = new iy("", Constants.GZIP_CAST_TYPE, (short) 11);
        l = new iy("", (byte) 12, (short) 12);
        m = new iy("", Constants.GZIP_CAST_TYPE, (short) 13);
        n = new iy("", (byte) 2, (short) 14);
        o = new iy("", Constants.GZIP_CAST_TYPE, (short) 15);
        p = new iy("", (byte) 10, (short) 16);
        q = new iy("", Constants.GZIP_CAST_TYPE, (short) 20);
        r = new iy("", Constants.GZIP_CAST_TYPE, (short) 21);
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
        this.f505a = new BitSet(4);
        this.f506a = false;
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
                int compareTo = Boolean.valueOf(m440a()).compareTo(Boolean.valueOf(hrVar.m440a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m440a() || (a19 = ir.a(this.f503a, hrVar.f503a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m442b()).compareTo(Boolean.valueOf(hrVar.m442b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m442b() || (a18 = ir.a(this.f504a, hrVar.f504a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m443c()).compareTo(Boolean.valueOf(hrVar.m443c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m443c() || (a17 = ir.a(this.f508b, hrVar.f508b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hrVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f510c, hrVar.f510c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hrVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f501a, hrVar.f501a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hrVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f507b, hrVar.f507b)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hrVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f511d, hrVar.f511d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hrVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f512e, hrVar.f512e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hrVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f513f, hrVar.f513f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hrVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f514g, hrVar.f514g)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hrVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f515h, hrVar.f515h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hrVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f502a, hrVar.f502a)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hrVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f516i, hrVar.f516i)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hrVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f506a, hrVar.f506a)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hrVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f517j, hrVar.f517j)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hrVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f509c, hrVar.f509c)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hrVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f518k, hrVar.f518k)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hrVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f519l, hrVar.f519l)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f501a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m438a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f504a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m439a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f504a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f508b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f510c != null) {
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
        jbVar.m563a();
        while (true) {
            iy m559a = jbVar.m559a();
            byte b2 = m559a.a;
            if (b2 == 0) {
                jbVar.f();
                m439a();
                return;
            }
            short s = m559a.f791a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f518k = jbVar.m564a();
                    jbVar.g();
                }
                je.a(jbVar, b2);
                jbVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hu huVar = new hu();
                            this.f503a = huVar;
                            huVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f504a = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f508b = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f510c = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f501a = jbVar.m558a();
                            a(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f507b = jbVar.m558a();
                            b(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f511d = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f512e = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f513f = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f514g = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f515h = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hs hsVar = new hs();
                            this.f502a = hsVar;
                            hsVar.a(jbVar);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f516i = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f506a = jbVar.m568a();
                            c(true);
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f517j = jbVar.m564a();
                            break;
                        }
                        je.a(jbVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f509c = jbVar.m558a();
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
                    this.f519l = jbVar.m564a();
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
            this.f505a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m440a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f503a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m441a(hr hrVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hrVar)) == null) {
            if (hrVar == null) {
                return false;
            }
            boolean m440a = m440a();
            boolean m440a2 = hrVar.m440a();
            if ((m440a || m440a2) && !(m440a && m440a2 && this.f503a.m458a(hrVar.f503a))) {
                return false;
            }
            boolean m442b = m442b();
            boolean m442b2 = hrVar.m442b();
            if ((m442b || m442b2) && !(m442b && m442b2 && this.f504a.equals(hrVar.f504a))) {
                return false;
            }
            boolean m443c = m443c();
            boolean m443c2 = hrVar.m443c();
            if ((m443c || m443c2) && !(m443c && m443c2 && this.f508b.equals(hrVar.f508b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hrVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f510c.equals(hrVar.f510c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hrVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f501a == hrVar.f501a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hrVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f507b == hrVar.f507b)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hrVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f511d.equals(hrVar.f511d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hrVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f512e.equals(hrVar.f512e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hrVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f513f.equals(hrVar.f513f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hrVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f514g.equals(hrVar.f514g))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hrVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f515h.equals(hrVar.f515h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = hrVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f502a.m450a(hrVar.f502a))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = hrVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f516i.equals(hrVar.f516i))) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = hrVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f506a == hrVar.f506a)) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = hrVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f517j.equals(hrVar.f517j))) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = hrVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f509c == hrVar.f509c)) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = hrVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f518k.equals(hrVar.f518k))) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = hrVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f519l.equals(hrVar.f519l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f508b : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m439a();
            jbVar.a(f500a);
            if (this.f503a != null && m440a()) {
                jbVar.a(a);
                this.f503a.b(jbVar);
                jbVar.b();
            }
            if (this.f504a != null) {
                jbVar.a(b);
                jbVar.a(this.f504a);
                jbVar.b();
            }
            if (this.f508b != null) {
                jbVar.a(c);
                jbVar.a(this.f508b);
                jbVar.b();
            }
            if (this.f510c != null) {
                jbVar.a(d);
                jbVar.a(this.f510c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(e);
                jbVar.a(this.f501a);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f);
                jbVar.a(this.f507b);
                jbVar.b();
            }
            if (this.f511d != null && g()) {
                jbVar.a(g);
                jbVar.a(this.f511d);
                jbVar.b();
            }
            if (this.f512e != null && h()) {
                jbVar.a(h);
                jbVar.a(this.f512e);
                jbVar.b();
            }
            if (this.f513f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f513f);
                jbVar.b();
            }
            if (this.f514g != null && j()) {
                jbVar.a(j);
                jbVar.a(this.f514g);
                jbVar.b();
            }
            if (this.f515h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f515h);
                jbVar.b();
            }
            if (this.f502a != null && l()) {
                jbVar.a(l);
                this.f502a.b(jbVar);
                jbVar.b();
            }
            if (this.f516i != null && m()) {
                jbVar.a(m);
                jbVar.a(this.f516i);
                jbVar.b();
            }
            if (n()) {
                jbVar.a(n);
                jbVar.a(this.f506a);
                jbVar.b();
            }
            if (this.f517j != null && o()) {
                jbVar.a(o);
                jbVar.a(this.f517j);
                jbVar.b();
            }
            if (p()) {
                jbVar.a(p);
                jbVar.a(this.f509c);
                jbVar.b();
            }
            if (this.f518k != null && q()) {
                jbVar.a(q);
                jbVar.a(this.f518k);
                jbVar.b();
            }
            if (this.f519l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f519l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m567a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f505a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m442b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f504a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f510c : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f505a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m443c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f508b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f505a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f510c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f505a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof hr)) {
                return m441a((hr) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f505a.get(1) : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f511d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f512e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f513f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f514g != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f515h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f502a != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f516i != null : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f505a.get(2) : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f517j != null : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f505a.get(3) : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f518k != null : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f519l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("PushMessage(");
            if (m440a()) {
                sb.append("to:");
                hu huVar = this.f503a;
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
            String str = this.f504a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f508b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("payload:");
            String str3 = this.f510c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createAt:");
                sb.append(this.f501a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("ttl:");
                sb.append(this.f507b);
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("collapseKey:");
                String str4 = this.f511d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f512e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str6 = this.f513f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f514g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str8 = this.f515h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("metaInfo:");
                hs hsVar = this.f502a;
                if (hsVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hsVar);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f516i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isOnline:");
                sb.append(this.f506a);
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("userAccount:");
                String str10 = this.f517j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("miid:");
                sb.append(this.f509c);
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("imeiMd5:");
                String str11 = this.f518k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str12 = this.f519l;
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
