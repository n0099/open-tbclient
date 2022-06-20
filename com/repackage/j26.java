package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i26 a() {
        InterceptResult invokeV;
        i26 i26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j26.class) {
                if (a == null) {
                    a = new i26();
                }
                i26Var = a;
            }
            return i26Var;
        }
        return (i26) invokeV.objValue;
    }
}
