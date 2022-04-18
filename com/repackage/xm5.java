package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wm5 a() {
        InterceptResult invokeV;
        wm5 wm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xm5.class) {
                if (a == null) {
                    a = new wm5();
                }
                wm5Var = a;
            }
            return wm5Var;
        }
        return (wm5) invokeV.objValue;
    }
}
