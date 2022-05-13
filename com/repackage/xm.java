package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wm a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized wm a() {
        InterceptResult invokeV;
        wm wmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (xm.class) {
                if (a == null) {
                    a = new wm();
                }
                wmVar = a;
            }
            return wmVar;
        }
        return (wm) invokeV.objValue;
    }
}
