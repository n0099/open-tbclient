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
import java.util.BitSet;
/* loaded from: classes8.dex */
public class ib implements iu<ib, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final jc a;

    /* renamed from: a  reason: collision with other field name */
    public static final jk f1314a;
    public static final jc b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f1315a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f1316a;

    /* renamed from: b  reason: collision with other field name */
    public int f1317b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372153, "Lcom/xiaomi/push/ib;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372153, "Lcom/xiaomi/push/ib;");
                return;
            }
        }
        f1314a = new jk("XmPushActionCheckClientInfo");
        a = new jc("", (byte) 8, (short) 1);
        b = new jc("", (byte) 8, (short) 2);
    }

    public ib() {
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
        this.f1316a = new BitSet(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ibVar)) == null) {
            if (ib.class.equals(ibVar.getClass())) {
                int compareTo = Boolean.valueOf(m1389a()).compareTo(Boolean.valueOf(ibVar.m1389a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m1389a() || (a3 = iv.a(this.f1315a, ibVar.f1315a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a2 = iv.a(this.f1317b, ibVar.f1317b)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return ib.class.getName().compareTo(ibVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public ib a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.f1315a = i;
            a(true);
            return this;
        }
        return (ib) invokeI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jfVar) == null) {
            jfVar.m1487a();
            while (true) {
                jc m1483a = jfVar.m1483a();
                byte b2 = m1483a.a;
                if (b2 == 0) {
                    break;
                }
                short s = m1483a.f1529a;
                if (s != 1) {
                    if (s == 2 && b2 == 8) {
                        this.f1317b = jfVar.m1481a();
                        b(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                } else {
                    if (b2 == 8) {
                        this.f1315a = jfVar.m1481a();
                        a(true);
                        jfVar.g();
                    }
                    ji.a(jfVar, b2);
                    jfVar.g();
                }
            }
            jfVar.f();
            if (!m1389a()) {
                throw new jg("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
            } else if (b()) {
                a();
            } else {
                throw new jg("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f1316a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1389a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1316a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1390a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ibVar)) == null) ? ibVar != null && this.f1315a == ibVar.f1315a && this.f1317b == ibVar.f1317b : invokeL.booleanValue;
    }

    public ib b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.f1317b = i;
            b(true);
            return this;
        }
        return (ib) invokeI.objValue;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jfVar) == null) {
            a();
            jfVar.a(f1314a);
            jfVar.a(a);
            jfVar.a(this.f1315a);
            jfVar.b();
            jfVar.a(b);
            jfVar.a(this.f1317b);
            jfVar.b();
            jfVar.c();
            jfVar.m1491a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f1316a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1316a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof ib)) {
                return m1390a((ib) obj);
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
            return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f1315a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "pluginConfigVersion:" + this.f1317b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
