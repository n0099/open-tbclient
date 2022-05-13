package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class w24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v24 a() {
        InterceptResult invokeV;
        v24 v24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w24.class) {
                if (a == null) {
                    a = new v24();
                }
                v24Var = a;
            }
            return v24Var;
        }
        return (v24) invokeV.objValue;
    }
}
