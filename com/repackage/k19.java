package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k19 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j19 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j19 a() {
        InterceptResult invokeV;
        j19 j19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k19.class) {
                if (a == null) {
                    a = new j19();
                }
                j19Var = a;
            }
            return j19Var;
        }
        return (j19) invokeV.objValue;
    }
}
