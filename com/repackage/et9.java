package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class et9 implements sn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ dp9 a;

    public et9(dp9 dp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dp9Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            ep9 ep9Var = this.a.e;
            if (ep9Var != null) {
                ep9Var.onClicked();
            }
        }
    }

    @Override // com.repackage.sn9
    public void onDisplayed() {
        ep9 ep9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ep9Var = this.a.e) == null) {
            return;
        }
        ep9Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                ep9 ep9Var = this.a.e;
                if (ep9Var != null) {
                    ep9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            dp9 dp9Var = this.a;
            ep9 ep9Var2 = dp9Var.e;
            if (ep9Var2 == null || dp9Var.j) {
                return;
            }
            ep9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b.d()) {
            dp9 dp9Var = this.a;
            Context context = dp9Var.a;
            un9 un9Var = dp9Var.b.a;
            hq9.s(context, (un9Var == null || !un9Var.f()) ? 0L : un9Var.c.getLo_timeout());
            String str = "";
            if (this.a.b.c().equals("image")) {
                un9 un9Var2 = this.a.b.a;
                if (un9Var2 != null && un9Var2.f()) {
                    str = un9Var2.c.getLoad();
                }
                this.a.f(str);
            } else if (this.a.b.c().equals(NativeConstants.TYPE_GIF)) {
                un9 un9Var3 = this.a.b.a;
                if (un9Var3 != null && un9Var3.f()) {
                    str = un9Var3.c.getLoad();
                }
                this.a.c(str);
            } else {
                ep9 ep9Var = this.a.e;
                if (ep9Var != null) {
                    ep9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
