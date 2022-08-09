package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vp5 a() {
        InterceptResult invokeV;
        vp5 vp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wp5.class) {
                if (a == null) {
                    a = new vp5();
                }
                vp5Var = a;
            }
            return vp5Var;
        }
        return (vp5) invokeV.objValue;
    }
}
