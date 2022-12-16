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
public class ig implements iu<ig, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f658a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f659a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371998, "Lcom/xiaomi/push/ig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371998, "Lcom/xiaomi/push/ig;");
                return;
            }
        }
        f658a = new jk("XmPushActionCustomConfig");
        a = new jc("", (byte) 15, (short) 1);
    }

    public ig() {
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
    public int compareTo(ig igVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, igVar)) == null) {
            if (ig.class.equals(igVar.getClass())) {
                int compareTo = Boolean.valueOf(m485a()).compareTo(Boolean.valueOf(igVar.m485a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m485a() || (a2 = iv.a(this.f659a, igVar.f659a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return ig.class.getName().compareTo(igVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public List<hu> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f659a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m484a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f659a == null) {
            throw new jg("Required field 'customConfigs' was not present! Struct: " + toString());
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
                m484a();
                return;
            }
            if (m555a.f833a == 1 && b == 15) {
                jd m556a = jfVar.m556a();
                this.f659a = new ArrayList(m556a.f834a);
                for (int i = 0; i < m556a.f834a; i++) {
                    hu huVar = new hu();
                    huVar.a(jfVar);
                    this.f659a.add(huVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m485a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f659a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m486a(ig igVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, igVar)) == null) {
            if (igVar == null) {
                return false;
            }
            boolean m485a = m485a();
            boolean m485a2 = igVar.m485a();
            if (m485a || m485a2) {
                return m485a && m485a2 && this.f659a.equals(igVar.f659a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            m484a();
            jfVar.a(f658a);
            if (this.f659a != null) {
                jfVar.a(a);
                jfVar.a(new jd((byte) 12, this.f659a.size()));
                for (hu huVar : this.f659a) {
                    huVar.b(jfVar);
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
            if (obj != null && (obj instanceof ig)) {
                return m486a((ig) obj);
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
            List<hu> list = this.f659a;
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
