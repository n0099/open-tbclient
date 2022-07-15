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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class id implements iu<id, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1320a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public static final jc j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1321a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1322a;

    /* renamed from: a  reason: collision with other field name */
    public String f1323a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1324a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f1325a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1326a;

    /* renamed from: b  reason: collision with other field name */
    public String f1327b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1328b;

    /* renamed from: c  reason: collision with other field name */
    public String f1329c;

    /* renamed from: d  reason: collision with other field name */
    public String f1330d;

    /* renamed from: e  reason: collision with other field name */
    public String f1331e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372091, "Lcom/xiaomi/push/id;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372091, "Lcom/xiaomi/push/id;");
                return;
            }
        }
        f1320a = new jk("XmPushActionCommand");
        a = new jc("", (byte) 12, (short) 2);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        e = new jc("", (byte) 15, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        h = new jc("", (byte) 2, (short) 10);
        i = new jc("", (byte) 2, (short) 11);
        j = new jc("", (byte) 10, (short) 12);
    }

    public id() {
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
        this.f1324a = new BitSet(3);
        this.f1326a = false;
        this.f1328b = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, idVar)) == null) {
            if (id.class.equals(idVar.getClass())) {
                int compareTo = Boolean.valueOf(m1395a()).compareTo(Boolean.valueOf(idVar.m1395a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1395a() || (a11 = iv.a(this.f1322a, idVar.f1322a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = iv.a(this.f1323a, idVar.f1323a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = iv.a(this.f1327b, idVar.f1327b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f1329c, idVar.f1329c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f1325a, idVar.f1325a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f1330d, idVar.f1330d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f1331e, idVar.f1331e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f1326a, idVar.f1326a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f1328b, idVar.f1328b)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f1321a, idVar.f1321a)) == 0) {
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
            return id.class.getName().compareTo(idVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public id a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f1323a = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f1329c : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1393a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f1323a == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1327b == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f1329c != null) {
            } else {
                throw new jg("Required field 'cmdName' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                m1393a();
                return;
            }
            switch (m1483a.f1529a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1322a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1323a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1327b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1329c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        jd m1484a = jfVar.m1484a();
                        this.f1325a = new ArrayList(m1484a.f1530a);
                        for (int i2 = 0; i2 < m1484a.f1530a; i2++) {
                            this.f1325a.add(jfVar.m1488a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1330d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f1331e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f1326a = jfVar.m1492a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f1328b = jfVar.m1492a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f1321a = jfVar.m1482a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1394a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.f1325a == null) {
                this.f1325a = new ArrayList();
            }
            this.f1325a.add(str);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f1324a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1395a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1322a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1396a(id idVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, idVar)) == null) {
            if (idVar == null) {
                return false;
            }
            boolean m1395a = m1395a();
            boolean m1395a2 = idVar.m1395a();
            if ((m1395a || m1395a2) && !(m1395a && m1395a2 && this.f1322a.m1381a(idVar.f1322a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = idVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f1323a.equals(idVar.f1323a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = idVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f1327b.equals(idVar.f1327b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = idVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1329c.equals(idVar.f1329c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = idVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1325a.equals(idVar.f1325a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = idVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1330d.equals(idVar.f1330d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = idVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1331e.equals(idVar.f1331e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = idVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1326a == idVar.f1326a)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = idVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f1328b == idVar.f1328b)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = idVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f1321a == idVar.f1321a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public id b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f1327b = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m1393a();
            jfVar.a(f1320a);
            if (this.f1322a != null && m1395a()) {
                jfVar.a(a);
                this.f1322a.b(jfVar);
                jfVar.b();
            }
            if (this.f1323a != null) {
                jfVar.a(b);
                jfVar.a(this.f1323a);
                jfVar.b();
            }
            if (this.f1327b != null) {
                jfVar.a(c);
                jfVar.a(this.f1327b);
                jfVar.b();
            }
            if (this.f1329c != null) {
                jfVar.a(d);
                jfVar.a(this.f1329c);
                jfVar.b();
            }
            if (this.f1325a != null && e()) {
                jfVar.a(e);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f1325a.size()));
                for (String str : this.f1325a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            if (this.f1330d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1330d);
                jfVar.b();
            }
            if (this.f1331e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1331e);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(h);
                jfVar.a(this.f1326a);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f1328b);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f1321a);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f1324a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1323a != null : invokeV.booleanValue;
    }

    public id c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f1329c = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f1324a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1327b != null : invokeV.booleanValue;
    }

    public id d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f1330d = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1329c != null : invokeV.booleanValue;
    }

    public id e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.f1331e = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1325a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof id)) {
                return m1396a((id) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f1330d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f1331e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f1324a.get(0) : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f1324a.get(1) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f1324a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommand(");
            if (m1395a()) {
                sb.append("target:");
                hy hyVar = this.f1322a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str = this.f1323a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f1327b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f1329c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f1325a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f1330d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f1331e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("updateCache:");
                sb.append(this.f1326a);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f1328b);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f1321a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
