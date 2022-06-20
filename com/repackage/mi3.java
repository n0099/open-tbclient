package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mi3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile li3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized li3 a() {
        InterceptResult invokeV;
        li3 li3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mi3.class) {
                if (a == null) {
                    a = new li3();
                }
                li3Var = a;
            }
            return li3Var;
        }
        return (li3) invokeV.objValue;
    }
}
