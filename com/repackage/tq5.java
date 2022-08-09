package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class tq5 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755282087, "Lcom/repackage/tq5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755282087, "Lcom/repackage/tq5;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            if (a.containsKey(Integer.valueOf(i))) {
                a.put(Integer.valueOf(i), Integer.valueOf(a.get(Integer.valueOf(i)).intValue() + 1));
            } else {
                a.put(Integer.valueOf(i), 2);
            }
        }
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (a.containsKey(Integer.valueOf(i))) {
                return a.get(Integer.valueOf(i)).intValue();
            }
            a.put(Integer.valueOf(i), 1);
            return 1;
        }
        return invokeI.intValue;
    }
}
