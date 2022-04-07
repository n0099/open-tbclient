package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uf8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tf8 a() {
        InterceptResult invokeV;
        tf8 tf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uf8.class) {
                if (a == null) {
                    a = new tf8();
                }
                tf8Var = a;
            }
            return tf8Var;
        }
        return (tf8) invokeV.objValue;
    }
}
