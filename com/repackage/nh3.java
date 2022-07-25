package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nh3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mh3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mh3 a() {
        InterceptResult invokeV;
        mh3 mh3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nh3.class) {
                if (a == null) {
                    a = new mh3();
                }
                mh3Var = a;
            }
            return mh3Var;
        }
        return (mh3) invokeV.objValue;
    }
}
