package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sl3 a() {
        InterceptResult invokeV;
        sl3 sl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tl3.class) {
                if (a == null) {
                    a = new sl3();
                }
                sl3Var = a;
            }
            return sl3Var;
        }
        return (sl3) invokeV.objValue;
    }
}
