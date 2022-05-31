package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wl5 a() {
        InterceptResult invokeV;
        wl5 wl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xl5.class) {
                if (a == null) {
                    a = new wl5();
                }
                wl5Var = a;
            }
            return wl5Var;
        }
        return (wl5) invokeV.objValue;
    }
}
