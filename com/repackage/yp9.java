package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes7.dex */
public class yp9 implements mk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ xl9 a;

    public yp9(xl9 xl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xl9Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            yl9 yl9Var = this.a.e;
            if (yl9Var != null) {
                yl9Var.onClicked();
            }
        }
    }

    @Override // com.repackage.mk9
    public void onDisplayed() {
        yl9 yl9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (yl9Var = this.a.e) == null) {
            return;
        }
        yl9Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                yl9 yl9Var = this.a.e;
                if (yl9Var != null) {
                    yl9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            xl9 xl9Var = this.a;
            yl9 yl9Var2 = xl9Var.e;
            if (yl9Var2 == null || xl9Var.j) {
                return;
            }
            yl9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b.d()) {
            xl9 xl9Var = this.a;
            Context context = xl9Var.a;
            ok9 ok9Var = xl9Var.b.a;
            bn9.s(context, (ok9Var == null || !ok9Var.f()) ? 0L : ok9Var.c.getLo_timeout());
            String str = "";
            if (this.a.b.c().equals("image")) {
                ok9 ok9Var2 = this.a.b.a;
                if (ok9Var2 != null && ok9Var2.f()) {
                    str = ok9Var2.c.getLoad();
                }
                this.a.f(str);
            } else if (this.a.b.c().equals(NativeConstants.TYPE_GIF)) {
                ok9 ok9Var3 = this.a.b.a;
                if (ok9Var3 != null && ok9Var3.f()) {
                    str = ok9Var3.c.getLoad();
                }
                this.a.c(str);
            } else {
                yl9 yl9Var = this.a.e;
                if (yl9Var != null) {
                    yl9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
