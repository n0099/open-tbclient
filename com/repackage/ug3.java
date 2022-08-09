package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ug3 {
    public static /* synthetic */ Interceptable $ic;
    public static wg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static wg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new wg3("0");
            }
            return a;
        }
        return (wg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            wg3 wg3Var = a;
            if (wg3Var == null) {
                a = new wg3(str);
            } else {
                wg3Var.n(str);
            }
        }
    }
}
