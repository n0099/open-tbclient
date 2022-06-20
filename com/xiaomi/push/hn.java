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
    public static final jk f468a;
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
    public long f469a;

    /* renamed from: a  reason: collision with other field name */
    public String f470a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f471a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f472a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f473a;

    /* renamed from: b  reason: collision with other field name */
    public long f474b;

    /* renamed from: b  reason: collision with other field name */
    public String f475b;

    /* renamed from: c  reason: collision with other field name */
    public String f476c;

    /* renamed from: d  reason: collision with other field name */
    public String f477d;

    /* renamed from: e  reason: collision with other field name */
    public String f478e;

    /* renamed from: f  reason: collision with other field name */
    public String f479f;

    /* renamed from: g  reason: collision with other field name */
    public String f480g;

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
        f468a = new jk("ClientUploadDataItem");
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
        this.f471a = new BitSet(3);
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
                int compareTo = Boolean.valueOf(m398a()).compareTo(Boolean.valueOf(hnVar.m398a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m398a() || (a12 = iv.a(this.f470a, hnVar.f470a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m400b()).compareTo(Boolean.valueOf(hnVar.m400b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m400b() || (a11 = iv.a(this.f475b, hnVar.f475b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m401c()).compareTo(Boolean.valueOf(hnVar.m401c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m401c() || (a10 = iv.a(this.f476c, hnVar.f476c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m402d()).compareTo(Boolean.valueOf(hnVar.m402d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m402d() || (a9 = iv.a(this.f469a, hnVar.f469a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m403e()).compareTo(Boolean.valueOf(hnVar.m403e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m403e() || (a8 = iv.a(this.f474b, hnVar.f474b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = iv.a(this.f473a, hnVar.f473a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = iv.a(this.f477d, hnVar.f477d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = iv.a(this.f478e, hnVar.f478e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = iv.a(this.f479f, hnVar.f479f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hnVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = iv.a(this.f472a, hnVar.f472a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hnVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = iv.a(this.f480g, hnVar.f480g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f474b : invokeV.longValue;
    }

    public hn a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f469a = j2;
            m397a(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f470a = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f472a = map;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public hn a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f473a = z;
            c(true);
            return this;
        }
        return (hn) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m394a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f470a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m395a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f472a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m396a() {
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
        jfVar.m544a();
        while (true) {
            jc m540a = jfVar.m540a();
            byte b2 = m540a.a;
            if (b2 == 0) {
                jfVar.f();
                m396a();
                return;
            }
            switch (m540a.f802a) {
                case 1:
                    if (b2 == 11) {
                        this.f470a = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f475b = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f476c = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f469a = jfVar.m539a();
                        m397a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f474b = jfVar.m539a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f473a = jfVar.m549a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f477d = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f478e = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f479f = jfVar.m545a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je m542a = jfVar.m542a();
                        this.f472a = new HashMap(m542a.f804a * 2);
                        for (int i2 = 0; i2 < m542a.f804a; i2++) {
                            this.f472a.put(jfVar.m545a(), jfVar.m545a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f480g = jfVar.m545a();
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
            if (this.f472a == null) {
                this.f472a = new HashMap();
            }
            this.f472a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m397a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f471a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m398a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f470a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m399a(hn hnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hnVar)) == null) {
            if (hnVar == null) {
                return false;
            }
            boolean m398a = m398a();
            boolean m398a2 = hnVar.m398a();
            if ((m398a || m398a2) && !(m398a && m398a2 && this.f470a.equals(hnVar.f470a))) {
                return false;
            }
            boolean m400b = m400b();
            boolean m400b2 = hnVar.m400b();
            if ((m400b || m400b2) && !(m400b && m400b2 && this.f475b.equals(hnVar.f475b))) {
                return false;
            }
            boolean m401c = m401c();
            boolean m401c2 = hnVar.m401c();
            if ((m401c || m401c2) && !(m401c && m401c2 && this.f476c.equals(hnVar.f476c))) {
                return false;
            }
            boolean m402d = m402d();
            boolean m402d2 = hnVar.m402d();
            if ((m402d || m402d2) && !(m402d && m402d2 && this.f469a == hnVar.f469a)) {
                return false;
            }
            boolean m403e = m403e();
            boolean m403e2 = hnVar.m403e();
            if ((m403e || m403e2) && !(m403e && m403e2 && this.f474b == hnVar.f474b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hnVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f473a == hnVar.f473a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hnVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f477d.equals(hnVar.f477d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hnVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f478e.equals(hnVar.f478e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hnVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f479f.equals(hnVar.f479f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hnVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f472a.equals(hnVar.f472a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hnVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f480g.equals(hnVar.f480g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hn b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f474b = j2;
            b(true);
            return this;
        }
        return (hn) invokeJ.objValue;
    }

    public hn b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f475b = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f476c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jfVar) == null) {
            m396a();
            jfVar.a(f468a);
            if (this.f470a != null && m398a()) {
                jfVar.a(a);
                jfVar.a(this.f470a);
                jfVar.b();
            }
            if (this.f475b != null && m400b()) {
                jfVar.a(b);
                jfVar.a(this.f475b);
                jfVar.b();
            }
            if (this.f476c != null && m401c()) {
                jfVar.a(c);
                jfVar.a(this.f476c);
                jfVar.b();
            }
            if (m402d()) {
                jfVar.a(d);
                jfVar.a(this.f469a);
                jfVar.b();
            }
            if (m403e()) {
                jfVar.a(e);
                jfVar.a(this.f474b);
                jfVar.b();
            }
            if (f()) {
                jfVar.a(f);
                jfVar.a(this.f473a);
                jfVar.b();
            }
            if (this.f477d != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f477d);
                jfVar.b();
            }
            if (this.f478e != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f478e);
                jfVar.b();
            }
            if (this.f479f != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f479f);
                jfVar.b();
            }
            if (this.f472a != null && j()) {
                jfVar.a(j);
                jfVar.a(new je(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f472a.size()));
                for (Map.Entry<String, String> entry : this.f472a.entrySet()) {
                    jfVar.a(entry.getKey());
                    jfVar.a(entry.getValue());
                }
                jfVar.d();
                jfVar.b();
            }
            if (this.f480g != null && k()) {
                jfVar.a(k);
                jfVar.a(this.f480g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f471a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m400b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f475b != null : invokeV.booleanValue;
    }

    public hn c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f476c = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f478e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f471a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m401c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f476c != null : invokeV.booleanValue;
    }

    public hn d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f477d = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f479f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m402d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f471a.get(0) : invokeV.booleanValue;
    }

    public hn e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f478e = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f480g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m403e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f471a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hn)) {
                return m399a((hn) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hn f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f479f = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f471a.get(2) : invokeV.booleanValue;
    }

    public hn g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f480g = str;
            return this;
        }
        return (hn) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f477d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f478e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f479f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f472a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f480g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m398a()) {
                sb.append("channel:");
                String str = this.f470a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m400b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f475b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m401c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f476c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m402d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f469a);
                z = false;
            }
            if (m403e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f474b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f473a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f477d;
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
                String str5 = this.f478e;
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
                String str6 = this.f479f;
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
                Map<String, String> map = this.f472a;
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
                String str7 = this.f480g;
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
