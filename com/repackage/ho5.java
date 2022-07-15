package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ho5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile go5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized go5 a() {
        InterceptResult invokeV;
        go5 go5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ho5.class) {
                if (a == null) {
                    a = new go5();
                }
                go5Var = a;
            }
            return go5Var;
        }
        return (go5) invokeV.objValue;
    }
}
