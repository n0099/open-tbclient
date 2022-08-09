package com.repackage;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c92 implements k82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c92() {
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

    @Override // com.repackage.k82
    @SuppressLint({"BDThrowableCheck"})
    public p82 a(o82 o82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, o82Var)) == null) {
            int type = o82Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (!jh1.a) {
                            return new f92();
                        }
                        throw new IllegalArgumentException("invalid model object:" + o82Var);
                    }
                    return new t22();
                }
                return hk2.b();
            }
            return new f92();
        }
        return (p82) invokeL.objValue;
    }
}
