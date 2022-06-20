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
public class fq9 implements tk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ em9 a;

    public fq9(em9 em9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {em9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = em9Var;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.k = true;
            fm9 fm9Var = this.a.e;
            if (fm9Var != null) {
                fm9Var.onClicked();
            }
        }
    }

    @Override // com.repackage.tk9
    public void onDisplayed() {
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fm9Var = this.a.e) == null) {
            return;
        }
        fm9Var.onDisplayed();
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
            if (pBError == PBError.PID_INVALID) {
                fm9 fm9Var = this.a.e;
                if (fm9Var != null) {
                    fm9Var.onFail(PBError.NO_FILL);
                    return;
                }
                return;
            }
            em9 em9Var = this.a;
            fm9 fm9Var2 = em9Var.e;
            if (fm9Var2 == null || em9Var.j) {
                return;
            }
            fm9Var2.onFail(PBError.NO_FILL);
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.b.d()) {
            em9 em9Var = this.a;
            Context context = em9Var.a;
            vk9 vk9Var = em9Var.b.a;
            in9.s(context, (vk9Var == null || !vk9Var.f()) ? 0L : vk9Var.c.getLo_timeout());
            String str = "";
            if (this.a.b.c().equals("image")) {
                vk9 vk9Var2 = this.a.b.a;
                if (vk9Var2 != null && vk9Var2.f()) {
                    str = vk9Var2.c.getLoad();
                }
                this.a.f(str);
            } else if (this.a.b.c().equals(NativeConstants.TYPE_GIF)) {
                vk9 vk9Var3 = this.a.b.a;
                if (vk9Var3 != null && vk9Var3.f()) {
                    str = vk9Var3.c.getLoad();
                }
                this.a.c(str);
            } else {
                fm9 fm9Var = this.a.e;
                if (fm9Var != null) {
                    fm9Var.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
