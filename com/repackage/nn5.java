package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mn5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mn5 a() {
        InterceptResult invokeV;
        mn5 mn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nn5.class) {
                if (a == null) {
                    a = new mn5();
                }
                mn5Var = a;
            }
            return mn5Var;
        }
        return (mn5) invokeV.objValue;
    }
}
