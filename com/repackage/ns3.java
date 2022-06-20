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
import com.repackage.bz1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ns3 implements ho3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ns3() {
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

    @Override // com.repackage.ho3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            bz1 V = fl2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    kz2.f(appContext, R.string.obfuscated_res_0x7f0f019f).G();
                    return;
                }
                return;
            }
            sp2 d = sp2.d(str, str);
            d.h(jSONObject.toString());
            bz1.b i = V.i("adLanding");
            i.n(bz1.g, bz1.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.ho3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? qs3.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.ho3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? qs3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.repackage.ho3
    public boolean d(View view2, bn3 bn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, bn3Var)) == null) ? qs3.a(view2, new yp2(bn3Var.c(), bn3Var.d(), bn3Var.e(), bn3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.repackage.ho3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = fl2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            fl2.U().W().g(true);
        }
    }

    @Override // com.repackage.ho3
    public boolean f(View view2, bn3 bn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, bn3Var)) == null) {
            jh1 W = fl2.U().W();
            return W != null && W.a(view2, new yp2(bn3Var.c(), bn3Var.d(), bn3Var.e(), bn3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.ho3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? qs3.d(view2) : invokeL.booleanValue;
    }
}
