package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vh3 a() {
        InterceptResult invokeV;
        vh3 vh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wh3.class) {
                if (a == null) {
                    a = new vh3();
                }
                vh3Var = a;
            }
            return vh3Var;
        }
        return (vh3) invokeV.objValue;
    }
}
