package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class hk9 implements hm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ gm9 a;

    public hk9(gm9 gm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gm9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gm9Var;
    }

    @Override // com.repackage.hm9
    public void c(boolean z, long j) {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.c(z, j);
    }

    @Override // com.repackage.hm9
    public void d(String str) {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.d(str);
    }

    @Override // com.repackage.hm9
    public void f() {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.f();
    }

    @Override // com.repackage.hm9
    public void g() {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.g();
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.onClicked();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hm9Var = this.a.b) == null) {
            return;
        }
        hm9Var.onLoaded();
    }
}
