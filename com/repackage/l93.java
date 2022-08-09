package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l93 extends j93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l93() {
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

    @Override // com.repackage.j93
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(i93 i93Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i93Var)) == null) {
            h93 b = n93.b(i93Var.a);
            if (b == null) {
                if (!j93.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = i93Var.b;
            if (i == 1) {
                b.putInt(i93Var.c, Integer.parseInt(i93Var.d));
            } else if (i == 2) {
                b.putLong(i93Var.c, Long.parseLong(i93Var.d));
            } else if (i == 3) {
                b.putBoolean(i93Var.c, Boolean.parseBoolean(i93Var.d));
            } else if (i == 4) {
                b.putString(i93Var.c, i93Var.d);
            } else if (i != 5) {
                if (j93.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(i93Var.c, Float.parseFloat(i93Var.d));
            }
            if (j93.a) {
                Log.d("SwanAppSpDelegation", "Put: " + i93Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
