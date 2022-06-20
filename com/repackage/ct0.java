package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ct0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bt0 a() {
        InterceptResult invokeV;
        bt0 bt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ct0.class) {
                if (a == null) {
                    a = new bt0();
                }
                bt0Var = a;
            }
            return bt0Var;
        }
        return (bt0) invokeV.objValue;
    }
}
