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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes6.dex */
public class hz implements iq<hz, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40637a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f604a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40638b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40639c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40640d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40641e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40642f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40643g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40644h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f40645i;
    public static final iy j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f605a;

    /* renamed from: a  reason: collision with other field name */
    public hu f606a;

    /* renamed from: a  reason: collision with other field name */
    public String f607a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f608a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f609a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f610a;

    /* renamed from: b  reason: collision with other field name */
    public String f611b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f612b;

    /* renamed from: c  reason: collision with other field name */
    public String f613c;

    /* renamed from: d  reason: collision with other field name */
    public String f614d;

    /* renamed from: e  reason: collision with other field name */
    public String f615e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372370, "Lcom/xiaomi/push/hz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372370, "Lcom/xiaomi/push/hz;");
                return;
            }
        }
        f604a = new jg("XmPushActionCommand");
        f40637a = new iy("", StandardMessageCodec.LIST, (short) 2);
        f40638b = new iy("", (byte) 11, (short) 3);
        f40639c = new iy("", (byte) 11, (short) 4);
        f40640d = new iy("", (byte) 11, (short) 5);
        f40641e = new iy("", (byte) 15, (short) 6);
        f40642f = new iy("", (byte) 11, (short) 7);
        f40643g = new iy("", (byte) 11, (short) 9);
        f40644h = new iy("", (byte) 2, (short) 10);
        f40645i = new iy("", (byte) 2, (short) 11);
        j = new iy("", (byte) 10, (short) 12);
    }

    public hz() {
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
        this.f608a = new BitSet(3);
        this.f610a = false;
        this.f612b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hzVar)) == null) {
            if (hz.class.equals(hzVar.getClass())) {
                int compareTo = Boolean.valueOf(m433a()).compareTo(Boolean.valueOf(hzVar.m433a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m433a() || (a11 = ir.a(this.f606a, hzVar.f606a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = ir.a(this.f607a, hzVar.f607a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = ir.a(this.f611b, hzVar.f611b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hzVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = ir.a(this.f613c, hzVar.f613c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = ir.a(this.f609a, hzVar.f609a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = ir.a(this.f614d, hzVar.f614d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = ir.a(this.f615e, hzVar.f615e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = ir.a(this.f610a, hzVar.f610a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = ir.a(this.f612b, hzVar.f612b)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = ir.a(this.f605a, hzVar.f605a)) == 0) {
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
            return hz.class.getName().compareTo(hzVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hz a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f607a = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public hz a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            this.f609a = list;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f613c : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m431a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f607a == null) {
                throw new jc("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f611b == null) {
                throw new jc("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f613c != null) {
            } else {
                throw new jc("Required field 'cmdName' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048581, this, jbVar) != null) {
            return;
        }
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40780a;
            if (b2 == 0) {
                jbVar.f();
                m431a();
                return;
            }
            switch (m520a.f810a) {
                case 2:
                    if (b2 == 12) {
                        hu huVar = new hu();
                        this.f606a = huVar;
                        huVar.a(jbVar);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f607a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f611b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f613c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        iz m521a = jbVar.m521a();
                        this.f609a = new ArrayList(m521a.f811a);
                        for (int i2 = 0; i2 < m521a.f811a; i2++) {
                            this.f609a.add(jbVar.m525a());
                        }
                        jbVar.i();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f614d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f615e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f610a = jbVar.m529a();
                        a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f612b = jbVar.m529a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f605a = jbVar.m519a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m432a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (this.f609a == null) {
                this.f609a = new ArrayList();
            }
            this.f609a.add(str);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f608a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m433a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f606a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m434a(hz hzVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hzVar)) == null) {
            if (hzVar == null) {
                return false;
            }
            boolean m433a = m433a();
            boolean m433a2 = hzVar.m433a();
            if ((m433a || m433a2) && !(m433a && m433a2 && this.f606a.m419a(hzVar.f606a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = hzVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f607a.equals(hzVar.f607a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hzVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f611b.equals(hzVar.f611b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hzVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f613c.equals(hzVar.f613c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hzVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f609a.equals(hzVar.f609a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hzVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f614d.equals(hzVar.f614d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hzVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f615e.equals(hzVar.f615e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hzVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f610a == hzVar.f610a)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hzVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f612b == hzVar.f612b)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hzVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f605a == hzVar.f605a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hz b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.f611b = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, jbVar) == null) {
            m431a();
            jbVar.a(f604a);
            if (this.f606a != null && m433a()) {
                jbVar.a(f40637a);
                this.f606a.b(jbVar);
                jbVar.b();
            }
            if (this.f607a != null) {
                jbVar.a(f40638b);
                jbVar.a(this.f607a);
                jbVar.b();
            }
            if (this.f611b != null) {
                jbVar.a(f40639c);
                jbVar.a(this.f611b);
                jbVar.b();
            }
            if (this.f613c != null) {
                jbVar.a(f40640d);
                jbVar.a(this.f613c);
                jbVar.b();
            }
            if (this.f609a != null && e()) {
                jbVar.a(f40641e);
                jbVar.a(new iz((byte) 11, this.f609a.size()));
                for (String str : this.f609a) {
                    jbVar.a(str);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f614d != null && f()) {
                jbVar.a(f40642f);
                jbVar.a(this.f614d);
                jbVar.b();
            }
            if (this.f615e != null && g()) {
                jbVar.a(f40643g);
                jbVar.a(this.f615e);
                jbVar.b();
            }
            if (h()) {
                jbVar.a(f40644h);
                jbVar.a(this.f610a);
                jbVar.b();
            }
            if (i()) {
                jbVar.a(f40645i);
                jbVar.a(this.f612b);
                jbVar.b();
            }
            if (j()) {
                jbVar.a(j);
                jbVar.a(this.f605a);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f608a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f607a != null : invokeV.booleanValue;
    }

    public hz c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f613c = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f608a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f611b != null : invokeV.booleanValue;
    }

    public hz d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            this.f614d = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f613c != null : invokeV.booleanValue;
    }

    public hz e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f615e = str;
            return this;
        }
        return (hz) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f609a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            if (obj != null && (obj instanceof hz)) {
                return m434a((hz) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f614d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f615e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f608a.get(0) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f608a.get(1) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f608a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommand(");
            if (m433a()) {
                sb.append("target:");
                hu huVar = this.f606a;
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
            String str = this.f607a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f611b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f613c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f609a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f614d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f615e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("updateCache:");
                sb.append(this.f610a);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f612b);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f605a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
