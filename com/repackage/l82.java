package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l82 implements t72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l82() {
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

    @Override // com.repackage.t72
    @SuppressLint({"BDThrowableCheck"})
    public y72 a(x72 x72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x72Var)) == null) {
            int type = x72Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!sg1.a) {
                            return new o82();
                        }
                        throw new IllegalArgumentException("invalid model object:" + x72Var);
                    }
                    return new c22();
                }
                return qj2.b();
            }
            return new o82();
        }
        return (y72) invokeL.objValue;
    }
}
