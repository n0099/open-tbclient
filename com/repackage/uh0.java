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
public abstract class uh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uh0() {
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
    public boolean b(@NonNull Context context, @NonNull yh0 yh0Var, @Nullable Map<String, Object> map, @Nullable ci0 ci0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yh0Var, map, ci0Var)) == null) {
            fz0.b((String) vy0.b(yh0Var.d(), "charge_url"));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void c(ci0 ci0Var, @Nullable yh0 yh0Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ci0Var, yh0Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            hi0.b(ci0Var, yh0Var, i, z);
        }
    }

    public void d(ci0 ci0Var, @Nullable yh0 yh0Var, @Nullable String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{ci0Var, yh0Var, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            hi0.c(ci0Var, yh0Var, str, i, z);
        }
    }
}
