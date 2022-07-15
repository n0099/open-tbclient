package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qt0 a() {
        InterceptResult invokeV;
        qt0 qt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rt0.class) {
                if (a == null) {
                    a = new qt0();
                }
                qt0Var = a;
            }
            return qt0Var;
        }
        return (qt0) invokeV.objValue;
    }
}
