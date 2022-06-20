package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vl5 a() {
        InterceptResult invokeV;
        vl5 vl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wl5.class) {
                if (a == null) {
                    a = new vl5();
                }
                vl5Var = a;
            }
            return vl5Var;
        }
        return (vl5) invokeV.objValue;
    }
}
