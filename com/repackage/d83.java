package com.repackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes5.dex */
public class d83 extends c83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d83() {
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
            Bundle bundle = new Bundle();
            a83 b = g83.b(b83Var.a);
            if (b == null) {
                if (c83.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = b83Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(b83Var.c, Integer.parseInt(b83Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(b83Var.c, Long.parseLong(b83Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(b83Var.c, Boolean.parseBoolean(b83Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(b83Var.c, b83Var.d));
            } else if (i != 5) {
                if (c83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(b83Var.c, Float.parseFloat(b83Var.d)));
            }
            if (c83.a) {
                Log.d("SwanAppSpDelegation", "Get: " + b83Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
