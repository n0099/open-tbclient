package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e83 extends c83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e83() {
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

    @Override // com.repackage.c83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(b83 b83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b83Var)) == null) {
            a83 b = g83.b(b83Var.a);
            if (b == null) {
                if (!c83.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = b83Var.b;
            if (i == 1) {
                b.putInt(b83Var.c, Integer.parseInt(b83Var.d));
            } else if (i == 2) {
                b.putLong(b83Var.c, Long.parseLong(b83Var.d));
            } else if (i == 3) {
                b.putBoolean(b83Var.c, Boolean.parseBoolean(b83Var.d));
            } else if (i == 4) {
                b.putString(b83Var.c, b83Var.d);
            } else if (i != 5) {
                if (c83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(b83Var.c, Float.parseFloat(b83Var.d));
            }
            if (c83.a) {
                Log.d("SwanAppSpDelegation", "Put: " + b83Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
