package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes7.dex */
public class vq9 implements dr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ zq9 a;

    public vq9(zq9 zq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = zq9Var;
    }

    @Override // com.repackage.dr9
    public void a(boolean z) {
        dr9 dr9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (dr9Var = this.a.b) == null) {
            return;
        }
        dr9Var.a(z);
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        dr9 dr9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (dr9Var = this.a.b) == null) {
            return;
        }
        dr9Var.onClicked();
    }

    @Override // com.repackage.dr9
    public void onDisplayed() {
        dr9 dr9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dr9Var = this.a.b) == null) {
            return;
        }
        dr9Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        dr9 dr9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pBError) == null) || (dr9Var = this.a.b) == null) {
            return;
        }
        dr9Var.onFail(pBError);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        dr9 dr9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (dr9Var = this.a.b) == null) {
            return;
        }
        dr9Var.onLoaded();
    }
}
