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
public class v83 extends t83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v83() {
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

    @Override // com.repackage.t83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle a(s83 s83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s83Var)) == null) {
            r83 b = x83.b(s83Var.a);
            if (b == null) {
                if (!t83.a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i = s83Var.b;
            if (i == 1) {
                b.putInt(s83Var.c, Integer.parseInt(s83Var.d));
            } else if (i == 2) {
                b.putLong(s83Var.c, Long.parseLong(s83Var.d));
            } else if (i == 3) {
                b.putBoolean(s83Var.c, Boolean.parseBoolean(s83Var.d));
            } else if (i == 4) {
                b.putString(s83Var.c, s83Var.d);
            } else if (i != 5) {
                if (t83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b.putFloat(s83Var.c, Float.parseFloat(s83Var.d));
            }
            if (t83.a) {
                Log.d("SwanAppSpDelegation", "Put: " + s83Var);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}
