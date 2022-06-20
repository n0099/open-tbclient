package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class el3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dl3 a() {
        InterceptResult invokeV;
        dl3 dl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (el3.class) {
                if (a == null) {
                    a = new dl3();
                }
                dl3Var = a;
            }
            return dl3Var;
        }
        return (dl3) invokeV.objValue;
    }
}
