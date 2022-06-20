package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class j36 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, String> a;
    public static Map<String, String> b;
    public static Map<String, String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755639548, "Lcom/repackage/j36;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755639548, "Lcom/repackage/j36;");
                return;
            }
        }
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        a.put("CAM_X0906", "CAM_X0906");
        b.put("CAM_X0906", "com.baidu.tbadk.core.elementsMaven.EMABTest");
        c.put("CAM_X0906", "testMethod");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (b.containsKey(str)) {
                try {
                    Method declaredMethod = Class.forName(b.get(str)).getDeclaredMethod(c.get(str), new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(null, new Object[0]);
                    return ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) ? a.get(str) : str;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
