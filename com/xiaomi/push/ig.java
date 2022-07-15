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
    public static final jk f1354a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f1355a;

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
        f1354a = new jk("XmPushActionCustomConfig");
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
                int compareTo = Boolean.valueOf(m1413a()).compareTo(Boolean.valueOf(igVar.m1413a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1413a() || (a2 = iv.a(this.f1355a, igVar.f1355a)) == 0) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1355a : (List) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1412a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f1355a == null) {
            throw new jg("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b = m1483a.a;
            if (b == 0) {
                jfVar.f();
                m1412a();
                return;
            }
            if (m1483a.f1529a == 1 && b == 15) {
                jd m1484a = jfVar.m1484a();
                this.f1355a = new ArrayList(m1484a.f1530a);
                for (int i = 0; i < m1484a.f1530a; i++) {
                    hu huVar = new hu();
                    huVar.a(jfVar);
                    this.f1355a.add(huVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1413a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1355a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1414a(ig igVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, igVar)) == null) {
            if (igVar == null) {
                return false;
            }
            boolean m1413a = m1413a();
            boolean m1413a2 = igVar.m1413a();
            if (m1413a || m1413a2) {
                return m1413a && m1413a2 && this.f1355a.equals(igVar.f1355a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            m1412a();
            jfVar.a(f1354a);
            if (this.f1355a != null) {
                jfVar.a(a);
                jfVar.a(new jd((byte) 12, this.f1355a.size()));
                for (hu huVar : this.f1355a) {
                    huVar.b(jfVar);
                }
                jfVar.e();
                jfVar.b();
            }
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj != null && (obj instanceof ig)) {
                return m1414a((ig) obj);
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
            List<hu> list = this.f1355a;
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
