package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j24 a() {
        InterceptResult invokeV;
        j24 j24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k24.class) {
                if (a == null) {
                    a = new j24();
                }
                j24Var = a;
            }
            return j24Var;
        }
        return (j24) invokeV.objValue;
    }
}
