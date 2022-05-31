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
import com.repackage.qy1;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cs3 implements wn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public cs3() {
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

    @Override // com.repackage.wn3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            qy1 V = uk2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    zy2.f(appContext, R.string.obfuscated_res_0x7f0f019f).G();
                    return;
                }
                return;
            }
            hp2 d = hp2.d(str, str);
            d.h(jSONObject.toString());
            qy1.b i = V.i("adLanding");
            i.n(qy1.g, qy1.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.wn3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? fs3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.wn3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? fs3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.wn3
    public boolean d(View view2, qm3 qm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, qm3Var)) == null) ? fs3.a(view2, new np2(qm3Var.c(), qm3Var.d(), qm3Var.e(), qm3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.wn3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = uk2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            uk2.U().W().g(true);
        }
    }

    @Override // com.repackage.wn3
    public boolean f(View view2, qm3 qm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, qm3Var)) == null) {
            yg1 W = uk2.U().W();
            return W != null && W.a(view2, new np2(qm3Var.c(), qm3Var.d(), qm3Var.e(), qm3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.wn3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? fs3.d(view2) : invokeL.booleanValue;
    }
}
