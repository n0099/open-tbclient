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
    public static final jk f624a;
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
    public long f625a;

    /* renamed from: a  reason: collision with other field name */
    public hy f626a;

    /* renamed from: a  reason: collision with other field name */
    public String f627a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f628a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f629a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f630a;

    /* renamed from: b  reason: collision with other field name */
    public String f631b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f632b;

    /* renamed from: c  reason: collision with other field name */
    public String f633c;

    /* renamed from: d  reason: collision with other field name */
    public String f634d;

    /* renamed from: e  reason: collision with other field name */
    public String f635e;

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
        f624a = new jk("XmPushActionCommand");
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
        this.f628a = new BitSet(3);
        this.f630a = false;
        this.f632b = true;
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
                int compareTo = Boolean.valueOf(m467a()).compareTo(Boolean.valueOf(idVar.m467a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m467a() || (a11 = iv.a(this.f626a, idVar.f626a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a10 = iv.a(this.f627a, idVar.f627a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a9 = iv.a(this.f631b, idVar.f631b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a8 = iv.a(this.f633c, idVar.f633c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a7 = iv.a(this.f629a, idVar.f629a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a6 = iv.a(this.f634d, idVar.f634d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a5 = iv.a(this.f635e, idVar.f635e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a4 = iv.a(this.f630a, idVar.f630a)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a3 = iv.a(this.f632b, idVar.f632b)) == 0) {
                                                    int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                    if (compareTo10 != 0) {
                                                        return compareTo10;
                                                    }
                                                    if (!j() || (a2 = iv.a(this.f625a, idVar.f625a)) == 0) {
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
            this.f627a = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f633c : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m465a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f627a == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f631b == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f633c != null) {
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
        jfVar.m559a();
        while (true) {
            jc m555a = jfVar.m555a();
            byte b2 = m555a.a;
            if (b2 == 0) {
                jfVar.f();
                m465a();
                return;
            }
            switch (m555a.f833a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f626a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f627a = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f631b = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f633c = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        jd m556a = jfVar.m556a();
                        this.f629a = new ArrayList(m556a.f834a);
                        for (int i2 = 0; i2 < m556a.f834a; i2++) {
                            this.f629a.add(jfVar.m560a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f634d = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f635e = jfVar.m560a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f630a = jfVar.m564a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f632b = jfVar.m564a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f625a = jfVar.m554a();
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
    public void m466a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.f629a == null) {
                this.f629a = new ArrayList();
            }
            this.f629a.add(str);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f628a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f626a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m468a(id idVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, idVar)) == null) {
            if (idVar == null) {
                return false;
            }
            boolean m467a = m467a();
            boolean m467a2 = idVar.m467a();
            if ((m467a || m467a2) && !(m467a && m467a2 && this.f626a.m453a(idVar.f626a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = idVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f627a.equals(idVar.f627a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = idVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f631b.equals(idVar.f631b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = idVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f633c.equals(idVar.f633c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = idVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f629a.equals(idVar.f629a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = idVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f634d.equals(idVar.f634d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = idVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f635e.equals(idVar.f635e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = idVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f630a == idVar.f630a)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = idVar.i();
            if ((i2 || i3) && !(i2 && i3 && this.f632b == idVar.f632b)) {
                return false;
            }
            boolean j2 = j();
            boolean j3 = idVar.j();
            if (j2 || j3) {
                return j2 && j3 && this.f625a == idVar.f625a;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public id b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f631b = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jfVar) == null) {
            m465a();
            jfVar.a(f624a);
            if (this.f626a != null && m467a()) {
                jfVar.a(a);
                this.f626a.b(jfVar);
                jfVar.b();
            }
            if (this.f627a != null) {
                jfVar.a(b);
                jfVar.a(this.f627a);
                jfVar.b();
            }
            if (this.f631b != null) {
                jfVar.a(c);
                jfVar.a(this.f631b);
                jfVar.b();
            }
            if (this.f633c != null) {
                jfVar.a(d);
                jfVar.a(this.f633c);
                jfVar.b();
            }
            if (this.f629a != null && e()) {
                jfVar.a(e);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f629a.size()));
                for (String str : this.f629a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            if (this.f634d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f634d);
                jfVar.b();
            }
            if (this.f635e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f635e);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(h);
                jfVar.a(this.f630a);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f632b);
                jfVar.b();
            }
            if (j()) {
                jfVar.a(j);
                jfVar.a(this.f625a);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m563a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f628a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f627a != null : invokeV.booleanValue;
    }

    public id c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.f633c = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f628a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f631b != null : invokeV.booleanValue;
    }

    public id d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            this.f634d = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f633c != null : invokeV.booleanValue;
    }

    public id e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            this.f635e = str;
            return this;
        }
        return (id) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f629a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj != null && (obj instanceof id)) {
                return m468a((id) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f634d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f635e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f628a.get(0) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f628a.get(1) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f628a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionCommand(");
            if (m467a()) {
                sb.append("target:");
                hy hyVar = this.f626a;
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
            String str = this.f627a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str2 = this.f631b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("cmdName:");
            String str3 = this.f633c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("cmdArgs:");
                List<String> list = this.f629a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str4 = this.f634d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str5 = this.f635e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("updateCache:");
                sb.append(this.f630a);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("response2Client:");
                sb.append(this.f632b);
            }
            if (j()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("createdTs:");
                sb.append(this.f625a);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
