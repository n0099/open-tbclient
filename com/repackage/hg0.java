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
/* loaded from: classes6.dex */
public abstract class hg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hg0() {
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
    public boolean b(@NonNull Context context, @NonNull lg0 lg0Var, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lg0Var, map, pg0Var)) == null) {
            sx0.b((String) ix0.b(lg0Var.d(), "charge_url"));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void c(pg0 pg0Var, @Nullable lg0 lg0Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pg0Var, lg0Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ug0.b(pg0Var, lg0Var, i, z);
        }
    }

    public void d(pg0 pg0Var, @Nullable lg0 lg0Var, @Nullable String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{pg0Var, lg0Var, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            ug0.c(pg0Var, lg0Var, str, i, z);
        }
    }
}
