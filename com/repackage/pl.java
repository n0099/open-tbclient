package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class pl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ol a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ol a() {
        InterceptResult invokeV;
        ol olVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pl.class) {
                if (a == null) {
                    a = new ol();
                }
                olVar = a;
            }
            return olVar;
        }
        return (ol) invokeV.objValue;
    }
}
