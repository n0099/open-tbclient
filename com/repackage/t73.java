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
public class t73 extends r73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t73() {
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

    @Override // com.repackage.r73
    @SuppressLint({"BDThrowableCheck"})
    public Bundle b(q73 q73Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q73Var)) == null) {
            p73 b = v73.b(q73Var.a);
            if (b == null) {
                if (!r73.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = q73Var.b;
            if (i == 1) {
                b.putInt(q73Var.c, Integer.parseInt(q73Var.d));
            } else if (i == 2) {
                b.putLong(q73Var.c, Long.parseLong(q73Var.d));
            } else if (i == 3) {
                b.putBoolean(q73Var.c, Boolean.parseBoolean(q73Var.d));
            } else if (i == 4) {
                b.putString(q73Var.c, q73Var.d);
            } else if (i != 5) {
                if (r73.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(q73Var.c, Float.parseFloat(q73Var.d));
            }
            if (r73.a) {
                Log.d("SwanAppSpDelegation", "Put: " + q73Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
