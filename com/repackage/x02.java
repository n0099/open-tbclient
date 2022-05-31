package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class x02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static AtomicInteger b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225481, "Lcom/repackage/x02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225481, "Lcom/repackage/x02;");
                return;
            }
        }
        a = rf1.a;
        b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str != null && str.startsWith("localDebug") : invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int andIncrement = b.getAndIncrement();
            String str = "localDebug";
            if (andIncrement >= 1) {
                str = "localDebug" + andIncrement;
            }
            if (a) {
                Log.i("DaemonIdGenerator", "next daemon id - " + str);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
