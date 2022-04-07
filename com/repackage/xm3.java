package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wm3 a() {
        InterceptResult invokeV;
        wm3 wm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xm3.class) {
                if (a == null) {
                    a = new wm3();
                }
                wm3Var = a;
            }
            return wm3Var;
        }
        return (wm3) invokeV.objValue;
    }
}
