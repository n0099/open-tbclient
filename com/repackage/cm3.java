package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bm3 a() {
        InterceptResult invokeV;
        bm3 bm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cm3.class) {
                if (a == null) {
                    a = new bm3();
                }
                bm3Var = a;
            }
            return bm3Var;
        }
        return (bm3) invokeV.objValue;
    }
}
