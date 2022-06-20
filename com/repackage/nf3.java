package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nf3 {
    public static /* synthetic */ Interceptable $ic;
    public static pf3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static pf3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new pf3("0");
            }
            return a;
        }
        return (pf3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            pf3 pf3Var = a;
            if (pf3Var == null) {
                a = new pf3(str);
            } else {
                pf3Var.n(str);
            }
        }
    }
}
