package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wi2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vi2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vi2 a() {
        InterceptResult invokeV;
        vi2 vi2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wi2.class) {
                if (a == null) {
                    a = new vi2();
                }
                vi2Var = a;
            }
            return vi2Var;
        }
        return (vi2) invokeV.objValue;
    }
}
