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
import java.io.Serializable;
import java.util.BitSet;
/* loaded from: classes7.dex */
public class ig implements iq<ig, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f673a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44449b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44450c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44451d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44452e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44453f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44454g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44455h;
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
    public int f674a;

    /* renamed from: a  reason: collision with other field name */
    public long f675a;

    /* renamed from: a  reason: collision with other field name */
    public hu f676a;

    /* renamed from: a  reason: collision with other field name */
    public String f677a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f678a;

    /* renamed from: b  reason: collision with other field name */
    public int f679b;

    /* renamed from: b  reason: collision with other field name */
    public long f680b;

    /* renamed from: b  reason: collision with other field name */
    public String f681b;

    /* renamed from: c  reason: collision with other field name */
    public long f682c;

    /* renamed from: c  reason: collision with other field name */
    public String f683c;

    /* renamed from: d  reason: collision with other field name */
    public String f684d;

    /* renamed from: e  reason: collision with other field name */
    public String f685e;

    /* renamed from: f  reason: collision with other field name */
    public String f686f;

    /* renamed from: g  reason: collision with other field name */
    public String f687g;

    /* renamed from: h  reason: collision with other field name */
    public String f688h;

    /* renamed from: i  reason: collision with other field name */
    public String f689i;

    /* renamed from: j  reason: collision with other field name */
    public String f690j;

    /* renamed from: k  reason: collision with other field name */
    public String f691k;

    /* renamed from: l  reason: collision with other field name */
    public String f692l;

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
        f673a = new jg("XmPushActionRegistrationResult");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44449b = new iy("", (byte) 12, (short) 2);
        f44450c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44451d = new iy("", Constants.GZIP_CAST_TYPE, (short) 4);
        f44452e = new iy("", (byte) 10, (short) 6);
        f44453f = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44454g = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        f44455h = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 10);
        j = new iy("", (byte) 10, (short) 11);
        k = new iy("", Constants.GZIP_CAST_TYPE, (short) 12);
        l = new iy("", Constants.GZIP_CAST_TYPE, (short) 13);
        m = new iy("", (byte) 10, (short) 14);
        n = new iy("", Constants.GZIP_CAST_TYPE, (short) 15);
        o = new iy("", (byte) 8, (short) 16);
        p = new iy("", Constants.GZIP_CAST_TYPE, (short) 17);
        q = new iy("", (byte) 8, (short) 18);
        r = new iy("", Constants.GZIP_CAST_TYPE, (short) 19);
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
        this.f678a = new BitSet(5);
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
                int compareTo = Boolean.valueOf(m523a()).compareTo(Boolean.valueOf(igVar.m523a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m523a() || (a19 = ir.a(this.f677a, igVar.f677a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m525b()).compareTo(Boolean.valueOf(igVar.m525b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m525b() || (a18 = ir.a(this.f676a, igVar.f676a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(igVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a17 = ir.a(this.f681b, igVar.f681b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(igVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a16 = ir.a(this.f683c, igVar.f683c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(igVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a15 = ir.a(this.f675a, igVar.f675a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(igVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a14 = ir.a(this.f684d, igVar.f684d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(igVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a13 = ir.a(this.f685e, igVar.f685e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(igVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a12 = ir.a(this.f686f, igVar.f686f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(igVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a11 = ir.a(this.f687g, igVar.f687g)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(igVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a10 = ir.a(this.f680b, igVar.f680b)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(igVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a9 = ir.a(this.f688h, igVar.f688h)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(igVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a8 = ir.a(this.f689i, igVar.f689i)) == 0) {
                                                                int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(igVar.m()));
                                                                if (compareTo13 != 0) {
                                                                    return compareTo13;
                                                                }
                                                                if (!m() || (a7 = ir.a(this.f682c, igVar.f682c)) == 0) {
                                                                    int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(igVar.n()));
                                                                    if (compareTo14 != 0) {
                                                                        return compareTo14;
                                                                    }
                                                                    if (!n() || (a6 = ir.a(this.f690j, igVar.f690j)) == 0) {
                                                                        int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(igVar.o()));
                                                                        if (compareTo15 != 0) {
                                                                            return compareTo15;
                                                                        }
                                                                        if (!o() || (a5 = ir.a(this.f674a, igVar.f674a)) == 0) {
                                                                            int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(igVar.p()));
                                                                            if (compareTo16 != 0) {
                                                                                return compareTo16;
                                                                            }
                                                                            if (!p() || (a4 = ir.a(this.f691k, igVar.f691k)) == 0) {
                                                                                int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(igVar.q()));
                                                                                if (compareTo17 != 0) {
                                                                                    return compareTo17;
                                                                                }
                                                                                if (!q() || (a3 = ir.a(this.f679b, igVar.f679b)) == 0) {
                                                                                    int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(igVar.r()));
                                                                                    if (compareTo18 != 0) {
                                                                                        return compareTo18;
                                                                                    }
                                                                                    if (!r() || (a2 = ir.a(this.f692l, igVar.f692l)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f675a : invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m521a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f681b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m522a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f681b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f683c != null) {
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
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                if (e()) {
                    m522a();
                    return;
                }
                throw new jc("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f677a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f676a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f681b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f683c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f675a = jbVar.m561a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f684d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f685e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f686f = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f687g = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f680b = jbVar.m561a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f688h = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f689i = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f682c = jbVar.m561a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f690j = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f674a = jbVar.m560a();
                        d(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f691k = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f679b = jbVar.m560a();
                        e(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f692l = jbVar.m567a();
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
            this.f678a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m523a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f677a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m524a(ig igVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, igVar)) == null) {
            if (igVar == null) {
                return false;
            }
            boolean m523a = m523a();
            boolean m523a2 = igVar.m523a();
            if ((m523a || m523a2) && !(m523a && m523a2 && this.f677a.equals(igVar.f677a))) {
                return false;
            }
            boolean m525b = m525b();
            boolean m525b2 = igVar.m525b();
            if ((m525b || m525b2) && !(m525b && m525b2 && this.f676a.m461a(igVar.f676a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = igVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f681b.equals(igVar.f681b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = igVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f683c.equals(igVar.f683c))) || this.f675a != igVar.f675a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = igVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f684d.equals(igVar.f684d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = igVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f685e.equals(igVar.f685e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = igVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f686f.equals(igVar.f686f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = igVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f687g.equals(igVar.f687g))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = igVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f680b == igVar.f680b)) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = igVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f688h.equals(igVar.f688h))) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = igVar.l();
            if ((l2 || l3) && !(l2 && l3 && this.f689i.equals(igVar.f689i))) {
                return false;
            }
            boolean m2 = m();
            boolean m3 = igVar.m();
            if ((m2 || m3) && !(m2 && m3 && this.f682c == igVar.f682c)) {
                return false;
            }
            boolean n2 = n();
            boolean n3 = igVar.n();
            if ((n2 || n3) && !(n2 && n3 && this.f690j.equals(igVar.f690j))) {
                return false;
            }
            boolean o2 = o();
            boolean o3 = igVar.o();
            if ((o2 || o3) && !(o2 && o3 && this.f674a == igVar.f674a)) {
                return false;
            }
            boolean p2 = p();
            boolean p3 = igVar.p();
            if ((p2 || p3) && !(p2 && p3 && this.f691k.equals(igVar.f691k))) {
                return false;
            }
            boolean q2 = q();
            boolean q3 = igVar.q();
            if ((q2 || q3) && !(q2 && q3 && this.f679b == igVar.f679b)) {
                return false;
            }
            boolean r2 = r();
            boolean r3 = igVar.r();
            if (r2 || r3) {
                return r2 && r3 && this.f692l.equals(igVar.f692l);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f687g : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jbVar) == null) {
            m522a();
            jbVar.a(f673a);
            if (this.f677a != null && m523a()) {
                jbVar.a(a);
                jbVar.a(this.f677a);
                jbVar.b();
            }
            if (this.f676a != null && m525b()) {
                jbVar.a(f44449b);
                this.f676a.b(jbVar);
                jbVar.b();
            }
            if (this.f681b != null) {
                jbVar.a(f44450c);
                jbVar.a(this.f681b);
                jbVar.b();
            }
            if (this.f683c != null) {
                jbVar.a(f44451d);
                jbVar.a(this.f683c);
                jbVar.b();
            }
            jbVar.a(f44452e);
            jbVar.a(this.f675a);
            jbVar.b();
            if (this.f684d != null && f()) {
                jbVar.a(f44453f);
                jbVar.a(this.f684d);
                jbVar.b();
            }
            if (this.f685e != null && g()) {
                jbVar.a(f44454g);
                jbVar.a(this.f685e);
                jbVar.b();
            }
            if (this.f686f != null && h()) {
                jbVar.a(f44455h);
                jbVar.a(this.f686f);
                jbVar.b();
            }
            if (this.f687g != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f687g);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f680b);
                jbVar.b();
            }
            if (this.f688h != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f688h);
                jbVar.b();
            }
            if (this.f689i != null && l()) {
                jbVar.a(l);
                jbVar.a(this.f689i);
                jbVar.b();
            }
            if (m()) {
                jbVar.a(m);
                jbVar.a(this.f682c);
                jbVar.b();
            }
            if (this.f690j != null && n()) {
                jbVar.a(n);
                jbVar.a(this.f690j);
                jbVar.b();
            }
            if (o()) {
                jbVar.a(o);
                jbVar.a(this.f674a);
                jbVar.b();
            }
            if (this.f691k != null && p()) {
                jbVar.a(p);
                jbVar.a(this.f691k);
                jbVar.b();
            }
            if (q()) {
                jbVar.a(q);
                jbVar.a(this.f679b);
                jbVar.b();
            }
            if (this.f692l != null && r()) {
                jbVar.a(r);
                jbVar.a(this.f692l);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f678a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m525b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f676a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f678a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f681b != null : invokeV.booleanValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f678a.set(3, z);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f683c != null : invokeV.booleanValue;
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f678a.set(4, z);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f678a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj != null && (obj instanceof ig)) {
                return m524a((ig) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f684d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f685e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f686f != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f687g != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f678a.get(1) : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f688h != null : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f689i != null : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f678a.get(2) : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f690j != null : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f678a.get(3) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f691k != null : invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f678a.get(4) : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f692l != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
            boolean z2 = false;
            if (m523a()) {
                sb.append("debug:");
                String str = this.f677a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m525b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hu huVar = this.f676a;
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
            String str2 = this.f681b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f683c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f675a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f684d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str5 = this.f685e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regSecret:");
                String str6 = this.f686f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str7 = this.f687g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("registeredAt:");
                sb.append(this.f680b);
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str8 = this.f688h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("clientId:");
                String str9 = this.f689i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (m()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f682c);
            }
            if (n()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str10 = this.f690j;
                if (str10 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str10);
                }
            }
            if (o()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("pushSdkVersionCode:");
                sb.append(this.f674a);
            }
            if (p()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("hybridPushEndpoint:");
                String str11 = this.f691k;
                if (str11 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str11);
                }
            }
            if (q()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersionCode:");
                sb.append(this.f679b);
            }
            if (r()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("region:");
                String str12 = this.f692l;
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
