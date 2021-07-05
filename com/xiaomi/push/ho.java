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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes8.dex */
public class ho implements iq<ho, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f43284a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f503a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f43285b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f43286c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f504a;

    /* renamed from: a  reason: collision with other field name */
    public hl f505a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f506a;

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f507a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372711, "Lcom/xiaomi/push/ho;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372711, "Lcom/xiaomi/push/ho;");
                return;
            }
        }
        f503a = new jg("NormalConfig");
        f43284a = new iy("", (byte) 8, (short) 1);
        f43285b = new iy("", (byte) 15, (short) 2);
        f43286c = new iy("", (byte) 8, (short) 3);
    }

    public ho() {
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
        this.f506a = new BitSet(1);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f504a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ho hoVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hoVar)) == null) {
            if (ho.class.equals(hoVar.getClass())) {
                int compareTo = Boolean.valueOf(m390a()).compareTo(Boolean.valueOf(hoVar.m390a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m390a() || (a4 = ir.a(this.f504a, hoVar.f504a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = ir.a(this.f507a, hoVar.f507a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = ir.a(this.f505a, hoVar.f505a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return ho.class.getName().compareTo(hoVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hl m388a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f505a : (hl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m389a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f507a == null) {
            throw new jc("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jbVar) == null) {
            jbVar.m524a();
            while (true) {
                iy m520a = jbVar.m520a();
                byte b2 = m520a.f43494a;
                if (b2 == 0) {
                    break;
                }
                short s = m520a.f810a;
                if (s == 1) {
                    if (b2 == 8) {
                        this.f504a = jbVar.m518a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 8) {
                        this.f505a = hl.a(jbVar.m518a());
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 15) {
                        iz m521a = jbVar.m521a();
                        this.f507a = new ArrayList(m521a.f811a);
                        for (int i2 = 0; i2 < m521a.f811a; i2++) {
                            hq hqVar = new hq();
                            hqVar.a(jbVar);
                            this.f507a.add(hqVar);
                        }
                        jbVar.i();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m390a()) {
                m389a();
                return;
            }
            throw new jc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f506a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m390a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f506a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m391a(ho hoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hoVar)) == null) {
            if (hoVar != null && this.f504a == hoVar.f504a) {
                boolean b2 = b();
                boolean b3 = hoVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f507a.equals(hoVar.f507a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hoVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f505a.equals(hoVar.f505a);
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            m389a();
            jbVar.a(f503a);
            jbVar.a(f43284a);
            jbVar.a(this.f504a);
            jbVar.b();
            if (this.f507a != null) {
                jbVar.a(f43285b);
                jbVar.a(new iz(StandardMessageCodec.LIST, this.f507a.size()));
                for (hq hqVar : this.f507a) {
                    hqVar.b(jbVar);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f505a != null && c()) {
                jbVar.a(f43286c);
                jbVar.a(this.f505a.a());
                jbVar.b();
            }
            jbVar.c();
            jbVar.m528a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f507a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f505a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ho)) {
                return m391a((ho) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder("NormalConfig(");
            sb.append("version:");
            sb.append(this.f504a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("configItems:");
            List<hq> list = this.f507a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                hl hlVar = this.f505a;
                if (hlVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hlVar);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
