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
public class u83 extends t83 {
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

    @Override // com.repackage.t83
    @SuppressLint({"BDThrowableCheck"})
    public Bundle b(s83 s83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, s83Var)) == null) {
            Bundle bundle = new Bundle();
            r83 b = x83.b(s83Var.a);
            if (b == null) {
                if (t83.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = s83Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(s83Var.c, Integer.parseInt(s83Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(s83Var.c, Long.parseLong(s83Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(s83Var.c, Boolean.parseBoolean(s83Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(s83Var.c, s83Var.d));
            } else if (i != 5) {
                if (t83.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(s83Var.c, Float.parseFloat(s83Var.d)));
            }
            if (t83.a) {
                Log.d("SwanAppSpDelegation", "Get: " + s83Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
