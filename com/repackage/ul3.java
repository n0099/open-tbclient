package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ul3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tl3 a() {
        InterceptResult invokeV;
        tl3 tl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ul3.class) {
                if (a == null) {
                    a = new tl3();
                }
                tl3Var = a;
            }
            return tl3Var;
        }
        return (tl3) invokeV.objValue;
    }
}
