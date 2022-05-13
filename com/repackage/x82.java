package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x82 implements f82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x82() {
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

    @Override // com.repackage.f82
    @SuppressLint({"BDThrowableCheck"})
    public k82 a(j82 j82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, j82Var)) == null) {
            int type = j82Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!eh1.a) {
                            return new a92();
                        }
                        throw new IllegalArgumentException("invalid model object:" + j82Var);
                    }
                    return new o22();
                }
                return ck2.b();
            }
            return new a92();
        }
        return (k82) invokeL.objValue;
    }
}
