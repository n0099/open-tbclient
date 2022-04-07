package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qj1 implements gm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qj1() {
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

    @Override // com.repackage.gm1
    public void a(Context context, cf3<Boolean> cf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, cf3Var) == null) || cf3Var == null) {
            return;
        }
        cf3Var.onCallback(null);
    }

    @Override // com.repackage.gm1
    public void b(boolean z, cf3<String> cf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cf3Var) == null) || cf3Var == null) {
            return;
        }
        cf3Var.onCallback(null);
    }

    @Override // com.repackage.gm1
    public void c(Context context, cf3<String> cf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, cf3Var) == null) || cf3Var == null) {
            return;
        }
        cf3Var.onCallback(null);
    }

    @Override // com.repackage.gm1
    public void d(cf3<Integer> cf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cf3Var) == null) || cf3Var == null) {
            return;
        }
        cf3Var.onCallback(null);
    }
}
