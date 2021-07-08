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
/* loaded from: classes6.dex */
public class hj implements iq<hj, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40271a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f479a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40272b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40273c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40274d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40275e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40276f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f40277g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f40278h;

    /* renamed from: i  reason: collision with root package name */
    public static final iy f40279i;
    public static final iy j;
    public static final iy k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f480a;

    /* renamed from: a  reason: collision with other field name */
    public String f481a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f482a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f483a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f484a;

    /* renamed from: b  reason: collision with other field name */
    public long f485b;

    /* renamed from: b  reason: collision with other field name */
    public String f486b;

    /* renamed from: c  reason: collision with other field name */
    public String f487c;

    /* renamed from: d  reason: collision with other field name */
    public String f488d;

    /* renamed from: e  reason: collision with other field name */
    public String f489e;

    /* renamed from: f  reason: collision with other field name */
    public String f490f;

    /* renamed from: g  reason: collision with other field name */
    public String f491g;

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
        f479a = new jg("ClientUploadDataItem");
        f40271a = new iy("", (byte) 11, (short) 1);
        f40272b = new iy("", (byte) 11, (short) 2);
        f40273c = new iy("", (byte) 11, (short) 3);
        f40274d = new iy("", (byte) 10, (short) 4);
        f40275e = new iy("", (byte) 10, (short) 5);
        f40276f = new iy("", (byte) 2, (short) 6);
        f40277g = new iy("", (byte) 11, (short) 7);
        f40278h = new iy("", (byte) 11, (short) 8);
        f40279i = new iy("", (byte) 11, (short) 9);
        j = new iy("", (byte) 13, (short) 10);
        k = new iy("", (byte) 11, (short) 11);
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
        this.f482a = new BitSet(3);
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
                int compareTo = Boolean.valueOf(m379a()).compareTo(Boolean.valueOf(hjVar.m379a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m379a() || (a12 = ir.a(this.f481a, hjVar.f481a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m381b()).compareTo(Boolean.valueOf(hjVar.m381b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m381b() || (a11 = ir.a(this.f486b, hjVar.f486b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m382c()).compareTo(Boolean.valueOf(hjVar.m382c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m382c() || (a10 = ir.a(this.f487c, hjVar.f487c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m383d()).compareTo(Boolean.valueOf(hjVar.m383d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m383d() || (a9 = ir.a(this.f480a, hjVar.f480a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m384e()).compareTo(Boolean.valueOf(hjVar.m384e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m384e() || (a8 = ir.a(this.f485b, hjVar.f485b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = ir.a(this.f484a, hjVar.f484a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = ir.a(this.f488d, hjVar.f488d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = ir.a(this.f489e, hjVar.f489e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = ir.a(this.f490f, hjVar.f490f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = ir.a(this.f483a, hjVar.f483a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = ir.a(this.f491g, hjVar.f491g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f485b : invokeV.longValue;
    }

    public hj a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f480a = j2;
            m378a(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f481a = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f483a = map;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f484a = z;
            c(true);
            return this;
        }
        return (hj) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m375a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f481a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m376a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f483a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m377a() {
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
        jbVar.m524a();
        while (true) {
            iy m520a = jbVar.m520a();
            byte b2 = m520a.f40508a;
            if (b2 == 0) {
                jbVar.f();
                m377a();
                return;
            }
            switch (m520a.f810a) {
                case 1:
                    if (b2 == 11) {
                        this.f481a = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f486b = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f487c = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f480a = jbVar.m519a();
                        m378a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f485b = jbVar.m519a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f484a = jbVar.m529a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f488d = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f489e = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f490f = jbVar.m525a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m522a = jbVar.m522a();
                        this.f483a = new HashMap(m522a.f814a * 2);
                        for (int i2 = 0; i2 < m522a.f814a; i2++) {
                            this.f483a.put(jbVar.m525a(), jbVar.m525a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f491g = jbVar.m525a();
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
            if (this.f483a == null) {
                this.f483a = new HashMap();
            }
            this.f483a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m378a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f482a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m379a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f481a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m380a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hjVar)) == null) {
            if (hjVar == null) {
                return false;
            }
            boolean m379a = m379a();
            boolean m379a2 = hjVar.m379a();
            if ((m379a || m379a2) && !(m379a && m379a2 && this.f481a.equals(hjVar.f481a))) {
                return false;
            }
            boolean m381b = m381b();
            boolean m381b2 = hjVar.m381b();
            if ((m381b || m381b2) && !(m381b && m381b2 && this.f486b.equals(hjVar.f486b))) {
                return false;
            }
            boolean m382c = m382c();
            boolean m382c2 = hjVar.m382c();
            if ((m382c || m382c2) && !(m382c && m382c2 && this.f487c.equals(hjVar.f487c))) {
                return false;
            }
            boolean m383d = m383d();
            boolean m383d2 = hjVar.m383d();
            if ((m383d || m383d2) && !(m383d && m383d2 && this.f480a == hjVar.f480a)) {
                return false;
            }
            boolean m384e = m384e();
            boolean m384e2 = hjVar.m384e();
            if ((m384e || m384e2) && !(m384e && m384e2 && this.f485b == hjVar.f485b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hjVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f484a == hjVar.f484a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hjVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f488d.equals(hjVar.f488d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hjVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f489e.equals(hjVar.f489e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hjVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f490f.equals(hjVar.f490f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hjVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f483a.equals(hjVar.f483a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hjVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f491g.equals(hjVar.f491g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hj b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f485b = j2;
            b(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f486b = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f487c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jbVar) == null) {
            m377a();
            jbVar.a(f479a);
            if (this.f481a != null && m379a()) {
                jbVar.a(f40271a);
                jbVar.a(this.f481a);
                jbVar.b();
            }
            if (this.f486b != null && m381b()) {
                jbVar.a(f40272b);
                jbVar.a(this.f486b);
                jbVar.b();
            }
            if (this.f487c != null && m382c()) {
                jbVar.a(f40273c);
                jbVar.a(this.f487c);
                jbVar.b();
            }
            if (m383d()) {
                jbVar.a(f40274d);
                jbVar.a(this.f480a);
                jbVar.b();
            }
            if (m384e()) {
                jbVar.a(f40275e);
                jbVar.a(this.f485b);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f40276f);
                jbVar.a(this.f484a);
                jbVar.b();
            }
            if (this.f488d != null && g()) {
                jbVar.a(f40277g);
                jbVar.a(this.f488d);
                jbVar.b();
            }
            if (this.f489e != null && h()) {
                jbVar.a(f40278h);
                jbVar.a(this.f489e);
                jbVar.b();
            }
            if (this.f490f != null && i()) {
                jbVar.a(f40279i);
                jbVar.a(this.f490f);
                jbVar.b();
            }
            if (this.f483a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja((byte) 11, (byte) 11, this.f483a.size()));
                for (Map.Entry<String, String> entry : this.f483a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f491g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f491g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f482a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m381b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f486b != null : invokeV.booleanValue;
    }

    public hj c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f487c = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f489e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f482a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m382c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f487c != null : invokeV.booleanValue;
    }

    public hj d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f488d = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f490f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m383d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f482a.get(0) : invokeV.booleanValue;
    }

    public hj e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f489e = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f491g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m384e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f482a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hj)) {
                return m380a((hj) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hj f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f490f = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f482a.get(2) : invokeV.booleanValue;
    }

    public hj g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f491g = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f488d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f489e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f490f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f483a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f491g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m379a()) {
                sb.append("channel:");
                String str = this.f481a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m381b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f486b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m382c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f487c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m383d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f480a);
                z = false;
            }
            if (m384e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f485b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f484a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f488d;
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
                String str5 = this.f489e;
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
                String str6 = this.f490f;
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
                Map<String, String> map = this.f483a;
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
                String str7 = this.f491g;
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
