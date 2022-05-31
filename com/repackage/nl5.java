package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nl5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ml5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ml5 a() {
        InterceptResult invokeV;
        ml5 ml5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nl5.class) {
                if (a == null) {
                    a = new ml5();
                }
                ml5Var = a;
            }
            return ml5Var;
        }
        return (ml5) invokeV.objValue;
    }
}
