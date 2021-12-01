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
/* loaded from: classes3.dex */
public class ho implements iq<ho, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final iy a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f508a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f63015b;

    /* renamed from: c  reason: collision with root package name */
    public static final iy f63016c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f509a;

    /* renamed from: a  reason: collision with other field name */
    public hl f510a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f511a;

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f512a;

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
        f508a = new jg("NormalConfig");
        a = new iy("", (byte) 8, (short) 1);
        f63015b = new iy("", (byte) 15, (short) 2);
        f63016c = new iy("", (byte) 8, (short) 3);
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
        this.f511a = new BitSet(1);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f509a : invokeV.intValue;
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
                int compareTo = Boolean.valueOf(m442a()).compareTo(Boolean.valueOf(hoVar.m442a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m442a() || (a4 = ir.a(this.f509a, hoVar.f509a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = ir.a(this.f512a, hoVar.f512a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = ir.a(this.f510a, hoVar.f510a)) == 0) {
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
    public hl m440a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f510a : (hl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m441a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f512a == null) {
            throw new jc("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jbVar) == null) {
            jbVar.m576a();
            while (true) {
                iy m572a = jbVar.m572a();
                byte b2 = m572a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m572a.f815a;
                if (s == 1) {
                    if (b2 == 8) {
                        this.f509a = jbVar.m570a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 8) {
                        this.f510a = hl.a(jbVar.m570a());
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 15) {
                        iz m573a = jbVar.m573a();
                        this.f512a = new ArrayList(m573a.f816a);
                        for (int i2 = 0; i2 < m573a.f816a; i2++) {
                            hq hqVar = new hq();
                            hqVar.a(jbVar);
                            this.f512a.add(hqVar);
                        }
                        jbVar.i();
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (m442a()) {
                m441a();
                return;
            }
            throw new jc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f511a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m442a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f511a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m443a(ho hoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hoVar)) == null) {
            if (hoVar != null && this.f509a == hoVar.f509a) {
                boolean b2 = b();
                boolean b3 = hoVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f512a.equals(hoVar.f512a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hoVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f510a.equals(hoVar.f510a);
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
            m441a();
            jbVar.a(f508a);
            jbVar.a(a);
            jbVar.a(this.f509a);
            jbVar.b();
            if (this.f512a != null) {
                jbVar.a(f63015b);
                jbVar.a(new iz(StandardMessageCodec.LIST, this.f512a.size()));
                for (hq hqVar : this.f512a) {
                    hqVar.b(jbVar);
                }
                jbVar.e();
                jbVar.b();
            }
            if (this.f510a != null && c()) {
                jbVar.a(f63016c);
                jbVar.a(this.f510a.a());
                jbVar.b();
            }
            jbVar.c();
            jbVar.m580a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f512a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f510a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ho)) {
                return m443a((ho) obj);
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
            sb.append(this.f509a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("configItems:");
            List<hq> list = this.f512a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                hl hlVar = this.f510a;
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
