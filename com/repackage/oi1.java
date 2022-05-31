package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class oi1 implements el1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oi1() {
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

    @Override // com.repackage.el1
    public void a(Context context, ae3<Boolean> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, ae3Var) == null) || ae3Var == null) {
            return;
        }
        ae3Var.onCallback(null);
    }

    @Override // com.repackage.el1
    public void b(boolean z, ae3<String> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, ae3Var) == null) || ae3Var == null) {
            return;
        }
        ae3Var.onCallback(null);
    }

    @Override // com.repackage.el1
    public void c(Context context, ae3<String> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, ae3Var) == null) || ae3Var == null) {
            return;
        }
        ae3Var.onCallback(null);
    }

    @Override // com.repackage.el1
    public void d(ae3<Integer> ae3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ae3Var) == null) || ae3Var == null) {
            return;
        }
        ae3Var.onCallback(null);
    }
}
