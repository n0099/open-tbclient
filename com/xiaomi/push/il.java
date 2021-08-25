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
public class il implements iq<il, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77807a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f759a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77808b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f77809c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f77810d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f77811e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f77812f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f77813g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f77814h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f77815i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f77816j;
    public static final iy k;
    public static final iy l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f760a;

    /* renamed from: a  reason: collision with other field name */
    public hu f761a;

    /* renamed from: a  reason: collision with other field name */
    public String f762a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f763a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f764a;

    /* renamed from: b  reason: collision with other field name */
    public String f765b;

    /* renamed from: c  reason: collision with other field name */
    public String f766c;

    /* renamed from: d  reason: collision with other field name */
    public String f767d;

    /* renamed from: e  reason: collision with other field name */
    public String f768e;

    /* renamed from: f  reason: collision with other field name */
    public String f769f;

    /* renamed from: g  reason: collision with other field name */
    public String f770g;

    /* renamed from: h  reason: collision with other field name */
    public String f771h;

    /* renamed from: i  reason: collision with other field name */
    public String f772i;

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
        f759a = new jg("XmPushActionUnRegistration");
        f77807a = new iy("", (byte) 11, (short) 1);
        f77808b = new iy("", StandardMessageCodec.LIST, (short) 2);
        f77809c = new iy("", (byte) 11, (short) 3);
        f77810d = new iy("", (byte) 11, (short) 4);
        f77811e = new iy("", (byte) 11, (short) 5);
        f77812f = new iy("", (byte) 11, (short) 6);
        f77813g = new iy("", (byte) 11, (short) 7);
        f77814h = new iy("", (byte) 11, (short) 8);
        f77815i = new iy("", (byte) 11, (short) 9);
        f77816j = new iy("", (byte) 11, (short) 10);
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
        this.f763a = new BitSet(2);
        this.f764a = true;
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
                int compareTo = Boolean.valueOf(m505a()).compareTo(Boolean.valueOf(ilVar.m505a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m505a() || (a13 = ir.a(this.f762a, ilVar.f762a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a12 = ir.a(this.f761a, ilVar.f761a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a11 = ir.a(this.f765b, ilVar.f765b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a10 = ir.a(this.f766c, ilVar.f766c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a9 = ir.a(this.f767d, ilVar.f767d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a8 = ir.a(this.f768e, ilVar.f768e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a7 = ir.a(this.f769f, ilVar.f769f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ilVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a6 = ir.a(this.f770g, ilVar.f770g)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ilVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a5 = ir.a(this.f771h, ilVar.f771h)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ilVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a4 = ir.a(this.f772i, ilVar.f772i)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ilVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a3 = ir.a(this.f764a, ilVar.f764a)) == 0) {
                                                            int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ilVar.l()));
                                                            if (compareTo12 != 0) {
                                                                return compareTo12;
                                                            }
                                                            if (!l() || (a2 = ir.a(this.f760a, ilVar.f760a)) == 0) {
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
            this.f765b = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f765b == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f766c != null) {
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
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f77856a;
            if (b2 == 0) {
                jbVar.f();
                a();
                return;
            }
            switch (m523a.f814a) {
                case 1:
                    if (b2 == 11) {
                        this.f762a = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f761a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f765b = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f766c = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f767d = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f768e = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f769f = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f770g = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f771h = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f772i = jbVar.m528a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f764a = jbVar.m532a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f760a = jbVar.m522a();
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
            this.f763a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m505a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f762a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m506a(il ilVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ilVar)) == null) {
            if (ilVar == null) {
                return false;
            }
            boolean m505a = m505a();
            boolean m505a2 = ilVar.m505a();
            if ((m505a || m505a2) && !(m505a && m505a2 && this.f762a.equals(ilVar.f762a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = ilVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f761a.m422a(ilVar.f761a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = ilVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f765b.equals(ilVar.f765b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = ilVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f766c.equals(ilVar.f766c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = ilVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f767d.equals(ilVar.f767d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = ilVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f768e.equals(ilVar.f768e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = ilVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f769f.equals(ilVar.f769f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = ilVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f770g.equals(ilVar.f770g))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = ilVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f771h.equals(ilVar.f771h))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = ilVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f772i.equals(ilVar.f772i))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = ilVar.k();
            if ((k2 || k3) && !(k2 && k3 && this.f764a == ilVar.f764a)) {
                return false;
            }
            boolean l2 = l();
            boolean l3 = ilVar.l();
            if (l2 || l3) {
                return l2 && l3 && this.f760a == ilVar.f760a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public il b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.f766c = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            a();
            jbVar.a(f759a);
            if (this.f762a != null && m505a()) {
                jbVar.a(f77807a);
                jbVar.a(this.f762a);
                jbVar.b();
            }
            if (this.f761a != null && b()) {
                jbVar.a(f77808b);
                this.f761a.b(jbVar);
                jbVar.b();
            }
            if (this.f765b != null) {
                jbVar.a(f77809c);
                jbVar.a(this.f765b);
                jbVar.b();
            }
            if (this.f766c != null) {
                jbVar.a(f77810d);
                jbVar.a(this.f766c);
                jbVar.b();
            }
            if (this.f767d != null && e()) {
                jbVar.a(f77811e);
                jbVar.a(this.f767d);
                jbVar.b();
            }
            if (this.f768e != null && f()) {
                jbVar.a(f77812f);
                jbVar.a(this.f768e);
                jbVar.b();
            }
            if (this.f769f != null && g()) {
                jbVar.a(f77813g);
                jbVar.a(this.f769f);
                jbVar.b();
            }
            if (this.f770g != null && h()) {
                jbVar.a(f77814h);
                jbVar.a(this.f770g);
                jbVar.b();
            }
            if (this.f771h != null && i()) {
                jbVar.a(f77815i);
                jbVar.a(this.f771h);
                jbVar.b();
            }
            if (this.f772i != null && j()) {
                jbVar.a(f77816j);
                jbVar.a(this.f772i);
                jbVar.b();
            }
            if (k()) {
                jbVar.a(k);
                jbVar.a(this.f764a);
                jbVar.b();
            }
            if (l()) {
                jbVar.a(l);
                jbVar.a(this.f760a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f763a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f761a != null : invokeV.booleanValue;
    }

    public il c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.f767d = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f765b != null : invokeV.booleanValue;
    }

    public il d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f769f = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f766c != null : invokeV.booleanValue;
    }

    public il e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            this.f770g = str;
            return this;
        }
        return (il) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f767d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj != null && (obj instanceof il)) {
                return m506a((il) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f768e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f769f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f770g != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f771h != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f772i != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f763a.get(0) : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f763a.get(1) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
            boolean z2 = false;
            if (m505a()) {
                sb.append("debug:");
                String str = this.f762a;
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
                hu huVar = this.f761a;
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
            String str2 = this.f765b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f766c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("regId:");
                String str4 = this.f767d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appVersion:");
                String str5 = this.f768e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f769f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("token:");
                String str7 = this.f770g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("deviceId:");
                String str8 = this.f771h;
                if (str8 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str8);
                }
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliasName:");
                String str9 = this.f772i;
                if (str9 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str9);
                }
            }
            if (k()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("needAck:");
                sb.append(this.f764a);
            }
            if (l()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f760a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
