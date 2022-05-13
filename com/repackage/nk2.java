package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mk2 a() {
        InterceptResult invokeV;
        mk2 mk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nk2.class) {
                if (a == null) {
                    a = new mk2();
                }
                mk2Var = a;
            }
            return mk2Var;
        }
        return (mk2) invokeV.objValue;
    }
}
