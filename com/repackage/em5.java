package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class em5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dm5 a() {
        InterceptResult invokeV;
        dm5 dm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (em5.class) {
                if (a == null) {
                    a = new dm5();
                }
                dm5Var = a;
            }
            return dm5Var;
        }
        return (dm5) invokeV.objValue;
    }
}
