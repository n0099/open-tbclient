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
import java.util.List;
/* loaded from: classes8.dex */
public class ih implements iu<ih, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f660a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f661a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371967, "Lcom/xiaomi/push/ih;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371967, "Lcom/xiaomi/push/ih;");
                return;
            }
        }
        f660a = new jk("XmPushActionNormalConfig");
        a = new jc("", (byte) 15, (short) 1);
    }

    public ih() {
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
    public int compareTo(ih ihVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ihVar)) == null) {
            if (ih.class.equals(ihVar.getClass())) {
                int compareTo = Boolean.valueOf(m488a()).compareTo(Boolean.valueOf(ihVar.m488a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m488a() || (a2 = iv.a(this.f661a, ihVar.f661a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return ih.class.getName().compareTo(ihVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public List<hs> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f661a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m487a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f661a == null) {
            throw new jg("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jfVar) != null) {
            return;
        }
        jfVar.m559a();
        while (true) {
            jc m555a = jfVar.m555a();
            byte b = m555a.a;
            if (b == 0) {
                jfVar.f();
                m487a();
                return;
            }
            if (m555a.f833a == 1 && b == 15) {
                jd m556a = jfVar.m556a();
                this.f661a = new ArrayList(m556a.f834a);
                for (int i = 0; i < m556a.f834a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jfVar);
                    this.f661a.add(hsVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m488a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f661a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m489a(ih ihVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ihVar)) == null) {
            if (ihVar == null) {
                return false;
            }
            boolean m488a = m488a();
            boolean m488a2 = ihVar.m488a();
            if (m488a || m488a2) {
                return m488a && m488a2 && this.f661a.equals(ihVar.f661a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            m487a();
            jfVar.a(f660a);
            if (this.f661a != null) {
                jfVar.a(a);
                jfVar.a(new jd((byte) 12, this.f661a.size()));
                for (hs hsVar : this.f661a) {
                    hsVar.b(jfVar);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m563a();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj != null && (obj instanceof ih)) {
                return m489a((ih) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
            sb.append("normalConfigs:");
            List<hs> list = this.f661a;
            if (list == null) {
                sb.append(StringUtil.NULL_STRING);
            } else {
                sb.append(list);
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
