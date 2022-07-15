package com.xiaomi.push;

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
public class hm implements iu<hm, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1193a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hn> f1194a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372773, "Lcom/xiaomi/push/hm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372773, "Lcom/xiaomi/push/hm;");
                return;
            }
        }
        f1193a = new jk("ClientUploadData");
        a = new jc("", (byte) 15, (short) 1);
    }

    public hm() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<hn> list = this.f1194a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hm hmVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hmVar)) == null) {
            if (hm.class.equals(hmVar.getClass())) {
                int compareTo = Boolean.valueOf(m1335a()).compareTo(Boolean.valueOf(hmVar.m1335a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1335a() || (a2 = iv.a(this.f1194a, hmVar.f1194a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return hm.class.getName().compareTo(hmVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1334a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f1194a == null) {
            throw new jg("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hnVar) == null) {
            if (this.f1194a == null) {
                this.f1194a = new ArrayList();
            }
            this.f1194a.add(hnVar);
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jfVar) != null) {
            return;
        }
        jfVar.m1487a();
        while (true) {
            jc m1483a = jfVar.m1483a();
            byte b = m1483a.a;
            if (b == 0) {
                jfVar.f();
                m1334a();
                return;
            }
            if (m1483a.f1529a == 1 && b == 15) {
                jd m1484a = jfVar.m1484a();
                this.f1194a = new ArrayList(m1484a.f1530a);
                for (int i = 0; i < m1484a.f1530a; i++) {
                    hn hnVar = new hn();
                    hnVar.a(jfVar);
                    this.f1194a.add(hnVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1335a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1194a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1336a(hm hmVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hmVar)) == null) {
            if (hmVar == null) {
                return false;
            }
            boolean m1335a = m1335a();
            boolean m1335a2 = hmVar.m1335a();
            if (m1335a || m1335a2) {
                return m1335a && m1335a2 && this.f1194a.equals(hmVar.f1194a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jfVar) == null) {
            m1334a();
            jfVar.a(f1193a);
            if (this.f1194a != null) {
                jfVar.a(a);
                jfVar.a(new jd((byte) 12, this.f1194a.size()));
                for (hn hnVar : this.f1194a) {
                    hnVar.b(jfVar);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj != null && (obj instanceof hm)) {
                return m1336a((hm) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder("ClientUploadData(");
            sb.append("uploadDataItems:");
            List<hn> list = this.f1194a;
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
