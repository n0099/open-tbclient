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
public class ho implements iq<ho, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f484a;
    public static final iy b;
    public static final iy c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f485a;

    /* renamed from: a  reason: collision with other field name */
    public hl f486a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f487a;

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f488a;

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
        f484a = new jg("NormalConfig");
        a = new iy("", (byte) 8, (short) 1);
        b = new iy("", (byte) 15, (short) 2);
        c = new iy("", (byte) 8, (short) 3);
    }

    public ho() {
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
        this.f487a = new BitSet(1);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f485a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m428a()).compareTo(Boolean.valueOf(hoVar.m428a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m428a() || (a4 = ir.a(this.f485a, hoVar.f485a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = ir.a(this.f488a, hoVar.f488a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = ir.a(this.f486a, hoVar.f486a)) == 0) {
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
    public hl m426a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f486a : (hl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m427a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f488a == null) {
            throw new jc("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jbVar) == null) {
            jbVar.m562a();
            while (true) {
                iy m558a = jbVar.m558a();
                byte b2 = m558a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m558a.f791a;
                if (s == 1) {
                    if (b2 == 8) {
                        this.f485a = jbVar.m556a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 8) {
                        this.f486a = hl.a(jbVar.m556a());
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 15) {
                        iz m559a = jbVar.m559a();
                        this.f488a = new ArrayList(m559a.f792a);
                        for (int i = 0; i < m559a.f792a; i++) {
                            hq hqVar = new hq();
                            hqVar.a(jbVar);
                            this.f488a.add(hqVar);
                        }
                        jbVar.i();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m428a()) {
                m427a();
                return;
            }
            throw new jc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f487a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m428a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f487a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m429a(ho hoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hoVar)) == null) {
            if (hoVar != null && this.f485a == hoVar.f485a) {
                boolean b2 = b();
                boolean b3 = hoVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f488a.equals(hoVar.f488a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hoVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f486a.equals(hoVar.f486a);
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
            m427a();
            jbVar.a(f484a);
            jbVar.a(a);
            jbVar.a(this.f485a);
            jbVar.b();
            if (this.f488a != null) {
                jbVar.a(b);
                jbVar.a(new iz((byte) 12, this.f488a.size()));
                for (hq hqVar : this.f488a) {
                    hqVar.b(jbVar);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f486a != null && c()) {
                jbVar.a(c);
                jbVar.a(this.f486a.a());
                jbVar.b();
            }
            jbVar.c();
            jbVar.m566a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f488a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f486a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ho)) {
                return m429a((ho) obj);
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
            sb.append(this.f485a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("configItems:");
            List<hq> list = this.f488a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                hl hlVar = this.f486a;
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
