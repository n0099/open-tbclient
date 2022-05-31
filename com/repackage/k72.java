package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k72 implements s62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k72() {
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

    @Override // com.repackage.s62
    @SuppressLint({"BDThrowableCheck"})
    public x62 a(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w62Var)) == null) {
            int type = w62Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!rf1.a) {
                            return new n72();
                        }
                        throw new IllegalArgumentException("invalid model object:" + w62Var);
                    }
                    return new b12();
                }
                return pi2.b();
            }
            return new n72();
        }
        return (x62) invokeL.objValue;
    }
}
