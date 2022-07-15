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
import java.util.BitSet;
/* loaded from: classes8.dex */
public class iq implements iu<iq, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1485a;
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
    public long f1486a;

    /* renamed from: a  reason: collision with other field name */
    public hy f1487a;

    /* renamed from: a  reason: collision with other field name */
    public String f1488a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1489a;

    /* renamed from: b  reason: collision with other field name */
    public long f1490b;

    /* renamed from: b  reason: collision with other field name */
    public String f1491b;

    /* renamed from: c  reason: collision with other field name */
    public long f1492c;

    /* renamed from: c  reason: collision with other field name */
    public String f1493c;

    /* renamed from: d  reason: collision with other field name */
    public String f1494d;

    /* renamed from: e  reason: collision with other field name */
    public String f1495e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371688, "Lcom/xiaomi/push/iq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371688, "Lcom/xiaomi/push/iq;");
                return;
            }
        }
        f1485a = new jk("XmPushActionUnRegistrationResult");
        a = new jc("", Constants.GZIP_CAST_TYPE, (short) 1);
        b = new jc("", (byte) 12, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 10, (short) 6);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
        g = new jc("", Constants.GZIP_CAST_TYPE, (short) 8);
        h = new jc("", (byte) 10, (short) 9);
        i = new jc("", (byte) 10, (short) 10);
    }

    public iq() {
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
        this.f1489a = new BitSet(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iq iqVar) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iqVar)) == null) {
            if (iq.class.equals(iqVar.getClass())) {
                int compareTo = Boolean.valueOf(m1460a()).compareTo(Boolean.valueOf(iqVar.m1460a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1460a() || (a10 = iv.a(this.f1488a, iqVar.f1488a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a9 = iv.a(this.f1487a, iqVar.f1487a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a8 = iv.a(this.f1491b, iqVar.f1491b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a7 = iv.a(this.f1493c, iqVar.f1493c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a6 = iv.a(this.f1486a, iqVar.f1486a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a5 = iv.a(this.f1494d, iqVar.f1494d)) == 0) {
                                        int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                        if (compareTo7 != 0) {
                                            return compareTo7;
                                        }
                                        if (!g() || (a4 = iv.a(this.f1495e, iqVar.f1495e)) == 0) {
                                            int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                            if (compareTo8 != 0) {
                                                return compareTo8;
                                            }
                                            if (!h() || (a3 = iv.a(this.f1490b, iqVar.f1490b)) == 0) {
                                                int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
                                                if (compareTo9 != 0) {
                                                    return compareTo9;
                                                }
                                                if (!i() || (a2 = iv.a(this.f1492c, iqVar.f1492c)) == 0) {
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
            return iq.class.getName().compareTo(iqVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1495e : (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1459a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f1491b == null) {
                throw new jg("Required field 'id' was not present! Struct: " + toString());
            } else if (this.f1493c != null) {
            } else {
                throw new jg("Required field 'appId' was not present! Struct: " + toString());
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
                if (e()) {
                    m1459a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (m1483a.f1529a) {
                case 1:
                    if (b2 == 11) {
                        this.f1488a = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f1487a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f1491b = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f1493c = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f1486a = jfVar.m1482a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f1494d = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f1495e = jfVar.m1488a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f1490b = jfVar.m1482a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f1492c = jfVar.m1482a();
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

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f1489a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1460a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1488a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1461a(iq iqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iqVar)) == null) {
            if (iqVar == null) {
                return false;
            }
            boolean m1460a = m1460a();
            boolean m1460a2 = iqVar.m1460a();
            if ((m1460a || m1460a2) && !(m1460a && m1460a2 && this.f1488a.equals(iqVar.f1488a))) {
                return false;
            }
            boolean b2 = b();
            boolean b3 = iqVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f1487a.m1381a(iqVar.f1487a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = iqVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f1491b.equals(iqVar.f1491b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = iqVar.d();
            if (((d2 || d3) && !(d2 && d3 && this.f1493c.equals(iqVar.f1493c))) || this.f1486a != iqVar.f1486a) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = iqVar.f();
            if ((f2 || f3) && !(f2 && f3 && this.f1494d.equals(iqVar.f1494d))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = iqVar.g();
            if ((g2 || g3) && !(g2 && g3 && this.f1495e.equals(iqVar.f1495e))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = iqVar.h();
            if ((h2 || h3) && !(h2 && h3 && this.f1490b == iqVar.f1490b)) {
                return false;
            }
            boolean i2 = i();
            boolean i3 = iqVar.i();
            if (i2 || i3) {
                return i2 && i3 && this.f1492c == iqVar.f1492c;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jfVar) == null) {
            m1459a();
            jfVar.a(f1485a);
            if (this.f1488a != null && m1460a()) {
                jfVar.a(a);
                jfVar.a(this.f1488a);
                jfVar.b();
            }
            if (this.f1487a != null && b()) {
                jfVar.a(b);
                this.f1487a.b(jfVar);
                jfVar.b();
            }
            if (this.f1491b != null) {
                jfVar.a(c);
                jfVar.a(this.f1491b);
                jfVar.b();
            }
            if (this.f1493c != null) {
                jfVar.a(d);
                jfVar.a(this.f1493c);
                jfVar.b();
            }
            jfVar.a(e);
            jfVar.a(this.f1486a);
            jfVar.b();
            if (this.f1494d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1494d);
                jfVar.b();
            }
            if (this.f1495e != null && g()) {
                jfVar.a(g);
                jfVar.a(this.f1495e);
                jfVar.b();
            }
            if (h()) {
                jfVar.a(h);
                jfVar.a(this.f1490b);
                jfVar.b();
            }
            if (i()) {
                jfVar.a(i);
                jfVar.a(this.f1492c);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f1489a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1487a != null : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f1489a.set(2, z);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1491b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1493c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1489a.get(0) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (obj != null && (obj instanceof iq)) {
                return m1461a((iq) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f1494d != null : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f1495e != null : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f1489a.get(1) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1489a.get(2) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
            boolean z2 = false;
            if (m1460a()) {
                sb.append("debug:");
                String str = this.f1488a;
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
                hy hyVar = this.f1487a;
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
            String str2 = this.f1491b;
            if (str2 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str2);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("appId:");
            String str3 = this.f1493c;
            if (str3 == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str3);
            }
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("errorCode:");
            sb.append(this.f1486a);
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("reason:");
                String str4 = this.f1494d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            if (g()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("packageName:");
                String str5 = this.f1495e;
                if (str5 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str5);
                }
            }
            if (h()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("unRegisteredAt:");
                sb.append(this.f1490b);
            }
            if (i()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("costTime:");
                sb.append(this.f1492c);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
