package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class n22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static AtomicInteger b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755521469, "Lcom/repackage/n22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755521469, "Lcom/repackage/n22;");
                return;
            }
        }
        a = rg1.a;
        b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str != null && str.startsWith("master") : invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = "master";
            if (h42.h()) {
                int andIncrement = b.getAndIncrement();
                if (andIncrement >= 1) {
                    str = "master" + andIncrement;
                }
                if (a) {
                    Log.i("MasterIdGenerator", "next master id - " + str);
                }
                return str;
            }
            return "master";
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int andSet = b.getAndSet(0);
            if (a) {
                Log.i("MasterIdGenerator", "last master id - " + andSet);
            }
            return andSet;
        }
        return invokeV.intValue;
    }
}
