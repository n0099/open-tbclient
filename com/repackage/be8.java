package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class be8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ae8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ae8 a() {
        InterceptResult invokeV;
        ae8 ae8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (be8.class) {
                if (a == null) {
                    a = new ae8();
                }
                ae8Var = a;
            }
            return ae8Var;
        }
        return (ae8) invokeV.objValue;
    }
}
