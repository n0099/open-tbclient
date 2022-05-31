package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cf3 {
    public static /* synthetic */ Interceptable $ic;
    public static ef3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ef3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new ef3("0");
            }
            return a;
        }
        return (ef3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ef3 ef3Var = a;
            if (ef3Var == null) {
                a = new ef3(str);
            } else {
                ef3Var.n(str);
            }
        }
    }
}
