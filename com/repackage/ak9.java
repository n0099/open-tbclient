package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes5.dex */
public class ak9 implements am9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zl9 a;

    public ak9(zl9 zl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zl9Var;
    }

    @Override // com.repackage.am9
    public void c(boolean z, long j) {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.c(z, j);
    }

    @Override // com.repackage.am9
    public void d(String str) {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.d(str);
    }

    @Override // com.repackage.am9
    public void f() {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.f();
    }

    @Override // com.repackage.am9
    public void g() {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        am9 am9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (am9Var = this.a.b) == null) {
            return;
        }
        am9Var.onLoaded();
    }
}
