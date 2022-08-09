package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lt0 a() {
        InterceptResult invokeV;
        lt0 lt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mt0.class) {
                if (a == null) {
                    a = new lt0();
                }
                lt0Var = a;
            }
            return lt0Var;
        }
        return (lt0) invokeV.objValue;
    }
}
