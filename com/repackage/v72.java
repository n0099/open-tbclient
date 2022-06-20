package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class v72 implements d72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v72() {
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

    @Override // com.repackage.d72
    @SuppressLint({"BDThrowableCheck"})
    public i72 a(h72 h72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, h72Var)) == null) {
            int type = h72Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!cg1.a) {
                            return new y72();
                        }
                        throw new IllegalArgumentException("invalid model object:" + h72Var);
                    }
                    return new m12();
                }
                return aj2.b();
            }
            return new y72();
        }
        return (i72) invokeL.objValue;
    }
}
