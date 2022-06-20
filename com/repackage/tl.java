package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sl a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sl a() {
        InterceptResult invokeV;
        sl slVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tl.class) {
                if (a == null) {
                    a = new sl();
                }
                slVar = a;
            }
            return slVar;
        }
        return (sl) invokeV.objValue;
    }
}
