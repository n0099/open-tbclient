package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bn5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile an5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized an5 a() {
        InterceptResult invokeV;
        an5 an5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bn5.class) {
                if (a == null) {
                    a = new an5();
                }
                an5Var = a;
            }
            return an5Var;
        }
        return (an5) invokeV.objValue;
    }
}
