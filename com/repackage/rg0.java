package com.repackage;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class rg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rg0() {
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

    public abstract String a();

    @CallSuper
    public boolean b(@NonNull Context context, @NonNull vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vg0Var, map, zg0Var)) == null) {
            jy0.b((String) zx0.b(vg0Var.d(), "charge_url"));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void c(zg0 zg0Var, @Nullable vg0 vg0Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{zg0Var, vg0Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            eh0.b(zg0Var, vg0Var, i, z);
        }
    }

    public void d(zg0 zg0Var, @Nullable vg0 vg0Var, @Nullable String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{zg0Var, vg0Var, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            eh0.c(zg0Var, vg0Var, str, i, z);
        }
    }
}
