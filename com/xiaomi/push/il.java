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
/* loaded from: classes4.dex */
public class il implements iq<il, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f760a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61396b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61397c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61398d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61399e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61400f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f61401g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f61402h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f61403i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f61404j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f761a;

    /* renamed from: a  reason: collision with other field name */
    public hu f762a;

    /* renamed from: a  reason: collision with other field name */
    public String f763a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f764a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f765a;

    /* renamed from: b  reason: collision with other field name */
    public String f766b;

    /* renamed from: c  reason: collision with other field name */
    public String f767c;

    /* renamed from: d  reason: collision with other field name */
    public String f768d;

    /* renamed from: e  reason: collision with other field name */
    public String f769e;

    /* renamed from: f  reason: collision with other field name */
    public String f770f;

    /* renamed from: g  reason: collision with other field name */
    public String f771g;

    /* renamed from: h  reason: collision with other field name */
    public String f772h;

    /* renamed from: i  reason: collision with other field name */
    public String f773i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371843, "Lcom/xiaomi/push/il;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371843, "Lcom/xiaomi/push/il;");
                return;
            }
        }
        f760a = new jg("XmPushActionUnRegistration");
        a = new iy("", (byte) 11, (short) 1);
        f61396b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f61397c = new iy("", (byte) 11, (short) 3);
        f61398d = new iy("", (byte) 11, (short) 4);
        f61399e = new iy("", (byte) 11, (short) 5);
        f61400f = new iy("", (byte) 11, (short) 6);
        f61401g = new iy("", (byte) 11, (short) 7);
        f61402h = new iy("", (byte) 11, (short) 8);
        f61403i = new iy("", (byte) 11, (short) 9);
        f61404j = new iy("", (byte) 11, (short) 10);
        k = new iy("", (byte) 2, (short) 11);
        l = new iy("", (byte) 10, (short) 12);
    }

    public il() {
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
        this.f764a = new BitSet(2);
        this.f765a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ilVar)) == null) {
            if (il.class.equals(ilVar.getClass())) {
                int compareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(ilVar.m566a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m566a() || (a13 = ir.a(this.f763a, ilVar.f763a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a12 = ir.a(this.f762a, ilVar.f762a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a11 = ir.a(this.f766b, ilVar.f766b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a10 = ir.a(this.f767c, ilVar.f767c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a9 = ir.a(this.f768d, ilVar.f768d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a8 = ir.a(this.f769e, ilVar.f769e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f770f, ilVar.f770f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f771g, ilVar.f771g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f772h, ilVar.f772h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f773i, ilVar.f773i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f765a, ilVar.f765a)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f761a, ilVar.f761a)) == 0) {
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
            return il.class.getName().compareTo(ilVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public il a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f766b = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f766b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f767c != null) {
            } else {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m588a();
        while (true) {
            iy m584a = jbVar.m584a();
            byte b2 = m584a.a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            switch (m584a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f763a = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f762a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f766b = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f767c = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f768d = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f769e = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f770f = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f771g = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f772h = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f773i = jbVar.m589a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f765a = jbVar.m593a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f761a = jbVar.m583a();
                        b(true);
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
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f764a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m566a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f763a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m567a(il ilVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ilVar)) == null) {
            if (ilVar == null) {
                return false;
            }
            boolean m566a = m566a();
            boolean m566a2 = ilVar.m566a();
            if ((m566a || m566a2) && !(m566a && m566a2 && this.f763a.equals(ilVar.f763a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ilVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f762a.m483a(ilVar.f762a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ilVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f766b.equals(ilVar.f766b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ilVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f767c.equals(ilVar.f767c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ilVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f768d.equals(ilVar.f768d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ilVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f769e.equals(ilVar.f769e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ilVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f770f.equals(ilVar.f770f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ilVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f771g.equals(ilVar.f771g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ilVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f772h.equals(ilVar.f772h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ilVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f773i.equals(ilVar.f773i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ilVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f765a == ilVar.f765a)) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ilVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f761a == ilVar.f761a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public il b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.f767c = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            a();
            jbVar.a(f760a);
            if (this.f763a != null && m566a()) {
                jbVar.a(a);
                jbVar.a(this.f763a);
                jbVar.b();
            }
            if (this.f762a != null && b()) {
                jbVar.a(f61396b);
                this.f762a.b(jbVar);
                jbVar.b();
            }
            if (this.f766b != null) {
                jbVar.a(f61397c);
                jbVar.a(this.f766b);
                jbVar.b();
            }
            if (this.f767c != null) {
                jbVar.a(f61398d);
                jbVar.a(this.f767c);
                jbVar.b();
            }
            if (this.f768d != null && e()) {
                jbVar.a(f61399e);
                jbVar.a(this.f768d);
                jbVar.b();
            }
            if (this.f769e != null && f()) {
                jbVar.a(f61400f);
                jbVar.a(this.f769e);
                jbVar.b();
            }
            if (this.f770f != null && g()) {
                jbVar.a(f61401g);
                jbVar.a(this.f770f);
                jbVar.b();
            }
            if (this.f771g != null && h()) {
                jbVar.a(f61402h);
                jbVar.a(this.f771g);
                jbVar.b();
            }
            if (this.f772h != null && i()) {
                jbVar.a(f61403i);
                jbVar.a(this.f772h);
                jbVar.b();
            }
            if (this.f773i != null && j()) {
                jbVar.a(f61404j);
                jbVar.a(this.f773i);
                jbVar.b();
            }
            if (k()) {
                jbVar.a(k);
                jbVar.a(this.f765a);
                jbVar.b();
            }
            if (l()) {
                jbVar.a(l);
                jbVar.a(this.f761a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f764a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f762a != null : invokeV.booleanValue;
    }

    public il c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f768d = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f766b != null : invokeV.booleanValue;
    }

    public il d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f770f = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f767c != null : invokeV.booleanValue;
    }

    public il e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f771g = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f768d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof il)) {
                return m567a((il) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f769e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f770f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f771g != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f772h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f773i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f764a.get(0) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f764a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
            boolean z2 = false;
            if (m566a()) {
                sb.append("debug:");
                String str = this.f763a;
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
                hu huVar = this.f762a;
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
            String str2 = this.f766b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f767c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str4 = this.f768d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str5 = this.f769e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f770f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("token:");
                String str7 = this.f771g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str8 = this.f772h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f773i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f765a);
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f761a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
