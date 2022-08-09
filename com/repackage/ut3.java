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
import com.repackage.i02;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ut3 implements op3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ut3() {
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

    @Override // com.repackage.op3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            i02 V = mm2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    r03.f(appContext, R.string.obfuscated_res_0x7f0f01a4).G();
                    return;
                }
                return;
            }
            zq2 d = zq2.d(str, str);
            d.h(jSONObject.toString());
            i02.b i = V.i("adLanding");
            i.n(i02.g, i02.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.op3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? xt3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.op3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? xt3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.op3
    public boolean d(View view2, io3 io3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, io3Var)) == null) ? xt3.a(view2, new fr2(io3Var.c(), io3Var.d(), io3Var.e(), io3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.op3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = mm2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            mm2.U().W().g(true);
        }
    }

    @Override // com.repackage.op3
    public boolean f(View view2, io3 io3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, io3Var)) == null) {
            qi1 W = mm2.U().W();
            return W != null && W.a(view2, new fr2(io3Var.c(), io3Var.d(), io3Var.e(), io3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.op3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? xt3.d(view2) : invokeL.booleanValue;
    }
}
