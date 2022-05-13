package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pg3 {
    public static /* synthetic */ Interceptable $ic;
    public static rg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static rg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new rg3("0");
            }
            return a;
        }
        return (rg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            rg3 rg3Var = a;
            if (rg3Var == null) {
                a = new rg3(str);
            } else {
                rg3Var.n(str);
            }
        }
    }
}
