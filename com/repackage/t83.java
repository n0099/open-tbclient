package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t83 extends r83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t83() {
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

    @Override // com.repackage.r83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(q83 q83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q83Var)) == null) {
            p83 b = v83.b(q83Var.a);
            if (b == null) {
                if (!r83.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = q83Var.b;
            if (i == 1) {
                b.putInt(q83Var.c, Integer.parseInt(q83Var.d));
            } else if (i == 2) {
                b.putLong(q83Var.c, Long.parseLong(q83Var.d));
            } else if (i == 3) {
                b.putBoolean(q83Var.c, Boolean.parseBoolean(q83Var.d));
            } else if (i == 4) {
                b.putString(q83Var.c, q83Var.d);
            } else if (i != 5) {
                if (r83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(q83Var.c, Float.parseFloat(q83Var.d));
            }
            if (r83.a) {
                Log.d("SwanAppSpDelegation", "Put: " + q83Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
