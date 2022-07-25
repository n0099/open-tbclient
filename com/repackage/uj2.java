package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tj2 a() {
        InterceptResult invokeV;
        tj2 tj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uj2.class) {
                if (a == null) {
                    a = new tj2();
                }
                tj2Var = a;
            }
            return tj2Var;
        }
        return (tj2) invokeV.objValue;
    }
}
