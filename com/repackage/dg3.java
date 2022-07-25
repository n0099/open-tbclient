package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dg3 {
    public static /* synthetic */ Interceptable $ic;
    public static fg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static fg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new fg3("0");
            }
            return a;
        }
        return (fg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            fg3 fg3Var = a;
            if (fg3Var == null) {
                a = new fg3(str);
            } else {
                fg3Var.n(str);
            }
        }
    }
}
