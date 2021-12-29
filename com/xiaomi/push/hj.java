package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class hj implements iq<hj, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f484a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f63565b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f63566c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f63567d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f63568e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f63569f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f63570g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f63571h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f63572i;

    /* renamed from: j  reason: collision with root package name */
    public static final iy f63573j;

    /* renamed from: k  reason: collision with root package name */
    public static final iy f63574k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f485a;

    /* renamed from: a  reason: collision with other field name */
    public String f486a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f487a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f488a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f489a;

    /* renamed from: b  reason: collision with other field name */
    public long f490b;

    /* renamed from: b  reason: collision with other field name */
    public String f491b;

    /* renamed from: c  reason: collision with other field name */
    public String f492c;

    /* renamed from: d  reason: collision with other field name */
    public String f493d;

    /* renamed from: e  reason: collision with other field name */
    public String f494e;

    /* renamed from: f  reason: collision with other field name */
    public String f495f;

    /* renamed from: g  reason: collision with other field name */
    public String f496g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372866, "Lcom/xiaomi/push/hj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372866, "Lcom/xiaomi/push/hj;");
                return;
            }
        }
        f484a = new jg("ClientUploadDataItem");
        a = new iy("", (byte) 11, (short) 1);
        f63565b = new iy("", (byte) 11, (short) 2);
        f63566c = new iy("", (byte) 11, (short) 3);
        f63567d = new iy("", (byte) 10, (short) 4);
        f63568e = new iy("", (byte) 10, (short) 5);
        f63569f = new iy("", (byte) 2, (short) 6);
        f63570g = new iy("", (byte) 11, (short) 7);
        f63571h = new iy("", (byte) 11, (short) 8);
        f63572i = new iy("", (byte) 11, (short) 9);
        f63573j = new iy("", (byte) 13, (short) 10);
        f63574k = new iy("", (byte) 11, (short) 11);
    }

    public hj() {
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
        this.f487a = new BitSet(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hj hjVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hjVar)) == null) {
            if (hj.class.equals(hjVar.getClass())) {
                int compareTo = Boolean.valueOf(m431a()).compareTo(Boolean.valueOf(hjVar.m431a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m431a() || (a12 = ir.a(this.f486a, hjVar.f486a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m433b()).compareTo(Boolean.valueOf(hjVar.m433b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m433b() || (a11 = ir.a(this.f491b, hjVar.f491b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m434c()).compareTo(Boolean.valueOf(hjVar.m434c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m434c() || (a10 = ir.a(this.f492c, hjVar.f492c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m435d()).compareTo(Boolean.valueOf(hjVar.m435d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m435d() || (a9 = ir.a(this.f485a, hjVar.f485a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m436e()).compareTo(Boolean.valueOf(hjVar.m436e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m436e() || (a8 = ir.a(this.f490b, hjVar.f490b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = ir.a(this.f489a, hjVar.f489a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = ir.a(this.f493d, hjVar.f493d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = ir.a(this.f494e, hjVar.f494e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = ir.a(this.f495f, hjVar.f495f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = ir.a(this.f488a, hjVar.f488a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = ir.a(this.f496g, hjVar.f496g)) == 0) {
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
            return hj.class.getName().compareTo(hjVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f490b : invokeV.longValue;
    }

    public hj a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f485a = j2;
            m430a(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f486a = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f488a = map;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f489a = z;
            c(true);
            return this;
        }
        return (hj) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m427a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f486a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m428a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f488a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m429a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, jbVar) != null) {
            return;
        }
        jbVar.m576a();
        while (true) {
            iy m572a = jbVar.m572a();
            byte b2 = m572a.a;
            if (b2 == 0) {
                jbVar.f();
                m429a();
                return;
            }
            switch (m572a.f815a) {
                case 1:
                    if (b2 == 11) {
                        this.f486a = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f491b = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f492c = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f485a = jbVar.m571a();
                        m430a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f490b = jbVar.m571a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f489a = jbVar.m581a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f493d = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f494e = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f495f = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m574a = jbVar.m574a();
                        this.f488a = new HashMap(m574a.f819a * 2);
                        for (int i2 = 0; i2 < m574a.f819a; i2++) {
                            this.f488a.put(jbVar.m577a(), jbVar.m577a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f496g = jbVar.m577a();
                        continue;
                        jbVar.g();
                    }
                    break;
            }
            je.a(jbVar, b2);
            jbVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.f488a == null) {
                this.f488a = new HashMap();
            }
            this.f488a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m430a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f487a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f486a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m432a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hjVar)) == null) {
            if (hjVar == null) {
                return false;
            }
            boolean m431a = m431a();
            boolean m431a2 = hjVar.m431a();
            if ((m431a || m431a2) && !(m431a && m431a2 && this.f486a.equals(hjVar.f486a))) {
                return false;
            }
            boolean m433b = m433b();
            boolean m433b2 = hjVar.m433b();
            if ((m433b || m433b2) && !(m433b && m433b2 && this.f491b.equals(hjVar.f491b))) {
                return false;
            }
            boolean m434c = m434c();
            boolean m434c2 = hjVar.m434c();
            if ((m434c || m434c2) && !(m434c && m434c2 && this.f492c.equals(hjVar.f492c))) {
                return false;
            }
            boolean m435d = m435d();
            boolean m435d2 = hjVar.m435d();
            if ((m435d || m435d2) && !(m435d && m435d2 && this.f485a == hjVar.f485a)) {
                return false;
            }
            boolean m436e = m436e();
            boolean m436e2 = hjVar.m436e();
            if ((m436e || m436e2) && !(m436e && m436e2 && this.f490b == hjVar.f490b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hjVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f489a == hjVar.f489a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hjVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f493d.equals(hjVar.f493d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hjVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f494e.equals(hjVar.f494e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hjVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f495f.equals(hjVar.f495f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hjVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f488a.equals(hjVar.f488a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hjVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f496g.equals(hjVar.f496g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hj b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f490b = j2;
            b(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f491b = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f492c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jbVar) == null) {
            m429a();
            jbVar.a(f484a);
            if (this.f486a != null && m431a()) {
                jbVar.a(a);
                jbVar.a(this.f486a);
                jbVar.b();
            }
            if (this.f491b != null && m433b()) {
                jbVar.a(f63565b);
                jbVar.a(this.f491b);
                jbVar.b();
            }
            if (this.f492c != null && m434c()) {
                jbVar.a(f63566c);
                jbVar.a(this.f492c);
                jbVar.b();
            }
            if (m435d()) {
                jbVar.a(f63567d);
                jbVar.a(this.f485a);
                jbVar.b();
            }
            if (m436e()) {
                jbVar.a(f63568e);
                jbVar.a(this.f490b);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f63569f);
                jbVar.a(this.f489a);
                jbVar.b();
            }
            if (this.f493d != null && g()) {
                jbVar.a(f63570g);
                jbVar.a(this.f493d);
                jbVar.b();
            }
            if (this.f494e != null && h()) {
                jbVar.a(f63571h);
                jbVar.a(this.f494e);
                jbVar.b();
            }
            if (this.f495f != null && i()) {
                jbVar.a(f63572i);
                jbVar.a(this.f495f);
                jbVar.b();
            }
            if (this.f488a != null && j()) {
                jbVar.a(f63573j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f488a.size()));
                for (Map.Entry<String, String> entry : this.f488a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f496g != null && k()) {
                jbVar.a(f63574k);
                jbVar.a(this.f496g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m580a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f487a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m433b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f491b != null : invokeV.booleanValue;
    }

    public hj c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f492c = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f494e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f487a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m434c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f492c != null : invokeV.booleanValue;
    }

    public hj d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f493d = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f495f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m435d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f487a.get(0) : invokeV.booleanValue;
    }

    public hj e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f494e = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f496g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m436e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f487a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hj)) {
                return m432a((hj) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hj f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f495f = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f487a.get(2) : invokeV.booleanValue;
    }

    public hj g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f496g = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f493d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f494e != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f495f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f488a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f496g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m431a()) {
                sb.append("channel:");
                String str = this.f486a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m433b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f491b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m434c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f492c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m435d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f485a);
                z = false;
            }
            if (m436e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f490b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f489a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f493d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
                z = false;
            }
            if (h()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("sourcePackage:");
                String str5 = this.f494e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
                z = false;
            }
            if (i()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("id:");
                String str6 = this.f495f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
                z = false;
            }
            if (j()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("extra:");
                Map<String, String> map = this.f488a;
                if (map == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(map);
                }
            } else {
                z2 = z;
            }
            if (k()) {
                if (!z2) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("pkgName:");
                String str7 = this.f496g;
                if (str7 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str7);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
