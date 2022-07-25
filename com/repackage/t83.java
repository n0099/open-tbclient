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
public class t83 extends s83 {
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

    @Override // com.repackage.s83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle c(r83 r83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r83Var)) == null) {
            Bundle bundle = new Bundle();
            q83 b = w83.b(r83Var.a);
            if (b == null) {
                if (s83.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = r83Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(r83Var.c, Integer.parseInt(r83Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(r83Var.c, Long.parseLong(r83Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(r83Var.c, Boolean.parseBoolean(r83Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(r83Var.c, r83Var.d));
            } else if (i != 5) {
                if (s83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(r83Var.c, Float.parseFloat(r83Var.d)));
            }
            if (s83.a) {
                Log.d("SwanAppSpDelegation", "Get: " + r83Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
