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
/* loaded from: classes10.dex */
public class ic implements iq<ic, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f78275a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f644a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hq> f645a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372122, "Lcom/xiaomi/push/ic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372122, "Lcom/xiaomi/push/ic;");
                return;
            }
        }
        f644a = new jg("XmPushActionCustomConfig");
        f78275a = new iy("", (byte) 15, (short) 1);
    }

    public ic() {
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
    public int compareTo(ic icVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, icVar)) == null) {
            if (ic.class.equals(icVar.getClass())) {
                int compareTo = Boolean.valueOf(m463a()).compareTo(Boolean.valueOf(icVar.m463a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m463a() || (a2 = ir.a(this.f645a, icVar.f645a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return ic.class.getName().compareTo(icVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public List<hq> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f645a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m462a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f645a == null) {
            throw new jc("Required field 'customConfigs' was not present! Struct: " + toString());
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
            byte b2 = m523a.f78390a;
            if (b2 == 0) {
                jbVar.f();
                m462a();
                return;
            }
            if (m523a.f814a == 1 && b2 == 15) {
                iz m524a = jbVar.m524a();
                this.f645a = new ArrayList(m524a.f815a);
                for (int i2 = 0; i2 < m524a.f815a; i2++) {
                    hq hqVar = new hq();
                    hqVar.a(jbVar);
                    this.f645a.add(hqVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m463a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f645a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m464a(ic icVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, icVar)) == null) {
            if (icVar == null) {
                return false;
            }
            boolean m463a = m463a();
            boolean m463a2 = icVar.m463a();
            if (m463a || m463a2) {
                return m463a && m463a2 && this.f645a.equals(icVar.f645a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jbVar) == null) {
            m462a();
            jbVar.a(f644a);
            if (this.f645a != null) {
                jbVar.a(f78275a);
                jbVar.a(new iz(StandardMessageCodec.LIST, this.f645a.size()));
                for (hq hqVar : this.f645a) {
                    hqVar.b(jbVar);
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
            if (obj != null && (obj instanceof ic)) {
                return m464a((ic) obj);
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
            StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
            sb.append("customConfigs:");
            List<hq> list = this.f645a;
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
