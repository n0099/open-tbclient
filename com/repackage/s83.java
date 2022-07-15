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
/* loaded from: classes7.dex */
public class s83 extends r83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s83() {
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
            Bundle bundle = new Bundle();
            p83 b = v83.b(q83Var.a);
            if (b == null) {
                if (r83.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = q83Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(q83Var.c, Integer.parseInt(q83Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(q83Var.c, Long.parseLong(q83Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(q83Var.c, Boolean.parseBoolean(q83Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(q83Var.c, q83Var.d));
            } else if (i != 5) {
                if (r83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(q83Var.c, Float.parseFloat(q83Var.d)));
            }
            if (r83.a) {
                Log.d("SwanAppSpDelegation", "Get: " + q83Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
