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
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class hi implements iq<hi, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f71091a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f482a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public List<hj> f483a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372897, "Lcom/xiaomi/push/hi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372897, "Lcom/xiaomi/push/hi;");
                return;
            }
        }
        f482a = new jg("ClientUploadData");
        f71091a = new iy("", (byte) 15, (short) 1);
    }

    public hi() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<hj> list = this.f483a;
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
    public int compareTo(hi hiVar) {
        InterceptResult invokeL;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hiVar)) == null) {
            if (hi.class.equals(hiVar.getClass())) {
                int compareTo = Boolean.valueOf(m376a()).compareTo(Boolean.valueOf(hiVar.m376a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m376a() || (a2 = ir.a(this.f483a, hiVar.f483a)) == 0) {
                    return 0;
                }
                return a2;
            }
            return hi.class.getName().compareTo(hiVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m375a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f483a == null) {
            throw new jc("Required field 'uploadDataItems' was not present! Struct: " + toString());
        }
    }

    public void a(hj hjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hjVar) == null) {
            if (this.f483a == null) {
                this.f483a = new ArrayList();
            }
            this.f483a.add(hjVar);
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048580, this, jbVar) != null) {
            return;
        }
        jbVar.m527a();
        while (true) {
            iy m523a = jbVar.m523a();
            byte b2 = m523a.f71329a;
            if (b2 == 0) {
                jbVar.f();
                m375a();
                return;
            }
            if (m523a.f815a == 1 && b2 == 15) {
                iz m524a = jbVar.m524a();
                this.f483a = new ArrayList(m524a.f816a);
                for (int i2 = 0; i2 < m524a.f816a; i2++) {
                    hj hjVar = new hj();
                    hjVar.a(jbVar);
                    this.f483a.add(hjVar);
                }
                jbVar.i();
            } else {
                je.a(jbVar, b2);
            }
            jbVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m376a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f483a != null : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m377a(hi hiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hiVar)) == null) {
            if (hiVar == null) {
                return false;
            }
            boolean m376a = m376a();
            boolean m376a2 = hiVar.m376a();
            if (m376a || m376a2) {
                return m376a && m376a2 && this.f483a.equals(hiVar.f483a);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jbVar) == null) {
            m375a();
            jbVar.a(f482a);
            if (this.f483a != null) {
                jbVar.a(f71091a);
                jbVar.a(new iz(StandardMessageCodec.LIST, this.f483a.size()));
                for (hj hjVar : this.f483a) {
                    hjVar.b(jbVar);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj != null && (obj instanceof hi)) {
                return m377a((hi) obj);
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
            List<hj> list = this.f483a;
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
