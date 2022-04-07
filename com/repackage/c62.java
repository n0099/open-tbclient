package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755845326, "Lcom/repackage/c62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755845326, "Lcom/repackage/c62;");
                return;
            }
        }
        a = tg1.a;
    }

    @NonNull
    public static a62 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            a62 b = b(c());
            if (a) {
                Log.d("PrelinkStrategyFactory", "prelink strategy - " + b.getClass().getSimpleName());
            }
            return b;
        }
        return (a62) invokeV.objValue;
    }

    public static a62 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 0) {
                return new y52();
            }
            if (i > 0) {
                return new b62(i);
            }
            if (i == -1) {
                return new z52();
            }
            return new y52();
        }
        return (a62) invokeI.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            qj2.g0().getSwitch("swan_prelink_policy_when_prefetch", 0);
            if (a) {
                Log.d("PrelinkStrategyFactory", "swan_prelink_policy_when_prefetch = 0");
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
