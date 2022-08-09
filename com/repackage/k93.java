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
/* loaded from: classes6.dex */
public class k93 extends j93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k93() {
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
            Bundle bundle = new Bundle();
            h93 b = n93.b(i93Var.a);
            if (b == null) {
                if (j93.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = i93Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(i93Var.c, Integer.parseInt(i93Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(i93Var.c, Long.parseLong(i93Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(i93Var.c, Boolean.parseBoolean(i93Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(i93Var.c, i93Var.d));
            } else if (i != 5) {
                if (j93.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(i93Var.c, Float.parseFloat(i93Var.d)));
            }
            if (j93.a) {
                Log.d("SwanAppSpDelegation", "Get: " + i93Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
