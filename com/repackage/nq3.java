package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mq3 a() {
        InterceptResult invokeV;
        mq3 mq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nq3.class) {
                if (a == null) {
                    a = new mq3();
                }
                mq3Var = a;
            }
            return mq3Var;
        }
        return (mq3) invokeV.objValue;
    }
}
