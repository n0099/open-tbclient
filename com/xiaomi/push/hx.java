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
/* loaded from: classes10.dex */
public class hx implements iq<hx, Object>, Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final iy f77883a;

    /* renamed from: a  reason: collision with other field name */
    public static final jg f602a;

    /* renamed from: b  reason: collision with root package name */
    public static final iy f77884b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f603a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f604a;

    /* renamed from: b  reason: collision with other field name */
    public int f605b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56372432, "Lcom/xiaomi/push/hx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56372432, "Lcom/xiaomi/push/hx;");
                return;
            }
        }
        f602a = new jg("XmPushActionCheckClientInfo");
        f77883a = new iy("", (byte) 8, (short) 1);
        f77884b = new iy("", (byte) 8, (short) 2);
    }

    public hx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f604a = new BitSet(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hx hxVar) {
        InterceptResult invokeL;
        int a2;
        int a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hxVar)) == null) {
            if (hx.class.equals(hxVar.getClass())) {
                int compareTo = Boolean.valueOf(m430a()).compareTo(Boolean.valueOf(hxVar.m430a()));
                if (compareTo != 0) {
                    return compareTo;
                }
                if (!m430a() || (a3 = ir.a(this.f603a, hxVar.f603a)) == 0) {
                    int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hxVar.b()));
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                    if (!b() || (a2 = ir.a(this.f605b, hxVar.f605b)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return hx.class.getName().compareTo(hxVar.getClass().getName());
        }
        return invokeL.intValue;
    }

    public hx a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f603a = i2;
            a(true);
            return this;
        }
        return (hx) invokeI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.xiaomi.push.iq
    public void a(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jbVar) == null) {
            jbVar.m527a();
            while (true) {
                iy m523a = jbVar.m523a();
                byte b2 = m523a.f78036a;
                if (b2 == 0) {
                    break;
                }
                short s = m523a.f814a;
                if (s != 1) {
                    if (s == 2 && b2 == 8) {
                        this.f605b = jbVar.m521a();
                        b(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                } else {
                    if (b2 == 8) {
                        this.f603a = jbVar.m521a();
                        a(true);
                        jbVar.g();
                    }
                    je.a(jbVar, b2);
                    jbVar.g();
                }
            }
            jbVar.f();
            if (!m430a()) {
                throw new jc("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
            } else if (b()) {
                a();
            } else {
                throw new jc("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f604a.set(0, z);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m430a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f604a.get(0) : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m431a(hx hxVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hxVar)) == null) ? hxVar != null && this.f603a == hxVar.f603a && this.f605b == hxVar.f605b : invokeL.booleanValue;
    }

    public hx b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f605b = i2;
            b(true);
            return this;
        }
        return (hx) invokeI.objValue;
    }

    @Override // com.xiaomi.push.iq
    public void b(jb jbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jbVar) == null) {
            a();
            jbVar.a(f602a);
            jbVar.a(f77883a);
            jbVar.a(this.f603a);
            jbVar.b();
            jbVar.a(f77884b);
            jbVar.a(this.f605b);
            jbVar.b();
            jbVar.c();
            jbVar.m531a();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f604a.set(1, z);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f604a.get(1) : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            if (obj != null && (obj instanceof hx)) {
                return m431a((hx) obj);
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
            return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f603a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "pluginConfigVersion:" + this.f605b + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
