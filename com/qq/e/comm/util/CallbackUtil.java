package com.qq.e.comm.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CallbackUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Boolean> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462147861, "Lcom/qq/e/comm/util/CallbackUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-462147861, "Lcom/qq/e/comm/util/CallbackUtil;");
                return;
            }
        }
        a = new HashMap();
    }

    public CallbackUtil() {
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

    public static boolean a(Class cls, String str, Class... clsArr) {
        InterceptResult invokeLLL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            if (cls == null) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append("#");
                sb2.append(str);
                for (Class cls2 : clsArr) {
                    sb2.append("_");
                    sb2.append(cls2.getName());
                }
                sb = sb2.toString();
            }
            Boolean bool = a.get(sb);
            if (bool == null) {
                try {
                    cls.getDeclaredMethod(str, clsArr);
                    a.put(sb, Boolean.TRUE);
                    return true;
                } catch (NoSuchMethodException unused) {
                    a.put(sb, Boolean.FALSE);
                    return false;
                }
            }
            return Boolean.TRUE.equals(bool);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean hasRenderFailCallback(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj == null) {
                return false;
            }
            return a(obj.getClass(), "onRenderFail", new Class[0]);
        }
        return invokeL.booleanValue;
    }

    public static boolean hasRenderSuccessCallback(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj == null) {
                return false;
            }
            return a(obj.getClass(), "onRenderSuccess", new Class[0]);
        }
        return invokeL.booleanValue;
    }
}
