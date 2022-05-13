package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class gn9 implements gp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ fp9 a;

    public gn9(fp9 fp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fp9Var;
    }

    @Override // com.repackage.gp9
    public void c(boolean z, long j) {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.c(z, j);
    }

    @Override // com.repackage.gp9
    public void d(String str) {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.d(str);
    }

    @Override // com.repackage.gp9
    public void f() {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.f();
    }

    @Override // com.repackage.gp9
    public void g() {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        gp9 gp9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (gp9Var = this.a.b) == null) {
            return;
        }
        gp9Var.onLoaded();
    }
}
