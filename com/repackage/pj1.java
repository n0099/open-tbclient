package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class pj1 implements fm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pj1() {
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

    @Override // com.repackage.fm1
    public void a(Context context, bf3<Boolean> bf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bf3Var) == null) || bf3Var == null) {
            return;
        }
        bf3Var.a(null);
    }

    @Override // com.repackage.fm1
    public void b(boolean z, bf3<String> bf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, bf3Var) == null) || bf3Var == null) {
            return;
        }
        bf3Var.a(null);
    }

    @Override // com.repackage.fm1
    public void c(Context context, bf3<String> bf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bf3Var) == null) || bf3Var == null) {
            return;
        }
        bf3Var.a(null);
    }

    @Override // com.repackage.fm1
    public void d(bf3<Integer> bf3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bf3Var) == null) || bf3Var == null) {
            return;
        }
        bf3Var.a(null);
    }
}
