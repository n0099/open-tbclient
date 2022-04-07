package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bg8 a() {
        InterceptResult invokeV;
        bg8 bg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cg8.class) {
                if (a == null) {
                    a = new bg8();
                }
                bg8Var = a;
            }
            return bg8Var;
        }
        return (bg8) invokeV.objValue;
    }
}
