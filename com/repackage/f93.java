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
public class f93 extends e93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f93() {
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

    @Override // com.repackage.e93
    @SuppressLint({"BDThrowableCheck"})
    public Bundle b(d93 d93Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d93Var)) == null) {
            Bundle bundle = new Bundle();
            c93 b = i93.b(d93Var.a);
            if (b == null) {
                if (e93.a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i = d93Var.b;
            if (i == 1) {
                bundle.putInt("result_value", b.getInt(d93Var.c, Integer.parseInt(d93Var.d)));
            } else if (i == 2) {
                bundle.putLong("result_value", b.getLong(d93Var.c, Long.parseLong(d93Var.d)));
            } else if (i == 3) {
                bundle.putBoolean("result_value", b.getBoolean(d93Var.c, Boolean.parseBoolean(d93Var.d)));
            } else if (i == 4) {
                bundle.putString("result_value", b.getString(d93Var.c, d93Var.d));
            } else if (i != 5) {
                if (e93.a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b.getFloat(d93Var.c, Float.parseFloat(d93Var.d)));
            }
            if (e93.a) {
                Log.d("SwanAppSpDelegation", "Get: " + d93Var);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}
