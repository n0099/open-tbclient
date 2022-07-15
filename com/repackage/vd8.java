package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class vd8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ud8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ud8 a() {
        InterceptResult invokeV;
        ud8 ud8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vd8.class) {
                if (a == null) {
                    a = new ud8();
                }
                ud8Var = a;
            }
            return ud8Var;
        }
        return (ud8) invokeV.objValue;
    }
}
