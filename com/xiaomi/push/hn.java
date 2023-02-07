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
/* loaded from: classes8.dex */
public class hn implements iu<hn, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f499a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public static final jc k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f500a;

    /* renamed from: a  reason: collision with other field name */
    public String f501a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f502a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f503a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f504a;

    /* renamed from: b  reason: collision with other field name */
    public long f505b;

    /* renamed from: b  reason: collision with other field name */
    public String f506b;

    /* renamed from: c  reason: collision with other field name */
    public String f507c;

    /* renamed from: d  reason: collision with other field name */
    public String f508d;

    /* renamed from: e  reason: collision with other field name */
    public String f509e;

    /* renamed from: f  reason: collision with other field name */
    public String f510f;

    /* renamed from: g  reason: collision with other field name */
    public String f511g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372742, "Lcom/xiaomi/push/hn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372742, "Lcom/xiaomi/push/hn;");
                return;
            }
        }
        f499a = new jk("ClientUploadDataItem");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", (byte) 10, (short) 4);
        e = new jc("", (byte) 10, (short) 5);
        f = new jc("", (byte) 2, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new jc("", (byte) 13, (short) 10);
        k = new jc("", Constants.GZIP_CAST_TYPE, (short) 11);
    }

    public hn() {
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
        this.f502a = new BitSet(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hn hnVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hnVar)) == null) {
            if (hn.class.equals(hnVar.getClass())) {
                int compareTo = Boolean.valueOf(m478a()).compareTo(Boolean.valueOf(hnVar.m478a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m478a() || (a12 = iv.a(this.f501a, hnVar.f501a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m480b()).compareTo(Boolean.valueOf(hnVar.m480b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m480b() || (a11 = iv.a(this.f506b, hnVar.f506b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m481c()).compareTo(Boolean.valueOf(hnVar.m481c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m481c() || (a10 = iv.a(this.f507c, hnVar.f507c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m482d()).compareTo(Boolean.valueOf(hnVar.m482d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m482d() || (a9 = iv.a(this.f500a, hnVar.f500a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m483e()).compareTo(Boolean.valueOf(hnVar.m483e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m483e() || (a8 = iv.a(this.f505b, hnVar.f505b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = iv.a(this.f504a, hnVar.f504a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = iv.a(this.f508d, hnVar.f508d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = iv.a(this.f509e, hnVar.f509e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = iv.a(this.f510f, hnVar.f510f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hnVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = iv.a(this.f503a, hnVar.f503a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hnVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = iv.a(this.f511g, hnVar.f511g)) == 0) {
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
            return hn.class.getName().compareTo(hnVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f505b : invokeV.longValue;
    }

    public hn a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f500a = j2;
            m477a(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f501a = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f503a = map;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f504a = z;
            c(true);
            return this;
        }
        return (hn) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m474a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f501a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m475a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f503a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m476a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, jfVar) != null) {
            return;
        }
        jfVar.mo624a();
        while (true) {
            jc mo620a = jfVar.mo620a();
            byte b2 = mo620a.a;
            if (b2 == 0) {
                jfVar.f();
                m476a();
                return;
            }
            switch (mo620a.f833a) {
                case 1:
                    if (b2 == 11) {
                        this.f501a = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f506b = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f507c = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f500a = jfVar.mo619a();
                        m477a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f505b = jfVar.mo619a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f504a = jfVar.mo630a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f508d = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f509e = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f510f = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je mo622a = jfVar.mo622a();
                        this.f503a = new HashMap(mo622a.f835a * 2);
                        for (int i2 = 0; i2 < mo622a.f835a; i2++) {
                            this.f503a.put(jfVar.mo625a(), jfVar.mo625a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f511g = jfVar.mo625a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            if (this.f503a == null) {
                this.f503a = new HashMap();
            }
            this.f503a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m477a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f502a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m478a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f501a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m479a(hn hnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hnVar)) == null) {
            if (hnVar == null) {
                return false;
            }
            boolean m478a = m478a();
            boolean m478a2 = hnVar.m478a();
            if ((m478a || m478a2) && !(m478a && m478a2 && this.f501a.equals(hnVar.f501a))) {
                return false;
            }
            boolean m480b = m480b();
            boolean m480b2 = hnVar.m480b();
            if ((m480b || m480b2) && !(m480b && m480b2 && this.f506b.equals(hnVar.f506b))) {
                return false;
            }
            boolean m481c = m481c();
            boolean m481c2 = hnVar.m481c();
            if ((m481c || m481c2) && !(m481c && m481c2 && this.f507c.equals(hnVar.f507c))) {
                return false;
            }
            boolean m482d = m482d();
            boolean m482d2 = hnVar.m482d();
            if ((m482d || m482d2) && !(m482d && m482d2 && this.f500a == hnVar.f500a)) {
                return false;
            }
            boolean m483e = m483e();
            boolean m483e2 = hnVar.m483e();
            if ((m483e || m483e2) && !(m483e && m483e2 && this.f505b == hnVar.f505b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hnVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f504a == hnVar.f504a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hnVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f508d.equals(hnVar.f508d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hnVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f509e.equals(hnVar.f509e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hnVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f510f.equals(hnVar.f510f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hnVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f503a.equals(hnVar.f503a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hnVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f511g.equals(hnVar.f511g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hn b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f505b = j2;
            b(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f506b = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f507c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jfVar) == null) {
            m476a();
            jfVar.a(f499a);
            if (this.f501a != null && m478a()) {
                jfVar.a(a);
                jfVar.a(this.f501a);
                jfVar.b();
            }
            if (this.f506b != null && m480b()) {
                jfVar.a(b);
                jfVar.a(this.f506b);
                jfVar.b();
            }
            if (this.f507c != null && m481c()) {
                jfVar.a(c);
                jfVar.a(this.f507c);
                jfVar.b();
            }
            if (m482d()) {
                jfVar.a(d);
                jfVar.a(this.f500a);
                jfVar.b();
            }
            if (m483e()) {
                jfVar.a(e);
                jfVar.a(this.f505b);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f504a);
                jfVar.b();
            }
            if (this.f508d != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f508d);
                jfVar.b();
            }
            if (this.f509e != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f509e);
                jfVar.b();
            }
            if (this.f510f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f510f);
                jfVar.b();
            }
            if (this.f503a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f503a.size()));
                for (Map.Entry<String, String> entry : this.f503a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f511g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f511g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.mo628a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f502a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m480b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f506b != null : invokeV.booleanValue;
    }

    public hn c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f507c = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f509e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f502a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m481c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f507c != null : invokeV.booleanValue;
    }

    public hn d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f508d = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f510f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m482d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f502a.get(0) : invokeV.booleanValue;
    }

    public hn e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f509e = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f511g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m483e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f502a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hn)) {
                return m479a((hn) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hn f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f510f = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f502a.get(2) : invokeV.booleanValue;
    }

    public hn g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f511g = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f508d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f509e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f510f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f503a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f511g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m478a()) {
                sb.append("channel:");
                String str = this.f501a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m480b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f506b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m481c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f507c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m482d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f500a);
                z = false;
            }
            if (m483e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f505b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f504a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f508d;
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
                String str5 = this.f509e;
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
                String str6 = this.f510f;
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
                Map<String, String> map = this.f503a;
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
                String str7 = this.f511g;
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
