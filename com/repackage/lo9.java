package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class lo9 implements lq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ kq9 a;

    public lo9(kq9 kq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kq9Var;
    }

    @Override // com.repackage.lq9
    public void c(boolean z, long j) {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.c(z, j);
    }

    @Override // com.repackage.lq9
    public void d(String str) {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.d(str);
    }

    @Override // com.repackage.lq9
    public void f() {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.f();
    }

    @Override // com.repackage.lq9
    public void g() {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        lq9 lq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (lq9Var = this.a.b) == null) {
            return;
        }
        lq9Var.onLoaded();
    }
}
