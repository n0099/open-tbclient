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
public class hs implements iu<hs, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f492a;
    public static final jc b;
    public static final jc c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f493a;

    /* renamed from: a  reason: collision with other field name */
    public hp f494a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f495a;

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f496a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372587, "Lcom/xiaomi/push/hs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372587, "Lcom/xiaomi/push/hs;");
                return;
            }
        }
        f492a = new jk("NormalConfig");
        a = new jc("", (byte) 8, (short) 1);
        b = new jc("", (byte) 15, (short) 2);
        c = new jc("", (byte) 8, (short) 3);
    }

    public hs() {
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
        this.f495a = new BitSet(1);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f493a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        int a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hsVar)) == null) {
            if (hs.class.equals(hsVar.getClass())) {
                int compareTo = Boolean.valueOf(m409a()).compareTo(Boolean.valueOf(hsVar.m409a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m409a() || (a4 = iv.a(this.f493a, hsVar.f493a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hsVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a3 = iv.a(this.f496a, hsVar.f496a)) == 0) {
                        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hsVar.c()));
                        if (compareTo3 != 0) {
                            return compareTo3;
                        }
                        if (!c() || (a2 = iv.a(this.f494a, hsVar.f494a)) == 0) {
                            return 0;
                        }
                        return a2;
                    }
                    return a3;
                }
                return a4;
            }
            return hs.class.getName().compareTo(hsVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hp m407a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f494a : (hp) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m408a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f496a == null) {
            throw new jg("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jfVar) == null) {
            jfVar.m544a();
            while (true) {
                jc m540a = jfVar.m540a();
                byte b2 = m540a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m540a.f802a;
                if (s == 1) {
                    if (b2 == 8) {
                        this.f493a = jfVar.m538a();
                        a(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else if (s != 2) {
                    if (s == 3 && b2 == 8) {
                        this.f494a = hp.a(jfVar.m538a());
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else {
                    if (b2 == 15) {
                        jd m541a = jfVar.m541a();
                        this.f496a = new ArrayList(m541a.f803a);
                        for (int i = 0; i < m541a.f803a; i++) {
                            hu huVar = new hu();
                            huVar.a(jfVar);
                            this.f496a.add(huVar);
                        }
                        jfVar.i();
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                }
            }
            jfVar.f();
            if (m409a()) {
                m408a();
                return;
            }
            throw new jg("Required field 'version' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f495a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m409a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f495a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m410a(hs hsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hsVar)) == null) {
            if (hsVar != null && this.f493a == hsVar.f493a) {
                boolean b2 = b();
                boolean b3 = hsVar.b();
                if ((b2 || b3) && !(b2 && b3 && this.f496a.equals(hsVar.f496a))) {
                    return false;
                }
                boolean c2 = c();
                boolean c3 = hsVar.c();
                if (c2 || c3) {
                    return c2 && c3 && this.f494a.equals(hsVar.f494a);
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jfVar) == null) {
            m408a();
            jfVar.a(f492a);
            jfVar.a(a);
            jfVar.a(this.f493a);
            jfVar.b();
            if (this.f496a != null) {
                jfVar.a(b);
                jfVar.a(new jd((byte) 12, this.f496a.size()));
                for (hu huVar : this.f496a) {
                    huVar.b(jfVar);
                }
                jfVar.e();
                jfVar.b();
            }
            if (this.f494a != null && c()) {
                jfVar.a(c);
                jfVar.a(this.f494a.a());
                jfVar.b();
            }
            jfVar.c();
            jfVar.m548a();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f496a != null : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f494a != null : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof hs)) {
                return m410a((hs) obj);
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
            sb.append(this.f493a);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("configItems:");
            List<hu> list = this.f496a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            if (c()) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append("type:");
                hp hpVar = this.f494a;
                if (hpVar == null) {
                    sb.append(StringUtil.NULL_STRING);
                } else {
                    sb.append(hpVar);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
