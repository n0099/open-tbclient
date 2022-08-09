package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class br3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ar3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ar3 a() {
        InterceptResult invokeV;
        ar3 ar3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (br3.class) {
                if (a == null) {
                    a = new ar3();
                }
                ar3Var = a;
            }
            return ar3Var;
        }
        return (ar3) invokeV.objValue;
    }
}
