package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mg3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lg3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lg3 a() {
        InterceptResult invokeV;
        lg3 lg3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mg3.class) {
                if (a == null) {
                    a = new lg3();
                }
                lg3Var = a;
            }
            return lg3Var;
        }
        return (lg3) invokeV.objValue;
    }
}
