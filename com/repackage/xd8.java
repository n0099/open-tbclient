package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wd8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wd8 a() {
        InterceptResult invokeV;
        wd8 wd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xd8.class) {
                if (a == null) {
                    a = new wd8();
                }
                wd8Var = a;
            }
            return wd8Var;
        }
        return (wd8) invokeV.objValue;
    }
}
