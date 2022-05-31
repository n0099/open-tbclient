package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755905869, "Lcom/repackage/a52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755905869, "Lcom/repackage/a52;");
                return;
            }
        }
        a = rf1.a;
    }

    @NonNull
    public static y42 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            y42 b = b(c());
            if (a) {
                Log.d("PrelinkStrategyFactory", "prelink strategy - " + b.getClass().getSimpleName());
            }
            return b;
        }
        return (y42) invokeV.objValue;
    }

    public static y42 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 0) {
                return new w42();
            }
            if (i > 0) {
                return new z42(i);
            }
            if (i == -1) {
                return new x42();
            }
            return new w42();
        }
        return (y42) invokeI.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            oi2.g0().getSwitch("swan_prelink_policy_when_prefetch", 0);
            if (a) {
                Log.d("PrelinkStrategyFactory", "swan_prelink_policy_when_prefetch = 0");
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
