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
public class u83 extends s83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u83() {
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

    @Override // com.repackage.s83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(r83 r83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r83Var)) == null) {
            q83 b = w83.b(r83Var.a);
            if (b == null) {
                if (!s83.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = r83Var.b;
            if (i == 1) {
                b.putInt(r83Var.c, Integer.parseInt(r83Var.d));
            } else if (i == 2) {
                b.putLong(r83Var.c, Long.parseLong(r83Var.d));
            } else if (i == 3) {
                b.putBoolean(r83Var.c, Boolean.parseBoolean(r83Var.d));
            } else if (i == 4) {
                b.putString(r83Var.c, r83Var.d);
            } else if (i != 5) {
                if (s83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(r83Var.c, Float.parseFloat(r83Var.d));
            }
            if (s83.a) {
                Log.d("SwanAppSpDelegation", "Put: " + r83Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
