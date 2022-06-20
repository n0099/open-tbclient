package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ul5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tl5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tl5 a() {
        InterceptResult invokeV;
        tl5 tl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ul5.class) {
                if (a == null) {
                    a = new tl5();
                }
                tl5Var = a;
            }
            return tl5Var;
        }
        return (tl5) invokeV.objValue;
    }
}
