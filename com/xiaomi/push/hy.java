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
public class hy implements iu<hy, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1272a;
    public static final jc b;
    public static final jc c;
    public static final jc d;
    public static final jc e;
    public static final jc f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f1273a;

    /* renamed from: a  reason: collision with other field name */
    public String f1274a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1275a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1276a;

    /* renamed from: b  reason: collision with other field name */
    public String f1277b;

    /* renamed from: c  reason: collision with other field name */
    public String f1278c;

    /* renamed from: d  reason: collision with other field name */
    public String f1279d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372401, "Lcom/xiaomi/push/hy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372401, "Lcom/xiaomi/push/hy;");
                return;
            }
        }
        f1272a = new jk("Target");
        a = new jc("", (byte) 10, (short) 1);
        b = new jc("", Constants.GZIP_CAST_TYPE, (short) 2);
        c = new jc("", Constants.GZIP_CAST_TYPE, (short) 3);
        d = new jc("", Constants.GZIP_CAST_TYPE, (short) 4);
        e = new jc("", (byte) 2, (short) 5);
        f = new jc("", Constants.GZIP_CAST_TYPE, (short) 7);
    }

    public hy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1275a = new BitSet(2);
        this.f1273a = 5L;
        this.f1277b = "xiaomi.com";
        this.f1278c = "";
        this.f1276a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hyVar)) == null) {
            if (hy.class.equals(hyVar.getClass())) {
                int compareTo = Boolean.valueOf(m1380a()).compareTo(Boolean.valueOf(hyVar.m1380a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1380a() || (a7 = iv.a(this.f1273a, hyVar.f1273a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a6 = iv.a(this.f1274a, hyVar.f1274a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a5 = iv.a(this.f1277b, hyVar.f1277b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a4 = iv.a(this.f1278c, hyVar.f1278c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a3 = iv.a(this.f1276a, hyVar.f1276a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a2 = iv.a(this.f1279d, hyVar.f1279d)) == 0) {
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
            return hy.class.getName().compareTo(hyVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f1274a == null) {
            throw new jg("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jfVar) == null) {
            jfVar.m1487a();
            while (true) {
                jc m1483a = jfVar.m1483a();
                byte b2 = m1483a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m1483a.f1529a;
                if (s == 1) {
                    if (b2 == 10) {
                        this.f1273a = jfVar.m1482a();
                        a(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s == 2) {
                    if (b2 == 11) {
                        this.f1274a = jfVar.m1488a();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s == 3) {
                    if (b2 == 11) {
                        this.f1277b = jfVar.m1488a();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s == 4) {
                    if (b2 == 11) {
                        this.f1278c = jfVar.m1488a();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s != 5) {
                    if (s == 7 && b2 == 11) {
                        this.f1279d = jfVar.m1488a();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else {
                    if (b2 == 2) {
                        this.f1276a = jfVar.m1492a();
                        b(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                }
            }
            jfVar.f();
            if (m1380a()) {
                a();
                return;
            }
            throw new jg("Required field 'channelId' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f1275a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1380a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1275a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1381a(hy hyVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hyVar)) == null) {
            if (hyVar != null && this.f1273a == hyVar.f1273a) {
                boolean b2 = b();
                boolean b3 = hyVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f1274a.equals(hyVar.f1274a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hyVar.c();
                if ((c2 || c3) && !(c2 && c3 && this.f1277b.equals(hyVar.f1277b))) {
                    return false;
                }
                boolean d2 = d();
                boolean d3 = hyVar.d();
                if ((d2 || d3) && !(d2 && d3 && this.f1278c.equals(hyVar.f1278c))) {
                    return false;
                }
                boolean e2 = e();
                boolean e3 = hyVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f1276a == hyVar.f1276a)) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = hyVar.f();
                if (f2 || f3) {
                    return f2 && f3 && this.f1279d.equals(hyVar.f1279d);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            a();
            jfVar.a(f1272a);
            jfVar.a(a);
            jfVar.a(this.f1273a);
            jfVar.b();
            if (this.f1274a != null) {
                jfVar.a(b);
                jfVar.a(this.f1274a);
                jfVar.b();
            }
            if (this.f1277b != null && c()) {
                jfVar.a(c);
                jfVar.a(this.f1277b);
                jfVar.b();
            }
            if (this.f1278c != null && d()) {
                jfVar.a(d);
                jfVar.a(this.f1278c);
                jfVar.b();
            }
            if (e()) {
                jfVar.a(e);
                jfVar.a(this.f1276a);
                jfVar.b();
            }
            if (this.f1279d != null && f()) {
                jfVar.a(f);
                jfVar.a(this.f1279d);
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f1275a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1274a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f1277b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1278c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1275a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj != null && (obj instanceof hy)) {
                return m1381a((hy) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1279d != null : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder("Target(");
            sb.append("channelId:");
            sb.append(this.f1273a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userId:");
            String str = this.f1274a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("server:");
                String str2 = this.f1277b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("resource:");
                String str3 = this.f1278c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isPreview:");
                sb.append(this.f1276a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("token:");
                String str4 = this.f1279d;
                if (str4 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str4);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
