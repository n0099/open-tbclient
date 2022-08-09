package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class cp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bp5 a() {
        InterceptResult invokeV;
        bp5 bp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cp5.class) {
                if (a == null) {
                    a = new bp5();
                }
                bp5Var = a;
            }
            return bp5Var;
        }
        return (bp5) invokeV.objValue;
    }
}
