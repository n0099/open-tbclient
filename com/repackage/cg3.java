package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cg3 {
    public static /* synthetic */ Interceptable $ic;
    public static eg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static eg3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new eg3("0");
            }
            return a;
        }
        return (eg3) invokeV.objValue;
    }

    public static void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            eg3 eg3Var = a;
            if (eg3Var == null) {
                a = new eg3(str);
            } else {
                eg3Var.n(str);
            }
        }
    }
}
