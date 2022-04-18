package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w26 a() {
        InterceptResult invokeV;
        w26 w26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x26.class) {
                if (a == null) {
                    a = new w26();
                }
                w26Var = a;
            }
            return w26Var;
        }
        return (w26) invokeV.objValue;
    }
}
