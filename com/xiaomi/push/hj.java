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
/* loaded from: classes7.dex */
public class hj implements iq<hj, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f460a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f44337b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f44338c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f44339d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f44340e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f44341f;

    /* renamed from: g  reason: collision with root package name */
    public static final iy f44342g;

    /* renamed from: h  reason: collision with root package name */
    public static final iy f44343h;
    public static final iy i;
    public static final iy j;
    public static final iy k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f461a;

    /* renamed from: a  reason: collision with other field name */
    public String f462a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f463a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f464a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f465a;

    /* renamed from: b  reason: collision with other field name */
    public long f466b;

    /* renamed from: b  reason: collision with other field name */
    public String f467b;

    /* renamed from: c  reason: collision with other field name */
    public String f468c;

    /* renamed from: d  reason: collision with other field name */
    public String f469d;

    /* renamed from: e  reason: collision with other field name */
    public String f470e;

    /* renamed from: f  reason: collision with other field name */
    public String f471f;

    /* renamed from: g  reason: collision with other field name */
    public String f472g;

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
        f460a = new jg("ClientUploadDataItem");
        a = new iy("", Constants.GZIP_CAST_TYPE, (short) 1);
        f44337b = new iy("", Constants.GZIP_CAST_TYPE, (short) 2);
        f44338c = new iy("", Constants.GZIP_CAST_TYPE, (short) 3);
        f44339d = new iy("", (byte) 10, (short) 4);
        f44340e = new iy("", (byte) 10, (short) 5);
        f44341f = new iy("", (byte) 2, (short) 6);
        f44342g = new iy("", Constants.GZIP_CAST_TYPE, (short) 7);
        f44343h = new iy("", Constants.GZIP_CAST_TYPE, (short) 8);
        i = new iy("", Constants.GZIP_CAST_TYPE, (short) 9);
        j = new iy("", (byte) 13, (short) 10);
        k = new iy("", Constants.GZIP_CAST_TYPE, (short) 11);
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
        this.f463a = new BitSet(3);
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
                int compareTo = Boolean.valueOf(m421a()).compareTo(Boolean.valueOf(hjVar.m421a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m421a() || (a12 = ir.a(this.f462a, hjVar.f462a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m423b()).compareTo(Boolean.valueOf(hjVar.m423b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m423b() || (a11 = ir.a(this.f467b, hjVar.f467b)) == 0) {
                        int compareTo3 = Boolean.valueOf(m424c()).compareTo(Boolean.valueOf(hjVar.m424c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m424c() || (a10 = ir.a(this.f468c, hjVar.f468c)) == 0) {
                            int compareTo4 = Boolean.valueOf(m425d()).compareTo(Boolean.valueOf(hjVar.m425d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!m425d() || (a9 = ir.a(this.f461a, hjVar.f461a)) == 0) {
                                int compareTo5 = Boolean.valueOf(m426e()).compareTo(Boolean.valueOf(hjVar.m426e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!m426e() || (a8 = ir.a(this.f466b, hjVar.f466b)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a7 = ir.a(this.f465a, hjVar.f465a)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a6 = ir.a(this.f469d, hjVar.f469d)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a5 = ir.a(this.f470e, hjVar.f470e)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a4 = ir.a(this.f471f, hjVar.f471f)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a3 = ir.a(this.f464a, hjVar.f464a)) == 0) {
                                                        int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
                                                        if (compareTo11 != 0) {
                                                            return compareTo11;
                                                        }
                                                        if (!k() || (a2 = ir.a(this.f472g, hjVar.f472g)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f466b : invokeV.longValue;
    }

    public hj a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            this.f461a = j2;
            m420a(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f462a = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f464a = map;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public hj a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f465a = z;
            c(true);
            return this;
        }
        return (hj) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m417a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f462a : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m418a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f464a : (Map) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m419a() {
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
        jbVar.m566a();
        while (true) {
            iy m562a = jbVar.m562a();
            byte b2 = m562a.a;
            if (b2 == 0) {
                jbVar.f();
                m419a();
                return;
            }
            switch (m562a.f791a) {
                case 1:
                    if (b2 == 11) {
                        this.f462a = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f467b = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f468c = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f461a = jbVar.m561a();
                        m420a(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f466b = jbVar.m561a();
                        b(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f465a = jbVar.m571a();
                        c(true);
                        continue;
                        jbVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f469d = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f470e = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f471f = jbVar.m567a();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        ja m564a = jbVar.m564a();
                        this.f464a = new HashMap(m564a.f795a * 2);
                        for (int i2 = 0; i2 < m564a.f795a; i2++) {
                            this.f464a.put(jbVar.m567a(), jbVar.m567a());
                        }
                        jbVar.h();
                        continue;
                        jbVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f472g = jbVar.m567a();
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
            if (this.f464a == null) {
                this.f464a = new HashMap();
            }
            this.f464a.put(str, str2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m420a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f463a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m421a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f462a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m422a(hj hjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, hjVar)) == null) {
            if (hjVar == null) {
                return false;
            }
            boolean m421a = m421a();
            boolean m421a2 = hjVar.m421a();
            if ((m421a || m421a2) && !(m421a && m421a2 && this.f462a.equals(hjVar.f462a))) {
                return false;
            }
            boolean m423b = m423b();
            boolean m423b2 = hjVar.m423b();
            if ((m423b || m423b2) && !(m423b && m423b2 && this.f467b.equals(hjVar.f467b))) {
                return false;
            }
            boolean m424c = m424c();
            boolean m424c2 = hjVar.m424c();
            if ((m424c || m424c2) && !(m424c && m424c2 && this.f468c.equals(hjVar.f468c))) {
                return false;
            }
            boolean m425d = m425d();
            boolean m425d2 = hjVar.m425d();
            if ((m425d || m425d2) && !(m425d && m425d2 && this.f461a == hjVar.f461a)) {
                return false;
            }
            boolean m426e = m426e();
            boolean m426e2 = hjVar.m426e();
            if ((m426e || m426e2) && !(m426e && m426e2 && this.f466b == hjVar.f466b)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hjVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f465a == hjVar.f465a)) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = hjVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f469d.equals(hjVar.f469d))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = hjVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f470e.equals(hjVar.f470e))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = hjVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f471f.equals(hjVar.f471f))) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = hjVar.j();
            if ((j2 || j3) && !(j2 && j3 && this.f464a.equals(hjVar.f464a))) {
                return false;
            }
            boolean k2 = k();
            boolean k3 = hjVar.k();
            if (k2 || k3) {
                return k2 && k3 && this.f472g.equals(hjVar.f472g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public hj b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j2)) == null) {
            this.f466b = j2;
            b(true);
            return this;
        }
        return (hj) invokeJ.objValue;
    }

    public hj b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            this.f467b = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f468c : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jbVar) == null) {
            m419a();
            jbVar.a(f460a);
            if (this.f462a != null && m421a()) {
                jbVar.a(a);
                jbVar.a(this.f462a);
                jbVar.b();
            }
            if (this.f467b != null && m423b()) {
                jbVar.a(f44337b);
                jbVar.a(this.f467b);
                jbVar.b();
            }
            if (this.f468c != null && m424c()) {
                jbVar.a(f44338c);
                jbVar.a(this.f468c);
                jbVar.b();
            }
            if (m425d()) {
                jbVar.a(f44339d);
                jbVar.a(this.f461a);
                jbVar.b();
            }
            if (m426e()) {
                jbVar.a(f44340e);
                jbVar.a(this.f466b);
                jbVar.b();
            }
            if (f()) {
                jbVar.a(f44341f);
                jbVar.a(this.f465a);
                jbVar.b();
            }
            if (this.f469d != null && g()) {
                jbVar.a(f44342g);
                jbVar.a(this.f469d);
                jbVar.b();
            }
            if (this.f470e != null && h()) {
                jbVar.a(f44343h);
                jbVar.a(this.f470e);
                jbVar.b();
            }
            if (this.f471f != null && i()) {
                jbVar.a(i);
                jbVar.a(this.f471f);
                jbVar.b();
            }
            if (this.f464a != null && j()) {
                jbVar.a(j);
                jbVar.a(new ja(Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, this.f464a.size()));
                for (Map.Entry<String, String> entry : this.f464a.entrySet()) {
                    jbVar.a(entry.getKey());
                    jbVar.a(entry.getValue());
                }
                jbVar.d();
                jbVar.b();
            }
            if (this.f472g != null && k()) {
                jbVar.a(k);
                jbVar.a(this.f472g);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m570a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f463a.set(1, z);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m423b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f467b != null : invokeV.booleanValue;
    }

    public hj c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f468c = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f470e : (String) invokeV.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.f463a.set(2, z);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m424c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f468c != null : invokeV.booleanValue;
    }

    public hj d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.f469d = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f471f : (String) invokeV.objValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m425d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f463a.get(0) : invokeV.booleanValue;
    }

    public hj e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            this.f470e = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f472g : (String) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m426e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f463a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, obj)) == null) {
            if (obj != null && (obj instanceof hj)) {
                return m422a((hj) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public hj f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f471f = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f463a.get(2) : invokeV.booleanValue;
    }

    public hj g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            this.f472g = str;
            return this;
        }
        return (hj) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f469d != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f470e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f471f != null : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f464a != null : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f472g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
            boolean z2 = false;
            if (m421a()) {
                sb.append("channel:");
                String str = this.f462a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m423b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(WebGLImageLoader.DATA_URL);
                String str2 = this.f467b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
                z = false;
            }
            if (m424c()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("name:");
                String str3 = this.f468c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
                z = false;
            }
            if (m425d()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("counter:");
                sb.append(this.f461a);
                z = false;
            }
            if (m426e()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("timestamp:");
                sb.append(this.f466b);
                z = false;
            }
            if (f()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("fromSdk:");
                sb.append(this.f465a);
                z = false;
            }
            if (g()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("category:");
                String str4 = this.f469d;
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
                String str5 = this.f470e;
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
                String str6 = this.f471f;
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
                Map<String, String> map = this.f464a;
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
                String str7 = this.f472g;
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
