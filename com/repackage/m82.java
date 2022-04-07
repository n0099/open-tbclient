package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m82 implements u72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m82() {
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

    @Override // com.repackage.u72
    @SuppressLint({"BDThrowableCheck"})
    public z72 a(y72 y72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y72Var)) == null) {
            int type = y72Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!tg1.a) {
                            return new p82();
                        }
                        throw new IllegalArgumentException("invalid model object:" + y72Var);
                    }
                    return new d22();
                }
                return rj2.b();
            }
            return new p82();
        }
        return (z72) invokeL.objValue;
    }
}
