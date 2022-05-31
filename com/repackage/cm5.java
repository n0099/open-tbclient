package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cm5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bm5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bm5 a() {
        InterceptResult invokeV;
        bm5 bm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cm5.class) {
                if (a == null) {
                    a = new bm5();
                }
                bm5Var = a;
            }
            return bm5Var;
        }
        return (bm5) invokeV.objValue;
    }
}
