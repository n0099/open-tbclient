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
/* loaded from: classes4.dex */
public class hu implements iq<hu, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f561a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f61284b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f61285c;

    /* renamed from: d  reason: collision with root package name */
    public static final iy f61286d;

    /* renamed from: e  reason: collision with root package name */
    public static final iy f61287e;

    /* renamed from: f  reason: collision with root package name */
    public static final iy f61288f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f562a;

    /* renamed from: a  reason: collision with other field name */
    public String f563a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f564a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f565a;

    /* renamed from: b  reason: collision with other field name */
    public String f566b;

    /* renamed from: c  reason: collision with other field name */
    public String f567c;

    /* renamed from: d  reason: collision with other field name */
    public String f568d;

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
        f561a = new jg("Target");
        a = new iy("", (byte) 10, (short) 1);
        f61284b = new iy("", (byte) 11, (short) 2);
        f61285c = new iy("", (byte) 11, (short) 3);
        f61286d = new iy("", (byte) 11, (short) 4);
        f61287e = new iy("", (byte) 2, (short) 5);
        f61288f = new iy("", (byte) 11, (short) 7);
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
        this.f564a = new BitSet(2);
        this.f562a = 5L;
        this.f566b = "xiaomi.com";
        this.f567c = "";
        this.f565a = false;
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
                int compareTo = Boolean.valueOf(m482a()).compareTo(Boolean.valueOf(huVar.m482a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m482a() || (a7 = ir.a(this.f562a, huVar.f562a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(huVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a6 = ir.a(this.f563a, huVar.f563a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(huVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a5 = ir.a(this.f566b, huVar.f566b)) == 0) {
                            int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                            if (compareTo4 != 0) {
                                return compareTo4;
                            }
                            if (!d() || (a4 = ir.a(this.f567c, huVar.f567c)) == 0) {
                                int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                                if (compareTo5 != 0) {
                                    return compareTo5;
                                }
                                if (!e() || (a3 = ir.a(this.f565a, huVar.f565a)) == 0) {
                                    int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                    if (compareTo6 != 0) {
                                        return compareTo6;
                                    }
                                    if (!f() || (a2 = ir.a(this.f568d, huVar.f568d)) == 0) {
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f563a == null) {
            throw new jc("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jbVar) == null) {
            jbVar.m588a();
            while (true) {
                iy m584a = jbVar.m584a();
                byte b2 = m584a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m584a.f815a;
                if (s == 1) {
                    if (b2 == 10) {
                        this.f562a = jbVar.m583a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 2) {
                    if (b2 == 11) {
                        this.f563a = jbVar.m589a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 3) {
                    if (b2 == 11) {
                        this.f566b = jbVar.m589a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s == 4) {
                    if (b2 == 11) {
                        this.f567c = jbVar.m589a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 5) {
                    if (s == 7 && b2 == 11) {
                        this.f568d = jbVar.m589a();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 2) {
                        this.f565a = jbVar.m593a();
                        b(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m482a()) {
                a();
                return;
            }
            throw new jc("Required field 'channelId' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f564a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m482a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f564a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m483a(hu huVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, huVar)) == null) {
            if (huVar != null && this.f562a == huVar.f562a) {
                boolean b2 = b();
                boolean b3 = huVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f563a.equals(huVar.f563a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = huVar.c();
                if ((c2 || c3) && !(c2 && c3 && this.f566b.equals(huVar.f566b))) {
                    return false;
                }
                boolean d2 = d();
                boolean d3 = huVar.d();
                if ((d2 || d3) && !(d2 && d3 && this.f567c.equals(huVar.f567c))) {
                    return false;
                }
                boolean e2 = e();
                boolean e3 = huVar.e();
                if ((e2 || e3) && !(e2 && e3 && this.f565a == huVar.f565a)) {
                    return false;
                }
                boolean f2 = f();
                boolean f3 = huVar.f();
                if (f2 || f3) {
                    return f2 && f3 && this.f568d.equals(huVar.f568d);
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
            jbVar.a(f561a);
            jbVar.a(a);
            jbVar.a(this.f562a);
            jbVar.b();
            if (this.f563a != null) {
                jbVar.a(f61284b);
                jbVar.a(this.f563a);
                jbVar.b();
            }
            if (this.f566b != null && c()) {
                jbVar.a(f61285c);
                jbVar.a(this.f566b);
                jbVar.b();
            }
            if (this.f567c != null && d()) {
                jbVar.a(f61286d);
                jbVar.a(this.f567c);
                jbVar.b();
            }
            if (e()) {
                jbVar.a(f61287e);
                jbVar.a(this.f565a);
                jbVar.b();
            }
            if (this.f568d != null && f()) {
                jbVar.a(f61288f);
                jbVar.a(this.f568d);
                jbVar.b();
            }
            jbVar.c();
            jbVar.m592a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f564a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f563a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f566b != null : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f567c != null : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f564a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
            if (obj != null && (obj instanceof hu)) {
                return m483a((hu) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f568d != null : invokeV.booleanValue;
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
            sb.append(this.f562a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("userId:");
            String str = this.f563a;
            if (str == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(str);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("server:");
                String str2 = this.f566b;
                if (str2 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str2);
                }
            }
            if (d()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("resource:");
                String str3 = this.f567c;
                if (str3 == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(str3);
                }
            }
            if (e()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("isPreview:");
                sb.append(this.f565a);
            }
            if (f()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("token:");
                String str4 = this.f568d;
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
