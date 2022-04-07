package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes5.dex */
public class cu9 implements qo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ bq9 a;

    public cu9(bq9 bq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bq9Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            cq9 cq9Var = this.a.e;
            if (cq9Var != null) {
                cq9Var.onClicked();
            }
        }
    }

    @Override // com.repackage.qo9
    public void onDisplayed() {
        cq9 cq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cq9Var = this.a.e) == null) {
            return;
        }
        cq9Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                cq9 cq9Var = this.a.e;
                if (cq9Var != null) {
                    cq9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            bq9 bq9Var = this.a;
            cq9 cq9Var2 = bq9Var.e;
            if (cq9Var2 == null || bq9Var.j) {
                return;
            }
            cq9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b.d()) {
            bq9 bq9Var = this.a;
            Context context = bq9Var.a;
            so9 so9Var = bq9Var.b.a;
            fr9.s(context, (so9Var == null || !so9Var.f()) ? 0L : so9Var.c.getLo_timeout());
            String str = "";
            if (this.a.b.c().equals("image")) {
                so9 so9Var2 = this.a.b.a;
                if (so9Var2 != null && so9Var2.f()) {
                    str = so9Var2.c.getLoad();
                }
                this.a.f(str);
            } else if (this.a.b.c().equals(NativeConstants.TYPE_GIF)) {
                so9 so9Var3 = this.a.b.a;
                if (so9Var3 != null && so9Var3.f()) {
                    str = so9Var3.c.getLoad();
                }
                this.a.c(str);
            } else {
                cq9 cq9Var = this.a.e;
                if (cq9Var != null) {
                    cq9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
