package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ir implements iu<ir, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1496a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public hy f1497a;

    /* renamed from: a  reason: collision with other field name */
    public String f1498a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f1499a;

    /* renamed from: b  reason: collision with other field name */
    public String f1500b;

    /* renamed from: c  reason: collision with other field name */
    public String f1501c;

    /* renamed from: d  reason: collision with other field name */
    public String f1502d;

    /* renamed from: e  reason: collision with other field name */
    public String f1503e;

    /* renamed from: f  reason: collision with other field name */
    public String f1504f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371657, "Lcom/xiaomi/push/ir;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371657, "Lcom/xiaomi/push/ir;");
                return;
            }
        }
        f1496a = new jk("XmPushActionUnSubscription");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", Constants.GZIP_CAST_TYPE, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 6);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        h = new jc("", (byte) 15, (short) 8);
    }

    public ir() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ir irVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, irVar)) == null) {
            if (ir.class.equals(irVar.getClass())) {
                int compareTo = Boolean.valueOf(m1462a()).compareTo(Boolean.valueOf(irVar.m1462a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1462a() || (a9 = iv.a(this.f1498a, irVar.f1498a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(irVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a8 = iv.a(this.f1497a, irVar.f1497a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a7 = iv.a(this.f1500b, irVar.f1500b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a6 = iv.a(this.f1501c, irVar.f1501c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a5 = iv.a(this.f1502d, irVar.f1502d)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a4 = iv.a(this.f1503e, irVar.f1503e)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a3 = iv.a(this.f1504f, irVar.f1504f)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a2 = iv.a(this.f1499a, irVar.f1499a)) == 0) {
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
            return ir.class.getName().compareTo(irVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ir a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f1500b = str;
            return this;
        }
        return (ir) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f1500b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1501c == null) {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
            } else if (this.f1502d != null) {
            } else {
                throw new jg("Required field 'topic' was not present! Struct: " + toString());
            }
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b2 = m1483a.a;
            if (b2 == 0) {
                jfVar.f();
                a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1498a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1497a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1500b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1501c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f1502d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f1503e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1504f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jd m1484a = jfVar.m1484a();
                        this.f1499a = new ArrayList(m1484a.f1530a);
                        for (int i = 0; i < m1484a.f1530a; i++) {
                            this.f1499a.add(jfVar.m1488a());
                        }
                        jfVar.i();
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
    public boolean m1462a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1498a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1463a(ir irVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, irVar)) == null) {
            if (irVar == null) {
                return false;
            }
            boolean m1462a = m1462a();
            boolean m1462a2 = irVar.m1462a();
            if ((m1462a || m1462a2) && !(m1462a && m1462a2 && this.f1498a.equals(irVar.f1498a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = irVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f1497a.m1381a(irVar.f1497a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = irVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f1500b.equals(irVar.f1500b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = irVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1501c.equals(irVar.f1501c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = irVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1502d.equals(irVar.f1502d))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = irVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1503e.equals(irVar.f1503e))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = irVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1504f.equals(irVar.f1504f))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = irVar.h();
            if (h2 || h3) {
                return h2 && h3 && this.f1499a.equals(irVar.f1499a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ir b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f1501c = str;
            return this;
        }
        return (ir) invokeL.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jfVar) == null) {
            a();
            jfVar.a(f1496a);
            if (this.f1498a != null && m1462a()) {
                jfVar.a(a);
                jfVar.a(this.f1498a);
                jfVar.b();
            }
            if (this.f1497a != null && b()) {
                jfVar.a(b);
                this.f1497a.b(jfVar);
                jfVar.b();
            }
            if (this.f1500b != null) {
                jfVar.a(c);
                jfVar.a(this.f1500b);
                jfVar.b();
            }
            if (this.f1501c != null) {
                jfVar.a(d);
                jfVar.a(this.f1501c);
                jfVar.b();
            }
            if (this.f1502d != null) {
                jfVar.a(e);
                jfVar.a(this.f1502d);
                jfVar.b();
            }
            if (this.f1503e != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1503e);
                jfVar.b();
            }
            if (this.f1504f != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1504f);
                jfVar.b();
            }
            if (this.f1499a != null && h()) {
                jfVar.a(h);
                jfVar.a(new jd(Constants.GZIP_CAST_TYPE, this.f1499a.size()));
                for (String str : this.f1499a) {
                    jfVar.a(str);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1497a != null : invokeV.booleanValue;
    }

    public ir c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.f1502d = str;
            return this;
        }
        return (ir) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1500b != null : invokeV.booleanValue;
    }

    public ir d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.f1503e = str;
            return this;
        }
        return (ir) invokeL.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1501c != null : invokeV.booleanValue;
    }

    public ir e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.f1504f = str;
            return this;
        }
        return (ir) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f1502d != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (obj != null && (obj instanceof ir)) {
                return m1463a((ir) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1503e != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1504f != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f1499a != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
            boolean z2 = false;
            if (m1462a()) {
                sb.append("debug:");
                String str = this.f1498a;
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
                hy hyVar = this.f1497a;
                if (hyVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hyVar);
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append("id:");
            String str2 = this.f1500b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f1501c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
            String str4 = this.f1502d;
            if (str4 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str4);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f1503e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str6 = this.f1504f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("aliases:");
                List<String> list = this.f1499a;
                if (list == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(list);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
