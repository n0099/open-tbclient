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
import java.util.List;
/* loaded from: classes2.dex */
public class id implements iq<id, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f71219a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f647a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<ho> f648a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372091, "Lcom/xiaomi/push/id;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372091, "Lcom/xiaomi/push/id;");
                return;
            }
        }
        f647a = new jg("XmPushActionNormalConfig");
        f71219a = new iy("", (byte) 15, (short) 1);
    }

    public id() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, idVar)) == null) {
            if (id.class.equals(idVar.getClass())) {
                int compareTo = Boolean.valueOf(m466a()).compareTo(Boolean.valueOf(idVar.m466a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m466a() || (a2 = ir.a(this.f648a, idVar.f648a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return id.class.getName().compareTo(idVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public List<ho> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f648a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m465a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f648a == null) {
            throw new jc("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f71328a;
            if (b2 == 0) {
                jbVar.f();
                m465a();
                return;
            }
            if (m523a.f815a == 1 && b2 == 15) {
                iz m524a = jbVar.m524a();
                this.f648a = new ArrayList(m524a.f816a);
                for (int i2 = 0; i2 < m524a.f816a; i2++) {
                    ho hoVar = new ho();
                    hoVar.a(jbVar);
                    this.f648a.add(hoVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m466a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f648a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m467a(id idVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, idVar)) == null) {
            if (idVar == null) {
                return false;
            }
            boolean m466a = m466a();
            boolean m466a2 = idVar.m466a();
            if (m466a || m466a2) {
                return m466a && m466a2 && this.f648a.equals(idVar.f648a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            m465a();
            jbVar.a(f647a);
            if (this.f648a != null) {
                jbVar.a(f71219a);
                jbVar.a(new iz(StandardMessageCodec.LIST, this.f648a.size()));
                for (ho hoVar : this.f648a) {
                    hoVar.b(jbVar);
                }
                jbVar.e();
                jbVar.b();
            }
            jbVar.c();
            jbVar.m531a();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj != null && (obj instanceof id)) {
                return m467a((id) obj);
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
            List<ho> list = this.f648a;
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
