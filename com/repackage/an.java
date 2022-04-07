package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zm a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zm a() {
        InterceptResult invokeV;
        zm zmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (an.class) {
                if (a == null) {
                    a = new zm();
                }
                zmVar = a;
            }
            return zmVar;
        }
        return (zm) invokeV.objValue;
    }
}
