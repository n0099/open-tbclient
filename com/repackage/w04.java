package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class w04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v04 a() {
        InterceptResult invokeV;
        v04 v04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w04.class) {
                if (a == null) {
                    a = new v04();
                }
                v04Var = a;
            }
            return v04Var;
        }
        return (v04) invokeV.objValue;
    }
}
