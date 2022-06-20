package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yr2 a() {
        InterceptResult invokeV;
        yr2 yr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zr2.class) {
                if (a == null) {
                    a = new yr2();
                }
                yr2Var = a;
            }
            return yr2Var;
        }
        return (yr2) invokeV.objValue;
    }
}
