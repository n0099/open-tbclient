package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ql3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pl3 a() {
        InterceptResult invokeV;
        pl3 pl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ql3.class) {
                if (a == null) {
                    a = new pl3();
                }
                pl3Var = a;
            }
            return pl3Var;
        }
        return (pl3) invokeV.objValue;
    }
}
