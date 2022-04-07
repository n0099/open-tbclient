package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes5.dex */
public class eo9 implements eq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ dq9 a;

    public eo9(dq9 dq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dq9Var;
    }

    @Override // com.repackage.eq9
    public void c(boolean z, long j) {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.c(z, j);
    }

    @Override // com.repackage.eq9
    public void d(String str) {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.d(str);
    }

    @Override // com.repackage.eq9
    public void f() {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.f();
    }

    @Override // com.repackage.eq9
    public void g() {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        eq9 eq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (eq9Var = this.a.b) == null) {
            return;
        }
        eq9Var.onLoaded();
    }
}
