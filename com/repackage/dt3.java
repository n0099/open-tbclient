package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rz1;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dt3 implements xo3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dt3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.xo3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            rz1 V = vl2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    a03.f(appContext, R.string.obfuscated_res_0x7f0f01a1).G();
                    return;
                }
                return;
            }
            iq2 d = iq2.d(str, str);
            d.h(jSONObject.toString());
            rz1.b i = V.i("adLanding");
            i.n(rz1.g, rz1.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.xo3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? gt3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.xo3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? gt3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.xo3
    public boolean d(View view2, rn3 rn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, rn3Var)) == null) ? gt3.a(view2, new oq2(rn3Var.c(), rn3Var.d(), rn3Var.e(), rn3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.xo3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = vl2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            vl2.U().W().g(true);
        }
    }

    @Override // com.repackage.xo3
    public boolean f(View view2, rn3 rn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, rn3Var)) == null) {
            zh1 W = vl2.U().W();
            return W != null && W.a(view2, new oq2(rn3Var.c(), rn3Var.d(), rn3Var.e(), rn3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.xo3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? gt3.d(view2) : invokeL.booleanValue;
    }
}
