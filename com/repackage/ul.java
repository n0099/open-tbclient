package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ul {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tl a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tl a() {
        InterceptResult invokeV;
        tl tlVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ul.class) {
                if (a == null) {
                    a = new tl();
                }
                tlVar = a;
            }
            return tlVar;
        }
        return (tl) invokeV.objValue;
    }
}
