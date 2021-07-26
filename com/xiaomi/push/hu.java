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
/* loaded from: classes6.dex */
public class hu implements iq<hu, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f40610a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f556a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f40611b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f40612c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f40613d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f40614e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f40615f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f557a;

    /* renamed from: a  reason: collision with other field name */
    public String f558a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f559a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f560a;

    /* renamed from: b  reason: collision with other field name */
    public String f561b;

    /* renamed from: c  reason: collision with other field name */
    public String f562c;

    /* renamed from: d  reason: collision with other field name */
    public String f563d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372525, "Lcom/xiaomi/push/hu;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372525, "Lcom/xiaomi/push/hu;");
                return;
            }
        }
        f556a = new jg("Target");
        f40610a = new iy("", (byte) 10, (short) 1);
        f40611b = new iy("", (byte) 11, (short) 2);
        f40612c = new iy("", (byte) 11, (short) 3);
        f40613d = new iy("", (byte) 11, (short) 4);
        f40614e = new iy("", (byte) 2, (short) 5);
        f40615f = new iy("", (byte) 11, (short) 7);
    }

    public hu() {
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
        this.f559a = new BitSet(2);
        this.f557a = 5L;
        this.f561b = "xiaomi.com";
        this.f562c = "";
        this.f560a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, huVar)) == null) {
            if (hu.class.equals(huVar.getClass())) {
                int compareTo = Boolean.valueOf(m418a()).compareTo(Boolean.valueOf(huVar.m418a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m418a() || (a7 = ir.a(this.f557a, huVar.f557a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a6 = ir.a(this.f558a, huVar.f558a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a5 = ir.a(this.f561b, huVar.f561b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a4 = ir.a(this.f562c, huVar.f562c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a3 = ir.a(this.f560a, huVar.f560a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a2 = ir.a(this.f563d, huVar.f563d)) == 0) {
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
            return hu.class.getName().compareTo(huVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f558a == null) {
            throw new jc("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jbVar) == null) {
            jbVar.m524a();
            while (true) {
                iy m520a = jbVar.m520a();
                byte b2 = m520a.f40780a;
                if (b2 == 0) {
                    break;
                }
                short s = m520a.f810a;
                if (s == 1) {
                    if (b2 == 10) {
                        this.f557a = jbVar.m519a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 2) {
                    if (b2 == 11) {
                        this.f558a = jbVar.m525a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 3) {
                    if (b2 == 11) {
                        this.f561b = jbVar.m525a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 4) {
                    if (b2 == 11) {
                        this.f562c = jbVar.m525a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 5) {
                    if (s == 7 && b2 == 11) {
                        this.f563d = jbVar.m525a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 2) {
                        this.f560a = jbVar.m529a();
                        b(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m418a()) {
                a();
                return;
            }
            throw new jc("Required field 'channelId' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f559a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m418a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f559a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m419a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, huVar)) == null) {
            if (huVar != null && this.f557a == huVar.f557a) {
                boolean b2 = b();
                boolean b3 = huVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f558a.equals(huVar.f558a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = huVar.c();
                if ((c2 || c3) && !(c2 && c3 && this.f561b.equals(huVar.f561b))) {
                    return false;
                }
                boolean d2 = d();
                boolean d3 = huVar.d();
                if ((d2 || d3) && !(d2 && d3 && this.f562c.equals(huVar.f562c))) {
                    return false;
                }
                boolean e2 = e();
                boolean e3 = huVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f560a == huVar.f560a)) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = huVar.f();
                if (f2 || f3) {
                    return f2 && f3 && this.f563d.equals(huVar.f563d);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            a();
            jbVar.a(f556a);
            jbVar.a(f40610a);
            jbVar.a(this.f557a);
            jbVar.b();
            if (this.f558a != null) {
                jbVar.a(f40611b);
                jbVar.a(this.f558a);
                jbVar.b();
            }
            if (this.f561b != null && c()) {
                jbVar.a(f40612c);
                jbVar.a(this.f561b);
                jbVar.b();
            }
            if (this.f562c != null && d()) {
                jbVar.a(f40613d);
                jbVar.a(this.f562c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f40614e);
                jbVar.a(this.f560a);
                jbVar.b();
            }
            if (this.f563d != null && f()) {
                jbVar.a(f40615f);
                jbVar.a(this.f563d);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f559a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f558a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f561b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f562c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f559a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj != null && (obj instanceof hu)) {
                return m419a((hu) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f563d != null : invokeV.booleanValue;
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
            sb.append(this.f557a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userId:");
            String str = this.f558a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("server:");
                String str2 = this.f561b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("resource:");
                String str3 = this.f562c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isPreview:");
                sb.append(this.f560a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("token:");
                String str4 = this.f563d;
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
