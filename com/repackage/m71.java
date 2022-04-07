package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m71 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l71 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l71 a() {
        InterceptResult invokeV;
        l71 l71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m71.class) {
                if (a == null) {
                    a = new l71();
                }
                l71Var = a;
            }
            return l71Var;
        }
        return (l71) invokeV.objValue;
    }
}
