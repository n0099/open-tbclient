package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eg3 {
    public static /* synthetic */ Interceptable $ic;
    public static gg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static gg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new gg3("0");
            }
            return a;
        }
        return (gg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            gg3 gg3Var = a;
            if (gg3Var == null) {
                a = new gg3(str);
            } else {
                gg3Var.n(str);
            }
        }
    }
}
