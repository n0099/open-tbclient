package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class wq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile vq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized vq3 a() {
        InterceptResult invokeV;
        vq3 vq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (wq3.class) {
                if (a == null) {
                    a = new vq3();
                }
                vq3Var = a;
            }
            return vq3Var;
        }
        return (vq3) invokeV.objValue;
    }
}
