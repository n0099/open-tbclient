package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k82 implements s72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k82() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.s72
    @SuppressLint({"BDThrowableCheck"})
    public x72 a(w72 w72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w72Var)) == null) {
            int type = w72Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!rg1.a) {
                            return new n82();
                        }
                        throw new IllegalArgumentException("invalid model object:" + w72Var);
                    }
                    return new b22();
                }
                return pj2.b();
            }
            return new n82();
        }
        return (x72) invokeL.objValue;
    }
}
