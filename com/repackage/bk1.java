package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk1 implements rm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bk1() {
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

    @Override // com.repackage.rm1
    public void a(Context context, nf3<Boolean> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, nf3Var) == null) || nf3Var == null) {
            return;
        }
        nf3Var.onCallback(null);
    }

    @Override // com.repackage.rm1
    public void b(boolean z, nf3<String> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, nf3Var) == null) || nf3Var == null) {
            return;
        }
        nf3Var.onCallback(null);
    }

    @Override // com.repackage.rm1
    public void c(Context context, nf3<String> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, nf3Var) == null) || nf3Var == null) {
            return;
        }
        nf3Var.onCallback(null);
    }

    @Override // com.repackage.rm1
    public void d(nf3<Integer> nf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, nf3Var) == null) || nf3Var == null) {
            return;
        }
        nf3Var.onCallback(null);
    }
}
