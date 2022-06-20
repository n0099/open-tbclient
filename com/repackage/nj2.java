package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nj2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mj2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mj2 a() {
        InterceptResult invokeV;
        mj2 mj2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nj2.class) {
                if (a == null) {
                    a = new mj2();
                }
                mj2Var = a;
            }
            return mj2Var;
        }
        return (mj2) invokeV.objValue;
    }
}
