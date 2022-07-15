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
import java.util.BitSet;
/* loaded from: classes8.dex */
public class is implements iu<is, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1505a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public static final jc g;
    public static final jc h;
    public static final jc i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1506a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1507a;

    /* renamed from: a  reason: collision with other field name */
    public String f1508a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1509a;

    /* renamed from: b  reason: collision with other field name */
    public String f1510b;

    /* renamed from: c  reason: collision with other field name */
    public String f1511c;

    /* renamed from: d  reason: collision with other field name */
    public String f1512d;

    /* renamed from: e  reason: collision with other field name */
    public String f1513e;

    /* renamed from: f  reason: collision with other field name */
    public String f1514f;

    /* renamed from: g  reason: collision with other field name */
    public String f1515g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371626, "Lcom/xiaomi/push/is;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371626, "Lcom/xiaomi/push/is;");
                return;
            }
        }
        f1505a = new jk("XmPushActionUnSubscriptionResult");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", Constants.GZIP_CAST_TYPE, (short) 9);
        i = new jc("", Constants.GZIP_CAST_TYPE, (short) 10);
    }

    public is() {
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
        this.f1509a = new BitSet(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(is isVar) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, isVar)) == null) {
            if (is.class.equals(isVar.getClass())) {
                int compareTo = Boolean.valueOf(m1465a()).compareTo(Boolean.valueOf(isVar.m1465a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1465a() || (a10 = iv.a(this.f1508a, isVar.f1508a)) == 0) {
                    int compareTo2 = Boolean.valueOf(m1467b()).compareTo(Boolean.valueOf(isVar.m1467b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!m1467b() || (a9 = iv.a(this.f1507a, isVar.f1507a)) == 0) {
                        int compareTo3 = Boolean.valueOf(m1468c()).compareTo(Boolean.valueOf(isVar.m1468c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!m1468c() || (a8 = iv.a(this.f1510b, isVar.f1510b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(isVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = iv.a(this.f1511c, isVar.f1511c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(isVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = iv.a(this.f1506a, isVar.f1506a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(isVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = iv.a(this.f1512d, isVar.f1512d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(isVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = iv.a(this.f1513e, isVar.f1513e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(isVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = iv.a(this.f1514f, isVar.f1514f)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(isVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = iv.a(this.f1515g, isVar.f1515g)) == 0) {
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
            return is.class.getName().compareTo(isVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1510b : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1464a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f1510b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
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
                m1464a();
                return;
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1508a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1507a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1510b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1511c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f1506a = jfVar.m1482a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1512d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1513e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f1514f = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f1515g = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f1509a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1465a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1508a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1466a(is isVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, isVar)) == null) {
            if (isVar == null) {
                return false;
            }
            boolean m1465a = m1465a();
            boolean m1465a2 = isVar.m1465a();
            if ((m1465a || m1465a2) && !(m1465a && m1465a2 && this.f1508a.equals(isVar.f1508a))) {
                return false;
            }
            boolean m1467b = m1467b();
            boolean m1467b2 = isVar.m1467b();
            if ((m1467b || m1467b2) && !(m1467b && m1467b2 && this.f1507a.m1381a(isVar.f1507a))) {
                return false;
            }
            boolean m1468c = m1468c();
            boolean m1468c2 = isVar.m1468c();
            if ((m1468c || m1468c2) && !(m1468c && m1468c2 && this.f1510b.equals(isVar.f1510b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = isVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f1511c.equals(isVar.f1511c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = isVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f1506a == isVar.f1506a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = isVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1512d.equals(isVar.f1512d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = isVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1513e.equals(isVar.f1513e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = isVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1514f.equals(isVar.f1514f))) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = isVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f1515g.equals(isVar.f1515g);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1513e : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jfVar) == null) {
            m1464a();
            jfVar.a(f1505a);
            if (this.f1508a != null && m1465a()) {
                jfVar.a(a);
                jfVar.a(this.f1508a);
                jfVar.b();
            }
            if (this.f1507a != null && m1467b()) {
                jfVar.a(b);
                this.f1507a.b(jfVar);
                jfVar.b();
            }
            if (this.f1510b != null) {
                jfVar.a(c);
                jfVar.a(this.f1510b);
                jfVar.b();
            }
            if (this.f1511c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f1511c);
                jfVar.b();
            }
            if (e()) {
                jfVar.a(e);
                jfVar.a(this.f1506a);
                jfVar.b();
            }
            if (this.f1512d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1512d);
                jfVar.b();
            }
            if (this.f1513e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1513e);
                jfVar.b();
            }
            if (this.f1514f != null && h()) {
                jfVar.a(h);
                jfVar.a(this.f1514f);
                jfVar.b();
            }
            if (this.f1515g != null && i()) {
                jfVar.a(i);
                jfVar.a(this.f1515g);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1467b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1507a != null : invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1515g : (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1468c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1510b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1511c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1509a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof is)) {
                return m1466a((is) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1512d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1513e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1514f != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1515g != null : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
            boolean z2 = false;
            if (m1465a()) {
                sb.append("debug:");
                String str = this.f1508a;
                if (str == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str);
                }
                z = false;
            } else {
                z = true;
            }
            if (m1467b()) {
                if (!z) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append("target:");
                hy hyVar = this.f1507a;
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
            String str2 = this.f1510b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("appId:");
                String str3 = this.f1511c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("errorCode:");
                sb.append(this.f1506a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f1512d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(UrlSchemaHelper.SCHEMA_TYPE_TOPIC);
                String str5 = this.f1513e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str6 = this.f1514f;
                if (str6 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str6);
                }
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("category:");
                String str7 = this.f1515g;
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
