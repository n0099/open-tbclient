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
public class ic implements iu<ic, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1318a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f1319a;

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
        f1318a = new jk("XmPushActionCollectData");
        a = new jc("", (byte) 15, (short) 1);
    }

    public ic() {
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
    public int compareTo(ic icVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, icVar)) == null) {
            if (ic.class.equals(icVar.getClass())) {
                int compareTo = Boolean.valueOf(m1391a()).compareTo(Boolean.valueOf(icVar.m1391a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1391a() || (a2 = iv.a(this.f1319a, icVar.f1319a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return ic.class.getName().compareTo(icVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ic a(List<hr> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            this.f1319a = list;
            return this;
        }
        return (ic) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f1319a == null) {
            throw new jg("Required field 'dataCollectionItems' was not present! Struct: " + toString());
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
                a();
                return;
            }
            if (m1483a.f1529a == 1 && b == 15) {
                jd m1484a = jfVar.m1484a();
                this.f1319a = new ArrayList(m1484a.f1530a);
                for (int i = 0; i < m1484a.f1530a; i++) {
                    hr hrVar = new hr();
                    hrVar.a(jfVar);
                    this.f1319a.add(hrVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1391a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1319a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1392a(ic icVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, icVar)) == null) {
            if (icVar == null) {
                return false;
            }
            boolean m1391a = m1391a();
            boolean m1391a2 = icVar.m1391a();
            if (m1391a || m1391a2) {
                return m1391a && m1391a2 && this.f1319a.equals(icVar.f1319a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jfVar) == null) {
            a();
            jfVar.a(f1318a);
            if (this.f1319a != null) {
                jfVar.a(a);
                jfVar.a(new jd((byte) 12, this.f1319a.size()));
                for (hr hrVar : this.f1319a) {
                    hrVar.b(jfVar);
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
            if (obj != null && (obj instanceof ic)) {
                return m1392a((ic) obj);
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
            StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
            sb.append("dataCollectionItems:");
            List<hr> list = this.f1319a;
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
